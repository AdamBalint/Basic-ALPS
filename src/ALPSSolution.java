
public interface ALPSSolution<T> {
	public double calculateFitness();
	public int compareTo();
	public T clone();
	public double getFitness();
	public int getAge();
}
