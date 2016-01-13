import java.util.*;
public class Grass extends FarmObject {
	int amount;
	public void doStuffForAnHour() {
		increaseGrass();
	}
	public Grass(int x, int y, int amount) {
		this.coordinateX = x;
		this.coordinateY = y;
		this.amount = amount;
	}
	public int getAmount() {
		return this.amount;
	}
	public void increaseGrass() {
		amount++;
	}
	public boolean canCreateNewGrass() {
		int deltaX = 0;
		int deltaY = 0;
		Random rand = new Random();
		boolean bool = true;
		double chanceOfSpread = amount;
		if(rand.nextInt(100)+1 < chanceOfSpread) {
			return true;
		}
		else {
			return false;
		}
	}
	public String toString() {
		return 
		"clean a: "+this.amount +", x: "+this.coordinateX+", y: "+this.coordinateY
		;
	}
	public void remove() {
		this.coordinateX = -2;
		this.coordinateY = -2;
	}
}