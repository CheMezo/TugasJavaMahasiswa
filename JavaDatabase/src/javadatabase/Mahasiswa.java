package javadatabase;

public abstract class Mahasiswa {
    private int id;
    private String nama;
    private String nim;
    private int tahunMasuk;
    private String jenis;
    int sks;

    // Constructor dengan ID (untuk data dari database)
    public Mahasiswa(int id, String nama, String nim, int tahunMasuk, String jenis, int sks) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.tahunMasuk = tahunMasuk;
        this.jenis = jenis;
        this.sks = sks;
    }

    // Constructor tanpa ID (untuk data baru yang mau diinsert)
    public Mahasiswa(String nama, String nim, int tahunMasuk, String jenis, int sks) {
        this.nama = nama;
        this.nim = nim;
        this.tahunMasuk = tahunMasuk;
        this.jenis = jenis;
        this.sks = sks;
    }

    public abstract long hitungBiaya();
    
    // Getter dan Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }

    public int getTahunMasuk() { return tahunMasuk; }
    public void setTahunMasuk(int tahunMasuk) { this.tahunMasuk = tahunMasuk; }
    
    public String getjenis() { return jenis; }
    public void setjenis(String jenis) { this.jenis = jenis; }
    
    public int getsks() { return sks; }
    public void setsks(int sks) { this.sks = sks;}
    
}
