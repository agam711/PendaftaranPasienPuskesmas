package entity;
import java.util.Date;
/**
 *
 * @author Agam
 */
public class Agam07220_PasienEntity extends Agam07220_DataAbstract{
    private String penyakit;

    public Agam07220_PasienEntity(String penyakit, String nama, String notelp, String password, Date TanggalLahir) {
        super(nama, notelp, password, TanggalLahir);
        this.penyakit = penyakit;
    }
    
    public String getPenyakit() {
        return penyakit;
    }

    public String getNama() {
        return nama;
    }
    
    public void setPenyakit(String penyakit) {
        this.penyakit = penyakit;
    }
    
}
