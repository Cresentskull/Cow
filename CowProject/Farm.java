import java.util.*;
import java.lang.*;
public class Farm{
	public int time;
	public FarmObject[] farmObjectList = new FarmObject[100];
	
	public void setupNewFarm() throws NullPointerException {
		farmObjectList[0] = new Cow("daycow", 10, 10);
		farmObjectList[1] = new Grass(20,20,4);
		farmObjectList[2] = new NocturnalCow("nightcow", 12, 12);
		farmObjectList[3] = new PoisonedGrass(50,53,5);
		farmObjectList[4] = new FlyingCow("flycow",5,5);
		
	}
	
	public void allEntitiesDoSomethingForAnHour() {
		for(int i = 0; i < farmObjectList.length; i++){
			farmObjectList[i].doStuffForAnHour();
			if(farmObjectList[i] instanceof Grass) {
				int j = 0;
				while((farmObjectList[j] instanceof Cow) || (farmObjectList[j] instanceof Grass)){
					j++;
				}
				int createNewGrass = ((Grass)farmObjectList[i]).createNewGrass();
				if(createNewGrass == 1)
				{
					farmObjectList[j] = new Grass(farmObjectList[i].coordinateX+1,farmObjectList[i].coordinateY, 1);
				}
				else if(createNewGrass == 2)
				{
					farmObjectList[j] = new Grass(farmObjectList[i].coordinateX-1,farmObjectList[i].coordinateY, 1);
				}
				else if(createNewGrass == 3)
				{
					farmObjectList[j] = new Grass(farmObjectList[i].coordinateX,farmObjectList[i].coordinateY+1, 1);
				}
				else if(createNewGrass == 4)
				{
					farmObjectList[j] = new Grass(farmObjectList[i].coordinateX,farmObjectList[i].coordinateY-1, 1);
				}

			}
		}
	}
	public void updateTime(int time){
		this.time = time;
	}

}