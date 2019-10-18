/*
 * Name : Toufiqul Islam
 * Roll : 1910876107
 * session: 2018-2019
 * */

public class CurrentAccount extends Bank {
    private final double INTEREST_RATE = 0.045;
    private final int TRANSACTION_LIMIT = 6;
    private int transaction = 0;


    CurrentAccount(String firstName,String lastName,String address,String mobile,double balance,int accountNumber){
        super(firstName,lastName,address,mobile,balance,accountNumber);
        System.out.println("Congratulations Your Current Account Successfully created!!\nYor Account Number is "+accountNumber
        +" !\nUse Account number for further access to Your Account!!");
    }

    public void deposit(double amount){
        if(transaction<=TRANSACTION_LIMIT){
            setBalance(getBalance()+amount);
            transaction++;
            System.out.println("Congratulations ! Transaction Successfully done !");
            setLastTransaction("Deposit");
        }
        else
            System.out.println("Daily Transaction limit over !");
    }

    public void withdraw(double amount){
        if(transaction<=TRANSACTION_LIMIT){
            if(amount<=getBalance()){
                setBalance(getBalance()-amount);
                transaction++;
                System.out.println("Congratulations ! Transaction Successfully done !");
                setLastTransaction("Withdraw");
            }
            else
                System.out.println("Insufficient Balance !");
        }
        else
            System.out.println("Daily Transaction limit over !");
    }
    public void checkBalance(){
        System.out.println("\nAccount Name : "+getFirstName()+" "+getLastName());
        System.out.println("Account Type : Current Account");
        System.out.println("Account Balance : "+getBalance());
    }
    public void accstatus(){
        System.out.println("\nAccount Name : "+getFirstName()+" "+getLastName());
        System.out.println("Account Type : Current Account");
        System.out.println("Address : "+getAddress());
        System.out.println("Contact : "+getMobile());
        System.out.println("Account Balance : "+getBalance());
        System.out.println("Last Transaction : "+getLastTransaction());
        System.out.println("Interest : "+getBalance()*INTEREST_RATE);
    }
}
