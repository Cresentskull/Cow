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
	public int createNewGrass() {
		int deltaX = 0;
		int deltaY = 0;
		Random rand = new Random();
		boolean bool = true;
		double chanceOfSpread = amount;
		if(rand.nextInt(100)+1 < chanceOfSpread) {
			return 0;
		}
		else {
			int n = rand.nextInt(4)+1;
			if(n==1) {
				deltaX++;
			}
			else if(n==2) {
				deltaX--;
			}
			else if(n==3) {
				deltaY++;
			}
			else if(n==4) {
				deltaY--;
			}
			for(int i = 0; i < farmObjectList.size(); i++) {
				if((this.coordinateX+deltaX == farmObjectList.get(i).coordinateX) && (this.coordinateY+deltaY == farmObjectList.get(i).coordinateY)) {
					return 0;
				}
			}
			return n;
		}
	}
	public String toString() {
		return 
		this.amount +", "+this.coordinateX+", "+this.coordinateY
		;
	}
	public void remove() {
		this.coordinateX = -1;
		this.coordinateY = -1;
	}
}