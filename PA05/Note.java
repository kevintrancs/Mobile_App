package com.example.ktran.pa05;

/**
 * Created by ktran on 10/23/17.
 */

public class Note {

    String title;
    String type;
    String content;

    public Note(String title, String type, String content){
        this.title = title;
        this.type = type;
        this.content = content;

    }

    @Override
    public String toString() {
        return this.title;
    }

    public String getTitle(){
        return this.title;
    }
    public String getType(){
        return this.type;
    }
    public String getContent(){
        return this.content;
    }
}
