
public class SolutionFactory {

	public SolutionFactory(){
		
	}
	
	public int[] generateSolution(int size){
		int[] chromo = new int[size];
		for (int i = 0; i < chromo.length; i++){
			chromo[i] = (int)Math.round(Math.random());
		}
		return chromo;
	}
	
	
}
