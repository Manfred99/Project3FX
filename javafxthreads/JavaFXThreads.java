/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxthreads;

import javafx.application.Application;

import Interface.Window;

/**
 *
 * @author root
 */
public class JavaFXThreads {

    /**
     * El programa JavaFXThreads implementa una aplicacion que se carga con una
     * interfaz hecha con javaFX y que se encarga de mover sprites a traves de
     * una matriz booleana y una matriz numerica para hacer una simulacion de un
     * laberinto
     *
     * @authors Manfred Gonzalez Hernandez B73331, Emanuel Solano Navarro
     * B77436, Jean Paul Sagot B56438
     * @since 25-05-2018
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(Window.class, args);

    }

}
