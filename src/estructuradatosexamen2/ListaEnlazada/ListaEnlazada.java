
package estructuradatosexamen2.ListaEnlazada;

import estructuradatosexamen2.Nodo;

public class ListaEnlazada {
    Nodo cabeza;
    public int length;
    
    public ListaEnlazada(){
        cabeza=null;
        length = 0;
    }
    public void agregarNodoInicio(int valor){
        Nodo nodo = new Nodo(valor);
        nodo.siguiente = cabeza;
        cabeza = nodo;
        length++;
    }
    public void agregarNodoFinal(int valor){
        Nodo nodo = new Nodo(valor);
        if(cabeza == null){
            cabeza = nodo;        
        }else{
            Nodo nodoActual=cabeza;
            while(nodoActual.siguiente!=null){
                nodoActual = nodoActual.siguiente;
            }
            
            nodoActual.siguiente = nodo; 
        }
        length++;
        
    }
    
    public void insertarEnPosicion(int dato, int posicion){
        if(posicion>=length){
            agregarNodoFinal(dato);
            return;
        }
        
        int indice = 0;
        
        
        if(posicion<=0||cabeza==null){
            agregarNodoInicio(dato);
            return;
        }
        
        Nodo nuevo = new Nodo(dato);
        Nodo actual = cabeza;
        
        while(indice<posicion-1&& actual.siguiente!=null){
            actual = actual.siguiente;
            indice++;
        }
        
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
        length++;
        
        
    }
    
    
    public void mostrarLista(){
        Nodo actual = cabeza;
        
        while(actual!=null){
            System.out.print(actual.valor +" -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
        
    }
    
}
