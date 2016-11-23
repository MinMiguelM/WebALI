/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cintermedia;


import entities.Plato;
import entities.Restaurante;
import entities.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import logica.ConexionBeanRemote;


/**
 *
 * @author SALABD
 */
public class ALIWebIntermedia {

    
    private ConexionBeanRemote conexion;
    
    public ALIWebIntermedia() throws Exception {
        
        Properties properties = new Properties();
        properties.setProperty("org.omg.CORBA.ORBInitialHost", "10.192.230.17");
        properties.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
        InitialContext ctx = new InitialContext(properties);
        conexion = (ConexionBeanRemote)ctx.lookup("java:global/NegocioALI/ConexionBean");
    }
    
    public void agregarPlato(Plato p) throws Exception {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        conexion.agregarPlato(p);
    }
     
    
    public List<Plato> getPlatos(String s) {
        
        List<Plato> listP= conexion.getPlatos(s);
        return listP;
    }
    
    public int pago(Usuario u, List<Plato> p){
        return conexion.pago(u, p);
    }
    
    public boolean eliminarPlato(Plato p){
        return conexion.eliminarPlato(p);
    }
    
    public Plato getPlatoByName(String pl){
        return conexion.getPlatoByName(pl);
    }
    
    public void editarPlato(Plato p){
        conexion.editarPlato(p);
    }

    //Restaurante
    public List<Restaurante> getRestaurantes(String s) {
        List<Restaurante> listR = conexion.getRestaurantes(s);
        return listR;
    }
    

    public void editarRestaurante(Restaurante p) {
        conexion.editarRestaurante(p);
    }

    public void agregarRestaurante(Restaurante p) {
       conexion.agregarRestaurante(p);
    }

    public boolean eliminarRest(Restaurante rest) {
        
        return conexion.eliminarRest(rest);
    }
    
      public Restaurante getRestauranteByName(String pl){
        return conexion.getRestauranteByName(pl);
    }

   
    

  
    
}
