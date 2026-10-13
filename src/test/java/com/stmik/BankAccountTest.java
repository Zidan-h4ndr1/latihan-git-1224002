package com.stmik;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Soal 8 (Bonus) - Minimal 6 test case untuk BankAccount.
 */
public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount();
    }

    @Test
    public void testInitialBalanceZero() {
        assertEquals(0.0, account.getBalance(), 0.0001);
    }

    @Test
    public void testDepositMenambahSaldo() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), 0.0001);
    }

    @Test
    public void testDepositNegatifDitolak() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-50.0));
    }

    @Test
    public void testDepositNolDitolak() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
    }

    @Test
    public void testWithdrawMengurangiSaldo() {
        account.deposit(200.0);
        account.withdraw(70.0);
        assertEquals(130.0, account.getBalance(), 0.0001);
    }

    @Test
    public void testWithdrawMelebihiSaldoDitolak() {
        account.deposit(50.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100.0));
    }

    @Test
    public void testWithdrawNegatifDitolak() {
        account.deposit(50.0);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10.0));
    }

    @Test
    public void testConstructorSaldoAwalNegatifDitolak() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-10.0));
    }
}
