/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author mdominguez
 */
public class Libro extends MaterialCapacitacion{
    private Double costo;
    private String isbn;
    private Integer paginas;
    
    public Libro() {
    }    

    public Libro(String titulo, Double costo, String isbn, Integer paginas) {
        this.titulo = titulo;
        this.costo = costo;
        this.isbn = isbn;
        this.paginas = paginas;
        this.estado = EstadoPromocion.ACCESO_TEMPRANO;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public Date getFechaPublicacion(){
        return this.fechaPublicacion;
    }
    
    public void publicar(String cadena) throws ParseException{
        this.estado = EstadoPromocion.LANZAMIENTO;
        super.publicar(cadena);
    }
        
    public void publicar(Date fechaEspecifica){
        this.estado = EstadoPromocion.LANZAMIENTO;
        this.fechaPublicacion = fechaEspecifica;
    }
    
    @Override
    public Double precio(){
        double precio = 0.0;
        switch(this.estado){
            case REGULAR:
                precio = this.costo + this.costo*(this.paginas/150)*0.03;
                break;
            case ACCESO_TEMPRANO:
                precio = (this.costo + this.costo*(this.paginas/150)*0.03)*0.9;
                break;
            case LANZAMIENTO:
                precio = (this.costo + this.costo*(this.paginas/150)*0.03)*1.2;
                break;
            case OFERTA:
                precio = this.costo*0.8;
                break;
        }
        return precio;       
    }
          
    @Override
    public void liquidar() {
        this.estado = EstadoPromocion.OFERTA;
    }
    
    @Override
    public void suscribir(){
        super.suscribir();
        if(this.suscripciones() >= 2){
            this.estado = EstadoPromocion.REGULAR;
        }
    }

    @Override
    public Long valorOrdenamiento() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return super.valorOrdenamiento();
    }

    @Override
    public boolean equals(Object o){
        return(o instanceof Libro && ((Libro)o).titulo.equalsIgnoreCase(this.titulo));
    }
    
}