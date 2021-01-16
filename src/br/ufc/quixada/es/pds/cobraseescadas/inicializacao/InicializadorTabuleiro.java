
package br.ufc.quixada.es.pds.cobraseescadas.inicializacao;
import br.ufc.quixada.es.pds.cobraseescadas.fabricas.FabricaCasas;
import br.ufc.quixada.es.pds.cobraseescadas.entidades.Casa;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InicializadorTabuleiro {
    
    private Map<Integer, Casa> casasCobra = new HashMap<Integer , Casa>(); 
    private Map<Integer, Casa> casasEscada = new HashMap<Integer, Casa>();
    private Map<Integer, Casa> casasNormal = new HashMap<Integer, Casa>();
    private Map<Integer, Casa> casasBonus = new HashMap<Integer, Casa>();
    private List<Casa> casas = new ArrayList<Casa>();
    private FabricaCasas fabricaCasas = new FabricaCasas();
   
    
    private void inserirCasas(){
        this.casasCobra.put(40, this.fabricaCasas.criaCasa("Cobra", 20));
        this.casasCobra.put(50, this.fabricaCasas.criaCasa("Cobra", 16));
        this.casasCobra.put(81, this.fabricaCasas.criaCasa("Cobra", 78));
        this.casasCobra.put(92, this.fabricaCasas.criaCasa("Cobra", 52));
        this.casasCobra.put(95, this.fabricaCasas.criaCasa("Cobra", 36));
        
        this.casasEscada.put(4, this.fabricaCasas.criaCasa("Escada", 22));
        this.casasEscada.put(10, this.fabricaCasas.criaCasa("Escada", 29));
        this.casasEscada.put(14, this.fabricaCasas.criaCasa("Escada", 77));
        this.casasEscada.put(33, this.fabricaCasas.criaCasa("Escada", 51));
        this.casasEscada.put(64, this.fabricaCasas.criaCasa("Escada", 82));
        this.casasEscada.put(74, this.fabricaCasas.criaCasa("Escada", 90));
        
        this.casasBonus.put(25, this.fabricaCasas.criaCasa("Bonus", 25));
        this.casasBonus.put(44, this.fabricaCasas.criaCasa("Bonus", 44));
        this.casasBonus.put(68, this.fabricaCasas.criaCasa("Bonus", 68));
        this.casasBonus.put(87, this.fabricaCasas.criaCasa("Bonus", 87));
        this.casasBonus.put(97, this.fabricaCasas.criaCasa("Bonus", 97));
    }
    
    private void popularTabuleiro(){
        this.casas.add(fabricaCasas.criaCasa("Normal", 0));
        for(int i = 1; i <= 100; i++){
           if(this.casasCobra.containsKey(i)){
               this.casas.add(this.casasCobra.get(i));
           }else{
               if(this.casasEscada.containsKey(i)){
                   this.casas.add(this.casasEscada.get(i));
               }else{
                   if(this.casasBonus.containsKey(i)){
                       this.casas.add(this.casasBonus.get(i));
                   }else{
                       this.casas.add(fabricaCasas.criaCasa("Normal", i));
                   }
                   
               }
           }
        }
    }
    
    public List<Casa> getCasas(){
        this.inserirCasas();
        this.popularTabuleiro();
        return this.casas;
    } 
}
