/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cintermedia.ALIWebIntermedia;
import entities.Plato;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author sala-a
 */
@Named(value = "mostrarPlato")
@SessionScoped
public class MostrarPlatos implements Serializable{
    
    List<Plato> listaPlatos;
    Plato pl;
    String name;
    ALIWebIntermedia intermedia;
    String text;
    /**
     * Creates a new instance of AdminPlato
     */
    public MostrarPlatos() throws Exception {
        listaPlatos = new ArrayList<>();
        pl = new Plato();
        intermedia = new ALIWebIntermedia();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public Plato getPl() {
        return pl;
    }

    public void setPl(Plato pl) {
        this.pl = pl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Plato> getListaPlatos() {
        return listaPlatos;
    }

    public void setListaPlatos(List<Plato> listaPlatos) {
        this.listaPlatos = listaPlatos;
    }

    public Plato getP() {
        return pl;
    }

    public void setP(Plato p) {
        this.pl = p;
    }
    
    public String agregar(Plato p){
        pl = p;
        System.out.println(pl.getNombre());
        return "";
    }
    
    public String buscar(){
        System.out.println(name);
        listaPlatos = intermedia.getPlatos(name);
        return "";
    }
    
    public String eliminar(){
        boolean b = intermedia.eliminarPlato(pl);
        System.out.println("------------->"+pl.getNombre());
        Plato pAux = intermedia.getPlatoByName(pl.getNombre());
        if(pAux == null){
            
            text = "Plato con nombre: "+ pl.getNombre() + " eliminado con exito.";
        }else
            text = "Plato con nombre: "+ pl.getNombre() + " no pudo ser elimincado.";
        return"informacion.xhtml";
    }
    
    public String editar_crear(){
        return "formulario.xhtml";
    }
    
    public String botonRegresar(){
        listaPlatos = new ArrayList<>();
        return "mostrarPlatos.xhtml";
    }
    
    public String editar(Plato p){
        System.out.println("La nueva informacion de su plato : \nID: "+ p.getId()+"\nNombre: "+p.getNombre()+"\nPrecio: "+p.getPrecio()+"\nDescripción: "+p.getDescripcion()+"\n");
        intermedia.editarPlato(p);
        text = "La nuva informacion de su plato : \nID: "+ p.getId()+"\nNombre: "+p.getNombre()+"\nPrecio: "+p.getPrecio()+"\nDescripción: "+p.getDescripcion()+"\n";
        
        return "informacion.xhtml";
    }
}
