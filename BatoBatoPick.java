import java.util.Random;
import java.util.Scanner;


public class BatoBatoPick {

	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		
		String[] picks = {"Bato", "Papel", "Gunting"};
		int user = -1;
		
		do {
			System.out.print("\n1=Bato, 2=Papel, 3=Gunting: ");
			user = scan.nextInt();
			
			Random random = new Random();
			int comp = random.nextInt(3) + 1;
			boolean winner = false;
			
			switch (user) {
			case 1: {
				if (comp == 3)
					winner = true;
				break;
			}
			case 2: {
				//(?) - ternary operator
				// - shortcut to if/else, demo only
				winner = (comp == 1) ? true: false;  
				break;
			}
			case 3: {
				if (comp == 2)
					winner = true;
				break;
			}
			case 0: {
				System.out.println("Quitter!");
				return;
			}
			default:
				System.out.println("Invalid input.");
				continue;
			}
			System.out.println("Bato...");
			Thread.sleep(500);
			System.out.println("Bato...");
			Thread.sleep(500);
			System.out.println("Pick!");
			
			System.out.println("Your pick: " + picks[user - 1]);
			System.out.println("Computer`s pick: " + picks[comp - 1]);
			System.out.print("Result: ");
			if (user == comp)
				System.out.println("Draw.");
			else if (winner)
				System.out.println("You win.");
			else
				System.out.println("You lose.");
			
		} while (user != 0);

	}

}