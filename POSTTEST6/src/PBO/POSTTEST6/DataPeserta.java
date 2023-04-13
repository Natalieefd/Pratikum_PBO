
//POSTTEST 6 PBO
//Nama        : Natalie Fuad
//NIM         : 2109106040
//Kelas       : INFORMATIKA A2'21

package PBO.POSTTEST6;

import static PBO.POSTTEST6.PosttestEnam.peserta;
import java.io.IOException;

public class DataPeserta implements display{
    private int nomorPeserta;
    private String nama;
    private int angkatan;
    private int semester;
    private String lomba;
    private String asalInstansi;
    
    public DataPeserta(int nomorPeserta, String nama, int angkatan, int semester, String lomba, String asalInstansi){
        this.nomorPeserta = nomorPeserta;
        this.nama = nama;
        this.angkatan = angkatan;
        this.semester = semester;
        this.lomba = lomba;
        this.asalInstansi = asalInstansi;
    }

    public int getNomorPeserta() {
        return nomorPeserta;
    }

    public void setNomorPeserta(int nomorPeserta) {
        this.nomorPeserta = nomorPeserta;
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

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    public String getLomba() {
        return lomba;
    }

    public void setLomba(String lomba) {
        this.lomba = lomba;
    }

    public String getAsalInstansi() {
        return asalInstansi;
    }

    public void setAsalInstansi(String asalInstansi) {
        this.asalInstansi = asalInstansi;
    }

    @Override
    public void displayData() throws IOException {
        System.out.println("\t\t            DATA TERTAMBAH");
        System.out.println("\t----------------------------------------------------");
        System.out.println("\t Nomor peserta               : " +this.nomorPeserta);
        System.out.println("\t Nama lengkap peserta        : " +this.nama);
        System.out.println("\t Angkatan                    : " +this.angkatan);
        System.out.println("\t Kelas                       : " +this.semester);
        System.out.println("\t Lomba yang diikuti          : " +this.lomba);
        System.out.println("\t Asal Instansi peserta       : " +this.asalInstansi);
        System.out.println("\t----------------------------------------------------\n");
    }
}
