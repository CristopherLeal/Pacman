/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacman;

import prolog.Logica;

/**
 *
 * @author cristopher
 */
public class Intel1 implements Inteligencia {

    private int x;
    private int y;
    Logica logica;
    
    //importante que todos tenham a mesma instancia da logica
    Intel1(Logica logica)
    {
        this.logica=logica;
        x=1;
        y=1;
    }
    
    @Override
    public void proximoMovimento() 
    {
      if(x < 20)
      {
       x++;
       y++;
      }
      else
      {
          x=1;
          y=1;
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
