package prolab;
import org.apache.commons.collections15.Transformer;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.KKLayout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Scanner;

public class Ýliski_Graf {
	
    
    public void a()
    {
   
    	 Kullanici.t_e_hash dondurMap = Parser_TakipEdilen.parserTakipEdilen();
    	 //System.out.println(dondurMap.t_e_hash.get(2));
    	 Kullanici.user username = Username.parserUsername();
    	 // System.out.println(username.user_hash.get(1));
    	 int i;
    	
    	 Scanner scanner = new Scanner(System.in);
    	 System.out.println("Kullanici Adi Giriniz:");
     	String ad = scanner.nextLine();
     	int bulunan=-1;
     	
     	 for(i=1;i<=10000;i++)
     	{
     		if(ad.equals(username.user_hash.get(i)))
     		{
     			bulunan=i;
     			break;
     		}
     		
     	}

     	
     	
    	 DirectedSparseGraph<String, String> graph = new DirectedSparseGraph<>();
    	// graph.addVertex(username.user_hash.get(bulunan));
    	 int k;
    	
    	 CustomHashMap<Integer, String> ayir = new CustomHashMap<>();
    	 int j=1;
    	 int tut=0;
    	 
    	String metin = dondurMap.t_e_hash.get(bulunan);
    	String[] satirlar = metin.split("\n");
    	
    	for ( j = 1; j < satirlar.length; j++) {
            ayir.put(j, satirlar[j-1]);
            tut++;
        }
    	 
    	 
    	 for(k=1;k<=10000;k++)
    	 {
    		 
    		 
    		 graph.addVertex(ayir.get(k));
    		 
    		 if(tut==k)
    		 {
    			 break;
    		 }
    		 
    	 } 
    	 
    	 for(k=1;k<=10000;k++)
    	 {
    		 
    		 
    		 graph.addEdge("edge"+k,username.user_hash.get(bulunan),ayir.get(k));
    		 
    		 if(tut==k)
    		 {
    			 break;
    		 }
    		 
    	 } 
    	 
    	 
    	 
    	 CircleLayout<String, String> layout = new CircleLayout<>(graph);
    	 
    	 Transformer<String, Shape> vertexSize = new Transformer<String, Shape>() {
             @Override
             public Shape transform(String vertex) {
                 // Burada node'larýn boyutunu belirleyebilirsiniz
                 // Örneðin, sabit bir boyut kullanalým
                 return new Ellipse2D.Double(-10, -10, 10, 10); // x, y, width, height
             }
         };
    	 
         Transformer<String, Paint> vertexFillPaint = new Transformer<String, Paint>() {
             @Override
             public Paint transform(String vertex) {
                 // Ýlk node için kýrmýzý, diðerleri için varsayýlan renk
                 return vertex.equals(username.user_hash.get(1)) ? Color.red : Color.BLUE;
             }
         };


         // Görselleþtirme için bir çerçeve oluþtur
         JFrame frame = new JFrame("Simple Graph Visualization");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         // Grafý görselleþtirmek için bir sunucu oluþtur
         BasicVisualizationServer<String, String> visualizationServer =
                 new BasicVisualizationServer<>(layout, new Dimension(1920, 1000));
         visualizationServer.getRenderContext().setVertexShapeTransformer(vertexSize);
         visualizationServer.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<>());
         visualizationServer.getRenderContext().setVertexFillPaintTransformer(vertexFillPaint);

         
         frame.getContentPane().add(visualizationServer);
         frame.pack();
         frame.setVisible(true);
         
         
         
    }
	
}
