package com.example.ktran.pa05;


/**
 * Class Name: Note
 *
 *
 * Methods:
 *  toString: Get string
 *  Setters/Getters
 *
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

    /**
     * method_name: toString
     *
     * @return: String
     */
    @Override
    public String toString() {
        return this.title;
    }

    /**
     * method_name: getTitle
     *
     * @return: String
     */
    public String getTitle(){
        return this.title;
    }
    /**
     * method_name: getType
     *
     * @return: String
     */
    public String getType(){
        return this.type;
    }
    /**
     * method_name: getContent
     *
     * @return: String
     */
    public String getContent(){
        return this.content;
    }

    /**
     * method_name: setTitle
     *
     */
    public void setTitle(String s){
        this.title = s;
    }
    /**
     * method_name: setContent
     *
     */
    public void setContent(String s){
        this.content = s;
    }
    /**
     * method_name: setType
     *
     */
    public void setType(String s){
        this.type = s;
    }
}
