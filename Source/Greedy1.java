package sample1;
import java.io.*;
import java.util.*;
public class Greedy1
{
	public static void main (String args[])throws IOException
	{
		int[][] graph = new int[1000][1000];
		 String filepath = "C:\\Users\\avina\\Desktop\\daa\\VehicleType.txt";
		 File inFile=new File(filepath);
		  Scanner in= new Scanner(inFile);
		    Scanner sc=new Scanner(System.in);  
		int x=0, y=0, n=0;
		try
        {
	      BufferedReader  br = new BufferedReader(new FileReader(filepath));

		try {
			
	      
	      while(in.hasNextLine())	//file reading
			{
				//String[] values = line.split(",");
	    		String currentLine = in.nextLine();
				String[] c1=currentLine.split(",");
				
	        	for (String str : c1)
	        	{
	        	
	        		int a=Integer.parseInt(str);
	        		//System.out.println(a);
	        	graph[x][y]=a;
	        		
					y=y+1;
	        		
	        	}
	        	
	        	n++;
	        	y=0;
	        	x=x+1;
	        	
	        				}
	    for(x=0;x<n;x++) {
	    	  for(y=0;y<3;y++) {
	    		  System.out.println(graph[x][y]+ " ");
	    	  }
	    	  
	      }
	      
	     
        	br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
       
        }
    } 
	  catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

	}
}
