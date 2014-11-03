/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pacman;

import prolog.Logica;

/**
 *
 * @author lucasmachado
 */
public class IntelParado implements Inteligencia
{

   private int x;
   private int y;
    
   public IntelParado(Logica logica,int x,int y,int codGhost)
   {
       this.x=x;
       this.y=y;
       logica.matarFantasma(codGhost);
   }
   
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void proximoMovimento() {
        
    }

    @Override
    public int getSleep() {
       return 10000;
    }
    
}
