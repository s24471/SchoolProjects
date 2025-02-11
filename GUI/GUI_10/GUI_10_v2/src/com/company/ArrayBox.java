package com.company;

public class ArrayBox <T extends Comparable> {
    private Object[] arr;
    private int index;

    public ArrayBox(int size) {
        this.arr = new Object[size];
        index = 0;
    }


    private boolean exists(T n) {
        for (int i = 0; i < index; i++) {
            if (arr[i] == n) return true;
        }
        return false;
    }

    private void expand(int n) {
        Object[] holder = new Object[arr.length + n];
        for (int i = 0; i < arr.length; i++) {
            holder[i] = arr[i];
        }
        arr = holder;
    }

    public boolean add(T n) {
        if (exists(n)) return false;
        if (index == arr.length) expand(1);
        arr[index++] = n;
        return true;
    }

    public boolean addAll(T[] n) {
        boolean check = false;
        for (int i = 0; i < n.length; i++) {
            if (add(n[i])) check = true;
        }
        return check;
    }

    private void del(int n) {
        Object[] holder = new Object[arr.length - 1];
        for (int i = 0; i < n; i++) {
            holder[i] = arr[i];
        }
        for (int i = n + 1; i < arr.length; i++) {
            holder[i - 1] = arr[i];
        }
        arr = holder;
        index--;
    }

    public boolean delete(T n) {
        if (!exists(n)) return false;
        for (int i = 0; i < index; i++) {
            if (arr[i] == n) {
                del(i);
                return true;
            }
        }
        return false;
    }

    public boolean swap(int a, int b) {
        if (a < 0 || b < 0 || a > index || b > index) return false;
        Object tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        return true;
    }

    public T min() {
        T min = (T) arr[0];
        for (int i = 0; i < index; i++) {
            T tmp = (T) arr[i];
            if (min.compareTo(tmp) > 0) min = tmp;
        }
        return min;
    }

    public T max() {
        T max = (T) arr[0];
        for (int i = 0; i < index; i++) {
            T tmp = (T) arr[i];
            if (max.compareTo(tmp) < 0) max = tmp;
        }
        return max;
    }

    public int search(T n){
        for (int i = 0; i < index; i++) {
            if(arr[i]==n)return i;
        }
        return -1;
    }

    public void print(){
        for (int i = 0; i < index-1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[index-1]);
        System.out.println();
    }

//    public void sort(){
//        boolean check = true;
//        while (check){
//            check = false;
//            for (int i = 0; i < index-1; i++) {
//                if (((T) arr[i]).compareTo(((T) arr[i + 1])) < 0) {
//                    swap(i, i + 1);
//                    check = true;
//                }
//            }
//        }
//    }
}
