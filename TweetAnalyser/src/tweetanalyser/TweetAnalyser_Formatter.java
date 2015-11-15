/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetanalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import twitter4j.*;

/**
 *
 * @author Cathal
 */
//Removes any "Stop words" or similar words to reduce the text of the tweet, returns an array list of "FormattedTweet" Objects which contain the reduced text and the timestamp only
public class TweetAnalyser_Formatter {
    
    private ArrayList badWords = new ArrayList();
    
    public ArrayList format(QueryResult result) throws FileNotFoundException{
        getBadWords();
        
        ArrayList tweets = new ArrayList();
        for(Status status : result.getTweets()){
            
        }
        return null;
    }
    
    private void getBadWords() throws FileNotFoundException{
        File file = new File("StopWords");
        Scanner scanner = new Scanner(file);
        
        while(scanner.hasNextLine()) {
            badWords.add(scanner.nextLine());
        }
        
    }
    
    private String deleteBadWords(String s){
        
        return null;
    }
}
