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
@Named(value = "mostrarRestaurante")
@SessionScoped
public class MostrarRestaurante implements Serializable{

    List<Restaurante> listaRest;
    List<Plato> listaP;
    Restaurante rest;
    String nombreRest;
    ALIWebIntermedia intermedia;
    String text;
    /**
     * Creates a new instance of MostrarRestaurante
     */
    
    // CONSTRUCTOR RESTAURANTE
    public MostrarRestaurante() throws Exception {
        listaRest = new ArrayList<>();
         listaP = new ArrayList<>();
         rest = new Restaurante();
        intermedia = new ALIWebIntermedia();
        
    }
    
    
    //Metodos
    
    public String buscarRest(){
        listaRest = intermedia.getRestaurantes(nombreRest);
        return "";
    }
    
    public String mostrarP(){
        System.out.println("here: "+rest.getNombre());
        listaP = intermedia.getRestauranteByName(rest.getNombre()).getPlatoList();
        return "";
    }
   
  /*  public void guardarP(Plato p)
            
    {
    rest.getPlatoList().add(p);
    }*/
            
          
    
    public String editarRestaurante(Restaurante p){
        System.out.println("La nueva informacion de su restaurante es: \nID: "+ p.getId()+"\nNombre: "+p.getNombre()+"\nDirección: "+p.getDireccion()+"\nDescripción: "+p.getDireccion()+"\n");
    
        intermedia.editarRestaurante(p);
        text = "La nuva informacion de su plato : \nID: "+ p.getId()+"\nNombre: "+p.getNombre()+"\nDirección: "+p.getDireccion()+"\nDescripción: "+p.getDireccion()+"\n";

        return "informacionRest.xhtml";
    }
    
      public String botonRegresar(){
          
        listaRest = new ArrayList<>();
        listaP=new ArrayList<>();
        
   
        return "mostrarRest.xhtml";
    }
      
      public String agregar(Restaurante p){
        rest = p;
        System.out.println(rest.getNombre());
        return "";
    }
    
      
    public String editar_crear(){
        
     
        return "formularioRest.xhtml";
    }
    
    public String platosRest(){
       
        return "mostrarPlatos.xhtml";
    }
    
     public String agregarRestaurante(Restaurante p) throws Exception{
       
       System.out.println("El restaurante se agregó");
       intermedia.agregarRestaurante(p);
       text = "El Restaurante agregado es : \nID: "+ p.getId()+"\nNombre: "+p.getNombre()+"\nDirección: "+p.getDireccion()+"\nDescripción: "+p.getDescripcion()+"\n";
        
        return "informacionRest.xhtml";
    }
    
   public String eliminarRest(){
        boolean b = intermedia.eliminarRest(rest);
        System.out.println("------------->"+rest.getNombre());
        Restaurante pAux = intermedia.getRestauranteByName(rest.getNombre());
        if(pAux == null){
            
            text = "Restaurante con nombre: "+ rest.getNombre() + " eliminado con exito.";
        }else
            text = "Restaurante con nombre: "+ rest.getNombre() + " no pudo ser eliminado.";
        
        return"informacionRest.xhtml";
    }
   

    
     
    

  

    public String getNombreRest() {
        return nombreRest;
    }

    // GET Y SET

    public List<Plato> getListaP() {
        return listaP;
    }

    public void setListaP(List<Plato> listaP) {
        this.listaP = listaP;
    }
    
    
    public void setNombreRest(String nombreRest) {
        this.nombreRest = nombreRest;
    }

    public List<Restaurante> getListaRest() {
        return listaRest;
    }

    public void setListaRest(List<Restaurante> listaRest) {
        this.listaRest = listaRest;
    }

    public Restaurante getRest() {
        return rest;
    }

    public void setRest(Restaurante rest) {
        this.rest = rest;
    }

    public String getName() {
        return nombreRest;
    }

    public void setName(String name) {
        this.nombreRest = name;
    }

    public ALIWebIntermedia getIntermedia() {
        return intermedia;
    }

    public void setIntermedia(ALIWebIntermedia intermedia) {
        this.intermedia = intermedia;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    
    
}
