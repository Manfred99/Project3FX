package Domain;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * La clase Character se encarga de contener la informacion acerca del sprite
 * que se va a utilizar en el programa extiende de la clase hilo para que esta
 * tenga un tiempo de ejecucion y pueda ejecutarse como si fuera una simulacion
 * de animacion.
 */
public class Character extends Thread {

    private int x;
    private int y;
    private int imgNum;
    private Image image;
    private ArrayList<Image> sprite;

    /**
     * Constructor
     *
     * @param x coordenada x del sprite
     * @param y coordenada y del sprite
     * @param imgNum numero de imagen del sprite a utilizar
     */
    public Character(int x, int y, int imgNum) {
        this.x = x;
        this.y = y;
        this.imgNum = imgNum;
        this.sprite = new ArrayList<Image>();
    }

    public Character() {
    }

    /**
     *
     * @return retorna el valor de la coordenada x
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x Establece el valor que se le da a la coordenada x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return retorna el valor de la coordenada y
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y establece el valor que se le da a la coordenada y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return retorna el numero de imagen que se utilizo en el sprite
     */
    public int getImgNum() {
        return imgNum;
    }

    /**
     *
     * @return retorna la imagen que se utilizo como sprite
     */
    public Image getImage() {
        return image;
    }

    /**
     *
     * @param image Establece la imagen que se quiere utilizar como sprite
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     *
     * @param imgNum Establece el numero de imagen que se quiere utilizar como
     * sprite
     */
    public void setImgNum(int imgNum) {
        this.imgNum = imgNum;
    }

    /**
     *
     * @return retorna un ArrayList de Image que se van a utilizar como sprites
     */
    public ArrayList<Image> getSprite() {
        return sprite;
    }

    /**
     *
     * @param sprite Establece el ArrayList de Image qye se va utilizar como
     * sprite
     */
    public void setSprite(ArrayList<Image> sprite) {
        this.sprite = sprite;
    }
}
