/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.ordenamiento;

import java.util.Arrays;

/**
 *
 * @author mdominguez
 */
public class OrdenarRadix extends OrdenadorService{
    
    @Override
    public ArregloDied ordenar(ArregloDied arrDesordenado) {
        arregloOrdenado = arrDesordenado.clonar();
        arregloOrdenado.inicializarContadores();
        
        long m = arregloOrdenado.getMax();  //Busco el número más grande
        String x = Long.toString(m);    //Lo convierto en una cadena
        int ndig= x.length();               //Saco la longitud de la cadena (cant. de cifras)
        
        long peso = 1;
        
        ColaDied urnas[] = new ColaDied[10];
        for (int i=0; i<10; i++)
            urnas[i] = new ColaDied(arregloOrdenado.tamanio());
        int d;
        for(int i=0; i<ndig; i++){
            for(int j=0; j<arregloOrdenado.tamanio(); j++){
                d= (int)((arregloOrdenado.get(j).valorOrdenamiento()/peso) %10);
                urnas[d].enqueue(arregloOrdenado.get(j));
            }
            
            int l=0;
            for(int k=0;k<10;k++){
                while(urnas[k].getCima() > 0){
                     arregloOrdenado.agregarEnPosicion(l,urnas[k].dequeue());
                     l++;
                }
            }
        
            peso *= 10;
        
        }
        
        return arregloOrdenado;
 
    } 

    
}
