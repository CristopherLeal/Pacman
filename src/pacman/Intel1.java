/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import java.util.ArrayList;
import java.util.List;
import prolog.Logica;
import prolog.Position;

/**
 *
 * @author cristopher
 */
public class Intel1 implements Inteligencia {

    private int x;
    private int y;
    private int iter;
    Logica logica;
    List<Position> pos;
    //importante que todos tenham a mesma instancia da logica
    Intel1(Logica logica)
    {
        this.logica=logica;
        x=2;
        y=2;
        iter=0;
        pos= logica.getPath(2 , 2);
    }
    
    @Override
    public void proximoMovimento() 
    {
        
        if(iter<pos.size()){
            x=pos.get(iter).getX();
            y=pos.get(iter).getY();
            iter++;
        }
        if(iter==pos.size()||iter>4){
            iter=0;
            pos=logica.getPath(x , y);
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
