import java.util.Arrays;

public class Solution implements ALPSSolution<Solution>, Comparable<Solution>{

	private int[] chromo;
	private int age = 1;
	private double fitness = Double.POSITIVE_INFINITY;
	
	public Solution(){
		chromo = new int[100];
	}
	
	public Solution(int[] chromo){
		this.chromo = chromo;
		calculateFitness();
	}
	public Solution(int[] chromo, int age){
		this.chromo = chromo;
		this.age = age;
		calculateFitness();
	}
	public Solution(int[] chromo, double fitness){
		this.chromo = chromo;
		this.fitness = fitness;
	}
	public Solution(int[] chromo, double fitness, int age){
		this.chromo = chromo;
		this.fitness = fitness;
		this.age = age;
	}
	
	public void randomChromosome(){
		chromo = Main.sf.generateSolution(chromo.length);
	}

	@Override
	public void calculateFitness() {
		// TODO Auto-generated method stub
		int score = 0;
		for (int i = 0; i < chromo.length; i += 2){
			if (chromo[i] == 1 && chromo[i+1] == 0){
				score += 1;
			}
		}
		fitness = score;
	}

	@Override
	public Solution clone() {
		// TODO Auto-generated method stub
		return new Solution(Arrays.copyOf(chromo, chromo.length), getFitness(), age);
	}

	@Override
	public double getFitness() {
		// TODO Auto-generated method stub
		if (fitness == Double.POSITIVE_INFINITY){
			calculateFitness();
		}
		return fitness;
	}

	@Override
	public int compareTo(Solution o) {
		// TODO Auto-generated method stub
		if (getFitness() < o.getFitness())
			return 1;
		else if (getFitness() > o.getFitness())
			return -1;
		else 
			return 0;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return age;
	}

	@Override
	public int[] getChromosome() {
		// TODO Auto-generated method stub
		return Arrays.copyOf(chromo, chromo.length);
	}

	@Override
	public void ageSolution() {
		// TODO Auto-generated method stub
		age++;
	}
	
	
}
