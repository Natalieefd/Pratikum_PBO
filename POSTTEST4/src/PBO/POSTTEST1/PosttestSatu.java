
//POSTTEST 1 PBO
//Nama        : Natalie Fuad
//NIM         : 2109106040
//Kelas       : INFORMATIKA A2'21

package PBO;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PosttestSatu {
    public static void main(String args[]) throws IOException {
        JudulPosttest jdl = new JudulPosttest();
        jdl.judul();
        
        ArrayList<DataPeserta> peserta = new ArrayList<DataPeserta>();
        
        String nama;
        int angkatan;
        String kategoriLomba;
        String asalInstansi;

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader bfr = new BufferedReader(input);
        
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
                jdl.newLine();
                jdl.menuAdd();
                System.out.print("\t\tInput nama lengkap peserta  : ");
                nama = bfr.readLine();
                System.out.print("\t\tInput angkatan peserta      : ");
                angkatan = Integer.parseInt(bfr.readLine());
                System.out.print("\t\tInput kategori lomba        : ");
                kategoriLomba = bfr.readLine();
                System.out.print("\t\tInput asal instansi peserta : ");
                asalInstansi = bfr.readLine();
                System.out.println("");
                
                DataPeserta dtpst = new DataPeserta(nama, angkatan, kategoriLomba, asalInstansi);
                
                peserta.add(dtpst);
                
                jdl.newLine();
                jdl.berhasil();
                jdl.newLine();
                
            } else if (pilihan == 2){
                jdl.newLine();
                if (peserta.size() == 0){
                    System.out.println("\n\t\t       ! BELUM ADA DATA !");

                } else {
                    jdl.menuRead();
                    for (int i=0; i<peserta.size(); i++){
                        System.out.println("\t\t▸Data Peserta Ke " +(i+1));
                        System.out.println("\t\t----------------------------------------------");
                        System.out.println("\t\t Nama lengkap peserta   : " +peserta.get(i).nama);
                        System.out.println("\t\t Angkatan               : " +peserta.get(i).angkatan);
                        System.out.println("\t\t Kategori lomba         : " +peserta.get(i).kategoriLomba);
                        System.out.println("\t\t Asal Instansi peserta  : " +peserta.get(i).asalInstansi);
                        System.out.println("\t\t----------------------------------------------");
                    }
                }
                jdl.newLine();
                
            } else if (pilihan == 3){
                jdl.newLine();

                if (peserta.size() == 0){
                    System.out.println("\n\t\t       ! BELUM ADA DATA !");

                } else {
                    jdl.menuUpdate();
                    for (int i=0; i<peserta.size(); i++){
                        System.out.println("\t\t▸Data Peserta Ke " +(i+1));
                        System.out.println("\t\t----------------------------------------------");
                        System.out.println("\t\t Nama lengkap peserta   : " +peserta.get(i).nama);
                        System.out.println("\t\t Angkatan               : " +peserta.get(i).angkatan);
                        System.out.println("\t\t Kategori lomba         : " +peserta.get(i).kategoriLomba);
                        System.out.println("\t\t Asal Instansi peserta  : " +peserta.get(i).asalInstansi);
                        System.out.println("\t\t----------------------------------------------\n");
                    }
                }
                
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
                
                peserta.get(indexUp-1).nama = newNama;
                peserta.get(indexUp-1).angkatan = newAngkatan;
                peserta.get(indexUp-1).kategoriLomba = newKategoriLomba;
                peserta.get(indexUp-1).asalInstansi = newAsalInstansi;
                
                jdl.newLine();
                jdl.berhasil();
                jdl.newLine();
                
            } else if (pilihan == 4){
                jdl.newLine();

                if (peserta.size() == 0){
                    System.out.println("\n\t\t       ! BELUM ADA DATA !");
                    jdl.newLine();
                    continue;
                    
                } else {
                    jdl.menuDelete();
                    for (int i=0; i<peserta.size(); i++){
                        System.out.println("\t\t▸Data Peserta Ke " +(i+1));
                        System.out.println("\t\t----------------------------------------------");
                        System.out.println("\t\t Nama lengkap peserta   : " +peserta.get(i).nama);
                        System.out.println("\t\t Angkatan               : " +peserta.get(i).angkatan);
                        System.out.println("\t\t Kategori lomba         : " +peserta.get(i).kategoriLomba);
                        System.out.println("\t\t Asal Instansi peserta  : " +peserta.get(i).asalInstansi);
                        System.out.println("\t\t----------------------------------------------\n");
                    }
                }
                
                System.out.print("\t\tInput nomor data yang ingin dihapus » ");
                int indexDel = Integer.parseInt(bfr.readLine());
                peserta.remove(indexDel-1);
                
                jdl.newLine();
                jdl.berhasil();
                jdl.newLine();
                
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
}