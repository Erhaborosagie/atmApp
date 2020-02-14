package main.atmApp;

/**
 * Created by Osagie Erhabor on 12/02/2020.
 */
public class Account {
    private int customerNumber;
    private int pinNumber;
    int accountBalance=0;

    int getCustomerNumber() {
        return customerNumber;
    }

    void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    int getPinNumber() {
        return pinNumber;
    }

    void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }
    int getAccountBalance() {
        return accountBalance;
    }

    void addToAccount(int amount){
        accountBalance+=amount;
        System.out.println("Deposit of " + amount + "was succesfull");
        System.out.println("Your new balance is " + getAccountBalance());
    }

    void reduceAccountBalance(int amount){
        accountBalance-=amount;
        System.out.println("Withdrawal of " + amount + "was succesfull");
        System.out.println("Your new balance is " + getAccountBalance());
    }
}
