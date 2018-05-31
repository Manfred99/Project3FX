/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 * La clase blockNum se encarga de crear un bloque que cuenta con cuatro lados
 * numericos y que segun el valor va a determinar la coordenada en la que se
 * encuentra el sprite y a que coordenada moverse en el proximo bloque
 */
public class BlockNum {
    private int a;
    private int b;
    private int c;
    private int d;

     /**
     * Contructor
     * @param a el lado a del bloque creado
     * @param b el lado b del bloque creado
     * @param c el lado c del bloque creado
     * @param d el lado d del bloque creado
     */
    public BlockNum(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    /**
     * getA
     * @return retorna el valor del lado a
     */
    public int getA() {
        return a;
    }

    /**
     * setA
     * @param a establece el valor que se le da al lado a
     */
    public void setA(int a) {
        this.a = a;
    }

    /**
     * getB
     * @return retorna el valor del lado b
     */
    public int getB() {
        return b;
    }

    /**
     * setB
     * @param b establece el valor que se le da al lado b
     */
    public void setB(int b) {
        this.b = b;
    }

     /**
     * getC
     * @return retorna el valor del lado b
     */
    public int getC() {
        return c;
    }

     /**
     * setC
     * @param c establece el valor que se le da al lado c
     */
    public void setC(int c) {
        this.c = c;
    }

    /**
     * getD
     * @return retorna el valor del lado d
     */
    public int getD() {
        return d;
    }

     /**
     * setD
     * @param d establece el valor que se le da al lado d
     */
    public void setD(int d) {
        this.d = d;
    }

     /**
     * 
     * @return String retorna un string con los valores asignados a los
     * diferentes lados a, b, c y d del bloque creado o sus coordenadas.
     */
    @Override
    public String toString() {
        return "BlockNum{" + "a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + '}';
    }
    
    
            
}
