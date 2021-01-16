
package br.ufc.quixada.es.pds.cobraseescadas.entidades;

import br.ufc.quixada.es.pds.cobraseescadas.inicializacao.InicializadorPilhaDeCartas;

import java.util.List;

public class PilhaDeCartas {
    
    private static PilhaDeCartas instancePilhaDeCartas;
    private List<Carta> listaCartas;
    private InicializadorPilhaDeCartas inicializadorPilhaDeCartas = new InicializadorPilhaDeCartas(3);
    
    private PilhaDeCartas(){
        this.listaCartas = this.inicializadorPilhaDeCartas.getCartas();
    }
    
    public static PilhaDeCartas getInstance(){
        if(instancePilhaDeCartas == null){
            instancePilhaDeCartas = new PilhaDeCartas();
        }
        
        return instancePilhaDeCartas;
    }
    
    public Carta getCarta(){
         Carta carta = this.listaCartas.remove(this.listaCartas.size() - 1);
         if(this.listaCartas.isEmpty()) this.listaCartas = this.inicializadorPilhaDeCartas.getCartas();
         return carta;
    }
    
    
}
