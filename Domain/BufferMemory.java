/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;

/**
 *
 * @author Oscar Luis
 */
public  class   BufferMemory {

    private static BlockNum itemLocation;
    private static BlockNum runnigLocation;
    private static boolean sameBlock;
    private static ArrayList<BlockNum> array = new ArrayList<>();
    private static int pos = -1;
    private static int runI;
    private static int runJ;
    private static int itemI;
    private static int itemJ;
    private static boolean desappear;
    private static boolean callejon;
    private static int fastI;
    private static int fastJ;
    private static int furiousI;
    private static int furiousJ;
    private static boolean callejonFurious;
   
    BufferMemoryFurious memoryFurious = new BufferMemoryFurious();
    BufferMemoryFast memoryFast = new BufferMemoryFast();
    
    public BufferMemory() {
    }

    

   
    
    public static boolean isCallejon() {
        return callejon;
    }

    public static void setCallejon(boolean callejon) {
        BufferMemory.callejon = callejon;
    }
    
    

    

    public static int getRunI() {
        return runI;
    }

    public static void setRunI(int runI) {
        BufferMemory.runI = runI;
    }

    public static int getRunJ() {
        return runJ;
    }

    public static void setRunJ(int runJ) {
        BufferMemory.runJ = runJ;
    }

    public static int getItemI() {
        return itemI;
    }
    

    public static void setItemI(int itemI) {
        BufferMemory.itemI = itemI;
    }

    public static int getItemJ() {
        return itemJ;
    }

    public static void setItemJ(int itemJ) {
        BufferMemory.itemJ = itemJ;
    }
    public boolean getEqualsJI(){
       
        return !memoryFurious.isEaten()&&((runI == itemI&&runJ==itemJ)||(runI == itemI&&runJ==itemJ)||(runI == itemI&&runJ==itemJ)||(runI == itemI&&runJ==itemJ));
    }
   
   

}
