/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Agam07220_AllObjMod;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Agam
 */
public class Agam07220_DeletePasien extends javax.swing.JFrame {

    JFrame Dokter = new JFrame();
    JTable tabelpasien = new JTable();
    JScrollPane scrolldokter = new JScrollPane(tabelpasien);
    JLabel dokterlabel, userlabel, passlabel, passbarulabel;
    JTextField usertext, passtext;
    JButton back, del;
    private static Scanner input = new Scanner(System.in);

    public Agam07220_DeletePasien() {
        Dokter.setSize(650, 500);
        Dokter.setLayout(null);
        Dokter.getContentPane().setBackground(Color.PINK);

        dokterlabel = new JLabel("Update data Pasien");
        dokterlabel.setBounds(150, 30, 400, 30);
        dokterlabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        Dokter.add(dokterlabel);

        scrolldokter.setBounds(30, 100, 570, 200);
        tabelpasien.setModel(Agam07220_AllObjCtrl.Pasien.daftarpasien());
        Dokter.add(scrolldokter);

        userlabel = new JLabel("Username");
        userlabel.setBounds(50, 320, 100, 30);
        Dokter.add(userlabel);

        usertext = new JTextField();
        usertext.setBounds(50, 350, 100, 30);
        Dokter.add(usertext);

        passlabel = new JLabel("password");
        passlabel.setBounds(200, 320, 100, 30);
        Dokter.add(passlabel);

        passtext = new JTextField();
        passtext.setBounds(200, 350, 100, 30);
        Dokter.add(passtext);

        del = new JButton("Hapus Data Pasien");
        del.setBounds(350, 350, 200, 30);
        del.setBackground(Color.GREEN);
        Dokter.add(del);

        back = new JButton("back");
        back.setBounds(50, 400, 100, 30);
        back.setBackground(Color.red);
        Dokter.add(back);

        Dokter.setLocationRelativeTo(null);
        Dokter.setVisible(true);
        Dokter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabelpasien.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelpasien.getSelectedRow();
                usertext.setText(Agam07220_AllObjCtrl.Pasien.daftarpasien().getValueAt(i, 0).toString());
                passtext.setText(Agam07220_AllObjCtrl.Pasien.daftarpasien().getValueAt(i, 1).toString());
            }
        });

        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                btnConfirmDialogActionPerformed(ae);

            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Dokter.dispose();
                Agam07220_DokterGUI men = new Agam07220_DokterGUI();
            }
        });
    }

    public void btnConfirmDialogActionPerformed(java.awt.event.ActionEvent evt) {
        int jawab = JOptionPane.showConfirmDialog(this, "Silahkan Konfirmasi");
        String user = usertext.getText();
        String pass = passtext.getText();
        // 0 : yes
        // 1 : no
        // 2 : cancel
        switch (jawab) {
            case JOptionPane.YES_OPTION:
                try {
                    int index = Agam07220_AllObjMod.pasMod.cekData(user, pass);
                    Agam07220_AllObjMod.dafPasMod.daftarpasienArrayList.remove(index);
                    Agam07220_AllObjMod.pasMod.pasienEntityArrayList.remove(index);
                    JOptionPane.showMessageDialog(null, "Hapus Data Sukses", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Nama atau password salah", "information", JOptionPane.INFORMATION_MESSAGE);
                    kosong();
                }
                break;
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(this, "Ganti Password dibatalkan");
                break;
        }
    }

    void kosong() {
        usertext.setText(null);
        passtext.setText(null);
    }
}
