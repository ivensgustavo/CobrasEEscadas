
package br.ufc.quixada.es.pds.cobraseescadas.interfaces;

import br.ufc.quixada.es.pds.cobraseescadas.entidades.Carta;

public interface IFabricaCartas {
    public Carta criarCarta(String tipo, int quantidadeCasas);
}
