public class Mahasiswa extends Pengguna {
    protected String nim;
    protected double ipk;

    public Mahasiswa(String nama, String email, String nim, double ipk) {
        super(nama, email);
        this.nim = nim;
        this.ipk = ipk;
    }

    public String getNim() {
        return nim;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Nama      : " + nama);
        System.out.println("Email     : " + email);
        System.out.println("NIM       : " + nim);
        System.out.println("IPK       : " + ipk);
    }
}