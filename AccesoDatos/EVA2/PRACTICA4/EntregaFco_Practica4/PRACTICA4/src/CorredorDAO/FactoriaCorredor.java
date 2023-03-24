package CorredorDAO;



import CorredorDAO.CorredorInterface;
import CorredorDAO.CorredorBD;


public class FactoriaCorredor {
    
     
  public static  CorredorInterface getCorredorDao(){
      
        return new CorredorBD();
    }
}