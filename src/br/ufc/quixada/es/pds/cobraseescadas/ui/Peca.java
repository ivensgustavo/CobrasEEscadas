
package br.ufc.quixada.es.pds.cobraseescadas.ui;

import jplay.GameImage;

public class Peca extends GameImage{
    
    public Peca(String fileName) {
        super(fileName);
    }
    
    public void setPosicao(int x, int y){
        this.x = x;
        this.y = y;
    }
}
