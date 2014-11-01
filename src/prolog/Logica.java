/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolog;
import java.lang.Integer;
import jpl.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author cristopher
 */
public class Logica {
    
    public Logica()
    {
        Query q1 = new Query("consult", new Atom("src/prolog/level2.pl"));
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
     public String intelFant1(int x, int y)
    {   
        
        Variable a = new Variable("X");
        jpl.Integer i1 = new jpl.Integer(2);
        jpl.Integer j1 = new jpl.Integer(2);
        jpl.Integer i2 = new jpl.Integer(x);
        jpl.Integer j2 = new jpl.Integer(y);

        Query q3 = new Query("solve", new Term[]{i1,j1,i2,j2,a});
        Hashtable result = q3.oneSolution();
        System.out.println(result.get("X").toString());
        return result.get("X").toString();
    }
    public List<Position> getPath(){
        Pattern pattern= Pattern.compile("(\\d+)");
        List<Position> posList= new ArrayList<>();
        int X,Y = 0;
        if(posicao(pacmanX(),pacmanY())){
            String str=intelFant1(pacmanX(),pacmanY());
            Matcher matcher=pattern.matcher(str);
            while(matcher.find()){
            X=Integer.parseInt(matcher.group());
              if(matcher.find()){
                    Y=Integer.parseInt(matcher.group());
                }
                posList.add(new Position(X,Y));
            }
        }    
        return posList;
    }
}
