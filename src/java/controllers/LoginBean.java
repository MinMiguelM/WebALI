/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

//import ejb.TransaccionBeanRemote;
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
    

    private String usuario;
    private String contrasenia;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() throws NamingException {
        //super();
     
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

 
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    

  
}
