import java.util.Comparator;

public class Vertex {
	String a;
	int aCount;
	String b;
	int bCount;
	double weight;

	public Vertex(String a,int aCount,String b,int bCount, double weight) {
		
		this.a=a;
		this.aCount=aCount;
		this.b=b;
		this.bCount=bCount;
		this.weight=weight;
		
	
	}
	public int getaCount() {
		return aCount;
	}
	public void setaCount(int aCount) {
		this.aCount = aCount;
	}
	public int getbCount() {
		return bCount;
	}
	public void setbCount(int bCount) {
		this.bCount = bCount;
	}
	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	
	public String toString(){
		return getA()+" "+getB()+" "+getWeight();
		
	}
	 public static Comparator<Vertex> weightSort = new Comparator<Vertex>() {

			public int compare(Vertex s1,Vertex s2) {

			   double w1 = s1.getWeight();
			   double w2 = s2.getWeight();

		        return Double.compare(w1, w2);
			  
		   }};
	

}
