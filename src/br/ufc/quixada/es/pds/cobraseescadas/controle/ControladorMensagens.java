package br.ufc.quixada.es.pds.cobraseescadas.controle;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
public class ControladorMensagens{
    private static ControladorMensagens controladorMensagens;
    public static ControladorMensagens getInstance(){
        if(controladorMensagens == null)
            controladorMensagens = new ControladorMensagens();
        return controladorMensagens;
    }
    public String mostrarMensagemDeEntrada(String mensagem){
        UIManager.put("OptionPane.cancelButtonText", "Sair do jogo");
        UIManager.put("OptionPane.yesButtonText", "Iniciar jogo");
        
        String resposta;
        
        resposta = JOptionPane.showInputDialog(mensagem);
        
        if(resposta == null){
            System.exit(0);
        }else{
            if(resposta.equals("")){
            resposta = "0";
            }
        }
        
        
        
        return resposta;
    }
    
   public void mostrarMensagem(String mensagem){
       JOptionPane.showMessageDialog(null, mensagem);
   }
    
    
}