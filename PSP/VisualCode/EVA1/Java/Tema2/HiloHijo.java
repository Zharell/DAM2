package PSP.Tema2;

public class HiloHijo implements Runnable {

    private static final int NUMERO_HIJOS=5;
    private static final int NUMERO_SALUDOS=2;

    int id;

    public HiloHijo (int id) {
        this.id=id;
    }

	public void run() {

            for (int i=0;i<NUMERO_SALUDOS;i++) {
			System.out.println("Soy el hijo"+id);
            }
            
	}


	//Para usar el hilo creo la clase UsaHilo:

	public static void main(String[] args){
        for (int i=0;i<NUMERO_HIJOS;i++) {
            HiloHijo hijo =new HiloHijo(i);
            Thread t = new Thread(hijo);
            t.start();
        }
		
        for (int i=0;i<NUMERO_SALUDOS;i++) {
            System.out.println("Soy el principal");
        }
	}



}
