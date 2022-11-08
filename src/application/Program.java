package application;

import model.entities.Account;
import model.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data");
            System.out.print("Number : ");
            int number = sc.nextInt();
            System.out.println("Holder : ");
            String holder = sc.next();
            System.out.println("Initial balance : ");
            double initialBalance = sc.nextDouble();
            System.out.println("Withdraw limit : ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, holder, initialBalance, withdrawLimit);

            System.out.println("Enter amount fot withdraw : ");
            double amount = sc.nextDouble();
            account.withdraw(amount);

            System.out.println("New Balance"+ account.getBalance());


        } catch (DomainException e){
            System.out.println("Withdraw Error: " + e.getMessage());
        } catch (RuntimeException e){
            System.out.println("Unexpected error! ");
        }
        sc.close();
    }
}