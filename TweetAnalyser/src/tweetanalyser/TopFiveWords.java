/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetanalyser;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cian
 */
public abstract class TopFiveWords {
    public static ArrayList<Word> getTopFive(List<FormattedTweet> tweets){
        ArrayList<Word> words = new ArrayList();
        ArrayList<Word> topWords = new ArrayList();
        
        for(FormattedTweet tweet : tweets){
            String[] word = tweet.getText().split(" ");
            for(String w : word){
                Boolean add = true;
                for(Word tweetWord : words){
                    if(tweetWord.getWord().equals(w)){
                        tweetWord.setCount(tweetWord.getCount()+1);
                        add = false;
                        break;
                    }
                }
                if(add) words.add(new Word(w, 1));
            }
        }
        
        for(Word word : words){
            int size = 0;
            if(topWords.size()<5) size = topWords.size();
            else size = 5;
            
            if(size == 0) {
                topWords.add(word);
                continue;
            }
                
            for(int i = 0; i<size; i++){
                if(size<5 && i==size-1) topWords.add(word);
                else if(word.getCount()>topWords.get(i).getCount()){
                    Word temp = topWords.get(i);
                    topWords.set(i, word);
                    word = temp;
                }
            }
        }
        return topWords;
    }
}
