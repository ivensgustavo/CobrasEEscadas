
package br.ufc.quixada.es.pds.cobraseescadas.ui;

import br.ufc.quixada.es.pds.cobraseescadas.controle.ControladorJogo;
import javax.swing.ImageIcon;

public class JanelaRetirarCarta extends javax.swing.JDialog {

    private String nomeJogador;
    private String descricaoCarta;
    private ControladorJogo controladorJogo;
    private boolean tirouCarta;
    
    public JanelaRetirarCarta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public JanelaRetirarCarta(java.awt.Frame parent, boolean modal,  String nomeJogador){
        super(parent, modal);
        initComponents();
        this.nomeJogador = nomeJogador;
        this.controladorJogo = ControladorJogo.getInstance();
        this.tirouCarta = false;
        this.setMensagemSolicitacao();
        this.setLocation(808, 290);
        this.setVisible(true);
        
    }

    private void setMensagemSolicitacao(){
        this.jTSolicitacao.setText(this.nomeJogador+", retire uma carta.");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBMostrarCarta = new javax.swing.JButton();
        CartaRetirada = new javax.swing.JLabel();
        jTSolicitacao = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBOK = new javax.swing.JButton();
        jBSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Retirar Carta");
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBMostrarCarta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufc/quixada/es/pds/cobraseescadas/recursos/carta.png"))); // NOI18N
        jBMostrarCarta.setBorder(null);
        jBMostrarCarta.setContentAreaFilled(false);
        jBMostrarCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMostrarCartaActionPerformed(evt);
            }
        });
        jPanel1.add(jBMostrarCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 102, -1, -1));
        jPanel1.add(CartaRetirada, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 120, 151));

        jTSolicitacao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTSolicitacao.setText("Mensagem de solicitação");
        jPanel1.add(jTSolicitacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 27, -1, -1));

        jLabel1.setText("Carta retirada:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, -1));

        jLabel2.setText("Monte de cartas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        jBOK.setText("OK");
        jBOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBOKActionPerformed(evt);
            }
        });
        jPanel1.add(jBOK, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));

        jBSair.setText("Sair");
        jBSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSairActionPerformed(evt);
            }
        });
        jPanel1.add(jBSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBMostrarCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMostrarCartaActionPerformed
        this.tirarCarta();
        this.mostrarCarta(); 
        this.setTirouCarta();
    }//GEN-LAST:event_jBMostrarCartaActionPerformed

    private void jBOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBOKActionPerformed
        if(this.tirouCarta == true){
            this.dispose();
        }
    }//GEN-LAST:event_jBOKActionPerformed

    private void jBSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBSairActionPerformed
 
    private void setTirouCarta(){
        this.tirouCarta = true;
    }
    
    private void setDescricaoCarta(){
        this.descricaoCarta = this.controladorJogo.getDescricaoUltimaCarta();
    }
    
    private void tirarCarta(){
        this.controladorJogo.getJogadorDaVez().tirarCarta();
        this.setDescricaoCarta();
    }
    
    private void mostrarCarta(){
        this.CartaRetirada.setIcon(new ImageIcon("src\\br\\ufc\\quixada\\es\\pds\\cobraseescadas\\recursos\\"+this.descricaoCarta+".png"));
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaRetirarCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaRetirarCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaRetirarCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaRetirarCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaRetirarCarta dialog = new JanelaRetirarCarta(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CartaRetirada;
    private javax.swing.JButton jBMostrarCarta;
    private javax.swing.JButton jBOK;
    private javax.swing.JButton jBSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jTSolicitacao;
    // End of variables declaration//GEN-END:variables
}
