package org.example;

public class BankAccount {

    private int accountNumber;
    private String accountName;
    private double accountBalance = 0;

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void deposit(double depositAmount) {
        this.accountBalance += depositAmount;
    }

    public void withdraw(double widthdrawAmount) {
        this.accountBalance -= widthdrawAmount;
    }

    void displayInformation (){
        System.out.println("==========");
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account number: " + accountName);
        System.out.println("Account number: " + accountBalance);
        System.out.println("==========");
    }
}
