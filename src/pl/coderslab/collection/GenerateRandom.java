package pl.coderslab.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GenerateRandom {
	public static void main(String[] args) {
	
		Map<Integer, Integer> randomMap = checkRandom(10000, 15);
		for (Map.Entry<Integer, Integer> entry : randomMap.entrySet()) {
			String result= "Liczba "+entry.getKey()+" została wylosowana "+entry.getValue()+" razy";
			System.out.println(result);
			
		}
			
		}

	public static Map<Integer, Integer> checkRandom(int amount, int interval) {
		Map<Integer, Integer> randomMap = new HashMap<>();
		Random r = new Random();
		List<Integer> randomNumbers = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			randomNumbers.add(r.nextInt(interval));
		}
		for (int i = 0; i < interval; i++) {
			List<Integer> tempList = new ArrayList<>();
			List<Integer> elements = Arrays.asList(i);
			tempList.addAll(randomNumbers);
			tempList.retainAll(elements);
			randomMap.put(i, tempList.size());

		}
		return randomMap;
	}
}
// #### Zadanie 1
// W projekcie utwórz pakiet `pl.coderslab.collection`, w pakiecie utwórz klasę
// `GenerateRandom` zawierającą metodę o sygnaturze:
// `public static Map<Integer, Integer> checkRand(int amount, int interval)`,
// metoda ta ma zwracać mapę wystąpień wartości losowych generowanych za pomocą
// klasy `Random`.
//
// Kluczem mapy ma być losowana liczba, wartością ilość jej wystąpień.
//
// Parametry:
// - `amount` - oznaczają ilość losowań jaka ma być wykonana.
// - `interval` - zakres wartości dla metody klasy `nextInt` klasy `Random`.
//
// Przykładowy wynik wyświetlenia elementów mapy dla wywołania metody z
// parametrami `amount` = 500000 oraz `interval` = 10:
//
// ````
// 0 : 50082
// 1 : 49956
// 2 : 49771
// 3 : 50001
// 4 : 50036
// 5 : 49699
// 6 : 50082
// 7 : 50272
// 8 : 50094
// 9 : 50007
//
// ````
