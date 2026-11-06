package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.DebitCard;
import com.klef.soa.repository.DebitCardRepository;

@Service
public class DebitCardServiceImpl implements DebitCardService {

	@Autowired
	private DebitCardRepository repo;

	@Override
	public DebitCard addDebitCard(DebitCard d) {
		return repo.save(d);
	}

	@Override
	public DebitCard updateDebitCard(DebitCard d) {

		Optional<DebitCard> optional = repo.findById(d.getDebitCardId());

		if(optional.isPresent()) {

			DebitCard debitCard = optional.get();

			debitCard.setHolderName(d.getHolderName());
			debitCard.setType(d.getType());
			debitCard.setStatus(d.getStatus());
			debitCard.setLocation(d.getLocation());

			return repo.save(debitCard);

		}
		else {

			return null;

		}

	}

	@Override
	public List<DebitCard> displayAllDebitCards() {
		return repo.findAll();
	}

	@Override
	public DebitCard displayDebitCardById(Long debitCardId) {
		return repo.findById(debitCardId).orElse(null);
	}

	@Override
	public String deleteDebitCardById(Long debitCardId) {

		boolean flag = repo.existsById(debitCardId);

		if(flag) {

			repo.deleteById(debitCardId);

			return "Debit Card Deleted Successfully";

		}
		else {

			return "Debit Card ID Not Found";

		}

	}

	@Override
	public List<DebitCard> displayDebitCardsByHolderName(String holderName) {
		return repo.findByHolderName(holderName);
	}

	@Override
	public List<DebitCard> displayDebitCardsByType(String type) {
		return repo.findByType(type);
	}

	@Override
	public Long debitCardCount() {
		return repo.count();
	}

}