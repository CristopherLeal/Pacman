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
public class IntelFraca implements Inteligencia
{

    private int x;
    private int y;
    private Logica logica;
    private char direcao;
    
    public IntelFraca(Logica logica)
    {
        this.logica = logica;
        x=logica.FantasmaX(3);
        y=logica.FantasmaY(3);
        direcao = 'r';
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
//        List<Position> lista = logica.movimentosPosiveis(x, y); 
//        //Collections.shuffle(lista);
//        for(Position s:lista)
//        {
//            if(manterDirecao(s.getX(),s.getY()))
//            {
//               x=s.getX();
//               y=s.getY();
//                break;
//            }
//        }
        logica.rightFantasma(3);
        x=logica.FantasmaX(3);
        y=logica.FantasmaY(3);
    }
    
    boolean manterDirecao(int x1,int y1)
    {
        switch(direcao)
        {
            case 'r':
                if(x1==x+1 && y1==y )
                    return true;
                break;
            case 'l':
                if(x1==x-1 && y1==y )
                    return true;
                break;
            case 'u':
                if(x1==x && y1==y-1 )
                    return true;
                break;
            case 'd':
                if(x1==x && y1==y+1 )
                    return true;
                break;     
        }
        return false;
    }
}
