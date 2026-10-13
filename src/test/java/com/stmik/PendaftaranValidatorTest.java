package com.stmik;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Soal 3 - 5(+1) test case berdasarkan independent path validasiPendaftaran.
 * P1: nama kosong | P2: umur &lt; 17 | P3: email null | P4: email tanpa '@'
 * P5: tidak setuju syarat | P6: semua valid (pendaftaran berhasil).
 */
public class PendaftaranValidatorTest {

    private PendaftaranValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new PendaftaranValidator();
    }

    @Test
    public void testPath1_NamaKosong() {
        // Arrange & Act
        String result = validator.validasiPendaftaran("", 20, "user@mail.com", true);
        // Assert
        assertEquals("Nama harus diisi", result);
    }

    @Test
    public void testPath1_NamaNull() {
        String result = validator.validasiPendaftaran(null, 20, "user@mail.com", true);
        assertEquals("Nama harus diisi", result);
    }

    @Test
    public void testPath2_UmurKurangDari17() {
        String result = validator.validasiPendaftaran("Budi", 16, "budi@mail.com", true);
        assertEquals("Umur minimal 17 tahun", result);
    }

    @Test
    public void testPath3_EmailNull() {
        String result = validator.validasiPendaftaran("Budi", 20, null, true);
        assertEquals("Email tidak valid", result);
    }

    @Test
    public void testPath4_EmailTanpaAt() {
        String result = validator.validasiPendaftaran("Budi", 20, "budimail.com", true);
        assertEquals("Email tidak valid", result);
    }

    @Test
    public void testPath5_TidakSetujuSyarat() {
        String result = validator.validasiPendaftaran("Budi", 20, "budi@mail.com", false);
        assertEquals("Harus menyetujui syarat dan ketentuan", result);
    }

    @Test
    public void testPath6_PendaftaranBerhasil() {
        String result = validator.validasiPendaftaran("Budi", 20, "budi@mail.com", true);
        assertEquals("Pendaftaran berhasil", result);
    }
}
