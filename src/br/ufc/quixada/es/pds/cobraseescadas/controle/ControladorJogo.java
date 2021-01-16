
package br.ufc.quixada.es.pds.cobraseescadas.controle;

import br.ufc.quixada.es.pds.cobraseescadas.entidades.Carta;
import br.ufc.quixada.es.pds.cobraseescadas.entidades.CobrasEEscadas;
import br.ufc.quixada.es.pds.cobraseescadas.entidades.IteradorJogadores;
import br.ufc.quixada.es.pds.cobraseescadas.entidades.Jogador;
import br.ufc.quixada.es.pds.cobraseescadas.entidades.PilhaDeCartas;
import br.ufc.quixada.es.pds.cobraseescadas.entidades.Tabuleiro;
import java.util.List;

public class ControladorJogo {
    private static ControladorJogo controlador;
    private CobrasEEscadas jogo;
    private ControladorTela controladorTela;
    private ControladorJogador controladorJogador;
    private IteradorJogadores iteradorJogadores;
    
    private ControladorJogo(){
        this.jogo = CobrasEEscadas.getInstance();
        this.controladorTela = ControladorTela.getInstance();
        this.controladorJogador = ControladorJogador.getInstance();
    }
    
    public static ControladorJogo getInstance(){
        if(controlador == null){
            controlador = new ControladorJogo();
        }
        return controlador;
    }
     
    public void configurarJogo(){
        
        int numeroJogadores = 0;
        do {            
            numeroJogadores = Integer.parseInt(
            ControladorMensagens.getInstance().mostrarMensagemDeEntrada("Por favor, insira o número de jogadores.\n "
                        + "obs.:Escolha um número entre 2 e 4"));
        } while (numeroJogadores < 2 || numeroJogadores > 4);
        
        
        for(int i = 1; i <= numeroJogadores; i++){
            String nomeJogador = "0";
            do {                
              nomeJogador  = ControladorMensagens.getInstance().mostrarMensagemDeEntrada("Jogador "+ i + 
                    " insira o seu nome:");
            } while (nomeJogador.equals("0"));
            
            this.jogo.addJogador(nomeJogador);
        }
        
       this.desenharNomesJogadores(this.jogo.getJogadores());
       this.controladorTela.atualizarJanela();
    }
    
    public void jogar() throws InterruptedException{
        while(true){
           IteradorJogadores iterador = this.jogo.criaIterador();
           while(iterador.temProximo() && this.jogo.verificarFimDeJogo() == false){
               this.jogo.setJogadorDaVez(iterador.proximo());
               this.controladorJogador.realizarJogada(this.jogo.getJogadorDaVez());
               Thread.sleep(500);
           }
           if(this.jogo.verificarFimDeJogo()){
               break;
           }
       }
       
       this.jogo.setGanhador();
       
       ControladorMensagens.getInstance().mostrarMensagem(
               "Fim de Jogo\n"+
                "O jogador "+this.controladorJogador.getNome(this.jogo.getGanhador())+" foi o vencedor!"
       );
       System.exit(0);
    }
    
    public void atualizarTela(){
        controladorTela.desenharFundo();
        Jogador jogador;
        this.iteradorJogadores =  this.jogo.criaIterador();
        while(iteradorJogadores.temProximo()){
            jogador = iteradorJogadores.proximo();
            this.controladorTela.desenharPeca(this.controladorJogador.getPeca(jogador), this.controladorJogador.getPosicao(jogador));
            
        }
        this.controladorTela.atualizarJanela();
        
    }
    
    public void desenharNomesJogadores(List<Jogador> listaJogadores){
        for(int i = 0; i < listaJogadores.size(); i++){
            this.controladorTela.desenharNomeJogador(this.controladorJogador.getNome(listaJogadores.get(i)), i+1);
        }
    }
    
    public void carregarJanela(){
        this.controladorTela.desenharFundo();
        this.controladorTela.atualizarJanela();
    }
    
    public Tabuleiro getTabuleiroJogo(){
        return this.jogo.getTabuleiro();
    }
    
    public PilhaDeCartas getPilhaDeCartasJogo(){
        return this.jogo.getPilhaDeCartas();
    }
    
    public int getValorDado(){
        return this.jogo.getValorDado();
    }
    
    public Jogador getJogadorDaVez(){
        return this.jogo.getJogadorDaVez();
    }
    
    public void setDestinoJogadorDaVez(int valorDado){
        this.controladorJogador.setPosicaoDestino(valorDado, this.jogo.getJogadorDaVez());     
    }
    
    public Carta getUltimaCartaRetirada(){
        return this.jogo.getUltimaCartaRetirada();
    }
    
    public String getDescricaoUltimaCarta(){
        return this.jogo.getUltimaCartaRetirada().getDescricao();
    }
    
    public void setUltimaCartaRetirada(Carta carta){
        this.jogo.setUltimaCartaRetirada(carta);
    }
    
    public ControladorTela getControladorTela(){
        return this.controladorTela;
    }
}