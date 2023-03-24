package PeliculasActoresAPI;

import java.util.List;

import MapAPI.ActoresPageResponse;
import MapAPI.PeliculasResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface PeliculasService {

    @GET("/pmdm/api/peliculas/")
    Call <List<PeliculasResponse>> listarPeliculas();

    @GET
    Call <ActoresPageResponse> mostrarActores(@Url String url);

}
