package com.klef.soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.DebitCard;
import java.util.List;

@Repository
public interface DebitCardRepository extends JpaRepository<DebitCard, Long> {

	// from DebitCard d where d.holderName=?1
	List<DebitCard> findByHolderName(String holderName);

	// from DebitCard d where d.type=?1
	List<DebitCard> findByType(String type);

	
}