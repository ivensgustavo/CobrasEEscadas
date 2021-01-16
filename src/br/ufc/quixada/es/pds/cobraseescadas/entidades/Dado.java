
package br.ufc.quixada.es.pds.cobraseescadas.entidades;

import java.util.Random;

public class Dado {
    
    private static Dado instanceDado;
    private int valor;
    
    private Dado(){
        this.valor = 0;
    }
    
    public static Dado getInstance(){
        if(instanceDado == null){
            instanceDado = new Dado();
        }
        return instanceDado;
    }
    
    public void lancar(){
        Random random = new Random();
        this.valor = random.nextInt(6) + 1;
    }
    
    public int getValor(){
        return this.valor;
    }
}
