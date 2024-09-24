package prolab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class �lgiAlan� {
	
	Scanner scanner = new Scanner(System.in);
	
	//�LG� ALANLARINI BEL�RLEME...
	
	
	
	public void Bolge�lgiAlani()
	{
		
		Kullanici.tweet_hash tweets = Parser_Tweet.parserTweet();
		Kullanici.bolge_hash bolge = Parser_Bolge.parserBolge();
		Kullanici.user username = Username.parserUsername();
	
		//B�LGE ADI ALINIP O B�LGEDEK� KULLANICILARIN ID'S� KAYDED�LD�.
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
		
		
		System.out.println(bolgeAdi+" BOLGES�NDEK� KULLAN�C�LAR : ");
		
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
                "sanat", "bilim", "teknoloji", "spor", "m�zik", "film", "edebiyat", "seyahat", "do�a", "moda",
                "yemek", "fotograf��l�k", "astronomi", "tarih", "oyun", "yoga", "hobi", "dans", "hayvanlar", "bah�e",
                "psikoloji", "felsefe", "kitap", "gezi", "otomobil", "ekonomi", "arkeoloji", "bilgisayar", "sa�l�k",
                "mimari", "robotik", "sinema", "mutfak", "�ocuk bak�m�", "karikat�r", "ekoloji", "dijital sanat",
                "�i�ek�ilik", "seramik", "makine m�hendisli�i", "bal�k��l�k", "plaj voleybolu", "n�robilim", "baharatlar",
                "seri katil psikolojisi", "uzay bilimi", "vintage arabalar", "hamur i�i yapma", "kost�m tasar�m�"
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
            System.out.println("KULLAN�LM�ST�R �LG� ALANLAR� BUNLARD�R");

	}
	
	public void Dil�lgiAlani()
	{
		
		Kullanici.tweet_hash tweets = Parser_Tweet.parserTweet();
		Kullanici.dil_hash dil = Parser_Dil.parserDil();
		Kullanici.user username = Username.parserUsername();
	
		//B�LGE ADI ALINIP O B�LGEDEK� KULLANICILARIN ID'S� KAYDED�LD�.
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
		
		
		System.out.println(dilAdi+" D�L�N� KULLANAN KULLAN�C�LAR : ");
		
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
                "sanat", "bilim", "teknoloji", "spor", "m�zik", "film", "edebiyat", "seyahat", "do�a", "moda",
                "yemek", "fotograf��l�k", "astronomi", "tarih", "oyun", "yoga", "hobi", "dans", "hayvanlar", "bah�e",
                "psikoloji", "felsefe", "kitap", "gezi", "otomobil", "ekonomi", "arkeoloji", "bilgisayar", "sa�l�k",
                "mimari", "robotik", "sinema", "mutfak", "�ocuk bak�m�", "karikat�r", "ekoloji", "dijital sanat",
                "�i�ek�ilik", "seramik", "makine m�hendisli�i", "bal�k��l�k", "plaj voleybolu", "n�robilim", "baharatlar",
                "seri katil psikolojisi", "uzay bilimi", "vintage arabalar", "hamur i�i yapma", "kost�m tasar�m�"
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
            System.out.println("KULLAN�LM�ST�R �LG� ALANLAR� BUNLARD�R");
		
		
		
	}
	
	
	public void Kullanici�lgiAlani()
	{
		
		Kullanici.tweet_hash tweets = Parser_Tweet.parserTweet();
		Kullanici.user username = Username.parserUsername();
		String[] ilgiAlanlariKelime = {
				"sanat", "bilim", "teknoloji", "spor", "m�zik", "film", "edebiyat", "seyahat", "do�a", "moda",
		        "yemek", "fotograf��l�k", "astronomi", "tarih", "oyun", "yoga", "hobi", "dans", "hayvanlar", "bah�e",
		        "psikoloji", "felsefe", "kitap", "gezi", "otomobil", "ekonomi", "arkeoloji", "bilgisayar", "sa�l�k",
		        "mimari", "robotik", "sinema", "mutfak", "�ocuk bak�m�", "karikat�r", "ekoloji", "dijital sanat",
		        "�i�ek�ilik", "seramik", "makine m�hendisli�i", "bal�k��l�k", "plaj voleybolu", "n�robilim", "baharatlar",
		        "seri katil psikolojisi", "uzay bilimi", "vintage arabalar", "hamur i�i yapma", "kost�m tasar�m�",
		        "kripto para", "bitki yeti�tirme", "kahve k�lt�r�", "anime", "gitar �alma", "ko�u", "kriptografi",
		        "g�ky�z� g�zlemi", "kahve", "d�v�� sanatlar�", "foto�raf��l�k", "programlama", "bisiklet s�rme",
		        "mantar toplama", "maraton ko�ma", "astronotluk", "molek�ler gastronomi", "yemek pi�irme", "ba�lama �alma",
		        "jeoloji", "k�pek e�itimi", "y�zme", "�arap tad�m�", "derin deniz dal���", "roman yazma", "sudoku ��zme",
		        "g�n�ll� �al��ma", "geli�en teknoloji takibi", "kamp yapma", "ok�uluk", "radyo program� sunma", "do�a y�r�y��leri",
		        "di� f�r�alama tekni�i", "minyat�r heykelcilik", "parf�m koleksiyonculu�u", "kahve demleme", "mobilya tasar�m�",
		        "uzun mesafe ko�u", "g�ne� g�zl��� koleksiyonu", "ka��t u�ak yapma", "tasavvuf m�zi�i dinleme", "robot yapma",
		        "meyve bah�esi kurma", "deniz biyolojisi", "stargazing", "antik diller ��renme", "kahve fincan� koleksiyonu"
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
