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
public class Logica {
    
    public Logica()
    {
        Query q1 = new Query("consult", new Atom("src/prolog/level1.pl"));
        q1.hasSolution();
    }
    
    
    public Hashtable pacman()
    {
        
        Variable a = new Variable("X");
        Variable b = new Variable("Y");
        Variable c = new Variable("Z");
        
        Query q2;
        q2 = new Query("pacman", new Term[]{a,b,c});
        
        Hashtable result = q2.oneSolution();
        return result;     
    }
    
    public int pacmanX()
    {
        return java.lang.Integer.parseInt(pacman().get("X").toString());
    }
    
    public int pacmanY()
    {
        return java.lang.Integer.parseInt(pacman().get("Y").toString());
    }
    
    public char pacmanDir()
    {
         char c = pacman().get("Z").toString().charAt(0);
         return c;
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
    
     public Boolean left()
    {
        Query q2 = new Query("left");
        return q2.hasSolution();
    }
    
    public Boolean up()
    {
        Query q2 = new Query("up");
        return q2.hasSolution();
    } 
    
    public Boolean down()
    {
        Query q2 = new Query("down");
        return q2.hasSolution();
    }
}
