package Company;
/*
 * Created by Adam McCavana on 02/05/2023
 * This class is used to create the subclass for BusinessAccounts
 * This extends the superclass CustomerAccount and these methods can be used whenever a user would
 * like to create or edit a Business Account, this contains variables and methods specific to Business accounts
 */

// Declares BusinessAccount as a subclass of CustomerAccount
public class BusinessAccount extends CustomerAccount
{
   // Declare perAccNumber as a private static int that can only be changed within this class and set equal to 2001
   private static int busAccNumber = 2001;
   // Declare discount as a private static double that can only be changed within this class
   private static double discount;
   public BusinessAccount()
   { super();} // Default Constructor

   public BusinessAccount(String newName, String newAddress, double newDiscount){
      // calls on the constructor of the superclass
      super(busAccNumber, newName, newAddress);
      discount = newDiscount;
      busAccNumber++;
      // set discount equal to the amount given
      // Increment busAccNumber once a BusinessAccount has been created to be used for the next Account
   } // Constructor

   public void setDiscount(double newDiscount){
      discount = newDiscount;
   }
   // setDiscount method is used to set a new Discount on an account, this overrides the method from the Superclass
   public double getDiscount(){
      return discount;
   }
   // getDiscount method is used to return discount, this overrides the method from the Superclass


   public String toString(){

      return "Account Number: " + getAccRefNo() + "\nName on Account: " + getName() + "\nType of Account: Personal Account\n" + "Address on Account: " + getAddress() + "\nThe current balance is £" + String.format("%.2f", displayBalance()) + "\nDiscount on Account: " + getDiscount() + "%";
      } // toString method is used to output all current information about a Business Account using the superclass/ current class methods

} // Business Account Class

