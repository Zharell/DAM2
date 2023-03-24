package PSP.Tema2Syncro;

class HiloB extends Thread {
	private Contador contador;

	//Se crea el Hilo y se le asigna el nombre
	public HiloB(String n , Contador c) {
		setName(n);
		contador = c;
	}
	
	public void run(){
		for (int j = 0; j < 300; j++) {

			// 2º.- Posible sincro
           // synchronized(contador){
                contador.decrementa();//decrementa el contador
             //   }
			 
			try {
				sleep(10);
			}catch (InterruptedException e) {}
		}
	}
}//FIN HILOB
