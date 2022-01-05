package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.delete;

import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.appsdeveloperblog.photoapp.api.account.domain.AccountType;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.update.AccountTypeUpdatedEvent;
import com.appsdeveloperblog.photoapp.api.account.persistence.AccountTypeRepository;

@Component
public class DeleteAccountTypeEventsHandler {
	private AccountTypeRepository accountTypeRepository;

	@Autowired
	public DeleteAccountTypeEventsHandler(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}
	
	@EventHandler
	public void on (AccountTypeDeletedEvent accountTypeDeletedEvent) {
		
		this.accountTypeRepository.deleteById(accountTypeDeletedEvent.getAccountTypeId());
		
	}
}
