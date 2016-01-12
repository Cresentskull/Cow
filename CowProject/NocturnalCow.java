import java.util.*;
public class NocturnalCow extends Cow {
	int time;
	public void updateTime(int time){
		this.time = time;
	}
	public NocturnalCow (String name, int x, int y) {
		super(name,x,y);
	}
	public void doStuffForAnHour() {
		if(isAwake()) {
			System.out.println(this.name+" is asleep");
		}
		else {
			System.out.println(this.name+" is awake");
			move();
			eat();
			makeHungry();
			kill();
		}
		this.age++;
		this.hungriness = hungriness+2;
	}
}