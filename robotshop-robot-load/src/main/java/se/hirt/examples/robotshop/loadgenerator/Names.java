package se.hirt.examples.robotshop.loadgenerator;

import java.io.IOException;
import java.util.Random;

public class Names {
	public final static Random RND = new Random();

	private final static String [] FIRST_NAMES;
	private final static String [] LAST_NAMES;
	
	static {
			String [] firstNames = null;
			String [] lastNames = null;
			try {
				firstNames = extractStrings("firstnames.txt");
				lastNames = extractStrings("lastnames.txt");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Problem initializing Names. Exiting...");
				System.exit(3);
			}
			FIRST_NAMES = firstNames;
			LAST_NAMES = lastNames;
	}

	private static String [] extractStrings(String resourceName) throws IOException {
		return Utils.getResource(resourceName).split("\\W+");
	}
	
	public static String getRandomName() {
		return FIRST_NAMES[RND.nextInt(FIRST_NAMES.length)] + " " + LAST_NAMES[RND.nextInt(LAST_NAMES.length)];
	}
	
	public static void main(String [] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(getRandomName());
		}
	}
}
