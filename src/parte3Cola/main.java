/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parte3Cola;

/**
 *
 * @author Usuario
 */
public class main {
    public static void main(String[] args) {
        Cola nuevaCola = new Cola();
        nuevaCola.insertaElemento(10);
        nuevaCola.insertaElemento(20);
        nuevaCola.insertaElemento(35);
        nuevaCola.insertaElemento(40);
        nuevaCola.insertaElemento(30);
        System.out.println(nuevaCola.mostrar());
    }
}
