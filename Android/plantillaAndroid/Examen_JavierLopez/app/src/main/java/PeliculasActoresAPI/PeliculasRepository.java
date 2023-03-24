package PeliculasActoresAPI;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import MapAPI.ActoresPageResponse;
import MapAPI.PeliculasResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeliculasRepository {

    private final String API_URL = "http://51.77.156.235:3322";
    private PeliculasRepository instance;
    private MutableLiveData <List<PeliculasResponse>> pRMutableLiveData;

    private MutableLiveData <ActoresPageResponse> actoresPageResponseMutableLiveData;
    private List <PeliculasResponse> respuesta;
    private PeliculasService service;

    public PeliculasRepository getInstance() {
        if (instance == null) {
            instance = new PeliculasRepository();
        }
        return instance;
    }

    public PeliculasRepository () {
        pRMutableLiveData = new MutableLiveData<>();
        actoresPageResponseMutableLiveData = new MutableLiveData<>();

        service = new retrofit2.Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PeliculasService.class);
    }

    public void listarPeliculas () {
        service.listarPeliculas().enqueue(new Callback<List<PeliculasResponse>>() {
            @Override
            public void onResponse(Call<List<PeliculasResponse>> call, Response<List<PeliculasResponse>> response) {
                respuesta = response.body();
                pRMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<PeliculasResponse>> call, Throwable t) {

            }
        });
    }

    public void mostrarActores(String url){
        service.mostrarActores(url).enqueue(new Callback<ActoresPageResponse>() {
            @Override
            public void onResponse(Call<ActoresPageResponse> call, Response<ActoresPageResponse> response) {
                actoresPageResponseMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ActoresPageResponse> call, Throwable t) {

            }
        });
    }

    public MutableLiveData <List<PeliculasResponse>> getpRMutableLiveData() {
        return pRMutableLiveData;
    }

    public MutableLiveData<ActoresPageResponse> getActoresPageResponseMutableLiveData() {
        return actoresPageResponseMutableLiveData;
    }
}
