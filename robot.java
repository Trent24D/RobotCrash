import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Main {
	public static void main(String[] args) {
		Robot robotOne = new Robot(new Random().nextInt(101), new Random().nextInt(101), 1);
		Robot robotTwo = new Robot(new Random().nextInt(101), new Random().nextInt(101), 2);
		Robot robotThree = new Robot(new Random().nextInt(101), new Random().nextInt(101), 3);
		Robot robotFour = new Robot(new Random().nextInt(101), new Random().nextInt(101), 4);
		int counter = 0;

		if (robotOne.isColliding(robotTwo) || robotOne.isColliding(robotThree) ||
			robotOne.isColliding(robotFour) || robotTwo.isColliding(robotThree) ||
			robotTwo.isColliding(robotFour) || robotThree.isColliding(robotFour)) {
			System.out.println("The robots have collided on spawn.");
			return;
		}

		List<Integer> allRobotXAxis = new ArrayList<>(); 
		List<Integer> allRobotYAxis = new ArrayList<>();
		List<Integer> secret = new ArrayList<>();
		List<String> Hit = new ArrayList<>();

		int round = 1;
		while (true) {

			allRobotXAxis.clear();
			allRobotYAxis.clear();
			secret.clear();
			Hit.clear();

			allRobotXAxis.add(robotOne.getHorizontal()); 
			allRobotXAxis.add(robotTwo.getHorizontal());
			allRobotXAxis.add(robotThree.getHorizontal());
			allRobotXAxis.add(robotFour.getHorizontal());


			allRobotYAxis.add(robotOne.getVertical());
			allRobotYAxis.add(robotTwo.getVertical());
			allRobotYAxis.add(robotThree.getVertical());
			allRobotYAxis.add(robotFour.getVertical());


			secret.add(robotOne.getCode());
			secret.add(robotTwo.getCode());
			secret.add(robotThree.getCode());
			secret.add(robotFour.getCode());

			robotOne.Move(allRobotXAxis, allRobotYAxis, Hit, counter, robotOne, robotTwo, robotThree, robotFour);
			allRobotXAxis.clear();
			allRobotYAxis.clear();
			secret.clear();
			Hit.clear();

			allRobotXAxis.add(robotOne.getHorizontal()); 
			allRobotXAxis.add(robotTwo.getHorizontal());
			allRobotXAxis.add(robotThree.getHorizontal());
			allRobotXAxis.add(robotFour.getHorizontal());


			allRobotYAxis.add(robotOne.getVertical());
			allRobotYAxis.add(robotTwo.getVertical());
			allRobotYAxis.add(robotThree.getVertical());
			allRobotYAxis.add(robotFour.getVertical());

			robotTwo.Move(allRobotXAxis,allRobotYAxis, Hit, counter, robotOne, robotTwo, robotThree, robotFour);
			allRobotXAxis.clear();
			allRobotYAxis.clear();
			secret.clear();
			Hit.clear();

			allRobotXAxis.add(robotOne.getHorizontal()); 
			allRobotXAxis.add(robotTwo.getHorizontal());
			allRobotXAxis.add(robotThree.getHorizontal());
			allRobotXAxis.add(robotFour.getHorizontal());


			allRobotYAxis.add(robotOne.getVertical());
			allRobotYAxis.add(robotTwo.getVertical());
			allRobotYAxis.add(robotThree.getVertical());
			allRobotYAxis.add(robotFour.getVertical());

			robotThree.Move(allRobotXAxis, allRobotYAxis, Hit, counter, robotOne, robotTwo, robotThree, robotFour);
			allRobotXAxis.clear();
			allRobotYAxis.clear();
			secret.clear();
			Hit.clear();

			allRobotXAxis.add(robotOne.getHorizontal()); 
			allRobotXAxis.add(robotTwo.getHorizontal());
			allRobotXAxis.add(robotThree.getHorizontal());
			allRobotXAxis.add(robotFour.getHorizontal());


			allRobotYAxis.add(robotOne.getVertical());
			allRobotYAxis.add(robotTwo.getVertical());
			allRobotYAxis.add(robotThree.getVertical());
			allRobotYAxis.add(robotFour.getVertical());

			robotFour.Move(allRobotXAxis, allRobotYAxis, Hit, counter, robotOne, robotTwo, robotThree, robotFour);
			allRobotXAxis.clear();
			allRobotYAxis.clear();
			secret.clear();
			Hit.clear();

			allRobotXAxis.add(robotOne.getHorizontal()); 
			allRobotXAxis.add(robotTwo.getHorizontal());
			allRobotXAxis.add(robotThree.getHorizontal());
			allRobotXAxis.add(robotFour.getHorizontal());


			allRobotYAxis.add(robotOne.getVertical());
			allRobotYAxis.add(robotTwo.getVertical());
			allRobotYAxis.add(robotThree.getVertical());
			allRobotYAxis.add(robotFour.getVertical());


			System.out.println("Round " + round);
			System.out.println("Robot One Coordinates: (" + robotOne.getHorizontal() + ", " + robotOne.getVertical() + ")");
			System.out.println("Robot Two Coordinates: (" + robotTwo.getHorizontal() + ", " + robotTwo.getVertical() + ")");
			System.out.println("Robot Three Coordinates: (" + robotThree.getHorizontal() + ", " + robotThree.getVertical() + ")");
			System.out.println("Robot Four Coordinates: (" + robotFour.getHorizontal() + ", " + robotFour.getVertical() + ")");

			round++;
		}
	}
}

