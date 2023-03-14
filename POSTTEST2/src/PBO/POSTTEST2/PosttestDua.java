
//POSTTEST 2 PBO
//Nama        : Natalie Fuad
//NIM         : 2109106040
//Kelas       : INFORMATIKA A2'21

package PBO.POSTTEST2;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PosttestDua {
    static InputStreamReader input = new InputStreamReader(System.in);
    static BufferedReader bfr = new BufferedReader(input);
    static ArrayList<PBO.POSTTEST2.DataPeserta> peserta = new ArrayList<PBO.POSTTEST2.DataPeserta>();
    static PBO.POSTTEST2.JudulPosttest jdl = new PBO.POSTTEST2.JudulPosttest();
    
    public static void main(String args[]) throws IOException {
        jdl.judul();

        while(true){
            jdl.menu();
            System.out.println("\t\t⁝ 1 ⁝  Add Data");
            System.out.println("\t\t⁝ 2 ⁝  Read Data");
            System.out.println("\t\t⁝ 3 ⁝  Update Data");
            System.out.println("\t\t⁝ 4 ⁝  Delete Data");
            System.out.println("\t\t⁝ 5 ⁝  Exit");
            System.out.println("\t\t---------------------------------");
            System.out.print("\t\tMasukkan pilihan anda » ");
            int pilihan = Integer.parseInt(bfr.readLine());
            
            if(pilihan == 1){
                addData();
            } else if (pilihan == 2){
                readData();
            } else if (pilihan == 3){
                readData();
                updateData();
            } else if (pilihan == 4){
                readData();
                deleteData();
            } else if (pilihan == 5){
                jdl.newLine();
                jdl.menuExit();
                break;
                
            } else {
                jdl.newLine();
                System.out.println("\n\t\t\t      …‥‥‥‥‥‥…\n");
                System.out.println("\t\t    ! PILIHAN TIDAK TERSEDIA !");
                System.out.println("\n\t\t\t      …‥‥‥‥‥‥…");
                jdl.newLine();
            }
        }
    }
    
    static void addData() throws IOException{
        jdl.newLine();
        jdl.menuAdd();
        System.out.print("\t\tInput nama lengkap peserta  : ");
        String nama = bfr.readLine();
        System.out.print("\t\tInput angkatan peserta      : ");
        int angkatan = Integer.parseInt(bfr.readLine());
        System.out.print("\t\tInput kategori lomba        : ");
        String kategoriLomba = bfr.readLine();
        System.out.print("\t\tInput asal instansi peserta : ");
        String asalInstansi = bfr.readLine();
        System.out.println("");

        PBO.POSTTEST2.DataPeserta dtpst = new PBO.POSTTEST2.DataPeserta(nama, angkatan, kategoriLomba, asalInstansi);

        peserta.add(dtpst);

        jdl.newLine();
        jdl.berhasil();
        jdl.newLine();
    }
    
    static void readData() throws IOException {
        jdl.newLine();
        if (peserta.size() == 0){
            System.out.println("\n\t\t       ! BELUM ADA DATA !");

        } else {
            jdl.menuRead();
            for (int i=0; i<peserta.size(); i++){
                System.out.println("\t\t▸Data Peserta Ke " +(i+1));
                System.out.println("\t\t----------------------------------------------");
                System.out.println("\t\t Nama lengkap peserta   : " +peserta.get(i).getNama());
                System.out.println("\t\t Angkatan               : " +peserta.get(i).getAngkatan());
                System.out.println("\t\t Kategori lomba         : " +peserta.get(i).getKategoriLomba());
                System.out.println("\t\t Asal Instansi peserta  : " +peserta.get(i).getAsalInstansi());
                System.out.println("\t\t----------------------------------------------\n");
            }
        }
        jdl.newLine();
    }
    
    static void updateData() throws IOException {
        System.out.print("\t\tInput nomor data yang ingin diubah » ");
        int indexUp = Integer.parseInt(bfr.readLine());
        System.out.println("\t\t----------------------------------------------");

        System.out.print("\n\t\tInput nama lengkap peserta  : ");
        String newNama = bfr.readLine();
        System.out.print("\t\tInput angkatan peserta      : ");
        int newAngkatan = Integer.parseInt(bfr.readLine());
        System.out.print("\t\tInput kategori lomba        : ");
        String newKategoriLomba = bfr.readLine();
        System.out.print("\t\tInput asal instansi peserta : ");
        String newAsalInstansi = bfr.readLine();
        System.out.println("");

        peserta.get(indexUp-1).setNama(newNama);
        peserta.get(indexUp-1).setAngkatan(newAngkatan);
        peserta.get(indexUp-1).setKategoriLomba(newKategoriLomba);
        peserta.get(indexUp-1).setAsalInstansi(newAsalInstansi);

        jdl.newLine();
        jdl.berhasil();
        jdl.newLine();
    }
    
    static void deleteData() throws IOException {
        System.out.print("\t\tInput nomor data yang ingin dihapus » ");
        int indexDel = Integer.parseInt(bfr.readLine());
        peserta.remove(indexDel-1);

        jdl.newLine();
        jdl.berhasil();
        jdl.newLine();
    }
    
}