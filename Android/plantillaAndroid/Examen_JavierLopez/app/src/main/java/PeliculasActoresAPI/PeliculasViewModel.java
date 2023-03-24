package PeliculasActoresAPI;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import MapAPI.ActoresPageResponse;
import MapAPI.PeliculasResponse;

public class PeliculasViewModel extends ViewModel {

    private MutableLiveData <List<PeliculasResponse>> data;
    private MutableLiveData <ActoresPageResponse> dataActor;
    private PeliculasRepository peliculasRepository;

    public void init() {
        peliculasRepository = new PeliculasRepository().getInstance();
        data = peliculasRepository.getpRMutableLiveData();
        dataActor = peliculasRepository.getActoresPageResponseMutableLiveData();
    }

    public void listarPeliculas () {
        peliculasRepository.listarPeliculas();
    }

    public void mostrarComentario(String url) {
        peliculasRepository.mostrarActores(url);
    }

    public MutableLiveData<List<PeliculasResponse>> getData() {
        return data;
    }

    public MutableLiveData<ActoresPageResponse> getDataActor() {
        return dataActor;
    }
}
