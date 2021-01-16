
package br.ufc.quixada.es.pds.cobraseescadas.entidades;

public class CartaVoltar extends Carta{
    
    public CartaVoltar(int quantidadeCasas){
        super(quantidadeCasas);
    }
    
    @Override
    public void getAcao(Jogador jogador) {
        jogador.setPosicao(jogador.getPosicao() - this.quantidadeCasas);
        
    }

    @Override
    public String getDescricao() {
        return "Voltar "+this.quantidadeCasas;
    }
       
}
