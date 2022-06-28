package mx.com.yh.huntinghome;

import androidx.appcompat.app.AppCompatActivity;

import mx.com.yh.huntinghome.logica.Registro;
import mx.com.yh.huntinghome.modelos.Constantes;
import mx.com.yh.huntinghome.modelos.Usuario;
import mx.com.yh.huntinghome.modelos.Validaciones;
import mx.com.yh.huntinghome.vistas.Home;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class LoginActivity extends AppCompatActivity {

    private JSONObject obj;
    private Validaciones objValidar;
    private Usuario usuarioUp;
    private Button btnRegist, btnLogin;
    private EditText etEmailUser, etpPassUser;
    private Constantes constantes;
    private String valorEstado, username, password;
    private int estadoError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        obj = new JSONObject();
        objValidar = new Validaciones();
        constantes = new Constantes();

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        btnRegist = (Button) findViewById(R.id.btnRegist);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        etEmailUser = (EditText) findViewById(R.id.etEmailUser);
        etpPassUser = (EditText) findViewById(R.id.etpPassUser);

        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (networkInfo.isAvailable() && networkInfo.isFailover() &&
                        networkInfo != null && networkInfo.isConnected()) {
                    Intent registro = new Intent(getApplicationContext(), Registro.class);
                    startActivity(registro);
                } else {
                    try {
                        networkInfo.wait(10000);
                        Toast.makeText(getApplicationContext(), "No tiene internet", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, LoginActivity.class));
                    }catch (Exception e){
                        Log.i("Error", "Error de coneccion");
                    }
                }
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (networkInfo.isFailover()== false && networkInfo.isAvailable() &&
                        networkInfo != null && networkInfo.isConnected()) {
                    password = etpPassUser.getText().toString();
                    //validate form
                    if (!objValidar.Vacio(etEmailUser) && !objValidar.Vacio(etpPassUser)) {
                        if (afterTextChanged()) {
                            try {
                                obj.put("correo", username);
                                obj.put("password", password);
                            } catch (JSONException e) {
                                Log.println(Log.ERROR, "error", e.toString());
                            }
                        }
                    }
                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST, constantes.getLoginUsuario(), obj,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        JSONObject jO = new JSONObject();
                                        jO = response;
                                        valorEstado = jO.getString("estado");

                                        JSONObject usuario = jO.getJSONObject("usuario");

                                        usuarioUp = new Usuario(usuario, getApplicationContext());

                                    } catch (JSONException e) {
                                        Log.println(Log.ERROR, "error", e.toString());
                                    }

                                    if (valorEstado.equals("1")) {
                                        //esta sección si funciona, el que no funciona es el Home
                                        startActivity(new Intent(LoginActivity.this, Home.class));
                                    }
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            estadoError = error.networkResponse.statusCode;
                            if (estadoError == 400) {
                                Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                            } else if (estadoError == 500) {
                                Toast.makeText(getApplicationContext(), "Servicio no disponible", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Usuario no registrado", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    queue.add(jsObjRequest);
                } else {
                    try {
                        networkInfo.wait(10000);
                        Toast.makeText(getApplicationContext(), "No tiene internet", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, LoginActivity.class));
                    }catch (Exception e){
                        Log.i("Error", "Error de coneccion");
                    }
                }
            }
        });
    }

    private boolean afterTextChanged() {

        if (etEmailUser.getText().toString().matches(constantes.getEmailPattern())) {
            username = etEmailUser.getText().toString();
            return true;
        } else {
            Toast.makeText(getApplicationContext(), "Correo Inválido", Toast.LENGTH_SHORT).show();
            etEmailUser.setError("Campo Requerido");
            etEmailUser.requestFocus();
            return false;
        }
    }
}