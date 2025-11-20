/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parte3Cola;

/**
 *
 * @author Usuario
 */
public class NodoCola {
    private int valor;
    private NodoCola sgte;
    public NodoCola(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public NodoCola getSgte() {
        return sgte;
    }

    public void setSgte(NodoCola sgte) {
        this.sgte = sgte;
    }
    
}
