/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import ejb.TransaccionBeanRemote;
import java.util.Properties;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author montanez
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean{
    
    private TransaccionBeanRemote prueba;
    private String text;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() throws NamingException {
        //super();
        Properties properties = new Properties();
        properties.setProperty("org.omg.CORBA.ORBInitialHost", "10.192.230.43");
        properties.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
        InitialContext ctx = new InitialContext(properties);
        prueba = (TransaccionBeanRemote)ctx.lookup("java:global/NegocioALI/TransaccionBean");
    }
    
    public String getText(){
        return this.text;
    }
    
    public void setText(String text){
        this.text = text;
    }
    
    public String buttonPerform(){
        System.out.println(prueba.prueba(text));
        return "";
    }
    
    
    
}
