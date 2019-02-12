
public class Weight {

	public static double weighted(String a , String b){
		double weight = 0;
		double dot=0;
		double d1 =0;
		double d2 =0;
		for(int i =1;i<Main.vectorDic.get(a).length;i++){
			
			double t1= Double.parseDouble(Main.vectorDic.get(a)[i]);
			d1 = d1 + (t1*t1);
			double t2 =Double.parseDouble(Main.vectorDic.get(b)[i]);
			d2 = d2 + (t2*t2);
			dot = dot +(t1*t2);
		}
		
		
		weight = dot / (Math.sqrt(d1) * Math.sqrt(d2));

		
		return 1-weight;
	}

}
