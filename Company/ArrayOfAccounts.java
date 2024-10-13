package Company;
 /*
 * Created by Adam McCavana on 02/05/2023
 * This class is used to create an ArrayOfAccounts List which is used to hold information
 * on each account registered by the user, this can then be accessed to retrieve
 * and edit any information using methods
 */

import java.util.ArrayList;
import java.util.List;

public class ArrayOfAccounts
{
   public static int account = -1;
   private List<CustomerAccount> customers = new ArrayList<>();
   // Declare private List which is used to create an ArrayList for Accounts
   public ArrayOfAccounts(){
      customers = new ArrayList<CustomerAccount>();
   }

   protected void insert(CustomerAccount newAccount){
      this.customers.add(newAccount);
      System.out.println(newAccount.getAddress() + " Added");
   } // insert Method is used to add new Accounts to the array and tell the user it has been added

   protected CustomerAccount getCurrent(int position) {
      return customers.get(position);
   }
   // getCurrent method is used to return the reference of the corresponding Account
   protected int getNoOfAccounts() {
      return customers.size();
   }
   // getNoOfAccounts is used to return the number of Accounts currently registered

   protected int accNumberCheck(int accNumber){


      for(int index = 0; index < getNoOfAccounts(); index++) {
         if ((getCurrent(index)).getAccRefNo() == (accNumber)) {
            account = index;
            break;
         }
         else{
             account = -1;
         }
      }
      return account;
   }

/* accNumberCheck method is used to loop through each object that is contained within the customers ArrayList
   and check each value against the user input, if there is a match the loop will break and the index will be returned,
   otherwise account will be returned as -1 which indicates no Account matches
 */

} // ArrayOfAccounts class
