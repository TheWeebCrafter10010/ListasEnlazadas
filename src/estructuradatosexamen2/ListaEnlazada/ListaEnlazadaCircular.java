
package estructuradatosexamen2.ListaEnlazada;

import estructuradatosexamen2.Nodo;


public class ListaEnlazadaCircular {
    Nodo cabeza;
    Nodo cola;
    int TAM;

    public ListaEnlazadaCircular() {
        cabeza = null;
        cola = null;
        TAM = 0;
    }
    
    public void insertarInicio(int dato){
        Nodo nuevo = new Nodo(dato);

        if(cabeza ==null){//Primer nodo
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = nuevo;//Se apunta a si mismo
        }else{
            nuevo.siguiente =cabeza;
            cola.siguiente = nuevo;
            cabeza = nuevo;
        }
        TAM++;
    }
    
    public void insertarFinal(int dato){
        Nodo nuevo = new Nodo(dato);

        if(cabeza ==null){//Primer nodo
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = nuevo;//Se apunta a si mismo
        }else{
            cola.siguiente = nuevo;
            nuevo.siguiente =cabeza;
            cola = nuevo;
        }
        TAM++;
    
    }
    
    public void insertarEnPosicion(int dato, int posicion){
        if(posicion<=0){
            insertarInicio(dato);
            return;
        }
        if(cabeza==null){
            insertarFinal(dato);
            return;
        }
        
        if(posicion>=TAM){
            insertarFinal(dato);
            return;
        }
        
        Nodo anterior = cabeza; //Nodo del anterior a 1
        for(int i =1;i<posicion;i++){
            anterior = anterior.siguiente;
        }
        Nodo nuevo = new Nodo(dato);
        
        nuevo.siguiente = anterior.siguiente;
        anterior.siguiente = nuevo;
        TAM++;
    }
    
    public int buscarDato(int valor){
        if(cabeza==null){
            System.out.println("lista vacia");
            return -1;
        }
        Nodo actual = cabeza;
        int pos = 0;
        do{
            if(actual.valor == valor){
                System.out.println("Valor "+valor+" encontrado en la posicion "+pos);
                return pos;
            }
            actual = actual.siguiente;
            pos++;
        }while(actual != cabeza);
        
        System.out.println("No se encontro el valor "+valor );
        return -1;
        
    }
    
    public void mostarListaCircular(){
        Nodo actual = cabeza;
        int pos = 0;
        
        if(cabeza == null){
            System.out.println("[Lista vacia]");
            return;
        }
        System.out.println("(Posicion : valor)");
        do{
            System.out.print("("+pos+" : "+actual.valor+") -> ");
            actual = actual.siguiente;
            pos++;
        }while(actual != cabeza);
        
        System.out.println("Inicio (0 : "+cabeza.valor+")");
        System.out.println("Tamanio: "+TAM);
    }
    
    public void eliminarDato(int valor){
        
        int posicion = buscarDato(valor);
        if(posicion ==-1){
           return;
        }
        
        Nodo anterior = cola;
        for(int i =0;i<posicion;i++){
            anterior =anterior.siguiente;
        }
        
        Nodo actual = anterior.siguiente;
        if(actual == cabeza && actual == cola){
            cabeza = null;
            cola = null;
        }else{
            anterior.siguiente = actual.siguiente;//elimina el actual
            if(actual == cabeza){
                cabeza= actual.siguiente;
                cola.siguiente = cabeza;
            }
            if(actual ==cola){
                cola = anterior;
            }
        }
        TAM--;
    
    }
    
}
