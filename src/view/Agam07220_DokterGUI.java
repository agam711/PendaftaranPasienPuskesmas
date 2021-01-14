package view;
import controller.Agam07220_AllObjMod;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.Agam07220_PasienController;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;

public class Agam07220_DokterGUI {
    private static Agam07220_PasienController pasien = new Agam07220_PasienController();
    JFrame Dokter = new JFrame();
    JTable tabelpasien = new JTable();
    JScrollPane scrolldokter = new JScrollPane(tabelpasien);
    JButton back, verif, update, delete;
    JLabel dokterlabel, userlabel, passlabel;
    JTextField usertext, passtext;
    
    public Agam07220_DokterGUI() {
        Dokter.setSize(650, 500);
        Dokter.setLayout(null);
        Dokter.getContentPane().setBackground(Color.PINK);
        dokterlabel = new JLabel("Dokter");
        dokterlabel.setBounds(250, 30, 200, 30);
        dokterlabel.setFont(new Font("Times New Roman", Font.BOLD, 40));
        Dokter.add(dokterlabel);
        
        scrolldokter.setBounds(30, 100, 570, 200);
        tabelpasien.setModel(pasien.daftarpasien());
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
        
        verif = new JButton("verif");
        verif.setBounds(350, 350, 100, 30);
        verif.setBackground(Color.GREEN);
        Dokter.add(verif);
        
        update = new JButton("Update");
        update.setBounds(500, 350, 100, 30);
        update.setBackground(Color.BLUE);
        Dokter.add(update);
        
        delete = new JButton("Delete");
        delete.setBounds(500, 400, 100, 30);
        delete.setBackground(Color.red);
        Dokter.add(delete);
        
        back = new JButton("back");
        back.setBounds(50, 400, 100, 30);
        back.setBackground(Color.red);
        Dokter.add(back);
        
        Dokter.setLocationRelativeTo(null);
        Dokter.setVisible(true);
        Dokter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Dokter.dispose();
                Agam07220_GUI men = new Agam07220_GUI();
            }
        });
        
        verif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String user = usertext.getText();
                String pass = passtext.getText();
                int index = Agam07220_AllObjMod.dafPasMod.cekData(user, pass);
                Agam07220_AllObjCtrl.Dokter.updateIsVerified(index, Agam07220_AllObjCtrl.Pasien.showDaftarpas(index).getPasienEntity(), Agam07220_AllObjCtrl.Dokter.dokterEntity().getNama());
                tabelpasien.setModel(pasien.daftarpasien());
            }
        });
        
        update.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Dokter.dispose();
                Agam07220_UpdatePasien update = new Agam07220_UpdatePasien();
            }
        });
        
        delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Dokter.dispose();
                Agam07220_DeletePasien delete = new Agam07220_DeletePasien();
            }
        });
        
        tabelpasien.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelpasien.getSelectedRow();
                usertext.setText(Agam07220_AllObjCtrl.Pasien.daftarpasien().getValueAt(i, 0).toString());
                passtext.setText(Agam07220_AllObjCtrl.Pasien.daftarpasien().getValueAt(i, 1).toString());
            }
        });
    }
    
}
