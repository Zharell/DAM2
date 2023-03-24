package PSP.Tema2Syncro;

public class Controladora {
	public static void main(String[] args) {
		Contador contador = new Contador(100);

		//Crea objetos Hilo y los nombra
		HiloA a = new HiloA( "HiloA", contador) ;
		HiloB b = new HiloB( "HiloB", contador);

		//Los inica
		
		a.start();
		b.start();
		
		// 1º.- ¿Qué ocurre?
		//No le damos tiempo a los demás Threads a funcionar
        try {

		
		//Equivalente a wait(NULL) en C
    	a.join();
        b.join();

		//Espera a que los procesos terminen sus calculos
        System.out.println("Contador vale " + contador.valor());
        } catch (Exception x) {
            
        }
		
	}
}
