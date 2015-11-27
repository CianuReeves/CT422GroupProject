/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetanalyser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import twitter4j.*;
import twitter4j.auth.*;
import twitter4j.api.*;
import twitter4j.conf.ConfigurationBuilder;


/**
 *
 * @author Cathal
 */
public class TweetAnalyser_Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //The following is required to get information from twitter
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey("qnL70f170zly7rCl73OfLIaHk");
        cb.setOAuthConsumerSecret("QVR1RnW6mK9fWyDQJSQy9lWOvpCd9RTVapM76ym5B1OTJNKMDt");
        cb.setOAuthAccessToken("4172361316-o8VJSIyiE3WBtr5gfHUziNM9UuYSwdTk2LHPkCF");
        cb.setOAuthAccessTokenSecret("5W8yCqnrnJJzNEaS6e904tbs2FvU8NEDeOqHBkB1Rjz9k");
        Twitter twitter = new TwitterFactory(cb.build()).getInstance();
        
        String q = "RouseyVsHolm"; //our query string

        Query query = new Query(q);
        query.setLang("en"); //Makes it so we only get english tweets back
        int numberOfTweets = 1000; //Number of tweets to get
        long lastID = Long.MAX_VALUE;
        
        //The following gathers tweets
        ArrayList<Status> tweets = new ArrayList();
        while (tweets.size() < numberOfTweets) {
            if (numberOfTweets - tweets.size() > 100) {
                query.setCount(100);
            } else {
                query.setCount(numberOfTweets - tweets.size());
            }
            try {
                QueryResult result = twitter.search(query);
                tweets.addAll(result.getTweets());
                System.out.println("Gathered " + tweets.size() + " tweets");
                for (Status t : tweets) {
                    if (t.getId() < lastID) {
                        lastID = t.getId();
                    }
                }
                if(tweets.size()%100!=0 || tweets.isEmpty()) numberOfTweets=tweets.size();
            } catch (TwitterException te) {
                System.out.println("Couldn't connect: " + te);
            };
            query.setMaxId(lastID - 1);
        }
        
        //The following analyses the tweets we have gotten and gives us output
        try{
            ArrayList<FormattedTweet> fTweets = TweetAnalyser_Formatter.format(tweets,q);
            List<WordGroup> wordGroups = TweetAnalyser_Formatter.createWordGroups(fTweets);
            
            for(WordGroup wordGroup : wordGroups){
                ArrayList<Word> words = wordGroup.getWords();
                System.out.println("\nTop Five Words for Time Period: "+wordGroup.getStartDate().toString()+" - "+wordGroup.getEndDate().toString());
                for(Word word : words){
                    System.out.println(word.getWord()+" "+word.getCount());
                }
            }
               
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

}

