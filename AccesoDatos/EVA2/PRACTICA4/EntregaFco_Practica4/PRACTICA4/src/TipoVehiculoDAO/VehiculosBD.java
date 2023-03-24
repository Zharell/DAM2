package TipoVehiculoDAO;

import java.sql.*;

import java.sql.SQLException;


public class VehiculosBD implements VehiculosInterface{
    private String nombre;
    private int ruedas, cod_Tipo_Vehiculo;
    private java.sql.Connection conexion=null;
    
    
    public VehiculosBD () {
    }
    
     public VehiculosInterface getNuevoVehiculo(int cod_Tipo_Vehiculo, String nombre, int ruedas){
        conexion=getConexion();
        java.sql.Statement sentencia=null;
        try{
            sentencia=conexion.createStatement();
            sentencia.execute("INSERT INTO PRACTICA4.tipo_vehiculos VALUES ("+cod_Tipo_Vehiculo+",'"+nombre+"',"+ruedas+")"); 
            }catch(SQLException e){  
                System.out.println("Error al intentar insertar Vehiculo"+ e.getMessage());
                return null;
            }
        VehiculosBD vehiculo= new VehiculosBD(); 
        vehiculo.cod_Tipo_Vehiculo=cod_Tipo_Vehiculo;
        vehiculo.nombre=nombre;
        vehiculo.ruedas=ruedas;
        return vehiculo;
    }
     
    
    public int getCod_Tipo_Vehiculo(){
        return this.cod_Tipo_Vehiculo;
    }
    public String getNombre(){
        return nombre;
    }
    public int getRuedas(){
        return ruedas;
    }
    public String getTrupla(){
        return "Tipo de Vehículo: "+this.cod_Tipo_Vehiculo+" Nombre: "+nombre+" Ruedas: "+ruedas; 
    }
    
    //Método que muestra todas las truplas en pantalla
    public void getAll(){
        conexion=getConexion();
        java.sql.Statement sentencia = null;
        VehiculosBD vehiculo= null;   
        try{
            sentencia= conexion.createStatement();
            vehiculo = new VehiculosBD();
            java.sql.ResultSet resultado;
            resultado = sentencia.executeQuery("SELECT * FROM PRACTICA4.tipo_vehiculos ");
               while(resultado.next()){						
                    vehiculo.cod_Tipo_Vehiculo=resultado.getInt("cod_tipo_vehiculo"); 
                    vehiculo.nombre=resultado.getString("nombre");
                    vehiculo.ruedas=resultado.getInt("ruedas");
                    System.out.println(vehiculo.getTrupla());
               }
                resultado.close();
                sentencia.close();
                conexion.close();
            }catch (SQLException e){
                System.out.println("Error en SELECT de vehiculo por codigo");   
            }
    }
    
    //Método hace update al Codigo Vehiculo
    public void  setTipoVehiculo(int cod_Tipo_Vehiculo, int nCod_Tipo_Vehiculo){ 
        conexion=getConexion();
        java.sql.Statement sentencia = null;
        try{
            sentencia= conexion.createStatement();
            sentencia.execute("UPDATE PRACTICA4.tipo_vehiculos SET cod_tipo_vehiculo="+nCod_Tipo_Vehiculo+" WHERE cod_tipo_vehiculo="+cod_Tipo_Vehiculo+"");        
            sentencia.close();
            conexion.close();
        }catch (SQLException e){
            System.out.println("Error al realizar un cambio de nombre");
            return;
        }
        this.nombre=nombre;   
    }
    
    //Método hace update a Ruedas
    public void  setRuedas(int ruedas){
        conexion=getConexion();
        java.sql.Statement sentencia=null;
         try{
            sentencia= conexion.createStatement(); 
            sentencia.execute("UPDATE PRACTICA4.tipo_vehiculos SET ruedas="+ruedas+" WHERE cod_tipo_vehiculo="+this.cod_Tipo_Vehiculo);
            sentencia.close();
            conexion.close();
        }catch (SQLException e){
            System.out.println("Error al realizar un cambio de ruedas");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        this.ruedas=ruedas;
    }
    
    //Método que conecta la bases de datos
    private java.sql.Connection getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println("No se encuentra la clase del Driver");
            return null;
        }
        Connection conexion= null;
        try {
            conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull","root", "");                               
        } catch (SQLException e){
            System.out.println("No se puede obtener la conexión");
            return null;
        }
        return conexion;
    }
    
    //Método utilizado para filtrar a través del Codigo Vehiculo
    public VehiculosInterface getVehiculoPorTipo(int cod_Tipo_Vehiculo){
        conexion=getConexion();
        java.sql.Statement sentencia = null;
        VehiculosBD vehiculo= null;  
        try{
            sentencia= conexion.createStatement();
            vehiculo = new VehiculosBD();
            java.sql.ResultSet resultado;
            resultado = sentencia.executeQuery("SELECT * FROM PRACTICA4.tipo_vehiculos WHERE cod_tipo_vehiculo="+cod_Tipo_Vehiculo+"");
               while(resultado.next()){						
                    vehiculo.cod_Tipo_Vehiculo=resultado.getInt("cod_tipo_vehiculo"); 
                    vehiculo.nombre=resultado.getString("nombre");
                    vehiculo.ruedas=resultado.getInt("ruedas");
               }
                resultado.close();
                sentencia.close();
                conexion.close();
            }catch (SQLException e){
                System.out.println("Error en SELECT de Corredor por DNI");
                return null;
            }
            return vehiculo;
    }
    
    //Método que borra truplas
    public void delete(int cod_tipo_vehiculo) {
        conexion=getConexion();
        java.sql.Statement sentencia = null;
        try{
            sentencia= conexion.createStatement(); 
            sentencia.execute("DELETE FROM PRACTICA4.tipo_vehiculos WHERE cod_tipo_vehiculo="+cod_tipo_vehiculo+"");
            sentencia.close();
            conexion.close();
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("Error al realizar delete sobre el vehiculo");
            return;
        };
        
    }
    
}
