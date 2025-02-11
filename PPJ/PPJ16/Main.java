package com.company;

public class Main {

    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }

        rekur(0);
        int d[]=splitToDigits(1234);
        for (int j = 0; j < d.length; j++) {
            System.out.println(d[j]);
        }
        System.out.println(isArmstrongNumber(9));
        System.out.println(isArmstrongNumber(123));
    }

    public static int rekur(int i){
        if(i>=10) return 0;
        System.out.println(i);
        i++;
        return rekur(i);
    }

    public static int[] splitToDigits(int val){
        int tmpVal=val;
        int digitCounter=0;
        while (tmpVal>0){
            digitCounter++;
            tmpVal=tmpVal/10;
        }
        int []digits=new int[digitCounter];
        int index=digitCounter-1;
        while (val>0){
            digits[index]=val%10;
            index--;
            val=val/10;
        }
        return digits;
    }

    public static boolean isArmstrongNumber(int val){
        int [] digits=splitToDigits(val);
        int sum=0;
        for (int i = 0; i < digits.length; i++) {
            sum+=Math.pow(digits[i],digits.length);
        }
        return val==sum;
    }

    public static int[][] calculateSquares(int screenWidth, int screenHeight, int side){
        int amountHorizontal=screenWidth/side, amountVertical=screenHeight/side;
        int amountSquares=amountHorizontal*amountVertical;
        int [][]squares=new int[amountSquares][2];
        int coordinateX=0,coordinateY=0;
        int index=0;
        while (coordinateY>screenHeight-side){
            while (coordinateX>screenWidth-side){
                squares[index][0]=coordinateX;
                squares[index][1]=coordinateY;
                index++;
                coordinateX+=side;
            }
            coordinateY+=side;
        }
        return squares;
    }

    public static boolean isPalindome(char[] str){
        return isPalindome(str,0,str.length-1);
    }

    public static boolean isPalindome(char[] str,int start, int end){
        if(str[start]!=str[end]) return false;
        if(start>=end) return true;
        start++;
        end--;
        return isPalindome(str,start,end);
    }

}
