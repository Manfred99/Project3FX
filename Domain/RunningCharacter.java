package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    BlockNum[][] matrixNum;
    BlockBool[][] matrixBool;

    public RunningCharacter(int x, int y, int imgNum, BlockBool[][] matrixBool, BlockNum[][] matrixNum) throws FileNotFoundException {
        super(x, y, imgNum);
        this.matrixBool = matrixBool;
        this.matrixNum = matrixNum;
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {

        ArrayList<Image> sprite = super.getSprite();

        for (int i = 0; i < 8; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Running" + i + ".png")));
        }
    }

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
                
                    if (matrixBool[i][j].getD() ) {

                        numBlock = matrixNum[i][j];
                        x = ((numBlock.getB() + numBlock.getD()) / 2) - 30;
                        w = ((numBlock.getA() + numBlock.getC()) / 2) - 15;
                        super.setImage(sprite.get(0));
                        for (int k = x; k < numBlock.getD()+10; k++) {
                            
                            super.setImage(sprite.get(0));
                            
                            super.setX(k);
                            super.setY(w);
                            Thread.sleep(20);
                        }
                        j++;
                        
                        if (j == 14) {
                            j = 0;
                        }
                        
                        //Thread.sleep(100);
                    } 
                    else if (matrixBool[i][j].getC()) {

                        numBlock = matrixNum[i][j];
                        x = ((numBlock.getB() + numBlock.getD()) / 2) - 30;
                        w = ((numBlock.getA() + numBlock.getC()) / 2) - 15;

                        for (int k = w; k < numBlock.getC()+25 ; k++) {
                            
                            super.setImage(sprite.get(0));
                            
                            super.setX(x);
                            super.setY(k);
                            Thread.sleep(20);
                        }
                        i++;
                       
                        if (i == 7) {
                            i = 1;
                        }
                        
                    } 
                    else if (matrixBool[i][j].getA()) {

                        numBlock = matrixNum[i][j];
                        x = ((numBlock.getB() + numBlock.getD()) / 2) - 30;
                        w = ((numBlock.getA() + numBlock.getC()) / 2) - 15;
                        for (int k = w; k > numBlock.getA()-55; k--) {
                           
                            super.setImage(sprite.get(0));
                            super.setX(x);
                            super.setY(k);
                            Thread.sleep(20);
                        }
//                        super.setImage(sprite.get(y));
//                        super.setX(x);
//                        super.setY(w);
                        System.out.println("HORIZONTAL");
                        System.out.println(numBlock);
                        i--;
                       
                        if (i == -1) {
                            i = 0;
                        }
                        
                        //Thread.sleep(600);
                    }
               
                //Thread.sleep(700);
            } catch (InterruptedException ex) {
                Logger.getLogger(RunningCharacter.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
