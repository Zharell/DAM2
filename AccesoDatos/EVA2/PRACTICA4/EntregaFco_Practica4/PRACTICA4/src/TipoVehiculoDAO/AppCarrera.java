package TipoVehiculoDAO;

import java.util.Scanner;


public class AppCarrera {
    
    public static Scanner sc = new Scanner(System.in);
    public static VehiculosInterface objetoDAO = FactoriaVehiculos.getVehiculosDao();
    
    public static void main(String[] args) {
 
        menuEleccion();
        
    }
    
    public static void menuEleccion(){
        int eleccion=1;
        while (eleccion!=0) {
            System.out.println("\n0 - Salir \n1 - Añadir nuevo vehículo \n2 - Modificar un vehículo  "
                               + "\n3 - Borrar un vehículo \n4 - Mostrar un vehículo "
                               + "\n5 - Mostrar Todos");
            eleccion = sc.nextInt();
            //Limpiamos el  buffer
            sc.nextLine(); 
            switch(eleccion) {
                case 0:
                    System.out.println("Has salido");
                break;
                case 1:
                    insertarVehiculo();
                break;
                case 2:
                    modificarVehiculo();
                break;
                case 3:
                    borrarCVehiculo();
                break;
                case 4:
                    mostrarVehiculo();
                break;
                case 5:
                    objetoDAO.getAll();
                break;
            }
        }    
    }
    
    //Método que inserta
    public static void insertarVehiculo(){
        System.out.println("Introduce Codigo de Vehiculo");
        int codvehiculo = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce nombre");
        String nombre = sc.nextLine();
        System.out.println("Introduce ruedas");
        int ruedas = sc.nextInt();
        objetoDAO.getNuevoVehiculo(codvehiculo, nombre, ruedas);
        System.out.println("Se ha insertado: "+objetoDAO.getVehiculoPorTipo(codvehiculo).getTrupla());
    }
    
    //Método que modifica el DNI de un Corredor
    public static void modificarVehiculo(){
        System.out.println("Cual deseas modificar:");
        objetoDAO.getAll();
        System.out.println("Introduce Codigo de Vehiculo");
        int codvehiculo = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce el nuevo Codigo de Vehiculo");
        int nCodvehiculo = sc.nextInt();
        objetoDAO.setTipoVehiculo(codvehiculo,nCodvehiculo);
        System.out.println("Se ha modificado: "+objetoDAO.getVehiculoPorTipo(nCodvehiculo).getTrupla());
    }
    
    //Método que borra un Corredor
    public static void borrarCVehiculo(){
        System.out.println("Cual deseas borrar:");
        objetoDAO.getAll();
        System.out.println("Introduce Codigo de Vehiculo");
        int codvehiculo = sc.nextInt();
        sc.nextLine();
        System.out.println("Se ha borrado: "+objetoDAO.getVehiculoPorTipo(codvehiculo).getTrupla());
        objetoDAO.delete(codvehiculo);
    }
    
    //Método que muestra un corredor
    public static void mostrarVehiculo(){
        System.out.println("Introduce Codigo de Vehiculo");
        int codvehiculo = sc.nextInt();
        sc.nextLine();
        System.out.println(objetoDAO.getVehiculoPorTipo(codvehiculo).getTrupla());
    }
    
    
}
