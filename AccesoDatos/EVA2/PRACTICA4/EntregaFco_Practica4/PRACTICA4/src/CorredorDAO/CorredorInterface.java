package CorredorDAO;

public interface CorredorInterface {
    
    
    //Métodos GETTER
    public String getDni();
    public String getNombre();
    public String getApellidos();   
    public int getEdad();
    public int getCod_tipo_vehiculo();
    public String getTrupla();
    public void getAll();
    
    //Métodos SETTER
    public void  setNombre(String nombre);  
    public void  setTipoVehiculo(int Tipo_vehiculo);            
    public void  setDni(String dni,String nDni);
    
    //Métodos FIND
    public CorredorInterface getCorredorPorDNI(String DNI);
    public java.util.Collection getCorredorPorTipoVehiculo(int Tipo_vehiculo);
    public java.util.Collection getCorredorPorNombre(String nombre);
    
    //Método DELETE
    public void delete(String dni);
    
    //Constructor
    public CorredorInterface getNuevoCorredor(String dni,String nombre,String apellidos, int edad, int cod_tipo_vehiculo );

}