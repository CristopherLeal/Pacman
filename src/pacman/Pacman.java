/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;
import jpl.*;

/**
 *
 * @author lucasmachado
 */
public class Pacman {
    public static int state = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Query q1 = new Query("consult", new Atom("src/prolog/pacman.pl") );
        q1.hasSolution();
    }
    
}
