package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

/**
 * Clase encargada de hacer que el sprite haga la simulacion de que se mueve en
 * el tablero del laberinto extiende a Character para poder obtener la informacion
 * de la imagen que se va a utilizar
 * 
 */
public class RunningCharacter extends Character {

    BlockNum[][] matrixNum;
    BlockBool[][] matrixBool;
    boolean callejon = false;

    /**
     * Constructor
     * @param x coordenada x inicial del caracter
     * @param y coordenada y inicial del caracter
     * @param imgNum numero del sprite que se va a utilizar
     * @param matrixBool matriz booleana que se va a utilizar decisiones
     * @param matrixNum matriz numerica que se va a utilizar coordenadas
     * @throws FileNotFoundException tira una excepcion en caso de que no se encuentre el archivo
     */
    public RunningCharacter(int x, int y, int imgNum, BlockBool[][] matrixBool, BlockNum[][] matrixNum) throws FileNotFoundException {
        super(x, y, imgNum);
        this.matrixBool = matrixBool;
        this.matrixNum = matrixNum;
        setSprite();
    }

    /**
     * Establece un ArrayList de Image y lo llena con imagenes de los sprites 
     * que se utilizan en el laberinto
     * @throws FileNotFoundException tira una excepcion en caso de que no se encuentre el archivo
     */
    public void setSprite() throws FileNotFoundException {

        ArrayList<Image> sprite = super.getSprite();

        for (int i = 0; i < 8; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Running" + i + ".png")));
        }
    }

    /**
     * Metodo que se encarga de que el hilo corra para poder simular el
     * movimiento del caracter
     */
    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        BlockNum tempStartNum = matrixNum[1][0];
        BlockNum tempFinishNum = matrixNum[5][13];
        BlockBool tempStartBool = matrixBool[1][0];
        BlockNum numBlock = tempStartNum;
        BlockBool boolBlock = tempStartBool;
        int i = 1;
        int j = 0;
        int x = 0;
        int w = 0;

