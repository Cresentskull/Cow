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
//	public String toString() {
//		return 
//		"clean "+this.amount +", "+this.coordinateX+", "+this.coordinateY
//		;
//	}
	public void remove() {
		this.coordinateX = -1;
		this.coordinateY = -1;
	}
}