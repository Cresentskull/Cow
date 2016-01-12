public class TestCase{
	public static void main(String[] args) {
		World world = new World();
		world.setupNewWorld();
		for(int i = 0; i <= 24; i++) {
			world.increaseTime();
		}
	}
}