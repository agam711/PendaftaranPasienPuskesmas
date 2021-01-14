/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import entity.Agam07220_DaftarPasienEntity;
/**
 *
 * @author Agam
 */
public class Agam07220_DaftarPasienModel implements Agam07220_Model{
     
    public ArrayList<Agam07220_DaftarPasienEntity> daftarpasienArrayList;
    
     public Agam07220_DaftarPasienModel() {
        daftarpasienArrayList = new ArrayList<Agam07220_DaftarPasienEntity>();
    }
     
     public void insertDataDaftarpasien(Agam07220_DaftarPasienEntity daftarpasien) {
        daftarpasienArrayList.add(daftarpasien);
    }
     
    public ArrayList<Agam07220_DaftarPasienEntity> getDaftarpasienArrayList() {
        return daftarpasienArrayList;
    }
    
    public int size() {
        return daftarpasienArrayList.size();
    }
    
    @Override
    public int cekData(String nama, String password) {
        int loop = 0;
        if (daftarpasienArrayList.size() == 0) {
            loop = -1; // data kosong
        } else {
            for (int i = 0; i < daftarpasienArrayList.size(); i++) {
                if (daftarpasienArrayList.get(i).getPasienEntity().getNama().equals(nama)) {
                    loop = i;
                    break;
                } else {
                    loop = -2;
                }
            }
        }
        return loop;
    }
    
    public Agam07220_DaftarPasienEntity showDaftarpas(int index) {
        return daftarpasienArrayList.get(index);
    }
    
    public void updateIsVerified(int index, Agam07220_DaftarPasienEntity daftarpasienEntity) {
        daftarpasienArrayList.set(index, daftarpasienEntity);
    }
}
