
package br.ufc.quixada.es.pds.cobraseescadas.entidades;

import br.ufc.quixada.es.pds.cobraseescadas.controle.ControladorJogo;
import br.ufc.quixada.es.pds.cobraseescadas.ui.Peca;


public class Jogador{
    
    private String nome;
    private int posicao;
    private Peca peca;
    private int destino;
    private ControladorJogo controladorJogo;
    public Jogador(String nome, int posicao, Peca peca){
        this.nome = nome;
        this.posicao = posicao;
        this.peca = peca;
        this.destino = 0;
        this.controladorJogo = ControladorJogo.getInstance();
    }
    
    public void setPosicao(int posicao){
        this.posicao = posicao;
    }
    
    public int getPosicao(){
        return this.posicao;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public Peca getPeca(){
        return this.peca;
    }
    
    public int getDestino(){
        return this.destino;
    }
    
    public void setDestino(int valorDado){
        this.destino = this.posicao + valorDado;
    }
    
    public void realizarJogada() throws InterruptedException{
        
        this.controladorJogo.getControladorTela().mostrarJanelaLancarDado(this.nome);
        Tabuleiro tabuleiro = this.controladorJogo.getTabuleiroJogo();
  
        if(this.destino > 100){
            this.destino = 100;
        }
        
        int posicaoAtual = this.posicao;
        while(posicaoAtual <= this.destino){
            this.setPosicao(posicaoAtual);
            controladorJogo.atualizarTela();
            Thread.sleep(400);
            posicaoAtual++;
        }
        
        Casa novaCasa = tabuleiro.getCasa(this.destino);
        novaCasa.getAcao(this);
        
        while(this.verificarContinuacao()){
            Casa casa = tabuleiro.getCasa(this.getPosicao());
            casa.getAcao(this);
        }
        
        controladorJogo.atualizarTela();
    }
    
    public void tirarCarta(){
        PilhaDeCartas pilhaDeCartas = this.controladorJogo.getPilhaDeCartasJogo();
        Carta carta = pilhaDeCartas.getCarta();
        this.controladorJogo.setUltimaCartaRetirada(carta);
    }
    
    public boolean verificarContinuacao(){
        Tabuleiro tabuleiro = CobrasEEscadas.getInstance().getTabuleiro();
        return tabuleiro.getCasa(this.posicao).getCasaResultante() != this.posicao;
    }

}
