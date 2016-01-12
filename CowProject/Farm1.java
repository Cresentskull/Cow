import java.util.*;
import java.lang.*;
public class Farm1{
	public int time;
	public String name;
	public ArrayList<FarmObject> farmObjectList = new ArrayList<>(5);
	
	public Farm1() {
	}
	
	public void setupNewFarm(){
		farmObjectList.add(new Cow("daycow", 10, 10));
		farmObjectList.add(new Grass(20,20,4));
		farmObjectList.add(new NocturnalCow("nightcow", 12, 12));
		farmObjectList.add(new PoisonedGrass(50,53,5));
		farmObjectList.add(new FlyingCow("flycow",5,5));
	}
	public void getInfoOfEntities(){
		for(FarmObject x : farmObjectList)
			System.out.println(x.toString());
	}
	
	public void allEntitiesDoSomethingForAnHour() {
		for(int i = 0; i < farmObjectList.size(); i++){
			farmObjectList.get(i).doStuffForAnHour();
			System.out.print(".");
		}
	}
	public void growSomeGrass() {
		for(int i = 0; i < farmObjectList.size(); i++){	
			if(farmObjectList.get(i) instanceof Grass) {
				int j = 0;
				int createNewGrass = ((Grass)farmObjectList.get(i)).createNewGrass();
				if(createNewGrass == 1)
				{
					farmObjectList.add(new Grass(farmObjectList.get(i).coordinateX+1,farmObjectList.get(i).coordinateY, 1));
				}
				else if(createNewGrass == 2)
				{
					farmObjectList.add(new Grass(farmObjectList.get(i).coordinateX-1,farmObjectList.get(i).coordinateY, 1));
				}
				else if(createNewGrass == 3)
				{
					farmObjectList.add(new Grass(farmObjectList.get(i).coordinateX,farmObjectList.get(i).coordinateY+1, 1));
				}
				else if(createNewGrass == 4)
				{
					farmObjectList.add(new Grass(farmObjectList.get(i).coordinateX,farmObjectList.get(i).coordinateY-1, 1));
				}
			}
		}
	}
	public void updateTime(int time){
		this.time = time;
	}
}