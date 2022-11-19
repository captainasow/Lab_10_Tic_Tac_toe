import java.util.Scanner;

public class SafeInput
{
    /**
     * Get an integer value within a specified range from low - high
     *
     * @param pipe Scanner to use for console input
     * @param prompt String that tells the user what to input
     * @param low low value for a range low - high
     * @param high high value for a range low - high
     * @return an int within the low - high range
     */

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = low - 1;
        String trash = "";
        boolean done = false;
        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    System.out.println("You said your val is " + retVal);
                    done = true;
                } else {
                    System.out.println("You said your num is " + retVal + " but the is range should be between " + low + " and " + high);
                }

            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " is not a valid number.");
            }
        } while (!done);
        return retVal;
    }


    /**
     * Use Scanner to get an int from the console with no constraints
     *
     * @param pipe Scanner to use for console input
     * @param prompt String that tells the user what to input
     * @return an int value
     */
    public static int getInt(Scanner pipe, String prompt) {
        int retVal = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;

            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " is not a valid number.");
            }
        } while (!done);
        return retVal;
    }

    /**
     * Use Scanner to get a double from the console with no constraints
     *
     * @param pipe Scanner to use for console input
     * @param prompt String that tells the user what to input
     * @return a double value
     */
    public static double getDouble(Scanner pipe, String prompt) {
        //FavNum 1-10
        double retVal = 0;
        String trash = "";
        boolean done = false;
        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine(); //clear buffer after reading a number
                done = true;

            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " is not a valid number.");
            }
        } while (!done);
        return retVal;
    }

    /**
     * Get a double value within a specified range from low - high
     *
     * @param pipe Scanner to use for console input
     * @param prompt String that tells the user what to input
     * @param low low value for a range low - high
     * @param high high value for a range low - high
     * @return a double within the low - high range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        //FavNum 1-10
        double retVal = low - 1;
        String trash = "";
        boolean done = false;
        do {
            System.out.print(prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine(); //clear buffer after reading a number
                if (retVal >= low && retVal <= high) {
                    System.out.println("You said your val is " + retVal);
                    done = true;
                } else {
                    System.out.println("You said your fav num is " + retVal + " but the is range should be between " + low + " and " + high);
                }

            } else {
                trash = pipe.nextLine();
                System.out.println(trash + " is not a valid number.");
            }
        } while (!done);
        return retVal;
    }

    /**
     * Get an arbitrary string of at least one character length
     *
     * @param pipe Scanner to use for input
     * @param prompt Prompt Msg for use about what to input
     * @return  string to enter by user at least one character
     */
    public static String getNonZeroLength(Scanner pipe, String prompt){
        String retVal = "";
        boolean done = false;
        do {
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();
            if (retVal.length() > 0){
                done = true;

            } else {
                System.out.println("You need to enter a character.");
            }
        } while (!done);
        return retVal;
    }


    /**
     *get string that matches a regular expression pattern like ###-##-#### \d{3}-\d{2}-\d{4}
     *
     * @param pipe scanner to use for input
     * @param prompt String prompt to tell the user what to input
     * @param pattern prompt to tell the user what kind of pattern to use
     * @return a string that matches the regEx pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String pattern){
        String retVal = "";
        boolean done = false;

        do{
            System.out.println(prompt + ": ");
            retVal = pipe.nextLine();
            if (retVal.matches(pattern)){
                done = true;
            } else {
                System.out.println("What you entered does not match the pattern. " + pattern);
            }
        }while (!done);
        return retVal;
    }

    /**
     * get Y or N and return true or false
     *
     * @param pipe Scanner to use to get input
     * @param prompt String prompt for the user the yes no question
     * @return a boolean value true or false for Y or N
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt){
        String respYN = "";
        boolean retVal = false;
        boolean done = false;

        do{
            System.out.println(prompt + "[Y/N]: ");
            respYN = pipe.nextLine();
            if (respYN.equalsIgnoreCase("Y")){
                retVal = true;
                done = true;
            } else if (respYN.equalsIgnoreCase("N")){
                retVal = false;
                done = true;
            } else {
                System.out.println("You must enter [Y/N]: ");
            }
        }while (!done);
        return retVal;
    }
}
