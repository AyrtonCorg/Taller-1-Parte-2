/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isi.died.tp.modelo;

import java.util.ArrayList;

/**
 *
 * @author st
 */
public class Portal2 extends Portal {
    
    private ArrayList<MaterialCapacitacion> al_matcap;
    
    public Portal2() {  
        this.al_matcap = new ArrayList<MaterialCapacitacion>();
    }
    
    public void agregar(MaterialCapacitacion m){
        this.al_matcap.add(m);
        super.agregarMaterial(this.al_matcap.size()-1, m);
    }
    
    public ArrayList<MaterialCapacitacion> listar(){
        return this.al_matcap;
    }
}
