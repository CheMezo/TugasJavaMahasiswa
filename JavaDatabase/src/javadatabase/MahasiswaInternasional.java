/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadatabase;

/**
 *
 * @author ASUS
 */
public class MahasiswaInternasional extends Mahasiswa{
    
    public MahasiswaInternasional (String nama, String nim, int TahunMasuk, int sks){
        super(nama, nim, TahunMasuk, "Internasional", sks);
    }
    
    @Override
    public long hitungBiaya(){
    return (sks * 300000) + 5000000;
    }   
}
