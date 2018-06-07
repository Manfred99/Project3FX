/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tdaCola;

/**
 *
 * @author OSCAR
 */
public class Nodo {
    public Object elemento; //objeto almacenado en el nodo
    public Nodo sgte; //apuntador al sgte nodo
    public Nodo ant;//Apuntador al Nodo anterior
    //Constructor
    public Nodo(Object elemento){
        this.elemento = elemento;
        this.sgte =this.ant=null; //el nuevo nodo apunta a nulo
    }

    public Nodo() {
        this.elemento = elemento;
        this.sgte =this.ant=null; //el nuevo nodo apunta a nulo
    }

    @Override
    public String toString() {
        return "Nodo{" + "elemento=" + elemento + '}';
    }
    
}
