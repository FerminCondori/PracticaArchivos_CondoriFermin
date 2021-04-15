/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio3;

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

/**
 *
 * @author FERMIN
 */
public class OperacionesHospital {
    private Hospital hospital;
    //agregacion
    private Especialidad especialidad;
    private List<Hospital> listaHospital;
    Scanner leer=new Scanner(System.in);
    
    //constructor

    public OperacionesHospital() {
        listaHospital=new ArrayList<>();
    }
    
    
    //metodos
    public void registrarHospital(){
        hospital=new Hospital();
        boolean continuar=true;
        System.out.println("Digite el nombre ");
        hospital.setNombre(leer.nextLine());
        System.out.println("Digite la direccion ");
        hospital.setDireccion(leer.nextLine());
        System.out.println("Digite el nivel");
        hospital.setNivel(leer.nextInt());
        leer.nextLine();
        do{
            agregarEspecialidad(hospital);
            System.out.println("¿Desea Introducir otra especialidad?(s/n)");
            String r=leer.nextLine();
            if(r.equalsIgnoreCase("n")){
                continuar=false;
            }
        }while(continuar);
        
        agregarHospital(hospital);
        System.out.println("Hospital Registrado...");
    }
    
    public void mostrarHospital(){
        if(listaHospital.size()>0){
            System.out.println("---------------");
            for(Hospital hosp:listaHospital){
                hosp.mostrar();
                System.out.println("---------------");
            }
        }
    }
    
    public void agregarHospital(Hospital hosp){
        listaHospital.add(hosp);
    }
    public void agregarEspecialidad(Hospital hospt){
        especialidad=new Especialidad();
        System.out.println("Nombre de la especialidad ");
        especialidad.setNomEspecialidad(leer.nextLine());
        //registrando la especialidad en la lista de especialidad
        hospt.adicionarEspecialidad(especialidad);
    }
    
    public void agregarEspecialidadHospital(String nombre){
        if(listaHospital.size()>0){
            boolean cont=true;
            int sw=0;
            for(Hospital hosp:listaHospital){
                if(hosp.getNombre().equalsIgnoreCase(nombre)){
                    do{
                        agregarEspecialidad(hosp);
                        System.out.println("¿Desea Introducir otra especialidad?(s/n)");
                        String r=leer.nextLine();
                        if(r.equalsIgnoreCase("n")){
                            cont=false;
                        }
                    }while(cont);
                    sw=1;
                }
            }
            if(sw==0){
                System.out.println("No tiene Hospital registrado");
            }
            
        }
        else{
            System.out.println("No tiene hospital registrado");
        }
    }
    
    public void mostrarEspecialidadHospital(String nombre){
        if(listaHospital.size()>0){
            int sw=0;
            System.out.println("---------------");
            for(Hospital hosp:listaHospital){
                if(hosp.getNombre().equalsIgnoreCase(nombre)){
                    hosp.mostrar();
                    System.out.println("---------------");
                    sw=1;
                } 
            }
            if(sw==0){
                System.out.println("No tiene hospital registrado");
            }
        }
    }
    
    public void listarHospitalEsp(String espc){
        if(listaHospital.size()>0){
            int sw=0,i=1;
            System.out.println("*****Hospitales*****");
            for(Hospital hosp:listaHospital){
                for(Especialidad esp:hosp.getListaEspecialidad()){
                    if(esp.getNomEspecialidad().equalsIgnoreCase(espc)){
                        System.out.println(i+".- Hospital: "+hosp.getNombre());
                        System.out.println(" *Direccion: "+hosp.getDireccion());
                        sw=1;
                        i++;
                    }
                }
            } 
            if(sw==0){
                System.out.println("No tiene hospital registrado");
            }
            System.out.println("----------------------");
        }
    }
    
    //CREANDO ARCHIVO
     public void crearArchivo(){
        Path path=Paths.get("E:\\programacionIII\\archivoHospital.txt");
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
        String ruta="E:\\programacionIII\\archivoHospital.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(listaHospital);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OperacionesHospital.class.getName()).log(Level.SEVERE,null, ex);
            sw=0;
        }catch(IOException em){
            Logger.getLogger(OperacionesHospital.class.getName()).log(Level.SEVERE,null, em);
            sw=0;
        }
        return sw;
    }
    
    public void leerHospitales(){
        String ruta="E:\\programacionIII\\archivoHospital.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                listaHospital=(List<Hospital>)ois.readObject();
            }
            else{
                System.out.println("El objeto es nulo");
            }
        }catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesHospital.class.getName()).log(Level.SEVERE,null, e);
        
        }catch(IOException ex){
            Logger.getLogger(OperacionesHospital.class.getName()).log(Level.SEVERE,null, ex);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(OperacionesHospital.class.getName()).log(Level.SEVERE,null, ex);
        }
   }
    
}
