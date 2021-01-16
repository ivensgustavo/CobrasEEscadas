
package br.ufc.quixada.es.pds.cobraseescadas.inicializacao;

import br.ufc.quixada.es.pds.cobraseescadas.fabricas.FabricaCartas;
import br.ufc.quixada.es.pds.cobraseescadas.entidades.Carta;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InicializadorPilhaDeCartas {
    
    private boolean[] cartasAvancar;
    private boolean[] cartasVoltar;
    private List<Carta> cartas;
    private FabricaCartas fabricaCartas;
    private int quantidadeCartas;
    
    public InicializadorPilhaDeCartas(int quantidadeCartasPorTipo){
        this.cartasAvancar = new boolean[quantidadeCartasPorTipo];
        this.cartasVoltar = new boolean[quantidadeCartasPorTipo];
        this.cartas = new ArrayList<>();
        this.fabricaCartas = new FabricaCartas();
        this.quantidadeCartas = quantidadeCartasPorTipo * 2;
    }
    
    public void inicializarCartas(){
        Random randomTipoCarta = new Random();
        Random randomValorCarta = new Random();
        
        for(int i = 0; i < this.quantidadeCartas; i++){
            int tipoCarta = randomTipoCarta.nextInt(2);
            int valorCarta = randomValorCarta.nextInt(3);
            Carta carta = null;
  
            while((tipoCarta == 0 && verificarSeACartaJaExiste(this.cartasAvancar, valorCarta)) || 
                    (tipoCarta == 1 && verificarSeACartaJaExiste(this.cartasVoltar, valorCarta))){
                
                tipoCarta = randomTipoCarta.nextInt(2);
                valorCarta = randomValorCarta.nextInt(3);
            }
              
            if(tipoCarta == 0){
                    this.cartasAvancar[valorCarta] = true;
                    carta = this.fabricaCartas.criarCarta("Avancar", valorCarta + 1);
            }else{
                    this.cartasVoltar[valorCarta] = true;
                    carta = this.fabricaCartas.criarCarta("Voltar", valorCarta + 1);
            }
              
            this.cartas.add(carta);
            
        }
    }
    
    public boolean verificarSeACartaJaExiste(boolean[] cartas, int indice){
        return cartas[indice] == true;
    }
    
    public List<Carta> getCartas(){
        this.inicializarCartas();
        return this.cartas;
    }
}
