/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;

/**
 *
 * @author ASUS
 */
public class MahasiswaReguler extends Mahasiswa {
    public MahasiswaReguler(String nama, String nim, int TahunMasuk, int sks){
        super(nama, nim, TahunMasuk, "Reguler", sks);
    }
    
    @Override
    public long hitungBiaya(){
        return sks * 150000;
    }
    
}
