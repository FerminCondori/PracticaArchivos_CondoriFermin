/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Ejercicio3;

import java.util.Scanner;

/**
 *
 * @author FERMIN
 */
public class PrincipalHospital {
    public static void main(String[] args) {
        boolean continuar=true;
        int opc=0;
        Scanner leer=new Scanner(System.in);
        OperacionesHospital operaciones=new OperacionesHospital();
        do{
            System.out.println("---*MENU DE OPCIONES*----");
            System.out.println("1. Crear Archivo");
            System.out.println("2. Registrar un Hospital y agregar especialidad");
            System.out.println("3. Guardar datos");
            System.out.println("4. Mostrar Hospitales"); 
            System.out.println("5. Agregar Especialidad a una hospital");
            System.out.println("6. Mostrar Especialidades de un hospital");
            System.out.println("7. Listar hospitales de una especialidad");
            System.out.println("8. Salir");
            System.out.println("Digite una opcion");
            opc=leer.nextInt();
            switch(opc){
                case 1:
                    operaciones.crearArchivo();
                    break;
                case 2:
                    operaciones.registrarHospital();
                    break;
                case 3:
                    int r=operaciones.guardarObjetos();
                    if(r==1)
                        System.out.println("Archivo Guardado!!");
                    else
                        System.out.println("El archivo no fue guardado");
                    break;
                case 4:
                    operaciones.leerHospitales();
                    operaciones.mostrarHospital();
                    break;
                case 5:
                    System.out.println("Digite el nombre del hospital");
                    leer.nextLine();
                    String nom=leer.nextLine();
                    operaciones.leerHospitales();
                    operaciones.agregarEspecialidadHospital(nom);
                    operaciones.guardarObjetos();
                    break;
                case 6:
                    System.out.println("Digite el nombre del hospital");
                    leer.nextLine();
                    String nomh=leer.nextLine();
                    operaciones.leerHospitales();
                    operaciones.mostrarEspecialidadHospital(nomh);
                    break;
                case 7:
                    System.out.println("Digite la especialidad");
                    leer.nextLine();
                    String esp=leer.nextLine();
                    operaciones.leerHospitales();
                    operaciones.listarHospitalEsp(esp);
                    break;
                default:
                    continuar=false;
                    break;
            }
            
        }while(continuar);
    }
}
