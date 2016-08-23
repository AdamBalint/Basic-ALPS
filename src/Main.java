import java.util.Random;

public class Main {

	public static Random rand = new Random(1);
	public static SolutionFactory sf = new SolutionFactory();
	public static PopulationOps popOps = new PopulationOps(90, 10, 4);
	public static ALPS alps = new ALPS(10,100,2);
	
	
	public Main (){
		alps.runALPS();
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
