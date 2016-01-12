public class PoisonedGrass extends Grass {
	public PoisonedGrass(int x, int y, int amount) {
		super(x,y,amount);
	}
	public void increaseGrass() {
		amount=amount+2;
	}
}