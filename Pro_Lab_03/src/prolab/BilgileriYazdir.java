package prolab;

import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BilgileriYazdir {
	
	public void Yazdir() throws IOException
	{
		
		String masaustuYolu = System.getProperty("user.home") + "/Desktop/"; 
		String dosyaAdi = "yeniDosya.txt";
        String dosyaYolu = masaustuYolu + dosyaAdi;
        
        File dosya = new File(dosyaYolu);
		
		try{
			
		
		Scanner scanner = new Scanner(System.in);
    	System.out.println("Kullanici Adi Giriniz:");
    	String ad = scanner.nextLine();
    	int bulunan=-1;
    	
    	BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(dosya));

    	
    	 

    	
    	Kullanici.user username = Username.parserUsername();
    	 
    	 int i;
    	 for(i=1;i<=10000;i++)
    	{
    		if(ad.equals(username.user_hash.get(i)))
    		{
    			bulunan=i;
    			break;
    		}
    		
    	}
    	 
    	 bufferedWriter.write("Kullanici Adi : "+username.user_hash.get(i));
    	 
    	 Kullanici.bolge_hash dondurBolge = Parser_Bolge.parserBolge();
    	 bufferedWriter.write("\nKullanicinin Bolgesi : "+dondurBolge.bolge_hash.get(i));
    	 
    	 Kullanici.dil_hash dondurDil = Parser_Dil.parserDil();
    	 bufferedWriter.write("\nKullanicinin Dili : "+dondurDil.dil_hash.get(i));
    	 
    	 Kullanici.t_e_hash dondurT_E = Parser_TakipEdilen.parserTakipEdilen();
    	 bufferedWriter.write("\nKullanicinin Takip Ettigi Kisiler : \n"+dondurT_E.t_e_hash.get(i));
    	 
    	 Kullanici.tak_hash dondurTak = Parser_Takipci.parserTakipci();
    	 bufferedWriter.write("\nKullanicinin Takipcileri : \n"+dondurTak.tak_hash.get(i));
    	 
    	 Kullanici.tweet_hash dondurTweet = Parser_Tweet.parserTweet();
    	 bufferedWriter.write("\nKullanicinin Tweetleri : \n"+dondurTweet.tweet_hash.get(i));
    	 
    	 
    	 bufferedWriter.close();
        
         System.out.println("Dosya oluþturuldu ve yazý eklendi.");
		}
		
		catch (IOException e) {
            e.printStackTrace();
        }
    	
	}

}
