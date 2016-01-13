import java.util.*;
public class Cow extends FarmObject {
	String name;
	int hungriness, age, sicknessLevel, timeon24;
	ArrayList<FarmObject> farmObjectList = new ArrayList<>(5);
	
	public void createFarmObjectList(ArrayList<FarmObject> farmObjectList){
		this.farmObjectList = farmObjectList;
	}

	public void updateTime(int time){
		this.timeon24 = time%24;
//		System.out.println(timeon24);
	}

	public Cow (String name, int x, int y) {
		this.name = name;
		this.coordinateX = x;
		this.coordinateY = y;
	}
	
	public boolean isAwake(){
		if((this.timeon24>=6 && this.timeon24 <=18)){
			return true;
		}
		else
			return false;
	}
	public void doStuffForAnHour() {
		if(this.isAwake()) {
//			System.out.println(this.name+" is awake");
			move();
			eat();
			kill();
		}
//		else
//			System.out.println(this.name+" is asleep");
		makeHungry();
		this.age++;

	}
	public void eat() {
		for(int i = 2; i < farmObjectList.size(); i++) {
			System.out.println("ate1");
			if((this.coordinateX == farmObjectList.get(i).coordinateX) && (this.coordinateY == farmObjectList.get(i).coordinateY) && (farmObjectList.get(i) instanceof Grass)) {
				System.out.println("ate2");
				System.out.println(((Grass)farmObjectList.get(i)).getAmount());
				if(farmObjectList.get(i) instanceof PoisonedGrass) {
					System.out.println(this.name+" Ate Poisoned Grass");
					this.sicknessLevel = this.sicknessLevel+((PoisonedGrass)farmObjectList.get(i)).getAmount();
					farmObjectList.get(i).remove();
				}
				else{
					System.out.println(this.name+" Ate Grass");
					this.hungriness = this.hungriness-((Grass)farmObjectList.get(i)).getAmount();
					((Grass)farmObjectList.get(i)).remove();
				}
			}
		}
	}



	public boolean checkCollision(int x, int y){
		if ((y < 0) || (y>100) || (x<0) || (x>100))
				return true;
		for(int i = 0; i < super.farmObjectList.size(); i++){
			System.out.println("c1");
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
		this.hungriness=this.hungriness+2;
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
	
	public String toString() {
		return 
		this.name +", "+"x: "+this.coordinateX+", y: "+this.coordinateY+", h: "+this.hungriness+", s: "+this.sicknessLevel+", a: "+this.age
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
