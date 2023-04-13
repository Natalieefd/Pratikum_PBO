
//POSTTEST 6 PBO
//Nama        : Natalie Fuad
//NIM         : 2109106040
//Kelas       : INFORMATIKA A2'21

package PBO.POSTTEST6;

import java.io.IOException;

public final class DataPemenang extends DataPeserta implements display{
    private String kategoriJuara;
    private int peringkat;
    private String hadiah;
    
    public DataPemenang(int nomorPeserta, String nama, int angkatan, int semester, String lomba,
                        String asalInstansi, String kategoriJuara, int peringkat, String hadiah){
        super(nomorPeserta, nama, angkatan, semester, lomba, asalInstansi);
        this.kategoriJuara = kategoriJuara;
        this.peringkat = peringkat;
        this.hadiah = hadiah;
    }

    public String getKategoriJuara() {
        return kategoriJuara;
    }

    public void setKategoriJuara(String kategoriJuara) {
        this.kategoriJuara = kategoriJuara;
    }

    public int getPeringkat() {
        return peringkat;
    }

    public void setPeringkat(int peringkat) {
        this.peringkat = peringkat;
    }
    
    public String getHadiah() {
        return hadiah;
    }

    public void setHadiah(String hadiah) {
        this.hadiah = hadiah;
    }
    
    @Override
    public void displayData() throws IOException {
        System.out.println("\t\t            DATA TERTAMBAH");
        System.out.println("\t----------------------------------------------------\n");
        System.out.println("\t Kategori juara           : " +this.kategoriJuara);
        System.out.println("\t Peringkat peserta        : " +this.peringkat);
        System.out.println("\t Hadia                    : " +this.hadiah);
        System.out.println("\t----------------------------------------------------\n");
    }
}

final class DataFinalis extends DataPeserta implements display{
    private String tingkatBabak;
    
    public DataFinalis(int nomorPeserta, String nama, int angkatan, int semester,
                       String lomba, String asalInstansi, String tingkatBabak) {
        super(nomorPeserta, nama, angkatan, semester, lomba, asalInstansi);
        this.tingkatBabak = tingkatBabak;
    }

    public String getTingkatBabak() {
        return tingkatBabak;
    }

    public void setTingkatBabak(String tingkatBabak) {
        this.tingkatBabak = tingkatBabak;
    }
    
    @Override
    public void displayData() throws IOException {
        System.out.println("\t\t            DATA TERTAMBAH");
        System.out.println("\t----------------------------------------------------\n");
        System.out.println("\t Babak finalis               : " +this.tingkatBabak);
        System.out.println("\t----------------------------------------------------\n");
    }
}