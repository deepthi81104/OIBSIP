import javax.swing.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static ArrayList<Transaction> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        int balance=0;
        int bank_balance= 10000;
        Scanner sc=new Scanner(System.in);
        JOptionPane.showConfirmDialog(null, "WELCOME TO YOU'RE ATM , READY  TO ACCESS YOU'RE ACCOUNT ?");
        String name=JOptionPane.showInputDialog("LOGIN:" +
                '\n'+ "enter name");
        String password=JOptionPane.showInputDialog("whats your password");
        if(Authenticate_login(name,password)){
            System.out.println("Welcome to you're account what would you like to do");
            while(true){
                display_choices();
                System.out.println("Whats you're choice ?");
                int choice= sc.nextInt();

                if (choice == 1) {
                    System.out.println("What is the amount you want to deposit:");
                    int amount = sc.nextInt();
                    balance=get_deposit(bank_balance, amount);
                    bank_balance=balance;
                } else if (choice == 2) {
                    System.out.println("What is the amount you want to withdraw:");
                    int amount1 = sc.nextInt();
                    balance=get_withdraw(bank_balance, amount1);
                    bank_balance=balance;

                } else if (choice == 3) {
                    System.out.println("Enter account to transfer money:");
                    String acc_name = sc.next();
                    System.out.println("Enter amount you want to transfer:");
                    int amount2 = sc.nextInt();
                    balance=get_transfer(bank_balance, amount2, acc_name);
                    bank_balance=balance;

                } else if (choice == 4) {
                    get_history();
                } else {
                    get_out();
                    break;
                }
            }
        }
    }
    public static boolean Authenticate_login(String name , String password){
        if(name.equals("user1")&& password.equals("123")) {
            JOptionPane.showMessageDialog(null,"valid login");
            return true;
        }
        else{
            JOptionPane.showMessageDialog(null,"invalid login try again");
        }
        return false;
    }
    public static void  display_choices() {
        System.out.println("1. Deposit" + '\n' + "2.Withdraw" + '\n' + "3.Transfer" + '\n' + "4.Transaction History" + '\n' + "5.Exit");
    }
    public static int  get_deposit(int bank_balance,int amount) {
        System.out.println("Amount successfully deposited");
        System.out.println("Total Balance"+ (bank_balance+amount));
        return bank_balance+amount;
    }

    public static int  get_withdraw(int bank_balance,int amount1) {
        if(amount1>bank_balance){
            System.out.println("Insufficient Funds");
        }
        else {
            System.out.println("Amount withdrawn"+'\n'+"Total Balance"+(bank_balance-amount1));
        }
        return bank_balance-amount1;
    }



    public static int get_transfer(int bank_balance, int amount2, String acc_name) {
        if (amount2 >= 5000) {
            System.out.println("5000 is the limit to transfer");
        } else {
            transactionHistory.add(new Transaction("Transfer to " + acc_name, amount2));
            System.out.println("Amount Transferred to " + acc_name + "\nTotal Balance: " + (bank_balance - amount2));
        }
        return bank_balance-amount2;
    }

    public static void get_history() {
        System.out.println("Transaction History:");
        for (Transaction transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public static void get_out() {
        System.out.println("Exiting the ATM. Goodbye!");
        System.exit(0);
    }

    static class Transaction {
        String type;
        int amount;

        public Transaction(String type, int amount) {
            this.type = type;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return type + ": " + amount;
        }
    }
}




             



