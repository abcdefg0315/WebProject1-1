package org.example;

import java.io.*;
import java.util.*;

public class WordCRUD implements iCRUD {
    private ArrayList<WordItem> list;

    public WordCRUD() {
        this.list = new ArrayList<WordItem>();
    }

    @Override
    public int addItem() {
        Scanner sc = new Scanner(System.in);
        int id = list.size() + 1;  // id를 list의 현재 크기 + 1로 설정
        int level;
        String word;
        String meaning;

        System.out.print("Enter a word >> ");
        word = sc.nextLine();

        System.out.print("Enter a meaning >> ");
        meaning = sc.nextLine();

        System.out.print("Enter a level of word >> ");
        level = sc.nextInt();

        WordItem newItem = new WordItem(id, level, word, meaning);
        this.list.add(newItem);
        System.out.println("Item added with ID: " + id);
        return 0;
    }

    @Override
    public int updateItem() {
        return 0;
    }

    @Override
    public int deleteItem() {
        return 0;
    }

    @Override
    public int printItem() {
        return 0;
    }
}
