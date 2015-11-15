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
public abstract class TweetAnalyser_Formatter {
    
    private static ArrayList<String> badWords = new ArrayList();
    
    public static ArrayList<FormattedTweet> format(ArrayList<Status> result, String queryWord) throws FileNotFoundException{
        
        badWords.add(queryWord);
        getBadWords();
        ArrayList<FormattedTweet> tweets = new ArrayList();
        
        for(Status status : result){
            tweets.add(new FormattedTweet(deleteBadWords(status.getText()), status.getCreatedAt()));
        }
        return tweets;
    }
    
    private static void getBadWords() throws FileNotFoundException{
        File file = new File("C:\\Users\\Cian\\Documents\\4BCT\\CT422 Modern Information Management\\Twitter\\CT422GroupProject\\TweetAnalyser\\src\\tweetanalyser\\StopWords.txt");
        Scanner scanner = new Scanner(file);
        
        while(scanner.hasNextLine()) {
            badWords.add(scanner.nextLine());
        }
        
    }
    
    private static ArrayList deleteBadWords(String s){
        ArrayList<String> goodWords = new ArrayList();
        String[] temp = s.split(" ");
        for(String word : temp){
            for(String badWord : badWords){
                if(word.toLowerCase().equals(badWord.toLowerCase())){
                    word = "";
                }
                else if(word.length()>0 && (word.charAt(0)=='@' || word.charAt(0)=='#')){
                    word = "";
                }
            }
            if(!word.equals("")) goodWords.add(word);
        }
        
        return goodWords;
    }
}
