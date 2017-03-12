package com.example.myfirstapp.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myfirstapp.ControlGymApplication;
import com.example.myfirstapp.R;
import com.example.myfirstapp.helper.SystemPreferencesHelper;
import com.example.myfirstapp.model.Miembro;
import com.example.myfirstapp.rest.ApiClient;
import com.example.myfirstapp.rest.ApiInterface;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();
    private final Context thisContext = this;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Login =(Button) findViewById(R.id.btn_login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText texto = (EditText) findViewById(R.id.correoLogin);
                String correo = texto.getText().toString();
                texto = (EditText) findViewById(R.id.contrasenaLogin);
                String clave = texto.getText().toString();
                enviarDatosLogin(correo, clave);
                // enviarDatosLogin("jacklin@gmail.com", "clave");
            }
        });
    }

    private void enviarDatosLogin(String correo, String clave){
        // Dialogo de carga para hacer saber al usuario que hay un proceso
        final ProgressDialog progress = new ProgressDialog(this);
        progress.setTitle("Autenticando usuario");
        progress.setMessage("Por favor espere un momento...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show(); // ejecutar progress.dismiss(); para detener el dialogo de carga

        // Generando parametros para luego ser parseados a formato json
        Map<String, String> params = new HashMap<>();
        params.put("Correo", correo);
        params.put("Clave", clave);

        // Llamando metodo POST con el objeto correspondiente como parametro
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Miembro> call = apiService.autenticar(params);
        call.enqueue(new Callback<Miembro>() {
            @Override
            public void onResponse(Call<Miembro>call, Response<Miembro> response) {
                if (response.body().getToken() != null
                        && !response.body().getToken().isEmpty()){
                    Log.d(TAG, "response.body().getResults(): " + response.body().getToken());

                    // Guardando el token y datos de usuario en archivos de preferencias
                    SystemPreferencesHelper.savePreference(ControlGymApplication.getContext(), "Authorization", response.body().getToken());
                    SystemPreferencesHelper.savePreference(ControlGymApplication.getContext(), "Correo", response.body().getCorreo());
                    SystemPreferencesHelper.savePreference(ControlGymApplication.getContext(), "Nombre", response.body().getNombre());
                    SystemPreferencesHelper.savePreference(ControlGymApplication.getContext(), "IdMiembro", response.body().getIdMiembro());

                    // Redirigir a siguiente activity
                    Intent Loginn=new Intent(LoginActivity.this, ProgramaActivity.class);
                    startActivity(Loginn);
                } else {
                    Log.d(TAG, "Toast message: " + "Correo o Clave incorrectos");
                    Toast.makeText(ControlGymApplication.getContext(), "Correo o Clave incorrectos", Toast.LENGTH_SHORT).show();
                }
                progress.dismiss();
            }

            @Override
            public void onFailure(Call<Miembro>call, Throwable t) {
                // Log error here since request failed
                progress.dismiss();
                Log.e(TAG, t.toString());
            }
        });
    }
}
