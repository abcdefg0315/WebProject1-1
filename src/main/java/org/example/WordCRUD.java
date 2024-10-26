package org.example;

import java.io.*;
import java.util.*;

public class WordCRUD implements iCRUD {
    private ArrayList<WordItem> list;

    public WordCRUD() {
        this.list = new ArrayList<WordItem>();
    }

    public void loadData() throws IOException {
        File file = new File("C:\\Users\\ssj49\\IdeaProjects\\WordCRUD\\data.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;

        while((line = br.readLine()) != null) {
            String[] lines = line.split("/");
            WordItem item = new WordItem(Integer.valueOf(lines[0]),Integer.valueOf(lines[1]),lines[2],lines[3]);
            list.add(item);
        }
        br.close();
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
        Scanner sc = new Scanner(System.in);

        System.out.println("Total " + this.list.size() + " words");
        for (WordItem item : this.list) {
            System.out.println(item.toString());
        }

        return 0;
    }
}
