package com.stmik;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Soal 4 - Unit test untuk calculateGrade() dan isPassed().
 */
public class StudentGradeTest {

    private StudentGrade grade;

    @BeforeEach
    public void setUp() {
        grade = new StudentGrade();
    }

    // --- calculateGrade ---

    @Test
    public void testCalculateGrade_A() {
        assertEquals("A", grade.calculateGrade(85));
    }

    @Test
    public void testCalculateGrade_B() {
        assertEquals("B", grade.calculateGrade(75));
    }

    @Test
    public void testCalculateGrade_C() {
        assertEquals("C", grade.calculateGrade(65));
    }

    @Test
    public void testCalculateGrade_D() {
        assertEquals("D", grade.calculateGrade(55));
    }

    @Test
    public void testCalculateGrade_E() {
        assertEquals("E", grade.calculateGrade(30));
    }

    @Test
    public void testCalculateGrade_Boundary80() {
        assertEquals("A", grade.calculateGrade(80));
        assertEquals("B", grade.calculateGrade(79));
    }

    @Test
    public void testCalculateGrade_InvalidLow() {
        assertThrows(IllegalArgumentException.class, () -> grade.calculateGrade(-1));
    }

    @Test
    public void testCalculateGrade_InvalidHigh() {
        assertThrows(IllegalArgumentException.class, () -> grade.calculateGrade(101));
    }

    // --- isPassed ---

    @Test
    public void testIsPassed_True() {
        assertTrue(grade.isPassed(80));
    }

    @Test
    public void testIsPassed_Boundary60() {
        assertTrue(grade.isPassed(60));
        assertFalse(grade.isPassed(59));
    }

    @Test
    public void testIsPassed_False() {
        assertFalse(grade.isPassed(40));
    }

    @Test
    public void testIsPassed_Invalid() {
        assertThrows(IllegalArgumentException.class, () -> grade.isPassed(-5));
        assertThrows(IllegalArgumentException.class, () -> grade.isPassed(150));
    }
}
