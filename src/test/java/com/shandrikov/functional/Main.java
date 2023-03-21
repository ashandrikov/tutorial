package com.shandrikov.functional;

public class Main {
    public static void main(String[] args) {
        printIt(s -> "meow" + s);
    }

    static void printIt(Printable smth) {
        smth.print("!");
    }
}

