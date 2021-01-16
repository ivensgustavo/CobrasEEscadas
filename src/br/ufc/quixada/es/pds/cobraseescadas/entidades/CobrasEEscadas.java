package br.ufc.quixada.es.pds.cobraseescadas.entidades;

import br.ufc.quixada.es.pds.cobraseescadas.interfaces.Agregador;
import br.ufc.quixada.es.pds.cobraseescadas.ui.Peca;
import java.util.ArrayList;
import java.util.List;

public class CobrasEEscadas implements Agregador{
    
    private static CobrasEEscadas cobrasEEscadas;
    private List<Jogador> listaJogadores;
    private Tabuleiro tabuleiro;
    private Dado dado;
    private PilhaDeCartas pilhaDeCartas;
    private Jogador ganhador;
    private Jogador jogadorDaVez;
    private Carta ultimaCartaRetirada;
    
    
    private CobrasEEscadas(){
        this.listaJogadores = new ArrayList<>();
        this.tabuleiro = Tabuleiro.getInstance();
        this.dado = Dado.getInstance();
        this.pilhaDeCartas = PilhaDeCartas.getInstance();
    }
    
    public static CobrasEEscadas getInstance(){
        if(cobrasEEscadas == null) {
            cobrasEEscadas = new CobrasEEscadas();
        }
        return cobrasEEscadas;
    }
    
    
    public boolean verificarFimDeJogo(){
        boolean terminou = false;
        
        for( Jogador j: this.listaJogadores){
            if(j.getPosicao() == 100){
                terminou = true;
                break;
            }
        }
        
        return terminou;
    }
    
    public Jogador getGanhador(){
        return this.ganhador;
    }    
     
    public void setGanhador(){
        for(Jogador jogador: this.listaJogadores){
            if(jogador.getPosicao() == 100){
                this.ganhador = jogador;
                break;
            }
        }
    }
    
    public Jogador getJogadorDaVez(){
        return this.jogadorDaVez;
    }
    
    public void setJogadorDaVez(Jogador jogador){
        this.jogadorDaVez = jogador;
    }
    
    public Carta getUltimaCartaRetirada(){
        return this.ultimaCartaRetirada;
    }
    
    public void setUltimaCartaRetirada(Carta carta){
        this.ultimaCartaRetirada = carta;
    }
    
    public void addJogador(String nome){
        Jogador jogador = new Jogador(nome, 1, new Peca("src\\br\\ufc\\quixada\\es\\pds\\cobraseescadas\\recursos\\peca"+String.valueOf(this.listaJogadores.size()+1)+".png"));
        this.listaJogadores.add(jogador);
    }
   
    
    public Tabuleiro getTabuleiro(){
        return this.tabuleiro;
    }
    
    public PilhaDeCartas getPilhaDeCartas(){
        return this.pilhaDeCartas;
    }
    
    @Override
    public IteradorJogadores criaIterador() {
        return new IteradorJogadores(this.listaJogadores);
    }

    public List<Jogador> getJogadores(){
        return this.listaJogadores;
    }
    
    public int getValorDado(){
        this.dado.lancar();
        int valor = this.dado.getValor();
        return valor;
    }
}