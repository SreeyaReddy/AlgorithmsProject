package sample1;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Graph {
	
	private  ArrayList<ArrayList<int[]>> vertices; // graph
	private static  ArrayList<ArrayList<int[]>> listitems; // graph
	private HashSet<Integer> explored; // nodes that have been explored
	int zipcode;
	/**
	 * Reads graph from input file.
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	

	        
	public Graph(String inputFileName) throws FileNotFoundException{
		vertices = new ArrayList<ArrayList<int[]>>();
		Scanner in = new Scanner(new File(inputFileName));//scans the input file
		//add all vertices
		while (in.hasNextLine()){
			 vertices.add(new ArrayList<int[]>());//adding vertices to arraylist
			 String[] line = in.nextLine().split("\t");//whenever you get a tab it takes the integer as vertex
			 int node = Integer.parseInt(line[0]);
			 for (int i = 1; i < line.length; i++){
				 String[] edgeStr = line[i].split(",");//whenever you get , it takes it as edge value
				 int[] edge = new int[2];
				 edge[0] = Integer.parseInt(edgeStr[0]);
				 edge[1] = Integer.parseInt(edgeStr[1]);
				 vertices.get(node - 64150).add(edge);
			 }
		}		
	}
	
	/**
	 * Computes the shortest-path distances between 1 and every other vertex of
	 * the graph.
	 * @return paths an array of integer indicates the path distances from 1 to 
	 * every node, e.g. paths[i] is the path distance from 1 to i+1.
	 */
	
public int[] shortestPath(){
	
	int k=0;
	//int src;
	
	
		int n = vertices.size();
		int a[] = new int[n];
		explored = new HashSet<Integer>();
		int[] paths = new int[n];
		explored.add(64150);
		paths[0] = 0;
		while (explored.size() < n){
			int w = 64149;//index-1
			
			int l = 1000000;
			for (int node : explored){				
				for (int[] edge : vertices.get(node - 64150)){
					if (!explored.contains(edge[0])){
						if (paths[node-64150] + edge[1] < l){
							w = edge[0];
							l = paths[node-64150] + edge[1];
							
						}
					}
				}
			}
			if (w != 64149){
				explored.add(w);
				paths[w-1] = l;
			
			
		 a[k]=w;
		 k++;
		
			} else {
				for (int i = 0; i < n; i++){
					if (!explored.contains(i+1)){
						paths[i] = 1000000;
					}
				}
				break;
			}
		}
		
		System.out.println(a[0]);
		return paths;
	
	}
	
	

	public static void main(String[] args) throws IOException{
		
		 int n=0;
		 
		    String filepath = "C:\\Users\\avina\\Desktop\\daa\\VehicleType.txt";
		    double count = 0,countBuffer=0,countLine=0;
		    String lineNumber = "";
		   int countincr=0;
		   int countincr1=0;
		    BufferedReader br;
		   
		    String line = "";
File inFile=new File(filepath);
		   Scanner in= new Scanner(inFile);
		    Scanner sc=new Scanner(System.in);  
		    
			   System.out.println("Enter your zipcode");  
			   int zipcode = sc.nextInt();
		    
			    System.out.println("Enter your vehicle type: 1.Ambulance  2. Fire Truck  3. Police car");  
			   int vtype=sc.nextInt(); 
			   
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
					System.out.println(ambulances+" " +firetruck+ " "+policecar);
					for(i=2;i<k;i+=3)
					{
						//if(alphabet[i]==zipcode)
						if(abc[i]==zipcode){
							countincr++;
							if(vtype==abc[i-1])
							{
								countincr1++;
								if(vtype==1)
								{
									ambulances--;
								System.out.println("Request sent");
								break;
								}
								else if(vtype==2)
								{
									firetruck--;
								System.out.println("Request sent");
								break;
								}
								else if(vtype==3)
								{
									policecar--;
								System.out.println("Request sent");
								break;
								}
								
							}
							
						}	
							
					}
					System.out.println(ambulances+" " +firetruck+ " "+policecar);
					if(countincr==0||countincr1==0)
					{
						System.out.println("go to dijikstra's");
						Graph g = new Graph("Distance.txt");
						//g.vehicleRequest();
						int[] paths = g.shortestPath();	
						//System.out.println(paths[6]); //7,37,59,82,99,115,133,165,188,197		
						System.out.println(Arrays.toString(paths));
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

			
		
		
		
		/*//Graph g = new Graph("SimpleInput.txt");
		Graph g = new Graph("Distance.txt");
		//g.vehicleRequest();
		int[] paths = g.shortestPath();	
		//System.out.println(paths[6]); //7,37,59,82,99,115,133,165,188,197		
		System.out.println(Arrays.toString(paths));
		//g.vehicleRequest();
		//System.out.println(paths[1]);*/
		 
		
		
		
	}
}