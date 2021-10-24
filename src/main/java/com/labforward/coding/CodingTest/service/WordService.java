package com.labforward.coding.CodingTest.service;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labforward.coding.CodingTest.model.InputRequest;
import com.labforward.coding.CodingTest.model.ResponseObject;
import com.labforward.coding.CodingTest.utils.WordUtils;

/**
 * 
 * Service layer for word analysis
 * @author Amrutha
 *
 */

@Service
public class WordService {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	@Autowired
	WordUtils wordUtils;

	/**
	 * Method to get the word analysis reposrt
	 * @param testInput
	 * @return ResponseObject
	 */
	public ResponseObject getWordAnalysisReport(InputRequest testInput) {
		LOG.info("******** Service layer Entry********");
		String splitTextDescription[] = null;

		ResponseObject responseObj = new ResponseObject();
		if (testInput != null) {
			splitTextDescription = testInput.getInputDescription().split(" ");
			Long count = wordUtils.getWordFrequency(splitTextDescription, testInput.getSearchString());
			responseObj.setFrequency(count);
			HashSet<String> similarWordsSet = wordUtils.findSimilarWords(splitTextDescription,
					testInput.getSearchString());
			responseObj.setSimilarWords(similarWordsSet);
		}
		LOG.info("******** Exit Service layer ********" + responseObj);
		return responseObj;

	}
}
