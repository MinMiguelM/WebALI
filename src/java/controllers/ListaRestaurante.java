/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cintermedia.ALIWebIntermedia;
import entities.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author SALABD
 */
@Named(value = "listaRestaurantes")
@SessionScoped
public class ListaRestaurante implements Serializable {
    
    
    //ATRIBUTOS
    List<Restaurante> listR;
    ALIWebIntermedia intermedia;
    String nombreRestaurante;
    String text;
    String nombreRest;

    
    
   // CONSTRUCTOR
    
    
     public ListaRestaurante() throws Exception {
        
        listR = new ArrayList<>();
        intermedia = new ALIWebIntermedia();
        text= new String();
        
              
    }
     
     
     //MÉTODOS
     
     
     
     
     //GETTERS Y SETTERS 

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
     
    public List<Restaurante> getListR() {
        return listR;
    }

    public void setListR(List<Restaurante> listR) {
        this.listR = listR;
    }

    public ALIWebIntermedia getIntermedia() {
        return intermedia;
    }

    public void setIntermedia(ALIWebIntermedia intermedia) {
        this.intermedia = intermedia;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public String getNombreRest() {
        return nombreRest;
    }

    public void setNombreRest(String nombreRest) {
        this.nombreRest = nombreRest;
    }
    


    /**
     * Creates a new instance of ListaRestaurantes
     */
   
    
}
