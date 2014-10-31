/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolog;
import jpl.*;
import java.util.*;
/**
 *
 * @author cristopher
 */
public class Inteligencia {
    
    public Inteligencia()
    {
        Query q1 = new Query("consult", new Atom("src/prolog/level1.pl"));
        q1.hasSolution();
    }
    
    
    public Hashtable pacman()
    {
        
        Variable a = new Variable("X");
        Variable b = new Variable("Y");
        
        Query q2;
        q2 = new Query("pacman", new Term[]{a,b});
        
        Hashtable result = q2.oneSolution();
        return result;     
    }
    
    public Boolean posicao(int X,int Y)
    {
        jpl.Integer i = new jpl.Integer(X);
        jpl.Integer j = new jpl.Integer(Y);

        Query q2 = new Query("pos", new Term[]{i,j});
       
        return q2.hasSolution();
    }
    
    public Boolean right()
    {
        Query q2 = new Query("right");
        return q2.hasSolution();
    }
    
}
