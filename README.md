# latihan-git-1224002

Nama: Hafizh Zidan Handrian
NIM: 1224002
Kelas: Sistem Informasi — STMIK Bandung
Mata Kuliah: Pengujian Perangkat Lunak — Pertemuan 4 (Unit Testing dengan GitHub Actions)

Repository untuk Latihan Terstruktur Pertemuan 4:
- Praktik Git Commands (Soal 2)
- Unit Test JUnit: Validasi Pendaftaran (Soal 3), StudentGrade (Soal 4), BankAccount (Soal 8/Bonus)
- Workflow GitHub Actions "Java Unit Test" + JaCoCo coverage (Soal 6 & 8)

## Struktur Project

```
.
├── README.md
├── test.txt
├── pom.xml
├── .gitignore
├── .github/workflows/java-test.yml
└── src/
    ├── main/java/com/stmik/
    │   ├── PendaftaranValidator.java
    │   ├── StudentGrade.java
    │   └── BankAccount.java
    └── test/java/com/stmik/
        ├── PendaftaranValidatorTest.java
        ├── StudentGradeTest.java
        └── BankAccountTest.java
```

## Cara Menjalankan Test Lokal

```bash
mvn test
mvn jacoco:report
# laporan: target/site/jacoco/index.html
```

## Link Repository

https://github.com/Zidan-h4ndr1/latihan-git-1224002
