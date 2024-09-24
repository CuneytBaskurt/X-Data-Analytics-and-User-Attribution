package prolab;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import prolab.Kullanici.t_e_hash;
import prolab.Kullanici.tweet_hash;
import prolab.Kullanici.user;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser_Tweet extends Kullanici {
	
	 public static Kullanici.tweet_hash parserTweet() {
		 

		    try {
		    	
		    	String desktopPath = System.getProperty("user.home") + "/Desktop";
		        String jsonFilePath = desktopPath + "/twitter_data.json";
		    	
		        // Jackson ObjectMapper olu�tur
		        ObjectMapper objectMapper = new ObjectMapper();

		        // JSON dosyas�n� oku
		        File jsonFile = new File(jsonFilePath);
		        JsonNode userArray = objectMapper.readTree(jsonFile);

		        Kullanici kullanici = new Kullanici();
		        Kullanici.tweet_hash tweet_hash2 = kullanici.new tweet_hash();
		        
		        int i=1;
		        // Her bir kullan�c� i�in bilgileri i�le
		        for (JsonNode userNode : userArray) {
		        	
		        	StringBuilder birlestir = new StringBuilder();
		        	
		            String username = userNode.get("username").asText();
		            String name = userNode.get("name").asText();
		            int followersCount = userNode.get("followers_count").asInt();
		            int followingCount = userNode.get("following_count").asInt();
		            String Dil = userNode.get("language").asText();
		            String bolge = userNode.get("region").asText();

		            Kullanici kullanici1 = new Kullanici(username, name, Dil, bolge, followersCount, followingCount);
	                Kullanici.user user = kullanici.new user();
	                user.user_hash.put(i,username);
	                
		            JsonNode tweetsArray = userNode.get("tweets");
		            if (tweetsArray.isArray()) {
		               
		                for (JsonNode tweetNode : tweetsArray) {
		                	birlestir.append(tweetNode).append("\n");
		                    
		                }
		               
		            }          

		            tweet_hash2.tweet_hash.put(i, birlestir.toString());
	                i++;
	            
	            birlestir.setLength(0);
		        }
		        
		        

		        return tweet_hash2;
		    } 
		    catch (IOException e) {
		         e.printStackTrace();
		         return null;
		     }
		    
			 }

}
