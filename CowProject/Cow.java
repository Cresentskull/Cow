import java.util.*;
public class Cow extends FarmObject {
	String name;
	int hungriness, age, sicknessLevel;
	
	public Cow (String name, int x, int y) {
		this.name = name;
		this.coordinateX = x;
		this.coordinateY = y;
	}
	
	public void doStuffForAnHour() {
		eat();
		makeHungry();
		kill();
	}
	public void eat() {
		for(int i = 0; i < farmObjectList.size(); i++) {
			if((this.coordinateX == farmObjectList.get(i).coordinateX) && (this.coordinateY == farmObjectList.get(i).coordinateY) && farmObjectList.get(i) instanceof Grass) {
				if(farmObjectList.get(i) instanceof PoisonedGrass) {
					this.sicknessLevel = this.sicknessLevel+((PoisonedGrass)farmObjectList.get(i)).amount;
					farmObjectList.get(i).remove();
				}
				else{
					this.hungriness = this.hungriness-((Grass)farmObjectList.get(i)).amount;
					((Grass)farmObjectList.get(i)).remove();
				}
			}
		}
	}
	public void move() {
		if(time>=6 && time <=18) {
			Random rand = new Random();
			int n = rand.nextInt(4)+1;
			int newX = 0;
			int newY = 0;
			boolean isOccupied = false;
			if(n==1) {
				newX++;
			}
			else if(n==2) {
				newX--;
			}
			else if(n==3) {
				newY++;
			}
			else if(n==4) {
				newY--;
			}

			for(int i = 0; i < farmObjectList.size(); i++) {
				if((this.coordinateX+newX == farmObjectList.get(i).coordinateX )&& (this.coordinateY+newY == farmObjectList.get(i).coordinateY) && farmObjectList.get(i) instanceof Cow) {
					isOccupied = true;
				}
			}
			if(isOccupied != true){
				this.coordinateX = this.coordinateX+newX;
				this.coordinateY = this.coordinateY+newY;
				System.out.println(n);
				doStuffForAnHour();
			}
		}
	}
	
	public void makeHungry() {
		hungriness++;
	}
	public void kill() {
		Random rand = new Random();
		if(hungriness>=100 || age>=90001) {
			this.remove();
		}
		double chanceDying = (0.0001*age*sicknessLevel);
		if(rand.nextInt(100)+1 < chanceDying) {
			this.remove();
		}
	}
	public String getName() {
		return name;
	}
	public void remove() {
		this.coordinateX = -1;
		this.coordinateY = -1;
	}
}
