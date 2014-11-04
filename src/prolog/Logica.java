/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolog;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.lang.Integer;
import jpl.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author cristopher
 */
public class Logica 
{
        
    public Logica()
    {
        Query q1 = new Query("consult", new Atom("src/prolog/pacman.pl"));
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
    
    public List<Position> movimentosPosiveis(int x1,int y1)
    {
        jpl.Integer i = new jpl.Integer(x1);
        jpl.Integer j = new jpl.Integer(y1);
        
        Variable x2 = new Variable("X2");
        Variable y2 = new Variable("Y2");
        
        Query q = new Query("mov", new Term[]{i,j,x2,y2});
        Hashtable[] solutions = q.allSolutions();
        
        List<Position> lista  = new ArrayList<Position>();
        
        for(Hashtable s:solutions)
        {
            int x = java.lang.Integer.parseInt(s.get("X2").toString()); 
            int y = java.lang.Integer.parseInt(s.get("Y2").toString());
            Position p = new Position(x,y);
            lista.add(p);
        }
        return lista;
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
    
    
    public String intelFant(int x1, int y1, int x2, int y2, String intel)
    {   
        
        Variable a = new Variable("X");
        jpl.Integer i1 = new jpl.Integer(x1);
        jpl.Integer j1 = new jpl.Integer(y1);
        jpl.Integer i2 = new jpl.Integer(x2);
        jpl.Integer j2 = new jpl.Integer(y2);

        Query q3 = new Query(intel, new Term[]{i1,j1,i2,j2,a});
        Hashtable result = q3.oneSolution();
        result.get("X").toString();
        return result.get("X").toString();
    }
    public List<Position> getPath(int x, int y){
        Pattern pattern= Pattern.compile("(\\d+)");
        List<Position> posList= new ArrayList<>();
        int X,Y = 0;
        if(posicao(pacmanX(),pacmanY())){
            String str=intelFant(x, y, pacmanX(), pacmanY(),"solvente");
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
    public List<Position> getPath2(int x, int y){
        Pattern pattern= Pattern.compile("(\\d+)");
        List<Position> posList= new ArrayList<>();
        int X,Y = 0;
        if(posicao(pacmanX(),pacmanY())){
            String str=intelFant(x, y, pacmanX(), pacmanY(),"solve2");
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
    public List<Position> getPath3(int x, int y){
        Pattern pattern= Pattern.compile("(\\d+)");
        List<Position> posList= new ArrayList<>();
        int X,Y = 0;
        if(posicao(pacmanX(),pacmanY())){
            String str=intelFant(x, y, pacmanX(), pacmanY(),"path");
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
    public Boolean comerFanstasmas(){
        Query q2 = new Query("comerFanstasmas");
        return q2.hasSolution();
    }
    public Boolean fanstasmaComeu(String str){
        Query q2 = new Query(str);
        return q2.hasSolution();
    }
    
    /**
     * Avalia se é permitido ao pacman comer um fantasma
     *
     * @param n indica o fanstasma
     * n==0 ---> fantasma vermelho
     * n==1 ---> fantasma azul
     * n==2 ---> fantasma amarelo
     * n==3 ---> fantasma rosa
     * @return 
     */
    
    public Boolean podeComerFanstasma(int n){
        Query q2;
        switch(n){
            case 0:
                q2 = new Query("comerBlinky");
                return q2.hasSolution();
            case 1:
                q2 = new Query("comerClyde");
                return q2.hasSolution();
            case 2:
                q2 = new Query("comerInky");
                return q2.hasSolution();
            case 3:
                q2 = new Query("comerPink");
                return q2.hasSolution();
            default:
                return false;
        }
    }
    
    public int FantasmaX(int n){
        Query q2;
        Variable a = new Variable("X");
        Variable b = new Variable("Y");

        switch(n){
            case 0:
                q2 = new Query("blinky", new Term[]{a,b});
                return java.lang.Integer.parseInt(q2.oneSolution().get("X").toString());
            case 1:
                q2 = new Query("clyde", new Term[]{a,b});
                return java.lang.Integer.parseInt(q2.oneSolution().get("X").toString());
            case 2:
                q2 = new Query("inky", new Term[]{a,b});
                return java.lang.Integer.parseInt(q2.oneSolution().get("X").toString());
            case 3:
                q2 = new Query("pinky", new Term[]{a,b});
                return java.lang.Integer.parseInt(q2.oneSolution().get("X").toString());
            default:
                return 0;
        }
    }
    
    public int FantasmaY(int n){
        Query q2;
        Variable a = new Variable("X");
        Variable b = new Variable("Y");

        switch(n){
            case 0:
                q2 = new Query("blinky", new Term[]{a,b});
                return java.lang.Integer.parseInt(q2.oneSolution().get("Y").toString());
            case 1:
                q2 = new Query("clyde", new Term[]{a,b});
                return java.lang.Integer.parseInt(q2.oneSolution().get("Y").toString());
            case 2:
                q2 = new Query("inky", new Term[]{a,b});
                return java.lang.Integer.parseInt(q2.oneSolution().get("Y").toString());
            case 3:
                q2 = new Query("pinky", new Term[]{a,b});
                return java.lang.Integer.parseInt(q2.oneSolution().get("Y").toString());
            default:
                return 0;
        }
    }
  
    public Boolean rightFantasma(int n){
        Query q2;
        
        switch(n){
            case 0:
                q2 = new Query("rightBlinky");
                return q2.hasSolution();
            case 1:
                q2 = new Query("rightClyde");
                return q2.hasSolution();
            case 2:
                q2 = new Query("rightInky");
                return q2.hasSolution();
            case 3:
                q2 = new Query("rightPinky");
                return q2.hasSolution();
            default:
                    return false;
        }
    }
    
    public Boolean leftFantasma(int n){
        Query q2;
        
        switch(n){
            case 0:
                q2 = new Query("leftBlinky");
                return q2.hasSolution();
            case 1:
                q2 = new Query("leftClyde");
                return q2.hasSolution();
            case 2:
                q2 = new Query("leftInky");
                return q2.hasSolution();
            case 3:
                q2 = new Query("leftPinky");
                return q2.hasSolution();
            default:
                    return false;
        }
    }
    
    public Boolean upFantasma(int n){
        Query q2;
        
        switch(n){
            case 0:
                q2 = new Query("upBlinky");
                return q2.hasSolution();
            case 1:
                q2 = new Query("upClyde");
                return q2.hasSolution();
            case 2:
                q2 = new Query("upInky");
                return q2.hasSolution();
            case 3:
                q2 = new Query("upPinky");
                return q2.hasSolution();
            default:
                    return false;
        }
    }
    
    public Boolean downFantasma(int n){
        Query q2;
        
        switch(n){
            case 0:
                q2 = new Query("downBlinky");
                return q2.hasSolution();
            case 1:
                q2 = new Query("downClyde");
                return q2.hasSolution();
            case 2:
                q2 = new Query("downInky");
                return q2.hasSolution();
            case 3:
                q2 = new Query("downPinky");
                return q2.hasSolution();
            default:
                    return false;
        }
    }
    
    public boolean matarFantasma(int n)
    {
        Query q2;
        
        switch(n){
            case 0:
                q2 = new Query("matarBlinky");
                return q2.hasSolution();
            case 1:
                q2 = new Query("matarClyde");
                return q2.hasSolution();
            case 2:
                q2 = new Query("matarInky");
                return q2.hasSolution();
            case 3:
                q2 = new Query("matarPinky");
                return q2.hasSolution();
            default:
                    return false;
        }
    }
    
    public boolean criarFantasma(int n)
    {
        Query q2;
        
        switch(n){
            case 0:
                q2 = new Query("criarBlinky");
                return q2.hasSolution();
            case 1:
                q2 = new Query("criarClyde");
                return q2.hasSolution();
            case 2:
                q2 = new Query("criarInky");
                return q2.hasSolution();
            case 3:
                q2 = new Query("criarPinky");
                return q2.hasSolution();
            default:
                    return false;
        }
    }
    
    public boolean colisao()
    {
        Query q = new Query("colisao");
        return q.hasSolution();
    }
    public boolean colisao1()
    {
        Query q = new Query("colisao1");
        return q.hasSolution();
    }
    public boolean colisao2()
    {
        Query q = new Query("colisao2");
        return q.hasSolution();
    }
    public boolean colisao3()
    {
        Query q = new Query("colisao3");
        return q.hasSolution();
    }
    public boolean colisao4()
    {
        Query q = new Query("colisao4");
        return q.hasSolution();
    }
}
