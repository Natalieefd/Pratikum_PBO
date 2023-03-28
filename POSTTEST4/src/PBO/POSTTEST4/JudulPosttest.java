
//POSTTEST 4 PBO
//Nama        : Natalie Fuad
//NIM         : 2109106040
//Kelas       : INFORMATIKA A2'21

package PBO.POSTTEST4;

class JudulPosttest {
    void judul(){
        System.out.println("\t ⁛⁘ = = = = = = = = = = = = = = = = = = = = = ⁘⁛");
        System.out.println("\t\t SISTEM PENDATAAN PESERTA LOMBA");
        System.out.println("\t ⁛⁘ = = = = = = = = = = = = = = = = = = = = = ⁘⁛");
    }
    
    void menu(){
        System.out.println("\n\t\t================================");
        System.out.println("\t\t              MENU");
        System.out.println("\t\t================================");
    }
    
    void menuData(){
        System.out.println("\t\t⁝ 1 ⁝  Data Peserta");
        System.out.println("\t\t⁝ 2 ⁝  Data Pemenang");
        System.out.println("\t\t⁝ 3 ⁝  Data Finalis");
        System.out.println("\t\t---------------------------------");
        System.out.print("\t\tMasukkan pilihan anda » ");    
    }
    
    //overloading
    void headerMenu(String kategori){
        System.out.println("\n\t\t================================");
        System.out.println("\t\t         MENU "+kategori+" DATA");
        System.out.println("\t\t================================");
    }
    
    //overloading
    void headerMenu(int pilihan, String kategori){
        
        if (pilihan == 1){
            System.out.println("\n\t\t================================");
            System.out.println("\t\t         ADD DATA " +kategori);
            System.out.println("\t\t================================\n");
            
        } else if (pilihan == 2){
            System.out.println("\n\t\t================================");
            System.out.println("\t\t       READ DATA " +kategori);
            System.out.println("\t\t================================\n");
            
        } else if (pilihan == 3){
            System.out.println("\n\t\t================================");
            System.out.println("\t\t      UPDATE DATA " +kategori);
            System.out.println("\t\t================================\n");
        
        } else if (pilihan == 4){
            System.out.println("\n\t\t================================");
            System.out.println("\t\t      DELETE DATA " +kategori);
            System.out.println("\t\t================================\n");
        }
    }
    
    void menuExit(){
        System.out.println("\n\t\t           ⁛⁘ …‥‥‥‥‥‥… ⁘⁛\n");
        System.out.println("\t\t\t     ! BYE BYE !");
        System.out.println("\n\t\t\t      (✿◡‿◡)");
        System.out.println("\t\t           ⁛⁘ …‥‥‥‥‥‥… ⁘⁛\n");
    }
    
    void berhasil(){
        System.out.println("\n\t\t================================");
        System.out.println("\t\t       ! PROSES BERHASIL !");
        System.out.println("\t\t================================");
    }
    
    void errorHandling(){
        System.out.println("\n\t\t\t      …‥‥‥‥‥‥…\n");
        System.out.println("\t\t    ! PILIHAN TIDAK TERSEDIA !");
        System.out.println("\n\t\t\t      …‥‥‥‥‥‥…");
    }
    
    void newLine(){
        System.out.println("\n--------------------------------------------------------------------");
    }
}

class exception extends JudulPosttest{
    @Override
    void errorHandling(){
        System.out.println("\n\t\t\t      …‥‥‥‥‥‥…\n");
        System.out.println("\t\t     ! INPUT HARUS ANGKA !");
        System.out.println("\n\t\t\t      …‥‥‥‥‥‥…");
    }
}