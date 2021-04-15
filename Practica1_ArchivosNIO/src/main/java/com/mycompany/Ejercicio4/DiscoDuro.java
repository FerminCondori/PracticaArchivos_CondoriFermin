/*
 * PRACTICA 1-MANEJO DE ARCHIVOS
 * EJERCICIO 4
 * EST. FERMIN CONDORI PAUCARA
 */
package com.mycompany.Ejercicio4;

public class DiscoDuro extends DispositivoAlmacenamiento {
    //atributos
    private String tipoInterfaz;
    //constructores
    //metodos
    @Override
    public void mostrar(){
        super.mostrar();
        System.out.println("Tipo de Interfaz: "+this.tipoInterfaz); 
    }
    //getter y setter
    
}
