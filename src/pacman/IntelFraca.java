/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.util.Collections;
import java.util.List;
import prolog.Logica;
import prolog.Position;

/**
 *
 * @author cristopher
 */
public class IntelFraca implements Inteligencia {

    private int x;
    private int y;
    private int iter;
    private int codGhost;
    Logica logica;
    List<Position> pos;
    //importante que todos tenham a mesma instancia da logica
    IntelFraca(Logica logica,int codGhost)
    {
        this.logica=logica;
        this.codGhost = codGhost;
        x=logica.FantasmaX(codGhost);
        y=logica.FantasmaY(codGhost);
        iter=0;
        pos= logica.getPath(x , y);
    }
    
//    IntelFraca(Logica logica,int X,int Y)
//    {
//        this.logica=logica;
//        x=X;
//        y=Y;
//        iter=0;
//        pos= logica.getPath2(x , y);
//    }
    
    @Override
    public void proximoMovimento() 
    {
        
        if(iter<pos.size()){
           
            int x1 = pos.get(iter).getX();
            int y1 = pos.get(iter).getY();
                
            if(x1==x+1 && y1==y)
            {
                logica.rightFantasma(codGhost);
            }
            else
                if(x1==x-1 && y1==y)
                {
                    logica.leftFantasma(codGhost);
                }
                else
                    if(x1==x && y1==y+1)
                    {
                        logica.downFantasma(codGhost);
                    }
                    else
                       if(x1==x && y1==y-1)
                       {
                            logica.upFantasma(codGhost); 
                       }
            
            x=logica.FantasmaX(codGhost);
            y=logica.FantasmaY(codGhost);
                      
            iter++;
            
        }
        //Para a inteligencia solvente, a atualizacao de 10 está boa
        //if(iter==pos.size()||iter>14){
            //iter=0;
            //pos=logica.getPath(x , y);
        //}
        //Para as outras inteligências, melhor não atualizar, somente quando ele chegar
        if(iter==pos.size()-1){
            iter=0;
            pos=logica.getPath2(x , y);
        }      
             
    }
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
    
}
