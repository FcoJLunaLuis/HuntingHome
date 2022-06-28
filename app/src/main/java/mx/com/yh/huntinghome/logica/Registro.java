package mx.com.yh.huntinghome.logica;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import mx.com.yh.huntinghome.LoginActivity;
import mx.com.yh.huntinghome.R;
import mx.com.yh.huntinghome.modelos.Constantes;
import mx.com.yh.huntinghome.modelos.Validaciones;
import mx.com.yh.huntinghome.vistas.DatePickerFragment;

public class Registro extends AppCompatActivity {

    private JSONObject datos;
    private Validaciones objValidar; //objeto de nuestro clase Validaciones
    private Constantes constantes;

    private RadioButton radioClienteUsuario;
    private RadioButton radioArrendadorUsuario;
    private RadioButton radioMascSexo;
    private RadioButton radioFemSexo;
    private Button btnRegister;
    private EditText etNombreUsuario, etApPatUsuario, etApMatUsuario, etTelefonoUsuario, etFecNacUsuario, etCorreoUsuario, etPassword;

    private String fNacimiento, nombre, apPaterno, apMaterno, telefono, FeNacimiento, email, password, sexo, tipo_usuario, error, valorEstado;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_usuario_activity);
        datos = new JSONObject();
        constantes = new Constantes();
        objValidar = new Validaciones();

        etNombreUsuario = (EditText) findViewById(R.id.etNombreUsuario);
        etApPatUsuario = (EditText) findViewById(R.id.etApPatUsuario);
        etApMatUsuario = (EditText) findViewById(R.id.etApMatUsuario);
        etTelefonoUsuario = (EditText) findViewById(R.id.etTelefonoUsuario);
        etFecNacUsuario = (EditText) findViewById(R.id.etFecNacUsuario);
        etCorreoUsuario = (EditText) findViewById(R.id.etCorreoUsuario);
        etPassword = (EditText) findViewById(R.id.etRPassUser);
        radioClienteUsuario = (RadioButton) findViewById(R.id.radioClienteUsuario);
        radioArrendadorUsuario = (RadioButton) findViewById(R.id.radioArrendadorUsuario);
        radioMascSexo = (RadioButton) findViewById(R.id.radioMascSexo);
        radioFemSexo = (RadioButton) findViewById(R.id.radioFemSexo);
        btnRegister = (Button) findViewById(R.id.btnEnviarUsuario);

        etFecNacUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.etFecNacUsuario:
                        showDatePickerDialog();
                        break;
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                nombre = etNombreUsuario.getText().toString();
                apPaterno = etApPatUsuario.getText().toString();
                apMaterno = etApMatUsuario.getText().toString();
                telefono = etTelefonoUsuario.getText().toString();
                password = etPassword.getText().toString();
                if (radioFemSexo.isChecked()) {
                    sexo = "M";
                } else if (radioMascSexo.isChecked()) {
                    sexo = "H";
                }

                if (radioClienteUsuario.isChecked()) {
                    tipo_usuario = "cliente";
                } else if (radioArrendadorUsuario.isChecked()) {
                    tipo_usuario = "arrendador";
                }


                if (!objValidar.Vacio(etNombreUsuario) && !objValidar.Vacio(etApPatUsuario) && !objValidar.Vacio(etTelefonoUsuario)
                        && !objValidar.Vacio(etFecNacUsuario) && !objValidar.Vacio(etCorreoUsuario) && !objValidar.Vacio(etPassword)) {
                    if (afterTextChanged()) {

                        try {
                            datos.put("nombre", nombre);
                            datos.put("ap_paterno", apPaterno);
                            datos.put("ap_materno", apMaterno);
                            datos.put("telefono", telefono);
                            datos.put("tipo_usuario", tipo_usuario);
                            datos.put("sexo", sexo);
                            datos.put("fecha_nac", fNacimiento);
                            datos.put("correo", email);
                            datos.put("password", password);
                        } catch (JSONException e) {
                            Log.println(Log.ERROR, "error", e.toString());
                        }
                    }
                }
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST, constantes.getRegistroUsuario(), datos,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {

                                    JSONObject jO = new JSONObject();
                                    jO = response;
                                    valorEstado = jO.getString("estado");
                                } catch (JSONException e) {
                                    Log.println(Log.ERROR, "error", e.toString());
                                }

                                if (valorEstado.equals("1")) {
                                    startActivity(new Intent(Registro.this, LoginActivity.class));
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "Usuario no registrado", Toast.LENGTH_SHORT);
                            }
                        });
                queue.add(jsObjRequest);
            }
        });
    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String selectedDate = twoDigits(day) + "/" + twoDigits(month + 1) + "/" + year;
                fNacimiento = year + "-" + twoDigits(month + 1) + "-" + twoDigits(day);
                etFecNacUsuario.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    private String twoDigits(int n) {
        return (n <= 9) ? ("0" + n) : String.valueOf(n);
    }

    private boolean afterTextChanged() {

        if (etCorreoUsuario.getText().toString().matches(constantes.getEmailPattern())) {
            email = etCorreoUsuario.getText().toString();
            return true;
        } else {
            Toast.makeText(getApplicationContext(), "Correo Inválido", Toast.LENGTH_SHORT).show();
            etCorreoUsuario.setError("Campo Requerido");
            etCorreoUsuario.requestFocus();
            return false;
        }
    }
}