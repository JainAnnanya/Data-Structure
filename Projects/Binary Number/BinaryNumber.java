
// Annanya Jain - Homework 1
// I Pledge my honor that I have abided by the Stevens Honor System
import java.util.Arrays;
import java.util.ArrayList;
public class BinaryNumber {
    //A constructor for creating a binary number of length length and consisting only of zeros.
    private int data[];
    private int length;


    public BinaryNumber(int length) {
        this.length = length;
        data = new int[length];
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds ");
        }
    }

    public BinaryNumber(String str) {
        //For creating a binary number given a string.
        length = str.length();
        data = new int[length];
        for (int i = 0; i < length; i++) {
            data[i] = Character.getNumericValue(str.charAt(i));
        }
    }

    public int getLength() {
        return length;
    }
    //For determining the length of a binary number.

    public int[] getInnerArray() {
        return data;
    }
    //returns the integer array representing the binary number.

    public int getDigit(int index) {
    //or obtaining a digit of a binary number given an index.
        if (data[index] > length) {
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds ");
        }
        return data[index];

    }

    public int toDecimal() {
        int decimal = 0;
        for (int i = 0; i < length - 1; i++) {
            decimal += (int) Math.pow(2, i) * data[i];
        }
        return decimal;
    }


    public void bitShift(int direction, int amount) {
        //transforming a binary number to its decimal notation
        if (direction != 1 && direction != -1) {
            throw new IllegalArgumentException("Not Valid");
        }

        if (amount == 0 || amount < 0) {
            throw new IllegalArgumentException("Not Valid");
        }

        int[] arrayName = new int[length];

        if (direction == -1) {
            arrayName = new int[length + amount];
            for (int i = 0; i < length; i++) {
                arrayName[i] = data[i];
            }
            data = arrayName;
            length = data.length;
        }

        if (direction == 1) {
            arrayName = new int[length - amount];
            for (int i = 0; i < arrayName.length; i++) {
                arrayName[i] = data[i+amount];
            }
            data = arrayName;
            length = data.length;

        }
    }

    public static int[] bwor( BinaryNumber bn1, BinaryNumber bn2){
        int[] arrayN = new int[bn1.length ];
        for(int i = 0; i < bn1.length; i++){
            if(bn1.data[i] == 1 ||  bn2.data[i] == 1) {
                arrayN[i] = 1;
            }
            else{
                arrayN[i] = 0;
            }
        }
        return arrayN;
    }

    public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2) {
        int[] arrayN = new int[bn1.length];
        for (int i = 0; i < bn1.length; i++) {
            if (bn1.data[i] == 1 && bn2.data[i] == 1) {
                arrayN[i] = 1;
            }
            else{
                arrayN[i] = 0;
            }
        }
        return arrayN;
    }

    public String toString(){
        String str = "";
        for(int i = 0; i < length; i++){
            str += data[i];
        }
        return str;
    }

    public void prepend(int amount){
        int[] arrayN = new int[length + amount];
        for(int i=0; i< length;i++){
            arrayN[i] = data[i];
        }
        data=arrayN;
        length = data.length;
    }

    public void add(BinaryNumber aBinaryNumber) {
        int carryon = 0;
        if (data.length < aBinaryNumber.length) {
            prepend(aBinaryNumber.length - data.length);
        }
        if (aBinaryNumber.length < data.length) {
            prepend(data.length - aBinaryNumber.length);
        }
        // prepend smaller list
        // for( int i = 0; i < length; i++){

    }


    /**public static void main(String[] args) {
        BinaryNumber a = new BinaryNumber(8);
        a.getDigit(2);
        System.out.println(a.getInnerArray());
        System.out.println(a.getLength());
        a.bitShift(1, 2);
        System.out.println(a);
    **/

    }
