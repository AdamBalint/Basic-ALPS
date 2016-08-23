
public class Population {
	
	private int popSize;
	private Solution[] pop;
	
	
	public Population(int popSize){
		this.popSize = popSize;
		pop = new Solution[popSize];
	}
	
	public Population(Solution[] pop){
		this.pop = pop;
		popSize = pop.length;
	}
	
	public void randomPopulation(){
		
		for (int i = 0; i < pop.length; i++){
			pop[i] = new Solution();
			pop[i].randomChromosome();
		}
		
	}
	
	public Population getNewPopulation(int layerNumber){
		Solution[] newPop = Main.popOps.getNewPopulation(pop, layerNumber);
		return new Population(newPop);
	}
	
	public Solution getRandomSolution(){
		return pop[Main.rand.nextInt(pop.length)];
	}
	
	public String layerInfo(){
		String s = "";
		int max = 0;
		int min = Integer.MAX_VALUE;
		double maxFitness = 0, minFitness = Double.MAX_VALUE;
		
		for (int i = 0; i < pop.length; i++){
			int solAge = pop[i].getAge();
			double fitness = pop[i].getFitness();
			max = Math.max(max, solAge);
			min = Math.min(min, solAge);
			maxFitness = Math.max(maxFitness, fitness);
			minFitness = Math.min(minFitness, fitness);
		}
		s += "Age: \n\t Max: " + max + "\n\t Min: " + min + "\n";
		s += "Fitness: \n\t Max: " + maxFitness + "\n\t Min: " + minFitness + "\n";
		
		return s;
	}

	public int getMaxAge() {
		// TODO Auto-generated method stub
		int maxAge = 0;
		for (Solution s : pop)
			maxAge = Math.max(maxAge, s.getAge());
		return maxAge;
	}
	
	public Solution[] getPopulation(){
		return pop;
	}
	
	
}
