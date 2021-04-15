/*
 * PRACTICA 1-MANEJO DE ARCHIVOS
 * EJERCICIO 4
 * EST. FERMIN CONDORI PAUCARA
 */
package com.mycompany.Ejercicio4;

public class DispositivoAlmacenamiento {
    //atributos
    private String marca;
    private double capacidad;
    private double espacioDisponible;
    //constructor
    //metodos
    public void mostrar(){
        System.out.println("Marca: "+this.marca);
        System.out.println("Capacidad: "+this.capacidad);
        System.out.println("Espacio disponible: "+this.espacioDisponible);
    }
    //getter y setter

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(double capacidad) {
        this.capacidad = capacidad;
    }

    public double getEspacioDisponible() {
        return espacioDisponible;
    }

    public void setEspacioDisponible(double espacioDisponible) {
        this.espacioDisponible = espacioDisponible;
    }
    
    
}
