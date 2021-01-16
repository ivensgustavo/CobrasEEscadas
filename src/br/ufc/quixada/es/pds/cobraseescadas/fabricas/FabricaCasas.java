
package br.ufc.quixada.es.pds.cobraseescadas.fabricas;

import br.ufc.quixada.es.pds.cobraseescadas.entidades.Casa;
import br.ufc.quixada.es.pds.cobraseescadas.entidades.CasaBonus;
import br.ufc.quixada.es.pds.cobraseescadas.entidades.CasaCobra;
import br.ufc.quixada.es.pds.cobraseescadas.entidades.CasaEscada;
import br.ufc.quixada.es.pds.cobraseescadas.entidades.CasaNormal;
import br.ufc.quixada.es.pds.cobraseescadas.interfaces.IFabricaCasas;

public class FabricaCasas implements IFabricaCasas{

    @Override
    public Casa criaCasa(String tipo, int casaResultante) {
        Casa casa;
        switch(tipo){
            case "Escada":
                casa = new CasaEscada(casaResultante);
                break;
            case "Cobra":
                casa = new CasaCobra(casaResultante);
                break;
            case "Bonus":
                casa = new CasaBonus(casaResultante);
                break;
            default: 
                casa = new CasaNormal(casaResultante);
                break;
        }
        
        return casa;
    }

   
}
