package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {

    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        sprite.add(new Image(new FileInputStream("src/Assets/Jumping0.png")));

        ArrayList<Image> sprite1 = super.getSprite();
        sprite1.add(new Image(new FileInputStream("src/Assets/Jumping1.png")));

        ArrayList<Image> sprite2 = super.getSprite();
        sprite2.add(new Image(new FileInputStream("src/Assets/Jumping2.png")));
    }

    @Override
    public void run() {

        while (true) {
            try {
                for (int j = 270; j < 365; j++) {
                    ArrayList<Image> sprite = super.getSprite();
                    super.setImage(sprite.get(1));
                    Thread.sleep(10);
                    this.setY(j);

                }

                ArrayList<Image> sprite2 = super.getSprite();
                super.setImage(sprite2.get(2));
                Thread.sleep(400);
                this.setY(270);

                for (int j = 365; j > 270; j--) {
                    ArrayList<Image> sprite1 = super.getSprite();
                    super.setImage(sprite1.get(0));
                    Thread.sleep(10);
                    this.setY(j);
                }

            } catch (InterruptedException ex) {
            }
        }
    }
}
