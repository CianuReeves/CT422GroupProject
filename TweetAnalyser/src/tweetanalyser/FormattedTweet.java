/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetanalyser;
/**
 *
 * @author Cian
 */


//This object will contain the reduced text and timestamp of a tweet only
public class FormattedTweet {
    private String[] text;
    private String timestamp;
    
    
    public FormattedTweet(){
    }
    
    public FormattedTweet(String[] t, String ts){
        this.timestamp = ts;
        this.text = t;
    }
    
    public String getTime(){
        return this.timestamp;
    } 
    
    public String getText(){
        StringBuilder sb = new StringBuilder();
        for(String ts : this.text){
            sb.append(ts);
            sb.append(" ");
        }
        return sb.toString();
    }
    
    public void setTime(String t){
        this.timestamp = t;
    }
    
    public void setText(String[] t){
        this.text = t;
    }
}
