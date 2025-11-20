
package parte3;

import java.util.ArrayList;

public class ArbolNum {
    NodoNum raiz;
    int contadorInorden;

    ArbolNum() {
        raiz = null;
        contadorInorden = 0;
    }

    void insertar(int valor) {
        raiz = insertarRec(raiz, valor);
    }

    private NodoNum insertarRec(NodoNum actual, int valor) {
        if (actual == null) return new NodoNum(valor);
        if (valor < actual.valor) {
            actual.izquierda = insertarRec(actual.izquierda, valor);
        } else {
            actual.derecha = insertarRec(actual.derecha, valor);
        }
        return actual;
    }
    
    public void asignarCoordenadas() {
        contadorInorden = 0;
        asignarRec(raiz, 0);
    }

    private void asignarRec(NodoNum nodo, int nivel) {
        if (nodo == null) return;
        asignarRec(nodo.izquierda, nivel + 1);
        nodo.x = contadorInorden++;
        nodo.y = nivel;
        asignarRec(nodo.derecha, nivel + 1);
    }

    public void listarNodos(NodoNum nodo, ArrayList<NodoNum> lista) {
        if (nodo == null) return;
        lista.add(nodo);
        listarNodos(nodo.izquierda, lista);
        listarNodos(nodo.derecha, lista);
    }

    public void obtenerInordenRec(NodoNum nodo, ArrayList<Integer> lista) {
        if (nodo == null) return;
        obtenerInordenRec(nodo.izquierda, lista);
        lista.add(nodo.valor);
        obtenerInordenRec(nodo.derecha, lista);
    }
}

