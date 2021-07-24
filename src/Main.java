import javafx.util.Builder;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static int [] leftNumbers = {10,20,30,40};
    static  int [] rightNumbers= {1,2,3,4};
    static char [] code ={'a','s','m','/'};
    static int [] result = new int [4];
    public static void main(String[] args) {


	if (args.length==0){
        for (int i = 0; i <code.length ; i++) {
            result[i] = execute(leftNumbers[i],rightNumbers[i],code[i]);
            printResultList(result);

        }
    }else if  (args.length==3){
	    handleCommandLine(args);
        }
	else if (args.length==1 && args[0].equalsIgnoreCase("interactive") ) {
        executeInteractively();
        }
	else{
	    System.out.println("Please provide 2 numeric values  and one operation code ");
    }

    }


    // print out the result
    public static void performOperation(String[] words) {
        char operationCode = optCodeFromString(words[2]);
        if (operationCode == 'w'){
            handleWhen(words);
        }else {
            int leftNumber = valueFromString(words[0]);
            int rightNumber = valueFromString(words[1]);
            int result = execute(leftNumber, rightNumber, operationCode);
            displayResult(leftNumber, rightNumber, operationCode, result);
        }

    }

    private static void handleWhen(String[] words) {
        LocalDate startDate = LocalDate.parse(words[0]);
        long daysToAdd = valueFromString(words[1]);
        LocalDate newDate = startDate.plusDays(daysToAdd);
        String output  = String.format("%s plus %o %s",startDate, daysToAdd, newDate);

        System.out.print(output);


    }

    private static void displayResult(int leftNumber, int rightNumber, char  operationCode, int result) {
        char symbol = symbolFromOptCode(operationCode);
//        StringBuilder builder = new StringBuilder();
//        builder.append(leftNumber);
//        builder.append(" ");
//        builder.append(symbol);
//        builder.append(" ");
//        builder.append(rightNumber);
//        builder.append(" ");
//        builder.append("= ");
//        builder.append(" ");
//        builder.append(result);

        String output = String.format("%o %c %o = %o",leftNumber,symbol,rightNumber,result);
        System.out.println(output);


    }







    //take input from the user and split into arrays of string
    public static void executeInteractively(){
        System.out.println("Enter two numbers in alphabets and one operation code");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String [] words =userInput.split(" ");
        performOperation(words);


    }


    private static void handleCommandLine(String[] args) {
        int leftNumbers = Integer.parseInt(args[0]);
        int rightNumbers= Integer.parseInt(args[1]);
        char code = args[3].charAt(3);

    }

    public static int execute(int leftNumbers,int rightNumbers,int code){
        int result;
       switch (code){
           case 'a':
               result=  leftNumbers + rightNumbers;
               break;

           case 's':
               result=  leftNumbers - rightNumbers;
               break;

           case 'm':
               result= leftNumbers * rightNumbers;
               break;

           case 'd':
               result=  leftNumbers / rightNumbers;
               break;

           default:
               throw new IllegalStateException("Unexpected value: " + code);
       }
       return result;
   }


   //returning the operation's first character
   public static char optCodeFromString(String operationName){
        char optCode = operationName.charAt(0);
        return optCode;
   }

    private static char symbolFromOptCode(char operationCode){
        char [] optcodes={'a','s','m','d'};
        char [] symbols ={'+','-','*','/'};
        char symbol=' ';
        for (int i = 0; i <optcodes.length ; i++) {
            if (optcodes[i] == operationCode){
                symbol = symbols[i];
                break;
            }

        }


        return symbol;
    }

   // changing the value of strings to values so that we can calculate
   public static int valueFromString(String word){
        String [] numberWords={ "zero", "one", "two", "three", "four", "five","six","seven","eight","nine", "ten"
       };

        int value= -1;
        for (int i = 0; i < numberWords.length ; i++) {
            if (word.contains(numberWords[i])){
                value = i;
                break;
            }


       }

       if (value == -1){
           value = Integer.parseInt(word);
       }


       return value;
   }

    public static void  printResultList(int [] result){
        for ( int num:result
        ) {
            System.out.println(num);

        }
    }
}


