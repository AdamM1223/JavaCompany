package Company;
/*
*
 * Created by Adam McCavana on 02/05/2023
 * This class is used to display the menu system to the user, this incorporates an Array, the Superclass, as well as
 * both subclasses to validate and run as intended and required by the assignment brief. The user will first be taken
 * to a Main Menu System and will be asked for input
 */

import java.util.Scanner;

public class Company
{  // Declare public class Company

   // Declare accNumber as a public static int and myArray as a new ArrayOfAccounts ArrayList
   private static int accNumber;

   private static double accDiscount;
   private static double sale;
   private static double paymentAmount;
   static ArrayOfAccounts myArray = new ArrayOfAccounts();


   public static void main(String[] args)
   {
      welcome();
      menuSystem();
   }  // Main Method is used to call on the welcome and menu methods

   public static void welcome()
   {
      System.out.println("** CW 2 **");
      System.out.println("Welcome to our company!");
   }  // The welcome Method is a small method welcoming the user to the Menu when it is first run


   /* Menu System method is used to present the user with the initial Menu and prompt them for
      a valid input to decide how to continue. This will then continue through the Method depending on
      what they have chosen to enter, ensuring that all user input is valid through multiple try catch blocks
      as well as if statements to ensure the values are within range.
    */
   public static void menuSystem()
   {
      do
      {
         /* declare initial variables to be used within this Method, such as a Scanner and setting valid = false,
            which is used in a do while loop
          */

         boolean valid = false;
         // Display the following menu to the user allowing them to know the valid options
         System.out.println("How would you like to continue? ");
         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
         System.out.println("Create a new account with us! - 1");
         System.out.println("View an existing account with us - 2");
         System.out.println("Exit Menu - 0");
         //validateMenuSystems(0,2);
         int menu;

         /* do while loop is used with the validateIntInput Method to take the user input following the Menu
         being displayed, this will take the user input as String and try to convert this to an Integer to be used
         within a switch statement. If the input is invalid an error message will be displayed to the user
         and they will be prompted for another input, thanks to the loop used.
          */
         System.out.println("Please choose an option: ");
         do
         {

            menu = Validation.validateIntInput();
//
            /* If the user inputs an integer, this input will be checked with an If statement to determine
            whether it is within the range of our Menu system, if the integer is not within the given range, an error
            message will be displayed to the user and the loop will return to the beginning
             */

            if (!(menu < 0 || menu > 2))
            {
               valid = true;
               System.out.println("Thank you");
            } else if (menu != -1)
            {
               System.out.println("Invalid Input - Try Again: ");
            }
            /*  Else If statement will check and ensure that the user input is within the correct range of values.
            If the value can pass this If statement then a "Thank You" message is displayed and the variable valid
            is set to true to end the do while loop */

         } while (!valid);

         /* The user input from above is input into a switch statement to determine what option the
            user decided on */

         switch (menu)
         {
            case 0:
               System.exit(0);
               // If Menu was 0 the system will exit the Menu

            case 1:
               /* If Menu was 1, case 1 will continue, another menu will
                  be output to the user, allowing them to decide which Account Type
                  to create
                */


               // Declare variable to be used in the following loop
               boolean accountChoice = false;
               // accountChoice is declared as false to begin the do while loop
               int accountOption = 4;

               /* Do while loop to loop the code while accountChoice is false, ensuring that if any invalid
                  input is given, the user will be given the chance to have another chance of inputting
                */
               do
               {
                  System.out.println("Please choose correct Account Type.");
                  System.out.println("Business Account - 1");
                  System.out.println("Personal Account - 2");
                  /* validateIntInput Method is used to take the user input and try to convert it to an integer
                   as is required for the Menu system, an error message will display if any invalid data
                   is entered and the user will be prompted for another input, until valid data has been
                   entered thanks to the loop */
                  do
                  {
                     accountOption = Validation.validateIntInput();
                     if ((accountOption < 1 || accountOption > 2) && accountOption != -1)
                     {
                        System.out.println("\nInvalid Input - Try Again:");
                     }
                  } while ((accountOption < 1 || accountOption > 2));
                  // If user input was a valid int, then pass the value into an if statement to check the range

                  // Error message if user input is not within the valid range
                     System.out.println("Thank you");
                     // Display "Thank You" message to user if input was valid

                        /* The user input from above is input into a switch statement to determine what option the
                        user decided on */
                     switch (accountOption)
                     {
                           /* If accountOption is 1, prompt the user for the required information for a Business
                              Account and store this information with variables to be used later
                            */
                        case 1:
                           Scanner business = new Scanner(System.in);
                           // Scanner to take user input
                           System.out.println("Please enter name for Business Account: ");
                           String name = business.nextLine();
                           System.out.println("Please enter address for Business Account: ");
                           String address = business.nextLine();

                              /* Do while loop is used with the validateDoubleInput Method to try and convert the
                              user input to a double value, so that it can be stored correctly, if invalid,
                              the user will see an error message and will be prompted for a new value */
                           System.out.println("Please enter valid discount for Business Account: ");
                           do
                           {
                              accDiscount = Validation.validateDoubleInput();
                              if (((accDiscount > 100) || (accDiscount < 0)) && (accDiscount != -1)){
                                 System.out.println("Invalid Input - Try Again: ");

                              }

                           } while ((accDiscount < 0) || (accDiscount > 100));
                           // Loop continues while user input is not between 0 and 100

                           BusinessAccount busAcc1 = new BusinessAccount(name, address, accDiscount);
                           // Create new BusinessAccount object using the values that have been given

                           //List<CustomerAccount> customers = new ArrayList<>();
                           myArray.insert(busAcc1);
                           // Insert new BusinessAccount into myArray
                           System.out.println("Account Number - " + busAcc1.getAccRefNo());
                           // Output the Account Number of this new account to the User
                           accountChoice = true;
                           break;
                           // set accountChoice to true to end the do while loop


                            /* If accountOption is 2, prompt the user for the required information for a Personal
                               Account and store this information with variables to be used later
                            */
                        case 2:
                           Scanner personal = new Scanner(System.in);
                           // Scanner to take user input

                           System.out.println("Please enter name for Personal Account: ");
                           name = personal.nextLine();
                           System.out.println("Please enter address for Personal Account: ");
                           address = personal.nextLine();
                           PersonalAccount perAcc1 = new PersonalAccount(name, address);
                           // Declare a new PersonalAccount with the values that have been given
                           myArray.insert(perAcc1);
                           // Insert new PersonalAccount into myArray
                           System.out.println("Account Number - " + perAcc1.getAccRefNo());
                           // Output the Account Number of this new account to the User
                           accountChoice = true;
                           // set accountChoice to true to end the do while loop
                           break;
                     }

               } while (!accountChoice);
               break; // break switch statement to go back to Menu

            /* If Menu is 2, the user has decided to view an existing account, case 2 will begin by prompting
               the user for the Account Number of the Account they would like to view */
            case 2:

               // Declare variable to begin do while loop

               boolean loop = false;
               char accType;
               /* Do while loop to loop the code while loop is false, ensuring that if any invalid
                  input is given, the method to obtain user input will run again until the input is valid
                */
               // Prompt user for Account Number
               System.out.println("Please enter the Account number for existing account (0 for Exit): ");
               do
               {
                     accNumber = Validation.validateIntInput();
                  // this method will validate user input and ensure it is an integer
                     String existingAccount = Integer.toString(accNumber);
                     // Convert user input to a string value to be able to check the first digit
                     accType = existingAccount.charAt(0);

                     // declare variable to store the character at index 0, to determine the type of Account
               } while (accNumber == -1);
                     // if accType = 1, let the user know it is a Personal Account and return accNumber
                     if (accType == '0'){
                        break;
                     }
                     if (accType == '1')
                     {
                        System.out.println("Personal Account");
                        existingAcc(accNumber);

                     } // if accType = 2, let the user know it is a Business Account and return accNumber
                     else if (accType == '2')
                     {
                        System.out.println("Business Account");
                        existingAcc(accNumber);
                     }
                     else{
                        System.out.println("Account cannot be found.");
                     }
                     // set loop to true to end do while loop


         }
      /* do while true ensures that the menuSystem Method will continually run whenever the user has entered
         any invalid input, stopping the program from crashing or coming to a standstill
       */
      } while (true);
   } // Menu System


