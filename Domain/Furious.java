package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import tdaCola.ColaException;

/**
 * Clase encargada de hacer que el sprite haga la simulacion de que se mueve en
 * el tablero del laberinto extiende a Character para poder obtener la
 * informacion de la imagen que se va a utilizar
 *
 */
public class Furious extends Character {

    BlockNum[][] matrixNum;
    BlockBool[][] matrixBool;
    boolean callejon = false;
    long sleep = 12;
    BufferMemoryFurious memory = new BufferMemoryFurious();
    BufferMemoryFast memory2= new BufferMemoryFast();
    BufferMemory memory3= new BufferMemory();
    
    boolean changeImages;
    int i;
    int j;

    BlockNum numBlock;
    BlockBool boolBlock;

    int x = 0;
    int w = 0;
    int s = 0;
    int h = 0;
    private static Random random = new Random();

    /**
     * Constructor
     *
     * @param x coordenada x inicial del caracter
     * @param y coordenada y inicial del caracter
     * @param imgNum numero del sprite que se va a utilizar
     * @param matrixBool matriz booleana que se va a utilizar decisiones
     * @param matrixNum matriz numerica que se va a utilizar coordenadas
     * @throws FileNotFoundException tira una excepcion en caso de que no se
     * encuentre el archivo
     */
    public Furious(int x, int y, int imgNum, BlockBool[][] matrixBool, BlockNum[][] matrixNum,
            int i, int j) throws FileNotFoundException {
        super(x, y, imgNum);
        this.matrixBool = matrixBool;
        this.matrixNum = matrixNum;

        this.i = i;
        this.j = j;
        
        setSprite();

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

        for (int i = 0; i < 10; i++) {
            sprite.add(new Image(new FileInputStream("src/FuriousImages/Furious" + i + ".png")));
        }
    }

    public int getAleatorio(int cota) {
        return random.nextInt(cota) + 1;
    }

    public void prove() throws InterruptedException {
        if (i + 1 == 7 || j + 1 == 14) {
            Thread.sleep(100000);
        } else if (i - 1 == -1 || j - 1 == -1) {
            callejon = false;
        } else if (!blockTrue(matrixBool[i][j + 1]) && !blockTrue(matrixBool[i][j - 1]) && !blockTrue(matrixBool[i + 1][j])) {
            if (callejon == true) {
                callejon = false;
            } else {
                callejon = true;
            }

        } else if (!blockTrue(matrixBool[i][j + 1]) && !blockTrue(matrixBool[i][j - 1]) && !blockTrue(matrixBool[i - 1][j])) {
            if (callejon == true) {
                callejon = false;
            } else {
                callejon = true;
            }
        } else if (!blockTrue(matrixBool[i][j - 1]) && !blockTrue(matrixBool[i + 1][j]) && !blockTrue(matrixBool[i - 1][j])) {
            if (callejon == true) {
                callejon = false;
            } else {
                callejon = true;
            }
        } else if (!blockTrue(matrixBool[i][j + 1]) && !blockTrue(matrixBool[i + 1][j]) && !blockTrue(matrixBool[i - 1][j])) {
            if (callejon == true) {
                callejon = false;
            } else {
                callejon = true;
            }
        }

    }

