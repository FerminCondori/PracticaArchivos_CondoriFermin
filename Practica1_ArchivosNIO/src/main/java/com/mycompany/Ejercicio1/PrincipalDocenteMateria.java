/*
 * PRACTICA 1-MANEJO DE ARCHIVOS
 * EJERCICIO 1(Asociacion)
 * EST. FERMIN CONDORI PAUCARA
 */
package com.mycompany.Ejercicio1;

import java.util.Scanner;

public class PrincipalDocenteMateria {
    public static void main(String[] args) {
        int opc=0;
        OperacionesDocenteMateria obj = new OperacionesDocenteMateria();
        boolean continuar = true;
        Scanner leer=new Scanner(System.in);
        do {
            System.out.println("MENU DE OPCIONES");
            System.out.println("1. Crear Archivo");
            System.out.println("2. Crear Docente");
            System.out.println("3. Crear Materia");
            System.out.println("4. Asignar Materia");
            System.out.println("5. Guardar los registros");
            System.out.println("6. Mostrar los datos");
            System.out.println("7. Salir");
            System.out.println("Digite una opcion");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    obj.crearArchivo();
                    break;
                case 2:
                    obj.crearDocente();
                    break;
                case 3:
                    obj.crearMateria();
                    break;
                case 4:
                    obj.asignarMateriaDocente();
                    break;
                case 5:
                    obj.guardarObjetos();
                    break;
                case 6:
                    obj.leerDocentes();
                    obj.mostrarDocente();
                    break;
                default:
                    continuar = false;
                    break;
            }
        } while (continuar);
    }
    
}
