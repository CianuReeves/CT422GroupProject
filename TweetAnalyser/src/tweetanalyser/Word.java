/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetanalyser;

/**
 *
 * @author Cian
 */
public class Word {
    private String word;
    private int count;
    
    public Word(){
    }
    
    public Word(String word, int count){
        this.word = word;
        this.count = count;
    }
    
    public String getWord(){
        return word;
    }
    
    public int getCount(){
        return count;
    }
    
    public void setWord(String word){
        this.word = word;
    }
    
    public void setCount(int count){
        this.count = count;
    }
}
