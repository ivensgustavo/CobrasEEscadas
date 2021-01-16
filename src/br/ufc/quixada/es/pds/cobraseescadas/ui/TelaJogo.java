
package br.ufc.quixada.es.pds.cobraseescadas.ui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.plaf.FontUIResource;
import jplay.GameImage;
import jplay.Window;

public class TelaJogo {
    
    private static TelaJogo tela; 
    private Window janela;
    private GameImage fundo;
    private List<Posicao> listaPosicoes;
    
    private TelaJogo(){
        this.janela = new Window(1150, 698);
        this.fundo = new GameImage("src\\br\\ufc\\quixada\\es\\pds\\cobraseescadas\\recursos\\fundo_cobras_e_escadas.png");
        this.listaPosicoes = new ArrayList<>(); 
        this.mapearPosicoes();
        this.desenharTextosGeraisDoJogo();
    }
    
    
    public static TelaJogo getInstance(){
        if(tela == null){
             tela = new TelaJogo();
        }
       
        return tela;
    }
    
    public void desenharFundo(){
        this.fundo.draw();
    }
     
    public void atualizarJanela(){
        this.janela.update();
    }
    
    public void desenharPeca(Peca peca, int pos){
        peca.setPosicao(this.listaPosicoes.get(pos).getX(), this.listaPosicoes.get(pos).getY());
        peca.draw();
    }
    
    public void mapearPosicoes(){
        int x = -65;
        int y = 705;
        this.listaPosicoes.add(new Posicao(0, 0));
        for(int i = 0; i < 10; i++){
            y = y - 70;
            if( i % 2 == 0) {
                x = -65;
            }else{
                x = 705;
            }
            
            for(int j = 0; j < 10; j++){
                if(i % 2 == 0){
                    x = x + 70;
                }else{
                    x = x - 70;
                }   
                this.listaPosicoes.add(new Posicao(x, y));
            }
        }
    }
    
    public void desenharTextosGeraisDoJogo(){
        Font font = new FontUIResource("Tahoma", 0, 24);
        this.janela.drawText("Cobras e Escadas", 830, 50, Color.black, font);
    }
    
    public void desenharNomeJogador(String nomeJogador, int numJogador){
       int xPeca = 0;
       int yPeca = 0;
       int xNome = 0;
       int yNome = 0;
       Font font = new FontUIResource("Tahoma", 0, 14);
       
       Peca peca = new Peca("src\\br\\ufc\\quixada\\es\\pds\\cobraseescadas\\recursos\\peca"+numJogador+".png");
       switch(numJogador){
           case 1:
               xPeca = 750;
               yPeca = 80;
               xNome = 806;
               yNome = 120;
               peca.setPosicao(xPeca, yPeca);
               break;
            
           case 2:
               xPeca = 950;
               yPeca = 80;
               xNome = 1008;
               yNome = 120;
               peca.setPosicao(xPeca, yPeca);
               break;
               
           case 3:
               xPeca = 750;
               yPeca = 160;
               xNome = 806;
               yNome = 200;
               peca.setPosicao(xPeca, yPeca);
               break;
            
           case 4:
               xPeca = 950;
               yPeca = 160;
               xNome = 1008;
               yNome = 200;
               peca.setPosicao(xPeca, yPeca);
               break;
               
           default:
               System.out.println("Erro ao desenhar as informações do  jogador");
               break;
               
       }
       peca.draw();
       this.janela.drawText(nomeJogador, xNome, yNome, Color.black, font);
    }
    
    public Window getWindow(){
        return this.janela;
    }
}
