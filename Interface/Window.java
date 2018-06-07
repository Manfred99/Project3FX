package Interface;

import Domain.BlockBool;
import Domain.BlockNum;
import Domain.BufferMemory;
import Domain.BufferMemoryFast;
import Domain.BufferMemoryFurious;
import Domain.ImportantMethods;
import Domain.MovingItem;

import Domain.Fast;
import Domain.Furious;
import Domain.Smart;
import Domain.StopWatch;

import Utility.Variables;
import java.io.FileNotFoundException;
import java.nio.BufferOverflowException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Window extends Application implements Runnable {

    private Thread thread;
    private Scene scene;
    private VBox pane;
    private Canvas canvas;
    private Image image;
    private BlockNum[][] matrixNum;
    private BlockBool[][] matrixBool;
    private MovingItem item;
    private Fast fast;
    private Furious furious;
    private Smart smart;

    public static int min = 0, sec = 0, mil = 0;
    public static boolean watchStart = true, watchRunning = false;
    Label timeLbl;

    private BufferMemory memory = new BufferMemory();
    private BufferMemoryFurious memory2 = new BufferMemoryFurious();
    private BufferMemoryFast memory3 = new BufferMemoryFast();
    private boolean matrixBoolean[][];
    private boolean start = false;
    ImportantMethods important = new ImportantMethods();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Maze runner");
        initComponents(primaryStage);
        primaryStage.setOnCloseRequest(exit);
        GraphicsContext g = this.canvas.getGraphicsContext2D();
        BlockNum[][] matrixNum1 = important.fillMatixNum();
        BlockBool[][] bool = important.fillMatrixBool7();
        canvas.setOnMouseClicked((event) -> {
            double x = event.getX();
            double y = event.getY();

            if (x >= 70 && x <= 1200 && y >= 70 && y <= 640) {
                System.out.println("Equis" + x);
                System.out.println("Ye" + y);
                BlockNum temp;
                BlockBool tempBool;
                for (int i = 0; i < matrixNum.length; i++) {
                    for (int j = 0; j < matrixNum[0].length; j++) {
                        temp = matrixNum[i][j];
                        tempBool = matrixBool[i][j];
                        if (temp.getA() <= y && temp.getB() <= x && temp.getC() >= y && temp.getD() >= x) {
                            if (tempBool.getA() || tempBool.getB() || tempBool.getC() || tempBool.getD()) {
                                matrixBool[i][j] = bool[i][j] = new BlockBool(false, false, false, false);
                                important.drawMaze(g, bool, matrixNum1);
                            } else {
//                                if (!matrixBool[i + 1][j].getB() && !matrixBool[i + 1][j].getD() && !matrixBool[i + 1][j].getA() && matrixBool[i + 1][j].getC() || !matrixBool[i - 1][j].getB() && !matrixBool[i - 1][j].getD() && !matrixBool[i - 1][j].getA() && matrixBool[i - 1][j].getC()) {
//                                    matrixBool[i][j] = bool[i][j] = new BlockBool(false, false, true, false);
//                                } else if (!matrixBool[i + 1][j].getB() && !matrixBool[i + 1][j].getD() && matrixBool[i + 1][j].getA() && !matrixBool[i + 1][j].getC() || !matrixBool[i - 1][j].getB() && !matrixBool[i - 1][j].getD() && matrixBool[i - 1][j].getA() && !matrixBool[i - 1][j].getC()) {
//                                    matrixBool[i][j] = bool[i][j] = new BlockBool(true, false, false, false);
//                                } else if (j != 0 && !matrixBool[i][j - 1].getA() && !matrixBool[i][j - 1].getC() && !matrixBool[i][j - 1].getB() && matrixBool[i][j - 1].getD() && !matrixBool[i][j + 1].getA() && !matrixBool[i][j + 1].getC() && !matrixBool[i][j + 1].getB() && matrixBool[i][j + 1].getD()) {
//                                    matrixBool[i][j] = bool[i][j] = new BlockBool(false, false, false, true);
//                                } else if (j != 0 && !matrixBool[i][j - 1].getA() && matrixBool[i][j - 1].getC() && matrixBool[i][j - 1].getB() && !matrixBool[i][j - 1].getD() || matrixBool[i + 1][j].getB() && !matrixBool[i + 1][j].getD() && matrixBool[i + 1][j].getC() && !matrixBool[i + 1][j].getA()) {
//                                    matrixBool[i][j] = bool[i][j] = new BlockBool(false, true, true, false);
//                                } else if (!matrixBool[i - 1][j].getB() && matrixBool[i - 1][j].getD() && !matrixBool[i - 1][j].getC() && matrixBool[i - 1][j].getA() || matrixBool[i][j + 1].getA() && !matrixBool[i][j + 1].getC() && !matrixBool[i][j + 1].getB() && matrixBool[i][j + 1].getD()) {
//                                    matrixBool[i][j] = bool[i][j] = new BlockBool(true, false, false, true);
//                                } else if (!matrixBool[i - 1][j].getB() && !matrixBool[i - 1][j].getD() && !matrixBool[i - 1][j].getC() && matrixBool[i - 1][j].getA() && !matrixBool[i][j - 1].getA() && !matrixBool[i][j - 1].getC() && !matrixBool[i][j - 1].getB() && matrixBool[i][j - 1].getD()) {
//                                    matrixBool[i][j] = bool[i][j] = new BlockBool(true, true, false, false);
//                                } else if (!matrixBool[i - 1][j].getB() && matrixBool[i - 1][j].getD() && matrixBool[i - 1][j].getC() && !matrixBool[i - 1][j].getA() && !matrixBool[i][j - 1].getA() && matrixBool[i][j - 1].getC() && !matrixBool[i][j - 1].getB() && matrixBool[i][j - 1].getD()) {
//                                    matrixBool[i][j] = bool[i][j] = new BlockBool(false, false, true, true);
//                                } else if (matrixBool[i][j + 1].getA() && matrixBool[i][j + 1].getB() && !matrixBool[i][j + 1].getC() && !matrixBool[i][j + 1].getD()) {
//                                    matrixBool[i][j] = bool[i][j] = new BlockBool(false, false, false, true);
//                                } else if (!matrixBool[i][j - 1].getA() && !matrixBool[i][j - 1].getB() && matrixBool[i][j - 1].getC() && matrixBool[i][j - 1].getD()) {
//                                    matrixBool[i][j] = bool[i][j] = new BlockBool(false, false, false, true);
//                                } else if (!matrixBool[i][j + 1].getA() && matrixBool[i][j + 1].getB() && matrixBool[i][j + 1].getC() && !matrixBool[i][j + 1].getD()) {
//                                    matrixBool[i][j] = bool[i][j] = new BlockBool(false, false, false, true);
//                                } else if (matrixBool[i][j - 1].getA() && !matrixBool[i][j - 1].getB() && !matrixBool[i][j - 1].getC() && matrixBool[i][j - 1].getD()) {
//                                    matrixBool[i][j] = bool[i][j] = new BlockBool(false, false, false, true);
//                                } else if (j == 0) {
//                                    matrixBool[i][j] = bool[i][j] = new BlockBool(false, false, false, true);
//                                }
                                if (blockTrue(matrixBool[i][j - 1]) && blockTrue(matrixBool[i + 1][j]) || blockTrue(matrixBool[i][j + 1]) && blockTrue(matrixBool[i + 1][j])
                                        || blockTrue(matrixBool[i + 1][j]) && blockTrue(matrixBool[i][j + 1]) || blockTrue(matrixBool[i - 1][j]) && blockTrue(matrixBool[i][j + 1])) {//caso 0 //&&!blockTrue(matrixBool[i-1][j])&&!blockTrue(matrixBool[i][j+1])
                                    matrixBool[i][j] = new BlockBool(true, true, true, true);
                                } else if (blockTrue(matrixBool[i][j + 1]) && blockTrue(matrixBool[i][j - 1])) {///caso1
                                    matrixBool[i][j] = new BlockBool(false, false, false, true);
                                } else if (blockTrue(matrixBool[i][j - 1]) && !blockTrue(matrixBool[i][j + 1])) {//caso2
                                    //matrixBool[i][j-1] = bool[i][j] = new BlockBool(false, false, false, true);
                                    matrixBool[i][j] = new BlockBool(false, true, false, false);
                                } else if (blockTrue(matrixBool[i][j + 1]) && !blockTrue(matrixBool[i][j - 1])) {//caso3
                                    matrixBool[i][j] = new BlockBool(false, false, false, true);
                                } else if (blockTrue(matrixBool[i][j + 1]) && blockTrue(matrixBool[i][j - 1]) && blockTrue(matrixBool[i + 1][j]) && blockTrue(matrixBool[i - 1][j])) {
                                    matrixBool[i][j] = new BlockBool(true, true, true, true);//caso4
                                } else if (blockTrue(matrixBool[i - 1][j]) && !blockTrue(matrixBool[i + 1][j])) {//caso5

                                    matrixBool[i][j] = new BlockBool(true, false, true, false);
                                } else if (blockTrue(matrixBool[i + 1][j]) && !blockTrue(matrixBool[i - 1][j])) {//caso6

                                    matrixBool[i][j] = new BlockBool(true, false, true, false);
                                } else if (blockTrue(matrixBool[i + 1][j]) && blockTrue(matrixBool[i - 1][j])) {//caso7

                                    matrixBool[i + 1][j] = new BlockBool(true, false, true, false);
                                    matrixBool[i - 1][j] = new BlockBool(true, false, true, false);
                                    matrixBool[i][j] = new BlockBool(true, false, true, false);

                                }

                                important.drawMaze(g, bool, matrixNum1);
                                System.out.println(temp);
                            }
                        }

                    }
                }
            }
        });
        primaryStage.show();
    }

    @Override
    public void run() {

        long start;
        long elapsed;
        long wait;
        int fps = 30;
        long time = 1000 / fps;

        while (true) {
            try {
                start = System.nanoTime();
                elapsed = System.nanoTime() - start;
                wait = time - elapsed / 1000000;
                Thread.sleep(wait);
                GraphicsContext gc = this.canvas.getGraphicsContext2D();
                if (this.start) {
                    draw(gc);
                }

            } catch (InterruptedException ex) {
            }
        }
    }

    private void initComponents(Stage primaryStage) {
        try {
            this.pane = new VBox();
            this.scene = new Scene(this.pane, Variables.WIDTH, Variables.HEIGHT);
            this.canvas = new Canvas(Variables.WIDTH, Variables.HEIGHT);

            timeLbl = new Label("00:00:00");
            timeLbl.setFont(new Font("Arial", 30));
            StopWatch watch = new StopWatch(timeLbl);

            MenuBar mb_Menu = new MenuBar();
            Menu m_Options = new Menu("Options");
            MenuItem mI_Start = new MenuItem("Start");
            MenuItem mI_Exit = new MenuItem("Exit");

            mI_Start.setOnAction((event) -> {

                playMusic();
                startThreadWatch();

                this.start = true;

                this.smart.start();
                this.furious.start();
                this.item.start();
                this.fast.start();
            });
            mI_Exit.setOnAction((event) -> {
                System.exit(1);
            });
            m_Options.getItems().addAll(mI_Start, mI_Exit);
            mb_Menu.getMenus().addAll(m_Options);

            this.pane.getChildren().addAll(mb_Menu, timeLbl, this.canvas);

            primaryStage.setScene(this.scene);

            //Inicializamos cada hilo (personaje) y lo iniciamos
            matrixBool = important.fillMatrixBool7();
            matrixNum = important.fillMatixNum();


            this.item = new MovingItem(0, 0, 0, matrixBool, matrixNum, false, 3, 5);
            this.thread = new Thread(this);

            this.thread.start();
            this.smart = new Smart(80, 190, 0, matrixBool, matrixNum, 3, 0);
            this.furious = new Furious(80, 190, 0, matrixBool, matrixNum, 5, 0);
            this.fast = new Fast(80, 190, 0, matrixBool, matrixNum, 1, 0);
        } catch (BufferOverflowException ex) {
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, Variables.WIDTH, Variables.HEIGHT);

        important.drawTable(80, 640, 1200, gc);

        important.drawMaze(gc, matrixBool, matrixNum);
//        gc.drawImage(this.fast.getImage(), this.fast.getX(), this.fast.getY());
//        gc.drawImage(this.furious.getImage(), this.furious.getX(), this.furious.getY());
        if (memory.isCallejon()) {
            gc.drawImage(this.smart.getImage(), this.smart.getX() + this.smart.getImage().getWidth(), this.smart.getY(), -this.smart.getImage().getWidth(), this.smart.getImage().getHeight());
        } else {
            gc.drawImage(this.smart.getImage(), this.smart.getX(), this.smart.getY());
        }
        if (memory2.isCallejonFurious()) {
            gc.drawImage(this.furious.getImage(), this.furious.getX() + this.furious.getImage().getWidth(), this.furious.getY(), -this.furious.getImage().getWidth(), this.furious.getImage().getHeight());
        } else {
            gc.drawImage(this.furious.getImage(), this.furious.getX(), this.furious.getY());
        }
        if (memory3.isCallejonfast()) {
            gc.drawImage(this.fast.getImage(), this.fast.getX() + this.fast.getImage().getWidth(), this.fast.getY(), -this.fast.getImage().getWidth(), this.fast.getImage().getHeight());
        } else {
            gc.drawImage(this.fast.getImage(), this.fast.getX(), this.fast.getY());
        }

        if (!memory2.isDesappear()) {
            gc.drawImage(this.item.getImage(), this.item.getX(), this.item.getY());

        } else {

        }

    }

    EventHandler<WindowEvent> exit = new EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            System.exit(0);
        }
    };

    public boolean blockTrue(BlockBool b) {

        return b.getA() || b.getB() || b.getC() || b.getD();
    }

    public void playMusic() {
        AudioClip clip = new AudioClip(this.getClass().getResource("Dreams.wav").toString());
        clip.play();
    }

    private void startThreadWatch() {
        if (watchStart == true) {
            StopWatch watch = new StopWatch(timeLbl);
            watch.start();
        }
    }
}
