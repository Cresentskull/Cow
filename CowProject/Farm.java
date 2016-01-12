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
		farmObjectList.add(new Grass(20,20,4));
		farmObjectList.add(new NocturnalCow("nightcow", 12, 12));
		farmObjectList.add(new PoisonedGrass(50,53,5));
		farmObjectList.add(new FlyingCow("flycow",5,5));
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

		Random rand = new Random();
		for(int i = 0; i < sizeOfList; i++){
			int randIntX = rand.nextInt(1)*2-1;
			int randIntY = rand.nextInt(1)*2-1;
			if(farmObjectList.get(i) instanceof Grass) {
				boolean canIGrowGrass = ((Grass)farmObjectList.get(i)).canCreateNewGrass();
//				System.out.println(canIGrowGrass);
				grassNewX = farmObjectList.get(i).coordinateX+randIntX;
				grassNewY = farmObjectList.get(i).coordinateY+randIntY;
		//		canIGrowGrass = checkCollision(grassNewX, grassNewY);
				
				if(canIGrowGrass)
					if(farmObjectList.get(i) instanceof PoisonedGrass)
						farmObjectList.add(new PoisonedGrass(grassNewX, grassNewY, 1));
					else
						farmObjectList.add(new Grass(grassNewX, grassNewY, 1));		
			}

		}
	}
	public int getSizeOfList() {
		return farmObjectList.size();
	}
	public boolean checkCollision(int x, int y){
		for(int i = 0; i < farmObjectList.size(); i++){
			if(((x == farmObjectList.get(i).coordinateX) && (y == farmObjectList.get(i).coordinateY)) || (y < 0) || (x < 0) || (y > 100) || (x > 100))
				return true;
		}
		return false;
	}

	public void updateTime(int time){
		this.time = time;
//		System.out.println(time);
	}
}