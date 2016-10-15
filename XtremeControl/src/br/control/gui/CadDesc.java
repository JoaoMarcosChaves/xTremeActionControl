/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.control.gui;

import br.control.Beans.DescVal_bean;
import br.control.Controller.DescVal_controller;
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
public class CadDesc extends javax.swing.JInternalFrame {

    DefaultTableModel tmDesc = new DefaultTableModel (null, new String [] {"Código desconto" ,"Porcentagem","Status"});
    List<DescVal_bean> lista;
    ListSelectionModel lsmDesc;
    
    public CadDesc() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPercDescCad = new javax.swing.JTextField();
        txtNumMatCad = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCodDesc = new javax.swing.JTextField();
        txtPercDescCons = new javax.swing.JTextField();
        txtNumMatCons = new javax.swing.JTextField();
        btnAlterar = new javax.swing.JButton();
        btnDesat = new javax.swing.JButton();
        btnReativ = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtStatusDesc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDescs = new javax.swing.JTable();
        btnPesquisar = new javax.swing.JButton();
        checkConsDes = new javax.swing.JCheckBox();
        btnLimparCamp = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Descontos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de desconto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel1.setText("Porcentagem do desconto:");

        jLabel2.setText("Numero de matriculas para obter desconto:");

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
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPercDescCad, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumMatCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(20, 20, 20))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtNumMatCad, txtPercDescCad});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPercDescCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNumMatCad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnSalvar)
                .addGap(21, 21, 21))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta de desconto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel3.setText("Código desconto:");

        jLabel4.setText("Porcentagem do desconto:");

        jLabel5.setText("Numero de matriculas para obter desconto:");

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnDesat.setText("Desativar");
        btnDesat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesatActionPerformed(evt);
            }
        });

        btnReativ.setText("Reativar");
        btnReativ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReativActionPerformed(evt);
            }
        });

        jLabel7.setText("Status:");

        tbDescs.setModel(tmDesc);
        tbDescs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmDesc= tbDescs.getSelectionModel();
        lsmDesc.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if (! e.getValueIsAdjusting()){
                    LinhaSelecionada(tbDescs);
                }
            }
        });
        jScrollPane1.setViewportView(tbDescs);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        checkConsDes.setText("Filtrar descontos desativados");

        btnLimparCamp.setText("Limpar campos");
        btnLimparCamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCampActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPercDescCons, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNumMatCons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtStatusDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCodDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLimparCamp, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDesat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnReativ))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(checkConsDes))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCodDesc, txtNumMatCons, txtPercDescCons, txtStatusDesc});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCodDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPercDescCons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtNumMatCons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(btnLimparCamp)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtStatusDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(checkConsDes)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnDesat)
                    .addComponent(btnReativ))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
  
        DescVal_controller controller = new DescVal_controller();
        DescVal_bean bean = new DescVal_bean();
        List<DescVal_bean> list = new ArrayList<>();
      
        if(verificaCamposCad()){      
         try{   
             
        bean.setDescVal(Float.valueOf(txtPercDescCad.getText()));
        bean.setDescQtdAtiv(Integer.valueOf(txtNumMatCad.getText()));
        
        int resp = JOptionPane.showConfirmDialog(this,"Confirma a inserção desse desconto?",
        "Confirmação", JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_NO_OPTION){
        
            try{
        
            
            
        controller.CadDescVal(bean);
        JOptionPane.showMessageDialog(this, "Desconto cadastrado com sucesso");
        
        list = controller.ConsUltimoDescCad();
        if(!list.isEmpty()){
        for(int i = 0; i < list.size();i++){
            txtCodDesc.setText(String.valueOf(list.get(i).getDescCod()));
            txtPercDescCons.setText(String.valueOf(list.get(i).getDescVal()));
            txtNumMatCons.setText(String.valueOf(list.get(i).getDescQtdAtiv()));
            txtStatusDesc.setText(list.get(i).getDescStatus());
        }
        }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
        }
            
        }
        
        
         }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Esses campos só aceitam números" ,"Informação",JOptionPane.INFORMATION_MESSAGE);
                txtPercDescCad.grabFocus();
            }
        
        
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        DescVal_controller controller = new DescVal_controller();
        DescVal_bean bean = new DescVal_bean();
        
        try{
            if(txtCodDesc.getText().equals("")){
                bean.setDescCod(0);
            }else{
                bean.setDescCod(Integer.valueOf(txtCodDesc.getText()));
            }
            if(txtPercDescCons.getText().equals("")){
                bean.setDescVal(0);
            }else{
                bean.setDescVal(Float.valueOf(txtPercDescCons.getText()));
            }
            if(txtNumMatCons.getText().equals("")){
                bean.setDescQtdAtiv(0);
            }else{
                bean.setDescQtdAtiv(Integer.valueOf(txtNumMatCons.getText()));
            }
            if(checkConsDes.isSelected()){
                bean.setDesativ(1);
            }else{
                bean.setDesativ(0);
            }
            
            lista = controller.ConsDescCad(bean);
            
            while(tmDesc.getRowCount()>0){ // enquanto as linhas forem zeradas, pega as linhas zeradas 
            tmDesc.removeRow(0); // e as remove
            }
            if(lista.size() == 0){
        
            JOptionPane.showMessageDialog(this,"Nenhum desconto localizado na pesquisa");
               }else{
                String[] linha = new String[] {null, null, null, null};
        for( int i=0; i <lista.size(); i++){
           
            
            tmDesc.addRow(linha);
            tmDesc.setValueAt(lista.get(i).getDescCod(), i, 0);
            tmDesc.setValueAt(lista.get(i).getDescVal(), i, 1);
            tmDesc.setValueAt(lista.get(i).getDescStatus(), i, 2);
            
               }
                }
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(this, ex);
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnLimparCampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCampActionPerformed

        txtCodDesc.setText("");
        txtNumMatCons.setText("");
        txtPercDescCons.setText("");
        txtStatusDesc.setText("");
    }//GEN-LAST:event_btnLimparCampActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        DescVal_controller controller = new DescVal_controller();
        DescVal_bean bean = new DescVal_bean();
        
        bean.setDescCod(Integer.valueOf(txtCodDesc.getText()));
        bean.setDescVal(Float.valueOf(txtPercDescCons.getText()));
        bean.setDescQtdAtiv(Integer.valueOf(txtNumMatCons.getText()));
        int resp = JOptionPane.showConfirmDialog(this,"Confirma a alteração desse desconto?",
        "Confirmação", JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_NO_OPTION){
        try{
            controller.AlteraDesc(bean);
            JOptionPane.showMessageDialog(this, "Desconto alterado com sucesso.");
            
        }catch(SQLException ex){
         JOptionPane.showMessageDialog(this, ex);   
        }
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDesatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesatActionPerformed
      DescVal_controller controller = new DescVal_controller();
      DescVal_bean bean = new DescVal_bean();
      
      bean.setDescCod(Integer.valueOf(txtCodDesc.getText()));
      int resp = JOptionPane.showConfirmDialog(this,"Confirma a desativação desse desconto?",
        "Confirmação", JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_NO_OPTION){
      try{
            controller.DesativaDesc(bean);
            JOptionPane.showMessageDialog(this, "Desconto desativado com sucesso.");
        txtCodDesc.setText("");
        txtNumMatCons.setText("");
        txtPercDescCons.setText("");
        txtStatusDesc.setText("");
        }catch(SQLException ex){
         JOptionPane.showMessageDialog(this, ex);   
        }
        }
    }//GEN-LAST:event_btnDesatActionPerformed

    private void btnReativActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReativActionPerformed
        DescVal_controller controller = new DescVal_controller();
      DescVal_bean bean = new DescVal_bean();
      
      bean.setDescCod(Integer.valueOf(txtCodDesc.getText()));
      int resp = JOptionPane.showConfirmDialog(this,"Confirma a reativação desse desconto?",
        "Confirmação", JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_NO_OPTION){
      try{
            controller.ReativaDesc(bean);
            JOptionPane.showMessageDialog(this, "Desconto reativado com sucesso.");
        }catch(SQLException ex){
         JOptionPane.showMessageDialog(this, ex);   
        }
        }
    }//GEN-LAST:event_btnReativActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnDesat;
    private javax.swing.JButton btnLimparCamp;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnReativ;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox checkConsDes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDescs;
    private javax.swing.JTextField txtCodDesc;
    private javax.swing.JTextField txtNumMatCad;
    private javax.swing.JTextField txtNumMatCons;
    private javax.swing.JTextField txtPercDescCad;
    private javax.swing.JTextField txtPercDescCons;
    private javax.swing.JTextField txtStatusDesc;
    // End of variables declaration//GEN-END:variables

public boolean verificaCamposCad(){
    float valor1 ;
    float valor2;
        if(!txtPercDescCad.getText().equals("") && !txtNumMatCad.getText().equals("")){

            return true;
        }else{
            JOptionPane.showMessageDialog(this, "Todos os campos são de preenchimento obrigatório");
            return false;
        }
    }

 private void LinhaSelecionada(JTable tabela){

        if (tbDescs.getSelectedRow() != -1) {
        txtCodDesc.setText(String.valueOf(lista.get(tabela.getSelectedRow()).getDescCod()));
        txtPercDescCons.setText(String.valueOf(lista.get(tabela.getSelectedRow()).getDescVal()));
        txtNumMatCons.setText(String.valueOf(lista.get(tabela.getSelectedRow()).getDescQtdAtiv()));
        txtStatusDesc.setText(String.valueOf(lista.get(tabela.getSelectedRow()).getDescStatus()));
        
        }
    }
}
