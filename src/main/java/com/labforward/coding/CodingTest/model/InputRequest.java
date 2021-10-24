package com.labforward.coding.CodingTest.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class InputRequest {

	private String inputDescription;
	private String searchString;
}
