# Sistem Pendaftaran KKN Semester Ganjil

Proyek ini adalah aplikasi konsol berbasis Java sederhana untuk Sistem Pendaftaran Kuliah Kerja Nyata (KKN) Semester Ganjil. Aplikasi ini dibuat untuk mendemonstrasikan berbagai konsep fundamental dalam Pemrograman Berorientasi Objek (PBO/OOP) serta Penanganan Eksepsi dan I/O menggunakan Java.

**Informasi Pembuat:**

- **Nama** : Moehammad Al-Byierr' Walidhain Daulay
- **NIM** : 251110047
- **Kelas**: 12D1
- **Topik**: P7 - Penanganan Eksepsi dan I/O

## Fitur Utama

1. **Pendaftaran Mahasiswa Reguler**: Mendaftarkan mahasiswa dengan informasi dasar seperti nama, email, NIM, dan IPK.
2. **Pendaftaran Mahasiswa Beasiswa**: Mendaftarkan mahasiswa yang mendapatkan beasiswa, lengkap dengan jenis beasiswanya (Subclass khusus).
3. **Tampilkan Semua Mahasiswa**: Menampilkan daftar seluruh mahasiswa yang telah terdaftar dalam sistem.
4. **Validasi IPK**: Memastikan input IPK berada dalam rentang yang valid (0.0 - 4.0).
5. **Penanganan NIM Duplikat**: Menggunakan exception kustom (`NIMSudahAdaException`) untuk mencegah pendaftaran mahasiswa dengan NIM yang sama.

## Konsep PBO yang Diimplementasikan

- **Abstraction**: Menggunakan kelas abstrak `Pengguna`.
- **Inheritance**: Kelas `Mahasiswa` mewarisi `Pengguna`, dan kelas `MahasiswaBeasiswa` mewarisi `Mahasiswa`.
- **Polymorphism**:
  - Overriding metode `tampilkanInfo()`.
  - Penyimpanan objek anak ke dalam referensi induk pada koleksi (List dari objek `Pengguna`).
- **Encapsulation**: Penggunaan akses modifier yang tepat (seperti `protected` dan `private`) serta metode getter.
- **Exception Handling**: Pembuatan Custom Exception (`NIMSudahAdaException`) dan penanganan error bawaan Java (`IllegalArgumentException`, `NumberFormatException`).

## Highlight Modul: Penanganan Eksepsi dan I/O

Modul ini memiliki fokus utama pada penerapan **Exception Handling** dan **I/O** (menggunakan `BufferedReader`) untuk membuat program lebih tangguh (_robust_) dalam menangani kesalahan _runtime_, terutama yang berkaitan dengan validasi data masukan pengguna. Terdapat dua bentuk penerapan eksepsi dalam sistem ini:

### 1. Custom Exception (`NIMSudahAdaException`)

Untuk aturan bisnis yang spesifik, yaitu mencegah duplikasi NIM dibuatlah kelas eksepsi khusus bernama `NIMSudahAdaException`. Kelas ini mewarisi kelas `Exception` bawaan Java, menjadikannya sebuah _Checked Exception_.
Ketika sistem mendeteksi NIM yang sudah ada dalam daftar, program akan melempar (`throw`) eksepsi ini. Eksepsi kemudian ditangkap dengan blok `try catch` sehingga aplikasi dapat memberikan pesan peringatan tanpa harus berhenti/crash.

### 2. Built-in Exception Java

Sistem ini juga menangani beberapa eksepsi bawaan Java (_Unchecked Exception_ turunan dari `RuntimeException`):

- **`IllegalArgumentException`**: Sengaja dilemparkan ketika argumen atau nilai yang diberikan tidak sesuai dengan aturan (misalnya, input IPK di bawah 0.0 atau di atas 4.0).
- **`NumberFormatException`**: Ditangani saat pengguna memasukkan format data yang salah, seperti memasukkan karakter huruf pada field yang seharusnya angka (contoh: saat memasukkan IPK atau memilih menu numerik).

## Struktur Kelas

- `Pengguna.java`: Kelas abstrak yang merepresentasikan pengguna sistem secara umum (menyimpan atribut nama dan email).
- `Mahasiswa.java`: Kelas turunan dari `Pengguna` yang merepresentasikan mahasiswa reguler (menambahkan atribut NIM dan IPK).
- `MahasiswaBeasiswa.java`: Kelas turunan dari `Mahasiswa` yang merepresentasikan mahasiswa beasiswa (menambahkan atribut jenis beasiswa).
- `SistemPendaftaran.java`: Kelas utama (Main Class) yang berisi logika program dan antarmuka interaktif berbasis konsol.
- `NIMSudahAdaException.java`: Exception kustom untuk menangani kasus ketika NIM yang sama dimasukkan dua kali.

## Cara Menjalankan Program

Pastikan Anda telah menginstal Java Development Kit (JDK) di komputer Anda.

1. Buka terminal atau Command Prompt.
2. Arahkan ke direktori tempat file-file Java ini disimpan.
3. Lakukan kompilasi program dengan menjalankan perintah:
   ```bash
   javac *.java
   ```
4. Jalankan program yang telah dikompilasi dengan perintah:
   ```bash
   java SistemPendaftaran
   ```
