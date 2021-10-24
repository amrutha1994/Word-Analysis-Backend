package com.labforward.coding.CodingTest.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class WordUtils {
	
	/**
	 * Method to find the frequency of a given word in the text
	 * @param textDescription
	 * @param searchKey
	 * @return Long count
	 */
	public Long getWordFrequency(String[] textDescription, String searchKey) {
		return Arrays.stream(textDescription).filter(word -> word.equals(searchKey)).count();
	}

	/**
	 * Method to find similar words in a text
	 * @param textDescription
	 * @param key
	 * @return HashSet<String> similarWordsList
	 */
	public HashSet<String> findSimilarWords(String[] textDescription, String key) {

		int keyCount = key.length();
		int keyCountPlus = key.length() + 1;
		int keyCountMinus = key.length() - 1;

		HashSet<String> listToTraverse = new HashSet<String>();
		HashSet<String> similarWordsList = new HashSet<String>();
		List<Integer> lengthList = Arrays.asList(keyCountMinus, keyCount, keyCountPlus);
		Arrays.stream(textDescription).forEach(item -> {
			if (lengthList.contains(item.length())) {
				if (!item.equals(key)) {
					listToTraverse.add(item);
				}

			}
		});
		listToTraverse.forEach(item -> {
			if (keyCount < item.length()) {
				if (item.startsWith(key) || item.endsWith(key)) {
					similarWordsList.add(item);
				}
			} else if (keyCount > item.length()) {
				if (key.startsWith(item) || key.endsWith(item)) {
					similarWordsList.add(item);
				}
			} else if (keyCount == item.length()) {
				char[] splitKey = key.toCharArray();
				char[] splitItem = item.toCharArray();
				int count = 0;
				for (int i = 0; i < keyCount; i++) {
					if (splitKey[i] != splitItem[i]) {
						count++;
					}
				}
				if (count <= 1) {
					similarWordsList.add(item);
				}
			}

		});
		return similarWordsList;

	}
}
