package com.klef.soa.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "debitcard_table")
public class DebitCard
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "debitcardid")
	private Long debitCardId;

	@Column(name = "holdername", length = 100, nullable = false)
	private String holderName;

	@Column(name = "type", length = 50, nullable = false)
	private String type;

	@Column(name = "status", length = 50, nullable = false)
	private String status;

	@Column(name = "location", length = 100, nullable = false)
	private String location;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Long getDebitCardId() {
		return debitCardId;
	}

	public void setDebitCardId(Long debitCardId) {
		this.debitCardId = debitCardId;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "DebitCard [debitCardId=" + debitCardId + ", holderName=" + holderName + ", type=" + type
				+ ", status=" + status + ", location=" + location + "]";
	}
}