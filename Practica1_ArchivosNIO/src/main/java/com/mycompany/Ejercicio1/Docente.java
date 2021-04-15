/*
 * PRACTICA 1-MANEJO DE ARCHIVOS
 * EJERCICIO 1 (Asociacion)
 * EST. FERMIN CONDORI PAUCARA
 */
package com.mycompany.Ejercicio1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Docente implements Serializable {
    static final long serialVersionUID=42L;
    
    //atributos
    private String nombre;
    private String paterno;
    private String materno;
    private String titulo;
    private int cargaHoraria;
    //relacionar las dos clases, el docente tiene  la materia
    //private Materia materia;
    private List<Materia> listaMaterias;
    //constructor
    public Docente() {
        listaMaterias=new ArrayList<>();
    }
    
    //metodos
    public void adicionarMaterias(Materia materia){
        listaMaterias.add(materia);
        System.out.println("Materia agregada...");
    }
    
    public void mostrar(){
        System.out.println("******* DOCENTE *******");
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Paterno: "+this.paterno);
        System.out.println("Materno: "+this.materno);
        System.out.println("Titulo: "+this.titulo);
        System.out.println("Carga Horaria: "+this.cargaHoraria);
        //mostrar todas las materias asignadas
        System.out.println("------- MATERIAS ---------");
        if(listaMaterias.size()>0){
            for(Materia mat:listaMaterias){
                mat.mostrar();
                System.out.println("....................");
            }
        }
        else{
            System.out.println("No tiene materias asignadas...");
        }
        System.out.println("***********************");
    }
    
    //getter y setter
    public List<Materia> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(Materia materia) {
        this.listaMaterias.add(materia);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    
}
