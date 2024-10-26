package org.example;

public class WordItem{
    private int id;
    private int level;
    private String word;
    private String meaning;

    public WordItem(int id, int level, String word, String meaning) {
        this.id = id;
        this.level = level;
        this.word = word;
        this.meaning = meaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "WordItem{" +
                "id=" + id +
                ", level=" + level +
                ", word='" + word + '\'' +
                ", meaning='" + meaning + '\'' +
                '}';
    }
}