
public class ALPS {
	
	private int numLayers, pop, ageGap;
	
	private Population[] layers;
	
	public ALPS(int numLayers, int pop, int ageGap){
		this.numLayers = numLayers;
		this.pop = pop;
		this.ageGap = ageGap;
		this.layers = new Population[numLayers];
		
		initPopulation();
		
	}
	
	private void initPopulation(){
		layers[0] = new Population(pop);
		layers[0].randomPopulation();
	}
	
	
	
}
