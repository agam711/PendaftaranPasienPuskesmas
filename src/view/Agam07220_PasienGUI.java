/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import entity.Agam07220_PasienEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Agam
 */
public class Agam07220_PasienGUI {
    JFrame Pasien = new JFrame();
    JButton back, daftarbtn;
    JTextArea area = new JTextArea();
    JLabel datadiri, daftarpasien;
    int cek = Agam07220_AllObjCtrl.Pasien.cekDaftarPasien(Agam07220_AllObjCtrl.Pasien.pasienEntity().getNama());

    public Agam07220_PasienGUI() {
        Pasien.setSize(720, 600);
        Pasien.setLayout(null);
        Pasien.getContentPane().setBackground(Color.PINK);
        datadiri = new JLabel("Data Pasien");
        datadiri.setFont(new Font("Times New Roman", Font.BOLD, 30));
        datadiri.setBounds(90, 30, 200, 30);
        Pasien.add(datadiri);
        area.setBounds(30, 90, 400, 300);
        Pasien.add(area);
        daftarbtn = new JButton("Daftar");
        daftarbtn.setBounds(500, 200, 100, 30);
        daftarbtn.setBackground(Color.GREEN);
        Pasien.add(daftarbtn);
        back = new JButton("back");
        back.setBounds(30, 500, 100, 30);
        back.setBackground(Color.red);
        Pasien.add(back);
        Pasien.setVisible(true);
        Pasien.setLocationRelativeTo(null);
        Pasien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if (cek == -1) {
            JOptionPane.showMessageDialog(null, "Anda Belum Verifikasi data Anda", "information", JOptionPane.INFORMATION_MESSAGE);
        } else if (cek == -2) {
            JOptionPane.showMessageDialog(null, "Anda Belun Verifikasi data Anda", "information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            area.setText(datapasien());
        }
        
        daftarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Agam07220_AllObjCtrl.Pasien.daftarPasien(Agam07220_AllObjCtrl.Pasien.pasienEntity(), true, null);
                area.setText(datapasien());
            }
        });
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Pasien.dispose();
                Agam07220_GUI men = new Agam07220_GUI();
            }
        });
    }

    public String datapasien() {
        int cek = Agam07220_AllObjCtrl.Pasien.cekDaftarPasien(Agam07220_AllObjCtrl.Pasien.pasienEntity().getNama());
        String cekverif;
        if (Agam07220_AllObjCtrl.Pasien.showDaftarpas(cek).isAccDokter() == false) {
            cekverif = "belum diverifikasi";
        } else {
            cekverif = "sudah diverifikasi";
        }
        String text = "Nama = " + Agam07220_AllObjCtrl.Pasien.showDaftarpas(cek).getPasienEntity().getNama() + "\n" 
                + "No. Telp = " + Agam07220_AllObjCtrl.Pasien.showDaftarpas(cek).getPasienEntity().getNotelp() + "\n"
                + "Penyakit = " + Agam07220_AllObjCtrl.Pasien.showDaftarpas(cek).getPasienEntity().getPenyakit() + "\n" 
                + "Tanggal Lahir = " + new SimpleDateFormat("dd-MM-yyyy").format(Agam07220_AllObjCtrl.Pasien.showDaftarpas(cek).getPasienEntity().getTanggalLahir()) + "\n" 
                + "verifikasi = " + cekverif + "\n" 
                + "Dokter Penangan = " + Agam07220_AllObjCtrl.Pasien.showDaftarpas(cek).getDokterpenangan() + "\n" ;
        return text;
    }
}
