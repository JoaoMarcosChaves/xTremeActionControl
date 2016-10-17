/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.control.gui;

import br.control.Beans.Alunos_bean;
import br.control.Controller.Alunos_controller;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class CadAlunos_telefones extends javax.swing.JInternalFrame {

    DefaultTableModel tmTelefs = new DefaultTableModel (null, new String [] {"Telefone","tipo"});
    List<Alunos_bean> tel;
    ListSelectionModel lsmTelefs;
    public CadAlunos_telefones() {
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
        txtCodAlu = new javax.swing.JTextField();
        txtTelef = new javax.swing.JTextField();
        try{  javax.swing.text.MaskFormatter tel= new javax.swing.text.MaskFormatter("####-####"); txtTelef = new javax.swing.JFormattedTextField(tel); } catch (Exception e){ }
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTelefs = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtCel = new javax.swing.JTextField();
        try{  javax.swing.text.MaskFormatter tel= new javax.swing.text.MaskFormatter("#####-####"); txtCel = new javax.swing.JFormattedTextField(tel); } catch (Exception e){ }
        jLabel4 = new javax.swing.JLabel();
        txtTelefCod = new javax.swing.JTextField();
        btnCadNovoTel = new javax.swing.JButton();
        btnSalvNovo = new javax.swing.JButton();
        btnCadNovoCel = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Telefones");

        jLabel1.setText("Código aluno:");

        jLabel2.setText("Telefone:");

        txtCodAlu.setEnabled(false);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        tbTelefs.setModel(tmTelefs);
        tbTelefs.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmTelefs= tbTelefs.getSelectionModel();
        lsmTelefs.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if (! e.getValueIsAdjusting()){
                    LinhaSelecionada(tbTelefs);
                }
            }
        });
        jScrollPane1.setViewportView(tbTelefs);

        jLabel3.setText("Celular:");

        jLabel4.setText("Telef. Cod:");

        txtTelefCod.setEnabled(false);

        btnCadNovoTel.setText("Cadastrar novo telefone");
        btnCadNovoTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadNovoTelActionPerformed(evt);
            }
        });

        btnSalvNovo.setText("Salvar novo");
        btnSalvNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvNovoActionPerformed(evt);
            }
        });

        btnCadNovoCel.setText("Cadastrar novo celular");
        btnCadNovoCel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadNovoCelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTelefCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCodAlu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(92, 92, 92)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTelef, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(btnCadNovoTel)
                                .addGap(18, 18, 18)
                                .addComponent(btnCadNovoCel)
                                .addGap(24, 24, 24)
                                .addComponent(btnSalvNovo))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCel, txtTelef});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCodAlu, txtTelefCod});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtCodAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTelefCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlterar)
                    .addComponent(btnExcluir)
                    .addComponent(btnCadNovoTel)
                    .addComponent(btnSalvNovo)
                    .addComponent(btnCadNovoCel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        Alunos_bean bean = new Alunos_bean();
        Alunos_controller controller = new Alunos_controller();
        
        if(!txtTelef.getText().replace("-", "").replaceAll(" ", "").equals("")){
        bean.setAluTelefone(txtTelef.getText());    
        }else if(!txtCel.getText().replace("-", "").replaceAll(" ", "").equals("")){
        bean.setAluTelefone(txtCel.getText());    
        }
        
        bean.setTelefCod(Integer.valueOf(txtTelefCod.getText()));
        
        int resp = JOptionPane.showConfirmDialog(this,"Confirma a alteração desse telefone?",
        "Confirmação", JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_NO_OPTION){
        try {
            controller.AlteraTelefAlu(bean);
            JOptionPane.showMessageDialog(this, "Telefone alterado com sucesso");  
           
           bean.setAluCod(Integer.valueOf(txtCodAlu.getText()));
           tel = controller.ConsultaTelefsAlu(bean);
           MostraPesquisa();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);   
        }
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnCadNovoTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadNovoTelActionPerformed
       txtCel.setEnabled(false);
       txtTelef.setEnabled(true);
       txtCel.setText("");
       txtTelef.setText("");
        
    }//GEN-LAST:event_btnCadNovoTelActionPerformed

    private void btnCadNovoCelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadNovoCelActionPerformed
        
        txtCel.setEnabled(true);
        txtTelef.setEnabled(false);
        txtCel.setText("");
       txtTelef.setText("");
        
    }//GEN-LAST:event_btnCadNovoCelActionPerformed

    private void btnSalvNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvNovoActionPerformed
        Alunos_bean bean = new Alunos_bean();
        Alunos_controller controller = new Alunos_controller();
        
        bean.setAluCod(Integer.valueOf(txtCodAlu.getText()));
        
        if(!txtCel.getText().replace("-", "").equals("")){
        bean.setAluTelefone(txtCel.getText());
        bean.setTelefTip("Cel");
        }
        else if(!txtTelef.getText().replace("-", "").equals("")){
        bean.setAluTelefone(txtTelef.getText());
        bean.setTelefTip("Fix");
        }
        
        int resp = JOptionPane.showConfirmDialog(this,"Confirma a inserção deste novo contato?",
        "Confirmação", JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_NO_OPTION){
            try{
                controller.cadTelefAlu(bean);
                JOptionPane.showMessageDialog(this, "Novo contato salvo com sucesso");   
                bean.setAluCod(Integer.valueOf(txtCodAlu.getText()));
                tel = controller.ConsultaTelefsAlu(bean);
                MostraPesquisa();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(this, ex);   
            }
        }
    }//GEN-LAST:event_btnSalvNovoActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       Alunos_bean bean = new Alunos_bean();
       Alunos_controller controller = new Alunos_controller();
        
        bean.setTelefCod(Integer.valueOf(txtTelefCod.getText()));
        
        int resp = JOptionPane.showConfirmDialog(this,"Confirma a exclusão deste contato?",
        "Confirmação", JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_NO_OPTION){
            try{
                controller.ExcluiTelAlu(bean);
                JOptionPane.showMessageDialog(this, "Contato excluído com sucesso");   
                bean.setAluCod(Integer.valueOf(txtCodAlu.getText()));
                tel = controller.ConsultaTelefsAlu(bean);
                MostraPesquisa();
            }catch(SQLException ex){
                JOptionPane.showMessageDialog(this, ex);   
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnCadNovoCel;
    private javax.swing.JButton btnCadNovoTel;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbTelefs;
    private javax.swing.JTextField txtCel;
    private javax.swing.JTextField txtCodAlu;
    private javax.swing.JTextField txtTelef;
    private javax.swing.JTextField txtTelefCod;
    // End of variables declaration//GEN-END:variables

public void RecebeCod(String cod){
    txtCodAlu.setText(cod);
    Alunos_bean bean = new Alunos_bean();
    Alunos_controller controller = new Alunos_controller();
    
    bean.setAluCod(Integer.valueOf(cod));
        try {
           tel = controller.ConsultaTelefsAlu(bean);
           MostraPesquisa();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);   
        }
    txtCel.setEnabled(false);
    txtTelef.setEnabled(false);
}

public void MostraPesquisa(){
    while(tmTelefs.getRowCount()>0){ // enquanto as linhas forem zeradas, pega as linhas zeradas 
            tmTelefs.removeRow(0); // e as remove
            }
            if(tel.size() == 0){
        
            JOptionPane.showMessageDialog(this,"Nenhum telefone vinculado ao aluno selecionado");
               }else{
                String[] linha = new String[] {null, null, null, null};
        for( int i=0; i <tel.size(); i++){
           
            tmTelefs.addRow(linha);
            tmTelefs.setValueAt(tel.get(i).getAluTelefone(), i, 0);
            tmTelefs.setValueAt(tel.get(i).getTelefTip(), i, 1);
            
            
               }
                }
}

private void LinhaSelecionada(JTable tabela){

        if (tbTelefs.getSelectedRow() != -1) {
            txtCel.setText("");
            txtTelef.setText("");
            txtTelefCod.setText(String.valueOf(tel.get(tabela.getSelectedRow()).getTelefCod()));
            if(String.valueOf(tel.get(tabela.getSelectedRow()).getAluTelefone()).length() == 9){
            txtCel.setEnabled(false);
            txtTelef.setEnabled(true);
            txtTelef.setText(String.valueOf(tel.get(tabela.getSelectedRow()).getAluTelefone()));        
            }
            else if(String.valueOf(tel.get(tabela.getSelectedRow()).getAluTelefone()).length() == 10){
            txtCel.setEnabled(true);
            txtTelef.setEnabled(false);
            txtCel.setText(String.valueOf(tel.get(tabela.getSelectedRow()).getAluTelefone()));        
            }
        }
    }

}
