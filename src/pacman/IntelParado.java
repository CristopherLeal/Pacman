package pacman;

import prolog.Logica;

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
   public IntelParado(Logica logica,int codGhost)
   {
       this.x=0;
       this.y=0;
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
       return 100;
    }
    
}
