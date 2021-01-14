package entity;

import java.util.Date;

public class Agam07220_DokterEntity extends Agam07220_DataAbstract {
private String spesialis;
private String nip;

    public Agam07220_DokterEntity(String spesialis, String nip, String nama, String notelp, String password, Date TanggalLahir) {
        super(nama, notelp, password, TanggalLahir);
        this.spesialis = spesialis;
        this.nip = nip;
    }

    @Override
    
    public String getNama() {
        return nama;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getSpesialis() {
        return spesialis;
    }

    public void setSpesialis(String spesialis) {
        this.spesialis = spesialis;
    }
    
}
