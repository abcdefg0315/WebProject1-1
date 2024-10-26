package org.example;

import java.io.IOException;
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
        try {
            manager.loadData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        boolean quit = false;
        do{
            printMenu();
            int menu = sc.nextInt();
            switch (menu){
                case 0:
                    System.out.println("Good bye!");
                    quit = true;
                    break;

                case 1:
                    manager.printItem();
                    break;

                case 2:
                    manager.printItemByLevel();
                    break;

                case 4:
                    manager.addItem();
                    break;

                case 5:
                    manager.updateItem();
                    break;

                case 6:
                    manager.deleteItem();
                    break;

                case 7:
                    manager.saveData();
                    break;

                default:
                    System.out.println("Wrong number.\n");
                    break;
            }
        }while(!quit);
    }
}
