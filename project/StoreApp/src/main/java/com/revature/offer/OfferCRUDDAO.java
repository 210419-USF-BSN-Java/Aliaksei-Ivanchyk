package com.revature.offer;

import java.util.List;

import com.revature.exception.BusinessException;
import com.revature.model.Offer;

public interface OfferCRUDDAO { 
	
	public Offer checkIfOfferAlreadyMade(int customer_id, int rock_id) throws BusinessException;
	public int cancelOffer(int customer_id, int rock_id) throws BusinessException;
	public int rejectOffer(int offer_id) throws BusinessException;
	public List<Offer> getAllActiveOffers() throws BusinessException;
	public int makeAnOffer(double amount, int customer_id, int rock_id) throws BusinessException;
	public int acceptOffer(double newBalance, Offer offer) throws BusinessException; 
	

}
