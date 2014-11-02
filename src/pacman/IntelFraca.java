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
    Logica logica;
    List<Position> pos;
    //importante que todos tenham a mesma instancia da logica
    IntelFraca(Logica logica)
    {
        this.logica=logica;
        x=2;
        y=2;
        iter=0;
        pos= logica.getPath(2 , 2);
    }
    
    IntelFraca(Logica logica,int X,int Y)
    {
        this.logica=logica;
        x=X;
        y=Y;
        iter=0;
        pos= logica.getPath2(x , y);
    }
    
    @Override
    public void proximoMovimento() 
    {
        
        if(iter<pos.size()){
            x=pos.get(iter).getX();
            y=pos.get(iter).getY();
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
