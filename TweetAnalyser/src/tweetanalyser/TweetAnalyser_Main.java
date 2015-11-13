/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetanalyser;

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
        // TODO code application logic here
        
        Twitter twitter = null;
        
  try {
           ConfigurationBuilder cb = new ConfigurationBuilder();
           cb.setDebugEnabled(true)
            .setOAuthConsumerKey("qnL70f170zly7rCl73OfLIaHk")
            .setOAuthConsumerSecret("QVR1RnW6mK9fWyDQJSQy9lWOvpCd9RTVapM76ym5B1OTJNKMDt")
            .setOAuthAccessToken("4172361316-o8VJSIyiE3WBtr5gfHUziNM9UuYSwdTk2LHPkCF")
            .setOAuthAccessTokenSecret("5W8yCqnrnJJzNEaS6e904tbs2FvU8NEDeOqHBkB1Rjz9k");
            TwitterFactory factory = new TwitterFactory(cb.build());
            twitter = factory.getInstance();
           
            String screenName = twitter.getScreenName();
            System.out.println(screenName + " Logged In!");

            Query query = new Query("Fallout4");
            QueryResult result = twitter.search(query);
            
            for (Status status : result.getTweets()){
                System.out.println(status.getCreatedAt() + " " + status.getText() + " " + status.getId());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
  
    }
  
        
    
}
