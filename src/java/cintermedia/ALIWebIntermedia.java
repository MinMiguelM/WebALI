/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cintermedia;


import entities.Plato;
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
        properties.setProperty("org.omg.CORBA.ORBInitialHost", "10.192.10.15");
        properties.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
        InitialContext ctx = new InitialContext(properties);
        conexion = (ConexionBeanRemote)ctx.lookup("java:global/NegocioALI/ConexionBean");
    }
    
    public List<Plato> getPlatos(String s) {
        
        List<Plato> listP= conexion.getPlatos(s);
        return listP;
    }
    
    public int pago(Usuario u, List<Plato> p){
        return conexion.pago(u, p);
    }

  
    
}
