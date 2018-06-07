package Domain;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;

/**
 *
 * Clase encargada de contener varios metodos importantes para la correcta
 * funcionalidad del proyecto entre ellos la creacion de matrices para la
 * movilidad de el personaje
 */
public class ImportantMethods {

    /**
     * drawTable method to make the lines of images
     *
     * @param size Tamaño de un cuadrante
     * @param d1 Ancho de la matriz total
     * @param d2 Largo de la matriz total
     * @param g metodo de grafico para poder dibujar las lineas correspondientes
     */
    public void drawTable(int size, int d1, int d2, GraphicsContext g) {

        for (int i = size; i < d1 + size; i += size) {
            g.strokeLine(size, i, d2, i);

        }
        for (int y = size; y < d2 + size; y += size) {
            g.strokeLine(y, size, y, d1);
        }

    }

    public int getD1(int pixels) {
        int d1 = 0;

        int num1 = 0;
        for (int i = 0; i <= 680; i++) {
            if (pixels * i <= 680) {
                num1 = i;
            } else {
                i = 680;
            }
        }

        d1 = pixels * num1;
        return d1;
    }//drawTable

    /**
     * fillMatrixNum se encarga de llenar la matriz con cuadrantes y sus
     * respectivas coordenadas numericas
     *
     * @return BlockNum[][] retorna una matriz llena con cuadrantes numericos
     */
    public BlockNum[][] fillMatixNum() {
        BlockNum[][] matrix = new BlockNum[7][14];
        BlockNum block;
        int dim1 = 0, dim2 = 0, dim3 = 0, dim4 = 0;
        for (int i = 0, x = 80; i < matrix.length; i++, x += 80) {
            for (int j = 0, y = 80; j < matrix[0].length; j++, y += 80) {
                dim1 = x;
                dim2 = y;
                dim3 = x + 80;
                dim4 = y + 80;
                block = new BlockNum(dim1, dim2, dim3, dim4);
                matrix[i][j] = block;
            }
        }
        return matrix;
    }

    /**
     * fillMatrixBool se encarga de llenar la matriz con cuadrantes y sus
     * respectivos valores booleanos
     *
     * @return BlockBool[][] retorna una matriz llena con cuadrantes booleanos
     */
    public BlockBool[][] fillMatrixBool() {
        BlockBool[][] matrix = new BlockBool[7][14];
        BlockBool block;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 1 && j <= 3) {
                    block = new BlockBool(false, false, false, true);
                } else if (i >= 1 && i <= 4 && j == 4) {
                    block = new BlockBool(false, false, true, false);
                } else if (i == 5 && j >= 4 && j <= 13) {
                    block = new BlockBool(false, false, false, true);
                } else {
                    block = new BlockBool(false, false, false, false);
                }

