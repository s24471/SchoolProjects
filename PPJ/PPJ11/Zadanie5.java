package com.company;

public class Zadanie5 {

    public static void main(String[] args) {
	    int arr1[]={1,3,5,80,6,3,78,2};
	    int arr2[]={5,6,7,8,9};

	    int arr3[]=new int[arr1.length+arr2.length];
        for (int i = 0; i < arr3.length; i++) {
            if(i<arr1.length)
                arr3[i]=arr1[i];
            else
                arr3[i]=arr2[i-arr1.length];
        }
        int elementy_tab4=0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i]==arr2[j])
                    elementy_tab4++;
            }
        }

        int tab4[]=new int[elementy_tab4];
        int index=0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(arr1[i]==arr2[j])
                    tab4[index++]=arr1[i];
            }
        }
        int min=arr3[0],max=arr3[0];
        for (int i = 0; i < arr3.length; i++) {
            if(min>arr3[i])
                min=arr3[i];
            if(max<arr3[i])
                max=arr3[i];
        }
        int elementy_tab5=max-min;
        for (int i = min; i < max; i++) {
            boolean powtorka=false;
            for (int j = 0; j < arr3.length; j++) {
                if(i==arr3[j] && !powtorka){
                    elementy_tab5--;
                    powtorka=true;
                }
            }
        }
        int tab5[]=new int[elementy_tab5];
        index=0;
        for (int i = min; i < max; i++) {
            boolean powtorka=false;
            for (int j = 0; j < arr3.length; j++) {
                if(i==arr3[j] && !powtorka){
                    powtorka=true;
                }
            }
            if(powtorka==false)
                tab5[index++]=i;
        }
        for (int i = 0; i < tab5.length; i++) {
            System.out.print(tab5[i]+" " );
        }

    }
}
