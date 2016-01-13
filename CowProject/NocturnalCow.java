import java.util.*;
public class NocturnalCow extends Cow {
	int timeon24;
	public void updateTime(int time){
		this.timeon24 = time%24;
//		System.out.println(timeon24);
	}
	public boolean isNocAwake(){
	if((this.timeon24 < 6 || this.timeon24 > 18)){
		return true;
	}
	else
		return false;
	}
	public NocturnalCow (String name, int x, int y) {
		super(name,x,y);
	}
	public void doStuffForAnHour() {
		if(this.isNocAwake()) {
//			System.out.println(this.name+" is awake");
			move();
			super.eat();
			kill();
		}
		else
//			System.out.println(this.name+" is asleep");
		makeHungry();
		this.age++;
	}
}