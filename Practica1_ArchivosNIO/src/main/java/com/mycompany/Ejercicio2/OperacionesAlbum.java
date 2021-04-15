/*
/*
 * PRACTICA 1-MANEJO DE ARCHIVOS
 * EJERCICIO 2 (Composicion)
 * EST. FERMIN CONDORI PAUCARA
 */
package com.mycompany.Ejercicio2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionesAlbum {
    private Album album;
    private Cancion cancion;
    Scanner leer=new Scanner(System.in);
    
    private List<Album> listaAlbumes;

    public OperacionesAlbum() {
        listaAlbumes=new ArrayList<>();
    }

    
    //metodos
    public void adicionarAlbum(Album album){
        listaAlbumes.add(album);
        System.out.println("Adicionando el album");
    }
    
    public void crearAlbum(){
        album=new Album();
        boolean continuar=true;
        System.out.println("Digite el nombre de album");
        album.setNombre(leer.nextLine());
        System.out.println("Digite el nombre de artista");
        album.setArtista(leer.nextLine());
        System.out.println("Digite el formato");
        album.setFormato(leer.nextLine());
        do{
            cancion=new Cancion();
            System.out.println("Digite el nombre de cancion");
            cancion.setNombreCancion(leer.nextLine());
            System.out.println("Digite la duracion");
            cancion.setDuracion(leer.nextFloat());
            leer.nextLine();
            System.out.println("Digite el genero");
            cancion.setGenero(leer.nextLine());
            album.adicionarCancion(cancion);
            System.out.println("¿Desea agregar otra cancion?(s/n)");
            String r=leer.nextLine();
            if(r.equalsIgnoreCase("n")){
                continuar=false;
            }
        }while(continuar);
        adicionarAlbum(album);
    }
    
    public void mostrarDatos(){
        if(listaAlbumes!=null){
            System.out.println("---LISTA DE ALBUMES---");
            for(Album alb:listaAlbumes){
                System.out.println("********ALBUM********");
                System.out.println("Nombre: "+alb.getNombre());
                System.out.println("Artista: "+alb.getArtista());
                System.out.println("Formato: "+alb.getFormato());
                alb.mostrarAlbum();
            }
        } 
        else{
            System.out.println("Lista vacia...");
        }
    }
    
    public void buscarCancion(){
        int sw=0;
        if(album!=null && album.getListaCanciones().size()>0){
            System.out.println("Ingrese el nombre de la cancion");
            String nombre=leer.nextLine();
            for(Album buscar:listaAlbumes){
                for(Cancion cancion:buscar.getListaCanciones()){
                    if(cancion.getNombreCancion().equalsIgnoreCase(nombre)){
                        sw=1; 
                        System.out.println("Nombre Cancion: "+nombre);
                        System.out.println("--------------------------");
                        System.out.println("Album: "+buscar.getNombre());
                        System.out.println("Artista: "+buscar.getArtista());
                        break;
                    }
                }
            }
            if(sw==0){
                System.out.println("La cancion "+nombre+" no existe dentro de un album");
            }
        }
        else{
            System.out.println("Lista vacia...");
        }
    }
    
    public void mostrarAlbum(){
        int sw=0;
        if(album!=null && album.getListaCanciones().size()>0){
            System.out.println("Ingrese el nombre de album");
            String nombre=leer.nextLine();
            for(Album albums:listaAlbumes){
                if(albums.getNombre().equalsIgnoreCase(nombre)){
                    sw=1; 
                    albums.mostrarAlbum();
                }
            }
            if(sw==0){
                System.out.println("El album "+nombre+" no existe");
            }
        }
        else{
            System.out.println("Lista vacia...");
        }
    }
    
    public void eliminarAlbum(){
        int sw=0,i=-1;
        if(listaAlbumes!=null){
            System.out.println("Ingrese el nombre de album a eliminar");
            String nombre=leer.nextLine();
            for(Album albums:listaAlbumes){
                i++;
                if(albums.getNombre().equalsIgnoreCase(nombre)){
                    sw=1; 
                    listaAlbumes.remove(i);
                    System.out.println("Album eliminada...");
                    break;
                }
            }
            if(sw==0){
                System.out.println("El album "+nombre+" no existe");
            }
        }
        else{
            System.out.println("Lista vacia...");
        }
    }
    
    
    //CREAR ARCHIVO
    public void crearArchivo(){
        Path path=Paths.get("E:\\programacionIII\\archivoAlbum.txt");
        try{
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("El archivo Creado");
            }
            else{
                System.out.println("Ya existe el archivo");
            }
        }catch(Exception e){
            System.out.println("El archivo no fue creado!!");
        }
    }
    
    //guardando la lista cliente dentro de un archivo con anterioridad
    public int guardarObjetos(){
        int sw=1;
        String ruta="E:\\programacionIII\\archivoAlbum.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaAlbumes);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesAlbum.class.getName()).log(Level.SEVERE,null, ex);
            sw=0;
        }catch(IOException em){
            Logger.getLogger(OperacionesAlbum.class.getName()).log(Level.SEVERE,null, em);
            sw=0;
        }
        return sw;
    }
    
    public void leerAlbum(){
        String ruta="E:\\programacionIII\\archivoAlbum.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaAlbumes=(List<Album>)ois.readObject();
            }
            else{
                System.out.println("El objeto es nulo");
            }
        }catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesAlbum.class.getName()).log(Level.SEVERE,null, e);
        
        }catch(IOException ex){
            Logger.getLogger(OperacionesAlbum.class.getName()).log(Level.SEVERE,null, ex);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(OperacionesAlbum.class.getName()).log(Level.SEVERE,null, ex);
        }
   }
    
}
