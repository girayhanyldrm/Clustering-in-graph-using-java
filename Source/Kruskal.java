
public class Kruskal {

	
int fathers[]=new int[1000];

int find(int x){
		if(fathers[x]==x){
			return x;
		}
		
		return find(fathers[x]);
		
	}

void unite(int x, int y){
	int fx = find(x);
	int fy = find(y);
	fathers[fx]=fy;
}


public static void kruskalMST(int n,int m){
	Kruskal samp= new Kruskal();
	for(int e=0;e<1000;e++){
		samp.fathers[e]=e;
	}
	double mst_weight=0; 
	int mst_edges=0;
	int mst_ni=0;
	while((mst_edges < n-1) || (mst_ni <m) ){
		int a=Main.graph.get(mst_ni).aCount;
		int b=Main.graph.get(mst_ni).bCount;
		double w=Main.graph.get(mst_ni).weight;
		if(samp.find(a)!=samp.find(b)){
			samp.unite(a, b);
			mst_weight = mst_weight + w;
			
			Main.graphMST.add(new Vertex(Main.graphDic.get(a),a, Main.graphDic.get(b),b,w));
			mst_edges++;
		}
		mst_ni++;
		
	}
	
}
}
