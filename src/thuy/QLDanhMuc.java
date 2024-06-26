/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package thuy;

import dao.danhmucdongvatDao;
import entity.danhmucdongvat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import uliti.Dialog;

/**
 *
 * @author Hieu
 */
public class QLDanhMuc extends javax.swing.JDialog {

    boolean isvalidate = false;
    int row = -1;
    danhmucdongvatDao dao;
    List<danhmucdongvat> lstdmdv = new ArrayList<>();

    /**
     * Creates new form danhmucdongvatJDiaLog
     */
    public QLDanhMuc(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        setTitle("QL Danh Mục");
        setLocationRelativeTo(null);
        dao = new danhmucdongvatDao();
        filltable();
    }

    public void moi() {
        txt_madm.setText("");
        txt_tendm.setText("");
        row = -1;
    }

    public void add() {
        danhmucdongvat a = getForm();
        if (!isvalidate) {
            return;
        }
        dao.addData(a);
        filltable();
    }

    public void sua() {
        if (row < 0) {
            Dialog.mess("Vui Lòng Chọn Trường Dữ Liệu Để Thao Tác");
            return;
        }
        danhmucdongvat a = getForm();
        if (!isvalidate) {
            return;
        }
        dao.updateData(a);
        filltable();
    }

    public void xoa() {
        if (row < 0) {
            Dialog.mess("Vui Lòng Chọn Trường Dữ Liệu Để Thao Tác");
            return;
        }
        danhmucdongvat a = getForm();
        dao.deleteData(a);
        filltable();
    }

    public danhmucdongvat getForm() {
        row = tbl_DanhMuc.getSelectedRow();
        danhmucdongvat a = new danhmucdongvat();
        if (row != -1) {
            int id = (int) tbl_DanhMuc.getValueAt(row, 0);
            a.setId(id);
        }
        String madm = txt_madm.getText();
        String tendm = txt_tendm.getText();
        String[] strs = {madm, tendm};
        isvalidate = uliti.validate.Validate(strs, strs.length);
        a.setMadm(madm);
        a.setTendm(tendm);
        return a;
    }

    public void setForm(int index) {
        lstdmdv = dao.getAllData();
        if (lstdmdv.isEmpty()) {
            System.out.println("Danh Sách Trống");
            return;
        }
        danhmucdongvat a = lstdmdv.get(index);
        txt_madm.setText(a.getMadm());
        txt_tendm.setText(a.getTendm());
    }

    public void filltable() {
        DefaultTableModel defaultTableModel = (DefaultTableModel) tbl_DanhMuc.getModel();
        defaultTableModel.setRowCount(0);
        lstdmdv = dao.getAllData();
        if (lstdmdv.isEmpty()) {
            System.out.println("Danh Sách Trống");
            return;
        }
        int i = 0;
        for (danhmucdongvat object : lstdmdv) {
            i++;
            Object[] row = {
                object.getId(),
                object.getMadm(),
                object.getTendm(),
                object.getTrangthai() == 1 ? "Tạm Chưa Nghĩ Ra" : "aa"
            };
            defaultTableModel.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_DanhMuc = new javax.swing.JTable();
        txt_tendm = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_madm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btn_Them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_moi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tbl_DanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Mã Danh Mục", "Tên Danh Mục", "Trạng Thái"
            }
        ));
        tbl_DanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_DanhMucMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_DanhMuc);

        jLabel1.setText("Tên Danh Mục");

        jLabel2.setText("Mã Danh Mục");

        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xoá");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_moi.setText("Mới");
        btn_moi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_moiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txt_tendm, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_madm, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Them)
                        .addGap(18, 18, 18)
                        .addComponent(btn_sua)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xoa))
                    .addComponent(btn_moi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_madm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tendm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Them)
                            .addComponent(btn_sua)
                            .addComponent(btn_xoa))
                        .addGap(18, 18, 18)
                        .addComponent(btn_moi))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        add();
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        sua();
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        xoa();
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_moiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_moiActionPerformed
        // TODO add your handling code here:
        moi();
    }//GEN-LAST:event_btn_moiActionPerformed

    private void tbl_DanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_DanhMucMouseClicked
        // TODO add your handling code here:
        row = tbl_DanhMuc.getSelectedRow();
        setForm(row);
    }//GEN-LAST:event_tbl_DanhMucMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_moi;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_DanhMuc;
    private javax.swing.JTextField txt_madm;
    private javax.swing.JTextField txt_tendm;
    // End of variables declaration//GEN-END:variables
}
