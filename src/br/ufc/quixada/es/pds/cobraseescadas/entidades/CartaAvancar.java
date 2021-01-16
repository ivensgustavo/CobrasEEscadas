
package br.ufc.quixada.es.pds.cobraseescadas.entidades;

public class CartaAvancar extends Carta{
    
    public CartaAvancar(int quantidadeCasas){
        super(quantidadeCasas);
    }
    
    @Override
    public void getAcao(Jogador jogador) {
        jogador.setPosicao(jogador.getPosicao() + this.quantidadeCasas);
        
    }

    @Override
    public String getDescricao() {
        return "Avancar "+this.quantidadeCasas;
    }
    
}
