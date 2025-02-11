package com.company;

public class Main {

    public static void main(String[] args) {
        int x[] = new int[10];
        int y[] = new int[10];
        for (int i = 0; i < x.length; i++) {
            x[i] = (int) (Math.random() * 90);
            y[i] = (int) (Math.random() * 90);
        }

        int maxX = x[0], minX = x[0], maxY = y[0], minY = y[0];

        for (int i = 0; i < x.length; i++) {
            if (maxX < x[i])
                maxX = x[i];
            if (minX > x[i])
                minX = x[i];

            if (maxY < y[i])
                maxY = y[i];
            if (minY > y[i])
                minY = y[i];
        }
        int lenX = maxX - minX;
        int lenY = maxY - minY;
        int srX = maxX - (lenX / 2);
        int srY = maxY - (lenY / 2);


        int A[] = {1, 3, 4, 6, 8, 12};
        int B[] = {13, 12, 11, 7, 4, 2, 1};
        int C[] = new int[A.length + B.length];
        int indexA = 0, indexB = B.length - 1;
        for (int i = 0; i < C.length; i++) {
            if (indexA < A.length && indexB >= 0) {
                if (A[indexA] < B[indexB]) {
                    C[i] = A[indexA];
                    indexA++;
                } else {
                    C[i] = B[indexB];
                    indexB--;
                }
            } else if (indexB >= 0) {
                C[i] = B[indexB];
                indexB--;
            } else {
                C[i] = A[indexA];
                indexA++;
            }
        }

        int tab[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        int UpToWrite=0, DownToWrite=tab.length-1;
        int RithtToWrite=tab[0].length-1, LeftToWrite=0;
        for (int i = UpToWrite; i <= RithtToWrite; i++) {
            System.out.print(tab[UpToWrite][i]);
        }
        UpToWrite++;
        for (int i = UpToWrite; i < DownToWrite; i++) {
            System.out.print(tab[i][RithtToWrite]);
        }
        RithtToWrite--;
    }
}
