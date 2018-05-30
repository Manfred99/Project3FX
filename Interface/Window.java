package Interface;

import Domain.BlockBool;
import Domain.BlockNum;
import Domain.ImportantMethods;
import Domain.JumpingCharacter;
import Domain.RunningCharacter;
import Domain.StandingCharacter;
import Utility.Variables;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.event.MouseEvent;
import java.io.FileInputStream;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Window extends Application implements Runnable{

    
    private Thread thread;
    private Scene scene;
    private VBox pane;
    private Canvas canvas;
    private Image image;
    private BlockNum[][] matrixNum;
    private BlockBool[][] matrixBool;
    private StandingCharacter sc;
    private RunningCharacter rc;
    private JumpingCharacter jc;
    private boolean start = false;
    ImportantMethods important = new ImportantMethods();
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Maze runner");
        initComponents(primaryStage);
        primaryStage.setOnCloseRequest(exit);
        canvas.setOnMouseClicked((event) -> {
            double x=event.getX();
            double y=event.getY();
            
        
         if (x >= 70 && x <= 1200 && y >= 70 && y <= 640){
            System.out.println("Equis"+x);
            System.out.println("Ye"+y);
            BlockNum temp;
            BlockBool tempBool;
            for (int i = 0; i < matrixNum.length; i++) {
                for (int j = 0; j < matrixNum[0].length; j++) {
                    temp=matrixNum[i][j];
                    
                    if(temp.getA() <= y && temp.getB() <= x && temp.getC() >= y && temp.getD() >= x){
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
    
    @Override
    public void run() {
        
        long start;
        long elapsed;
        long wait;
        int fps = 30;
        long time = 1000/fps;

        while(true){
            try {
                start=System.nanoTime();
                elapsed=System.nanoTime()-start;                    
                wait = time-elapsed/1000000;
                Thread.sleep(wait);
                GraphicsContext gc = this.canvas.getGraphicsContext2D();
                if(this.start){
                    draw(gc);
                }
                
            } 
            catch (InterruptedException ex) {}
        }
    }

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
                 
                    this.start =true;
                
                    
                
                    this.rc.start();
                 
             });
             mI_Exit.setOnAction((event) -> {
                 System.exit(1);
             });
             m_Options.getItems().addAll(mI_Start,mI_Exit);
             mb_Menu.getMenus().addAll(m_Options);
             
            this.pane.getChildren().addAll(mb_Menu,this.canvas);
            
            primaryStage.setScene(this.scene);
            
            //Inicializamos cada hilo (personaje) y lo iniciamos
            
            matrixBool=important.fillMatrixBool5();
            matrixNum= important.fillMatixNum();
            this.rc = new RunningCharacter(80, 190, 0, matrixBool,matrixNum);
            
            this.thread = new Thread(this);
            this.thread.start();
        } 
        
        
        catch (BufferOverflowException ex){} catch (FileNotFoundException ex) {
            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void draw(GraphicsContext gc){
        gc.clearRect(0, 0, Variables.WIDTH, Variables.HEIGHT);
        
        
        
        important.drawTable(80, 640, 1200, gc);

        important.drawMaze(gc, matrixBool, matrixNum);
        gc.drawImage(this.rc.getImage(), this.rc.getX(), this.rc.getY());
    }
    
    EventHandler<WindowEvent> exit = new EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
            System.exit(0);
        }
    };
    
}
