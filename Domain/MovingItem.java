/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 *
 * @author jeanp
 */
public class MovingItem extends Character {

    BlockNum[][] matrixNum;
    BlockBool[][] matrixBool;
    boolean horizontal;
    boolean abajo;
    int i = 0;
    int j = 0;
    int cantCuadros;
    int l;
    int r;
    int h;
    int sleep;
    boolean derecha;
    BufferMemory memory = new BufferMemory();
    BufferMemoryFurious memory2 = new BufferMemoryFurious();
    BufferMemoryFast memory3 = new BufferMemoryFast();
    /**
     * Constructor
     *
     * @param x coordenada x inicial del item
     * @param y coordenada y inicial del item
     * @param imgNum numero del sprite que se va a utilizar
     * @param matrixBool matriz booleana que se va a utilizar decisiones
     * @param matrixNum matriz numerica que se va a utilizar coordenadas
     * @throws FileNotFoundException tira una excepcion en caso de que no se
     * encuentre el archivo
     */
    public MovingItem(int x, int y, int imgNum, BlockBool[][] matrixBool, BlockNum[][] matrixNum, boolean direction,int i, int j) throws FileNotFoundException {
        super(x, y, imgNum);
        this.matrixBool = matrixBool;
        this.matrixNum = matrixNum;
        this.horizontal = direction;
        setSprite();
        this.i = i;
        this.j = j;
        this.sleep = 20;
        if (horizontal) {
            if (matrixBool[i][j].getD()) {
                derecha = true;
            } else {

                derecha = false;

              
            }
        } else {
            
            if (matrixBool[i][j].getA()||matrixBool[i][j].getC()) {
                abajo = true;
            } else if (matrixBool[i][j].getB()||matrixBool[i][j].getD()) {

                abajo = false;

              
            }

        }

    }

    /**
     * Establece un ArrayList de Image y lo llena con imagenes de los sprites
     * que se utilizan en el laberinto
     *
     * @throws FileNotFoundException tira una excepcion en caso de que no se
     * encuentre el archivo
     */
    public void setSprite() throws FileNotFoundException {

        ArrayList<Image> sprite = super.getSprite();

        for (int i = 0; i < 8; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/berryItemSprite75x75.png")));
        }
    }

    /**
     * Metodo que se encarga de que el hilo corra para poder simular el
     * movimiento del item
     */
    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        BlockNum tempStartNum = matrixNum[1][0];
        BlockNum tempFinishNum = matrixNum[5][13];
        BlockBool tempStartBool = matrixBool[1][0];
        BlockNum numBlock = tempStartNum;
        BlockBool boolBlock = tempStartBool;
        

        int x = 1;
        int w = 0;

        while (true) {
            try {
                memory.setItemI(i);
                memory.setItemJ(j);
                memory2.setItemJ(j);
                memory2.setItemI(i);
                memory3.setItemJ(j);
                memory3.setItemI(i);
                if (horizontal) {

                    //movimiento hacia la derecha
                    /**
                     * *****Movimiento horizontal******
                     */
                    if (j+1!=14&&blockTrue(matrixBool[i][j + 1])&&derecha) {
                        numBlock = matrixNum[i][j];
                        
                         
                        x = ((numBlock.getB() + numBlock.getD()) / 2) - 39;
                        w = ((numBlock.getA() + numBlock.getC()) / 2) - 20;
                        super.setImage(sprite.get(0));
                        for (int k = x; k < numBlock.getD(); k++) {

                            super.setImage(sprite.get(0));

                            super.setX(k);
                            super.setY(w);
                            Thread.sleep(sleep);
                        }
                        j++;

                        

                        //Thread.sleep(100);
                        //movimiento hacia la izquierda
                    }else {
                        derecha = false;
                    }
                    if (j-1!=-1&&blockTrue(matrixBool[i][j - 1])&&!derecha) {

                        numBlock = matrixNum[i][j];
                        
                        w = ((numBlock.getA() + numBlock.getC()) / 2) - 20;
                        super.setImage(sprite.get(0));
                        for (int k = numBlock.getD()-50; k > numBlock.getB() - 50; k--) {

                            super.setImage(sprite.get(0));

                            super.setX(k);
                            super.setY(w);
                            Thread.sleep(sleep);
                        }
                        j--;

                        

                        //Thread.sleep(100);
                    }else {
                        derecha = true;
                    }

                } else {
                    /**
                     * *****Movimiento vertical******
                     */

                    if (blockTrue(matrixBool[i + 1][j]) && abajo) {
                        numBlock = matrixNum[i][j];
                        
                        w = ((numBlock.getB() + numBlock.getD()) / 2) - 39;

                        for (int k = numBlock.getA(); k < numBlock.getC(); k++) {

                            super.setImage(sprite.get(0));

                            super.setX(w);
                            super.setY(k);
                            Thread.sleep(sleep);
                        }
                        i++;
                        

                        
                        
                    } else {
                        abajo = false;
                    }
                    if (blockTrue(matrixBool[i - 1][j]) && !abajo) {
                          
                        numBlock = matrixNum[i][j];
                        
                        x = ((numBlock.getB() + numBlock.getD()) / 2) - 38;

                        for (int k = numBlock.getC()-60; k >= numBlock.getA()-60; k--) {

                            super.setImage(sprite.get(0));
                            super.setX(x);
                            super.setY(k);
                            Thread.sleep(sleep);
                        }

                        i--;
                        
                        
                        if (i == -1) {
                            i = 0;
                        }
                        
                    } else {
                        abajo = true;
                    }
                    
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Fast.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean blockTrue(BlockBool b) {
        return b.getA() || b.getB() || b.getC() || b.getD();
    }
}
