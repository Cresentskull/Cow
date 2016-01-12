import java.util.*;
public class FlyingCow extends Cow {
	public FlyingCow (String name, int x, int y) {
		super(name,x,y);
	}
	public void move() {
		Random rand = new Random();
		int newX = rand.nextInt(100) + 1;
		int newY = rand.nextInt(100) + 1;
		Boolean canMove = !checkCollision(newX, newY);

		if(canMove){
			this.coordinateX = newX;
			this.coordinateY = newY;
		}
		
	}
}