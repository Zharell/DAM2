package MapAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PeliculasResponse {

    @SerializedName("estrellas")
    @Expose
    private int estrellas;

    @SerializedName("descripcion")
    @Expose
    private String descripcionPelicula;

    @SerializedName("url")
    @Expose
    private String urlPelicula;

    @SerializedName("nombre")
    @Expose
    private String nombrePelicula;

    public int getEstrellas() {
        return estrellas;
    }

    public String getDescripcionPelicula() {
        return descripcionPelicula;
    }

    public String getUrlPelicula() {
        return urlPelicula;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }
}
