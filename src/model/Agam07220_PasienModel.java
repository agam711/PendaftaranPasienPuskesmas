package model;
import entity.Agam07220_PasienEntity;
import java.util.ArrayList;

public class Agam07220_PasienModel implements Agam07220_Model{
    
    public ArrayList<Agam07220_PasienEntity> pasienEntityArrayList;
    
    public Agam07220_PasienModel(){
        pasienEntityArrayList = new ArrayList<Agam07220_PasienEntity>();
    }
    
    public void insert(Agam07220_PasienEntity pasienEntity){
        pasienEntityArrayList.add(pasienEntity);
    }
    
     public int size() {
        return pasienEntityArrayList.size();
    }
    
    @Override
    public int cekData(String nama, String password) {
        int loop = 0;
        if (pasienEntityArrayList.size() == 0) {
            loop = -1; // data kosong
        } else {
            for (int i = 0; i < pasienEntityArrayList.size(); i++) {
                if (pasienEntityArrayList.get(i).getNama().equals(nama)&&pasienEntityArrayList.get(i).getPassword().equals(password)) {
                    loop = i;
                    break;
                } else {
                    loop = -2;
                }
            }
        }
        return loop;
    }

    public Agam07220_PasienEntity getPasienEntityArrayList(int index){
        return pasienEntityArrayList.get(index);
    }
    
}
