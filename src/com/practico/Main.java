package com.practico;

import java.util.Scanner;

public class Main {


    public static int counter = 0;
    public static int[] numberLast5options = new int[5];
    public static String[] nameLast5options = new String[5];
    public static String[] optionsValue = {"1.Verify sex entering the char M or F","2.Verify if the sum of an array in positions 2,3, and 4 is pair","3.Verify if an array contains at least one pair value","4.Verify if two words are equals",
            "5.Verify if the number is capicua","6.Verify A is minor than B","7.Verify if the multiplication of A * B is equals to the division of A / B","8.Verify if an array of numbers A has at least 2 numbers from an array B","9.Return the word entered in reverse way",
            "10.Return a word entered replacing the vowels with a value entered","11.Show the number of the last 5 exercises executed","12.Print the last 5 exercises"};


    public static void main(String[] args) {
        executeProgram();
    }

    public static void executeProgram(){
        int option = printMenu();
        executeOption(option);
    }


    public static int printMenu(){
        System.out.println("Welcome to the options menu: ");
        for(int i=0;i<optionsValue.length;i++){
            System.out.println(optionsValue[i]);
        }
        System.out.println("Exnter 13 to exit!!!");
        System.out.println("Please select an option: ");
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static void update5lastOptions(int option){
        int[] temp1= new int[5];
        String[] temp2= new String[5];
        if(counter>4){
            temp1 = numberLast5options;
            temp2 = nameLast5options;
            for(int i=0;i<4;i++){
                numberLast5options[i] = temp1[i+1];
                nameLast5options[i] = temp2[i+1];
            }
            numberLast5options[4]=option;
            nameLast5options[4]=optionsValue[option-1];
        }else{
            numberLast5options[counter]=option;
            nameLast5options[counter]=optionsValue[option-1];
        }
        counter++;
    }

    public static void printNumberOfLast5Options(){
        System.out.println("Number of last 5 options selected:");
        for(int i=0;i<numberLast5options.length;i++){
            System.out.println("Option: "+ numberLast5options[i]);
        }
    }

    public static void printNameOfLast5Options(){
        System.out.println("Name of last 5 options selected:");
        for(int i=0;i<nameLast5options.length;i++){
            System.out.println("Option: "+ nameLast5options[i]);
        }
    }

    public static void executeOption(int option){
        int[] values = new int[5];
        int[] valuesA = new int[5];
        int[] valuesB = new int[5];
        Scanner in = new Scanner(System.in);
        boolean conti = true;
        if(option<13){
            System.out.println("You selected the option "+ optionsValue[option-1]);
            update5lastOptions(option);
        }
        switch (option){
            case 1:
                System.out.println("Enter M or F: ");
                String sexSelected = in.next();
                verifySex(String.valueOf(sexSelected).charAt(0));
                break;
            case 2:
                for(int i=0;i<5;i++){
                    System.out.println("Enter one number: ");
                    values[i] = in.nextInt();
                }
                verifyAdditionIsPair(values);
                break;
            case 3:
                for(int i=0;i<5;i++){
                    System.out.println("Enter one number: ");
                    values[i] = in.nextInt();
                }
                verifyArrayContainsValuePair(values);
                break;
            case 4:
                System.out.println("Enter the first word: ");
                String firstWord = in.next();
                System.out.println("Enter the second: ");
                String secondWord = in .next();
                verifyWordsAreEquals(firstWord,secondWord);
                break;
            case 5:
                System.out.println("Enter one number: ");
                int number  = in.nextInt();
                verifyIsCapicua(number);
                break;
            case 6:
                System.out.println("Enter number A: ");
                int numberA  = in.nextInt();
                System.out.println("Enter number B: ");
                int numberB  = in.nextInt();
                verifyAminorThanB(numberA,numberB);
                break;
            case 7:
                System.out.println("Enter number A: ");
                numberA  = in.nextInt();
                System.out.println("Enter number B: ");
                numberB  = in.nextInt();
                verifyAtimesBEqualsAbetweenB(numberA,numberB);
                break;
            case 8:
                System.out.println("Enter values for array A: ");
                for(int i=0;i<5;i++){
                    System.out.println("Enter one number: ");
                    valuesA[i] = in.nextInt();
                }
                System.out.println("Enter values for array B: ");
                for(int i=0;i<5;i++){
                    System.out.println("Enter one number: ");
                    valuesB[i] = in.nextInt();
                }
                verifyAhasValuesFromB(valuesA,valuesB);
                break;
            case 9:
                System.out.println("Enter a word: ");
                String word = in.next();
                returnWordReversed(word);
                break;
            case 10:
                System.out.println("Enter a word: ");
                word = in.next();
                System.out.println("Enter a letter to set in the vowels: ");
                String letter = in.next();
                replaceVowelsWithLetter(word,letter);
                break;
            case 11:
                printNumberOfLast5Options();
                break;
            case 12:
                printNameOfLast5Options();
                break;
            case 13:
                System.out.println("See you next time!!!");
                conti = false;
                break;
            default:
                System.out.println("The option is not valid, try again...");
                break;
        }
        if(conti){
            executeProgram();
        }
    }

    public static void replaceVowelsWithLetter(String word, String let){
        String replaceString=word.replace('a',let.charAt(0));
        replaceString=replaceString.replace('A',let.charAt(0));
        replaceString=replaceString.replace('e',let.charAt(0));
        replaceString=replaceString.replace('E',let.charAt(0));
        replaceString=replaceString.replace('i',let.charAt(0));
        replaceString=replaceString.replace('I',let.charAt(0));
        replaceString=replaceString.replace('o',let.charAt(0));
        replaceString=replaceString.replace('O',let.charAt(0));
        replaceString=replaceString.replace('u',let.charAt(0));
        replaceString=replaceString.replace('U',let.charAt(0));
        System.out.println("The word replaeced is: " + replaceString );
    }

    public static void returnWordReversed(String word){
        StringBuilder strb = new StringBuilder(word);
        String str = strb.reverse().toString();
        System.out.println("The reversed word is: ");
        System.out.println(str);
    }

    public static void verifyAhasValuesFromB(int[] valsA, int[] valsB){
        int times = 0;
        for(int i=0;i<valsA.length;i++){
            int val = valsB[i];
            for(int j=0;j<valsA.length;j++){
                if(valsA[j]==val){
                    times++;
                }
            }
        }
        if(times>=2){
            System.out.println("True: array A contains at least 2 values from array B");
        }else{
            System.out.println("False: array A doesn't contain at least 2 values from array B");
        }
    }

    public static void verifyAtimesBEqualsAbetweenB(int numA, int numB){
        int multi = numA * numB;
        int div = numA / numB;
        if(multi == div){
            System.out.println("True: A * B is equuals to A / B");
        }else{
            System.out.println("False: A * B is not equuals to A / B");
        }
    }

    public static void verifyAminorThanB(int numA, int numB){
        if(numA < numB){
            System.out.println("True: A is minor than B");
        }else{
            System.out.println("False: A is not minor than B");
        }
    }

    public static void verifyIsCapicua(int number){
        String num = String.valueOf(number);
        int numLength =num.length();
        for(int i=0;i<numLength;i++){
            if(num.charAt(i)==num.charAt(numLength-1-i)){
                if(i==numLength-1){
                    System.out.println("True: the number is capicua");
                }
            }else{
                System.out.println("False: the number is not capicua");
                break;
            }
        }
    }

    public static void verifyWordsAreEquals(String word1, String word2){
        if(word1.equals(word2))
            System.out.println("True: the words are equals");
        else
            System.out.println("False: the words are not equals");
    }

    public static void verifyArrayContainsValuePair(int[] values){
        System.out.println("You entered the next values:");
        for(int i=0;i<values.length;i++){
            System.out.println("Value "+ (i+1) +" : "+values[i]);
        }
        for(int i=0;i<values.length;i++){
            if(values[i]%2 == 0){
                System.out.println("The result is true because the array has at least one pair value");
                break;
            }else{
                if(i==values.length-1)
                    System.out.println("The result is false because the array hasn't at least one pair value");
            }
        }

    }

    public static void verifyAdditionIsPair(int[] values){
        int sum = values[1]+values[2]+values[3];
        System.out.println("You entered the next values:");
        for(int i=0;i<values.length;i++){
            System.out.println("Value "+ (i+1) +" : "+values[i]);
        }
        if(sum%2 == 0){
            System.out.println("True: the sum of numbers in positions 2,3 and 4 is pair");
        }else{
            System.out.println("False: the sum of numbers in positions 2,3 and 4 is not pair");
        }
    }

    public static void verifySex(char sex){
        boolean value = false;
        do{
            if(sex=='F' || sex=='f'){
                value = true;
                break;
            }else if(sex=='M' || sex=='m'){
                value = false;
                break;
            }else{
                System.out.println("Try again... Enter F or M:");
                Scanner in = new Scanner(System.in);
                String sexSelected = in.next();
                sex = sexSelected.charAt(0);
            }
        }while(true);
        System.out.println("The value for the sex "+String.valueOf(sex)+" is: "+value);
    }

}
