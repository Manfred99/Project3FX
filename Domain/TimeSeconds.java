package Domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manfr
 */
public class TimeSeconds {
    private static int seconds;
    private static boolean stopFast;
    private static int percentage;
    private static int totalPercentage=15;

    public TimeSeconds() {
        seconds=0;
        stopFast=false;
        percentage=100;
    }

    public static int getSeconds() {
        return seconds;
    }

    public static void setSeconds(int seconds) {
        TimeSeconds.seconds = seconds;
    }

    public boolean isStopFast() {
        
        return stopFast;
    }

    public static void setStopFast(boolean stop) {
        
            
        TimeSeconds.stopFast = stop;
    }

    public static int getPersentage() {
        
        return percentage;
    }

    public static void setPersentage(int seconds) {
        
        if(totalPercentage==0){
            setStopFast(true);
            TimeSeconds.totalPercentage=15;
        }
            
            TimeSeconds.totalPercentage-= seconds;
            if(totalPercentage==10){
                TimeSeconds.percentage = 66;
                setStopFast(false);
            }else if (totalPercentage==5){
                TimeSeconds.percentage = 33;
                setStopFast(false);
            }else if (totalPercentage==0){
                TimeSeconds.percentage = 0;
            }
            
            if(totalPercentage==0){
            setStopFast(true);
            
        }
            
            
        
        
    }
    
}
