/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.control.gui;

import br.control.Beans.Alunos_bean;
import br.control.Beans.Ativ_bean;
import br.control.Beans.Matricula_bean;
import br.control.Controller.Alunos_controller;
import br.control.Controller.Ativ_controller;
import br.control.Controller.MatrAlu_controller;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author joãomarcos
 */
public class MatriculaAlunos extends javax.swing.JInternalFrame {

    DefaultTableModel tmAlus = new DefaultTableModel (null, new String [] {"Código aluno" ,"Nome","CPF","Idade","Sexo"});
    DefaultTableModel tmMatr = new DefaultTableModel (null, new String [] {"Matricula" ,"Atividade","Valor","Status"});
    List<Alunos_bean> alunos = new ArrayList<>();
    List<Matricula_bean> matriculas = new ArrayList<>();
    List<Ativ_bean> listaAtiv;
    ListSelectionModel lsmAlu;
    ListSelectionModel lsmMat;

    public MatriculaAlunos() {
        initComponents();
        Ativ_bean bean = new Ativ_bean();
        Ativ_controller controller = new Ativ_controller();
        
        try{
          bean.setAtivCod(0);
            bean.setAtivNome("");
            bean.setAtivValor(0);
            bean.setDesativ(0);
            listaAtiv = controller.ConsultaAtivs(bean);
            
            for(int i = 0; i < listaAtiv.size();i++){
                comboAtiv.addItem(listaAtiv.get(i).getAtivCod()+" - "+listaAtiv.get(i).getAtivNome());
            }
        }catch(SQLException e){
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoRadio = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCodAlu = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        txtIdade = new javax.swing.JTextField();
        txtNumRes = new javax.swing.JTextField();
        radioMasc = new javax.swing.JRadioButton();
        radioFem = new javax.swing.JRadioButton();
        txtCpf = new javax.swing.JFormattedTextField();
        txtCep = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAlu = new javax.swing.JTable();
        btnLimpCamp = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCodAluMat = new javax.swing.JTextField();
        txtMat = new javax.swing.JTextField();
        txtStatusMat = new javax.swing.JTextField();
        comboAtiv = new javax.swing.JComboBox();
        dtVencMens = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMats = new javax.swing.JTable();
        btnTrancarMat = new javax.swing.JButton();
        btnDestrancMat = new javax.swing.JButton();
        btnSalvaMat = new javax.swing.JButton();
        txtValMens = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Consulta de Alunos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel1.setText("Código aluno:");

        jLabel2.setText("Nome:");

        jLabel3.setText("CPF:");

        jLabel4.setText("Peso:");

        jLabel5.setText("Idade:");

        jLabel6.setText("CEP:");

        jLabel7.setText("Num. Residencia:");

        jLabel9.setText("Sexo:");

        txtCodAlu.setText("0");

        txtPeso.setText("0");

        txtIdade.setText("0");

        txtNumRes.setText("0");

        grupoRadio.add(radioMasc);
        radioMasc.setText("Masculino");

        grupoRadio.add(radioFem);
        radioFem.setText("Feminino");

        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        tbAlu.setModel(tmAlus);
        tbAlu.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmAlu= tbAlu.getSelectionModel();
        lsmAlu.addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent e){
                if (! e.getValueIsAdjusting()){
                    LinhaSelecionada(tbAlu);
                }
            }
        });
        jScrollPane1.setViewportView(tbAlu);

        btnLimpCamp.setText("Limpar campos");
        btnLimpCamp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpCampActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodAlu, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(45, 45, 45)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(49, 49, 49)
                                .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(56, 56, 56)
                                .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(64, 64, 64)
                                .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(27, 27, 27)
                                .addComponent(radioMasc)
                                .addGap(18, 18, 18)
                                .addComponent(radioFem)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpCamp))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPesquisar))))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCep, txtCpf, txtIdade, txtNome, txtNumRes, txtPeso});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(btnLimpCamp))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtCodAlu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNumRes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(radioMasc)
                            .addComponent(radioFem))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Matricula de alunos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel8.setText("*Código Aluno:");

        jLabel10.setText("Matricula:");

        jLabel11.setText("*Atividade:");

        jLabel12.setText("*Valor da mensalidade:   R$");

        jLabel13.setText("*Vencimento da mensalidade:");

        jLabel14.setText("Status Matricula:");

        comboAtiv.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione uma atividade" }));
        comboAtiv.setToolTipText("");
        comboAtiv.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboAtivItemStateChanged(evt);
            }
        });

        tbMats.setModel(tmMatr);
        tbMats.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);   lsmMat= tbMats.getSelectionModel();   lsmMat.addListSelectionListener(new ListSelectionListener(){      public void valueChanged(ListSelectionEvent e){          if (! e.getValueIsAdjusting()){            LinhaSelecionadaMat(tbMats);   }   }   });
        jScrollPane2.setViewportView(tbMats);

        btnTrancarMat.setText("Trancar matricula");
        btnTrancarMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrancarMatActionPerformed(evt);
            }
        });

        btnDestrancMat.setText("Destrancar matricula");
        btnDestrancMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDestrancMatActionPerformed(evt);
            }
        });

        btnSalvaMat.setText("Salvar matricula");
        btnSalvaMat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvaMatActionPerformed(evt);
            }
        });

        DecimalFormat dFormat = new DecimalFormat("###.00") ;
        NumberFormatter formatter = new NumberFormatter(dFormat) ;
        formatter.setFormat(dFormat) ;
        formatter.setAllowsInvalid(false) ;

        txtValMens.setFormatterFactory ( new DefaultFormatterFactory (formatter ) ) ;

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtStatusMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodAluMat, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboAtiv, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(84, 84, 84))
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValMens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtVencMens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnTrancarMat)
                        .addGap(26, 26, 26)
                        .addComponent(btnDestrancMat)
                        .addGap(28, 28, 28)
                        .addComponent(btnSalvaMat)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCodAluMat, txtMat, txtStatusMat, txtValMens});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtCodAluMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(comboAtiv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtValMens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(txtStatusMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13)
                    .addComponent(dtVencMens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTrancarMat)
                    .addComponent(btnDestrancMat)
                    .addComponent(btnSalvaMat))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
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

    private void btnLimpCampActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpCampActionPerformed
        txtCodAlu.setText("0");
        txtNome.setText("");
        txtCpf.setText("");
        txtPeso.setText("0");
        txtIdade.setText("0");
        txtCep.setText("");
        txtNumRes.setText("0");
        grupoRadio.clearSelection();

    }//GEN-LAST:event_btnLimpCampActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        Alunos_bean bean = new Alunos_bean();
        Alunos_controller controller = new Alunos_controller();
        

        bean.setAluCod(Integer.valueOf(txtCodAlu.getText()));
        bean.setAluNome(txtNome.getText());
        bean.setAluCpf(txtCpf.getText().replace(".", "").replace("-", "").replaceAll(" ", ""));
        bean.setAluIdade(Integer.valueOf(txtIdade.getText()));
        bean.setAluPeso(Float.valueOf(txtPeso.getText()));
        bean.setAluCep(txtCep.getText().replace("-", "").replaceAll(" ", ""));
        bean.setAluNumResid(Integer.valueOf(txtNumRes.getText()));
        if(radioMasc.isSelected()){
            bean.setAluSexo("Masculino");
        }
        if(radioFem.isSelected()){
            bean.setAluSexo("Feminino");
        }
        bean.setValDesc(0);

        try {
            alunos =   controller.ConsultaAlu(bean);
            MostraPesquisa();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
       
        
         
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnTrancarMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrancarMatActionPerformed
        Matricula_bean bean = new Matricula_bean();
        MatrAlu_controller controller = new MatrAlu_controller();
        
        if(!txtMat.getText().equals("")){
            int resp = JOptionPane.showConfirmDialog(this,"Confirma que esta matricula será trancada?",
        "Confirmação", JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_NO_OPTION){
            
           bean.setMatrCod(Integer.valueOf(txtMat.getText()));
            
           try{
               controller.TrancMatricAlu(bean);
               JOptionPane.showMessageDialog(this, "Matricula trancada com sucesso.");
           }catch(SQLException ex){
                JOptionPane.showMessageDialog(this, ex);
           }
               
           try {
            bean.setAluCod(Integer.valueOf(txtCodAluMat.getText()));
            matriculas = controller.ConsultaMatriculas(bean);
            MostraPesquisaMat();
            txtStatusMat.setText("Trancado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
            
        }
        }
    }//GEN-LAST:event_btnTrancarMatActionPerformed

    private void comboAtivItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboAtivItemStateChanged
    float desc = 0;
    
    if(comboAtiv.getSelectedItem().equals("Selecione uma atividade")){
        txtValMens.setText("00");
    }else{
    if(!alunos.isEmpty() && !txtCodAluMat.getText().equals("")){
        

        txtValMens.setText(String.valueOf(listaAtiv.get(comboAtiv.getSelectedIndex()-1).getAtivValor()));

    }
    else{
        txtValMens.setText(String.valueOf(listaAtiv.get(comboAtiv.getSelectedIndex()-1).getAtivValor()));
    }
    }
    }//GEN-LAST:event_comboAtivItemStateChanged

    private void btnSalvaMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaMatActionPerformed
        Matricula_bean bean = new Matricula_bean();
        MatrAlu_controller controller = new MatrAlu_controller();
        java.sql.Date dataVenc = null;
        java.util.Date dataVencUtil = null;
        try{
        dataVencUtil =  dtVencMens.getDate();
	dataVenc = new java.sql.Date(dataVencUtil.getTime());
        }catch(Exception e){}
        
        if(VerificaCampos()){

            bean.setAluCod(Integer.valueOf(txtCodAluMat.getText()));
            bean.setAtivCod(Integer.valueOf(String.valueOf(comboAtiv.getSelectedItem()).substring(0,String.valueOf(comboAtiv.getSelectedItem()).indexOf(" - ")).trim()));
            bean.setMatrValMens(Float.valueOf(txtValMens.getText().replace(",", ".")));
            bean.setMatrDtVenc(dataVenc);
            
            int resp = JOptionPane.showConfirmDialog(this,"Confirma a inserção da matricula aluno?",
        "Confirmação", JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_NO_OPTION){
           try{ 
            controller.CadMatricAlu(bean);
            JOptionPane.showMessageDialog(this, "Aluno matriculado com sucesso.");
            txtMat.setText(String.valueOf(controller.ConsultaUltimaMat()));
             try{

            bean.setAluCod(Integer.valueOf(txtCodAluMat.getText()));
            matriculas = controller.ConsultaMatriculas(bean);
            MostraPesquisaMat();
            
             }catch(SQLException ex){
                 JOptionPane.showMessageDialog(this,"mensali ex: \n"+ ex);
             }
           }catch(SQLException ex){
               JOptionPane.showMessageDialog(this, ex);
           }
        }
        }
        
        
        
    }//GEN-LAST:event_btnSalvaMatActionPerformed

    private void btnDestrancMatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDestrancMatActionPerformed
         Matricula_bean bean = new Matricula_bean();
        MatrAlu_controller controller = new MatrAlu_controller();
        
        if(!txtMat.getText().equals("")){
            int resp = JOptionPane.showConfirmDialog(this,"Confirma que esta matricula será destrancada?",
        "Confirmação", JOptionPane.YES_NO_OPTION);
        if(resp == JOptionPane.YES_NO_OPTION){
            
           bean.setMatrCod(Integer.valueOf(txtMat.getText()));
            
           try{
               controller.DestrancMatricAlu(bean);
               JOptionPane.showMessageDialog(this, "Matricula destrancada com sucesso.");
           }catch(SQLException ex){
                JOptionPane.showMessageDialog(this, ex);
           }
           
           try {
            bean.setAluCod(Integer.valueOf(txtCodAluMat.getText()));
            matriculas = controller.ConsultaMatriculas(bean);
            MostraPesquisaMat();
            txtStatusMat.setText("Aberto");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        }
        }
    }//GEN-LAST:event_btnDestrancMatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDestrancMat;
    private javax.swing.JButton btnLimpCamp;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvaMat;
    private javax.swing.JButton btnTrancarMat;
    private javax.swing.JComboBox comboAtiv;
    private com.toedter.calendar.JDateChooser dtVencMens;
    private javax.swing.ButtonGroup grupoRadio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton radioFem;
    private javax.swing.JRadioButton radioMasc;
    private javax.swing.JTable tbAlu;
    private javax.swing.JTable tbMats;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCodAlu;
    private javax.swing.JTextField txtCodAluMat;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtIdade;
    private javax.swing.JTextField txtMat;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumRes;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtStatusMat;
    private javax.swing.JFormattedTextField txtValMens;
    // End of variables declaration//GEN-END:variables

