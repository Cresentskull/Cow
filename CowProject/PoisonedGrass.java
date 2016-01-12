public class PoisonedGrass extends Grass {
	public PoisonedGrass(int x, int y, int amount) {
		super(x,y,amount);
	}
	public void increaseGrass() {
		amount=amount+2;
	}
	public String toString() {
		return 
		"poisoned a: "+this.amount +", x: "+this.coordinateX+", y: "+this.coordinateY
		;
	}
}