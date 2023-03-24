package MapAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ActoresPageResponse {

    @SerializedName("nombre")
    @Expose
    private String nombrePel;

    @SerializedName("descripcion")
    @Expose
    private String descripcionPel;

    @SerializedName("estrellas")
    @Expose
    private String estrellasPel;

    @SerializedName("actores")
    @Expose
    private List<ActoresResponse> actoresResponses;

    public String getNombrePel() {
        return nombrePel;
    }

    public String getDescripcionPel() {
        return descripcionPel;
    }

    public String getEstrellasPel() {
        return estrellasPel;
    }

    public List<ActoresResponse> getActoresResponses() {
        return actoresResponses;
    }
}
