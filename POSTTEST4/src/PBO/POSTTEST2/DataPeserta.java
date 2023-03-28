
//POSTTEST 2 PBO
//Nama        : Natalie Fuad
//NIM         : 2109106040
//Kelas       : INFORMATIKA A2'21

package PBO.POSTTEST2;

public class DataPeserta {
    private String nama;
    private int angkatan;
    private String kategoriLomba;
    private String asalInstansi;
    
    public DataPeserta(String Nama, int Angkatan, String KategoriLomba, String AsalInstansi){
        this.nama = Nama;
        this.angkatan = Angkatan;
        this.kategoriLomba = KategoriLomba;
        this.asalInstansi = AsalInstansi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(int angkatan) {
        this.angkatan = angkatan;
    }

    public String getKategoriLomba() {
        return kategoriLomba;
    }

    public void setKategoriLomba(String kategoriLomba) {
        this.kategoriLomba = kategoriLomba;
    }

    public String getAsalInstansi() {
        return asalInstansi;
    }

    public void setAsalInstansi(String asalInstansi) {
        this.asalInstansi = asalInstansi;
    }
}
