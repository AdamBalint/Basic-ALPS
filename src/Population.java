
public class Population {
	
	private int popSize;
	private Solution[] pop;
	
	
	public Population(int popSize){
		this.popSize = popSize;
		pop = new Solution[popSize];
	}
	
	public void randomPopulation(){
		
		for (int i = 0; i < pop.length; i++){
			pop[i] = new Solution();
			pop[i].randomChromosome();
		}
		
	}

	
	
}
