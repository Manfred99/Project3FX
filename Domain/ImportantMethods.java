package Domain;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oscar Luis
 */
public class ImportantMethods {
    //method to make the lines of images
    public void drawTable(int size, int d1, int d2,GraphicsContext g){
         
        
        for (int i = size; i < d1+size; i+=size) {
            g.strokeLine(size, i, d2, i);
            
        }
        for (int y = size; y < d2+size; y+=size)
            g.strokeLine(y,size,y, d1);
        
    }
    public int getD1(int pixels){
        int d1 = 0;
        
             int num1=0;
                for (int i = 0; i <=680; i++) {
                    if(pixels*i<=680){
                        num1=i;
                    }else{
                        i=680;
                    }
                }
                
            d1=pixels*num1;  
            return d1;
    }
    public BlockNum[][] fillMatixNum(){
        BlockNum[][] matrix = new BlockNum[7][14];
        BlockNum block;
        int dim1=0,dim2=0,dim3=0,dim4=0;
        for (int i = 0,x=80; i < matrix.length; i++,x+=80) {
            for (int j = 0,y=80; j < matrix[0].length; j++,y+=80) {
                dim1=x;
                dim2=y;
                dim3=x+80;
                dim4=y+80;
                block = new BlockNum(dim1, dim2, dim3, dim4);
                matrix[i][j]=block;
            }
        }
        return matrix;
    }
    
    public BlockBool[][] fillMatrixBool(){
        BlockBool[][] matrix = new BlockBool[7][14];
        BlockBool block;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i==1&&j<=3){
                    block = new BlockBool(false, false, false, true);
                }else if(i>=1&&i<=4&&j==4){
                    block = new BlockBool(false, false, true, false);
                }else if(i==5&&j>=4&&j<=13){
                    block = new BlockBool(false, false, false, true);
                }else{
                    block = new BlockBool(false, false, false, false);
                }
                
                matrix[i][j]=block;
            }
        }
        return matrix;
    }
    public void drawMaze(GraphicsContext g, BlockBool[][] matrixBool , BlockNum[][] matrixNum){
        BlockBool blockBool;
        BlockNum blockNum;
        for (int i = 0; i < matrixBool.length; i++) {
            for (int j = 0; j < matrixBool[0].length; j++) {
                blockBool = matrixBool[i][j];
                blockNum = matrixNum[i][j];
                if(blockBool.getA()==true||blockBool.getB()==true ||blockBool.getC()==true||blockBool.getD()==true){
                    g.setFill(Paint.valueOf("WHITE"));
                    g.fillRect(blockNum.getB()+1, blockNum.getA()+1, 79,79);
                    
                }else{
                    g.setFill(Paint.valueOf("BLACK"));
                    g.fillRect(blockNum.getB()+1, blockNum.getA()+1, 79,79 );
                }
                
            }
        }
    }
    
    public BlockBool[][] fillMatrixBool2(){
        BlockBool[][] matrix = new BlockBool[7][14];
        BlockBool block;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i==1&&j<=3){
                    block = new BlockBool(false, false, false, true);
                }
                else if(i>=1&&i<=4&&j==4){
                    block = new BlockBool(false, false, true, false);
                }
                else if(i==5&&j>=4&&j<6){
                    block = new BlockBool(false, false, false, true);
                }
                else if(i>=2&&i<=5&&j==6){
                    block = new BlockBool(true, false, false, false);
                }
                else if(i==1&&j>=6&&j<8){
                    block = new BlockBool(false, false, false, true);
                }
                else if(i>=1&&i<=4&&j==8){
                    block = new BlockBool(false, false, true, false);
                }
                else if(i==5&&j>=8&&j<14){
                    block = new BlockBool(false, false, false, true);
                }
                else{
                    block = new BlockBool(false, false, false, false);
                }
                
                matrix[i][j]=block;
            }
        }
        return matrix;
    }
    
    public BlockBool[][] fillMatrixBool3(){
        BlockBool[][] matrix = new BlockBool[7][14];
        BlockBool block;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i==1&&j<=3){
                    block = new BlockBool(false, true, false, true);
                }else if (i==1 &&j==4){
                    block = new BlockBool(false, true, true, false);
                }
                else if(i>=2&&i<=4&&j==4){
                    block = new BlockBool(true, false, true, false);
                }
                else if(i==5&&j==4){
                    block = new BlockBool(true, false, false, true);
                }
                else if(i==5&&j==5){
                    block = new BlockBool(false, true, false, true);
                }
                else if(i==5&&j==6){
                    block = new BlockBool(true, true, false, false);
                }
                else if(i>=2&&i<=4&&j==6){
                    block = new BlockBool(true, false, true, false);
                }
                else if(i==1&&j==6){
                    block = new BlockBool(false, false, true, true);
                }
                else if(i==1&&j==7){
                    block = new BlockBool(false, true, false, true);
                }
                else if(i==1&&j==8){
                    block = new BlockBool(false, true, true, false);
                }
                else if(i>=2&&i<=4&&j==8){
                    block = new BlockBool(true, false, true, false);
                }
                else if(i==5&&j==8){
                    block = new BlockBool(true, false, false, true);
                }
                else if(i==5&&j>=8&&j<13){
                    block = new BlockBool(false, true, false, true);
                }
                else{
                    block = new BlockBool(false, false, false, false);
                }
                
                matrix[i][j]=block;
            }
        }
        return matrix;
    }
    public BlockBool[][] fillMatrixBool4(){
        BlockBool[][] matrix = new BlockBool[7][14];
        BlockBool block;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i==1&&j<=3){
                    block = new BlockBool(false, false, false, true);
                }
                else if(i>=1&&i<=4&&j==4){
                    block = new BlockBool(false, false, true, false);
                }
                else if(i==5&&j>=4&&j<6){
                    block = new BlockBool(false, false, false, true);
                }
                else if(i>=2&&i<=5&&j==6){
                    block = new BlockBool(true, false, false, false);
                }
                else if(i==1&&j>=6&&j<8){
                    block = new BlockBool(false, false, false, true);
                }
                else if(i>=1&&i<=4&&j==8){
                    block = new BlockBool(false, false, true, false);
                }
                else if(i==5&&j>=8&&j<13){
                    block = new BlockBool(false, false, false, true);
                }
                else{
                    block = new BlockBool(false, false, false, false);
                }
                
                matrix[i][j]=block;
            }
        }
        return matrix;
    }
    
    
    
}