class Robot {
	private int PointXAxis;
	private int PointYAxis;
	private int unique;

	public Robot(int a, int b, int unique) {
		PointXAxis = a;
		PointYAxis = b;
		this.unique = unique;
	}

	public int getHorizontal() {
		return PointXAxis;
	}

	public int getVertical() {
		return PointYAxis;
	}

	public int getCode() {
		return unique;
	}

	public boolean isColliding(Robot other) {
		return this.PointXAxis == other.PointXAxis && this.PointYAxis == other.PointYAxis;
	}

	public void Move(List<Integer> allRobotXAxis, List<Integer> allRobotYAxis, List<String> Hit, int counter, Robot robotOne, Robot robotTwo, Robot robotThree, Robot robotFour) {
		Random random = new Random();
		int RandX = random.nextInt(21) - 10;
		int RandY = random.nextInt(21) - 10;
		

		if (RandX < 0) {
			for (int i = 0; i < Math.abs(RandX); i++) {
				PointXAxis = PointXAxis - 1;
				if (PointXAxis > 100) {
					PointXAxis = 100;
				}

				if (PointYAxis > 100) {
					PointYAxis = 100;
				}

				if (PointXAxis < 0) {
					PointXAxis = 0;

				}
				if (PointYAxis < 0) {
					PointYAxis = 0;
				}
				
				if (PointXAxis == allRobotXAxis.get(0) && PointYAxis == allRobotYAxis.get(0)){
							counter = counter + 1;
							Hit.add("One");
				}

				if (PointXAxis == allRobotXAxis.get(1) && PointYAxis == allRobotYAxis.get(1)){
					counter = counter + 1;
					Hit.add("Two");
				}

				if (PointXAxis == allRobotXAxis.get(2) && PointYAxis == allRobotYAxis.get(2)){
					counter = counter + 1;
					Hit.add("Three");
				}

				if (PointXAxis == allRobotXAxis.get(3) && PointYAxis == allRobotYAxis.get(3)){
					counter = counter + 1;
					Hit.add("Four");
				}

				

				if (counter == 2 && Hit.get(0) != Hit.get(1)){
					System.out.println("Crash Detected: ");
					System.out.println("Robot One Coordinates: (" + robotOne.getHorizontal() + ", " + robotOne.getVertical() + ")");
					System.out.println("Robot Two Coordinates: (" + robotTwo.getHorizontal() + ", " + robotTwo.getVertical() + ")");
					System.out.println("Robot Three Coordinates: (" + robotThree.getHorizontal() + ", " + robotThree.getVertical() + ")");
					System.out.println("Robot Four Coordinates: (" + robotFour.getHorizontal() + ", " + robotFour.getVertical() + ")");
					
					System.out.println("Robot " + Hit.get(0) + " and Robot " + Hit.get(1) + " have collided at point (" + PointXAxis + ", " + PointYAxis + ")");
					System.exit(0);
				}

				else{
					Hit.clear();
					counter = 0;
					continue;
				}		
			}
		}	
			
		
		if (RandX > 0) {
			for (int i = 0; i < Math.abs(RandX); i++) {
				PointXAxis = PointXAxis + 1;
				if (PointXAxis > 100) {
					PointXAxis = 100;
				}
	
				if (PointYAxis > 100) {
					PointYAxis = 100;
				}
	
				if (PointXAxis < 0) {
					PointXAxis = 0;
				}
				if (PointYAxis < 0) {
					PointYAxis = 0;
				}
			
				if (PointXAxis == allRobotXAxis.get(0) && PointYAxis == allRobotYAxis.get(0)){
					counter = counter + 1;
					Hit.add("One");
				}

				if (PointXAxis == allRobotXAxis.get(1) && PointYAxis == allRobotYAxis.get(1)){
					counter = counter + 1;
					Hit.add("Two");
				}

				if (PointXAxis == allRobotXAxis.get(2) && PointYAxis == allRobotYAxis.get(2)){
					counter = counter + 1;
					Hit.add("Three");
				}

				if (PointXAxis == allRobotXAxis.get(3) && PointYAxis == allRobotYAxis.get(3)){
					counter = counter + 1;
					Hit.add("Four");
				}

				

				if (counter == 2 && Hit.get(0) != Hit.get(1)){
					System.out.println("Crash Detected: ");
					System.out.println("Robot One Coordinates: (" + robotOne.getHorizontal() + ", " + robotOne.getVertical() + ")");
					System.out.println("Robot Two Coordinates: (" + robotTwo.getHorizontal() + ", " + robotTwo.getVertical() + ")");
					System.out.println("Robot Three Coordinates: (" + robotThree.getHorizontal() + ", " + robotThree.getVertical() + ")");
					System.out.println("Robot Four Coordinates: (" + robotFour.getHorizontal() + ", " + robotFour.getVertical() + ")");
						System.out.println("Robot " + Hit.get(0) + " and Robot " + Hit.get(1) + " have collided at point (" + PointXAxis + ", " + PointYAxis + ")");
						System.exit(0);
					}

				else{
					Hit.clear();
					counter = 0;
					continue;
				}
			}			
		}
		

		if (RandY > 0) {
			for (int i = 0; i < Math.abs(RandX); i++) {
				PointYAxis = PointYAxis + 1;
				if (PointXAxis > 100) {
					PointXAxis = 100;
				}
	
				if (PointYAxis > 100) {
					PointYAxis = 100;
				}
	
				if (PointXAxis < 0) {
					PointXAxis = 0;
				}
				if (PointYAxis < 0) {
					PointYAxis = 0;
				}
			
				if (PointXAxis == allRobotXAxis.get(0) && PointYAxis == allRobotYAxis.get(0)){
					counter = counter + 1;
					Hit.add("One");
				}

				if (PointXAxis == allRobotXAxis.get(1) && PointYAxis == allRobotYAxis.get(1)){
					counter = counter + 1;
					Hit.add("Two");
				}

				if (PointXAxis == allRobotXAxis.get(2) && PointYAxis == allRobotYAxis.get(2)){
					counter = counter + 1;
					Hit.add("Three");
				}

				if (PointXAxis == allRobotXAxis.get(3) && PointYAxis == allRobotYAxis.get(3)){
					counter = counter + 1;
					Hit.add("Four");
				}

				
				if (counter == 2 && Hit.get(0) != Hit.get(1)){
					System.out.println("Crash Detected: ");
					System.out.println("Robot One Coordinates: (" + robotOne.getHorizontal() + ", " + robotOne.getVertical() + ")");
					System.out.println("Robot Two Coordinates: (" + robotTwo.getHorizontal() + ", " + robotTwo.getVertical() + ")");
					System.out.println("Robot Three Coordinates: (" + robotThree.getHorizontal() + ", " + robotThree.getVertical() + ")");
					System.out.println("Robot Four Coordinates: (" + robotFour.getHorizontal() + ", " + robotFour.getVertical() + ")");
					System.out.println("Robot " + Hit.get(0) + " and Robot " + Hit.get(1) + " have collided at point (" + PointXAxis + ", " + PointYAxis + ")");
					System.exit(0);
				}

				else{
					Hit.clear();
					counter = 0;
					continue;
				}				
			}
		}
		
		if (RandY < 0) {
			for (int i = 0; i < Math.abs(RandX); i++) {
				PointYAxis = PointYAxis - 1;
				if (PointXAxis > 100) {
					PointXAxis = 100;
				}
	
				if (PointYAxis > 100) {
					PointYAxis = 100;
				}
	
				if (PointXAxis < 0) {
					PointXAxis = 0;
				}
				if (PointYAxis < 0) {
					PointYAxis = 0;
				}
			
				if (PointXAxis == allRobotXAxis.get(0) && PointYAxis == allRobotYAxis.get(0)){
					counter = counter + 1;
					Hit.add("One");
				}

				if (PointXAxis == allRobotXAxis.get(1) && PointYAxis == allRobotYAxis.get(1)){
					counter = counter + 1;
					Hit.add("Two");
				}

				if (PointXAxis == allRobotXAxis.get(2) && PointYAxis == allRobotYAxis.get(2)){
					counter = counter + 1;
					Hit.add("Three");
				}

				if (PointXAxis == allRobotXAxis.get(3) && PointYAxis == allRobotYAxis.get(3)){
					counter = counter + 1;
					Hit.add("Four");
				}

				

				if (counter == 2 && Hit.get(0) != Hit.get(1)){
					System.out.println("Crash Detected: ");
					System.out.println("Robot One Coordinates: (" + robotOne.getHorizontal() + ", " + robotOne.getVertical() + ")");
					System.out.println("Robot Two Coordinates: (" + robotTwo.getHorizontal() + ", " + robotTwo.getVertical() + ")");
					System.out.println("Robot Three Coordinates: (" + robotThree.getHorizontal() + ", " + robotThree.getVertical() + ")");
					System.out.println("Robot Four Coordinates: (" + robotFour.getHorizontal() + ", " + robotFour.getVertical() + ")");
					System.out.println("Robot " + Hit.get(0) + " and Robot " + Hit.get(1) + " have collided at point (" + PointXAxis + ", " + PointYAxis + ")");
					System.exit(0);
				}

				else{
					Hit.clear();
					counter = 0;
					continue;
				}				
			}
		}		
	}
}
