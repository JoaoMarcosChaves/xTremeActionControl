/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.control.gui;

import java.awt.Dimension;
import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author joãomarcos
 */
public class CadAlunos extends javax.swing.JInternalFrame {

    DefaultTableModel tmAlus = new DefaultTableModel (null, new String [] {"Código aluno" ,"Nome","CPF","Idade","Sexo"});
    public CadAlunos() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelPrincip = new javax.swing.JDesktopPane();
        btnNovoCad = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAlu = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCodAlu = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        txtIdade = new javax.swing.JTextField();
        txtCep = new javax.swing.JTextField();
        txtNumRes = new javax.swing.JTextField();
        txtDesc = new javax.swing.JTextField();
        radioMasc = new javax.swing.JRadioButton();
        radioFem = new javax.swing.JRadioButton();
        btnTelef = new javax.swing.JButton();
        btnEmail = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Alunos");

        panelPrincip.setBackground(new java.awt.Color(240, 240, 240));
        panelPrincip.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Consulta de alunos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        btnNovoCad.setText("Novo cadastro");
        btnNovoCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoCadActionPerformed(evt);
            }
        });

        jButton2.setText("Pesquisar");

        btnAlterar.setText("Alterar");

        tbAlu.setModel(tmAlus);
        jScrollPane1.setViewportView(tbAlu);

        jLabel1.setText("Código aluno:");

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Peso:");

        jLabel5.setText("Idade:");

        jLabel6.setText("CEP:");

        jLabel7.setText("Num. Residencia:");

        jLabel8.setText("Desconto de:");

        jLabel9.setText("Sexo:");

        buttonGroup1.add(radioMasc);
        radioMasc.setText("Masculino");

        buttonGroup1.add(radioFem);
        radioFem.setText("Feminino");

        btnTelef.setText("Telefones");
        btnTelef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTelefActionPerformed(evt);
            }
        });

        btnEmail.setText("E-mails");
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipLayout = new javax.swing.GroupLayout(panelPrincip);
        panelPrincip.setLayout(panelPrincipLayout);
        panelPrincipLayout.setHorizontalGroup(
            panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipLayout.createSequentialGroup()
                        .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(panelPrincipLayout.createSequentialGroup()
                                .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnAlterar)
                                    .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelPrincipLayout.createSequentialGroup()
                                        .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelPrincipLayout.createSequentialGroup()
                                                .addGap(205, 205, 205)
                                                .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(panelPrincipLayout.createSequentialGroup()
                                                        .addComponent(jLabel7)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtNumRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(panelPrincipLayout.createSequentialGroup()
                                                        .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel5)
                                                            .addComponent(jLabel6))
                                                        .addGap(56, 56, 56)
                                                        .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(55, 55, 55)
                                                .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel9))
                                                .addGap(27, 27, 27)
                                                .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(panelPrincipLayout.createSequentialGroup()
                                                        .addComponent(radioMasc)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(radioFem))
                                                    .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 128, Short.MAX_VALUE))
                                    .addGroup(panelPrincipLayout.createSequentialGroup()
                                        .addComponent(txtCodAlu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2)))))
                        .addContainerGap())
                    .addGroup(panelPrincipLayout.createSequentialGroup()
                        .addComponent(btnNovoCad)
                        .addGap(18, 18, 18)
                        .addComponent(btnTelef)
                        .addGap(18, 18, 18)
                        .addComponent(btnEmail)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        panelPrincipLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCep, txtCpf, txtDesc, txtIdade, txtNome, txtNumRes, txtPeso});

        panelPrincipLayout.setVerticalGroup(
            panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoCad)
                    .addComponent(btnTelef)
                    .addComponent(btnEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btnAlterar)
                .addGap(18, 18, 18)
                .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelPrincipLayout.createSequentialGroup()
                            .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(txtNumRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelPrincipLayout.createSequentialGroup()
                            .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))))
                    .addGroup(panelPrincipLayout.createSequentialGroup()
                        .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelPrincipLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(radioMasc)
                            .addComponent(radioFem))))
                .addGap(61, 61, 61)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelPrincip.setLayer(btnNovoCad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(btnAlterar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(txtCodAlu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(txtNome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(txtCpf, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(txtPeso, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(txtIdade, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(txtCep, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(txtNumRes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(txtDesc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(radioMasc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(radioFem, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(btnTelef, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelPrincip.setLayer(btnEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincip)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPrincip)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoCadActionPerformed
 
        CadAlunosIntern alu = new CadAlunosIntern();
        centralizaForm(alu);
        panelPrincip.add(alu);
        alu.setVisible(true);
        
    }//GEN-LAST:event_btnNovoCadActionPerformed

    private void btnTelefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTelefActionPerformed
     CadAlunos_telefones tel = new CadAlunos_telefones();
        centralizaForm(tel);
        panelPrincip.add(tel);
        tel.setVisible(true);
    }//GEN-LAST:event_btnTelefActionPerformed

    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailActionPerformed
    CadAlunos_emails em = new CadAlunos_emails();
        centralizaForm(em);
        panelPrincip.add(em);
        em.setVisible(true);
    }//GEN-LAST:event_btnEmailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnEmail;
    private javax.swing.JButton btnNovoCad;
    private javax.swing.JButton btnTelef;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDesktopPane panelPrincip;
    private javax.swing.JRadioButton radioFem;
    private javax.swing.JRadioButton radioMasc;
    private javax.swing.JTable tbAlu;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCodAlu;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumRes;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables

private void centralizaForm(JInternalFrame frame) {
        Dimension desktopSize = panelPrincip.getSize();
        Dimension jInternalFrameSize = frame.getSize();
        frame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
    }

public void recebeInf(String cod){
    txtCodAlu.setText(cod);
}
}
