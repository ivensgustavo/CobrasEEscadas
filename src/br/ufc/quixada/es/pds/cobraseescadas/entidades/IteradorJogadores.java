
package br.ufc.quixada.es.pds.cobraseescadas.entidades;

import br.ufc.quixada.es.pds.cobraseescadas.interfaces.IIterador;
import java.util.List;

public class IteradorJogadores implements IIterador{

    private List<Jogador> listaJogadores;
    private int posicao;
    
    public IteradorJogadores(List<Jogador> listaJogadores){
        this.listaJogadores = listaJogadores;
        this.posicao = 0;
    }
    
    @Override
    public boolean temProximo() {
        return this.posicao < this.listaJogadores.size();
    }

    @Override
    public Jogador proximo() {
        Jogador jogador = this.listaJogadores.get(posicao);
        this.posicao++;
        return jogador;
    }
    
}
