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
public class BufferMemoryFurious {
    private static boolean desappear;
    private static boolean callejon;
    private static int furiousI;
    private static int furiousJ;
    private static boolean callejonFurious;
    private static int itemI;
    private static int itemJ;
    private static boolean eaten =false;
    
    public BufferMemoryFurious() {
    }

    public static boolean isEaten() {
        return eaten;
    }

    public static void setEaten(boolean eaten) {
        BufferMemoryFurious.eaten = eaten;
    }

    public static int getItemI() {
        return itemI;
    }

    public static void setItemI(int itemI) {
        BufferMemoryFurious.itemI = itemI;
    }

    public static int getItemJ() {
        return itemJ;
    }

    public static void setItemJ(int itemJ) {
        BufferMemoryFurious.itemJ = itemJ;
    }
    
    public static boolean isCallejonFurious() {
        return callejonFurious;
    }

    public static void setCallejonFurious(boolean callejonFurious) {
        BufferMemoryFurious.callejonFurious = callejonFurious;
    }

    public static int getFuriousI() {
        return furiousI;
    }

    public static void setFuriousI(int furiousI) {
        BufferMemoryFurious.furiousI = furiousI;
    }

    public static int getFuriousJ() {
        return furiousJ;
    }

    public static void setFuriousJ(int furiousJ) {
        BufferMemoryFurious.furiousJ = furiousJ;
    }

//    public static int getFastI() {
//        return fastI;
//    }
//
//    public static void setFastI(int fastI) {
//        BufferMemoryFurious.fastI = fastI;
//    }
//
//    public static int getFastJ() {
//        return fastJ;
//    }
//
//    public static void setFastJ(int fastJ) {
//        BufferMemoryFurious.fastJ = fastJ;
//    }
    
    public static boolean isCallejon() {
        return callejon;
    }

    public static void setCallejon(boolean callejon) {
        BufferMemoryFurious.callejon = callejon;
    }
    
    public static boolean isDesappear() {
        return desappear;
    }

    public static void setDesappear(boolean desappear) {
        BufferMemoryFurious.desappear = desappear;
    }
    public boolean getEqualsJIFurious(){
        
        return !isEaten()&&((furiousI == itemI&&furiousJ==itemJ)||(furiousI == itemI&&furiousJ==itemJ)||(furiousI == itemI&&furiousJ==itemJ)||(furiousI == itemI&&furiousJ==itemJ));
    }
}
