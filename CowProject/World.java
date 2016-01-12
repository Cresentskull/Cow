import java.lang.*;

public class World {
	public int time;
	public Farm1 farm = new Farm1();

	public World(){}
	
	public void setupNewWorld(){
		farm.setupNewFarm();
	}
	
	public void increaseTime() {
		this.time = this.time+1;
		farm.updateTime(time);
		farm.allEntitiesDoSomethingForAnHour();
	}
}