package com.labforward.coding.CodingTest.model;

import java.util.HashSet;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ResponseObject {

	private Long frequency;
	private HashSet<String> similarWords;

}
