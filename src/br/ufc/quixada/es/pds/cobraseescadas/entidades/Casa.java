
package br.ufc.quixada.es.pds.cobraseescadas.entidades;

import br.ufc.quixada.es.pds.cobraseescadas.interfaces.ITemAcao;

public abstract class Casa implements ITemAcao{
    
    protected int casaResultante;
    
    public Casa(int casaResultante){
        this.casaResultante = casaResultante;
    }
    
    @Override
    public void getAcao(Jogador jogador){
       jogador.setPosicao(casaResultante);
    }
    
    public int getCasaResultante(){
        return this.casaResultante;
    }
}
