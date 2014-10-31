/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

import javax.swing.SwingUtilities;
import jpl.Atom;
import jpl.Query;
import prolog.Inteligencia;

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
    
//            Inteligencia i = new Inteligencia();
//            System.out.println(i.posicao(1, 2));
//            System.out.println(i.pacman().get("X")+" " +i.pacman().get("Y"));
//            System.out.println(i.right());
//            System.out.println(i.pacman().get("X")+" " +i.pacman().get("Y"));
       
     }
}
