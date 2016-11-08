/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author montanez
 */
public class BaseController {
    
    private InitialContext context;
    private final String SERVER_IP = "192.169.0.3";
    
    public BaseController(){
        try{
            /*Properties properties = new Properties();
            properties.put("org.omg.CORBA.ORBInitialHost",SERVER_IP);
            properties.put("org.omg.CORBA.ORBInitialPort","3700");*/
            context = new InitialContext();
        }catch(NamingException e){
            e.printStackTrace();
        }
    }
    
    protected Object lookup(String ejbName){
        try{
            return context.lookup(ejbName);
        }catch(NamingException e){
            e.printStackTrace();
            return null;
        }
    }
    
}
