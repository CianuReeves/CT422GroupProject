/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetanalyser;

import java.util.ArrayList;
import twitter4j.*;

/**
 *
 * @author Cathal
 */
//Removes any "Stop words" or similar words to reduce the text of the tweet, returns an array list of "FormattedTweet" Objects which contain the reduced text and the timestamp only
public class TweetAnalyser_Formatter {
    
    private String[] badWords = {"the","on"};
    
    public ArrayList format(QueryResult result){
        ArrayList tweets = new ArrayList();
        for(Status status : result.getTweets()){
            
        }
        return null;
    }
    
    private String deleteBadWords(String s){
        
        return null;
    }
}
