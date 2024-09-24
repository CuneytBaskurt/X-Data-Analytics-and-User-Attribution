,package prolab;

import java.io.File;
import java.io.IOException;

import prolab.Kullanici.t_e_hash;
import prolab.Kullanici.user;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Username {
	
	
	 public static Kullanici.user parserUsername() {
 		 
		    try {
		    	
		    	String desktopPath = System.getProperty("user.home") + "/Desktop";
		        String jsonFilePath = desktopPath + "/twitter_data.json";
		    	
		        ObjectMapper objectMapper = new ObjectMapper();

		        File jsonFile = new File(jsonFilePath);
		        JsonNode userArray = objectMapper.readTree(jsonFile);
		   
		        int i=1;
		        
		        Kullanici kullanici = new Kullanici();
		        Kullanici.user username1 = kullanici.new user();
		        for (JsonNode userNode : userArray) {

		        	String username = userNode.get("username").asText();
		            String name = userNode.get("name").asText();
		            int followersCount = userNode.get("followers_count").asInt();
		            int followingCount = userNode.get("following_count").asInt();
		            String Dil = userNode.get("language").asText();
		            String bolge = userNode.get("region").asText();
	                
	                Kullanici kullanici1 = new Kullanici(username, name, Dil, bolge, followersCount, followingCount);
	                Kullanici.user user = kullanici1.new user();
	                //user.user_hash.put(i,username);  
	                username1.user_hash.put(i, username);
		            i++;
		            
		            
		        	}
 
		        return username1;
		    } 
		    catch (IOException e) {
		         e.printStackTrace();
		     }
			return null;
		    
			 }
	
	
	
	
	
	
	

}
