package com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.update;

import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.appsdeveloperblog.photoapp.api.account.domain.AccountType;
import com.appsdeveloperblog.photoapp.api.account.features.accountTypes.commands.create.AccountTypeCreatedEvent;
import com.appsdeveloperblog.photoapp.api.account.persistence.AccountTypeRepository;


@Aggregate
public class UpdateAccountTypeAggregate {
	
	@AggregateIdentifier
	private String identifier=UUID.randomUUID().toString();
	
	
	private String accountTypeId;
	private String accountName;
	private double price;
	private String description;
	
	public UpdateAccountTypeAggregate() {
	
	}
	
	
	@CommandHandler
	public UpdateAccountTypeAggregate(UpdateAccountTypeCommand updateAccountTypeCommand) {
		//valid
		
		
		
		//bussines
		
		
		
		
		//event fire
		AccountTypeUpdatedEvent accountTypeUpdatedEvent = new AccountTypeUpdatedEvent();
		BeanUtils.copyProperties(updateAccountTypeCommand, accountTypeUpdatedEvent);
		AggregateLifecycle.apply(accountTypeUpdatedEvent);
		

	}
	
	@EventSourcingHandler
	public void on(AccountTypeUpdatedEvent accountTypeupdateEvent) {
		
		this.accountTypeId=accountTypeupdateEvent.getAccountTypeId();
		this.accountName = accountTypeupdateEvent.getAccountName();
		this.description = accountTypeupdateEvent.getDescription();
		this.price=accountTypeupdateEvent.getPrice();
		
		
	}
	
}
