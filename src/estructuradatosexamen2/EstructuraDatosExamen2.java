/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructuradatosexamen2;

import estructuradatosexamen2.ListaEnlazada.ListaEnlazada;
import estructuradatosexamen2.ListaEnlazada.ListaEnlazadaCircular;

/**
 *
 * @author Usuario
 */
public class EstructuraDatosExamen2 {

    public static void main(String[] args) {
        listaEnlazadaCircular();
    }
    
    public static void listaEnlazada(){
    ListaEnlazada lista = new ListaEnlazada();
        
        lista.agregarNodoInicio(13);
        lista.agregarNodoInicio(18);
        lista.agregarNodoInicio(24);
        
        lista.agregarNodoFinal(30);
        lista.mostrarLista();
        
        
        
        lista.mostrarLista();
        
        lista.insertarEnPosicion(58, lista.length/2);
        
        lista.mostrarLista();
    }
    
    public static void listaEnlazadaCircular(){
        ListaEnlazadaCircular lista = new ListaEnlazadaCircular();
        
        lista.insertarInicio(35);
//        lista.insertarInicio(54);
//        lista.insertarInicio(32);
//        lista.insertarInicio(78);
//        lista.insertarFinal(99);
        
        lista.mostarListaCircular();
        
        lista.eliminarDato(35);
        lista.mostarListaCircular();
    }
    
    
    
}
