/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parte3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class main {
    public static void main(String[] args) {
        ejercicio1();
    }
    
    public static void ejercicio1(){
        Scanner sc = new Scanner(System.in);
        ArbolNum arbol = new ArbolNum();

        final int arregloTAM = 10;
        int[] arregloIngresado = new int[arregloTAM];

        System.out.println("Arbol Binario\nIngrese " + arregloTAM + " números enteros:");

        // Lectura de los numeros para ingresarlos al arreglo
        for (int i = 0; i < arregloTAM; i++) {
            System.out.print("N" + (i + 1) + ": ");
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) {
                System.out.println("Entrada vacía, intente de nuevo.");
                i--;
                continue;
            }
            try {
                int val = Integer.parseInt(linea);
                arregloIngresado[i] = val;
                arbol.insertar(val);
            } catch (NumberFormatException e) {
                System.out.println("Numero no valido, intente otra vez");
                i--;
            }
        }

        System.out.println("\nArreglo original:");
        System.out.println(Arrays.toString(arregloIngresado));

        // Asignar coordenadas para visualización
        arbol.asignarCoordenadas();

        // Reunir nodos para medir dimensiones y longitudes
        ArrayList<NodoNum> lista = new ArrayList<>();
        arbol.listarNodos(arbol.raiz, lista);
        if (lista.isEmpty()) {
            System.out.println("Árbol vacío.");
            return;
        }

        int maxX = 0, maxY = 0, maxLong = 0;
        for (NodoNum n : lista) {
            if (n.x > maxX) maxX = n.x;
            if (n.y > maxY) maxY = n.y;
            int len = String.valueOf(n.valor).length();
            if (len > maxLong) maxLong = len;
        }

        // Configuración del "lienzo"
        int espacio = Math.max(4, maxLong + 2); // separación horizontal entre centros
        int columnas = (maxX + 1) * espacio + espacio;
        int filas = (maxY + 1) * 2 + 1; // 2 filas por nivel (una con valor, otra separación)

        // Crear lienzo (matriz de chars) inicializada con espacios
        char[][] lienzo = new char[filas][columnas];
        for (int r = 0; r < filas; r++)
            for (int c = 0; c < columnas; c++)
                lienzo[r][c] = ' ';

        // Colocar nodos en sus posiciones (sin líneas)
        colocarNodosEnLienzo(arbol.raiz, lienzo, espacio);

        // Imprimir recorrido inorden (números ordenados)
        System.out.println("\nNúmeros en orden ascendente:");
        ArrayList<Integer> orden = new ArrayList<>();
        arbol.obtenerInordenRec(arbol.raiz, orden);
        for (int v : orden) System.out.print(v + " ");
        System.out.println("\n");

        // Imprimir lienzo con los nodos posicionados
        for (int r = 0; r < filas; r++) {
            System.out.println(new String(lienzo[r]));
        }

    }

    // Coloca nodos en el lienzo respetando x (horizontal) e y (nivel)
    private static void colocarNodosEnLienzo(NodoNum nodo, char[][] lienzo, int espacio) {
        if (nodo == null) return;
        int x = nodo.x * espacio + espacio / 2;
        int y = nodo.y * 2; // fila para el número (nivel * 2)

        // Escribir el número centrado en (y,x)
        String texto = String.valueOf(nodo.valor);
        int inicio = x - texto.length() / 2;
        if (inicio < 0) inicio = 0;
        for (int i = 0; i < texto.length() && inicio + i < lienzo[0].length; i++) {
            lienzo[y][inicio + i] = texto.charAt(i);
        }

        // Recursión para colocar hijos también
        colocarNodosEnLienzo(nodo.izquierda, lienzo, espacio);
        colocarNodosEnLienzo(nodo.derecha, lienzo, espacio);
    }

    
}
