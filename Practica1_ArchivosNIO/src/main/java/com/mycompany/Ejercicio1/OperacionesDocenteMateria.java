/*
 * PRACTICA 1-MANEJO DE ARCHIVOS
 * EJERCICIO 1(Asociacion)
 * EST. FERMIN CONDORI PAUCARA
 */
package com.mycompany.Ejercicio1;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperacionesDocenteMateria {
    private Docente docente;
    private Materia materia;
    Scanner leer=new Scanner(System.in);
    
    //metodos
    public void crearDocente(){
        docente=new Docente();
        System.out.println("Digite  nombre");
        docente.setNombre(leer.nextLine());
        System.out.println("Digite apellido paterno");
        docente.setPaterno(leer.nextLine());
        System.out.println("Digite apellido materno");
        docente.setMaterno(leer.nextLine());
        System.out.println("Digite apellido titulo");
        docente.setTitulo(leer.nextLine());
        System.out.println("Digite carga horaria");
        docente.setCargaHoraria(leer.nextInt());
        leer.nextLine();
        System.out.println("Docente Registrado...");
    }
    
    public void mostrarDocente(){
        if(docente!=null){
            docente.mostrar();
        }
    }
    
    public void crearMateria(){
        materia=new Materia();
        System.out.println("Digite el nombre de la materia");
        materia.setNombreMateria(leer.nextLine());
        System.out.println("Digite el año de la materia");
        materia.setAnioMateria(leer.nextInt());
        System.out.println("Digite hora de la materia");
        materia.setHoraMateria(leer.nextInt());
        leer.nextLine();
        System.out.println("Materia Creado");
    }
    
    public void mostrarMateria(){
        if(materia!=null){
            materia.mostrar();
        }
    }
    
    //asignacion
    public void asignarMateriaDocente(){
        if(docente!=null && materia!=null){
            docente.setListaMaterias(materia);
            System.out.println("Asignacion realizada");
        }
    }
    
    //CREANDO UN ARCHIVO
    public void crearArchivo(){
        Path path=Paths.get("E:\\programacionIII\\archivoDocente.txt");
        try {
            if(!Files.exists(path)){
                Files.createFile(path);
                System.out.println("El archivo se creo correctamente");
            }
            else{
                System.out.println("El archivo ya existe");
            }
            
        } catch (Exception e) {
        }
        
    }
    
    //GUARDANDO EL DOCENTE CREADO CON ANTERIORIDAD
    public void guardarObjetos(){
        String ruta="E:\\programacionIII\\archivoDocente.txt";
        try {
            FileOutputStream archivo=new FileOutputStream(ruta);
            ObjectOutputStream oos=new ObjectOutputStream(archivo);
            oos.writeObject(docente);
            oos.close();
            archivo.close();
        } catch (FileNotFoundException en) {
            Logger.getLogger(OperacionesDocenteMateria.class.getName()).log(Level.SEVERE,null,en);
        }catch (IOException er) {
            Logger.getLogger(OperacionesDocenteMateria.class.getName()).log(Level.SEVERE,null,er);
        }
        
    }
   
    public void leerDocentes(){
        String ruta="E:\\programacionIII\\archivoDocente.txt";
        try {
            FileInputStream archivo=new FileInputStream(ruta);
            ObjectInputStream ois=new ObjectInputStream(archivo);
            if(ois!=null){
                docente=(Docente)ois.readObject();
            }
            else{
                System.out.println("El objeto es nulo");
            }
            
        } catch (FileNotFoundException e) {
            Logger.getLogger(OperacionesDocenteMateria.class.getName()).log(Level.SEVERE,null,e);
        }catch (IOException ex) {
            Logger.getLogger(OperacionesDocenteMateria.class.getName()).log(Level.SEVERE,null,ex);
        }catch (ClassNotFoundException em) {
            Logger.getLogger(OperacionesDocenteMateria.class.getName()).log(Level.SEVERE,null,em);
        }
        
    }
    
}
