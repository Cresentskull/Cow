public class World {
	public int time;
	public Farm farm;

	public void setupNewWorld() {
		farm.setupNewFarm();
	}
	
	public void increaseTime() {
		this.time = this.time+1;
		farm.updateTime(time);
		farm.allEntitiesDoSomethingForAnHour();
	}
}