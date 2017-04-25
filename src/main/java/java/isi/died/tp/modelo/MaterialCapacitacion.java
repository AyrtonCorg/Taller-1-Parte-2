/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import isi.died.tp.ordenamiento.Ordenable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author mdominguez
 */
public abstract class MaterialCapacitacion implements Ordenable {
    protected String titulo;
    protected EstadoPromocion estado;
    protected Date fechaPublicacion;
    private Integer suscripciones;

    public MaterialCapacitacion() {
        this.suscripciones=0;
    }       

    public MaterialCapacitacion(String titulo) {
        this();
        this.titulo = titulo;
    } 
       
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }   
    
    
    protected Integer suscripciones(){
        return this.suscripciones;
    }
   
    public void publicar(){
        this.estado = EstadoPromocion.LANZAMIENTO;
        this.fechaPublicacion = new Date();
    }
    
    public abstract Double precio();

    public abstract void liquidar();
    
    public void suscribir(){
        suscripciones++;
    }
    
    public final void cancelarSuscripcion(){
        suscripciones--;
    }
    
    @Override
    public boolean equals(Object o){
        return(o instanceof MaterialCapacitacion && ((MaterialCapacitacion)o).titulo.equalsIgnoreCase(this.titulo));
    }
    
    public void publicar(String cadena) throws ParseException{
        Calendar c = new GregorianCalendar();
        Calendar c_today = new GregorianCalendar();
        Date ahora = new Date();
        c_today.setTime(ahora);
        
        String format = "dd/MM/yyyy";
        DateFormat df = new SimpleDateFormat(format);
        Date fecha_comparacion = new Date();
        fecha_comparacion = df.parse(cadena);
        c.setTime(fecha_comparacion);
        
        if(c.get(Calendar.DAY_OF_YEAR)-45<c_today.get(Calendar.DAY_OF_YEAR)&& ((c.get(Calendar.DAY_OF_WEEK)!= 1) && (c.get(Calendar.DAY_OF_WEEK)!= 7))){
           this.fechaPublicacion= df.parse(cadena); 
        }else{
            this.fechaPublicacion= ahora; 
        }
                
    }
    
    @Override
    public Long valorOrdenamiento(){
        return Long.valueOf(numerarString(this.titulo)+""+formatoPrecio(this.precio()));
    }     
    
    private Long formatoPrecio(Double precio){
        Long precioEntero = Math.round(precio);
        Long x = precioEntero%10000 ;
        Long formato = 10000+ x;
        return formato;
    }
    
    private Long numerarString(String arg){
        String origen = arg.toUpperCase();
        String resultado = "";
        char unChar ;
        for(int i =0;i<4;i++){
            Integer aux;
            if(i>origen.length()-1) aux = 37;
            else {
                unChar = origen.charAt(i);
                if(unChar>='A' && unChar <='Z'){
                    aux = unChar-54;
                }else{
                    aux = 38;
                } 
            }
            resultado +=aux;
        }
        return Long.valueOf(resultado);
    }
}