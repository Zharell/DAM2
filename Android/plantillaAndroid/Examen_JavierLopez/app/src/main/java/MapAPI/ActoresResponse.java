package MapAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ActoresResponse {

    @SerializedName("nombre")
    @Expose
    private String nombreActor;

    @SerializedName("pelicula")
    @Expose
    private String peliculaActor;

    public String getNombreActor() {
        return nombreActor;
    }

    public String getPeliculaActor() {
        return peliculaActor;
    }
}
