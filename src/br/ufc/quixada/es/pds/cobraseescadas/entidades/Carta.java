
package br.ufc.quixada.es.pds.cobraseescadas.entidades;

import br.ufc.quixada.es.pds.cobraseescadas.interfaces.ITemAcao;

public abstract class Carta implements ITemAcao{
    
    protected int quantidadeCasas;
    
     public Carta(int quantidadeCasas){
        this.quantidadeCasas = quantidadeCasas;
    }
    
    public abstract String getDescricao();
}
