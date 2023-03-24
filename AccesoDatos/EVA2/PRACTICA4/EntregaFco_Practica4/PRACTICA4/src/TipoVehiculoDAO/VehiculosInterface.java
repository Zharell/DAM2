
package TipoVehiculoDAO;

public interface VehiculosInterface {
    
    public VehiculosInterface getNuevoVehiculo(int cod_Tipo_Vehiculo,String nombre,int  ruedas);
    
    public int getCod_Tipo_Vehiculo();
    public String getNombre();
    public int getRuedas();
    public String getTrupla();
    public void getAll();
     
     
    public VehiculosInterface getVehiculoPorTipo(int cod_tipo_vehiculo);
    public void delete(int cod_tipo_vehiculo);
    
    public void  setTipoVehiculo(int cod_Tipo_Vehiculo,int nCod_Tipo_Vehiculo);
    public void  setRuedas(int ruedas);
       
}
