import java.util.*;
public class Cow extends FarmObject {
	String name;
	int hungriness, age, sicknessLevel, time;
	
	public void updateTime(int time){
		this.time = time;
//		System.out.println(time);
	}

	public Cow (String name, int x, int y) {
		this.name = name;
		this.coordinateX = x;
		this.coordinateY = y;
	}
	
	public boolean isAwake(){
		if((this.time>=6 && this.time <=18)){
			return true;
		}
		else if ((this.time>=30 && this.time <=42))
			return true;
		else
			return false;
	}
	public void doStuffForAnHour() {
		if(this.isAwake()) {
			System.out.println(this.name+" is awake");
			move();
			eat();
			makeHungry();
			kill();
		}
		else
			System.out.println(this.name+" is asleep");
		this.age++;
		this.hungriness = hungriness+2;
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



	public boolean checkCollision(int x, int y){
		if ((y < 0) || (y>100) || (x<0) || (x>100))
				return true;
		for(int i = 0; i < farmObjectList.size(); i++){
			if((x == farmObjectList.get(i).coordinateX) && (y == farmObjectList.get(i).coordinateY) && farmObjectList.get(i) instanceof Cow)
				return true;
		}
		return false;
	}


	public void move() {
		boolean canMove = false;
		int[] randomArray = getRandomDirection();
		canMove = !checkCollision(this.coordinateX+randomArray[0], this.coordinateY+randomArray[1]);
//		System.out.println(canMove);

		if(canMove){
			this.coordinateX = this.coordinateX+randomArray[0];
			this.coordinateY = this.coordinateY+randomArray[1];
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
	public String toString() {
		return 
		this.name +", "+this.coordinateX+", "+this.coordinateY+", "+this.hungriness+", "+this.sicknessLevel+", "+this.age
		;
	}
	public void remove() {
		this.coordinateX = -1;
		this.coordinateY = -1;
	}
	public int[] getRandomDirection() {
		Random rand = new Random();
		int[] newArr = new int[] {0,0};
		int numbdirection = rand.nextInt(4)+1;
		if(numbdirection == 1)
			newArr[0] = 1;
		if(numbdirection == 2)
			newArr[0] = -1;
		if(numbdirection == 3)
			newArr[1] = 1;
		else
			newArr[1] = -1;
		return newArr;
	}
}
