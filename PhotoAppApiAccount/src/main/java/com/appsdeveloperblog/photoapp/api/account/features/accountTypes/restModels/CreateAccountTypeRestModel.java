package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.restModels;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CreateAccountTypeRestModel {

	private String accountName;//free business team vs.
	
	private double price;
	
	private String description;
	
}
