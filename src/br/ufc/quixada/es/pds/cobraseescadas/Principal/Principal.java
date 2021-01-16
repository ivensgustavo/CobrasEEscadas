
package br.ufc.quixada.es.pds.cobraseescadas.Principal;


import br.ufc.quixada.es.pds.cobraseescadas.controle.ControladorJogo;

public class Principal {
    public static void main(String[] args) throws InterruptedException{
        ControladorJogo controladorJogo = ControladorJogo.getInstance();
        controladorJogo.carregarJanela();
        controladorJogo.configurarJogo();
        controladorJogo.jogar();
        
    }
}
