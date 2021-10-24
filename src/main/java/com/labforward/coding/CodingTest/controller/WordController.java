package com.labforward.coding.CodingTest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.labforward.coding.CodingTest.model.InputRequest;
import com.labforward.coding.CodingTest.model.ResponseObject;
import com.labforward.coding.CodingTest.service.WordService;

/**
 * 
 * Controller layer for the word analysis API
 * 
 * @author Amrutha
 *
 */

@RestController
@RequestMapping(value = "/word")
@CrossOrigin(origins = "*")
public class WordController {

	@Autowired
	private WordService wordService;

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	/**
	 * Method to get the word analysis report
	 * 
	 * @param inputData
	 * @return ResponseEntity
	 */
	@PostMapping(value = "/get")
	public ResponseEntity<?> getWordAnalysisReport(@RequestBody InputRequest inputData) {

		LOG.info("******** Controller layer Entry********");

		ResponseObject wordReport = null;
		ResponseEntity<?> responseEntity = null;
		try {
			wordReport = wordService.getWordAnalysisReport(inputData);
			if (wordReport != null) {
				responseEntity = new ResponseEntity<>(wordReport, HttpStatus.OK);
			} else {
				responseEntity = ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
		} catch (Exception ex) {
			responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

		return responseEntity;

	}
}
