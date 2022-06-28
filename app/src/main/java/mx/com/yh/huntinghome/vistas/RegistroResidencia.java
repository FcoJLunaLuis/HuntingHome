package mx.com.yh.huntinghome.vistas;

import androidx.appcompat.app.AppCompatActivity;

import mx.com.yh.huntinghome.LoginActivity;
import mx.com.yh.huntinghome.R;
import mx.com.yh.huntinghome.modelos.Constantes;
import mx.com.yh.huntinghome.modelos.Validaciones;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegistroResidencia extends AppCompatActivity {

    private JSONObject datosResidencia;
    private Validaciones objValidar; //objeto de nuestro clase Validaciones
    private Constantes constantes;

    SharedPreferences myPreferences;

    private RadioButton radioResidencia;
    private RadioButton radioHabitacion;
    private CheckBox cbServAgua, cbServElec, cbServGas, cbServDrenaje, cbServInternet, cbServCable, cbServTel, cbMasc, cbCuota;
    private Button btnGuardar;
    private EditText etNumHabitaciones, etCalle, etNumeroInt, etNumeroExt
            , etColonia, etMunicipio, etEstado,etDetallesResidencia,precio;

    private String numHabitaciones, calle, numeroInt, numeroExt, colonia, municipio, estado, tipo_lugar, error, valorEstado,
            agua, electricidad, gas, drenaje, internet, cable, telefono, mascotas, cuota, userSesion, claveApi,detalles;

    private int costo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_residencia);

        myPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        datosResidencia = new JSONObject();
        constantes = new Constantes();
        objValidar = new Validaciones();

        etNumHabitaciones = (EditText) findViewById(R.id.etNumHabit);
        etCalle = (EditText) findViewById(R.id.etCalleRes);
        etNumeroInt = (EditText) findViewById(R.id.etNumIntRes);
        etNumeroExt = (EditText) findViewById(R.id.etNumExtRes);
        etColonia = (EditText) findViewById(R.id.etColRes);
        etMunicipio = (EditText) findViewById(R.id.etMunRes);
        etEstado = (EditText) findViewById(R.id.etEstRes);
        etDetallesResidencia = (EditText) findViewById(R.id.etDetallesResidencia);
        radioResidencia = (RadioButton) findViewById(R.id.rbRes);
        radioHabitacion = (RadioButton) findViewById(R.id.rbHabit);
        btnGuardar = (Button) findViewById(R.id.btnGuardarRes);
        cbServAgua = (CheckBox) findViewById(R.id.cbServAgua);
        cbServElec = (CheckBox) findViewById(R.id.cbServElec);
        cbServGas = (CheckBox) findViewById(R.id.cbServGas);
        cbServDrenaje = (CheckBox) findViewById(R.id.cbServDrenaje);
        cbServInternet = (CheckBox) findViewById(R.id.cbServInternet);
        cbServCable = (CheckBox) findViewById(R.id.cbServCable);
        cbServTel = (CheckBox) findViewById(R.id.cbServTel);
        cbMasc = (CheckBox) findViewById(R.id.cbMasc);
        cbCuota = (CheckBox) findViewById(R.id.cbCuot);
        precio = (EditText) findViewById(R.id.etPrecio);

        numHabitaciones = etNumHabitaciones.getText().toString();
        calle = etCalle.getText().toString();
        numeroInt = etNumeroInt.getText().toString();
        numeroExt = etNumeroExt.getText().toString();
        colonia = etColonia.getText().toString();
        municipio = etMunicipio.getText().toString();
        estado = etEstado.getText().toString();
        detalles = etDetallesResidencia.getText().toString();
        costo = Integer.parseInt(precio.getText().toString());


        btnGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                if (radioResidencia.isChecked()) {
                    tipo_lugar = "Residencia";
                }else if (radioHabitacion.isChecked()) {
                    tipo_lugar = "Habitaciòn";
                }

                if(cbCuota.isChecked()){
                    cuota="1";
                }else{
                    cuota="0";
                }
                if(cbMasc.isChecked()){
                    mascotas="1";
                }else{
                    mascotas="0";
                }

                if(cbServAgua.isChecked()){
                    agua="1";
                }else{
                    agua="0";
                }

                if(cbServElec.isChecked()){
                    electricidad="1";
                }else{
                    electricidad="0";
                }
                if(cbServGas.isChecked()){
                    gas="1";
                }else{
                    gas="0";
                }
                if(cbServInternet.isChecked()){
                    internet="1";
                }else{
                    internet="0";
                }
                if(cbServCable.isChecked()){
                    cable="1";
                }else{
                    cable="0";
                }
                if(cbServDrenaje.isChecked()){
                    drenaje="1";
                }else{
                    drenaje="0";
                }
                if(cbServTel.isChecked()){
                    telefono="1";
                }else{
                    telefono="0";
                }

                claveApi = myPreferences.getString("claveApi","unknown");
                if (!objValidar.Vacio(etNumHabitaciones) && !objValidar.Vacio(etCalle) && !objValidar.Vacio(etNumeroExt)
                        && !objValidar.Vacio(etColonia) && !objValidar.Vacio(etMunicipio) && !objValidar.Vacio(etEstado)) {

                    try {
                        datosResidencia.put("id_usuario", tipo_lugar);
                        datosResidencia.put("calle", calle);
                        datosResidencia.put("num_int", numeroInt);
                        datosResidencia.put("num_ext", numeroExt);
                        datosResidencia.put("colonia", colonia);
                        datosResidencia.put("municipio", municipio);
                        datosResidencia.put("estado", estado);
                        datosResidencia.put("detalles",detalles);
                        datosResidencia.put("precio",costo);
                        datosResidencia.put("ubicacion","");
                        datosResidencia.put("mascotas","");
                        datosResidencia.put("deposito","");
                        datosResidencia.put("activo","");

                        //datos.put("id_tipo", tipo_lugar);
                        //datos.put("numHabitaciones", numHabitaciones);
                        //datos.put("agua", agua);
                        //datos.put("luz", electricidad);
                        //datos.put("gas", gas);
                        //datos.put("internet", internet);
                        //datos.put("cable", cable);
                        //datos.put("drenaje", drenaje);
                        //datos.put("telefono", telefono);
                    } catch (JSONException e) {
                        Log.println(Log.ERROR, "error", e.toString());
                    }

                }

                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

                JsonObjectRequest jsObjRequest = new JsonObjectRequest(Request.Method.POST, constantes.getRegistroResidecia(), datosResidencia,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {

                                    JSONObject jO = new JSONObject();
                                    jO = response;
                                    System.out.println(jO);
                                    valorEstado = jO.getString("estado");
                                } catch (JSONException e) {
                                    Log.println(Log.ERROR, "error", e.toString());
                                }
                                if (valorEstado.equals("1")) {
                                    startActivity(new Intent(RegistroResidencia.this, LoginActivity.class));
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "Residencia no registrada", Toast.LENGTH_SHORT);
                    }
                }){
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        headers.put("authorization", claveApi);
                        return headers;
                    }
                };
                queue.add(jsObjRequest);
            }
        });
    }
}

