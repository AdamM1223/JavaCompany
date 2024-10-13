package Company;

import java.util.Scanner;

/**
 * Created by 60027330 on 16/05/2023
 * Comments about Program here
 */
public class Validation
{
   public static int menuInput;
   public static double storedDouble;

    /* this validateIntInput Method is to be used when taking the user's input when it has to be converted
   to an integer, this allows us to call the method multiple times instead of writing the same try catch block
   multiple times within the code, this method uses a public static int to allow for the values to be changed multiple
   times over, if the input cannont be converted the user will be shown an Error message and prompted for another input
    */

   public static int validateIntInput(){

      Scanner intInput = new Scanner(System.in);
      menuInput = -1;
      // Scanner declared to take user input
      try
      {
         String userInput = intInput.next();
         menuInput = Integer.parseInt(userInput);
         if (menuInput == -1){
            System.out.println("\nInvalid Input - Try Again: ");
         }

      } catch (NumberFormatException var22)
      {
         System.out.println("\nInvalid Input - Try Again: ");
      }
      return menuInput;
      // return converted Integer
   }

   /* this validateDoubleInput Method is to be used when taking the user's input when it has to be converted
to a double, like the method above this allows us to call the method multiple times instead of writing the same
try catch block multiple times within the code, this method uses a public static int to allow for the values to be
changed multiple times over, if the input cannont be converted the user will be shown an Error message and
prompted for another input */
   public static double validateDoubleInput(){

      Scanner doubleInput = new Scanner(System.in);
      storedDouble = -1;
      // Scanner declared to take user input
      try
      {
         String discount = doubleInput.nextLine();
         storedDouble = Double.parseDouble(discount);
         if (storedDouble == -1){
            System.out.println("Invalid Input - Try Again: ");
         }

      } catch (NumberFormatException e)
      {
         System.out.println("Invalid Input - Try Again: ");
      }
      return storedDouble;
      // return converted Double
   }

} //class
