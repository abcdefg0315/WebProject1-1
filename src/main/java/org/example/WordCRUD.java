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
        Scanner sc = new Scanner(System.in);
        printItem();
        System.out.print("Enter the id to edit: ");
        int id = sc.nextInt();
        WordItem item_found =findId(id);
        if(item_found == null) {
            System.out.println("Not found.");
            return -1;
        }

        System.out.println(item_found.toString());
        sc.nextLine();
        System.out.print("Enter a word >> ");
        String word =sc.nextLine();
        System.out.print("Enter a meaning >> ");
        String meaning = sc.nextLine();
        System.out.print("Enter a level of word (1~10) >> ");
        int level = sc.nextInt();
        while(!(level>0 && level<=10)){
            System.out.print("level (1~10) >>");
            level = sc.nextInt();
        }
        item_found.setWord(word);
        item_found.setLevel(level);
        item_found.setMeaning(meaning);
        System.out.println("Updated!");
        return 0;
    }

    @Override
    public int deleteItem() {
        Scanner sc = new Scanner(System.in);
        printItem();
        System.out.print("Enter the id to delete: ");
        int id = sc.nextInt();
        WordItem item_found =findId(id);
        if(item_found == null) {
            System.out.println("Not found.");
            return -1;
        }

        System.out.println(item_found.toString());
        sc.nextLine();
        System.out.print("Are you sure to delete? (y/n) >>");
        String s = sc.nextLine();
        if(s.equals("y")){
            this.list.remove(item_found);
            System.out.println("Word deleted.");
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setId(i + 1);
            }
        } else if (s.equals("n")) {
            return -1;
        } else {
            System.out.println("Wrong answer.");
            return -1;
        }
        return 0;
    }

    @Override
    public int printItem() {
        System.out.println("Total " + this.list.size() + " words");
        for (WordItem item : this.list) {
            System.out.println(item.toString());
        }
        System.out.println();
        return 0;
    }

    public void printItemByLevel() {
        System.out.println("Words with level");
        for(int i=1;i<=10;i++){
            System.out.println("level "+ i +" [");
            for (WordItem item : list) {
                if (item.getLevel() == i) {
                    System.out.println(item.toString());
                }
            }
            System.out.println("]\n");
        }
    }


    public WordItem findId(int id){
        for (WordItem item : this.list) {
            if (item.getId() == id)
                return item;
        }
        return null;
    }


    public void saveData(){
        String line = "";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\ssj49\\IdeaProjects\\WordCRUD\\data.txt");
            for (WordItem item : list) {
                line = item.getId() + "/" + item.getLevel() + "/" + item.getWord()+ "/" + item.getMeaning() + "\n";
                byte b[] = line.getBytes();
                fileOutputStream.write(b);
            }
            fileOutputStream.close();
            System.out.println("Saved!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