                matrix[i][j] = block;
            }
        }
        return matrix;
    }

    /**
     * drawMaze se encarga de dibujar el laberinto en el que se ejecutara el
     * programa y donde se moveran los sprites
     *
     * @param g metodo grafico para poder rellenar los cuadrantes, blanco(camino
     * abierto), negro(camino cerrado)
     * @param matrixBool matriz booleana para poder evaluar si esta abierto o
     * cerrado
     * @param matrixNum matriz numerica para poder determinar los coordenadas de
     * los cuadrantes
     */
    public void drawMaze(GraphicsContext g, BlockBool[][] matrixBool, BlockNum[][] matrixNum) {
        BlockBool blockBool;
        BlockNum blockNum;
        for (int i = 0; i < matrixBool.length; i++) {
            for (int j = 0; j < matrixBool[0].length; j++) {
                blockBool = matrixBool[i][j];
                blockNum = matrixNum[i][j];
                if (blockBool.getA() == true || blockBool.getB() == true || blockBool.getC() == true || blockBool.getD() == true) {
                    g.setFill(Paint.valueOf("WHITE"));
                    g.fillRect(blockNum.getB() + 1, blockNum.getA() + 1, 79, 79);

                } else {
                    g.setFill(Paint.valueOf("BLACK"));
                    g.fillRect(blockNum.getB() + 1, blockNum.getA() + 1, 79, 79);
                }

            }
        }
    }

    public BlockBool[][] fillMatrixBool2() {
        BlockBool[][] matrix = new BlockBool[7][14];
        BlockBool block;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 1 && j <= 3) {
                    block = new BlockBool(false, false, false, true);
                } else if (i >= 1 && i <= 4 && j == 4) {
                    block = new BlockBool(false, false, true, false);
                } else if (i == 5 && j >= 4 && j < 6) {
                    block = new BlockBool(false, false, false, true);
                } else if (i >= 2 && i <= 5 && j == 6) {
                    block = new BlockBool(true, false, false, false);
                } else if (i == 1 && j >= 6 && j < 8) {
                    block = new BlockBool(false, false, false, true);
                } else if (i >= 1 && i <= 4 && j == 8) {
                    block = new BlockBool(false, false, true, false);
                } else if (i == 5 && j >= 8 && j < 14) {
                    block = new BlockBool(false, false, false, true);
                } else {
                    block = new BlockBool(false, false, false, false);
                }

                matrix[i][j] = block;
            }
        }
        return matrix;
    }

    public BlockBool[][] fillMatrixBool3() {
        BlockBool[][] matrix = new BlockBool[7][14];
        BlockBool block;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 1 && j <= 3) {
                    block = new BlockBool(false, true, false, true);
                } else if (i == 1 && j == 4) {
                    block = new BlockBool(false, true, true, false);
                } else if (i >= 2 && i <= 4 && j == 4) {
                    block = new BlockBool(true, false, true, false);
                } else if (i == 5 && j == 4) {
                    block = new BlockBool(true, false, false, true);
                } else if (i == 5 && j == 5) {
                    block = new BlockBool(false, true, false, true);
                } else if (i == 5 && j == 6) {
                    block = new BlockBool(true, true, false, false);
                } else if (i >= 2 && i <= 4 && j == 6) {
                    block = new BlockBool(true, false, true, false);
                } else if (i == 1 && j == 6) {
                    block = new BlockBool(false, false, true, true);
                } else if (i == 1 && j == 7) {
                    block = new BlockBool(false, true, false, true);
                } else if (i == 1 && j == 8) {
                    block = new BlockBool(false, true, true, false);
                } else if (i >= 2 && i <= 4 && j == 8) {
                    block = new BlockBool(true, false, true, false);
                } else if (i == 5 && j == 8) {
                    block = new BlockBool(true, false, false, true);
                } else if (i == 5 && j >= 8 && j < 13) {
                    block = new BlockBool(false, true, false, true);
                } else {
                    block = new BlockBool(false, false, false, false);
                }

                matrix[i][j] = block;
            }
        }
        return matrix;
    }

    public BlockBool[][] fillMatrixBool4() {
        BlockBool[][] matrix = new BlockBool[7][14];
        BlockBool block;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 1 && j <= 3) {
                    block = new BlockBool(false, false, false, true);
                } else if (i >= 1 && i <= 4 && j == 4) {
                    block = new BlockBool(false, false, true, false);
                } else if (i == 5 && j >= 4 && j < 6) {
                    block = new BlockBool(false, false, false, true);
                } else if (i >= 2 && i <= 5 && j == 6) {
                    block = new BlockBool(true, false, false, false);
                } else if (i == 1 && j >= 6 && j < 8) {
                    block = new BlockBool(false, false, false, true);
                } else if (i >= 1 && i <= 4 && j == 8) {
                    block = new BlockBool(false, false, true, false);
                } else if (i == 5 && j >= 8 && j < 13) {
                    block = new BlockBool(false, false, false, true);
                } else {
                    block = new BlockBool(false, false, false, false);
                }

                matrix[i][j] = block;
            }
        }
        return matrix;
    }

    public BlockBool[][] fillMatrixBool5() {
        BlockBool[][] matrix = new BlockBool[7][14];
        BlockBool block;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 1 && j <= 3) {
                    block = new BlockBool(false, false, false, true);
                } else if (i == 1 && j == 4) {
                    block = new BlockBool(false, true, true, false);
                } else if (i >= 2 && i <= 4 && j == 4) {
                    block = new BlockBool(false, false, true, false);
                } else if (i == 5 && j == 4) {
                    block = new BlockBool(true, false, false, true);
                } else if (i == 5 && j == 5) {
                    block = new BlockBool(false, false, false, true);
                } else if (i == 5 && j == 6) {
                    block = new BlockBool(true, true, false, false);
                } else if (i >= 2 && i <= 4 && j == 6) {
                    block = new BlockBool(true, false, false, false);
                } else if (i == 1 && j == 6) {
                    block = new BlockBool(false, false, true, true);
                } else if (i == 1 && j == 7) {
                    block = new BlockBool(false, false, false, true);
                } else if (i == 1 && j == 8) {
                    block = new BlockBool(false, true, true, false);
                } else if (i >= 2 && i <= 4 && j == 8) {
                    block = new BlockBool(false, false, true, false);
                } else if (i == 5 && j == 8) {
                    block = new BlockBool(true, false, false, true);
                } else if (i == 5 && j >= 8 && j < 13) {
                    block = new BlockBool(false, false, false, true);
                } else {
                    block = new BlockBool(false, false, false, false);
                }

                matrix[i][j] = block;
            }
        }
        return matrix;
    }

    public BlockBool[][] fillMatrixBool6() {
        BlockBool[][] matrix = new BlockBool[7][14];
        BlockBool block;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 1 && j <= 3) {
                    block = new BlockBool(false, false, false, true);
                } else {
                    block = new BlockBool(false, false, false, false);
                }

                matrix[i][j] = block;
            }
        }
        return matrix;
    }

    public BlockBool[][] fillMatrixBool7() {
        BlockBool[][] matrix = new BlockBool[7][14];
        BlockBool block;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 1 && j <= 2) {
                    block = new BlockBool(false, false, false, true);
                } 
                else if (i == 1 && j == 3) {
                    block = new BlockBool(false, true, true, false);//esquina 1
                } 
                else if (i == 2 && j == 3) {
                    block = new BlockBool(false, false, true, false);
                } 
                else if (i == 3 && j <= 4&&j!=3) {
                    block = new BlockBool(false, false, false, true);
                }
                else if (i == 3 && j==3) {
                    block = new BlockBool(true, true, true, true);
                    //block = new BlockBool(false, false, false, false);
                }
                else if (i == 4 && j == 3) {
                    block = new BlockBool(true, false, false, false);
                }
                else if (i == 5 && j <= 2) {
                    block = new BlockBool(false, false, false, true);
                }
                else if (i == 5 && j == 3) {
                    block = new BlockBool(true, true, false, false);//esquina 2
                }
                else if (i == 3 && j == 5) {
                    block = new BlockBool(true, true, false, false);//esquina 3
                }
                else if (i == 2 && j == 5) {
                    block = new BlockBool(true, false, false, false);
                } 
                else if (i == 1 && j == 5) {
                    block = new BlockBool(false, false, true, true);//esquina 4
                }
                else if (i == 1 && j==6) {
                    block = new BlockBool(false, false, false, true);
                }
                else if (i == 1 && j == 7) {//Aqui puedo hacer algo si se cae
                    block = new BlockBool(false, true, true, true);
                } 
                else if (i == 1 && j == 8) {
                    block = new BlockBool(false, true, false, false);
                }
                else if (i >=2&&i<=4 && j == 7) {
                    block = new BlockBool(false, false, true, false);
                }
                else if (i==5 && j == 6) {
                    block = new BlockBool(false, false, false, true);
                }
                else if (i==5 && j == 7) {
                    block = new BlockBool(true, false, false, true);//Aqui puedo hacer algo tambien 
                }
                else if (i==5 && j >=8&&j<=9) {
                    block = new BlockBool(false, false, false, true);
                }
                else if (i==5 && j==10) {
                    block = new BlockBool(true, true, false, true);//Aqui puedo hacer algo tambien 
                }
                else if (i==3&& j==10) {
                    block = new BlockBool(false, false, true, false);
                }
                else if (i==4&& j==10) {
                    block = new BlockBool(true, false, false, false);
                }
                else if (i==5&& j>=11&&j<=13) {
                    block = new BlockBool(false, false, false, true);
                }
//                else if (i == 5 && j == 5) {
//                    block = new BlockBool(false, false, false, true);
//                } 
//                else if (i == 5 && j == 6) {
//                    block = new BlockBool(true, true, false, false);
//                } 
//                else if (i >= 2 && i <= 4 && j == 6) {
//                    block = new BlockBool(true, false, false, false);
//                } 
//                else if (i == 1 && j == 6) {
//                    block = new BlockBool(false, false, true, true);
//                } 
//                else if (i == 1 && j == 7) {
//                    block = new BlockBool(false, false, false, true);
//                } 
//                else if (i == 1 && j == 8) {
//                    block = new BlockBool(false, true, true, false);
//                } 
//                else if (i >= 2 && i <= 4 && j == 8) {
//                    block = new BlockBool(false, false, true, false);
//                } 
//                else if (i == 5 && j == 8) {
//                    block = new BlockBool(true, false, false, true);
//                } 
//                else if (i == 5 && j >= 8 && j < 13) {
//                    block = new BlockBool(false, false, false, true);
//                } 
                else {
                    block = new BlockBool(false, false, false, false);
                }

                matrix[i][j] = block;
            }
        }
        return matrix;
    }
}
