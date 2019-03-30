package com.altimetrik.consumer;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class Transaction {

	public Double amount;
	public String time;
	public Transaction() {
		time =  OffsetDateTime.now(ZoneOffset.UTC).toString();
	}
	
	public Transaction(Double amount) {
		this.amount = amount;
		time =  OffsetDateTime.now(ZoneOffset.UTC).toString();
		
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Transaction [amount=" + amount + ", time=" + time + "]";
	}
	
	
}
