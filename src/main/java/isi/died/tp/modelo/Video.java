/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;


/**
 *
 * @author st
 */
public class Video extends MaterialCapacitacion{

   
    private int segundos;
    private double costo;
    
    public Video(){
        
    }
    
    public Video(int segundos, double costo, String titulo) {
        this.titulo = titulo;
        this.segundos = segundos;
        this.costo = costo;
        this.estado = EstadoPromocion.REGULAR;
    }
    
     public int getSegundos() {
        return segundos;
    }

    public double getCosto() {
        return costo;
    }
    
    @Override
    public Double precio(){
        double precio = 0.0;
        switch(this.estado){
            case REGULAR:
                precio = this.costo * this.segundos;
                break;
            case OFERTA:
               precio = (this.costo * this.segundos)/2;
                break;
        }
        return precio;       
    }
    
    @Override
    public void liquidar() {
        this.estado = EstadoPromocion.OFERTA;
    }

    @Override
    public Long valorOrdenamiento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public boolean equals(Object o){
        return(o instanceof Video && ((Video)o).titulo.equalsIgnoreCase(this.titulo));
    }
    
}
