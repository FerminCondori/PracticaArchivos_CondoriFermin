/*
 * PRACTICA 1-MANEJO DE ARCHIVOS
 * EJERCICIO 2 (Composicion)
 * EST. FERMIN CONDORI PAUCARA
 */
package com.mycompany.Ejercicio2;

import java.util.Scanner;

public class PrincipalAlbum {
    public static void main(String[] args) {
        OperacionesAlbum operaciones=new OperacionesAlbum();
        boolean continuar=true;
        int opc=0;
        Scanner leer=new Scanner(System.in);
        do{
            System.out.println("-----MENU DE OPCIONES-----");
            System.out.println("1. Crear Archivo");
            System.out.println("2. Crear album y canciones");
            System.out.println("3. Guardar Datos");
            System.out.println("4. Mostrar album y canciones");
            System.out.println("5. Buscar cancion, mostrar album y la artista");
            System.out.println("6. Mostrar canciones de un album");
            System.out.println("7. Eliminar un album");
            System.out.println("8. Salir");
            System.out.println("Digite la opcion");
            opc=leer.nextInt();
            switch (opc) {
                case 1:
                    operaciones.crearArchivo();
                    break;
                case 2:
                    operaciones.crearAlbum();
                    break;
                case 3:
                    int r=operaciones.guardarObjetos();
                    if(r==1)
                        System.out.println("Archivo Guardado!!");
                    else
                        System.out.println("El archivo no fue guardado");
                    break;
                case 4:
                    operaciones.leerAlbum();
                    operaciones.mostrarDatos();
                    break;
                case 5:
                    operaciones.leerAlbum();
                    operaciones.buscarCancion();
                    break;
                case 6:
                    operaciones.leerAlbum();
                    operaciones.mostrarAlbum();
                    break;
                case 7:
                    operaciones.leerAlbum();
                    operaciones.eliminarAlbum();
                    operaciones.guardarObjetos();
                    break;
                default:
                    continuar=false;
                    break;
            }
            
        }while(continuar);
        
    }
    
}
