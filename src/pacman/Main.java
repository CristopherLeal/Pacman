/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

import javax.swing.SwingUtilities;
import jpl.Atom;
import jpl.Query;
import prolog.Logica;

/**
 *
 * @author lucasmachado
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Runnable r;

        r = new Runnable() {
            public void run() {
                new PacmanGUI().startGUI();
            }
        };
        SwingUtilities.invokeLater(r);
    
           
       
     }
}
