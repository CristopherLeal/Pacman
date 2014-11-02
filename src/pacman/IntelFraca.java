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
public class IntelFraca implements Inteligencia
{

    private int x;
    private int y;
    private Logica logica;
    
    public IntelFraca(Logica logica)
    {
        this.logica = logica;
        x=2;
        y=2;
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
    
}