    public void derecha(BlockNum block) {
        ArrayList<Image> sprite = super.getSprite();
        w = ((numBlock.getA() + numBlock.getC()) / 2) - 35;

        h = 0;

        for (int k = numBlock.getB(), y = 8; k < numBlock.getD(); k++, y++) {
            try {
                if (y == 10) {
                    y = 8;
                }
                if (s == 8) {
                    s = 0;
                }
                if (changeImages) {
                    super.setImage(sprite.get(y));
                    memory.setDesappear(changeImages);
                } else if (h == 10) {
                    super.setImage(sprite.get(s++));
                } else if (h == 35) {
                    super.setImage(sprite.get(s++));
                } else if (h == 50) {
                    super.setImage(sprite.get(s++));
                }
                h++;

                super.setX(k);
                super.setY(w);
                if (memory.getEqualsJIFurious()) {

                    changeImages = true;
                    memory.setEaten(true);
                   
                }
                
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(Furious.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        j++;
    }

    public void arriba(BlockNum block) {
        ArrayList<Image> sprite = super.getSprite();
        x = ((numBlock.getB() + numBlock.getD()) / 2) - 38;

        h = 0;
        for (int k = numBlock.getC() - 80, y = 8; k >= numBlock.getA() - 80; k--, y++) {

            try {
                if (y == 10) {
                    y = 8;
                }
                if (s == 8) {
                    s = 0;
                }
                if (changeImages) {
                    super.setImage(sprite.get(y));
                    memory.setDesappear(changeImages);
                } else if (h == 10) {
                    super.setImage(sprite.get(s++));
                } else if (h == 35) {
                    super.setImage(sprite.get(s++));
                } else if (h == 50) {
                    super.setImage(sprite.get(s++));
                }
                h++;
                super.setX(x);
                super.setY(k);
                if (memory.getEqualsJIFurious()) {

                    changeImages = true;
                    memory.setEaten(true);
                }
                
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(Furious.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        i--;
    }

    public void abajo(BlockNum block) {
        ArrayList<Image> sprite = super.getSprite();
        x = ((numBlock.getB() + numBlock.getD()) / 2) - 38;
        h = 0;
        for (int k = numBlock.getA(), y = 8; k < numBlock.getC(); k++, y++) {
            try {
                if (y == 10) {
                    y = 8;
                }
                if (s == 8) {
                    s = 0;
                }
                if (changeImages) {
                    super.setImage(sprite.get(y));
                    memory.setDesappear(changeImages);
                } else if (h == 10) {
                    super.setImage(sprite.get(s++));
                } else if (h == 35) {
                    super.setImage(sprite.get(s++));
                } else if (h == 50) {
                    super.setImage(sprite.get(s++));
                }
                h++;

                super.setX(x);
                super.setY(k);
                if (memory.getEqualsJIFurious()) {

                    changeImages = true;
                    memory.setEaten(true);

                }
                
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(Furious.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        i++;

    }

    public void izquierda(BlockNum block) {

        ArrayList<Image> sprite = super.getSprite();
        w = ((numBlock.getA() + numBlock.getC()) / 2) - 33;
        h = 0;
        for (int k = numBlock.getD() - 66, y = 8; k > numBlock.getB() - 66; k--, y++) {

            try {
                if (y == 10) {
                    y = 8;
                }
                if (s == 8) {
                    s = 0;
                }
                if (changeImages) {
                    super.setImage(sprite.get(y));
                    memory.setDesappear(changeImages);
                } else if (h == 10) {
                    super.setImage(sprite.get(s++));
                } else if (h == 35) {
                    super.setImage(sprite.get(s++));
                } else if (h == 50) {
                    super.setImage(sprite.get(s++));
                }
                h++;

                super.setX(k);
                super.setY(w);
                if (memory.getEqualsJIFurious()) {

                    changeImages = true;
                    memory.setEaten(true);
                }
                
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(Furious.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        j--;
    }

    /**
     * Metodo que se encarga de que el hilo corra para poder simular el
     * movimiento del caracter
     */
    @Override
    public void run() {
        try {
            while (true) {

                if (i + 1 == 7 || j + 1 == 14) {
                    Thread.sleep(100000);
                } else if (i - 1 == -1 || j - 1 == -1) {
                    callejon = false;
                }
                
                
                memory.setFuriousI(i);
                memory.setFuriousJ(j);
                memory.setCallejonFurious(callejon);
                
                    
                if (!callejon) {

                    if (blockTrue(matrixBool[i][j + 1])) {

                        
                        numBlock = matrixNum[i][j];

                        derecha(numBlock);

                        changeImages = false;
                        prove();

                        //Thread.sleep(100);
                    } else if (matrixBool[i][j].getA()||matrixBool[i][j].getC()) {

                        
                        numBlock = matrixNum[i][j];
                        if(blockTrue(matrixBool[i+1][j])&&blockTrue(matrixBool[i-1][j])){
                            int random = getAleatorio(2);
                            if(random==1){
                                arriba(numBlock);
                            }else{
                                abajo(numBlock);
                            }
                        }else if(blockTrue(matrixBool[i+1][j])&&!blockTrue(matrixBool[i-1][j])){
                            abajo(numBlock);
                        }else if(!blockTrue(matrixBool[i+1][j])&&blockTrue(matrixBool[i-1][j])){
                            arriba(numBlock);
                        }
                        

                        changeImages = false;
                        prove();
                        //Thread.sleep(600);
                    }

                    else {
                        callejon = true;
                    }


                }
                if (callejon) {

                    if (i == 0 || j == 0) {

                        callejon = false;
                    } else if (matrixBool[i][j].getA() && matrixBool[i][j].getB() && matrixBool[i][j].getC() && matrixBool[i][j].getD()) {
                        int aleatorio = getAleatorio(4);
                        if (aleatorio == 1) {
                            numBlock = matrixNum[i][j];

                            derecha(numBlock);

                            changeImages = false;
                            prove();
                        } else if (aleatorio == 2) {
                            numBlock = matrixNum[i][j];

                            izquierda(numBlock);
                            changeImages = false;
                            prove();

                        } else if (aleatorio == 3) {

                            numBlock = matrixNum[i][j];

                            arriba(numBlock);

                            changeImages = false;
                            prove();

                        } else if (aleatorio == 4) {

                            numBlock = matrixNum[i][j];

                            abajo(numBlock);

                            changeImages = false;
                            prove();

                        }
                    } else if (matrixBool[i][j].getA() && !matrixBool[i][j].getB() && !matrixBool[i][j].getC() && !matrixBool[i][j].getD()) {

                        numBlock = matrixNum[i][j];
                        abajo(numBlock);

                        changeImages = false;
                        prove();

                    } else if (matrixBool[i][j].getA() && matrixBool[i][j].getD()) {
                        int aleatorio = getAleatorio(3);
                        if (aleatorio == 1) {
                            callejon = false;
                        } else if (aleatorio == 2 && blockTrue(matrixBool[i - 1][j])) {

                            numBlock = matrixNum[i][j];
                            arriba(numBlock);

                            changeImages = false;
                            prove();
                        } else {
                            callejon = true;
                        }

                    } else if (matrixBool[i][j].getC() && !matrixBool[i][j].getB()) {
                        int aleatorio = getAleatorio(2);
                        if (aleatorio == 1 && blockTrue(matrixBool[i - 1][j])) {

                            numBlock = matrixNum[i][j];

                            arriba(numBlock);

                            changeImages = false;
                            prove();

                        } else if (aleatorio == 2 && blockTrue(matrixBool[i + 1][j])) {

                            numBlock = matrixNum[i][j];
                            abajo(numBlock);
                            changeImages = false;
                            prove();
                        }
                        

                    } else if (matrixBool[i][j].getC() && matrixBool[i][j].getD()) {
                        int aleatorio = getAleatorio(2);

                        if (aleatorio == 1 && blockTrue(matrixBool[i + 1][j])) {

                            numBlock = matrixNum[i][j];
                            abajo(numBlock);
                            changeImages = false;
                            prove();
                        } else if (aleatorio == 2 && blockTrue(matrixBool[i][j - 1])) {

                            numBlock = matrixNum[i][j];

                            izquierda(numBlock);
                            changeImages = false;
                            prove();

                        }

                        //Thread.sleep(100);
                    } else if (matrixBool[i][j].getA() && matrixBool[i][j].getB() && !matrixBool[i][j].getC() && !matrixBool[i][j].getD() && blockTrue(matrixBool[i][j - 1])) {

                        numBlock = matrixNum[i][j];

                        izquierda(numBlock);
                        changeImages = false;
                        prove();

                        //Thread.sleep(100);
                    } else if (matrixBool[i][j].getC() && matrixBool[i][j].getB() && blockTrue(matrixBool[i][j - 1])) {

                        numBlock = matrixNum[i][j];

                        izquierda(numBlock);

                        changeImages = false;
                        prove();

                    } else if (blockTrue(matrixBool[i][j - 1])) {

                        numBlock = matrixNum[i][j];

                        izquierda(numBlock);
                        changeImages = false;
                        prove();

                        //Thread.sleep(100);
                    } else if (blockTrue(matrixBool[i][j + 1])) {

                       
                        numBlock = matrixNum[i][j];

                        derecha(numBlock);

                        changeImages = false;
                        prove();

                        //Thread.sleep(100);
                    } else {
                        callejon = false;
                    }

                }
                
            }
        } catch (InterruptedException ex) {

            Logger.getLogger(Furious.class.getName()).log(Level.SEVERE, null, ex);
        } 


    }

    public boolean blockTrue(BlockBool b) {

        return b.getA() || b.getB() || b.getC() || b.getD();
    }

}