   /* existingAcc Method is called when the User decides to check the details of an existing account, the user
   will be prompted to enter an Account Number that already exists and this will then be checked against all
   stored Accounts to determine if there is a valid Account to check, continuing onto a furher Menu system
    */

   public static void existingAcc(int accNumber)
   {
      // Declare variables to be used within the following loops
      boolean accountExists = false;

         int accountCheck = myArray.accNumberCheck(accNumber);
         if (accountCheck == -1){
            accountExists = false;
         }
         else {
            accountExists = true;
         }
      // If else statement to determine if there is a valid existing account following the check completed above
      if (!accountExists){
         if (accNumber == -1){
             System.out.println("Account cannot be found.");
         }
         else
         {
            System.out.println("Account " + accNumber + " cannot be found.");
         }
         totalMenu();
      } /* if no match was found the user will see a message saying it could not be found and will be brought back
         to the beginning Menu through the totalMenu() Method */
      else
      {
         System.out.println("Account " + accNumber + " found.");
         // if there was a match found the user will see a message saying it was found
         /* Do while loop to display the following Menu to the user, giving them another chance if an invalid
            amount is input, as well as being able to come back to this Menu to select different options instead
             of having to restart the program to make it back to this point */
         do
         {
            System.out.println("~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Please choose from the following options!\n");
            System.out.println("Record a new sale - 1");
            System.out.println("Make a payment to the account - 2");
            System.out.println("Display the current balance of the account - 3");
            System.out.println("Display the full details of the account - 4");
            System.out.println("Change the discount (if applicable) - 5 ");
            System.out.println("Exit Menu System - 0 ");

            // Scanners declared to take user input
            int existingMenu;
            boolean valid = false;
            // Variables to store user input and continue a do while loop
            System.out.println("Please choose an option: ");
            do
            {

               // Prompt user for an input for the Menu

               /* validateIntInput Method is used within this do while loop to validate the user input
               * to ensure that it is an integer value that has been entered, this will let the user know if they
               * have entered an invalid number  */
               existingMenu = Validation.validateIntInput();
               // If the integer was valid, the value is inserted into an If statement to check for the extreme ranges
                if ((existingMenu < 0 || existingMenu > 5) && existingMenu != -1)
               {
                  System.out.println("\nInvalid choice - Try Again: ");
               } // Error Message if integer is not within the valid range

               // Else continues if the integer was within a valid range
               else
                  {
                     valid = true; // do while condition
                     System.out.println("Thank you\n");
                     Scanner keyboard = new Scanner(System.in);
                     // Scanner to take user input

                     switch (existingMenu)
                     {  // Switch statement with the input from the previous Menu system

                        case 0:
                           totalMenu();
                           // Case 0 will run the totalMenu Method which will go to the original Menu
                        case 1:
                          // Case 1 will be used to calculate the new balance with the addition of a sale to the Account

                           // Declare variables to store the user input and check if it is valid
                           /* Do while loop to loop the code while valid is false, ensuring that if any invalid
                              input is given, the user will be given the chance to have another chance of inputting
                           */
                           System.out.println("Please enter value of Sale: ");
                           do
                           {
                              System.out.print("£ ");
                              sale = Validation.validateDoubleInput();
                              /* validateDoubleInput allows us to validate the user input without writing
                               * out the same code multiple times, this is done through a try catch block */

                              // Check the value of sale, ensuring it is above 0
                              if ((sale < 0) && (sale != -1))
                              {
                                 System.out.println("\nInvalid choice - Try Again: ");
                              } // Error message to display to the user
                              else
                              {
                                 myArray.getCurrent(accountCheck).recordSale(sale);
                                 System.out.println("New Balance - £" + String.format("%.2f", myArray.getCurrent(accountCheck).displayBalance()));
                                 valid = true;
                                 // setting valid to true will end the loop

                              }  /* if sale is not below 0, then this value can be used with the recordSale Method
                                 to record the changes in the balance for this specific account, the Balance is then
                                 displayed to the user to ensure they are aware of changes
                              */
                           } while (!valid);

                           break;   // break Switch loop going back to the Menu

                        case 2:
                        /* Case 2 is used to take money off the Balance of the Account, the user is
                           prompted for a Payment amount, which is then validated. Depending on the type of Account
                           the user is viewing, the discount will be calculated, displayed to the user and then
                           calculated as the new updated Balance
                         */
                           // Declare variables to take the user input and to allow the do while loop
                           valid = false;
                              /* Do while loop is used with the validateDoubleInput Method to try and convert the
                              user input to a double value, so that it can be stored correctly, if invalid,
                              the user will see an error message and will be prompted for a new value */
                           System.out.println("Current Balance is £ " + String.format("%.2f", myArray.getCurrent(accountCheck).displayBalance()));
                           if (myArray.getCurrent(accountCheck).displayBalance() == 0){
                              valid = true;
                              System.out.println("This requires a balance.");
                           }
                           else{
                           do
                           {

                              System.out.println("Please enter value of Payment: ");
                              // Prompt user for a value
                              System.out.print("£ ");
                              paymentAmount = Validation.validateDoubleInput();
                              // Check value to ensure the integer is larger than 0
                              if (((paymentAmount < 0) || (paymentAmount > myArray.getCurrent(accountCheck).displayBalance())) && paymentAmount != -1)
                              {
                                 System.out.println("\nPlease enter an Amount between 0 and the Current Balance");
                              } // Error message displayed to the User
                              else
                              {
                                 myArray.getCurrent(accountCheck).payment(paymentAmount);
                                 System.out.println("New Balance - £" + String.format("%.2f", myArray.getCurrent(accountCheck).displayBalance()));
                                 // If a valid integer, call the payment Method to calculate the new Balance for this Account
                                 valid = true;
                                 // valid equal to true ends the do while loop
                              }
                           } while (!valid);}

                           break;   // break Switch loop, returning to the Menu

                        case 3:
                        // Case 3 will be used to display the current balance of the Account to the user
                           System.out.println("Current Balance is: £" + String.format("%.2f", myArray.getCurrent(accountCheck).displayBalance()));
                           System.out.println("\n");
                           // Display current balance to the user
                           break; // break Switch loop, returning to the Menu

                        case 4:
                        /* Case 4 is used to display the full details of an Account to the user,
                           this is carried out by using the toString Method, which may override from the
                           BusinessAccount subclass depending on the type of Account the user is looking at
                         */
                           System.out.println("Full details of Account are as follows: \n");
                           System.out.println(myArray.getCurrent(accountCheck).toString());
                           System.out.println("\n" + "Press any key to continue: ");
                           keyboard.nextLine();
                           // Prompt the user for any key to continue and return to the Menu
                           break;

                        case 5:
                           /* Case 5 is used to change the discount value on an Account, although this is only
                              applicable to Business Accounts, so this must first be checked
                            */

                           /* Do while loop to loop the code while true, ensuring that if any invalid
                              input is given, the user will be given the chance to have another chance of inputting
                           */
                           do
                           {
                              String account = Integer.toString(myArray.getCurrent(accountCheck).getAccRefNo());
                              /* This line of code gets the Account Reference Number of the Account and then
                              converts and saves it as a String value */
                              if (account.charAt(0) == '1')
                              {
                                 System.out.println("Invalid choice - This account does not have discount. Sorry :( \n");
                                 break;

                              } /* If statement to check the first character of the Account Number, if this equals 1,
                              then we know this is a Personal Account, in which the discount does not apply */

                              // Else by default ensures the first character is a 2, which applies
                              else {
                                 // Declare variable to begin a loop
                                 valid = false;
                                 System.out.println("Current Discount is : " + myArray.getCurrent(accountCheck).getDiscount() + "%");
                                 // Output current balance

                                 do
                                 {
                                    System.out.println("Please enter updated Discount: ");
                                    // Prompt user for input

                                    /* validateDoubleInput allows us to validate the user input without writing
                                    * out the same code multiple times, this is done through a try catch block */
                                    accDiscount = Validation.validateDoubleInput();

                                    // Error message displayed
                                    // Check to ensure a valid double has been entered
                                    if (((accDiscount < 0) || (accDiscount > 100)) && accDiscount!= -1)
                                    {
                                       System.out.println("\nInvalid choice, please enter a value between 0 and 100");
                                    } // Error message displayed
                                    else
                                    {
                                     /* Once a valid discount value has been entered, continue this code by
                                       calling the setDiscount Method, the subclass will override the Superclass
                                       ensuring that the Method functions as intended
                                      */
                                       myArray.getCurrent(accountCheck).setDiscount(accDiscount);
                                       System.out.println("New Discount: " + myArray.getCurrent(accountCheck).getDiscount());
                                       // Once the new discount has been set, this will be displayed to the user
                                       valid = true;
                                       // valid equal to true will break the loop
                                       break;

                                    } // If else
                                 } while (!valid);

                                 break;

                              } // If else

                           } while (true);

                     } // Switch for existing account

                  } // If Statement
            } while (!valid);

         } while (accountExists == true);

      } // if statement

   } // existingAcc Method


   public static void totalMenu(){
      menuSystem();
   } // totalMenu Method is used to return to the first Menu in certain situations where the user has invalid input

} // Company Class