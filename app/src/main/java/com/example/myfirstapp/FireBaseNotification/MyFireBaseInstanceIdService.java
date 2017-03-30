package com.example.myfirstapp.FireBaseNotification;

import android.util.Log;

import com.example.myfirstapp.ControlGymApplication;
import com.example.myfirstapp.helper.SystemPreferencesHelper;
import com.example.myfirstapp.rest.ApiClient;
import com.example.myfirstapp.rest.ApiInterface;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.google.android.gms.internal.zzs.TAG;

/**
 * Created by M.Franco on 3/27/2017.
 */

public class MyFireBaseInstanceIdService extends FirebaseInstanceIdService{
    private static final String TAG = "Reg_Token";

    @Override
    public void onTokenRefresh() {
        // Guardando el Instance ID token en el app server.
        registrarToken();
    }

    public void registrarToken(){
        // Obteniendo el InstanceID token actualizado.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
        // Validar que el miembro este autenticado.
        int idMiembroActivo = SystemPreferencesHelper.getPreferenceInt(ControlGymApplication.getContext(), "IdMiembro");
        if (idMiembroActivo != -1){
            // Generando parametros para luego ser parseados a formato json.
            Map<String, String> params = new HashMap<>();
            params.put("DeviceToken", refreshedToken);
            params.put("IdMiembro", Integer.toString(idMiembroActivo));

            // Llamando metodo POST con el objeto correspondiente como parametro.
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<ResponseBody> call = apiService.registrarDeviceToken(params);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody>call, Response<ResponseBody> response) {
                    if (response.code() == 201) {
                        Log.d(TAG, "device Token actualizado");
                    } else {
                        Log.e(TAG, Integer.toString(response.code()));
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody>call, Throwable t) {
                    // Log error here since request failed
                    Log.e(TAG, t.toString());
                }
            });
        }
    }
}
