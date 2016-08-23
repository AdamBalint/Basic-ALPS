import java.util.Arrays;

public class PopulationOps {

	private int crossover, mutation, tournSize;
	
	
	public PopulationOps(int crossover, int mutation, int tournSize){
		this.crossover = crossover;
		this.mutation = mutation;
		this.tournSize = tournSize;
	}
	
	
	private Solution getParent(Solution[] pop, int layerNumber){
		Solution[] candidates = new Solution[tournSize];
		
		for (int i = 0; i < tournSize; i++){
			//System.out.println(pop.length);
			candidates[i] = (Main.rand.nextInt(100) < 10)? Main.alps.getRandomSolutionFromLayerBelow(layerNumber) : pop[Main.rand.nextInt(pop.length)];
		}
		Arrays.sort(candidates);
		
		return candidates[0].clone();
	}
	
	
	
	public Solution[] getNewPopulation(Solution[] pop, int layerNumber){
		Solution[] newPop = new Solution[pop.length];
//		System.out.println(layerNumber);
		for (int i = 0; i < pop.length; i+= 2){
			Solution[] parents = {getParent(pop, layerNumber), getParent(pop, layerNumber)};
			Solution[] children;
			
			
			if (Main.rand.nextInt(100) < crossover){
				children = crossover(parents);
				if (Main.rand.nextInt(100) < mutation){
					children[0] = mutate(children[0]);
				}
				if (Main.rand.nextInt(100) < mutation){
					children[1] = mutate(children[1]);
				}
			}
			else{
				children = parents;
			}
			
			newPop[i] = children[0];
			newPop[i].ageSolution();
			newPop[i+1] = children[1];
			newPop[i+1].ageSolution();
		}
		
		
		return newPop;
	}


	private Solution mutate(Solution child) {
		// TODO Auto-generated method stub
		int[] chromo = child.getChromosome();
		int from = Main.rand.nextInt(chromo.length), to = Main.rand.nextInt(chromo.length);
		int tmp = chromo[from];
		chromo[from] = chromo[to];
		chromo[to] = tmp;
		return new Solution(chromo, child.getAge());
	}


	private Solution[] crossover(Solution[] parents) {
		// TODO Auto-generated method stub
		int[] parent1Chromo = parents[0].getChromosome();
		int[] parent2Chromo = parents[1].getChromosome();
		
		int[] c1Chromo = new int[parent1Chromo.length], c2Chromo = new int[parent1Chromo.length];
		
		for (int i = 0; i < c1Chromo.length; i++){
			int maskBit = Main.rand.nextInt(2);
			if (maskBit == 1){
				c1Chromo[i] = parent1Chromo[i];
				c2Chromo[i] = parent2Chromo[i];
			}else{
				c1Chromo[i] = parent2Chromo[i];
				c2Chromo[i] = parent1Chromo[i];
			}
		}
		int age = Math.max(parents[0].getAge(), parents[1].getAge());
		
		Solution[] children = {new Solution(c1Chromo, age), new Solution(c2Chromo, age)};
		return children;
	}


	public Population mergeLayers(Population population, Population population2) {
		// TODO Auto-generated method stub
		Solution[] pop = population.getPopulation();
		Solution[] pop2 = population2.getPopulation();	
		Solution[] retPop = new Solution[pop.length];
		
		for (int i = 0; i < retPop.length; i++){
			retPop[i] = mergeTourn(pop,pop2);
		}
		
		return new Population(retPop);
	}
	
	private Solution mergeTourn(Solution[] pop, Solution[] pop2){
		Solution[] candidates = new Solution[6];
		
		for (int i = 0; i < 6; i++){
			candidates[i] = i % 2 == 0 ? pop[Main.rand.nextInt(pop.length)] : pop2[Main.rand.nextInt(pop2.length)];
		}
		
		Arrays.sort(candidates);
		return candidates[0].clone();
	}
	
	
}
