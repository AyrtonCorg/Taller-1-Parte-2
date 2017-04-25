/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

/**
 *
 * @author mdominguez
 */
public final class Suscriptor {
    private String nombre;

    // a. crear una constante CAPACIDAD_DOCUMENTOS q permite determinar la cantidad MAXIMA 
    // de documentos que puede tener una biblioteca
    private final Integer CAPACIDAD_DOCUMENTOS = 5;

    // definir un arreglo que permita almacenar documentos
    private MaterialCapacitacion[] material;    
    
    // definir una variable que determine cual es el presupuesto de la biblioteca
    private Double credito;
    
    // definir una variable de control para saber cuantos documentos tiene la biblioteca
    private Integer cantidadDocumentos;
    
    public Suscriptor(){
        this.material = new MaterialCapacitacion[CAPACIDAD_DOCUMENTOS];
        cantidadDocumentos=0;
        credito=0.0;
    }    
    
    public Suscriptor(String nombre){
        this();
        this.nombre=nombre;
    }       

    public Double getCredito() {
        return credito;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }
    
    public void listarSuscripciones(){
         System.out.println("SUSCRIPCIONES DEL USUARIO");       
         for(MaterialCapacitacion unMaterial: this.material){
             if(unMaterial!=null){
                 System.out.println("     >"+unMaterial.getTitulo());
             }
         }
    }
    
    public void agregar(MaterialCapacitacion d){
        // implementar el método agregar documentos que agrega un documento a la biblioteca solamente
        // si hay presupuesto disponible
        if(d.precio() <= this.credito && this.cantidadDocumentos < 5){
            this.material[this.cantidadDocumentos] = d;
            d.suscribir();
            this.credito = this.credito - d.precio();
            this.cantidadDocumentos++;
        }else{
            System.out.println("\nNo se pudo agregar el Material de Capacitacion.");
        }
    }

    public void quitar(MaterialCapacitacion d){
      // implementar el metodo
      boolean esta = false;
      for(int i=0; i<this.cantidadDocumentos; i++){
          if(this.material[i] == d && esta==false){
            esta=true;  
           }
          if(i<this.cantidadDocumentos-1 && esta==true){
            this.material[i]=this.material[i+1];
           }        
        }
      if(esta==true){
        this.material[this.cantidadDocumentos-1]=null;
        this.cantidadDocumentos--;
        this.credito += d.precio();
      }else
        System.out.println("\nNo se pudo quitar el Material de Capacitacion porque no se encuentra suscrito.");  
      }
      
       
    
    /*private Double costo(){
        Double totalizador = 0.0;
        for(MaterialCapacitacion d:this.material){
            if(d!=null)totalizador +=d.precio();
        }
        return totalizador;
    }*/
    
    //Sacamos esta parte porque sino no funciona nuestro codigo en la forma que lo pensamos.

    public Double disponible(){
        return this.credito/*-costo()*/;
    }

    @Override
    public String toString() {
        return "Suscriptor{" + "nombre=" + nombre + ", credito=" + credito + '}';
    }

    

}
