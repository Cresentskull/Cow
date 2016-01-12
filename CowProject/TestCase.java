import java.lang.*;
public class TestCase{	
	public static void main(String[] args){
		World world;
		world=new World();
		world.setupNewWorld();
		System.out.println();
		world.increaseTime();
		System.out.println();
		world.increaseTime();
		System.out.println();
		world.increaseTime();
//		for(int i = 0; i <= 24; i++) {
//			world.increaseTime();
//			System.out.println("this shit");
		}
	}