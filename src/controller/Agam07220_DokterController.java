/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Agam07220_DaftarPasienEntity;
import entity.Agam07220_DokterEntity;
import entity.Agam07220_PasienEntity;
import java.util.Date;

/**
 *
 * @author Agam
 */
public class Agam07220_DokterController implements Agam07220_ControllerInterface{
    int indexLogin = 0;

    public Agam07220_DokterController() {
    }
    
    public void dataDokter(){
        String spesialis [] = {"Saraf","Mata","THT","Kandungan","Jantung","Tulang","Psikiater"};
        String nama [] = {"Michael","Alan","Odil","Fitria","Sita","Eric","Fernanda"};
        String password [] = {"01","02","03","04","05","06","07"};
        String notelp [] = {"01","02","03","04","05","06","07"};
        String nip [] = {"01","02","03","04","05","06","07"};
        String tglLahir [] = {"04/05/2000","01/12/2000","03/03/2000","23/06/2000","11/07/2000","13/09/2000","22/12/2000"};
        
       for (int i = 0; i < nama.length; i++) {
            Agam07220_AllObjMod.dokMod.insert(new Agam07220_DokterEntity(spesialis[i], nip[i], nama[i], notelp[i], password[i], new Date(tglLahir[i])));
        }
    }
    
    @Override
    public void login(String nama, String password) {
        indexLogin = Agam07220_AllObjMod.dokMod.cekData(nama, password);
    }
    
    public Agam07220_DokterEntity dokterEntity() {
        return Agam07220_AllObjMod.dokMod.getDokterEntityArrayList(indexLogin);
    }
    
    public void updateIsVerified(int index, Agam07220_PasienEntity pasienEntity, String dokterpenangan) {
        Agam07220_AllObjMod.dafPasMod.updateIsVerified(index, new Agam07220_DaftarPasienEntity(pasienEntity, true, dokterpenangan));
    }
    
    
}
