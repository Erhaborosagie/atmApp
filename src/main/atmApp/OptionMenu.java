package main.atmApp;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Osagie Erhabor on 12/02/2020.
 */
public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer,Integer> data = new HashMap<Integer, Integer>();

    public void getLogin(){
        int x = 1;
        do {
            try {
                data.put(1110111, 1234);
                data.put(1110151, 1334);

                System.out.println("Enter your account number");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter your four digit pin");
                setPinNumber(menuInput.nextInt());
            }catch (Exception e){
                System.err.println("\n Invalid character(s) Numbers only \n");
                x=2;
            }
            for (Map.Entry<Integer, Integer> entry:data.entrySet()){
                if (entry.getKey() == getCustomerNumber() && entry.getValue()==getPinNumber()){
                    performOperation();
                }
            }

            System.out.println("\n Wrong account number or pin only \n");
        }while (x==1);
    }

    private void performOperation() {
        System.out.println("What do you want to do?");
        System.out.println("Check Account Balance: 1");
        System.out.println("Withdraw Amount: 2");
        System.out.println("Deposit Amount: 3");
        System.out.println("Exit: 4");

        int choice = menuInput.nextInt();

        switch (choice){
            case 1:
                System.out.println("Your account balance is: " + moneyFormat.format(getAccountBalance()));
                performOperation();
                break;
            case 2:
                currentWithdraw();
                performOperation();
                break;
            case 3:
                currentDeposit();
                performOperation();
                break;
            case 4:
                System.out.println("Thank you for using this service");
                break;
            default:
                System.err.println("\nInvalid choice\n");
                performOperation();
        }
    }

    private void currentDeposit() {
        System.out.println("Enter amount to deposit");
        int amount = menuInput.nextInt();
        addToAccount(amount);
    }

    private void currentWithdraw() {
        System.out.println("Enter amount :");
        int amount = menuInput.nextInt();
        if (amount<getAccountBalance()){
            reduceAccountBalance(amount);
        }else System.out.println("Insufficient fund. \n Account balance is :" + getAccountBalance());

    }
}
