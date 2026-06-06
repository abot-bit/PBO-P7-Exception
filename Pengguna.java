public abstract class Pengguna {
    protected String nama;
    protected String email;

    public Pengguna(String nama, String email) {
        this.nama = nama;
        this.email = email;
    }

    public abstract void tampilkanInfo();
}