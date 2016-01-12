import java.util.*;
public class NocturnalCow extends Cow {
	public NocturnalCow (String name, int x, int y) {
		super(name,x,y);
	}
	public void move() {
		if(time<6||time>18){
			Random rand = new Random();
			int n = rand.nextInt(4)+1;
			int deltaX = 0;
			int deltaY = 0;
			boolean isOccupied = false;
			if(n==1) {
				deltaX++;
			}
			else if(n==2) {
				deltaX--;
			}
			else if(n==3) {
				deltaY++;
			}
			else if(n==4) {
				deltaY--;
			}

			for(int i = 0; i < farmObjectList.size(); i++) {
				if((this.coordinateX+deltaX == farmObjectList.get(i).coordinateX) && (this.coordinateY+deltaY == farmObjectList.get(i).coordinateY) && farmObjectList.get(i) instanceof Cow) {
					isOccupied = true;
				}
			}
			if(isOccupied != true){
				this.coordinateX = this.coordinateX+deltaX;
				this.coordinateY = this.coordinateY+deltaY;
				System.out.println(this.coordinateX+","+this.coordinateY);
				super.doStuffForAnHour();
			}
		}
	}
}