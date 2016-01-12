import java.lang.*;
public class TestCase{	
	public static void main(String[] args){
		World world;
		world=new World();
		world.setupNewWorld();
		for(int i = 0; i <= 24; i++) {
			System.out.println();
			world.increaseTime();
			System.out.println();
		}
		System.out.println(world.farm.farmObjectList.size());
	}
}