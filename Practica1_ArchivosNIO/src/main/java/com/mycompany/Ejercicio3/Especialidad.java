/*
/*
 * PRACTICA 1-MANEJO DE ARCHIVOS
 * EJERCICIO 3(Agregacion)
 * EST. FERMIN CONDORI PAUCARA
 */
package com.mycompany.Ejercicio3;

import java.io.Serializable;

public class Especialidad implements Serializable{
    static final long serialVersionUID=47L;
    //atributos
    private String nomEspecialidad;
    
    //metodos
    public void mostrar(){
        System.out.println(this.nomEspecialidad);
    }
    
    //getter y setter

    public String getNomEspecialidad() {
        return nomEspecialidad;
    }

    public void setNomEspecialidad(String nomEspecialidad) {
        this.nomEspecialidad = nomEspecialidad;
    }
    
}
