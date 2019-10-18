/*
 * Name : Toufiqul Islam
 * Roll : 1910876107
 * session: 2018-2019
 * */

public abstract class Bank {
    private String firstName;
    private String lastName;
    private String address;
    private String mobile;
    private double balance;
    private int accountNumber;
    private String lastTransaction;
    Bank(String firstName,String lastName,String address,String mobile,double balance, int accountNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobile = mobile;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setLastTransaction(String transaction){
        lastTransaction = transaction;
    }

    public String getLastTransaction() {
        return lastTransaction;
    }

    abstract void withdraw(double amount);
    abstract void deposit(double amount);
    abstract void accstatus();

}
