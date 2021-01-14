/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
/**
 *
 * @author Agam
 */
public class Agam07220_DaftarPasienEntity {
    private Agam07220_PasienEntity pasienEntity;
    private boolean accDokter;
    private String dokterpenangan;

    public Agam07220_DaftarPasienEntity(Agam07220_PasienEntity pasienEntity, boolean accDokter, String dokterpenangan) {
        this.pasienEntity = pasienEntity;
        this.accDokter = accDokter;
        this.dokterpenangan = dokterpenangan;
    }

    public Agam07220_PasienEntity getPasienEntity() {
        return pasienEntity;
    }

    public void setPasienEntity(Agam07220_PasienEntity pasienEntity) {
        this.pasienEntity = pasienEntity;
    }

    public boolean isAccDokter() {
        return accDokter;
    }

    public void setAccDokter(boolean accDokter) {
        this.accDokter = accDokter;
    }

    public String getDokterpenangan() {
        return dokterpenangan;
    }

    public void setDokterpenangan(String dokterpenangan) {
        this.dokterpenangan = dokterpenangan;
    }
    
    
}
