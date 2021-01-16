package br.ufc.quixada.es.pds.cobraseescadas.controle;

import br.ufc.quixada.es.pds.cobraseescadas.entidades.Jogador;
import br.ufc.quixada.es.pds.cobraseescadas.ui.Peca;

public class ControladorJogador {
    private static ControladorJogador uniqueInstance;
    
    public static ControladorJogador getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new  ControladorJogador();
        }
        return uniqueInstance;
    }
    
    private ControladorJogador(){
    }

    public void setPosicao(int posicao, Jogador jogador){
        jogador.setPosicao(posicao);
    }
    
    public int getPosicao(Jogador jogador){
        return jogador.getPosicao();
    }
    
    public int getdestino(Jogador jogador){
        return jogador.getDestino();
    }
    
    public void setPosicaoDestino(int valorDado, Jogador jogador){
        jogador.setDestino(valorDado);
    }
    
    public String getNome(Jogador jogador){
        return jogador.getNome();
    }
    
    public Peca getPeca(Jogador jogador){
        return jogador.getPeca();
    }
    
    public void realizarJogada(Jogador jogador) throws InterruptedException{
        jogador.realizarJogada();
    }
    
    public void tirarCarta(Jogador jogador){
        jogador.tirarCarta();
    }
    
    public boolean verificarContinuacao(Jogador jogador){
        return jogador.verificarContinuacao();
    }
}
