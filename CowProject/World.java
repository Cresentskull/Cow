import java.lang.*;

public class World {
	public int time = 6;
	public Farm1 farm = new Farm1();

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
		farm.getInfoOfEntities();
	}
}