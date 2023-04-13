
//POSTTEST 6 PBO
//Nama        : Natalie Fuad
//NIM         : 2109106040
//Kelas       : INFORMATIKA A2'21

package PBO.POSTTEST6;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PosttestEnam {
    static InputStreamReader input = new InputStreamReader(System.in);
    static BufferedReader bfr = new BufferedReader(input);
    static ArrayList<DataPeserta> peserta = new ArrayList<DataPeserta>();
    static ArrayList<DataPemenang> pemenang = new ArrayList<DataPemenang>();
    static ArrayList<DataFinalis> finalis = new ArrayList<DataFinalis>();
    static stringOutput stro = new stringOutput();
    final static String oneSTAwards = "Uang tunai Rp. 1.500.000\n\t\t\t\t    dan Sertifikat";
    final static String twoNDAwards = "Uang tunai Rp. 850.000\n\t\t\t\t    dan Sertifikat";
    final static String thirdAwards = "Uang tunai Rp. 6500.000\n\t\t\t\t    dan Sertifikat";
    final static String awards = "Sertifikat";
    static int index = 0;
    static String kategoriJuara;
    static String hadiah;
    static String tingkatBabak;
    
    public static void main(String args[]) throws IOException {
        stro.judul();

        while(true){
            stro.menu();
            System.out.println("\t\t⁝ 1 ⁝  Add Data");
            System.out.println("\t\t⁝ 2 ⁝  Read Data");
            System.out.println("\t\t⁝ 3 ⁝  Update Data");
            System.out.println("\t\t⁝ 4 ⁝  Delete Data");
            System.out.println("\t\t⁝ 5 ⁝  Exit");
            System.out.println("\t\t---------------------------------");
            System.out.print("\t\tMasukkan pilihan anda » ");
            try {
                int pilihan = Integer.parseInt(bfr.readLine());

                if(pilihan == 1){
                    stro.headerMenu("ADD");
                    stro.menuData();
                    int pilihanAdd = Integer.parseInt(bfr.readLine());

                    addData(pilihanAdd);

                } else if (pilihan == 2){
                    stro.headerMenu("READ");
                    stro.menuData();
                    int pilihanRead = Integer.parseInt(bfr.readLine());

                    readData(pilihanRead);

                } else if (pilihan == 3){
                    stro.headerMenu("UPDATE");
                    stro.menuData();
                    int pilihanUpdate = Integer.parseInt(bfr.readLine());

                    readData(pilihanUpdate);
                    updateData(pilihanUpdate);

                } else if (pilihan == 4){
                    stro.headerMenu("DELETE");
                    stro.menuData();
                    int pilihanDel = Integer.parseInt(bfr.readLine());

                    readData(pilihanDel);
                    deleteData(pilihanDel);

                } else if (pilihan == 5){
                    stro.newLine();
                    stro.menuExit();
                    break;

                } else {
                    stro.newLine();
                    stro.errorHandling();
                    stro.newLine();
                }
            } catch (Exception e){
                stro.newLine();
                stro.errorHandlingInt();
                stro.newLine();
            }
        }
    }
    
    static void addData(int pilihan) throws IOException{
        
        //add data peserta
        if (pilihan == 1){
            stro.newLine();
                stro.headerMenu(1,"PESERTA");
            
            try {
                int nomorPeserta = ++index;
                System.out.print("\t\tInput nama lengkap peserta     : ");
                String nama = bfr.readLine();
                System.out.print("\t\tInput angkatan peserta         : ");
                int angkatan = Integer.parseInt(bfr.readLine());
                System.out.print("\t\tInput semester peserta         : ");
                int semester = Integer.parseInt(bfr.readLine());
                System.out.print("\t\tInput kategori lomba           : ");
                String lomba = bfr.readLine();
                System.out.print("\t\tInput asal instansi peserta    : ");
                String asalInstansi = bfr.readLine();
                System.out.println("");
                
                DataPeserta dtPst = new DataPeserta(nomorPeserta, nama, angkatan,
                        semester, lomba, asalInstansi);
                peserta.add(dtPst);

                stro.newLine();
                stro.berhasil();
                stro.newLine();
                dtPst.displayData();
                
            } catch (Exception e){
                stro.newLine();
                stro.errorHandlingInt();
                stro.newLine();
            }

        // add data pemenang
        } else if (pilihan == 2){            
            stro.newLine();
            stro.headerMenu(1,"PEMENANG");
            
            if (peserta.size() == 0){
                System.out.println("\t! MOHON MASUKKAN DATA PESERTA TERLEBIH "
                        + "DAHULU !");
            } else {
                readData(1);
                System.out.print("\t\tPilih nomor data peserta » ");

                try {
                    int indexPeserta = Integer.parseInt(bfr.readLine());
                    boolean hasil = checkPemenang(indexPeserta);
                    
                    if (!hasil){
                        int nomorPeserta = peserta.get(indexPeserta-1).getNomorPeserta();
                        String nama = peserta.get(indexPeserta-1).getNama();
                        int angkatan = peserta.get(indexPeserta-1).getAngkatan();
                        int semester = peserta.get(indexPeserta-1).getSemester();
                        String lomba = peserta.get(indexPeserta-1).getLomba();
                        String asalInstansi = peserta.get(indexPeserta-1).getAsalInstansi();
                        System.out.println("\n\t\tPilih kategori juara     :\n\t\t ⁝ 1 ⁝ Utama\n\t\t ⁝ 2 ⁝ Harapan\n\t\t ⁝ 3 ⁝ Favorite");
                        System.out.print("\t\t▸ ");
                        int kategoriPemenang = Integer.parseInt(bfr.readLine());
                        System.out.print("\n\t\tInput peringkat peserta    : ");
                        int peringkat = Integer.parseInt(bfr.readLine());
                        System.out.println("");
                        
                        switch (kategoriPemenang) {
                            case 1 -> {
                                kategoriJuara = "Utama";
                                if (peringkat > 3){
                                    stro.newLine();
                                    System.out.println("\n\t\t\t   …‥‥‥‥‥‥…\n");
                                    System.out.println("\t\tKategori utama hanya terdapat\n\t\t   peringkat 1, 2, dan 3!");
                                    System.out.println("\n\t\t\t   …‥‥‥‥‥‥…\n");
                                    stro.newLine();
                                    stro.gagal();
                                    stro.newLine();
                                    break;
                                    
                                } else {
                                    switch (peringkat) {
                                        case 1:
                                            hadiah = oneSTAwards;
                                            break;
                                        case 2:
                                            hadiah = twoNDAwards;
                                            break;
                                        default:
                                            hadiah = thirdAwards;
                                            break;
                                    }
                                    
                                    DataPemenang dtPmn = new DataPemenang(nomorPeserta, nama, angkatan,
                                            semester, lomba, asalInstansi, kategoriJuara, peringkat, hadiah);
                                    pemenang.add(dtPmn);

                                    stro.newLine();
                                    stro.berhasil();
                                    stro.newLine();
                                    dtPmn.displayData();
                                }
                            }
                                
                            case 2 -> {
                                kategoriJuara = "Harapan";
                                if (peringkat > 3){
                                    stro.newLine();
                                    System.out.println("\n\t\t\t   …‥‥‥‥‥‥…\n");
                                    System.out.println("\t\tKategori harapan hanya terdapat\n\t\t   peringkat 1, 2, dan 3!");
                                    System.out.println("\n\t\t\t   …‥‥‥‥‥‥…\n");
                                    stro.newLine();
                                    stro.gagal();
                                    stro.newLine();
                                    break;
                                    
                                } else {
                                    hadiah = awards;
                                    
                                    DataPemenang dtPmn = new DataPemenang(nomorPeserta, nama, angkatan,
                                            semester, lomba, asalInstansi, kategoriJuara, peringkat, hadiah);
                                    pemenang.add(dtPmn);

                                    stro.newLine();
                                    stro.berhasil();
                                    stro.newLine();
                                    dtPmn.displayData();
                                }
                            }
                                
                            case 3 -> {
                                kategoriJuara = "Favorite";
                                if (peringkat > 3){
                                    stro.newLine();
                                    System.out.println("\n\t\t\t          …‥‥‥‥‥‥…\n");
                                    System.out.println("\t\tKategori favorite hanya terdapat\n\t\t     peringkat 1, 2, dan 3!");
                                    System.out.println("\n\t\t\t          …‥‥‥‥‥‥…\n");
                                    stro.newLine();
                                    stro.gagal();
                                    stro.newLine();
                                    break;
                                    
                                } else {
                                    hadiah = awards;
                                    
                                    DataPemenang dtPmn = new DataPemenang(nomorPeserta, nama, angkatan,
                                            semester, lomba, asalInstansi, kategoriJuara, peringkat, hadiah);
                                    pemenang.add(dtPmn);

                                    stro.newLine();
                                    stro.berhasil();
                                    stro.newLine();
                                    dtPmn.displayData();
                                }
                            }
                                
                            default -> {
                                stro.newLine();
                                stro.errorHandling();
                                stro.newLine();
                            }
                        }
                        
                    } else {
                        stro.newLine();
                        System.out.println("\n\t\t! DATA PEMENANG SUDAH ADA !");
                        stro.newLine();
                    }
                } catch (Exception e){
                    stro.newLine();
                    stro.errorHandlingInt();
                    stro.newLine();
                }
            }
        
        //add data finalis
        } else if (pilihan == 3){
            stro.newLine();
                stro.headerMenu(1,"FINALIS");
            
            if (peserta.size() == 0){
                System.out.println("\t! MOHON MASUKKAN DATA PESERTA TERLEBIH "
                        + "DAHULU !");
            } else {
                readData(1);
                System.out.print("\t\tPilih nomor data peserta » ");

                try {
                    int indexPeserta = Integer.parseInt(bfr.readLine());
                    boolean hasil = checkFinalis(indexPeserta);
                    
                    if (!hasil){
                        int nomorPeserta = peserta.get(indexPeserta-1).getNomorPeserta();
                        String nama = peserta.get(indexPeserta-1).getNama();
                        int angkatan = peserta.get(indexPeserta-1).getAngkatan();
                        int semester = peserta.get(indexPeserta-1).getSemester();
                        String lomba = peserta.get(indexPeserta-1).getLomba();
                        String asalInstansi = peserta.get(indexPeserta-1).getAsalInstansi();
                        System.out.println("\n\t\tPilih babak finalis       :\n\t\t"
                                + " ⁝ 1 ⁝  Grand-Final\n\t\t ⁝ 2 ⁝ Semi-Final");
                        System.out.print("\t\t▸ ");
                        int babak = Integer.parseInt(bfr.readLine());
                        System.out.println("");

                        if (babak == 1){
                            tingkatBabak = "Grand-Final";
                            
                            DataFinalis dtFnl = new DataFinalis(nomorPeserta, nama, angkatan, 
                                    semester, lomba, asalInstansi, tingkatBabak);
                            finalis.add(dtFnl);

                            stro.newLine();
                            stro.berhasil();
                            stro.newLine();
                            dtFnl.displayData();
                        
                        } else if (babak == 2){
                            tingkatBabak = "Semi-Final";
                            
                            DataFinalis dtFnl = new DataFinalis(nomorPeserta, nama, angkatan, 
                                    semester, lomba, asalInstansi, tingkatBabak);
                            finalis.add(dtFnl);

                            stro.newLine();
                            stro.berhasil();
                            stro.newLine();
                            dtFnl.displayData();
                            
                        } else {
                            stro.newLine();
                            stro.errorHandling();
                            stro.newLine();
                        }
                        
                    } else {
                        stro.newLine();
                        System.out.println("\n\t\t! DATA FINALIS SUDAH ADA !");
                        stro.newLine();
                    }
                } catch (Exception e){
                    stro.newLine();
                    stro.errorHandlingInt();
                    stro.newLine();
                }
            }
            
        } else {
            stro.newLine();
            stro.errorHandling();
            stro.newLine();
        }
    }
    
    static final boolean checkPemenang(int indexPeserta){
        for(int i = 0; i < pemenang.size(); i++){
            if (pemenang.get(i).getNomorPeserta() == indexPeserta){
                return true;
            } else{
            }
        }
        return false;
    }
    
    static final boolean checkFinalis(int indexPeserta){
        for(int i = 0; i < finalis.size(); i++){
            if (finalis.get(i).getNomorPeserta() == indexPeserta){
                return true;
            } else{
            }
        }
        return false;
    }
    
    static void readData(int pilihan) throws IOException {
        
        // read data peserta
        if (pilihan == 1){
            stro.newLine();
            if (peserta.size() == 0){
                System.out.println("\n\t\t       ! BELUM ADA DATA !");

            } else {
                stro.headerMenu(2, "PESERTA");
                for (int i=0; i<peserta.size(); i++){
                    System.out.println("\t\t▸Data Peserta Ke " +(i+1));
                    System.out.println("\t\t----------------------------------------------");
                    System.out.println("\t\t Nomor peserta          : " 
                                        +peserta.get(i).getNomorPeserta());
                    System.out.println("\t\t Nama lengkap peserta   : " 
                                        +peserta.get(i).getNama());
                    System.out.println("\t\t Angkatan               : " 
                                        +peserta.get(i).getAngkatan());
                    System.out.println("\t\t Kelas                  : " 
                                        +peserta.get(i).getSemester());
                    System.out.println("\t\t Lomba yang diikuti     : " 
                                        +peserta.get(i).getLomba());
                    System.out.println("\t\t Asal Instansi peserta  : " 
                                        +peserta.get(i).getAsalInstansi());
                    System.out.println("\t\t----------------------------------------------\n");
                }
            }
            stro.newLine();
            
        // read data pemenang
        } else if(pilihan == 2){
            stro.newLine();
            if (pemenang.size() == 0){
                System.out.println("\n\t\t       ! BELUM ADA DATA !");

            } else {
                stro.headerMenu(2, "PEMENANG");
                for (int i=0; i<pemenang.size(); i++){
                    System.out.println("\t\t▸Data Peserta Ke " +(i+1));
                    System.out.println("\t\t----------------------------------------------");
                    System.out.println("\t\t Nomor Peserta          : " 
                                        +pemenang.get(i).getNomorPeserta());
                    System.out.println("\t\t Nama lengkap Peserta   : " 
                                        +pemenang.get(i).getNama());
                    System.out.println("\t\t Angkatan               : " 
                                        +pemenang.get(i).getAngkatan());
                    System.out.println("\t\t Kelas                  : " 
                                        +pemenang.get(i).getSemester());
                    System.out.println("\t\t Lomba yang diikuti     : " 
                                        +pemenang.get(i).getLomba());
                    System.out.println("\t\t Asal Instansi Peserta  : " 
                                        +pemenang.get(i).getAsalInstansi());
                    System.out.println("\t\t Kategori Juara         : " 
                                        +pemenang.get(i).getKategoriJuara());
                    System.out.println("\t\t Peringkat peserta      : " 
                                        +pemenang.get(i).getPeringkat());
                    System.out.println("\t\t Hadiah peserta         : " 
                                        +pemenang.get(i).getHadiah());
                    System.out.println("\t\t----------------------------------------------\n");
                }
            }
            stro.newLine();
            
        // read data finalis
        } else if(pilihan == 3){
            stro.newLine();
            if (finalis.size() == 0){
                System.out.println("\n\t\t       ! BELUM ADA DATA !");

            } else {
                stro.headerMenu(2, "FINALIS");
                for (int i=0; i<finalis.size(); i++){
                    System.out.println("\t\t▸Data Peserta Ke " +(i+1));
                    System.out.println("\t\t----------------------------------------------");
                    System.out.println("\t\t Nomor Peserta          : " 
                                        +finalis.get(i).getNomorPeserta());
                    System.out.println("\t\t Nama lengkap Peserta   : " 
                                        +finalis.get(i).getNama());
                    System.out.println("\t\t Angkatan               : " 
                                        +finalis.get(i).getAngkatan());
                    System.out.println("\t\t Kelas                  : " 
                                        +finalis.get(i).getSemester());
                    System.out.println("\t\t Lomba yang diikuti     : " 
                                        +finalis.get(i).getLomba());
                    System.out.println("\t\t Asal Instansi Peserta  : " 
                                        +finalis.get(i).getAsalInstansi());
                    System.out.println("\t\t Babak Finalis          : " 
                                        +finalis.get(i).getTingkatBabak());
                    System.out.println("\t\t----------------------------------------------\n");
                }
            }
            stro.newLine();
            
        } else {
            stro.newLine();
            stro.errorHandling();
            stro.newLine();
        }
    }
    
    static void updateData(int pilihan) throws IOException {
        
        //update data peserta
        if (pilihan == 1){
            if (peserta.size() == 0){
                System.out.println("\t! MOHON MASUKKAN DATA PESERTA TERLEBIH DAHULU !");
                
            } else {
                System.out.print("\t\tInput nomor data yang ingin diubah » ");
                
                try {
                    int indexUp = Integer.parseInt(bfr.readLine());
                    System.out.println("\t\t----------------------------------------------");

                    System.out.print("\n\t\tIngin mengubah data nama?\n\t\t[Yes»1/No»2] » ");
                    int ubahNama = Integer.parseInt(bfr.readLine());
                    
                    if(ubahNama == 1){
                        System.out.print("\n\t\tInput nama lengkap peserta   : ");
                        String newNama = bfr.readLine();
                        peserta.get(indexUp-1).setNama(newNama);  
                    } else if (ubahNama == 2){
                    }

                    System.out.print("\n\t\tIngin mengubah data angkatan?\n\t\t[Yes»1/No»2] » ");
                    int ubahAngkatan = Integer.parseInt(bfr.readLine());

                    if(ubahAngkatan == 1){
                        System.out.print("\n\t\tInput angkatan data peserta  : ");
                        int newAngkatan = Integer.parseInt(bfr.readLine());
                        peserta.get(indexUp-1).setAngkatan(newAngkatan);
                    } else if (ubahAngkatan == 2){
                    }

                    System.out.print("\n\t\tIngin mengubah data semester peserta?\n\t\t[Yes»1/No»2] » ");
                    int ubahSemester = Integer.parseInt(bfr.readLine());

                    if(ubahSemester == 1){
                        System.out.print("\n\t\tInput kelas peserta          : ");
                        int newKelas = Integer.parseInt(bfr.readLine());
                        peserta.get(indexUp-1).setSemester(newKelas);
                    } else if (ubahSemester == 2){
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
                    stro.newLine();
                    stro.berhasil();
                    stro.newLine();

                } catch (Exception e){
                    stro.newLine();
                    stro.errorHandlingInt();
                    stro.newLine();
                }
            }
            
        // update data pemenang
        } else if(pilihan == 2){
            if (pemenang.size() == 0){
                System.out.println("\t! MOHON MASUKKAN DATA PEMENANG TERLEBIH DAHULU !");
            } else {
                System.out.print("\t\tInput nomor data yang ingin diubah » ");
                try {
                    int indexUp = Integer.parseInt(bfr.readLine());
                    System.out.println("\t\t----------------------------------------------");

                    System.out.print("\n\t\tIngin mengubah data kategori juara?\n\t\t[Yes»1/No»2] » ");
                    int ubahJuara = Integer.parseInt(bfr.readLine());
                    System.out.print("\n\t\tIngin mengubah data peringkat?\n\t\t[Yes»1/No»2] » ");
                    int ubahPeringkat = Integer.parseInt(bfr.readLine());

                    if(ubahJuara == 1 && ubahPeringkat == 1){
                        System.out.println("\n\t\tPilih kategori juara     :\n\t\t ⁝ 1 ⁝ Utama\n\t\t ⁝ 2 ⁝ Harapan\n\t\t ⁝ 3 ⁝ Favorite");
                        System.out.print("\t\t▸ ");
                        int kategoriPemenang = Integer.parseInt(bfr.readLine());
                        System.out.print("\n\t\tInput peringkat peserta  : ");
                        int newPeringkat = Integer.parseInt(bfr.readLine());
                        System.out.println("");
                        
                        switch (kategoriPemenang) {
                            case 1 -> {
                                kategoriJuara = "Utama";
                                if (newPeringkat > 3){
                                    stro.newLine();
                                    System.out.println("\n\t\t\t   …‥‥‥‥‥‥…\n");
                                    System.out.println("\t\tKategori utama hanya terdapat\n\t\t   peringkat 1, 2, dan 3!");
                                    System.out.println("\n\t\t\t   …‥‥‥‥‥‥…\n");
                                    stro.newLine();
                                    break;
                                    
                                } else {
                                    hadiah = switch (newPeringkat) {
                                        case 1 -> oneSTAwards;
                                        case 2 -> twoNDAwards;
                                        default -> thirdAwards;
                                    };
                                    
                                    pemenang.get(indexUp-1).setKategoriJuara(kategoriJuara);
                                    pemenang.get(indexUp-1).setPeringkat(newPeringkat);
                                    pemenang.get(indexUp-1).setHadiah(hadiah);

                                    stro.newLine();
                                    stro.berhasil();
                                    stro.newLine();
                                } break;
                            }
                                
                            case 2 -> {
                                kategoriJuara = "Harapan";
                                if (newPeringkat > 3){
                                    stro.newLine();
                                    System.out.println("\n\t\t\t          …‥‥‥‥‥‥…\n");
                                    System.out.println("\t\tKategori harapan hanya terdapat\n\t\t   peringkat 1, 2, dan 3!");
                                    System.out.println("\n\t\t\t          …‥‥‥‥‥‥…\n");
                                    stro.newLine();
                                    break;
                                    
                                } else {
                                    hadiah = awards;
                                    
                                    pemenang.get(indexUp-1).setKategoriJuara(kategoriJuara);
                                    pemenang.get(indexUp-1).setPeringkat(newPeringkat);
                                    pemenang.get(indexUp-1).setHadiah(hadiah);

                                    stro.newLine();
                                    stro.berhasil();
                                    stro.newLine();
                                } break;
                            }
                                
                            case 3 -> {
                                kategoriJuara = "Favorite";
                                if (newPeringkat > 3){
                                    stro.newLine();
                                    System.out.println("\n\t\t\t          …‥‥‥‥‥‥…\n");
                                    System.out.println("\t\tKategori favorite hanya terdapat\n\t\t     peringkat 1, 2, dan 3!");
                                    System.out.println("\n\t\t\t          …‥‥‥‥‥‥…\n");
                                    stro.newLine();
                                    break;
                                    
                                } else {
                                    hadiah = awards;
                                    
                                    pemenang.get(indexUp-1).setKategoriJuara(kategoriJuara);
                                    pemenang.get(indexUp-1).setPeringkat(newPeringkat);
                                    pemenang.get(indexUp-1).setHadiah(hadiah);

                                    stro.newLine();
                                    stro.berhasil();
                                    stro.newLine();
                                } break;
                            }
                                
                            default -> {
                                stro.newLine();
                                stro.errorHandling();
                                stro.newLine();
                            }
                        }
                        
                    } else if (ubahJuara == 1 && ubahPeringkat == 2){
                        System.out.println("\n\t\tPilih kategori juara     :\n\t\t ⁝ 1 ⁝ Utama\n\t\t ⁝ 2 ⁝ Harapan\n\t\t ⁝ 3 ⁝ Favorite");
                        System.out.print("\t\t▸ ");
                        int kategoriPemenang = Integer.parseInt(bfr.readLine());
                        System.out.println("");
                        
                        int peringkat = pemenang.get(indexUp).getPeringkat();
                        
                        switch (kategoriPemenang) {
                            case 1 :
                                kategoriJuara = "Utama";
                                hadiah = switch (peringkat) {
                                    case 1 -> oneSTAwards;
                                    case 2 -> twoNDAwards;
                                    default -> thirdAwards;
                                };
                                pemenang.get(indexUp-1).setKategoriJuara(kategoriJuara);
                                pemenang.get(indexUp-1).setHadiah(hadiah);

                                stro.newLine();
                                stro.berhasil();
                                stro.newLine();
                                break;
                                
                            case 2 :
                                kategoriJuara = "Harapan";
                                hadiah = awards;

                                pemenang.get(indexUp-1).setKategoriJuara(kategoriJuara);
                                pemenang.get(indexUp-1).setHadiah(hadiah);

                                stro.newLine();
                                stro.berhasil();
                                stro.newLine();
                                break;
                                
                            case 3 :
                                kategoriJuara = "Favorite";
                                hadiah = awards;

                                pemenang.get(indexUp-1).setKategoriJuara(kategoriJuara);
                                pemenang.get(indexUp-1).setHadiah(hadiah);

                                stro.newLine();
                                stro.berhasil();
                                stro.newLine();
                                break;
                                
                            default :
                                stro.newLine();
                                stro.errorHandling();
                                stro.newLine();
                            }
                        
                    } else if (ubahJuara == 2 && ubahPeringkat == 1){
                        System.out.print("\n\t\tInput peringkat peserta  : ");
                        int newPeringkat = Integer.parseInt(bfr.readLine());
                        System.out.println("");
                        
                        String kategori = pemenang.get(indexUp-1).getKategoriJuara();

                        switch (kategori) {
                            case "Utama" -> {
                                if (newPeringkat > 3){
                                    stro.newLine();
                                    System.out.println("\n\t\t\t   …‥‥‥‥‥‥…\n");
                                    System.out.println("\t\tKategori utama hanya terdapat\n\t\t   peringkat 1, 2, dan 3!");
                                    System.out.println("\n\t\t\t   …‥‥‥‥‥‥…\n");
                                    stro.newLine();
                                    stro.gagal();
                                    stro.newLine();
                                    break;
                                    
                                } else {
                                    hadiah = switch (newPeringkat) {
                                        case 1 -> oneSTAwards;
                                        case 2 -> twoNDAwards;
                                        default -> thirdAwards;
                                    };
                                    
                                    pemenang.get(indexUp-1).setPeringkat(newPeringkat);
                                    pemenang.get(indexUp-1).setHadiah(hadiah);

                                    stro.newLine();
                                    stro.berhasil();
                                    stro.newLine();
                                }
                            }
                                
                            case "Harapan" -> {
                                if (newPeringkat > 3){
                                    stro.newLine();
                                    System.out.println("\n\t\t\t          …‥‥‥‥‥‥…\n");
                                    System.out.println("\t\tKategori harapan hanya terdapat\n\t\t   peringkat 1, 2, dan 3!");
                                    System.out.println("\n\t\t\t          …‥‥‥‥‥‥…\n");
                                    stro.newLine();
                                    stro.gagal();
                                    stro.newLine();
                                    break;
                                    
                                } else {
                                    hadiah = awards;
                                    
                                    pemenang.get(indexUp-1).setPeringkat(newPeringkat);
                                    pemenang.get(indexUp-1).setHadiah(hadiah);

                                    stro.newLine();
                                    stro.berhasil();
                                    stro.newLine();
                                }
                            }
                                
                            case "Favorite" -> {
                                if (newPeringkat > 3){
                                    stro.newLine();
                                    System.out.println("\n\t\t\t          …‥‥‥‥‥‥…\n");
                                    System.out.println("\t\tKategori favorite hanya terdapat\n\t\t     peringkat 1, 2, dan 3!");
                                    System.out.println("\n\t\t\t          …‥‥‥‥‥‥…\n");
                                    stro.newLine();
                                    stro.gagal();
                                    stro.newLine();
                                    break;
                                    
                                } else {
                                    hadiah = awards;
                                    
                                    pemenang.get(indexUp-1).setPeringkat(newPeringkat);
                                    pemenang.get(indexUp-1).setHadiah(hadiah);

                                    stro.newLine();
                                    stro.berhasil();
                                    stro.newLine();
                                }
                            }
                                
                            default -> {
                                stro.newLine();
                                stro.errorHandling();
                                stro.newLine();
                            }
                        }
                        
                    } else if (ubahJuara == 2 && ubahPeringkat == 2){
                    } else {
                        stro.newLine();
                        stro.errorHandling();
                        stro.newLine();
                    }
                    
                } catch (Exception e){
                    stro.newLine();
                    stro.errorHandling();
                    stro.newLine();
                }
            }
            
        // update data finalis
        } else if(pilihan == 3){
            if (finalis.size() == 0){
                System.out.println("\t! MOHON MASUKKAN DATA FINALIS TERLEBIH DAHULU !");
            } else {
                System.out.print("\t\tInput nomor data yang ingin diubah » ");
                try {
                    int indexUp = Integer.parseInt(bfr.readLine());
                    System.out.println("\t\t----------------------------------------------");

                    System.out.print("\n\t\tIngin mengubah data babak finalis?\n\t\t[Yes»1/No»2] » ");
                    int ubahTingkat = Integer.parseInt(bfr.readLine());

                    if(ubahTingkat == 1){
                        System.out.println("\n\t\tPilih babak finalis       :\n\t\t ⁝ 1 ⁝  Grand-Final\n\t\t ⁝ 2 ⁝ Semi-Final");
                        System.out.print("\t\t▸ ");
                        int babak = Integer.parseInt(bfr.readLine());
                        System.out.println("");
                        
                        if (babak == 1){
                            tingkatBabak = "Grand-Final";
                            
                            finalis.get(indexUp-1).setTingkatBabak(tingkatBabak);

                            stro.newLine();
                            stro.berhasil();
                            stro.newLine();
                        
                        } else if (babak == 2){
                            tingkatBabak = "Semi-Final";
                            
                            finalis.get(indexUp-1).setTingkatBabak(tingkatBabak);

                            stro.newLine();
                            stro.berhasil();
                            stro.newLine();
                            
                        } else {
                            stro.newLine();
                            stro.errorHandling();
                            stro.newLine();
                        }
                        
                    } else if (ubahTingkat == 2){
                    }
                    
                } catch (Exception e){
                    stro.newLine();
                    stro.errorHandlingInt();
                    stro.newLine();
                }
            }
            
        } else {
            stro.newLine();
            stro.errorHandling();
            stro.newLine();
        }
    }
    
    static void deleteData(int pilihan) throws IOException {
        
        // delete data peserta
        if(pilihan == 1){
            System.out.print("\t\tInput nomor data yang ingin dihapus » ");
            int indexDel = Integer.parseInt(bfr.readLine());
            peserta.remove(indexDel-1);
            
            stro.newLine();
            stro.berhasil();
            stro.newLine();
            
        // delete data pemenang
        } else if (pilihan == 2){
            System.out.print("\t\tInput nomor data yang ingin dihapus » ");
            int indexDel = Integer.parseInt(bfr.readLine());
            pemenang.remove(indexDel-1);

            stro.newLine();
            stro.berhasil();
            stro.newLine();
            
        // delete data finalis
        } else if (pilihan == 3){
            System.out.print("\t\tInput nomor data yang ingin dihapus » ");
            int indexDel = Integer.parseInt(bfr.readLine());
            finalis.remove(indexDel-1);

            stro.newLine();
            stro.berhasil();
            stro.newLine();
            
        } else {
            stro.newLine();
            stro.errorHandling();
            stro.newLine();
        }
    }
}