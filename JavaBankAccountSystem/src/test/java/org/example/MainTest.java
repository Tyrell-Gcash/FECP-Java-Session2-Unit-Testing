package org.example;

import java.io.ByteArrayInputStream;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {


    private final InputStream originalIn = System.in;

    private BankAccount bankAccount;

    private ArrayList<BankAccount> bankAccounts;

    @BeforeEach
    void setUp() {
        bankAccounts = new ArrayList<>();

        bankAccount = new BankAccount();
        bankAccount.setAccountName("Tyrell");
        bankAccount.setAccountNumber(1);
        bankAccount.deposit(1000);

        bankAccounts.add(bankAccount);
    }

    @AfterEach
    void restoreSystemInput() {
        System.setIn(originalIn);
    }

    @Test
    public void testValidWidthdrawAmount(){
        //https://www.geeksforgeeks.org/advance-java/unit-testing-system-in-for-input-handling-in-junit/

        String userInput = "1\n200\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        Main.widthdrawFromAccount(bankAccounts); // assuming the method is in class `Main`

        assertEquals(800, bankAccounts.get(0).getAccountBalance(), 0.001); // Account balance should now be 800
    }

    @Test
    public void testValidDepositAmount(){
        //https://www.geeksforgeeks.org/advance-java/unit-testing-system-in-for-input-handling-in-junit/

        String userInput = "1\n500.0\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        Main.depositToAccount(bankAccounts);

        assertEquals(1500, bankAccounts.get(0).getAccountBalance(), 0.001); // Account balance should now be 800
    }

    @Test
    public void testInvalidWidthdrawAmount_NegativeValue(){
        //https://www.geeksforgeeks.org/advance-java/unit-testing-system-in-for-input-handling-in-junit/

        String userInput = "1\n-500.0\n-500.0\n0";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        Main.widthdrawFromAccount(bankAccounts);

        assertEquals(1000, bankAccounts.get(0).getAccountBalance(), 0.001); // Account balance should now be 800
    }

    @Test
    public void testInvalidWidthdrawAmount_ExceedsBalance(){
        //https://www.geeksforgeeks.org/advance-java/unit-testing-system-in-for-input-handling-in-junit/

        String userInput = "1\n500000.0\n500000.0\n0";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        Main.widthdrawFromAccount(bankAccounts);

        assertEquals(1000, bankAccounts.get(0).getAccountBalance(), 0.001); // Account balance should now be 800
    }

    @Test
    public void testInvalidDepositAmount(){
        //https://www.geeksforgeeks.org/advance-java/unit-testing-system-in-for-input-handling-in-junit/

        String userInput = "1\n-500.0\n-500.0\n0";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        Main.depositToAccount(bankAccounts);

        assertEquals(1000, bankAccounts.get(0).getAccountBalance(), 0.001); // Account balance should now be 800
    }

    @Test
    public void testCreateAccountWithNoBalance(){
        //https://www.geeksforgeeks.org/advance-java/unit-testing-system-in-for-input-handling-in-junit/

        BankAccount expected = new BankAccount();
        expected.setAccountNumber(2);
        expected.setAccountName("Lebron James");
        bankAccounts.add(expected);

        BankAccount actual = bankAccounts.get(1);

        String userInput = "2\nLebron_James\nno";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        Main.createAccount(bankAccounts);

        assertEquals(expected, actual); // Account balance should now be 800
    }

    @Test
    public void testGetAccountNumberMethod(){
        int accountNumber = 1;
        bankAccount.getAccountNumber();
        assertEquals(accountNumber, bankAccount.getAccountNumber(), 0.001);
    }

}