public void MostraPesquisa(){
    while(tmAlus.getRowCount()>0){ // enquanto as linhas forem zeradas, pega as linhas zeradas 
            tmAlus.removeRow(0); // e as remove
            }
            if(alunos.size() == 0){
        
            JOptionPane.showMessageDialog(this,"Nenhum aluno localizado na pesquisa");
               }else{
                String[] linha = new String[] {null, null, null, null};
        for( int i=0; i <alunos.size(); i++){
           
            tmAlus.addRow(linha);
            tmAlus.setValueAt(alunos.get(i).getAluCod(), i, 0);
            tmAlus.setValueAt(alunos.get(i).getAluNome(), i, 1);
            tmAlus.setValueAt(alunos.get(i).getAluCpf(), i, 2);
            tmAlus.setValueAt(alunos.get(i).getAluIdade(), i, 3);
            tmAlus.setValueAt(alunos.get(i).getAluSexo(), i, 4);
            
               }
                }
}

public void MostraPesquisaMat(){
    while(tmMatr.getRowCount()>0){ // enquanto as linhas forem zeradas, pega as linhas zeradas 
            tmMatr.removeRow(0); // e as remove
            }
            if(matriculas.size() == 0){
        
            JOptionPane.showMessageDialog(this,"Nenhuma matricula localizada.");
               }else{
                String[] linha = new String[] {null, null, null, null};
        for( int i=0; i <matriculas.size(); i++){
           
            tmMatr.addRow(linha);
            tmMatr.setValueAt(matriculas.get(i).getMatrCod(), i, 0);
            tmMatr.setValueAt(matriculas.get(i).getAtivNome(), i, 1);
            tmMatr.setValueAt(matriculas.get(i).getMatrValMens(), i, 2);
            tmMatr.setValueAt(matriculas.get(i).getMatrStatus(), i, 3);
            
            
               }
                }
}

