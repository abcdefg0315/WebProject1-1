package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main pStudio = new Main();
        pStudio.J101();
    }

    public void printMenu(){
        System.out.print("[Menu] 1. List  2. List(level)  3. Search  4.Add  5.Modify  6.Delete  7.Save file 0.Exit >> ");
    }

    public void J101(){
        Scanner sc = new Scanner(System.in);
        WordCRUD manager = new WordCRUD();
        boolean quit = false;
        do{
            printMenu();
            int menu = sc.nextInt();
            switch (menu){
                case 0:
                    quit = true;
                    break;

                case 1:
                    manager.printItem();
                    break;

                case 4:
                    manager.addItem();
                    break;

                default:
                    System.out.println("Wrong number.\n");
                    break;
            }
        }while(!quit);
    }
}
