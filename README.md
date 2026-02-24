# Modul 1

## Reflection 1

Penerapan clean code yang saya terapkan adalah meaningful names di mana saya menggunakan nama-nama variable dan function yang jelas dan bermakna. Saya juga tidak menuliskan komentar-komentar yang tidak penting. Layout dan formatting juga saya terapkan.


## Reflection 2

1. Setelah membuat unit test dan berhasil, saya merasa lebih confident dengan kode yang sudah dibuat. Tidak ada jumlah yang pasti dalam membuat unit test, tetapi paling tidak unit test yang dibuat sudah mencakup seluruh function yang ada.
   Cara tahu kalau unit test sudah cukup untuk verify programnya adalah dengan melihat code coverage. Semakin tinggi code coverage, semakin tinggi pula kemungkinan keberhasilan program.
   Walaupun code coverage sudah 100%, bukan berarti kode bebas dari bugs atau error. Bisa saja terdapat logika atau input tak terduga.


2. Menurut saya dengan menambah functional test suite baru, dapat menimbulkan bebarapa potensi masalah clean code. Misalnya prosedur setup yang sama ditulis berulang di beberapa kelas test. Selain itu, jika terjadi perubahan pada setup, maka harus diperbarui di banyak tempat.
   Dengan demikian, saya merasa bahwa hal itu dapat menurunkan kualitas kode.
   Beberapa solusi yang dapat diterapkan adalah dengan membuat base test class yang berisi setup umum dan variabel bersama, lalu mewariskannya ke kelas test lain. Selain itu, menggunakan class helper atau utility untuk fungsi yang sering digunakan.


# Modul 2

1. Saat PMD dijalankan, tidak ada code quality issue yang ditemukan. Namun, sebelumnya saya sudah melakukan refactoring pada ProductController dan ProductServiceImpl, yaitu mengubah mekanisme dependency injection dari field injection menjadi constructor injection.
   Sebelumnya, dependency diinject langsung ke field menggunakan @Autowired. Lalu, untuk meningkatkan code quality, saya ubah menjadi constructor injection agar mengikuti best practice. Dengan constructor injection, bisa meningkatkan testability karena dependency bisa diinject saat testing, meningkatkan keamanan dan konsistensi karena dependency bisa dideklarasikan sebagai final.


2. Iya, implementasi saat ini sudah memenuhi definisi Continuous Integration (CI) dan Continuous Deployment (CD).
   Continuous Integration sudah diterapkan karena setiap push dan pull request secara otomatis memicu workflow GitHub Actions yang menjalankan build, test, dan code analysis (Jacoco, PMD, OSSF Scorecard). Ini memastikan bahwa setiap perubahan code akan langsung divalidasi sebelum diintegrasi ke branch utama (main).
   Continuous Deployment juga sudah diterapkan karena setiap perubahan yang berhasil dimerge ke branch main secara otomatis dideploy ke platform PaaS (Koyeb). Lalu, seluruh prses (testing, code coverage checking, code scanning, deployment) berjalan secara otomatis melalui workflow yang terintegrasi yang merupakan cerminan dari CI/CD.

link: sunny-robby-adv-prog-ac3b0cbf.koyeb.app/