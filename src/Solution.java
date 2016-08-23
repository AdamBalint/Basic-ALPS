import java.util.Arrays;

public class Solution implements GenericSolution<Solution>{

	private int[] chromo;
	
	public Solution(){
		chromo = new int[100];
	}
	
	public void randomChromosome(){
		chromo = Main.sf.generateSolution(chromo.length);
		System.out.println(Arrays.toString(chromo) + "\n");
	}

	@Override
	public double calculateFitness() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Solution clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getFitness() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
