package Domain;

/**
 * La clase blockBool se encarga de crear un bloque que cuenta con cuatro lados
 * booleanos y que segun el valor del lado va a crear un camino para que el
 * sprite se traslade al bloque correspondiente
 */
public class BlockBool {

    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;

    /**
     * Contructor
     *
     * @param a el lado a del bloque creado
     * @param b el lado b del bloque creado
     * @param c el lado c del bloque creado
     * @param d el lado d del bloque creado
     */
    public BlockBool(boolean a, boolean b, boolean c, boolean d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }//constructor

    /**
     * getA
     * @return retorna el valor del lado a
     */

    public boolean getA() {
        return a;
    }

    /**
     * setA
     * @param a establece el valor que se le da al lado a
     */
    public void setA(boolean a) {
        this.a = a;
    }

    /**
     * getB
     * @return retorna el valor del lado b
     */
    public boolean getB() {
        return b;
    }

    /**
     * setB
     * @param b establece el valor que se le da al lado b
     */
    public void setB(boolean b) {
        this.b = b;
    }

    /**
     * getC
     * @return retorna el valor del lado c
     */
    public boolean getC() {
        return c;
    }

    /**
     * setC
     * @param c establece el valor que se le da al lado c
     */
    public void setC(boolean c) {
        this.c = c;
    }

    /**
     * getD
     * @return retorna el valor del lado d
     */
    public boolean getD() {
        return d;
    }

     /**
     * setD
     * @param d establece el valor que se le da al lado d
     */
    public void setD(boolean d) {
        this.d = d;
    }

    /**
     * 
     * @return String retorna un string con los valores asignados a los
     * diferentes lados a, b, c y d del bloque creado
     */
    @Override
    public String toString() {
        return "BlockBool{" + "a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + "}";
    }
}
