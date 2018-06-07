/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdaCola;

/**
 *
 * @author Emmanuel
 */
public interface Cola {
public int getSize(); // Devuelve el numero de
public boolean isEmpty(); // true si la pila esta
public void anular();
public int getPosicion(Object elemento) throws ColaException;
public void encolar(Object Elemento) throws ColaException;
public Object desencolar() throws ColaException;
public boolean existe(Object elemento) throws ColaException;
public Object frente() throws ColaException;
}
