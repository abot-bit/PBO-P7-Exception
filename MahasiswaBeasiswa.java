public class MahasiswaBeasiswa extends Mahasiswa {
    private String jenisBeasiswa;

    public MahasiswaBeasiswa(String nama, String email, String nim, double ipk, String jenisBeasiswa) {
        super(nama, email, nim, ipk);
        this.jenisBeasiswa = jenisBeasiswa;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Beasiswa  : " + jenisBeasiswa);
    }
}