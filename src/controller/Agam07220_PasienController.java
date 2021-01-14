/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import entity.Agam07220_PasienEntity;
import entity.Agam07220_DaftarPasienEntity;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Agam
 */
public class Agam07220_PasienController implements Agam07220_ControllerInterface{
    int indexLogin = 0;
    public Agam07220_PasienController() {
    }
    
    public Agam07220_PasienEntity getData() {
        return Agam07220_AllObjMod.pasMod.getPasienEntityArrayList(indexLogin);
    }
    
    public void daftarPasien(Agam07220_PasienEntity pasienEntity, boolean isVerified, String dokterpenangan) {
        Agam07220_AllObjMod.dafPasMod.insertDataDaftarpasien(new Agam07220_DaftarPasienEntity(pasienEntity, isVerified, dokterpenangan));
    }
    
    @Override
    public void login(String nama, String password) {
        indexLogin = Agam07220_AllObjMod.pasMod.cekData(nama, password);
    }
    
    public void insert(String penyakit, String nama, String no_telp, String password, Date tglLahir) {
        Agam07220_AllObjMod.pasMod.insert(new Agam07220_PasienEntity(penyakit, nama, no_telp, password, tglLahir));
    }
    
    public Agam07220_PasienEntity pasienEntity() {
        return Agam07220_AllObjMod.pasMod.getPasienEntityArrayList(indexLogin);
    }
    
    public int cekDaftarPasien(String nama) {
        int cek = Agam07220_AllObjMod.dafPasMod.cekData(nama,null);
        return cek;
    }
    
    public Agam07220_DaftarPasienEntity showDaftarpas(int index) {
        return Agam07220_AllObjMod.dafPasMod.showDaftarpas(index);
    }
    
    public Agam07220_PasienEntity setPasienEntity(int index) {
        return Agam07220_AllObjMod.pasMod.getPasienEntityArrayList(index);
    }
    
    public DefaultTableModel daftarpasien(){
        DefaultTableModel dtmdaftarpasien = new DefaultTableModel();
        Object[] kolom ={"Nama","Password","No Telp","Tgl Lahir","Penyakit","Verified","Dokter Penangan"};
        dtmdaftarpasien.setColumnIdentifiers(kolom);
        int size = Agam07220_AllObjMod.dafPasMod.getDaftarpasienArrayList().size();
        String verif = null;
        for (int i=0;i<size;i++){
            if(Agam07220_AllObjMod.dafPasMod.getDaftarpasienArrayList().get(i).isAccDokter()==false){
        verif = "no";
    }else{
        verif = "yes";
            }
    Object [] data = new Object[7];
    data[0] = Agam07220_AllObjMod.dafPasMod.getDaftarpasienArrayList().get(i).getPasienEntity().getNama();
    data[1] = Agam07220_AllObjMod.dafPasMod.getDaftarpasienArrayList().get(i).getPasienEntity().getPassword();
    data[2] = Agam07220_AllObjMod.dafPasMod.getDaftarpasienArrayList().get(i).getPasienEntity().getNotelp();
    data[3] = new SimpleDateFormat("dd-MM-yyyy").format(Agam07220_AllObjMod.dafPasMod.getDaftarpasienArrayList().get(i).getPasienEntity().getTanggalLahir());
    data[4] = Agam07220_AllObjMod.dafPasMod.getDaftarpasienArrayList().get(i).getPasienEntity().getPenyakit();
    data[5] = verif;
    data[6] = Agam07220_AllObjMod.dafPasMod.getDaftarpasienArrayList().get(i).getDokterpenangan();
    dtmdaftarpasien.addRow(data);
        }
    return dtmdaftarpasien;
    }
}
