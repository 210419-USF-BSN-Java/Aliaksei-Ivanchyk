package com.revature.offer;

import java.util.List;

import com.revature.model.Offer;

public interface OfferCRUDDAO { 
	
	public int makeAnOffer(Offer offer); 
	public int checkIfOfferAlreadyMade(int customer_id, int rock_id);
	public int cancelOffer(int customer_id, int rock_id);
	public List<Offer> getAllOffers();
	public int acceptOffer(int offer_id, int customer_id, int rock_id);
	public int rejectOffer(int offer_id); 
	

}
