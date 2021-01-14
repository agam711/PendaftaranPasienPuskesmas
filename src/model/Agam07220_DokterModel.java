package model;
import entity.Agam07220_DokterEntity;
import java.util.ArrayList;

public class Agam07220_DokterModel implements Agam07220_Model{
    
    public ArrayList<Agam07220_DokterEntity> dokterEntityArrayList;
    
    public Agam07220_DokterModel() {
        dokterEntityArrayList = new ArrayList<Agam07220_DokterEntity>();
    }
    
    public void insert(Agam07220_DokterEntity dokterEntity) {
        dokterEntityArrayList.add(dokterEntity);
    }
    
    @Override
    public int cekData(String nama, String password) {
        int loop = 0;
        for (Agam07220_DokterEntity agam07220_DokterEntity : dokterEntityArrayList) {
            if (agam07220_DokterEntity.getNama().equals(nama) && agam07220_DokterEntity.getPassword().equals(password)) {
                break;
            } else {
                loop++;
            }
        }
        return loop;
    }
    
    public Agam07220_DokterEntity getDokterEntityArrayList(int index){
        return dokterEntityArrayList.get(index);
    }
}
