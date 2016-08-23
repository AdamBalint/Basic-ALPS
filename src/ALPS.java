
public class ALPS {

	private int numLayers, pop, ageGap;

	private Population[] layers;
	private int[] layerLimits;
	
	
	public ALPS(int numLayers, int pop, int ageGap){
		this.numLayers = numLayers;
		this.pop = pop;
		this.ageGap = ageGap;
		this.layers = new Population[numLayers];

		layerLimits = new int[numLayers];
		
		for (int i = 0; i < numLayers-1; i++){
			layerLimits[i] = (i+1)*ageGap;
		}
		layerLimits[numLayers-1] = Integer.MAX_VALUE;
		initPopulation();

	}

	private void initPopulation(){
		layers[0] = new Population(pop);
		layers[0].randomPopulation();
	}

	public Solution getRandomSolutionFromLayerBelow(int layer){
		int belowLayer = Math.max(layer-1, 0);
		//System.out.println("Layer below: " + belowLayer);
		// System.out.println("Layer below: " + belowLayer);
		return layers[belowLayer].getRandomSolution();
	}

	public void runALPS(){
		for (int i = 0; i < 100; i++){
			for (int layer = numLayers-1; layer >= 0; layer-- ){
				if (layers[layer] != null){
					System.err.println("Layer " + layer + ":");
					System.out.println(layers[layer].layerInfo());
					layers[layer] = layers[layer].getNewPopulation(layer);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					int maxAge = layers[layer].getMaxAge();
					if (maxAge > layerLimits[layer]){
						moveLayerUp(layer);
					}
				}
				if (layers[0] == null){
					layers[0] = new Population(pop);
					layers[0].randomPopulation();
				}
			}
		}
	}

	private void moveLayerUp(int currentLayer) {
		// TODO Auto-generated method stub
		int aboveLayer = currentLayer + 1;
		if (layers[aboveLayer] == null){
			layers[aboveLayer] = layers[currentLayer];
			layers[currentLayer] = null;
		}else{
			layers[aboveLayer] = Main.popOps.mergeLayers(layers[currentLayer], layers[aboveLayer]);
			layers[currentLayer] = null;
		}
		
		
	}


}
