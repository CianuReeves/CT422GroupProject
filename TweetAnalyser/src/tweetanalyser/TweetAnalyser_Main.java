/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetanalyser;

import java.io.FileNotFoundException;
import java.util.ArrayList;
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

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setOAuthConsumerKey("qnL70f170zly7rCl73OfLIaHk");
        cb.setOAuthConsumerSecret("QVR1RnW6mK9fWyDQJSQy9lWOvpCd9RTVapM76ym5B1OTJNKMDt");
        cb.setOAuthAccessToken("4172361316-o8VJSIyiE3WBtr5gfHUziNM9UuYSwdTk2LHPkCF");
        cb.setOAuthAccessTokenSecret("5W8yCqnrnJJzNEaS6e904tbs2FvU8NEDeOqHBkB1Rjz9k");
        String q = "Fallout4";
        Twitter twitter = new TwitterFactory(cb.build()).getInstance();
        Query query = new Query("q");
        int numberOfTweets = 500;
        long lastID = Long.MAX_VALUE;
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

            } catch (TwitterException te) {
                System.out.println("Couldn't connect: " + te);
            };
            query.setMaxId(lastID - 1);
        }

        try{
            ArrayList<FormattedTweet> fTweets = TweetAnalyser_Formatter.format(tweets,q);
            for(FormattedTweet temp : fTweets){
                System.out.println(temp.getText());
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        
        /*for (int i = 0; i < tweets.size(); i++) {
            Status t = (Status) tweets.get(i);

            GeoLocation loc = t.getGeoLocation();

            String user = t.getUser().getScreenName();
            String msg = t.getText();
            String time = "";
            if (loc != null) {
                Double lat = t.getGeoLocation().getLatitude();
                Double lon = t.getGeoLocation().getLongitude();
                System.out.println(i + " USER: " + user + " wrote: " + msg + " located at " + lat + ", " + lon);
            } else {
                System.out.println(i + " USER: " + user + " wrote: " + msg);
            }
        }*/

    }

}










//-----------------------------------------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------------------------------------//

//                                                  Spare Code That Works                                                      //

//-----------------------------------------------------------------------------------------------------------------------------//
//-----------------------------------------------------------------------------------------------------------------------------//



//  try {
//           ConfigurationBuilder cb = new ConfigurationBuilder();
//           cb.setDebugEnabled(true)
//            .setOAuthConsumerKey("qnL70f170zly7rCl73OfLIaHk")
//            .setOAuthConsumerSecret("QVR1RnW6mK9fWyDQJSQy9lWOvpCd9RTVapM76ym5B1OTJNKMDt")
//            .setOAuthAccessToken("4172361316-o8VJSIyiE3WBtr5gfHUziNM9UuYSwdTk2LHPkCF")
//            .setOAuthAccessTokenSecret("5W8yCqnrnJJzNEaS6e904tbs2FvU8NEDeOqHBkB1Rjz9k");
//            TwitterFactory factory = new TwitterFactory(cb.build());
//            Twitter twitter = factory.getInstance();
//           
//            String screenName = twitter.getScreenName();
//            System.out.println(screenName + " Logged In!");

//            Query query = new Query("Fallout4");
//            query.setCount(100);
//
//            QueryResult result = twitter.search(query);
//            
//            for (Status status : result.getTweets()){
//                System.out.println(status.getCreatedAt() + " " + status.getText());
//            }
            
//            Query query2 = new Query("Fallout4");
//            query2.
//            query2.setCount(100);
//
//            QueryResult result2 = twitter.search(query2);
//            
//            for (Status status : result2.getTweets()){
//                System.out.println(status.getCreatedAt() + " " + status.getText());
//            }
            
//            Query query3 = new Query("Fallout4");
//            query3.setCount(100);
//
//            QueryResult result3 = twitter.search(query3);
//            
//            for (Status status : result3.getTweets()){
//                System.out.println(status.getCreatedAt() + " " + status.getText());
//            }
            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//  
