/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import cintermedia.ALIWebIntermedia;
import com.sun.codemodel.JExpr;
import com.sun.faces.component.visit.FullVisitContext;
import entities.Plato;
import entities.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.visit.VisitCallback;
import javax.faces.component.visit.VisitContext;
import javax.faces.component.visit.VisitResult;
import javax.faces.context.FacesContext;

/**
 *
 * @author SALABD
 */
@Named(value = "listaPlatos")
@SessionScoped
public class ListaPlato implements Serializable{

    /**
     * Creates a new instance of ListaPlatos
     */
    List<Plato> listP;
    ALIWebIntermedia intermedia;
    String nombrePlato;
    List<Plato> seleccionPlatos;
    Boolean selected;

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    
    
    public List<Plato> getSeleccionPlatos() {
        return seleccionPlatos;
    }

    public void setSeleccionPlatos(List<Plato> seleccionPlatos) {
        this.seleccionPlatos = seleccionPlatos;
    }
    
    public ALIWebIntermedia getIntermedia() {
        return intermedia;
    }

    public void setIntermedia(ALIWebIntermedia intermedia) {
        this.intermedia = intermedia;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public ListaPlato() throws Exception {
        seleccionPlatos = new ArrayList<>();
        listP = new ArrayList<Plato>();
        intermedia = new ALIWebIntermedia();

    }

    public void setListP(List<Plato> listP) {
        this.listP = listP;
    }

    public String buttonPerform() {
        listP = intermedia.getPlatos(nombrePlato);
        return "";
    }
    
    public String buttonPagar() {
        Usuario u = new Usuario();
        u.setCedula("123");
        u.setCorreo("asd");
        u.setFechaNacimiento(new Date());
        u.setNombre("lalok de andres");
        u.setPasswordmispagos("pass");
        u.setUsuariomispagos("umispagos");
        System.out.println(intermedia.pago(u, listP));
        return "pago.xhtml";
    }
    
    /*public UIComponent findComponent(final String id){
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot root = context.getViewRoot();
        final UIComponent [] found = new UIComponent[1];
        
        root.visitTree(new FullVisitContext(context), new VisitCallback() {
            @Override
            public VisitResult visit(VisitContext context, UIComponent target) {
                if(target.getId().equals(id)){
                    found[0] = target;
                    return VisitResult.COMPLETE;
                }
                return VisitResult.ACCEPT;
            }
        });
        return found[0];
    }*/
    
    public void agregarCheckbox(){
        for(int i = 0;i< listP.size();i++){
            List<Boolean> lista = new ArrayList<>();
            lista.add(selected);
        }
       
    }
    
    public String buttonAgregar(Plato p) {
        seleccionPlatos.add(p);
        System.out.println(seleccionPlatos.size());
        return "";
    }
    
    public String eliminar(Plato p){
        seleccionPlatos.remove(p);
        return "";
    }
   

    public List<Plato> getListP() {
        return listP;
    }

}
