package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.delete;

import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.update.AccountTypeUpdatedEvent;

@Aggregate
public class DeleteAccountTypeAggregate {
	
	
	@AggregateIdentifier
	private String identifier=UUID.randomUUID().toString();
	
	
	private String accountTypeId;


	public DeleteAccountTypeAggregate() {
		super();
	}
	
	@CommandHandler
	public DeleteAccountTypeAggregate(DeleteAccountTypeCommand deleteAccountTypeCommand) {
		//valid 
		
	
		//bussines
		
		//event fire
		AccountTypeDeletedEvent accountTypeDeletedEvent = new AccountTypeDeletedEvent();
		BeanUtils.copyProperties(deleteAccountTypeCommand, accountTypeDeletedEvent);
		AggregateLifecycle.apply(accountTypeDeletedEvent);
		

		
		
	}
	
	
	@EventSourcingHandler
	public void on(AccountTypeDeletedEvent accountTypeDeletedEvent) {
		
		this.accountTypeId=accountTypeDeletedEvent.getAccountTypeId();
		
		
	}
}
