import java.lang.*;

public class World {
	public int time = 6;
	public Farm[] allFarm = new Farm[10];
	public Farm farm = new Farm();

	public World(){}
	
	public void setupNewWorld(){
		farm.setupNewFarm();
		farm.getInfoOfEntities();
	}
	
	public void increaseTime() {
		this.time = this.time+1;
		System.out.println("Time now is: " +time);
		farm.updateTime(time);
		farm.allEntitiesDoSomethingForAnHour();
		farm.growSomeGrass();
		farm.cowEatGrass();
		farm.getInfoOfEntities();
	}
}