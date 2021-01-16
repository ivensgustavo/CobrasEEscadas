
package br.ufc.quixada.es.pds.cobraseescadas.fabricas;

import br.ufc.quixada.es.pds.cobraseescadas.entidades.CartaAvancar;
import br.ufc.quixada.es.pds.cobraseescadas.entidades.CartaVoltar;
import br.ufc.quixada.es.pds.cobraseescadas.interfaces.IFabricaCartas;
import br.ufc.quixada.es.pds.cobraseescadas.entidades.Carta;

public class FabricaCartas implements IFabricaCartas{

    @Override
    public Carta criarCarta(String tipo, int quantidadeCasas) {
        Carta carta;
        switch(tipo){
            case "Avancar":
                carta = new CartaAvancar(quantidadeCasas);
                break;
            
            case "Voltar":
                carta = new CartaVoltar(quantidadeCasas);
                break;
            default:
                carta = new CartaVoltar(quantidadeCasas);
                break;
        }
        
        return carta;
    }
    
}
