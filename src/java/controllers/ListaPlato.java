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
import static java.awt.SystemColor.window;
import java.io.Serializable;
import java.math.BigInteger;
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
import static jdk.nashorn.internal.objects.NativeFunction.function;

/**
 *
 * @author SALABD
 */
@Named(value = "listaPlatos")
@SessionScoped
public class ListaPlato implements Serializable {

    /**
     * Creates a new instance of ListaPlatos
     */
    List<Plato> listP;
    ALIWebIntermedia intermedia;
    String nombrePlato;
    List<Plato> seleccionPlatos;
    Boolean selected;
    int precioTotal;
    String text;

    public ListaPlato() throws Exception {
        seleccionPlatos = new ArrayList<>();
        listP = new ArrayList<Plato>();
        intermedia = new ALIWebIntermedia();
        precioTotal = 0;
        text = new String();

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

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
        u.setFechaNacimiento("12/6/1990");
        u.setNombre("lalok de andres");
        u.setPasswordmispagos("pass");
        u.setUsuariomispagos("umispagos");
        //System.out.println(intermedia.pago(u, listP));
        if(intermedia.pago(u, listP)>0)
            text = "Transacción exitosa.";
        else
            text = "Transacción sin éxito.";
        return "confirmacionPago.xhtml";
    }

    
    public String buttonAgregar(Plato p) {
        seleccionPlatos.add(p);
        precioTotal += p.getPrecio().intValue();

        System.out.println(precioTotal);
        return "";
    }

    public String eliminar(Plato p) {
        seleccionPlatos.remove(p);
        precioTotal -= p.getPrecio().intValue();
        System.out.println(precioTotal);
        return "";
    }

    public List<Plato> getListP() {
        return listP;
    }
    
    public String buttonRegresar(){
        seleccionPlatos = new ArrayList<>();
        listP = new ArrayList<Plato>();
        precioTotal = 0;
        text = new String();
        return "menuPlatos.xhtml";
    }

}
