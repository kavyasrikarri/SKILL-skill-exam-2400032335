
package com.klef.soa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

import com.klef.soa.entity.DebitCard;
import com.klef.soa.repository.DebitCardRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DebitCardRepositoryTest
{
    @Autowired
    private DebitCardRepository repository;

    @Test
    void testFindAllDebitCards()
    {
        List<DebitCard> cards = repository.findAll();
        assertNotNull(cards);
        assertFalse(cards.isEmpty());
        System.out.println("Total Debit Cards: " + cards.size());
    }

    @Test
    void testFindDebitCardById()
    {
        Optional<DebitCard> card = repository.findById(2L);
        assertTrue(card.isPresent());
        assertEquals(2L, card.get().getDebitCardId());
        System.out.println("Debit Card ID: " + card.get().getDebitCardId());
        System.out.println("Holder Name: " + card.get().getHolderName());
    }

    @Test
    void testFindDebitCardByInvalidId()
    {
        Optional<DebitCard> card = repository.findById(9999L);
        assertFalse(card.isPresent());
    }

    @Test
    void testDatabaseConnection()
    {
        long count = repository.count();
        assertTrue(count >= 0);
        System.out.println("Total Debit Cards in Database: " + count);
    }

    @Test
    void testDebitCardDetails()
    {
        Optional<DebitCard> card = repository.findById(2L);
        assertTrue(card.isPresent());

        DebitCard foundCard = card.get();

        assertNotNull(foundCard.getHolderName());
        assertNotNull(foundCard.getType());
        assertNotNull(foundCard.getStatus());
        assertNotNull(foundCard.getLocation());

        System.out.println("Holder Name: " + foundCard.getHolderName());
        System.out.println("Type: " + foundCard.getType());
        System.out.println("Status: " + foundCard.getStatus());
        System.out.println("Location: " + foundCard.getLocation());
    }

    @Test
    void testTotalDebitCardCount()
    {
        long count = repository.count();
        assertEquals(2L, count);
    }

    @Test
    void testFindDebitCardByHolderName()
    {
    	List<DebitCard> cards = repository.findByHolderName("Lakshmi");

    	assertNotNull(cards);
    	assertFalse(cards.isEmpty());
    	assertEquals("Lakshmi", cards.get(0).getHolderName());

    	System.out.println("Holder Name: " + cards.get(0).getHolderName());
}