
package br.ufc.quixada.es.pds.cobraseescadas.entidades;

import br.ufc.quixada.es.pds.cobraseescadas.controle.ControladorJogo;

public class CasaBonus extends Casa{

    public CasaBonus(int casaResultante) {
        super(casaResultante);
    }

    @Override
    public void getAcao(Jogador jogador) {
        jogador.setPosicao(this.casaResultante);
        ControladorJogo.getInstance().getControladorTela().mostrarJanelaRetirarCarta(jogador.getNome());
        Carta cartaAcao = ControladorJogo.getInstance().getUltimaCartaRetirada();
        cartaAcao.getAcao(jogador);
    }
    
}
