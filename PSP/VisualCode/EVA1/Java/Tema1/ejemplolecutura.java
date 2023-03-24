package PSP.Tema1;

import java.io.*;

public class Ejemplo5 {

	public static void main(String[] args) throws IOException {

		File directorio = new File("/home/javier/.config/Code/User/workspaceStorage/5a5787c52c8aef2d36b70c38bba4694c/redhat.java/jdt_ws/ProyectosJava_9595dec8/bin");
		ProcessBuilder pb = new ProcessBuilder("java", "EjemploLectura");

		pb.directory(directorio);

		// se ejecuta el proceso
		Process p = pb.start();

		// escritura -- envia entrada 
		OutputStream os = p.getOutputStream();
		os.write("Hola Manuel\n".getBytes());
		os.flush(); // vac�a el buffer de salida

		// lectura -- obtiene la salida
		InputStream is = p.getInputStream();
		int c;
		while ((c = is.read()) != -1)
			System.out.print((char) c);
		is.close();

		// COMPROBACION DE ERROR - 0 bien - 1 mal
		int exitVal;
		try {
			exitVal = p.waitFor();
			System.out.println("Valor de Salida: " + exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			InputStream er = p.getErrorStream();
			BufferedReader brer = new BufferedReader(new InputStreamReader(er));
			String liner = null;
			while ((liner = brer.readLine()) != null)
				System.out.println("ERROR >" + liner);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}// Ejemplo5
