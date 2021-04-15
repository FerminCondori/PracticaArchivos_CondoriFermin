/*
/*
 * PRACTICA 1-MANEJO DE ARCHIVOS
 * EJERCICIO 2 (Composicion)
 * EST. FERMIN CONDORI PAUCARA
 */
package com.mycompany.Ejercicio2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Album implements Serializable{
    static final long serialVersionUID=43L;
    
    //atributos
     private String nombre;
    private String artista;
    private String formato;
    //definicion de composicion
    private List<Cancion> listaCanciones;

    public Album() {
        listaCanciones=new ArrayList<>();
    }
    
    public void mostrarAlbum(){
        if(listaCanciones.size()>0){
            int i=1;
            System.out.println("------CANCIONES--------");
            System.out.println("Nro.\t Nombre "+"\t Duracion "+"\t Genero");
        System.out.println("--------------------------------------------");
            for(Cancion cancion:listaCanciones){
                System.out.print(i+".- ");i++;
                cancion.mostrarCancion();
            }
        }
    }
    
    public void adicionarCancion(Cancion cancion){
        listaCanciones.add(cancion);
        System.out.println("Adicionando la cancion al album");
    }
    
    //getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public List<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(List<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }
}
