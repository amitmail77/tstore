package tstore.service;

import java.util.List;
import java.util.Map;

import tstore.entity.Trade;
import tstore.exception.VersionCheckException;

public interface TStoreService {
	
	public abstract Map<String,List<Trade>> createTStore();
	public abstract Map<String, List<Trade>> updateTStore(Trade newTrade, Map<String, List<Trade>> intitalTStore) throws VersionCheckException;
}