        while (true) {
            try {
                if (!callejon) {
                    if (blockTrue(matrixBool[i][j+1])) {

                        numBlock = matrixNum[i][j];
                        x = ((numBlock.getB() + numBlock.getD()) / 2)-39;
                        w = ((numBlock.getA() + numBlock.getC()) / 2)-10;
                        super.setImage(sprite.get(0));
                        for (int k = x; k < numBlock.getD(); k++) {

                            super.setImage(sprite.get(0));

                            super.setX(k);
                            super.setY(w);
                            Thread.sleep(10);
                        }
                        j++;

                        if (j == 14) {
                            j = 0;
                        }

                        //Thread.sleep(100);
                    } else if (matrixBool[i][j].getC()) {

                        numBlock = matrixNum[i][j];
                        x = ((numBlock.getB() + numBlock.getD()) / 2)-39;
                        w = ((numBlock.getA() + numBlock.getC()) / 2)-39;

                        for (int k = w; k < numBlock.getC(); k++) {

                            super.setImage(sprite.get(0));

                            super.setX(x);
                            super.setY(k);
                            Thread.sleep(10);
                        }
                        i++;

                        if (i == 7) {
                            i = 1;
                        }

                    } else if (matrixBool[i][j].getA()) {

                        numBlock = matrixNum[i][j];
                        x = ((numBlock.getB() + numBlock.getD()) / 2)-38;
                        w = numBlock.getC()-40;
                        for (int k = w; k >= numBlock.getA()-40; k--) {

                            super.setImage(sprite.get(0));
                            super.setX(x);
                            super.setY(k);
                            Thread.sleep(10);
                        }

                        
                        i--;

                        if (i == -1) {
                            i = 0;
                        }

                        //Thread.sleep(600);
                    }
                    else {
                        callejon = true;
                    }
                    
                } 
                if(callejon) {

                    if (matrixBool[i][j].getA()&&!matrixBool[i][j].getB()&&!matrixBool[i][j].getC()&&!matrixBool[i][j].getD()) {
                        System.out.println("Si");
                        numBlock = matrixNum[i][j];
                        x = ((numBlock.getB() + numBlock.getD()) / 2)-39;
                        w = ((numBlock.getA() + numBlock.getC()) / 2)-39;

                        for (int k = w; k < numBlock.getC(); k++) {

                            super.setImage(sprite.get(0));

                            super.setX(x);
                            super.setY(k);
                            Thread.sleep(10);
                        }
                        i++;

                        if (i == 7) {
                            i = 1;
                        }
                    }else if (matrixBool[i][j].getA()&&matrixBool[i][j].getD()&&!matrixBool[i][j].getB()&&!matrixBool[i][j].getC()) {

                       numBlock = matrixNum[i][j];
                        x = ((numBlock.getB() + numBlock.getD()) / 2)-38;
                        w = numBlock.getC()-40;
                        for (int k = w; k >= numBlock.getA()-40; k--) {

                            super.setImage(sprite.get(0));
                            super.setX(x);
                            super.setY(k);
                            Thread.sleep(10);
                        }

                        
                        i--;

                        if (i == -1) {
                            i = 0;
                        }

                    }else if (matrixBool[i][j].getA()&&matrixBool[i][j].getB()&&!matrixBool[i][j].getC()&&!matrixBool[i][j].getD()) {

                       numBlock = matrixNum[i][--j];
                       
                        w = ((numBlock.getA() + numBlock.getC()) / 2)-10;
                        super.setImage(sprite.get(0));
                        for (int k = numBlock.getD(); k >numBlock.getB()-80  ; k--) {
                            
                            super.setImage(sprite.get(0));

                            super.setX(k);
                            super.setY(w);
                            Thread.sleep(10);
                        }
                        j--;

                        if (j == -1) {
                            j = 13;
                        }


                    }else if (matrixBool[i][j].getC()&&!matrixBool[i][j].getB()&&!matrixBool[i][j].getA()&&!matrixBool[i][j].getD()) {
                        
                        numBlock = matrixNum[i][j];
                        x = ((numBlock.getB() + numBlock.getD()) / 2) - 39;
                        w = ((numBlock.getA() + numBlock.getC()) / 2) - 39;

                        for (int k = numBlock.getC(); k > numBlock.getA(); k--) {

                            super.setImage(sprite.get(0));

                            super.setX(x);
                            super.setY(k);
                            Thread.sleep(10);
                        }

                        i--;

                        if (i == -1) {
                            i = 6;
                        }

                    }else if (matrixBool[i][j].getC()&&matrixBool[i][j].getD()&&!matrixBool[i][j].getA()&&!matrixBool[i][j].getB()) {
                        
                        numBlock = matrixNum[i][j];
                        x = ((numBlock.getB() + numBlock.getD()) / 2) - 39;
                        w = ((numBlock.getA() + numBlock.getC()) / 2) - 39;

                        for (int k = numBlock.getA(); k < numBlock.getC(); k++) {

                            super.setImage(sprite.get(0));

                            super.setX(x);
                            super.setY(k);
                            Thread.sleep(10);
                        }

                        i++;

                        if (i == -1) {
                            i = 6;
                        }
                        //Thread.sleep(100);
                    }else if (matrixBool[i][j].getC()&&matrixBool[i][j].getB()) {
                        
                        numBlock = matrixNum[i][--j];
                       
                        w = ((numBlock.getA() + numBlock.getC()) / 2)-10;
                        super.setImage(sprite.get(0));
                        for (int k = numBlock.getD(); k >numBlock.getB()-80  ; k--) {
                            
                            super.setImage(sprite.get(0));

                            super.setX(k);
                            super.setY(w);
                            Thread.sleep(10);
                        }
                        j--;

                        if (j == -1) {
                            j = 13;
                        }

                        //Thread.sleep(100);
                    }else if (blockTrue(matrixBool[i][j-1])) {
                        
                        numBlock = matrixNum[i][--j];
                       
                        w = ((numBlock.getA() + numBlock.getC()) / 2)-10;
                        super.setImage(sprite.get(0));
                        for (int k = numBlock.getD(); k >numBlock.getB()-80  ; k--) {
                            
                            super.setImage(sprite.get(0));

                            super.setX(k);
                            super.setY(w);
                            Thread.sleep(10);
                        }
                        j--;

                        if (j == -1) {
                            j = 13;
                        }

                        //Thread.sleep(100);
                    }  else {
                        callejon = false;
                    }
                    
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(RunningCharacter.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
    public boolean blockTrue(BlockBool b) {
        return b.getA() || b.getB() || b.getC() || b.getD();
    }
            
}
