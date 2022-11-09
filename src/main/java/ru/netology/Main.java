package ru.netology;

public class Main {
    public static void main(String[] args) {
        BinOps bins = new BinOps();
        //демонстрация
        System.out.println(bins.sum("1100", "1101"));
        System.out.println(bins.mult("0101", "0111"));
    }
}