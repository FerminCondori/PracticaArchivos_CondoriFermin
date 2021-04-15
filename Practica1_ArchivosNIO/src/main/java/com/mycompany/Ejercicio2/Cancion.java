/*
 * PRACTICA 1-MANEJO DE ARCHIVOS
 * EJERCICIO 2 (Composicion)
 * EST. FERMIN CONDORI PAUCARA
 */
package com.mycompany.Ejercicio2;

import java.io.Serializable;

public class Cancion implements Serializable{
    static final long serialVersionUID=43L;
    
    //atributos
     private String nombreCancion;
    private float duracion;
    private String genero;
    
    //metodos
    public void mostrarCancion(){
        System.out.println("\t "+this.nombreCancion+"\t "+this.duracion+"\t "+this.genero);
    }
    
    //getter y setter

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
