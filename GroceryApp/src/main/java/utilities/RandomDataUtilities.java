package utilities;

import java.util.Random;

public class RandomDataUtilities {
	
	public int  randon() {
		Random random = new Random();
		int limit = 1000;
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}
}
