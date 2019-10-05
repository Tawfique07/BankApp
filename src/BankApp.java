import java.util.Scanner;

public class BankApp {
    private static int nextSavingsAccountNumber = 1000;
    private static int nextCurrentAccountNumber = 2000;
    private static int number;
    private static boolean mark;

    public static void main(String[] args) {
        int s=0, c=0, choice;
        String firstName;
        String lastName;
        String address;
        String mobile;
        double balance;



        SavingsAccount[] savings = new SavingsAccount[100];
        CurrentAccount[] current = new CurrentAccount[100];
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        Scanner input3 = new Scanner(System.in);
        cls();
        System.out.println("~Banking System App~");
        do{

            System.out.println("\n1. Open Savings Account.\n2. Open Current Account.\n3. Deposit.\n4. Withdraw.\n5. Check Balance.\n6. Account Status." +
                    "\n7. Exit.");
            System.out.print("Press here : ");
            choice= input.nextInt();
            switch (choice){
                case 1:
                    cls();
                    System.out.println("~Banking System App~");
                    System.out.print("\nFirst Name : "); firstName = input1.nextLine();
                    System.out.print("Last  Name : "); lastName = input1.nextLine();
                    System.out.print("Address    : "); address = input1.nextLine();
                    System.out.print("Cell Number: "); mobile = input1.nextLine();
                    System.out.print("Opening Balance: "); balance = input.nextDouble();
                    while(balance<1000){
                        System.out.println("Opening Balance not less than 1000!");
                        System.out.print("Opening Balance: "); balance = input.nextDouble();
                    }
                    savings[s] = new SavingsAccount(firstName,lastName,address,mobile,balance,nextSavingsAccountNumber);
                    s++; nextSavingsAccountNumber++;
                    break;
                case 2:
                    cls();
                    System.out.println("~Banking System App~");
                    System.out.print("\nFirst Name : ");firstName = input1.nextLine();
                    System.out.print("Last  Name : ");lastName = input1.nextLine();
                    System.out.print("Address    : "); address = input1.nextLine();
                    System.out.print("Cell Number: "); mobile = input1.nextLine();
                    System.out.print("Opening Balance: "); balance = input.nextDouble();
                    while(balance<40000){
                        System.out.println("Opening Balance not less than 40000!");
                        System.out.print("Opening Balance: "); balance = input.nextDouble();
                    }
                    current[c] = new CurrentAccount(firstName,lastName,address,mobile,balance,nextCurrentAccountNumber);
                    c++; nextCurrentAccountNumber++;
                    break;
                case 3:
                    cls();
                    System.out.println("~Banking System App~");
                    System.out.print("\nEnter Account Number : "); number= input.nextInt();
                    while(number<1000 || number > 2099){
                        System.out.print("Enter Correct Account Number : ");
                        number= input.nextInt();
                    }
                    if(checker(s,c)){
                        System.out.println("Enter Amount : "); balance = input.nextDouble();
                        if(mark)
                        {
                            savings[number].deposit(balance);
                            System.out.println("Your New Account Balance is : "+savings[number].getBalance());
                        }
                        else
                        {
                            current[number].deposit(balance);
                            System.out.println("Your New Account Balance is : "+current[number].getBalance());
                        }
                    }
                    else
                        System.out.println("Sorry, Account Doesn't Exist!!");
                    break;
                case 4:
                    cls();
                    System.out.println("~Banking System App~");
                    System.out.print("\nEnter Account Number : "); number= input.nextInt();
                    while(number<1000 || number > 2099){
                        System.out.print("Enter Correct Account Number : ");
                        number= input.nextInt();
                    }
                    if(checker(s,c)){
                        System.out.println("Enter Amount : "); balance = input.nextDouble();
                        if(mark)
                        {
                            savings[number].withdraw(balance);
                            System.out.println("Your New Account Balance is : "+savings[number].getBalance());
                        }
                        else
                        {
                            current[number].withdraw(balance);
                            System.out.println("Your New Account Balance is : "+current[number].getBalance());
                        }
                    }
                    else
                        System.out.println("Sorry, Account Doesn't Exist!!");
                    break;
                case 5:
                    cls();
                    System.out.println("~Banking System App~");
                    System.out.print("Enter Account Number : "); number= input.nextInt();
                    while(number<1000 || number > 2099){
                        System.out.print("Enter Correct Account Number : ");
                        number= input.nextInt();
                    }
                    if(checker(s,c)){
                        if(mark)
                            savings[number].checkBalance();
                        else
                            current[number].checkBalance();
                    }
                    else
                        System.out.println("Sorry, Account Doesn't Exist!!");
                    break;
                case 6:
                    cls();
                    System.out.println("~Banking System App~");
                    System.out.print("Enter Account Number : "); number= input.nextInt();
                    while(number<1000 || number > 2099){
                        System.out.print("Enter Correct Account Number : ");
                        number= input.nextInt();
                    }
                    if(checker(s,c)){
                        if(mark)
                            savings[number].accstatus();
                        else
                            current[number].accstatus();
                    }
                    else
                        System.out.println("Sorry, Account Doesn't Exist!!");
                    break;
                case 7:
                    cls();
                    break;
                default:
                    cls();
                    System.out.println("~Banking System App~");
                    System.out.println("No match fount! try again !");

            }

        }while(choice!=7);
    }
    private static boolean checker(int s,int c){
        String check;
        check = Integer.toString(number);
        if(check.charAt(0)=='1')
        {
            mark = true;
            number = number % 1000;
            return number < s;
        }
        else if(check.charAt(0)=='2')
        {
            mark = false;
            number = number % 1000;
            return number < c;
        }
        else
            return false;
    }
    public static void cls() {
        try {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }catch (Exception E)
        {
            System.out.println(E);
        }
    }

}
