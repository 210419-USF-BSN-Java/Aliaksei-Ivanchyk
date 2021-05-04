package com.revature.offer.service.impl;

import org.apache.log4j.Logger;

import com.revature.exception.BusinessException;
import com.revature.model.Offer;
import com.revature.offer.OfferCRUDDAO;
import com.revature.offer.impl.OfferCRUDDAOImpl;
import com.revature.offer.service.OfferCRUDService;

public class OfferCRUDServiceImpl implements OfferCRUDService  {
	private  Logger Log = Logger.getLogger(OfferCRUDServiceImpl.class);
	OfferCRUDDAO ocd = new OfferCRUDDAOImpl();

	@Override
	public int makeAnOffer(double amount, int customer_id, int rock_id) throws BusinessException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int acceptOffer(double amount, Offer offer) throws BusinessException {
		int c = 0;
		if (amount < 0 ) {
			Log.info("Balance cannot be zero");
		} else {
			c = ocd.acceptOffer(amount, offer);		
		}
		return c;
	}
	
//	public int makeAnOffer(double amount, int customer_id, int rock_id) throws BusinessException {
//		if (amount < 0) {
//			Log.warn("Entered amount cannot be zero");
//			throw new BusinessException();
//		}
//		
//		int c = ccd.makeAnOffer(amount, customer_id, rock_id);
//		if (c == 0) {
//			Log.warn("Something went wrong on adding the offer");
//			throw new BusinessException();
//		}
//		return c;
//	}

}
