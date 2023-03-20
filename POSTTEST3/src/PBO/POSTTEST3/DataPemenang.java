
//POSTTEST 3 PBO
//Nama        : Natalie Fuad
//NIM         : 2109106040
//Kelas       : INFORMATIKA A2'21

package PBO.POSTTEST3;

public class DataPemenang extends DataPeserta{
    private String kategoriJuara;
    private int peringkat;
    
    public DataPemenang(int nomorPeserta, String nama, int angkatan, int kelas,
                        String lomba,String asalInstansi, String kategoriJuara, int peringkat){
        super(nomorPeserta, nama, angkatan, kelas, lomba, asalInstansi);
        this.kategoriJuara = kategoriJuara;
        this.peringkat = peringkat;
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
}

class DataFinalis extends DataPeserta{
    private String tingkatBabak;
    
    public DataFinalis(int nomorPeserta, String nama, int angkatan, int kelas,
                       String lomba, String asalInstansi, String tingkatBabak) {
        super(nomorPeserta, nama, angkatan, kelas, lomba, asalInstansi);
        this.tingkatBabak = tingkatBabak;
    }

    public String getTingkatBabak() {
        return tingkatBabak;
    }

    public void setTingkatBabak(String tingkatBabak) {
        this.tingkatBabak = tingkatBabak;
    }

}