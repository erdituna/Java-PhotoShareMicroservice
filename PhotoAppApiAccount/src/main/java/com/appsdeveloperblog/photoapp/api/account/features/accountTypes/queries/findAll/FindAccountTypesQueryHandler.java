package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.queries.findAll;

import java.util.ArrayList;
import java.util.List;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.photoapp.api.account.domain.AccountType;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.restModels.AccountTypeListRestModel;
import com.appsdeveloperblog.photoapp.api.account.persistence.AccountTypeRepository;

@Component
public class FindAccountTypesQueryHandler {

	private AccountTypeRepository accountTypeRepository;
	
	@Autowired
	public FindAccountTypesQueryHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}
	
	@QueryHandler
	public List<AccountTypeListRestModel> findAccountTypes(FindAccountTypesQuery findAccountTypesQuery){
		
		List<AccountType> accountTypes = this.accountTypeRepository.findAll();
		
		List<AccountTypeListRestModel> result = new ArrayList<>();
		
		for (AccountType accountType : accountTypes) {
			
			AccountTypeListRestModel model = new AccountTypeListRestModel();
			BeanUtils.copyProperties(accountType, model);
			result.add(model);
		}
		
		
		return result;
	}
	
	@QueryHandler
	public AccountTypeListRestModel getById(FindAccountTypeGetByIdQuery findAccountTypeGetByIdQuery) {
		AccountType accountType = this.accountTypeRepository.findByAccountTypeId(findAccountTypeGetByIdQuery.getAccountTypeId());
		AccountTypeListRestModel result = new AccountTypeListRestModel();
		BeanUtils.copyProperties(accountType,result);
		return result;
	}
	
	
}





