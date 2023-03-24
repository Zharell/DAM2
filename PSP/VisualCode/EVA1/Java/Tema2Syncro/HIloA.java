package PSP.Tema2Syncro;

class HiloA extends Thread {
	private Contador contador;

	//Se crea el Hilo y se le asigna el nombre
	public HiloA (String n , Contador c) {
		setName(n);
		contador = c ;
	}
	
	public void run(){
		for (int j = 0; j < 200; j++) {

			// 2º.- Posible sincro
            //codigo concurrente
            //synchronized(contador){
			contador.incrementa();
            //}

			try {
				sleep(10);
				
			} catch (InterruptedException e ) {
				System.out.println("He salado esperando notify");

			}
		}
	}
}
