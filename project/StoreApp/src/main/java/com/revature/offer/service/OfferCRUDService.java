package com.revature.offer.service;

import com.revature.exception.BusinessException;
import com.revature.model.Offer;

public interface OfferCRUDService {

	public int makeAnOffer(double amount, int customer_id, int rock_id) throws BusinessException;
	public int acceptOffer(double amount,Offer offer) throws BusinessException;

}
