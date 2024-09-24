package prolab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ÝlgiAlaný {
	
	Scanner scanner = new Scanner(System.in);
	
	//ÝLGÝ ALANLARINI BELÝRLEME...
	
	
	
	public void BolgeÝlgiAlani()
	{
		
		Kullanici.tweet_hash tweets = Parser_Tweet.parserTweet();
		Kullanici.bolge_hash bolge = Parser_Bolge.parserBolge();
		Kullanici.user username = Username.parserUsername();
	
		//BÖLGE ADI ALINIP O BÖLGEDEKÝ KULLANICILARIN ID'SÝ KAYDEDÝLDÝ.
		int[] bolgeler = new int[10000];
		String bolgeAdi;
		System.out.println("Bir Bolge Adi Girin : ");
		bolgeAdi = scanner.nextLine();
		int sayac=1;
		for(int i=1;i<=10000;i++)
		{
			if(bolge.bolge_hash.get(i).endsWith(bolgeAdi))
			{
				bolgeler[sayac] = i;
				sayac++;
			}
		}
		
		
		System.out.println(bolgeAdi+" BOLGESÝNDEKÝ KULLANÝCÝLAR : ");
		
		for(int i=1;i<sayac;i++)
		{
			System.out.println(username.user_hash.get(bolgeler[i]));
		}
		
		
		StringBuilder birlestir = new StringBuilder();
		for(int i=1;i<sayac;i++)
		{
			birlestir.append(tweets.tweet_hash.get(bolgeler[i])).append("\n");
		}
		
		String metin = birlestir.toString();
		metin = metin.toLowerCase();
        
		HashMap<Integer, String> ilgiAlanlari = new HashMap<>();

        String[] ilgiAlanlariKelime = {
                "sanat", "bilim", "teknoloji", "spor", "müzik", "film", "edebiyat", "seyahat", "doða", "moda",
                "yemek", "fotografçýlýk", "astronomi", "tarih", "oyun", "yoga", "hobi", "dans", "hayvanlar", "bahçe",
                "psikoloji", "felsefe", "kitap", "gezi", "otomobil", "ekonomi", "arkeoloji", "bilgisayar", "saðlýk",
                "mimari", "robotik", "sinema", "mutfak", "çocuk bakýmý", "karikatür", "ekoloji", "dijital sanat",
                "çiçekçilik", "seramik", "makine mühendisliði", "balýkçýlýk", "plaj voleybolu", "nörobilim", "baharatlar",
                "seri katil psikolojisi", "uzay bilimi", "vintage arabalar", "hamur iþi yapma", "kostüm tasarýmý"
            };
        
        for (int i = 1; i <= ilgiAlanlariKelime.length; i++) {
            ilgiAlanlari.put(i, ilgiAlanlariKelime[i - 1]);
        }
        
        Map<String, Integer> enCokGecenIlgiAlanlari = new HashMap<>();
        String[] kelimeler = metin.split("\\s+");
        
        for (int i = 1; i <= ilgiAlanlari.size(); i++) {
            String ilgiAlani = ilgiAlanlari.get(i);
            int kelimeSayisi = 0;

            for (String kelime : kelimeler) {
                if (kelime.equals(ilgiAlani)) {
                    kelimeSayisi++;
                }
            }
        
            enCokGecenIlgiAlanlari.put(ilgiAlani, kelimeSayisi);
        }

            
            
            enCokGecenIlgiAlanlari.entrySet().stream()
            .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
            .limit(3)
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " kez"));
            System.out.println("KULLANÝLMÝSTÝR ÝLGÝ ALANLARÝ BUNLARDÝR");

	}
	
	public void DilÝlgiAlani()
	{
		
		Kullanici.tweet_hash tweets = Parser_Tweet.parserTweet();
		Kullanici.dil_hash dil = Parser_Dil.parserDil();
		Kullanici.user username = Username.parserUsername();
	
		//BÖLGE ADI ALINIP O BÖLGEDEKÝ KULLANICILARIN ID'SÝ KAYDEDÝLDÝ.
		int[] bolgeler = new int[10000];
		String dilAdi;
		System.out.println("Bir Dil Adi Girin : ");
		dilAdi = scanner.nextLine();
		int sayac=1;
		for(int i=1;i<=10000;i++)
		{
			if(dil.dil_hash.get(i).endsWith(dilAdi))
			{
				bolgeler[sayac] = i;
				sayac++;
			}
		}
		
		
		System.out.println(dilAdi+" DÝLÝNÝ KULLANAN KULLANÝCÝLAR : ");
		
		for(int i=1;i<sayac;i++)
		{
			System.out.println(username.user_hash.get(bolgeler[i]));
		}
		
		
		StringBuilder birlestir = new StringBuilder();
		for(int i=1;i<sayac;i++)
		{
			birlestir.append(tweets.tweet_hash.get(bolgeler[i])).append("\n");
		}
		
		String metin = birlestir.toString();
		metin = metin.toLowerCase();
        
		HashMap<Integer, String> ilgiAlanlari = new HashMap<>();

        String[] ilgiAlanlariKelime = {
                "sanat", "bilim", "teknoloji", "spor", "müzik", "film", "edebiyat", "seyahat", "doða", "moda",
                "yemek", "fotografçýlýk", "astronomi", "tarih", "oyun", "yoga", "hobi", "dans", "hayvanlar", "bahçe",
                "psikoloji", "felsefe", "kitap", "gezi", "otomobil", "ekonomi", "arkeoloji", "bilgisayar", "saðlýk",
                "mimari", "robotik", "sinema", "mutfak", "çocuk bakýmý", "karikatür", "ekoloji", "dijital sanat",
                "çiçekçilik", "seramik", "makine mühendisliði", "balýkçýlýk", "plaj voleybolu", "nörobilim", "baharatlar",
                "seri katil psikolojisi", "uzay bilimi", "vintage arabalar", "hamur iþi yapma", "kostüm tasarýmý"
            };
        
        for (int i = 1; i <= ilgiAlanlariKelime.length; i++) {
            ilgiAlanlari.put(i, ilgiAlanlariKelime[i - 1]);
        }
        
        Map<String, Integer> enCokGecenIlgiAlanlari = new HashMap<>();
        String[] kelimeler = metin.split("\\s+");
        
        for (int i = 1; i <= ilgiAlanlari.size(); i++) {
            String ilgiAlani = ilgiAlanlari.get(i);
            int kelimeSayisi = 0;

            for (String kelime : kelimeler) {
                if (kelime.equals(ilgiAlani)) {
                    kelimeSayisi++;
                }
            }
        
            enCokGecenIlgiAlanlari.put(ilgiAlani, kelimeSayisi);
        }

            
            
            enCokGecenIlgiAlanlari.entrySet().stream()
            .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
            .limit(3)
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " kez"));
            System.out.println("KULLANÝLMÝSTÝR ÝLGÝ ALANLARÝ BUNLARDÝR");
		
		
		
	}
	
	
	public void KullaniciÝlgiAlani()
	{
		
		Kullanici.tweet_hash tweets = Parser_Tweet.parserTweet();
		Kullanici.user username = Username.parserUsername();
		String[] ilgiAlanlariKelime = {
				"sanat", "bilim", "teknoloji", "spor", "müzik", "film", "edebiyat", "seyahat", "doða", "moda",
		        "yemek", "fotografçýlýk", "astronomi", "tarih", "oyun", "yoga", "hobi", "dans", "hayvanlar", "bahçe",
		        "psikoloji", "felsefe", "kitap", "gezi", "otomobil", "ekonomi", "arkeoloji", "bilgisayar", "saðlýk",
		        "mimari", "robotik", "sinema", "mutfak", "çocuk bakýmý", "karikatür", "ekoloji", "dijital sanat",
		        "çiçekçilik", "seramik", "makine mühendisliði", "balýkçýlýk", "plaj voleybolu", "nörobilim", "baharatlar",
		        "seri katil psikolojisi", "uzay bilimi", "vintage arabalar", "hamur iþi yapma", "kostüm tasarýmý",
		        "kripto para", "bitki yetiþtirme", "kahve kültürü", "anime", "gitar çalma", "koþu", "kriptografi",
		        "gökyüzü gözlemi", "kahve", "dövüþ sanatlarý", "fotoðrafçýlýk", "programlama", "bisiklet sürme",
		        "mantar toplama", "maraton koþma", "astronotluk", "moleküler gastronomi", "yemek piþirme", "baðlama çalma",
		        "jeoloji", "köpek eðitimi", "yüzme", "þarap tadýmý", "derin deniz dalýþý", "roman yazma", "sudoku çözme",
		        "gönüllü çalýþma", "geliþen teknoloji takibi", "kamp yapma", "okçuluk", "radyo programý sunma", "doða yürüyüþleri",
		        "diþ fýrçalama tekniði", "minyatür heykelcilik", "parfüm koleksiyonculuðu", "kahve demleme", "mobilya tasarýmý",
		        "uzun mesafe koþu", "güneþ gözlüðü koleksiyonu", "kaðýt uçak yapma", "tasavvuf müziði dinleme", "robot yapma",
		        "meyve bahçesi kurma", "deniz biyolojisi", "stargazing", "antik diller öðrenme", "kahve fincaný koleksiyonu"
            };
		
		System.out.println("Kullanici Adi Girin : ");
		String ad = scanner.nextLine();
		
		int bulunan=-1;
		
		 int i;
    	 for(i=1;i<=10000;i++)
    	{
    		if(ad.equals(username.user_hash.get(i)))
    		{
    			bulunan=i;
    			break;
    		}
    		
    	}
		tweets.tweet_hash.get(bulunan);
		
		 String kullaniciTweetleri = tweets.tweet_hash.get(bulunan).toLowerCase();
		
		 Map<String, Integer> ilgiAlanlariSayisi = new HashMap<>();
		 
		 for (String ilgiAlani : ilgiAlanlariKelime) {
		        int kelimeSayisi = 0;
		        String[] kelimeler = kullaniciTweetleri.split("\\s+");
		        for (String kelime : kelimeler) {
		            if (kelime.equals(ilgiAlani)) {
		                kelimeSayisi++;
		            }
		        }
		        ilgiAlanlariSayisi.put(ilgiAlani, kelimeSayisi);
		    }
		 
		 ilgiAlanlariSayisi.entrySet().stream()
         .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
         .limit(3)
         .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " kez"));
    	 
		 
		 
		
	}
	
	
	
	
	
	
	
	
	
	

}
