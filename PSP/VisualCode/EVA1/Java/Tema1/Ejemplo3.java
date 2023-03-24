package PSP.Tema1;

import java.io.*;

public class Ejemplo3 {
  public static void main(String[] args) throws IOException {

	//creamos objeto File al directorio donde esta Ejemplo2
	File directorio = new File("/home/javier/.config/Code/User/workspaceStorage/5a5787c52c8aef2d36b70c38bba4694c/redhat.java/jdt_ws/ProyectosJava_9595dec8/bin");	

	//El proceso a ejecutar es Ejemplo2			
	ProcessBuilder pb = new ProcessBuilder("java", "Ejemplo2");

    //se establece el directorio donde se encuentra el ejecutable
    System.out.println("Prueba "+directorio);
    pb.directory(directorio);
        
	System.out.printf("Directorio de trabajo: %s%n",pb.directory());

    //se ejecuta el proceso
	Process p = pb.start();

   //obtener la salida devuelta por el proceso
	try {
		InputStream is = p.getInputStream();
		int c;
		while ((c = is.read()) != -1)
			System.out.print((char) c);
		is.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
		
  }
}// Ejemplo3

