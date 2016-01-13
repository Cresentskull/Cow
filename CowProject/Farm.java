import java.util.*;
import java.lang.*;
public class Farm{
	public int time;
	public String name;
	public ArrayList<FarmObject> farmObjectList = new ArrayList<>(5);
	
	public Farm() {
	}
	
	public void setupNewFarm(){
		farmObjectList.add(new Cow("daycow", 10, 10));
		farmObjectList.add(new NocturnalCow("nightcow", 12, 12));
		farmObjectList.add(new FlyingCow("flycow",5,5));
		farmObjectList.add(new Grass(20,20,4));
		farmObjectList.add(new PoisonedGrass(50,53,5));
	}
	public void getInfoOfEntities(){
		for(FarmObject x : farmObjectList) {
			if(x instanceof Cow)
				System.out.println(x.toString());
		}
	}
	
	public void allEntitiesDoSomethingForAnHour() {	
		int sizeOfList = getSizeOfList();
		for(int i = 0; i < sizeOfList; i++){
			farmObjectList.get(i).updateTime(time);
			farmObjectList.get(i).doStuffForAnHour();
		}
	}
	public void growSomeGrass() {
		int sizeOfList = getSizeOfList();
		int grassNewX;
		int grassNewY;

		for(int i = 0; i < sizeOfList; i++){
			int[] random = getRandomDirection();
			if(farmObjectList.get(i) instanceof Grass) {
				boolean canIGrowGrass = ((Grass)farmObjectList.get(i)).canCreateNewGrass();
//				System.out.println(canIGrowGrass);
				grassNewX = farmObjectList.get(i).coordinateX+random[0];
				grassNewY = farmObjectList.get(i).coordinateY+random[1];
				canIGrowGrass = !checkCollision(grassNewX, grassNewY);
				
				if(canIGrowGrass)
					if(farmObjectList.get(i) instanceof PoisonedGrass)
						farmObjectList.add(new PoisonedGrass(grassNewX, grassNewY, 1));
					else
						farmObjectList.add(new Grass(grassNewX, grassNewY, 1));		
			}

		}
	}

	public void cowEatGrass() {
		for(int i = 0; i < getSizeOfList(); i++){
			if(farmObjectList.get(i) instanceof Cow) {
				for(int j = 0; j < getSizeOfList(); j++) {
					if((farmObjectList.get(i).coordinateX == farmObjectList.get(j).coordinateX) 
						&& (farmObjectList.get(i).coordinateY == farmObjectList.get(j).coordinateY) 
						&& (farmObjectList.get(j) instanceof Grass)) {
							if(farmObjectList.get(j) instanceof PoisonedGrass){
								((Cow)farmObjectList.get(i)).eatPoison(((Grass)farmObjectList.get(j)).getAmount());
							}
							((Cow)farmObjectList.get(i)).eat(((Grass)farmObjectList.get(j)).getAmount());
							(farmObjectList.get(j)).remove();
					}
				}	
			}
		}
	}
	
	public int getSizeOfList() {
		return farmObjectList.size();
	}
	
	public boolean checkCollision(int x, int y){
		if ((y < 0) || (y>100) || (x<0) || (x>100))
				return true;
		for(int i = 0; i < farmObjectList.size(); i++){
			if((x == farmObjectList.get(i).coordinateX) && (y == farmObjectList.get(i).coordinateY))
				return true;
		}
		return false;
	}

	public void updateTime(int time){
		this.time = time;
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