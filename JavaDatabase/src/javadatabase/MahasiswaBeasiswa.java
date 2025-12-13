/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;

/**
 *
 * @author ASUS
 */
public class MahasiswaBeasiswa extends Mahasiswa {
    public MahasiswaBeasiswa(String nama, String nim, int TahunMasuk, int sks){
        super (nama, nim, TahunMasuk, "Beasiswa", sks);
        
    }
    @Override
    public long hitungBiaya() {
        return sks * 150000 / 2;
    }
}
