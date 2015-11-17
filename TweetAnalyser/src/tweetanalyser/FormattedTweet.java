/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tweetanalyser;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Cian
 */


//This object will contain the reduced text and timestamp of a tweet only
public class FormattedTweet {
    private ArrayList<String> text;
    private Date timestamp;
    private long id;
    
    
    public FormattedTweet(){
    }
    
    public FormattedTweet(ArrayList<String> t, Date ts, long id){
        this.timestamp = ts;
        this.text = t;
        this.id = id;
    }
    
    public Date getTime(){
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
    
    public long getId(){
        return this.id;
    }
    
    public void setTime(Date t){
        this.timestamp = t;
    }
    
    public void setText(ArrayList<String> t){
        this.text = t;
    }
    
    public void setId(long id){
        this.id = id;
    }
}
