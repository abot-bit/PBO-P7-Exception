import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SistemPendaftaran {
    private static ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean berjalan = true;

        System.out.println("Nama : Moehammad Al-Byierr' Walidhain Daulay");
        System.out.println("NIM  : 251110047");
        System.out.println("Kelas: 12D1");
        System.out.println("P7 - Penanganan Eksepsi dan I/O");

        while (berjalan) {
            System.out.println("\n=== Sistem Pendaftaran KKN Semester Ganjil ===");
            System.out.println("1. Daftarkan Mahasiswa Reguler");
            System.out.println("2. Daftarkan Mahasiswa Beasiswa");
            System.out.println("3. Tampilkan Semua Data");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");

            try {
                String pilihan = reader.readLine();

                switch (pilihan) {
                    case "1":
                        daftarkanData(reader, false);
                        break;
                    case "2":
                        daftarkanData(reader, true);
                        break;
                    case "3":
                        tampilkanSemua();
                        break;
                    case "4":
                        berjalan = false;
                        System.out.println("Keluar dari sistem. Terima kasih!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid, silakan coba lagi.");
                }
            } catch (IOException e) {
                /*
                Method printStackTrace() digunakan untuk melacak dan menampilkan urutan eksekusi
                yang menyebabkan terjadinya error/eksepsi ke layar.
                Ini sangat berguna untuk proses debugging karena kita bisa mengetahui
                dibaris mana code error (IOException) terjadi.
                */
                e.printStackTrace();
            }
        }
    }
    private static void daftarkanData(BufferedReader reader, boolean isBeasiswa) {
        try {
            System.out.print("Masukkan Nama   : ");
            String nama = reader.readLine();
            System.out.print("Masukkan Email  : ");
            String email = reader.readLine();
            System.out.print("Masukkan NIM    : ");
            String nim = reader.readLine();

            for (Mahasiswa mhs : daftarMahasiswa) {
                if (mhs.getNim().equals(nim)) {
                    throw new NIMSudahAdaException("Error: NIM " + nim + " sudah terdaftar di Database!");
                }
            }

            System.out.print("Masukkan IPK    : ");
            double ipk = Double.parseDouble(reader.readLine()); 

            if (ipk < 0.0 || ipk > 4.0) {
                throw new IllegalArgumentException("Error: IPK tidak valid! Harus berada di rentang nilai 0.0 hingga 4.0.");
            }
            if (isBeasiswa) {
                System.out.print("Jenis Beasiswa  : ");
                String jenisBeasiswa = reader.readLine();
                MahasiswaBeasiswa mb = new MahasiswaBeasiswa(nama, email, nim, ipk, jenisBeasiswa);
                daftarMahasiswa.add(mb);
                System.out.println("\nMahasiswa Beasiswa berhasil didaftarkan.");
            } else {
                Mahasiswa mhs = new Mahasiswa(nama, email, nim, ipk);
                daftarMahasiswa.add(mhs);
                System.out.println("\nMahasiswa berhasil didaftarkan.");
            }

        } catch (NIMSudahAdaException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: IPK harus berupa angka, bukan huruf!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca input.");
        }
    }

    private static void tampilkanSemua() {
        if (daftarMahasiswa.isEmpty()) {
            System.out.println("\nBelum ada data mahasiswa yang terdaftar.");
            return;
        }

        System.out.println("\n--- Data Mahasiswa Terdaftar dalam KKN Semester Ganjil---");
        for (Mahasiswa mhs : daftarMahasiswa) {
            mhs.tampilkanInfo();
            System.out.println("-------------------------------------------------------");
        }
    }
}