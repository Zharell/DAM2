package CorredorDAO;

import java.util.Scanner;

public class AppCorredor {
    
    public static Scanner sc = new Scanner(System.in);
    
    public static CorredorInterface objetoDAO = FactoriaCorredor.getCorredorDao();
    
    public static void main(String[] args) {
        
        //Método menú
        menuEleccion();
        
    }
    
    public static void menuEleccion(){
        int eleccion=1;
        while (eleccion!=0) {
            System.out.println("\n0 - Salir \n1 - Añadir nuevo Corredor \n2 - Modificar un Corredor  "
                               + "\n3 - Borrar un Corredor \n4 - Mostrar un Corredor "
                               + "\n5 - Mostrar Todos");
            eleccion = sc.nextInt();
            //Limpiamos el  buffer
            sc.nextLine(); 
            switch(eleccion) {
                case 0:
                    System.out.println("Has salido");
                break;
                case 1:
                    insertarCorredor();
                break;
                case 2:
                    modificarCorredor();
                break;
                case 3:
                    borrarCorredor();
                break;
                case 4:
                    mostrarCorredor();
                break;
                case 5:
                    objetoDAO.getAll();
                break;
            }
        }    
    }
    
    //Método que inserta
    public static void insertarCorredor(){
        System.out.println("Introduce DNI");
        String dni = sc.nextLine();
        System.out.println("Introduce nombre");
        String nombre = sc.nextLine();
        System.out.println("Introduce apellidos");
        String apellidos = sc.nextLine();
        System.out.println("Introduce edad");
        int edad = sc.nextInt();
        System.out.println("Introduce vehiculo");
        int vehiculo = sc.nextInt();
        objetoDAO.getNuevoCorredor(dni, nombre, apellidos, edad, vehiculo);
        System.out.println("Se ha insertado: "+objetoDAO.getCorredorPorDNI(dni).getTrupla());
    }
    
    //Método que modifica el DNI de un Corredor
    public static void modificarCorredor(){
        System.out.println("Cual deseas modificar:");
        objetoDAO.getAll();
        System.out.println("Introduce DNI");
        String dni = sc.nextLine();
        System.out.println("Introduce nuevo DNI");
        String nDni = sc.nextLine();
        objetoDAO.setDni(dni,nDni);
        System.out.println("Se ha modificado: "+objetoDAO.getCorredorPorDNI(nDni).getTrupla());
    }
    
    //Método que borra un Corredor
    public static void borrarCorredor(){
        System.out.println("Cual deseas borrar:");
        objetoDAO.getAll();
        System.out.println("Introduce DNI");
        String dni = sc.nextLine();
        System.out.println("Se ha borrado: "+objetoDAO.getCorredorPorDNI(dni).getTrupla());
        objetoDAO.delete(dni);
    }
    
    //Método que muestra un corredor
    public static void mostrarCorredor(){
        System.out.println("Introduce DNI para mostrar:");
        String dni = sc.nextLine();
        System.out.println(objetoDAO.getCorredorPorDNI(dni).getTrupla());
    }
    
    
}
