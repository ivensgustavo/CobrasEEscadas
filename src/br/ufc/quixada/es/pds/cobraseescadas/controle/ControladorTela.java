package br.ufc.quixada.es.pds.cobraseescadas.controle;

import br.ufc.quixada.es.pds.cobraseescadas.ui.JanelaLancarDados;
import br.ufc.quixada.es.pds.cobraseescadas.ui.JanelaRetirarCarta;
import br.ufc.quixada.es.pds.cobraseescadas.ui.Peca;
import br.ufc.quixada.es.pds.cobraseescadas.ui.TelaJogo;
import java.awt.Window;


public class ControladorTela {
    
    private static ControladorTela controladorTela;
    private  TelaJogo tela;
  
    private ControladorTela(){
        this.tela = TelaJogo.getInstance();
    }
    
    public static ControladorTela getInstance(){
        if(controladorTela == null){
            controladorTela = new ControladorTela();
        }
        return controladorTela;
    }
    
    public void desenharFundo(){
        tela.desenharFundo();
    }
     
    public void atualizarJanela(){
        tela.atualizarJanela();
    }
    
    public void desenharPeca(Peca peca, int pos){
        tela.desenharPeca(peca, pos);
    }
    
    public void mapearPosicoes(){
        tela.mapearPosicoes();
    }
    
    public void desenharTextosGeraisDoJogo(){
        tela.desenharTextosGeraisDoJogo();
    }
    
    public void desenharNomeJogador(String nomeJogador, int numJogador){
        tela.desenharNomeJogador(nomeJogador, numJogador);
    }
    
    public Window getWindow(){
        return tela.getWindow();
    }
    
    public JanelaLancarDados mostrarJanelaLancarDado(String nomeJogador){
        return new JanelaLancarDados(this.tela.getWindow(), true, nomeJogador);
        
    }
    
    public JanelaRetirarCarta mostrarJanelaRetirarCarta(String nomeJogador){
        return new JanelaRetirarCarta(this.tela.getWindow(), true, nomeJogador);
    }
}
