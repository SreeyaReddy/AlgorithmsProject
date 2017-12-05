package sample1;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Graph {
	
	private  ArrayList<ArrayList<int[]>> vertices; 
	private static  ArrayList<ArrayList<int[]>> listitems; 
	private HashSet<Integer> explored; // nodes that have been explored
	static int zipcode,zipcodef,source,destination,s=0,zipcode1,countincr=0, countincr1=0, vtype=0,n=0, index=0;
	static int[][] abcd = new int[1000][1000];
	    static String filepath = "C:\\Users\\avina\\Desktop\\daa\\VehicleType.txt";
	    double count = 0,countBuffer=0,countLine=0;
	    String lineNumber = "";
	    static BufferedReader br;
	    static String line = "";
        static File inFile=new File(filepath);
	    
	// A utility function to find the vertex with minimum distance value,
		// from the set of vertices not yet included in shortest path tree
	static final int V=9;
	int minDistance(int dist[], Boolean sptSet[])
	{
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index=-1;

		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min)
			{
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

		// A utility function to print the constructed distance array
	int printSolution(int dist[], int n, int vtype) throws IOException
	{
		int m=0;
		int temp=0;
		int[] m2= new int[V];
		index++;

		 for(int l=0;l<V;l++) {
				m2[l]=dist[l];
				}
		 for (int p = 0; p < n; p++) 
	        {
	            for (int q = p + 1; q < n; q++) 
	            {
	                if (m2[p] > m2[q]) 
	                {
	                    temp = m2[p];
	                    m2[p] = m2[q];
	                    m2[q] = temp;
	                }
	            }
	        }
		 for(int l=0;l<V;l++) {
			
			if(m>dist[l] || dist[l]>0)
				//m=dist[l];
			 m=m2[index];
				}
		//System.out.println(m);
		for(s=0;s<V;s++) {
			
			if(dist[s]==m) {
				//System.out.println(s+"index in for"+ (s+64150));
				destination=(s+64150);
				
			break;
			}
		}
		//System.out.println(s+"s after for");
		zipcodef=(s+64150);
		//System.out.println(index+"index");
		//System.out.println(zipcodef+" printsolution");
		//System.out.println(zipcodef + "destination");
		
	/*	System.out.println("Vertex Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i+" \t "+dist[i]);*/
		return zipcodef;	
	}
	
	static void zipcodeVerify(int zipcode,int vtype,int zp2)throws IOException {
		int zp=0;
		   Scanner in= new Scanner(inFile);
		  try {
  	        br = new BufferedReader(new FileReader(filepath));
  	        try {
  	        	while((line = br.readLine()) != null)
  	            {
  	                n++;
  	            }
					
					//System.out.println(n);
					//int [ ] [ ] abc = new int [ n ] [ n ];
					int k=n*3;
					int i=0;
					int[] abc = new int[k];
					int j=0;
					int c = 0;
					int ambulances=0;
					int firetruck=0;
					int policecar=0;
					while(in.hasNextLine()){
					//String[]	currentLine.add(in.nextLine());
					String currentLine = in.nextLine();
					String[] c1=currentLine.split(",");
					
				
					for(String alphabet : c1)
				    {
				   int a=Integer.parseInt(alphabet);
				   abc[i]=a;
				   i++;
				    }
					
  	            br.close();
					}
					for(i=2;i<k;i+=3)
					{
						if(abc[i]==zipcode)
						{
						if(abc[i-1]==1)
							ambulances++;
						else if(abc[i-1]==2)
							firetruck++;
						else if(abc[i-1]==3)
							policecar++;
					}
					
					}
					//System.out.println(ambulances+" " +firetruck+ " "+policecar);
					for(i=2;i<k;i+=3)
					{
						//if(alphabet[i]==zipcode)
						if(abc[i]==zipcode){
							countincr++;
							//System.out.println(countincr);
							if(vtype==abc[i-1])
							{
								countincr1++;
								//System.out.println(countincr1);

								if(vtype==1)
								{
									ambulances--;
								System.out.println("Request sent from: "+ zipcode);
								try(FileWriter fw = new FileWriter("C:\\\\Users\\\\avina\\\\Desktop\\\\daa\\\\output.txt", true);
									    BufferedWriter bw = new BufferedWriter(fw);
									    PrintWriter out = new PrintWriter(bw))
									{
									//System.out.println("destination");
									 out.println("Sent from: "+ zipcode + "\t" +"vehicle type: " + vtype);
									 } catch (IOException e) {
									    //exception handling left as an exercise for the reader
									}			    //more code
									  
								break;
								}
								else if(vtype==2)
								{
									firetruck--;
								System.out.println("Request sent from: "+ zipcode);
								try(FileWriter fw = new FileWriter("C:\\\\Users\\\\avina\\\\Desktop\\\\daa\\\\output.txt", true);
									    BufferedWriter bw = new BufferedWriter(fw);
									    PrintWriter out = new PrintWriter(bw))
									{
									//System.out.println("destination");
									 out.println("Sent from: "+ zipcode + "\t" +"vehicle type: " + vtype);
									} catch (IOException e) {
									    //exception handling left as an exercise for the reader
									}		
								break;
								}
								else if(vtype==3)
								{
									policecar--;
								System.out.println("Request sent from: "+ zipcode);
								try(FileWriter fw = new FileWriter("C:\\\\Users\\\\avina\\\\Desktop\\\\daa\\\\output.txt", true);
									    BufferedWriter bw = new BufferedWriter(fw);
									    PrintWriter out = new PrintWriter(bw))
									{
									//System.out.println("destination");
									 out.println("Sent from: "+ zipcode + "\t" +"vehicle type: " + vtype);								   // System.out.println("Source"+"Destination"+"vtype");
									} catch (IOException e) {
									    //exception handling left as an exercise for the reader
									}		
								break;
								
								}
								
							}
							
						}	
							
					}
					//System.out.println(ambulances+" " +firetruck+ " "+policecar);
					if(countincr==0||countincr1==0)
					{
						//System.out.println(countincr+ "c,c1"+countincr1);
						//System.out.println("go to dijikstra's");
						//Graph g = new Graph("Distance.txt");
						//g.vehicleRequest();
						Graph t = new Graph();
						
						
					 zp=	t.dijkstra(abcd, zp2-64150,vtype);
					 zipcodeVerify(zp,vtype,zp2);
					 //System.out.println(zp);
				    
						
					}
					if(countincr!=0||countincr1!=0) {
						 Scanner sc=new Scanner(System.in);  
						    
						   System.out.println("Enter your zipcode between 64150--64160");  
						   zipcode1 = sc.nextInt();
					    source=zipcode1;
						    System.out.println("Enter your vehicle type: 1.Ambulance  2. Fire Truck  3. Police car");  
						   vtype=sc.nextInt();
						 
						  // System.out.println(zipcode1+" "+vtype);
						   countincr=0;
						   countincr1=0;
						   index=0;
						   try(FileWriter fw = new FileWriter("C:\\\\Users\\\\avina\\\\Desktop\\\\daa\\\\output.txt", true);
								    BufferedWriter bw = new BufferedWriter(fw);
								    PrintWriter out = new PrintWriter(bw))
								{
								    out.println("source: "+ zipcode1);
								} catch (IOException e) {
								    //exception handling left as an exercise for the reader
								}
						   zipcodeVerify(zipcode1,vtype,zipcode1);
						  
						  // System.out.println(countincr+ "last"+countincr1);
					}
					} catch (IOException e) {
  	            // TODO Auto-generated catch block
  	            e.printStackTrace();
  	       
  	        }
  	    } 
			  catch (FileNotFoundException e) {
  	        // TODO Auto-generated catch block
  	        e.printStackTrace();
  	    }
			//return zp;

	}
	
	int dijkstra(int graph[][], int src, int vtype)throws IOException
	{
		int dist[] = new int[V]; 
		Boolean sptSet[] = new Boolean[V];

		// Initialize all distances as INFINITE and stpSet[] as false
		for (int i = 0; i < V; i++)
		{
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		// Distance of source vertex from itself is always 0
		dist[src] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < V-1; count++)
		{
			
			int u = minDistance(dist, sptSet);
			sptSet[u] = true;
			for (int v = 0; v < V; v++)
				if (!sptSet[v] && graph[u][v]!=0 &&
						dist[u] != Integer.MAX_VALUE &&
						dist[u]+graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}

		// print the constructed distance array
		int zp= printSolution(dist, V, vtype);
		return zp;
		
	}

	public static void main(String[] args) throws IOException{
		
		
			 String filepaths = "C:\\Users\\avina\\Desktop\\daa\\Distance.txt";
			 File inFiles=new File(filepaths);
			  Scanner in1= new Scanner(inFiles);   
			int x=0, y=0, n1=0;
		   
		 
		    Scanner sc=new Scanner(System.in);  
		    
			   System.out.println("Enter your zipcode between 64150--64160");  
			   int zipcode = sc.nextInt();
			   
		    
			    System.out.println("Enter your vehicle type: 1.Ambulance  2. Fire Truck  3. Police car");  
			   vtype=sc.nextInt();
			   try(FileWriter fw = new FileWriter("C:\\\\Users\\\\avina\\\\Desktop\\\\daa\\\\output.txt", true);
					    BufferedWriter bw = new BufferedWriter(fw);
					    PrintWriter out = new PrintWriter(bw))
					{
					    out.println("source"+zipcode);
					} catch (IOException e) {
					    //exception handling left as an exercise for the reader
					}
			   Graph p = new Graph();
			   
				try
			       {
				      BufferedReader  brd = new BufferedReader(new FileReader(filepaths));
					try {
				      while(in1.hasNextLine())	//file reading
						{
							//String[] values = line.split(",");
				    		String currentLine = in1.nextLine();
							String[] c1=currentLine.split(",");
							
				        	for (String str : c1)
				        	{
				        	
				        		int a=Integer.parseInt(str);
				        		//System.out.println(a);
				        	    abcd[x][y]=a;
				        		
								y=y+1;
				        		
				        	}
				        	
				        	n1++;
				        	y=0;
				        	x=x+1;
				        	
				        				}
				/*    for(x=0;x<n;x++) {
				    	  for(y=0;y<n;y++) {
				    		  System.out.println(graph[x][y]+ " ");
				    	  }
				    	  
									    }*/
				    
										
					    	            brd.close();
										}
					    	        
										catch (IOException e) {
						    	            // TODO Auto-generated catch block
						    	            e.printStackTrace();
						    	       
						    	        }
						    	    } 
									  catch (FileNotFoundException e) {
						    	        // TODO Auto-generated catch block
						    	        e.printStackTrace();
						    	    }
				
				
				/*PrintStream out = new PrintStream(new FileOutputStream("C:\\Users\\avina\\Desktop\\daa\\output.txt"));
				System.setOut(out);*/
				
				
				//String filepathk = "C:\\Users\\avina\\Desktop\\daa\\output.txt";
				
				/*BufferedWriter bw = new BufferedWriter(new FileWriter("filepathk", true));
			
				 bw.newLine();
				 bw.flush();*/
					/* Let us create the example graph discussed above */
					
					p.zipcodeVerify(zipcode,vtype,zipcode);
						 
				/*if(zpc>64149)
					zipcodeVerify(zpc,vtype);*/
			
	}
}