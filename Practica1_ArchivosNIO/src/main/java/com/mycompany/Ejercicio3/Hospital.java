/*
/*
 * PRACTICA 1-MANEJO DE ARCHIVOS
 * EJERCICIO 3 (Agregacion)
 * EST. FERMIN CONDORI PAUCARA
 */
package com.mycompany.Ejercicio3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hospital implements Serializable{
    static final long serialVersionUID=43L;
    //atributos
    private String nombre;
    private String direccion;
    private int nivel;
    //definiendo la agregacion
    private List<Especialidad> listaEspecialidad;
    
    //constructor
    public Hospital() {
        listaEspecialidad=new ArrayList<>();
    }
    
    //metodos
    public void adicionarEspecialidad(Especialidad esp){
        listaEspecialidad.add(esp);
        System.out.println("Especialidad Registrada...");
    }
    
    public void mostrar(){
        int i=1;
        System.out.println("Nombre del Hospital: "+this.nombre);
        System.out.println("Direccion: "+this.direccion);
        System.out.println("Nivel: "+this.nivel);
        //mostrando especialidades registradas
        if(listaEspecialidad.size()>0){
            System.out.println("----ESPECIALIDADES----");
            for(Especialidad esp:listaEspecialidad){
                System.out.print(i+".- ");
                esp.mostrar();
                i++;
            }
        }
        else{
            System.out.println("No tiene especialidades registradas...");
        }
    }
    
    //getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<Especialidad> getListaEspecialidad() {
        return listaEspecialidad;
    }

    public void setListaEspecialidad(List<Especialidad> listaEspecialidad) {
        this.listaEspecialidad = listaEspecialidad;
    }
    
}
