/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetanalyser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Cian
 */

//This object contains a group of words.
public class WordGroup {
    private ArrayList<Word> words = new ArrayList();
    private Date start = new Date();
    private Date end = new Date();
    
    public WordGroup(){
        
    }
    
    public WordGroup(List<FormattedTweet> t){
        this.words = TopFiveWords.getTopFive(t);
        this.start = t.get(t.size()-1).getTime();
        this.end = t.get(0).getTime();
    }
    
    public ArrayList<Word> getWords(){
        return this.words;
    }
    
    public Date getStartDate(){
        return this.start;
    }
    
    public Date getEndDate(){
        return this.end;
    }
    
    public void setWord(Word w, int index){
        this.words.set(index, w);
    }
    
    public void setWords(ArrayList<FormattedTweet> t){
        this.words = TopFiveWords.getTopFive(t);
    }
    
    public void setStartDate(Date s){
        this.start = s;
    }
    
    public void setEndDate(Date e){
        this.end = e;
    }
}
