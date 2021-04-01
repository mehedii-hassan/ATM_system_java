package atmSystem;

/* 
Main class
 */
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Mehedi Hassan
 */
public class OptionMenu extends Account {

    Scanner myScanner = new Scanner(System.in);
    DecimalFormat moneyFormat1 = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

    //Validate Login information customer number and PIN number-------------
    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                //Now putting key value pair in HashMap---------------------
                hashMap.put(160951, 100001);
                hashMap.put(160952, 100041);
                hashMap.put(160953, 100023);
                hashMap.put(160954, 100028);
                hashMap.put(160955, 100068);
                hashMap.put(160956, 100099);

                System.out.println("Welcome to the ATM Project!");
                System.out.print("Enter your customer Number: ");
                setCustomerNumber(myScanner.nextInt());
                System.out.print("Enter your PIN Number: ");
                setPinNumber(myScanner.nextInt());
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("\n" + "Invalid Character(s). Only Numbers." + "\n");
                e.printStackTrace();
                x = 2;
            }
            /*for(Map.Entry<Integer,Integer> it : data.entrySet()){
           if(it.getkey()==getCustomerNumber() && it.getValue()==getPinNumber){
             getAccountType();
           }
         }*/
            int cn = getCustomerNumber();
            int pn = getPinNumber();
            if (hashMap.containsKey(cn) && hashMap.get(cn) == pn) {
                getAccountType();
            } else {
                System.out.println("\n" + "Wrong Customer Number or Pin Number" + "\n");
            }
        } while (x == 1);
    }

    //Display Account type Menu with selection---------------------
    public void getAccountType() {
        System.out.println("Select the Account you Want to Access: ");
        System.out.println(" Type 1 - Checking Account");
        System.out.println(" Type 2 - Saving Account");
        System.out.println(" Type 3 - Exit");
        System.out.print("Choice: ");

        int selection = myScanner.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;

            case 2:
                getSaving();
                break;

            case 3:
                System.out.println("Thank You for using this ATM, bye.  \n");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getAccountType();
        }
    }

    //Displey checking account Menu with selection-----------------
    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println(" Type 1 - View Balance");
        System.out.println(" Type 2 - Withdraw Funds");
        System.out.println(" Type 3 - Deposit Funds");
        System.out.println(" Type 4 - Exit");
        System.out.print("Choice: ");

        int selection = myScanner.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;

            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You for using this ATM, bye.");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getChecking();
        }
    }

//Display savig account Menu with selection-------------------
    public void getSaving() {
        System.out.println("Saving Account: ");
        System.out.println(" Type 1 - View Balance");
        System.out.println(" Type 2 - Withdraw Funds");
        System.out.println(" Type 3 - Deposit Funds");
        System.out.println(" Type 4 - Exit");
        System.out.print("Choice: ");

        int selection = myScanner.nextInt();

        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;

            case 2:
                getsavingWithdrawInput();
                getAccountType();
                break;

            case 3:
                getSavingDepositInput();
                getAccountType();
                break;

            case 4:
                System.out.println("Thank You for using this ATM, bye.");
                break;

            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getChecking();
        }
    }
}
