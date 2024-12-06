# ReTech  
**E-Commerce Application Using Java**

## 1. Tambahkan Library JDBC ke Eclipse  
Agar aplikasi dapat terhubung ke database MySQL, tambahkan library **MySQL JDBC Driver** ke proyek.

### Langkah-langkah:  
1. **Download MySQL JDBC Driver:**  
   Unduh file `mysql-connector-java-X.X.X.jar` dari [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/). Pilih **Platform Independent**, lalu unduh file ZIP-nya.

2. **Ekstrak File ZIP:**  
   Ekstrak file ZIP ke lokasi yang mudah diakses, misalnya:  
   `C:\Program Files\Java\mysql-connector-j`.

3. **Temukan File JAR:**  
   Di dalam folder hasil ekstraksi, cari file `mysql-connector-java-X.X.X.jar`.

4. **Tambahkan ke Eclipse:**  
   - Buka proyek Java di Eclipse.  
   - Klik kanan pada proyek > **Build Path** > **Configure Build Path**.  
   - Klik tab **Libraries** > **Add External JARs**.  
   - Arahkan ke lokasi file `mysql-connector-java-X.X.X.jar`, pilih, lalu klik **Open**.  
   - Klik **Apply and Close**.  

---

## 2. Pastikan JDK yang Digunakan adalah Versi Lengkap (Bukan JRE)  
Pastikan Anda menggunakan **JDK** (Java Development Kit), bukan **JRE** (Java Runtime Environment), karena JRE tidak memiliki pustaka lengkap untuk pengembangan aplikasi. Jadi install terlebih dahulu jika belum ada. https://www.oracle.com/id/java/technologies/javase/jdk11-archive-downloads.html

### Langkah-langkah:  
1. Klik kanan pada proyek Anda di Eclipse > **Properties**.  
2. Pilih **Java Build Path** > **Libraries**.  
3. Periksa apakah **JRE System Library** menunjuk ke JDK.  
   - Jika menunjuk ke **JRE**, lakukan langkah berikut:  
     - Klik **Edit...**.  
     - Pilih **Installed JREs...**.  
     - Klik **Add...** > **Standard VM**.  
     - Arahkan ke folder instalasi JDK (contoh: `C:\Program Files\Java\jdk-11`).  
     - Set **JDK 11** sebagai default.  
   - Klik **Apply and Close**.  

---

## 3. Pastikan Library JDBC Sudah Tepat  
Periksa kembali bahwa library **MySQL Connector** sudah benar diatur di **classpath**.

### Langkah-langkah:  
1. Klik kanan pada proyek Anda di Eclipse > **Build Path** > **Configure Build Path**.  
2. Pada tab **Libraries**, pastikan file JAR `mysql-connector-java-X.X.X.jar` telah ditambahkan.  
   - Jika belum ada, klik **Add External JARs...**, pilih file JAR, lalu tambahkan ke **Classpath**.  
3. Klik **Apply and Close**.  

---

## 4. Menjalankan Aplikasi  
### Langkah-langkah:  
1. Jalankan file `Main.java` sebagai aplikasi Java di Eclipse.  
2. Pastikan **XAMPP** telah dinyalakan dan database yang diperlukan sudah diimpor.  
3. Nikmati interaksi dengan fitur **E-Commerce** yang terhubung dengan database MySQL.  
