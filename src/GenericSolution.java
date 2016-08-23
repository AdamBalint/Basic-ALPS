
public interface GenericSolution<T> {
	
	public double calculateFitness();
	public int compareTo();
	public T clone();
	public double getFitness();
	
}
