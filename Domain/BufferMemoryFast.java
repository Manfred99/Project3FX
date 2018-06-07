/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author manfr
 */
public class BufferMemoryFast {
   
    private static int fastI;
    private static int fastJ;
    private static boolean callejonfast;
    private static int itemI;
    private static int itemJ;
    private static boolean stop;
    TimeSeconds tm = new TimeSeconds();
    BufferMemoryFurious memoryFurious = new BufferMemoryFurious();
    

    public BufferMemoryFast() {
    }

    public boolean isStop() {
        stop = tm.isStopFast();
        System.out.println(stop);
        return stop;
    }

    public static void setStop(boolean stop) {
        BufferMemoryFast.stop = stop;
    }

    public static int getFastI() {
        return fastI;
    }

    public static void setFastI(int fastI) {
        BufferMemoryFast.fastI = fastI;
    }

    public static int getFastJ() {
        return fastJ;
    }

    public static void setFastJ(int fastJ) {
        BufferMemoryFast.fastJ = fastJ;
    }

    public static boolean isCallejonfast() {
        return callejonfast;
    }

    public static void setCallejonfast(boolean callejonfast) {
        BufferMemoryFast.callejonfast = callejonfast;
    }

    public static int getItemI() {
        return itemI;
    }

    public static void setItemI(int itemI) {
        BufferMemoryFast.itemI = itemI;
    }

    public static int getItemJ() {
        return itemJ;
    }

    public static void setItemJ(int itemJ) {
        BufferMemoryFast.itemJ = itemJ;
    }
     public boolean getEqualsJIFast(){
         
        
        return !memoryFurious.isEaten()&&(fastI == itemI&&fastJ==itemJ);
    }

}
