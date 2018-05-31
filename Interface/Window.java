package Interface;

import Domain.BlockBool;
import Domain.BlockNum;
import Domain.ImportantMethods;
import Domain.MovingItem;
import Domain.RunningCharacter;
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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * Clase encargada de crear la ventana donde se ejecutaran el laberinto con sus
 * dichas funciones como lo es el movimiento del caracter extiende a Application
 * e implementa Runnable
 */
public class Window extends Application implements Runnable {

    private Thread thread;
    private Scene scene;
    private VBox pane;
    private Canvas canvas;
    private Image image;
    private BlockNum[][] matrixNum;
    private BlockBool[][] matrixBool;
    private RunningCharacter rc;
    private MovingItem mi;
    private boolean start = false;
    ImportantMethods important = new ImportantMethods();

    /**
     * start inicia el hilo en el que se va a ejecutar la ventana
     *
     * @param primaryStage la ventana en FX que se va a ejecutar cuando se corra
     * el hilo
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Maze runner");
        initComponents(primaryStage);
        primaryStage.setOnCloseRequest(exit);
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

                        if (temp.getA() <= y && temp.getB() <= x && temp.getC() >= y && temp.getD() >= x) {
                            tempBool = matrixBool[i][j];
                            System.out.println(temp);
                            System.out.println(tempBool);
//                        Graphics g = getGraphics();
//                        g.setColor(Color.yellow);
//                        g.fillRect(temp.getB(), temp.getA(),80, 80);
                        }

                    }
                }
            }
        });
        primaryStage.show();
    }

    /**
     * run se encarga de correr el programa para dibujar el laberinto
     */
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

    /**
     * metodo encargado de inicializar los componentes que se van a utilizar
     *
     * @param primaryStage la ventana en FX que se va a ejecutar
     */
    private void initComponents(Stage primaryStage) {
        try {
            this.pane = new VBox();
            this.scene = new Scene(this.pane, Variables.WIDTH, Variables.HEIGHT);
            this.canvas = new Canvas(Variables.WIDTH, Variables.HEIGHT);
            MenuBar mb_Menu = new MenuBar();
            Menu m_Options = new Menu("Options");
            MenuItem mI_Start = new MenuItem("Start");
            MenuItem mI_Exit = new MenuItem("Exit");

            mI_Start.setOnAction((event) -> {

                this.start = true;

                this.rc.start();
                this.mi.start();

            });
            mI_Exit.setOnAction((event) -> {
                System.exit(1);
            });
            m_Options.getItems().addAll(mI_Start, mI_Exit);
            mb_Menu.getMenus().addAll(m_Options);

            this.pane.getChildren().addAll(mb_Menu, this.canvas);

            primaryStage.setScene(this.scene);

            //Inicializamos cada hilo (personaje) y lo iniciamos
            matrixBool = important.fillMatrixBool5();
            matrixNum = important.fillMatixNum();
            this.rc = new RunningCharacter(80, 190, 0, matrixBool, matrixNum);
            this.mi = new MovingItem(80, 190, 0, matrixBool, matrixNum);
            
            this.thread = new Thread(this);
            this.thread.start();
        } catch (BufferOverflowException ex) {
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param gc metodo de grafico para poder dibujar el laberinto y todo lo
     * relacionado a este
     */
    private void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, Variables.WIDTH, Variables.HEIGHT);

        important.drawTable(80, 640, 1200, gc);

        important.drawMaze(gc, matrixBool, matrixNum);
        gc.drawImage(this.rc.getImage(), this.rc.getX(), this.rc.getY());
        gc.drawImage(this.mi.getImage(), this.mi.getX(), 170);
    }

    EventHandler<WindowEvent> exit = new EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            System.exit(0);
        }
    };

}
