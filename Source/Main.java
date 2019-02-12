import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static ArrayList<String[]> vector = new ArrayList<String[]>();
	public static ArrayList<Vertex> graph=new ArrayList<Vertex>();
	public static Map<String, String[]> vectorDic = new HashMap<String, String[]>();
	public static ArrayList<String> vertex = new ArrayList<String>();
	public static Map<Integer,String> graphDic = new HashMap<Integer,String>();
	public static ArrayList<Vertex> graphMST =new ArrayList<Vertex>();
	public static void main(String[] args) throws IOException{

			String fileName = args[0];
			File file = new File(fileName);
			try{
				Scanner input= new Scanner(file);
				while(input.hasNextLine()){
					String data = input.nextLine();
					String[] words = data.split(" ");
					words[0]=words[0].substring(1, words[0].length()-1);
						
					vector.add(words);
					vectorDic.put(words[0], words);
					
				}
				input.close();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
/////////////////////////////////////////////////////////////////////////////////////
			int i = 0 ;

			File file2 = new File(args[1]);
			try{
				Scanner input2= new Scanner(file2);
				while(input2.hasNextLine()){
					String data2 = input2.nextLine();
					String[] word = data2.split("-");
					if(!vertex.contains(word[0]))
					{
						vertex.add(word[0]);
						graphDic.put(i,word[0]);
						i++;

						
					}
				    if(!vertex.contains(word[1]))
					{
						vertex.add(word[1]);
						graphDic.put(i,word[1]);
						i++;
					}
				}
				input2.close();
			}
			catch(FileNotFoundException e){
				e.printStackTrace();
			}
			int x=0;
			for(int t=0;t<vertex.size();t++){
				x++;
				for(int y=x;y <vertex.size();y++){
					if(t!=y){
						double weight = Weight.weighted(vertex.get(t), vertex.get(y));
						graph.add(new Vertex(vertex.get(t),vertex.indexOf(vertex.get(t)), vertex.get(y),vertex.indexOf(vertex.get(y)),weight));
					}
					
			
				}
				
			}
			int vertexSayisi=vertex.size();
			int m=graph.size();
			Collections.sort(graph,Vertex.weightSort);
			Kruskal.kruskalMST(vertexSayisi, m);
			int edgeSayisi=graphMST.size();
			PrintStream writer = new PrintStream(new File(args[2]));
			System.out.println(vertex.size());
			int cluster=Integer.valueOf(args[3]);
			for(int xx=1;xx<cluster;xx++){
				graphMST.remove(graphMST.get(edgeSayisi-xx));
			}
			boolean[] control= new boolean[vertexSayisi];
			for(int fals=0;fals<vertexSayisi;fals++){
				control[fals]=false;
			}	
			
			Graph g=new Graph(vertexSayisi);
			for(Vertex str : graphMST){
				
				g.addEdge(str.getaCount(), str.getbCount());
				
	}
			
			for(int fals=0;fals<vertexSayisi;fals++){
				if(control[fals]==false){
					g.DFS(fals,control,writer);
					//System.out.println("");
					writer.println("");
				}
			}
			
			
	}
			
	
}
