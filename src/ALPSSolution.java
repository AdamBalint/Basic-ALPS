
public interface ALPSSolution<T> {
	
	public void calculateFitness();
	public T clone();
	public double getFitness();
	public int getAge();
	public int[] getChromosome();
	public void ageSolution();
}
