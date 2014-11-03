/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.List;
import javax.swing.SwingUtilities;
import jpl.Atom;
import jpl.Query;
import prolog.Logica;
import prolog.Position;

/**
 *
 * @author lucasmachado
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Runnable r;
//
//        r = new Runnable() {
//
//            public void run() {
//                new PacmanGUI().startGUI();
//            }
//        };
//        SwingUtilities.invokeLater(r);
        
         new PacmanGUI().startGUI();
        
        
         
      //  Logica l = new Logica();
//        List <Position> lista = l.movimentosPosiveis(2, 2);
//        
//        for(Position p : lista)
//        {
//            System.out.println(p.getX()+","+ p.getY());
//        }
        
//        System.out.println(l.FantasmaX(3)+","+l.FantasmaY(3));
//        System.out.println( l.rightFantasma(3));
//         System.out.println(l.FantasmaX(3)+","+l.FantasmaY(3));
      
       
     }
}
