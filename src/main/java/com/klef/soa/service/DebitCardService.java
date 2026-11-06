package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.DebitCard;

public interface DebitCardService {

	DebitCard addDebitCard(DebitCard d);

	DebitCard updateDebitCard(DebitCard d);

	List<DebitCard> displayAllDebitCards();

	DebitCard displayDebitCardById(Long debitCardId);

	String deleteDebitCardById(Long debitCardId);

	List<DebitCard> displayDebitCardsByHolderName(String holderName);

	List<DebitCard> displayDebitCardsByType(String type);

	Long debitCardCount();

}