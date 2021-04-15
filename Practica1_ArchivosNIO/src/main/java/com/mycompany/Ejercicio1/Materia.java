/*
 * PRACTICA 1-MANEJO DE ARCHIVOS
 * EJERCICIO 1 (Asociacion)
 * EST. FERMIN CONDORI PAUCARA
 */
package com.mycompany.Ejercicio1;

import java.io.Serializable;

public class Materia implements Serializable{
    static final long serialVersionUID=43L;
    
    //Atributos
    private String nombreMateria;
    private int anioMateria;
    private int horaMateria;
    
    //metodos
    public void mostrar(){
        System.out.println("Nombre: "+this.nombreMateria);
        System.out.println("Año: "+this.anioMateria);
        System.out.println("Hora: "+this.horaMateria);
    }
    
    //getter y setter

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getAnioMateria() {
        return anioMateria;
    }

    public void setAnioMateria(int anioMateria) {
        this.anioMateria = anioMateria;
    }

    public int getHoraMateria() {
        return horaMateria;
    }

    public void setHoraMateria(int horaMateria) {
        this.horaMateria = horaMateria;
    }
    
    
}
