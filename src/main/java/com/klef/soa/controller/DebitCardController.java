package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.entity.DebitCard;
import com.klef.soa.service.DebitCardService;

@RestController
@RequestMapping("/debitcard")
public class DebitCardController
{
	@Autowired
	private DebitCardService service;

	@GetMapping("/")
	public String demo()
	{
		return "Spring Boot Project";
	}

	// Add Debit Card
	@PostMapping("/add")
	public ResponseEntity<DebitCard> addDebitCard(@RequestBody DebitCard d)
	{
		DebitCard debitCard = service.addDebitCard(d);
		return ResponseEntity.status(201).body(debitCard);
	}

	// Display All Debit Cards
	@GetMapping("/displayall")
	public ResponseEntity<List<DebitCard>> displayAllDebitCards()
	{
		List<DebitCard> debitCards = service.displayAllDebitCards();
		return ResponseEntity.status(200).body(debitCards);
	}

	// Display Debit Card By ID
	@GetMapping("/display")
	public ResponseEntity<?> displayDebitCardById(@RequestParam Long id)
	{
		DebitCard debitCard = service.displayDebitCardById(id);

		if (debitCard != null)
		{
			return ResponseEntity.status(200).body(debitCard);
		}
		else
		{
			return ResponseEntity.status(404).body("Debit Card ID Not Found");
		}
	}

	// Update Debit Card
	@PutMapping("/update")
	public ResponseEntity<?> updateDebitCard(@RequestBody DebitCard debitCard)
	{
		DebitCard d = service.updateDebitCard(debitCard);

		if (d != null)
		{
			return ResponseEntity.ok(d);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Debit Card ID Not Found");
		}
	}

	// Delete Debit Card By ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDebitCardById(@PathVariable Long id)
	{
		String message = service.deleteDebitCardById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	// Display Debit Cards By Holder Name
	@GetMapping("/displaybyholdername/{holderName}")
	public ResponseEntity<List<DebitCard>> displayDebitCardsByHolderName(@PathVariable String holderName)
	{
		List<DebitCard> debitCards = service.displayDebitCardsByHolderName(holderName);
		return ResponseEntity.status(200).body(debitCards);
	}

	// Display Debit Cards By Type
	@GetMapping("/displaybytype/{type}")
	public ResponseEntity<List<DebitCard>> displayDebitCardsByType(@PathVariable String type)
	{
		List<DebitCard> debitCards = service.displayDebitCardsByType(type);
		return ResponseEntity.status(200).body(debitCards);
	}

	// Debit Card Count
	@GetMapping("/count")
	public ResponseEntity<String> debitCardCount()
	{
		Long count = service.debitCardCount();
		String msg = "Total Debit Cards = " + count;
		return ResponseEntity.ok(msg);
	}
}