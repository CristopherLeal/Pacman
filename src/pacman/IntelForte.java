package pacman;

import java.util.List;
import prolog.Logica;
import prolog.Position;

public class IntelForte implements Inteligencia {

    private int x;
    private int y;
    private int iter;
    private final int codGhost;
    private final int sleep;
    private final Logica logica;
    List<Position> pos;

    public IntelForte(Logica logica,int codGhost, int sleep)
    {
        this.logica=logica;
        this.codGhost = codGhost;
        logica.criarFantasma(codGhost);
        x=logica.FantasmaX(codGhost);
        y=logica.FantasmaY(codGhost);      
        iter=0;
        pos= logica.getPath(x , y);
        this.sleep = sleep;
    }
    
    
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
      
        if(iter==pos.size()||iter>10){
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

    @Override
    public int getSleep() {
        return sleep;
    }
    
}
