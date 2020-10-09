import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task4_CountryTour {
	public static void main(String[] args) {
		Scanner sp = new Scanner(System.in);
		int n = sp.nextInt();
		Map<Integer, Integer> countries = new HashMap<Integer, Integer>();
		sp.nextLine();

		for (int i = 0; i < n; i++) {
			String[] numbers = sp.nextLine().split(" ");
			countries.put(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
		}
		int theFirstCountry = 0;
		int distance = 0;
		int food = 0;
		String lastCountry=" ";

		for (Map.Entry<Integer, Integer> country : countries.entrySet()) {
			distance = country.getKey();
			food += country.getValue();
			lastCountry=distance+" "+food;
			if (distance <= food) {
				theFirstCountry ++;
				food = food - distance;
			}
			
		}
		if(lastCountry.toCharArray()[0]==lastCountry.toCharArray()[2]) {
		System.out.println(theFirstCountry);
		}else {
			System.out.println("NO");
		}

	}

}
