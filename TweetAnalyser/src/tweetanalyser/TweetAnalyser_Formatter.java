/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetanalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import twitter4j.*;

/**
 *
 * @author Cathal
 */
//Removes any "Stop words" or similar words to reduce the text of the tweet, returns an array list of "FormattedTweet" Objects which contain the reduced text and the timestamp only
public abstract class TweetAnalyser_Formatter {
    
    private static HashMap<String, ArrayList<String>> badWords = new HashMap();
    
    public static ArrayList<FormattedTweet> format(ArrayList<Status> result, String queryWord) throws FileNotFoundException{
        
        getBadWords(queryWord);
        ArrayList<FormattedTweet> tweets = new ArrayList();
        
        for(Status status : result){
            tweets.add(new FormattedTweet(deleteBadWords(status.getText()), status.getCreatedAt(), status.getId()));
        }
        return tweets;
    }
    
    private static HashMap getBadWords(String q) throws FileNotFoundException{
        File file = new File("src\\tweetanalyser\\StopWords.txt");
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            ArrayList<String> temp = new ArrayList();
            String s = scanner.nextLine().toLowerCase();
            if(badWords.containsKey(""+s.charAt(0))){
                temp = badWords.get(""+s.charAt(0));
            }
            temp.add(s);
            badWords.put(""+s.charAt(0), temp);
        }
        
        ArrayList<String> temp = new ArrayList();
        q = q.toLowerCase();
        if(badWords.containsKey(""+q.charAt(0))){
            temp = badWords.get(""+q.charAt(0));
        }
        temp.add(q);
        badWords.put(""+q.charAt(0), temp);
       
        return badWords;
        
    }
    
    private static ArrayList deleteBadWords(String s){
        ArrayList<String> goodWords = new ArrayList();
        String[] temp = s.replaceAll("[^a-zA-Z # @]", "").toLowerCase().split("\\s+");
        for(String word : temp){
            if(!word.isEmpty()){
                String key = ""+word.charAt(0);
                if(badWords.containsKey(key)){
                    for(String badWord : badWords.get(key)){
                        if(word.toLowerCase().equals(badWord)){
                            word = "";
                        }
                        else if(word.length()>0 && (word.charAt(0)=='@' || word.charAt(0)=='#' || word.charAt(0)=='\n' || word.charAt(0)==' ' || word.contains("http"))){
                            word = "";
                        }
                    }
                    if(!word.equals("")) goodWords.add(word);
                }
            } 
        }
        
        return goodWords;
    }
    
    public static List<WordGroup> createWordGroups(ArrayList<FormattedTweet> fTweets){
        List<WordGroup> wordGroups = new ArrayList<>();
        int count = (int)Math.ceil(fTweets.size()/50);
        int i = 1;
        
        while(i<=count){
            if(i*50<=fTweets.size()) wordGroups.add(new WordGroup(fTweets.subList((i-1)*50, i*50)));
            else wordGroups.add(new WordGroup(fTweets.subList((i-1)*50, fTweets.size()-1)));
            i++;
        }
        Collections.reverse(wordGroups);
        return wordGroups;
    }
    
}
