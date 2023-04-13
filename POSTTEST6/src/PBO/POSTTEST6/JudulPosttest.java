
//POSTTEST 6 PBO
//Nama        : Natalie Fuad
//NIM         : 2109106040
//Kelas       : INFORMATIKA A2'21

package PBO.POSTTEST6;

public abstract class JudulPosttest {
    protected abstract void errorHandlingInt();
    protected abstract void judul();
    protected abstract void menu();
    protected abstract void menuData();
    
    //overloading
    protected abstract void headerMenu(String kategori);
    
    //overloading
    protected abstract void headerMenu(int pilihan, String kategori);
    protected abstract void menuExit();
    protected abstract void berhasil();
    protected abstract void gagal();
    protected abstract void errorHandling();
    protected abstract void newLine();
}

class stringOutput extends JudulPosttest{
    @Override
    protected void errorHandlingInt(){
        System.out.println("\n\t\t\t      …‥‥‥‥‥‥…\n");
        System.out.println("\t\t       ! INPUT HARUS ANGKA !");
        System.out.println("\n\t\t\t      …‥‥‥‥‥‥…");
    }

    @Override
    protected final void judul() {
        System.out.println("\t ⁛⁘ = = = = = = = = = = = = = = = = = = = = = ⁘⁛");
        System.out.println("\t\t SISTEM PENDATAAN PESERTA LOMBA");
        System.out.println("\t ⁛⁘ = = = = = = = = = = = = = = = = = = = = = ⁘⁛");
    }

    @Override
    protected void menu() {
        System.out.println("\n\t\t================================");
        System.out.println("\t\t              MENU");
        System.out.println("\t\t================================");
    }

    @Override
    protected void menuData() {
        System.out.println("\t\t⁝ 1 ⁝  Data Peserta");
        System.out.println("\t\t⁝ 2 ⁝  Data Pemenang");
        System.out.println("\t\t⁝ 3 ⁝  Data Finalis");
        System.out.println("\t\t---------------------------------");
        System.out.print("\t\tMasukkan pilihan anda » ");    
    }

    @Override
    protected void headerMenu(String kategori) {
        System.out.println("\n\t\t================================");
        System.out.println("\t\t         MENU "+kategori+" DATA");
        System.out.println("\t\t================================");
    }

    @Override
    protected void headerMenu(int pilihan, String kategori) {
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

    @Override
    protected final void menuExit() {
        System.out.println("\n\t\t           ⁛⁘ …‥‥‥‥‥‥… ⁘⁛\n");
        System.out.println("\t\t\t     ! BYE BYE !");
        System.out.println("\n\t\t\t      (✿◡‿◡)");
        System.out.println("\t\t           ⁛⁘ …‥‥‥‥‥‥… ⁘⁛\n");
    }

    @Override
    protected final void berhasil() {
        System.out.println("\n\t\t================================");
        System.out.println("\t\t       ! PROSES BERHASIL !");
        System.out.println("\t\t================================");
    }
    
    @Override
    protected final void gagal() {
        System.out.println("\n\t\t================================");
        System.out.println("\t\t        ! PROSES GAGAL !");
        System.out.println("\t\t================================");
    }

    @Override
    protected final void errorHandling(){
        System.out.println("\n\t\t\t      …‥‥‥‥‥‥…\n");
        System.out.println("\t\t    ! PILIHAN TIDAK TERSEDIA !");
        System.out.println("\n\t\t\t      …‥‥‥‥‥‥…");
    }
    
    @Override
    protected void newLine() {
        System.out.println("\n--------------------------------------------------------------------");
    }
}