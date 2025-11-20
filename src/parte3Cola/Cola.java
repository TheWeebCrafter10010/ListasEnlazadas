/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parte3Cola;

/**
 *
 * @author Usuario
 */
public class Cola {
    private NodoCola first, last, nuevo, p;

    public void colaVacia(){
        first= null; last = null;
    }
    public void insertaElemento(int valor){
        nuevo = new NodoCola(valor);
        if(last == null){
            last = nuevo; first = nuevo; 
        }
        else{
            last.setSgte(nuevo);
            last = nuevo;
        }
    }
    public int eliminaElemento(){
        int valor=0;
        if(first != null){
            valor = first.getValor();
            first= first.getSgte();
            if(first == null)
                last = null;
        }
        return valor;
    }
    public int acceso(){
        int valor=0;
        if(first != null){
            valor = first.getValor();
        }
        return valor;
    }    
    public String mostrar(){
        String cadena="Cola Vacia";
        if(first != null){
            cadena="";
            p = first;
            while(p!= null){
                cadena += p.getValor()+" - ";
                p = p.getSgte();
            }
        }
        return cadena;
    }
}
