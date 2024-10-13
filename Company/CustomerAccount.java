package Company;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

/*
 * Created by Adam McCavana on 02/05/2023
 * This class is used as a Superclass for all accounts being created by users,
 * this class contains the setters and getters for all account information which can be called upon when
 * asking the user for their details. This class can also be used to call on methods from the two subclasses
 * connected to it.
 */
   // Declare abstract class CustomerAccount
   abstract public class CustomerAccount
   {
      // Declare private and public variables that will be used when creating Customer Accounts and viewing/editing the data
      private int accRefNo;
      private String name;
      private String address;
      private double balance;
      public List<CustomerAccount> customers = new ArrayList<>();
      // Declare new List customers as an ArrayList
      public CustomerAccount(){}
      // Default Constructor

      public CustomerAccount(int newAccRefNo, String newName, String newAddress){
         accRefNo = newAccRefNo;
         name = newName;
         address = newAddress;
         balance = 0;
      } // Constructor for creating Customer Accounts

      DecimalFormat df = new DecimalFormat("0,000.00");
      // This line is used to create a decimal format to be used within this class
      protected void setName(String newName){
         name = newName;
      } // set a new name
      protected void setAddress(String newAddress){
         address = newAddress;
      } // set a new address

      protected void setBalance(double newBalance){
         balance = newBalance;
      } // set a new balance

      protected String getName(){
         return name;
      } // return name on the Account
      protected String getAddress(){
         return address;
      } // return address on the Account
      protected int getAccRefNo(){
         return accRefNo;
      } // return Account Reference Number on the Account
      protected double displayBalance(){
         return balance;
      } // return Balance on the Account

      protected void payment(double paymentAmount)
      {
         String accType = Integer.toString(getAccRefNo());
         if (accType.charAt(0) == '2')
         {
            double discount = getDiscount();
            double amountSaved = paymentAmount - ((paymentAmount / 100) * discount);
            if (discount >= 0)
            {
               System.out.println("You saved: £" + df.format((paymentAmount / 100) * discount));
            }
            setBalance(displayBalance() - amountSaved);
         }
         else {
            double newBalance = displayBalance() - paymentAmount;
            setBalance(newBalance);
         }
      } /* Payment method is used to calculate how much is to be taken off the balance, the accType is worked out using
      the first value of Account Number, with 2 being a Business Account. If the account is a Business Account then the
      method will calculate the saving that the user will receive due to their discount. If the discount is valid then the
      saving will be output to the user and then the balance will be calculated.
      If the account has no discount, the balance will be calculated as normal with the paymentAmount being subtracted
      from the current balance.
      */

      protected void recordSale(double saleAmount){
         setBalance(displayBalance() + saleAmount);
      } // recordSale method is used to increase the balance of the Account by the sale amount using setBalance method

      public double getDiscount(){
         return 0.0;
      } // getDiscount method is created in this class to allow for subclass to override this method once it is called
      public void setDiscount(double newDiscount){}
      // setDiscount method is created in this class to allow for subclass to override this method once it is called

      public String toString(){

         return "Account Number: " + getAccRefNo() + "\nName on Account: " + getName() + "\nType of Account: Personal Account\n" + "Address on Account: " + getAddress() + "\nThe current balance is £" + String.format("%.2f", displayBalance());
         }  // toString method is used to output all current information about a Customer Account using the get methods already declared

   } // Customer Account Class


