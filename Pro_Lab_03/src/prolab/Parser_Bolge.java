package prolab;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Parser_Bolge extends Kullanici {
	
	public static Kullanici.bolge_hash parserBolge() {

	 

	    try {
	    	
	    	String desktopPath = System.getProperty("user.home") + "/Desktop";
	        String jsonFilePath = desktopPath + "/twitter_data.json";
	    	
	        // Jackson ObjectMapper olu�tur
	        ObjectMapper objectMapper = new ObjectMapper();

	        // JSON dosyas�n� oku
	        File jsonFile = new File(jsonFilePath);
	        JsonNode userArray = objectMapper.readTree(jsonFile);
	        
	        Kullanici kullanici = new Kullanici();
	        Kullanici.bolge_hash bolge2_hash = kullanici.new bolge_hash();

	        // Her bir kullan�c� i�in bilgileri i�le
	        int i=1;
	        for (JsonNode userNode : userArray) {
	            String username = userNode.get("username").asText();
	            String name = userNode.get("name").asText();
	            int followersCount = userNode.get("followers_count").asInt();
	            int followingCount = userNode.get("following_count").asInt();
	            String Dil = userNode.get("language").asText();
	            String bolge = userNode.get("region").asText();
 
                Kullanici kullanici1 = new Kullanici(username, name, Dil, bolge, followersCount, followingCount);
                bolge2_hash.bolge_hash.put(i, bolge.toString());
                i++;

	        }
	        
	        
	        return bolge2_hash;

	    } 
	    catch (IOException e) {
	         e.printStackTrace();
	         return null;
	     }
	    
		 }

}
