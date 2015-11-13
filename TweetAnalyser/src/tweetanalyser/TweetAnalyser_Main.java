/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetanalyser;

import twitter4j.*;
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
        
        try {
 Twitter twitter = new Twitter("username", "password");
 twitter.verifyCredentials();
 System.out.println("You're logged in!");
 java.util.List<Status> statusList = twitter.getUserTimeline();
 String s = String.valueOf(statusList.get(0).getText());
 } catch (TwitterException e) {
 
 System.out.println("Login failed");
 
 }
        
    }
    
}
