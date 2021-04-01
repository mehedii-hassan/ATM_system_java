package atmSystem;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Mehedi Hassan
 */
public class Account {

    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    Scanner myScanner = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    //Set the customer number----------------------
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    //Get the customer number----------------------
    public int getCustomerNumber() {
        return customerNumber;
    }

    //Set the PIN number----------------------
    public void setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
    }

    //Get the PIN number------------------------------------
    public int getPinNumber() {
        return pinNumber;
    }

    //Get the checking accont balance-----------------------
    public double getCheckingBalance() {
        return checkingBalance;
    }

    //Get the saving accont balance-------------------------
    public double getSavingBalance() {
        return savingBalance;
    }

    //Calulate checking account  withdrawl------------------
    public double calcCheckingWithdraw(double amount) {

        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    //Calulate saving account  withdrawl--------------------
    public double calcSavingWithdraw(double amount) {

        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    //Calulate checking account  deposit--------------------
    public double calcCheckingDeposit(double amount) {

        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    //Calulate saving account  deposit-----------------------
    public double calcSavingDeposit(double amount) {

        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    //Customer Checking account withdraw input---------------
    public void getCheckingWithdrawInput() {
        System.out.println("Checking account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to withdraw from Checking Account: ");
        double amount = myScanner.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account Balance : " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance Cannot be Negative.\n");
        }

    }

    //Customer Saving account withdraw input------------------
    public void getsavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to withdraw from saving Account: ");
        double amount = myScanner.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("New saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance Cannot be Negative." + "\n");
        }
    }

    //Customer Checking account deposit input-----------------
    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance: " + moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to Deposit from Checking Account: ");
        double amount = myScanner.nextDouble();

        if ((checkingBalance + amount) >= 0) {
            calcCheckingDeposit(amount);
            System.out.println("New Checking Account Balance: " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance Cannot be Negative." + "\n");
        }
    }

    //Customer Saving account Deposit input---------------
    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance: " + moneyFormat.format(savingBalance));
        System.out.print("Amount you want to Deposit from Saving Account: ");
        double amount = myScanner.nextDouble();

        if ((savingBalance + amount) >= 0) {
            calcSavingDeposit(amount);
            System.out.println("New saving Account Balance: " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Balance Cannot be Negative." + "\n");
        }
    }
}
