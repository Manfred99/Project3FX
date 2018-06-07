package Domain;

import Interface.Window;
import javafx.application.Platform;
import javafx.scene.control.Label;

/**
 *
 * StopWatch es un Thread que se encarga de mostrar sec:seg:secSeg en lo que
 * dura el character dentro del laberinto
 */
public class StopWatch extends Thread {

    Label showTime;

    public StopWatch(Label timer) {
        super();
        this.showTime = timer;
    }

    

    @Override
    public void run() {
        try {
            int time = 0;
            while (Window.watchStart) {
                Thread.sleep(16);
                execThreadWatch(time);
                time++;
            }
        } catch (Exception e) {
            System.out.println("Exception on thread: " + e.getMessage());
        }
    }

    private void execThreadWatch(int time) {
        Window.mil++;

        if (Window.mil > 59) {
            Window.mil = 0;
            Window.sec++;
        } else if (Window.sec > 59) {
            Window.sec = 0;
            Window.min++;
        }
        String textmil = "", textsec = "", textmin = "";
        textmil += Window.mil;
        textsec += Window.sec;
        textmin += Window.min;

        String watch = textmin + ":" + textsec + ":" + textmil;
        Platform.runLater(() -> showTime.setText(watch));

    }
}
