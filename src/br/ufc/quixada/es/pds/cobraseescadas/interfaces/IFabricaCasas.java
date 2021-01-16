
package br.ufc.quixada.es.pds.cobraseescadas.interfaces;

import br.ufc.quixada.es.pds.cobraseescadas.entidades.Casa;

public interface IFabricaCasas {
    public Casa criaCasa(String tipo, int casaResultante);
}
