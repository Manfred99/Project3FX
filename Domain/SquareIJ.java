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
public class SquareIJ {
    private int j;
    private int i;

    public SquareIJ(int j, int i) {
        this.j = j;
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "SquareIJ{" + "j=" + j + ", i=" + i + '}';
    }
    
}
