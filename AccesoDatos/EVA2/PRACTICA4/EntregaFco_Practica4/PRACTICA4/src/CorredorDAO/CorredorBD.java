package CorredorDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CorredorBD implements CorredorInterface {
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;
    private int cod_tipo_vehiculo;
    private java.sql.Connection conexionA=null;
    
    public CorredorBD() {
        
    }
    public String getDni(){
        return this.dni;
    }
    public String getNombre(){
        return nombre; 
    }
    public String getApellidos(){
        return apellidos;
    }
    public int getEdad(){
        return edad;
    }
    public int getCod_tipo_vehiculo(){
        return cod_tipo_vehiculo;
    }
    public String getTrupla(){
        return "DNI: "+this.dni+" Nombre: "+nombre+" Apellidos: "+apellidos+" Edad: "+edad+" Tipo_Vehiculo: "+cod_tipo_vehiculo; 
    }
    
    //Método que muestra todas las truplas en pantalla
    public void getAll(){
    conexionA=getConexionCorredor();
        java.sql.Statement sentencia = null;
        CorredorBD corredor= null;
        try{
            sentencia= conexionA.createStatement();

            corredor = new CorredorBD();
            java.sql.ResultSet resultado;
            resultado = sentencia.executeQuery("SELECT * FROM PRACTICA4.corredor ");

               while(resultado.next()){						
                    corredor.dni=resultado.getString("dni"); 
                    corredor.nombre=resultado.getString("nombre");
                    corredor.apellidos=resultado.getString("apellidos");
                    corredor.edad=resultado.getInt("edad");
                    corredor.cod_tipo_vehiculo=resultado.getInt("cod_tipo_vehiculo");
                    System.out.println(corredor.getTrupla());
               }
                resultado.close();
                sentencia.close();
                conexionA.close();
            }catch (SQLException e){
                System.out.println("Error en SELECT de Corredor por DNI");   
            }
    }
    
    //Método que realiza la conexión con la BD
    private java.sql.Connection getConexionCorredor(){
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

    //Método que modifica el nombre
    public void  setNombre(String nombre){
        conexionA=getConexionCorredor();
        java.sql.Statement sentencia = null;
        try{
            sentencia= conexionA.createStatement();
            sentencia.execute("UPDATE PRACTICA4.corredor SET NOMBRE='"+nombre+"'WHERE dni='"+this.dni+"'");
            sentencia.close();
                conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en realizar UPDATE en corredores");
            return;
        }
        this.nombre=nombre;
    }

    //Método que modifica el tipo de vehiculo
    public void  setTipoVehiculo(int cod_tipo_vehiculo){
           conexionA=getConexionCorredor();
           java.sql.Statement sentencia = null;
            try{
                sentencia= conexionA.createStatement();
                sentencia.execute("UPDATE PRACTICA4.corredor SET cod_tipo_vehiculo='"+cod_tipo_vehiculo+"'WHERE dni='"+this.dni+"'");
                sentencia.close();
                conexionA.close();
            }catch (SQLException e){
                System.out.println("Error en realizar UPDATE en Tipo_Vehiculos");
                return;
            }
            this.cod_tipo_vehiculo=cod_tipo_vehiculo;
    }
    
    //Método que modifica el DNI
    public void  setDni(String dni,String nDni){
        conexionA=getConexionCorredor();
        java.sql.Statement sentencia=null;
        try{
            sentencia= conexionA.createStatement(); 
            sentencia.execute("UPDATE PRACTICA4.corredor SET DNI='"+nDni+"'WHERE dni='"+dni +"'");
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en realizar UPDATE en corredores");
            return;
        }catch (Exception e){
            System.out.println(e.getClass());
            return;
        }
        this.dni=dni;
    }

    //Método utilizado para filtrar a través del DNI
    public CorredorInterface getCorredorPorDNI(String dni){
        conexionA=getConexionCorredor();
        java.sql.Statement sentencia = null;
        CorredorBD corredor= null;   
        try{
            sentencia= conexionA.createStatement();
            corredor = new CorredorBD();
            java.sql.ResultSet resultado;
            resultado = sentencia.executeQuery("SELECT * FROM PRACTICA4.corredor WHERE dni='"+dni+"'");
               while(resultado.next()){						
                    corredor.dni=resultado.getString("dni"); 
                    corredor.nombre=resultado.getString("nombre");
                    corredor.apellidos=resultado.getString("apellidos");
                    corredor.edad=resultado.getInt("edad");
                    corredor.cod_tipo_vehiculo=resultado.getInt("cod_tipo_vehiculo");   
               }
                resultado.close();
                sentencia.close();
                conexionA.close();
            }catch (SQLException e){
                System.out.println("Error en SELECT de Corredor por DNI");
                return null;
            }
            return corredor;
    }
    
    //Método utilizado para filtrar a través del tipo de vehiculo
    public java.util.Collection getCorredorPorTipoVehiculo(int cod_tipo_vehiculo){
        conexionA=getConexionCorredor();
        java.sql.Statement sentencia = null;
        CorredorBD corredor= null;  
        java.util.Collection coleccion =null;
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector(); 	
            java.sql.ResultSet resultado;
            resultado = sentencia.executeQuery("SELECT * FROM PRACTICA4.corredor WHERE cod_tipo_vehiculo="+ cod_tipo_vehiculo+"");
            while(resultado.next()){
                corredor.dni=resultado.getString("dni"); 
                corredor.nombre=resultado.getString("nombre");
                corredor.apellidos=resultado.getString("apellidos");
                corredor.edad=resultado.getInt("edad");
                corredor.cod_tipo_vehiculo=resultado.getInt("cod_tipo_vehiculo");
                coleccion.add(corredor);
            }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de Corredor por tipo de vehículo");
            return null;
        }
        return coleccion;
    }

    //Método utilizado para filtrar a través del nombre
    public java.util.Collection getCorredorPorNombre(String nombre){
        conexionA=getConexionCorredor();
        java.sql.Statement sentencia = null;   
        CorredorBD corredor= null;  
        java.util.Collection coleccion =null;
        try{
            sentencia= conexionA.createStatement(); 
            coleccion = new java.util.Vector();         
            java.sql.ResultSet resultado;
            resultado = sentencia.executeQuery("SELECT * FROM PRACTICA4.corredor WHERE nombre='"+nombre+"'");
            while(resultado.next()){
                corredor.dni=resultado.getString("dni"); 
                corredor.nombre=resultado.getString("nombre");
                corredor.apellidos=resultado.getString("apellidos");
                corredor.edad=resultado.getInt("edad");
                corredor.cod_tipo_vehiculo=resultado.getInt("cod_tipo_vehiculo");
                coleccion.add(corredor);
            }
            resultado.close();
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println("Error en SELECT de Corredor por tipo de nombre");
            return null;
        }
        return coleccion;
    }

    //METODO DE BORRADO
    public void delete(String dni) {
        conexionA=getConexionCorredor();
        java.sql.Statement sentencia=null;
        try{
            sentencia= conexionA.createStatement(); 
            sentencia.execute("DELETE FROM PRACTICA4.corredor WHERE dni='"+dni+"'");
            sentencia.close();
            conexionA.close();
        }catch (SQLException e){
            System.out.println(e);
            System.out.println("Error al realizar delete sobre el corredor");
            return;
        };
    }
    
    //METODO INSERT
    public CorredorInterface getNuevoCorredor(String dni,String nombre,String apellidos, int edad, int cod_tipo_vehiculo ){
        conexionA=getConexionCorredor();
        java.sql.Statement sentencia=null;
        try{
            sentencia=conexionA.createStatement();
            sentencia.execute("INSERT INTO PRACTICA4.corredor VALUES ('"+dni+"','"+ nombre+"','"+apellidos+"',"+edad+","+cod_tipo_vehiculo+")");
        }catch(SQLException e){  
            System.out.println("Error SQL al insertar Corredor"+ e.getMessage());
            return null;
        }
        CorredorBD corredor= new CorredorBD(); 
        corredor.dni=dni;
        corredor.nombre=nombre;
        corredor.apellidos=apellidos;
        corredor.edad=edad;
        corredor.cod_tipo_vehiculo=cod_tipo_vehiculo;
        return corredor;
    }
    
    
    

}
