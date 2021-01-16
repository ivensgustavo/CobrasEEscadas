
package br.ufc.quixada.es.pds.cobraseescadas.entidades;

import br.ufc.quixada.es.pds.cobraseescadas.inicializacao.InicializadorTabuleiro;
import java.util.List;

public class Tabuleiro {
    
    private static Tabuleiro instanceTabuleiro;
    private List<Casa> listaCasas;
    private InicializadorTabuleiro inicializadorTabuleiro = new InicializadorTabuleiro();
    
    private Tabuleiro(){
        this.listaCasas = inicializadorTabuleiro.getCasas();
    }
 
   public static Tabuleiro getInstance(){
       if(instanceTabuleiro == null){
           instanceTabuleiro = new Tabuleiro();
       }
       return instanceTabuleiro;
    }
   
   public List<Casa> getListaCasas(){
       return this.listaCasas;
   }
   
   public Casa getCasa(int posicao){
       return this.listaCasas.get(posicao);
   }
}
