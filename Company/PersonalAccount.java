package Company;

/*
 * Created by Adam McCavana on 02/05/2023
 * This class is used to create the subclass for Personal Accounts
 * This extends the superclass CustomerAccount allowing for variables and methods to be passed for the creation
 * and editing details for a Personal Account
 */

// Declares PersonalAccount as a subclass of CustomerAccount
public class PersonalAccount extends CustomerAccount
{

      // Declare perAccNumber as a private static int that can only be changed within this class and set equal to 1001
      private static int perAccNumber = 1001;


      public PersonalAccount(){
         super();
      } // Default constructor

      public PersonalAccount(String newName, String newAddress){
         // calls on the constructor of the superclass
         super(perAccNumber, newName, newAddress);
         perAccNumber++;
         // Increment perAccNumber once a PersonalAccount has been created to be used for the next Account

      } // Constructor method for PersonalAccount, using

} // Personal Account Class
