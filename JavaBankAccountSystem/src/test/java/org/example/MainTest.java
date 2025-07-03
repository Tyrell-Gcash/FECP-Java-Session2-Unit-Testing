package org.example;

import java.io.ByteArrayInputStream;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    static  ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private BankAccount bankAccount;

    @BeforeEach
    void setup() {

        bankAccount = new BankAccount();
        bankAccount.setAccountName("Tyrell");
        bankAccount.setAccountNumber(1);
        bankAccount.deposit(1000);

        bankAccounts.add(bankAccount);
    }

//    @Test
//    public void testValidDepositAmount(){
//        double deposit = 1000.0;
//        bankAccount.deposit(deposit);
//        assertEquals(deposit, bankAccount.getAccountBalance(), 0.001);
//    }
//
//    @Test
//    public void testInvalidDepositAmount(){
//        double deposit = -1000.0;
//        bankAccount.deposit(deposit);
//        assertEquals(deposit, bankAccount.getAccountBalance(), 0.001);
//    }

    @Test
    public void testValidWidthdrawAmount(){
        String simulatedInput = "1\n200\n";
        InputStream originalIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        
        Main.widthdrawFromAccount(bankAccounts); // assuming the method is in class `Main`


        assertEquals(800, bankAccounts.get(0).getAccountBalance(), 0.001); // Account balance should now be 800


        System.setIn(originalIn);
    }

    @Test
    public void testGetAccountNumberMethod(){
        int accountNumber = 1;
        bankAccount.getAccountNumber();
        assertEquals(accountNumber, bankAccount.getAccountNumber(), 0.001);
    }

}