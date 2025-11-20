/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parte3;

/**
 *
 * @author Usuario
 */
public class NodoNum {
    int valor;
    NodoNum izquierda, derecha;
    int x; // posición inorden (horizontal)
    int y; // nivel/profundidad (vertical)

    NodoNum(int valor) {
        this.valor = valor;
        this.izquierda = null;
        this.derecha = null;
        this.x = -1;
        this.y = -1;
    }
}

