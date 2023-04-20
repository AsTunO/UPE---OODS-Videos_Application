package projetoooc;

public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        EditarVideoButton = new javax.swing.JButton();
        PesquisarVideoButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        SairButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        RemoverUsuarioButton = new javax.swing.JButton();
        EditarUsuarioButton = new javax.swing.JButton();
        AssistirVideoButton = new javax.swing.JButton();
        ListarHistóricoButton = new javax.swing.JButton();
        CriarUsuárioButton = new javax.swing.JButton();
        PublicarVideoButton = new javax.swing.JButton();
        DeletarVideoButton = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 255));

        EditarVideoButton.setText("Editar video publicado");
        EditarVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarVideoButtonActionPerformed(evt);
            }
        });

        PesquisarVideoButton.setText("Pesquisar Video");
        PesquisarVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarVideoButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Menu");

        SairButton.setText("Sair");
        SairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecione uma Opção");

        RemoverUsuarioButton.setText("Remover Usuário");
        RemoverUsuarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoverUsuarioButtonActionPerformed(evt);
            }
        });

        EditarUsuarioButton.setText("Editar Usuário");
        EditarUsuarioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarUsuarioButtonActionPerformed(evt);
            }
        });

        AssistirVideoButton.setText("Assistir Video");
        AssistirVideoButton.setToolTipText("");
        AssistirVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AssistirVideoButtonActionPerformed(evt);
            }
        });

        ListarHistóricoButton.setText("Listar Histórico de Usuário");
        ListarHistóricoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListarHistóricoButtonActionPerformed(evt);
            }
        });

        CriarUsuárioButton.setText("Criar Usuário");
        CriarUsuárioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CriarUsuárioButtonMouseClicked(evt);
            }
        });
        CriarUsuárioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriarUsuárioButtonActionPerformed(evt);
            }
        });

        PublicarVideoButton.setText("Publicar Video");
        PublicarVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PublicarVideoButtonActionPerformed(evt);
            }
        });

        DeletarVideoButton.setText("Deletar Video");
        DeletarVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletarVideoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DeletarVideoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(EditarVideoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PesquisarVideoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SairButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PublicarVideoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AssistirVideoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ListarHistóricoButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(CriarUsuárioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RemoverUsuarioButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EditarUsuarioButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(CriarUsuárioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RemoverUsuarioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditarUsuarioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AssistirVideoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ListarHistóricoButton)
                .addGap(13, 13, 13)
                .addComponent(PublicarVideoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DeletarVideoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditarVideoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PesquisarVideoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SairButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EditarVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarVideoButtonActionPerformed
        new EditarVideo().setVisible(true);
    }//GEN-LAST:event_EditarVideoButtonActionPerformed

    private void PesquisarVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarVideoButtonActionPerformed
        new PesquisarVideo().setVisible(true);
    }//GEN-LAST:event_PesquisarVideoButtonActionPerformed

    private void SairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairButtonActionPerformed
        dispose();
    }//GEN-LAST:event_SairButtonActionPerformed

    private void EditarUsuarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarUsuarioButtonActionPerformed
        new EditarUser().setVisible(true);
    }//GEN-LAST:event_EditarUsuarioButtonActionPerformed

    private void AssistirVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AssistirVideoButtonActionPerformed
        new AssistirVideo().setVisible(true);
    }//GEN-LAST:event_AssistirVideoButtonActionPerformed

    private void PublicarVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PublicarVideoButtonActionPerformed
        new PublicarVideo().setVisible(true);
    }//GEN-LAST:event_PublicarVideoButtonActionPerformed

    private void DeletarVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarVideoButtonActionPerformed
        new DeletarVideo().setVisible(true);
    }//GEN-LAST:event_DeletarVideoButtonActionPerformed

    private void CriarUsuárioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarUsuárioButtonActionPerformed
   
        new CriarUser().setVisible(true);
    }//GEN-LAST:event_CriarUsuárioButtonActionPerformed

    private void CriarUsuárioButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CriarUsuárioButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_CriarUsuárioButtonMouseClicked

    private void RemoverUsuarioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoverUsuarioButtonActionPerformed
        new RemoverUser().setVisible(true);
    }//GEN-LAST:event_RemoverUsuarioButtonActionPerformed

    private void ListarHistóricoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarHistóricoButtonActionPerformed
        new ListarHistorico().setVisible(true);
    }//GEN-LAST:event_ListarHistóricoButtonActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AssistirVideoButton;
    private javax.swing.JButton CriarUsuárioButton;
    private javax.swing.JButton DeletarVideoButton;
    private javax.swing.JButton EditarUsuarioButton;
    private javax.swing.JButton EditarVideoButton;
    private javax.swing.JButton ListarHistóricoButton;
    private javax.swing.JButton PesquisarVideoButton;
    private javax.swing.JButton PublicarVideoButton;
    private javax.swing.JButton RemoverUsuarioButton;
    private javax.swing.JButton SairButton;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
