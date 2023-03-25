package tstore.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tstore.dao.TStoreDao;
import tstore.entity.Trade;
import tstore.exception.VersionCheckException;
import tstore.util.TValidatorUtil;

public class TStoreServiceImpl implements TStoreService {
	
	private TStoreDao TStoreDao;
	
	public TStoreServiceImpl(TStoreDao TStoreDao) {
		this.TStoreDao = TStoreDao;
	}

	@Override
	public Map<String, List<Trade>> createTStore() {
		return TStoreDao.createTStore();
	}

	@Override
	public Map<String, List<Trade>> updateTStore(Trade newTrade, Map<String, List<Trade>> intitalTStore) throws VersionCheckException {
		//Validation of Trades before updating into trade store
		
	    //Validation-2.Store should not allow the trade which has less maturity date then today date.
		if(newTrade.getMaturityDate().isBefore(LocalDate.now())) {
			System.out.println("As trade maturity date is less than today's date so trade is not going to add in store.");
			return intitalTStore;
		}
		
		List<Trade> tList = intitalTStore.get(newTrade.getTradeId());
		//if trade is new then update in store.
		if(tList == null) {
			tList = new ArrayList<Trade>();
			tList.add(newTrade);
		}else {
			/*Validation-1.The lower version is being received by the store it will reject the trade and throw an exception.
			If the version is same it will override/update the existing record*/
			tList = TValidatorUtil.rejectForLowerVerUpdateForSameVer(newTrade, tList);
			
		}
	
		//Validation-3.Store should automatically update the expire flag if in a store the trade crosses the maturity date.
		TValidatorUtil.updateTradeExpireFlag(intitalTStore);
		return TStoreDao.updateTStore(newTrade.getTradeId(),tList);
	}
}
