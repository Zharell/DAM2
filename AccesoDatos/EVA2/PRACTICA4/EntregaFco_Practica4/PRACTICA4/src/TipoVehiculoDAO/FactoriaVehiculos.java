
package TipoVehiculoDAO;



import TipoVehiculoDAO.VehiculosBD;
import TipoVehiculoDAO.VehiculosInterface;


public class FactoriaVehiculos {
    public static VehiculosInterface getVehiculosDao(){
    
        
        return new VehiculosBD();
    }
    
}