private void LinhaSelecionada(JTable tabela){

    MatrAlu_controller controllerMat = new MatrAlu_controller();
        Matricula_bean beanM = new Matricula_bean();
        if (tbAlu.getSelectedRow() != -1) {
        txtCodAlu.setText(String.valueOf(alunos.get(tabela.getSelectedRow()).getAluCod()));
        txtNome.setText(String.valueOf(alunos.get(tabela.getSelectedRow()).getAluNome()));
        txtCpf.setText(String.valueOf(alunos.get(tabela.getSelectedRow()).getAluCpf()));
        txtPeso.setText(String.valueOf(alunos.get(tabela.getSelectedRow()).getAluPeso()));
        txtIdade.setText(String.valueOf(alunos.get(tabela.getSelectedRow()).getAluIdade()));
        txtCep.setText(String.valueOf(alunos.get(tabela.getSelectedRow()).getAluCep()));
        txtNumRes.setText(String.valueOf(alunos.get(tabela.getSelectedRow()).getAluNumResid()));
        if(String.valueOf(alunos.get(tabela.getSelectedRow()).getAluSexo()).equals("Masculino")){
            
            radioMasc.setSelected(true);
        }
        if(String.valueOf(alunos.get(tabela.getSelectedRow()).getAluSexo()).equals("Feminino")){
            
            radioFem.setSelected(true);
        }
        
        txtCodAluMat.setText(String.valueOf(alunos.get(tabela.getSelectedRow()).getAluCod()));
        }
        
        try {
            beanM.setAluCod(Integer.valueOf(txtCodAlu.getText()));
            matriculas = controllerMat.ConsultaMatriculas(beanM);
            MostraPesquisaMat();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
        
        txtMat.setText("");
        txtStatusMat.setText("");
        txtValMens.setText(",00");
        comboAtiv.setSelectedIndex(0);
        dtVencMens.setDate(null);
    }


private void LinhaSelecionadaMat(JTable tabela){

        if (tbMats.getSelectedRow() != -1) {
        
        txtMat.setText(String.valueOf(matriculas.get(tabela.getSelectedRow()).getMatrCod()));
        txtStatusMat.setText(String.valueOf(matriculas.get(tabela.getSelectedRow()).getMatrStatus()));
        dtVencMens.setDate(matriculas.get(tabela.getSelectedRow()).getMatrDtVenc());
        for(int i = 1; i < comboAtiv.getItemCount();i++){
            if(matriculas.get(tabela.getSelectedRow()).getAtivCod() == 
                   Integer.valueOf(String.valueOf(comboAtiv.getItemAt(i)).substring(0,String.valueOf(comboAtiv.getItemAt(i)).indexOf(" - ")).trim())){
                
              comboAtiv.setSelectedIndex(i);
              
            }
        }
        txtValMens.setText(String.valueOf(matriculas.get(tabela.getSelectedRow()).getMatrValMens()));
        } 
    }

public boolean VerificaCampos(){
    
    if(!txtCodAluMat.getText().equals("") && dtVencMens.getDate() != null && !comboAtiv.getSelectedItem().equals("Selecione uma atividade") 
            && !txtValMens.getText().replace(".00", "").equals("")){
        
        return true;
    }else{
        JOptionPane.showMessageDialog(this, "Os campos com * ao lado são de preenchimeto obrigatório.");
    return false;    
    }
    
    
}
}
