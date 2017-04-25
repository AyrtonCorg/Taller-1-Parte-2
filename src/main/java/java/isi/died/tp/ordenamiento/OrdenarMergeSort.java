/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.ordenamiento;

/**
 *
 * @author mdominguez
 */
public class OrdenarMergeSort extends OrdenadorService{

    @Override
    public ArregloDied ordenar(ArregloDied arrDesordenado) {
        arregloOrdenado = arrDesordenado.clonar();
        arregloOrdenado.inicializarContadores();
                   
        return mergesort(arregloOrdenado, 0,arregloOrdenado.tamanio()-1);
    }
    
    
    public ArregloDied mergesort(ArregloDied a, int primero, int ultimo){
        int central;
        if(primero < ultimo){
            central = primero + (ultimo-primero)/2;
            mergesort(a, primero, central);
            mergesort (a, central+1, ultimo);
            mezcla (a, primero, central, ultimo);
        }
        return a;
    }
    
   
    public void mezcla(ArregloDied a, int izq, int medio, int der){
        ArregloDied tmp = new ArregloDied(a.tamanio());
        int i, k, z;
        i = z = izq;//k
        k = medio + 1;//j
        
        // Copy both parts into the helper array
                
                tmp = a.clonar();
                // Copy the smallest values from either the left or the right side back
                // to the original array
                while (i <= medio && k <= der) {
                        if (tmp.mayorIgual(k,i)) {
                                a.agregarEnPosicion(z,tmp.get(i));
                                i++;
                        } else {
                            a.agregarEnPosicion(z,tmp.get(k));
                                k++;
                        }
                        z++;
                }
                // Copy the rest of the left side of the array into the target array
                while (i <= medio) {
                        a.agregarEnPosicion(z,tmp.get(i));
                        z++;
                        i++;
                }

        

       /* while (i <= medio && k <= der){
            if (a.mayorIgual(k, i)){
                tmp.agregarEnPosicion(z, a.get(i));
                i++;
            }else{
                tmp.agregarEnPosicion(z, a.get(k));
                k++;
            }
             z++;
        }
        
        while(i <= medio){
            tmp.agregarEnPosicion(z, a.get(i));
            z++;
            i++;
        }
        while (k <= der){
            tmp.agregarEnPosicion(z, a.get(k));
            z++;
            k++;
        }
        return tmp;
    } */
}

}