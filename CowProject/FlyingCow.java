import java.util.*;
public class FlyingCow extends Cow {
	public FlyingCow (String name, int x, int y) {
		super(name,x,y);
	}
	public void move() {
		Random rand = new Random();
		int newX = rand.nextInt(10) + 1;
		int newY = rand.nextInt(10) + 1;
		boolean isOccupied = false;
		for(int i = 0; i < farmObjectList.size(); i++) {
				if((newX == farmObjectList.get(i).coordinateX) && (newY == farmObjectList.get(i).coordinateY) && farmObjectList.get(i) instanceof Cow) {
					isOccupied = true;
				}
			}
			if(isOccupied != true){
				this.coordinateX = newX;
				this.coordinateY = newY;
				System.out.println(newX+","+newY);
				super.doStuffForAnHour();
			}
	}
}