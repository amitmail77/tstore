package tstore.dao;

import java.util.List;
import java.util.Map;

import tstore.entity.Trade;

public interface TStoreDao {
	public abstract Map<String,List<Trade>> createTStore();
	public abstract Map<String, List<Trade>> updateTStore(String tId, List<Trade> tList);
}
