package tstore.dao;

import java.util.List;
import java.util.Map;

import tstore.entity.Trade;
import tstore.util.TStoreUtil;

public class TStoreDaoImpl implements TStoreDao {

	@Override
	public Map<String, List<Trade>> createTStore() {
		return TStoreUtil.createTStore();
	}

	@Override
	public Map<String, List<Trade>> updateTStore(String tId, List<Trade> tList) {
		return TStoreUtil.updateTStore(tId, tList);
	}
	
}
