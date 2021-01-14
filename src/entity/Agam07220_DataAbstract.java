package entity;

import java.util.Date;

public abstract class Agam07220_DataAbstract {
    protected String nama,notelp,password;
    protected Date TanggalLahir;

    public Agam07220_DataAbstract(String nama, String notelp, String password, Date TanggalLahir) {
        this.nama = nama;
        this.notelp = notelp;
        this.password = password;
        this.TanggalLahir = TanggalLahir;
    }

    public Agam07220_DataAbstract(){
    }

    public abstract String getNama();

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNotelp() {
        return notelp;
    }

    public void setNotelp(String notelp) {
        this.notelp = notelp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getTanggalLahir() {
        return TanggalLahir;
    }

    public void setTanggalLahir(Date TanggalLahir) {
        this.TanggalLahir = TanggalLahir;
    }
}