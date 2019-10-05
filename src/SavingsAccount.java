public class SavingsAccount extends Bank {
    private final double MIN_ACC_BALANCE = 500;
    private final double INTEREST_RATE = 0.0275;
    private final int TRANSACTION_LIMIT = 3;
    private final double MAX_WITHDRAW = 50000;
    private final double DAILY_WITHDRAW = 120000;
    private int transaction = 0;
    private double withdraw = 0;


    SavingsAccount(String firstName,String lastName,String address,String mobile,double balance,int accountNumber){
        super(firstName,lastName,address,mobile,balance,accountNumber);
        System.out.println("Congratulations Your Savings Account Successfully created!!\nYor Account Number is "+accountNumber
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
            System.out.println("Sorry, Daily Transaction limit reached !");
    }

    public void withdraw(double amount){
        if(transaction<=TRANSACTION_LIMIT){
            if(amount<=MAX_WITHDRAW){
                if((withdraw+amount)<=DAILY_WITHDRAW){
                    if((amount+MIN_ACC_BALANCE)<=getBalance()){
                        setBalance(getBalance()-amount);
                        transaction++;
                        withdraw += amount;
                        System.out.println("Congratulations ! Transaction Successfully done !");
                        setLastTransaction("Withdraw");
                    }
                    else
                        System.out.println("Sorry, You have Insufficient Balance !");
                }
                else
                    System.out.println("Sorry ! Daily Withdraw limit reached !");
            }
            else
                System.out.println("Sorry ! Maximum withdraw limit exceeded !");
        }
        else
            System.out.println("Sorry ! Daily Transaction limit reached !");
    }
    public void checkBalance(){
        System.out.println("\nAccount Name : "+getFirstName()+" "+getLastName());
        System.out.println("Account Type : Savings Account");
        System.out.println("Account Balance : "+getBalance());
    }

    public void accstatus(){
        System.out.println("\nAccount Name : "+getFirstName()+" "+getLastName());
        System.out.println("Account Type : Savings Account");
        System.out.println("Address : "+getAddress());
        System.out.println("Contact : "+getMobile());
        System.out.println("Account Balance : "+getBalance());
        System.out.println("Last Transaction : "+getLastTransaction());
        System.out.println("Interest : "+getBalance()*INTEREST_RATE);
    }
}
