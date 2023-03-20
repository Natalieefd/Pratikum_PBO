
//POSTTEST 3 PBO
//Nama        : Natalie Fuad
//NIM         : 2109106040
//Kelas       : INFORMATIKA A2'21

package PBO.POSTTEST3;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PosttestTiga {
    static InputStreamReader input = new InputStreamReader(System.in);
    static BufferedReader bfr = new BufferedReader(input);
    static ArrayList<DataPeserta> peserta = new ArrayList<DataPeserta>();
    static ArrayList<DataPemenang> pemenang = new ArrayList<DataPemenang>();
    static ArrayList<DataFinalis> finalis = new ArrayList<DataFinalis>();
    static JudulPosttest jdl = new JudulPosttest();
    static int index = 0;
    
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
                jdl.menuAdd();
                jdl.menuData();
                int pilihanAdd = Integer.parseInt(bfr.readLine());
                
                addData(pilihanAdd);
                
            } else if (pilihan == 2){
                jdl.menuRead();
                jdl.menuData();
                int pilihanRead = Integer.parseInt(bfr.readLine());
                
                readData(pilihanRead);
                
            } else if (pilihan == 3){
                jdl.menuUpdate();
                jdl.menuData();
                int pilihanUpdate = Integer.parseInt(bfr.readLine());
                
                readData(pilihanUpdate);
                updateData(pilihanUpdate);
                
            } else if (pilihan == 4){
                jdl.menuDelete();
                jdl.menuData();
                int pilihanDel = Integer.parseInt(bfr.readLine());
                
                readData(pilihanDel);
                deleteData(pilihanDel);
                
            } else if (pilihan == 5){
                jdl.newLine();
                jdl.menuExit();
                break;
                
            } else {
                jdl.newLine();
                jdl.nonMenu();
                jdl.newLine();
            }
        }
    }
    
    static void addData(int pilihan) throws IOException{
        
        //add data peserta
        if (pilihan == 1){
            jdl.newLine();
            jdl.menuAddPeserta();
            
            int nomorPeserta = ++index;
            System.out.print("\t\tInput nama lengkap peserta     : ");
            String nama = bfr.readLine();
            System.out.print("\t\tInput angkatan peserta         : ");
            int angkatan = Integer.parseInt(bfr.readLine());
            System.out.print("\t\tInput kelas peserta            : ");
            int kelas = Integer.parseInt(bfr.readLine());
            System.out.print("\t\tInput kategori lomba           : ");
            String lomba = bfr.readLine();
            System.out.print("\t\tInput asal instansi peserta    : ");
            String asalInstansi = bfr.readLine();
            System.out.println("");

            peserta.add(new DataPeserta(nomorPeserta, nama, angkatan, kelas, lomba, asalInstansi));

            jdl.newLine();
            jdl.berhasil();
            jdl.newLine();

        // add data pemenang
        } else if (pilihan == 2){
            jdl.newLine();
            jdl.menuAddPemenang();
            
            if (peserta.size() == 0){
                System.out.println("\t! MOHON MASUKKAN DATA PESERTA TERLEBIH DAHULU !");
            } else {
                readData(1);
                System.out.print("\t\tPilih nomor data peserta » ");
                int indexPeserta = Integer.parseInt(bfr.readLine());

                if (pemenang.size() > 0){
                    for(int i = 0; i < peserta.size(); i++){
                        if (pemenang.get(i).getNomorPeserta() == indexPeserta){
                            jdl.newLine();
                            System.out.println("\n\t\t! DATA PESERTA SUDAH ADA !");
                            jdl.newLine();
                            break;
                        }
                    }
                } else {
                    int nomorPeserta = peserta.get(indexPeserta-1).getNomorPeserta();
                    String nama = peserta.get(indexPeserta-1).getNama();
                    int angkatan = peserta.get(indexPeserta-1).getAngkatan();
                    int kelas = peserta.get(indexPeserta-1).getKelas();
                    String lomba = peserta.get(indexPeserta-1).getLomba();
                    String asalInstansi = peserta.get(indexPeserta-1).getAsalInstansi();
                    System.out.print("\t\tInput kategori juara       : ");
                    String kategoriJuara = bfr.readLine();
                    System.out.print("\t\tInput peringkat peserta    : ");
                    int peringkat = Integer.parseInt(bfr.readLine());
                    System.out.println("");

                    pemenang.add(new DataPemenang(nomorPeserta, nama, angkatan,
                            kelas, lomba, asalInstansi, kategoriJuara, peringkat));
                    jdl.newLine();
                    jdl.berhasil();
                    jdl.newLine();
                }
            }
        
        //add data finalis
        } else if (pilihan == 3){
            jdl.newLine();
            jdl.menuAddFinalis();
            
            if (peserta.size() == 0){
                System.out.println("\t! MOHON MASUKKAN DATA PESERTA TERLEBIH DAHULU !");
            } else {
                readData(1);
                System.out.print("\t\tMasukkan nomor data peserta » ");
                int indexPeserta = Integer.parseInt(bfr.readLine());
                
                if (finalis.size() > 0){
                    for(int i = 0; i < peserta.size(); i++){
                        if (finalis.get(i).getNomorPeserta() == indexPeserta){
                            jdl.newLine();
                            System.out.println("\n\t\t! DATA PESERTA SUDAH ADA !");
                            jdl.newLine();
                            break;
                        }
                    }
                } else {
                    int nomorPeserta = peserta.get(indexPeserta-1).getNomorPeserta();
                    String nama = peserta.get(indexPeserta-1).getNama();
                    int angkatan = peserta.get(indexPeserta-1).getAngkatan();
                    int kelas = peserta.get(indexPeserta-1).getKelas();
                    String lomba = peserta.get(indexPeserta-1).getLomba();
                    String asalInstansi = peserta.get(indexPeserta-1).getAsalInstansi();
                    System.out.print("\t\tInput babak finalis       : ");
                    String tingkatBabak = bfr.readLine();
                    System.out.println("");

                    finalis.add(new DataFinalis(nomorPeserta, nama, angkatan, 
                            kelas, lomba, asalInstansi, tingkatBabak));
                    jdl.newLine();
                    jdl.berhasil();
                    jdl.newLine();
                }
            }
        }
    }
    
    static void readData(int pilihan) throws IOException {
        
        // read data peserta
        if (pilihan == 1){
            jdl.newLine();
            if (peserta.size() == 0){
                System.out.println("\n\t\t       ! BELUM ADA DATA !");

            } else {
                jdl.menuReadPeserta();
                for (int i=0; i<peserta.size(); i++){
                    System.out.println("\t\t▸Data Peserta Ke " +(i+1));
                    System.out.println("\t\t----------------------------------------------");
                    System.out.println("\t\t Nomor peserta          : " +peserta.get(i).getNomorPeserta());
                    System.out.println("\t\t Nama lengkap peserta   : " +peserta.get(i).getNama());
                    System.out.println("\t\t Angkatan               : " +peserta.get(i).getAngkatan());
                    System.out.println("\t\t Kelas                  : " +peserta.get(i).getKelas());
                    System.out.println("\t\t Lomba yang diikuti     : " +peserta.get(i).getLomba());
                    System.out.println("\t\t Asal Instansi peserta  : " +peserta.get(i).getAsalInstansi());
                    System.out.println("\t\t----------------------------------------------\n");
                }
            }
            jdl.newLine();
            
        // read data pemenang
        } else if(pilihan == 2){
            jdl.newLine();
            if (pemenang.size() == 0){
                System.out.println("\n\t\t       ! BELUM ADA DATA !");

            } else {
                jdl.menuReadPemenang();
                for (int i=0; i<pemenang.size(); i++){
                    System.out.println("\t\t▸Data Peserta Ke " +(i+1));
                    System.out.println("\t\t----------------------------------------------");
                    System.out.println("\t\t Nomor Peserta          : " +pemenang.get(i).getNomorPeserta());
                    System.out.println("\t\t Nama lengkap Peserta   : " +pemenang.get(i).getNama());
                    System.out.println("\t\t Angkatan               : " +pemenang.get(i).getAngkatan());
                    System.out.println("\t\t Kelas                  : " +pemenang.get(i).getKelas());
                    System.out.println("\t\t Lomba yang diikuti     : " +pemenang.get(i).getLomba());
                    System.out.println("\t\t Asal Instansi Peserta  : " +pemenang.get(i).getAsalInstansi());
                    System.out.println("\t\t Kategori Juara         : " +pemenang.get(i).getKategoriJuara());
                    System.out.println("\t\t Peringkat peserta      : " +pemenang.get(i).getPeringkat());
                    System.out.println("\t\t----------------------------------------------\n");
                }
            }
            jdl.newLine();
            
        // read data pemenang
        } else if(pilihan == 3){
            jdl.newLine();
            if (finalis.size() == 0){
                System.out.println("\n\t\t       ! BELUM ADA DATA !");

            } else {
                jdl.menuReadPemenang();
                for (int i=0; i<finalis.size(); i++){
                    System.out.println("\t\t▸Data Peserta Ke " +(i+1));
                    System.out.println("\t\t----------------------------------------------");
                    System.out.println("\t\t Nomor Peserta          : " +finalis.get(i).getNomorPeserta());
                    System.out.println("\t\t Nama lengkap Peserta   : " +finalis.get(i).getNama());
                    System.out.println("\t\t Angkatan               : " +finalis.get(i).getAngkatan());
                    System.out.println("\t\t Kelas                  : " +finalis.get(i).getKelas());
                    System.out.println("\t\t Lomba yang diikuti     : " +finalis.get(i).getLomba());
                    System.out.println("\t\t Asal Instansi Peserta  : " +finalis.get(i).getAsalInstansi());
                    System.out.println("\t\t Babak Finalis          : " +finalis.get(i).getTingkatBabak());
                    System.out.println("\t\t----------------------------------------------\n");
                }
            }
            jdl.newLine();
        }
    }
    
    static void updateData(int pilihan) throws IOException {
        
        //update data peserta
        if (pilihan == 1){
            if (peserta.size() == 0){
                System.out.println("\t! MOHON MASUKKAN DATA PESERTA TERLEBIH DAHULU !");
            } else {
                System.out.print("\t\tInput nomor data yang ingin diubah » ");
                int indexUp = Integer.parseInt(bfr.readLine());
                System.out.println("\t\t----------------------------------------------");

                System.out.print("\n\t\tIngin mengubah data nama?\n\t\t[Yes»1/No»2] » ");
                int ubahNama = Integer.parseInt(bfr.readLine());
                if(ubahNama == 1){
                    System.out.print("\n\t\tInput nama lengkap peserta  : ");
                    String newNama = bfr.readLine();
                    peserta.get(indexUp-1).setNama(newNama);  
                } else if (ubahNama == 2){
                }

                System.out.print("\n\t\tIngin mengubah data angkatan?\n\t\t[Yes»1/No»2] » ");
                int ubahAngkatan = Integer.parseInt(bfr.readLine());

                if(ubahAngkatan == 1){
                    System.out.print("\n\t\tInput angkatan data peserta       : ");
                    int newAngkatan = Integer.parseInt(bfr.readLine());
                    peserta.get(indexUp-1).setAngkatan(newAngkatan);
                } else if (ubahAngkatan == 2){
                }

                System.out.print("\n\t\tIngin mengubah data kelas?\n\t\t[Yes»1/No»2] » ");
                int ubahKelas = Integer.parseInt(bfr.readLine());

                if(ubahKelas == 1){
                    System.out.println("\n\t\t*jika mahasiswa silahkan input semester*");
                    System.out.print("\t\tInput kelas peserta          : ");
                    int newKelas = Integer.parseInt(bfr.readLine());
                    peserta.get(indexUp-1).setKelas(newKelas);
                } else if (ubahKelas == 2){
                }

                System.out.print("\n\t\tIngin mengubah data lomba?\n\t\t[Yes»1/No»2] » ");
                int ubahLomba = Integer.parseInt(bfr.readLine());

                if(ubahLomba == 1){
                    System.out.print("\n\t\tInput lomba yang diikuti     : ");
                    String newLomba = bfr.readLine();
                    peserta.get(indexUp-1).setLomba(newLomba);
                } else if (ubahLomba == 2){
                }

                System.out.print("\n\t\tIngin mengubah data asal instansi?\n\t\t[Yes»1/No»2] » ");
                int ubahInstansi = Integer.parseInt(bfr.readLine());

                if(ubahInstansi == 1){
                    System.out.print("\n\t\tInput asal instansi peserta  : ");
                    String newAsalInstansi = bfr.readLine();
                    peserta.get(indexUp-1).setAsalInstansi(newAsalInstansi);
                } else if (ubahInstansi == 2){
                }

                System.out.println("");
                jdl.newLine();
                jdl.berhasil();
                jdl.newLine();
            }
            
        // update data pemenang
        } else if(pilihan == 2){
            if (peserta.size() == 0){
                System.out.println("\t! MOHON MASUKKAN DATA PESERTA TERLEBIH DAHULU !");
            } else {
                System.out.print("\t\tInput nomor data yang ingin diubah » ");
                int indexUp = Integer.parseInt(bfr.readLine());
                System.out.println("\t\t----------------------------------------------");

                System.out.print("\n\t\tIngin mengubah data kategori juara?\n\t\t[Yes»1/No»2] » ");
                int ubahJuara = Integer.parseInt(bfr.readLine());

                if(ubahJuara == 1){
                    // contoh data yang di-inputkan » "utama/harapan/favorite"
                    System.out.print("\t\tInput kategori juara       : ");
                    String newKategoriJuara = bfr.readLine();
                    pemenang.get(indexUp-1).setKategoriJuara(newKategoriJuara);
                } else if (ubahJuara == 2){
                }

                System.out.print("\n\t\tIngin mengubah data peringkat?\n\t\t[Yes»1/No»2] » ");
                int ubahPeringkat = Integer.parseInt(bfr.readLine());

                if(ubahPeringkat == 1){
                    // contoh data yang di-inputkan » "1, 2, 3, dst."
                    System.out.print("\n\t\tInput peringkat peserta  : ");
                    int newPeringkat = Integer.parseInt(bfr.readLine());
                    pemenang.get(indexUp-1).setPeringkat(newPeringkat);
                } else if (ubahPeringkat == 2){
                }

                System.out.println("");
                jdl.newLine();
                jdl.berhasil();
                jdl.newLine();
            }
            
        // update data finalis
        } else if(pilihan == 3){
            if (peserta.size() == 0){
                System.out.println("\t! MOHON MASUKKAN DATA PESERTA TERLEBIH DAHULU !");
            } else {
                System.out.print("\t\tInput nomor data yang ingin diubah » ");
                int indexUp = Integer.parseInt(bfr.readLine());
                System.out.println("\t\t----------------------------------------------");

                System.out.print("\n\t\tIngin mengubah data babak finalis?\n\t\t[Yes»1/No»2] » ");
                int ubahTingkat = Integer.parseInt(bfr.readLine());

                if(ubahTingkat == 1){
                    // contoh data yang di-inputkan » "semi-final/grand-final"
                    System.out.print("\t\tInput babak finalis       : ");
                    String newTingkatBabak = bfr.readLine();
                    finalis.get(indexUp-1).setTingkatBabak(newTingkatBabak);
                } else if (ubahTingkat == 2){
                }

                System.out.println("");
                jdl.newLine();
                jdl.berhasil();
                jdl.newLine();
            }
        }
        
    }
    
    static void deleteData(int pilihan) throws IOException {
        
        // delete data peserta
        if(pilihan == 1){
            System.out.print("\t\tInput nomor data yang ingin dihapus » ");
            int indexDel = Integer.parseInt(bfr.readLine());
            peserta.remove(indexDel-1);

            jdl.newLine();
            jdl.berhasil();
            jdl.newLine();
            
        // delete data pemenang
        } else if (pilihan == 2){
            System.out.print("\t\tInput nomor data yang ingin dihapus » ");
            int indexDel = Integer.parseInt(bfr.readLine());
            pemenang.remove(indexDel-1);

            jdl.newLine();
            jdl.berhasil();
            jdl.newLine();
            
        // delete data finalis
        } else if (pilihan == 3){
            System.out.print("\t\tInput nomor data yang ingin dihapus » ");
            int indexDel = Integer.parseInt(bfr.readLine());
            finalis.remove(indexDel-1);

            jdl.newLine();
            jdl.berhasil();
            jdl.newLine();
        }
    }
    
}