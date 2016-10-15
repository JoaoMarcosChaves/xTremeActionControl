
package br.control.gui;

import br.control.Beans.Ativ_bean;
import br.control.Controller.Ativ_controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joãomarcos
 */
public class CadAtividades extends javax.swing.JInternalFrame {

    DefaultTableModel tmCadAtiv = new DefaultTableModel (null, new String [] {"Código atividade" ,"Nome", "Valor","Status"});
    List<Ativ_bean> lista;
    ListSelectionModel lsmCadAtiv;
    public CadAtividades() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNomeAtivCad = new javax.swing.JTextField();
        txtValorAtivCad = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescAtivCad = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCodAtiv = new javax.swing.JTextField();
        txtNomeAtivCons = new javax.swing.JTextField();
        txtValorAtivCons = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDesativar = new javax.swing.JButton();
        btnReativar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbConsAtiv = new javax.swing.JTable();
        checkFiltroDes = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescAtivCons = new javax.swing.JTextArea();
        btnLimpar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Atividades");
        setPreferredSize(new java.awt.Dimension(1280, 527));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Cadastro da atividade", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel1.setText("Nome da atividade: ");

        jLabel2.setText("Valor da atividade:");

        jLabel3.setText("Descrição:");

        txtDescAtivCad.setColumns(20);
        txtDescAtivCad.setLineWrap(true);
        txtDescAtivCad.setRows(5);
        jScrollPane1.setViewportView(txtDescAtivCad);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalvar)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGap(24, 24, 24)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtValorAtivCad, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane1)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(txtNomeAtivCad, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNomeAtivCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtValorAtivCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)))
                .addGap(53, 53, 53)
                .addComponent(btnSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Consulta de atividades", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel4.setText("Código da atividade:");

        jLabel5.setText("Nome da atividade:");

        jLabel6.setText("Valor da atividade:");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnDesativar.setText("Desativar");
        btnDesativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesativarActionPerformed(evt);
            }
        });

        btnReativar.setText("Reativar");
        btnReativar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReativarActionPerformed(evt);
            }
        });

        tbConsAtiv.setModel(tmCadAtiv);
        tbConsAtiv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmCadAtiv = tbConsAtiv.getSelectionModel();
        lsmCadAtiv.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if (! e.getValueIsAdjusting()){
                    LinhaSelecionada(tbConsAtiv);
                }
            }
        });
        jScrollPane2.setViewportView(tbConsAtiv);

        checkFiltroDes.setText("Filtrar atividades desativadas");

        jLabel7.setText("Descrição:");

        txtDescAtivCons.setColumns(20);
        txtDescAtivCons.setRows(5);
        jScrollPane3.setViewportView(txtDescAtivCons);

        btnLimpar.setText("Limpar campos");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodAtiv, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtValorAtivCons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomeAtivCons, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPesquisar)
                                .addGap(24, 24, 24))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpar)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(btnAlterar)
                                .addGap(41, 41, 41)
                                .addComponent(btnDesativar)
                                .addGap(39, 39, 39)
                                .addComponent(btnReativar))
                            .addComponent(checkFiltroDes))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCodAtiv, txtValorAtivCons});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtCodAtiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(txtNomeAtivCons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btnPesquisar)
                            .addGap(91, 91, 91))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6)
                                .addComponent(txtValorAtivCons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(54, 54, 54)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLimpar)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(checkFiltroDes)
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnDesativar)
                    .addComponent(btnReativar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        Ativ_bean bean = new Ativ_bean();
        Ativ_controller controller = new Ativ_controller();
        List<Ativ_bean> lista = new ArrayList<>();
        
        int resp = JOptionPane.showConfirmDialog(this,"Confirma a inserção dessa atividade?",
        "Confirmação", JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_NO_OPTION){
        try{
            if(verificaCamposCad()){
                
        bean.setAtivNome(txtNomeAtivCad.getText());
        bean.setAtivValor(Float.valueOf(txtValorAtivCad.getText()));
        bean.setAtivDescr(txtDescAtivCad.getText());
                
               controller.cadAtiv(bean);        
               JOptionPane.showMessageDialog(this, "Cadastrado com sucesso");
               
        lista = controller.ConsultaUltimaAtivCad();
        
        for(int i = 0; i < lista.size(); i ++){
            txtCodAtiv.setText(String.valueOf(lista.get(i).getAtivCod()));
            txtNomeAtivCons.setText(lista.get(i).getAtivNome());
            txtValorAtivCons.setText(String.valueOf(lista.get(i).getAtivValor()));
            txtDescAtivCons.setText(lista.get(i).getAtivDescr());
        }
        
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
        }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        Ativ_bean bean = new Ativ_bean();
        Ativ_controller controller = new Ativ_controller();
        
        try{
          
            if(txtCodAtiv.getText().equals("")){
            bean.setAtivCod(0);
            }else{
            bean.setAtivCod(Integer.valueOf(txtCodAtiv.getText()));    
            }
            bean.setAtivNome(txtNomeAtivCons.getText());
            if(txtValorAtivCons.getText().equals("")){
            bean.setAtivValor(0);
            }else{
            bean.setAtivValor(Float.valueOf(txtValorAtivCons.getText()));    
            }
            bean.setAtivDescr(txtDescAtivCons.getText());
            if(checkFiltroDes.isSelected()){
                bean.setDesativ(1);
            }else{
                bean.setDesativ(0);
            }

            lista = controller.ConsultaAtivs(bean);
            
    while(tmCadAtiv.getRowCount()>0){ // enquanto as linhas forem zeradas, pega as linhas zeradas 
        tmCadAtiv.removeRow(0); // e as remove
    }    
    if(lista.size() == 0){
        
            JOptionPane.showMessageDialog(this,"Nenhuma atividade localizada na pesquisa");
    }else{
        String[] linha = new String[] {null, null, null, null};
        for( int i=0; i <lista.size(); i++){
           
            
            tmCadAtiv.addRow(linha);
            tmCadAtiv.setValueAt(lista.get(i).getAtivCod(), i, 0);
            tmCadAtiv.setValueAt(lista.get(i).getAtivNome(), i, 1);
            tmCadAtiv.setValueAt(lista.get(i).getAtivValor(), i, 2);
            tmCadAtiv.setValueAt(lista.get(i).getAtivStatus(), i, 3);
            
    }
    } 
        
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
       Ativ_bean bean = new Ativ_bean();
       Ativ_controller controller = new Ativ_controller();
       
       bean.setAtivCod(Integer.valueOf(txtCodAtiv.getText()));
       bean.setAtivNome(txtNomeAtivCons.getText());
       bean.setAtivValor(Float.valueOf(txtValorAtivCons.getText()));
       bean.setAtivDescr(txtDescAtivCons.getText());
       
       int resp = JOptionPane.showConfirmDialog(this,"Confirma a alteração dessa atividade?",
        "Confirmação", JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_NO_OPTION){
       try{
       controller.AlteraAtiv(bean);    
       JOptionPane.showMessageDialog(this, "Alteração realizada com sucesso");
       
       }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
       }
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed

        txtCodAtiv.setText("");
        txtDescAtivCons.setText("");
        txtNomeAtivCons.setText("");
        txtValorAtivCons.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnDesativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesativarActionPerformed
        Ativ_bean bean = new Ativ_bean();
       Ativ_controller controller = new Ativ_controller();
       
       bean.setAtivCod(Integer.valueOf(txtCodAtiv.getText()));
       int resp = JOptionPane.showConfirmDialog(this,"Confirma a desativação dessa atividade?",
        "Confirmação", JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_NO_OPTION){
       try{
       controller.DesativaAtiv(bean);
       JOptionPane.showMessageDialog(this, "Atividade desativada com sucesso");
       
       }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
       }
        }
    }//GEN-LAST:event_btnDesativarActionPerformed

    private void btnReativarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReativarActionPerformed
Ativ_bean bean = new Ativ_bean();
       Ativ_controller controller = new Ativ_controller();
       
       bean.setAtivCod(Integer.valueOf(txtCodAtiv.getText()));
       int resp = JOptionPane.showConfirmDialog(this,"Confirma a reativação dessa atividade?",
        "Confirmação", JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_NO_OPTION){
       try{
       controller.AtivaAtiv(bean);
       JOptionPane.showMessageDialog(this, "Atividade reativada com sucesso");
       
       }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
       }
        }
    }//GEN-LAST:event_btnReativarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnDesativar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnReativar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox checkFiltroDes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbConsAtiv;
    private javax.swing.JTextField txtCodAtiv;
    private javax.swing.JTextArea txtDescAtivCad;
    private javax.swing.JTextArea txtDescAtivCons;
    private javax.swing.JTextField txtNomeAtivCad;
    private javax.swing.JTextField txtNomeAtivCons;
    private javax.swing.JTextField txtValorAtivCad;
    private javax.swing.JTextField txtValorAtivCons;
    // End of variables declaration//GEN-END:variables

    public boolean verificaCamposCad(){
        if(!txtNomeAtivCad.getText().equals("") && !txtValorAtivCad.getText().equals("") && !txtDescAtivCad.getText().equals("")){
            return true;
        }else{
            JOptionPane.showMessageDialog(this, "Todos os campos são de preenchimento obrigatório");
            return false;
        }
    }
    
    private void LinhaSelecionada(JTable tabela){

        if (tbConsAtiv.getSelectedRow() != -1) {
        txtCodAtiv.setText(String.valueOf(lista.get(tabela.getSelectedRow()).getAtivCod()));
        txtNomeAtivCons.setText(String.valueOf(lista.get(tabela.getSelectedRow()).getAtivNome()));
        txtValorAtivCons.setText(String.valueOf(lista.get(tabela.getSelectedRow()).getAtivValor()));
        txtDescAtivCons.setText(String.valueOf(lista.get(tabela.getSelectedRow()).getAtivDescr()));
        
        }
    }
    
    
}
