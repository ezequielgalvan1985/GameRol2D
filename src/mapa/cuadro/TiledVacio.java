package mapa.cuadro;

import graficos.Pantalla;
import graficos.Sprite;

public class TiledVacio extends Tiled {


    public TiledVacio(Sprite sprite) {
        super(sprite);
    }
    public void mostrar(int x, int y, Pantalla pantalla){
        pantalla.mostrar(x,y,this);
    }
}
