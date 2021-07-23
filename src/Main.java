import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	int [] leftNumbers = {10,20,30,40};
	int [] rightNumbers= {1,2,3,4};
	char [] code ={'a','b','c','d'};
	int [] result = new int [4];


	if (args.length==0){
        for (int i = 0; i <code.length ; i++) {
            result[i] = execute(leftNumbers[i],rightNumbers[i],code[i]);

        }
    }else if  (args.length==3){
	    handleCommandLine(args);
        }
	else{
	    System.out.println("Please provide 2 numeric values  and one operation code ");
    }


        for ( int num:result
             ) {
            System.out.println(num);

        }
    }

    //take input from the user and split into arrays of string
    public static void executeInteractively(){
        System.out.println("Enter two numbers in alphabets and one operation code");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String [] words =userInput.split(" ");
        performOperation(words);


    }
    // print out the result
    public static void performOperation(String[] words) {
        int leftNumber = valueFromString(words[0]);
        int rightNumber = valueFromString(words[1]);
        int operationCode= optCodeFromString(words[2]);
        int result = execute(leftNumber,rightNumber,operationCode);
        System.out.println(result);
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

           case 'b':
               result=  leftNumbers - rightNumbers;
               break;

           case 'c':
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

   // changing the value of strings to values so that we can calculate
   public static int valueFromString(String word){
        String [] numberWords={ "zero", "one", "two", "three", "four", "five","six","seven","eight","nine", "ten"
       };

        int value=0;
        for (int i = 0; i < numberWords.length ; i++) {
            if (word.equals(numberWords[i])){
                value = i;
                break;
            }


       }


       return value;
   }
}


