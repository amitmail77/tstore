package tstore.util.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import tstore.entity.Trade;
import tstore.util.TStoreUtil;
import tstore.util.TValidatorUtil;

public class TValidatorUtilTest {

	@Test
	public void testUpdateTradeExpireFlag() {
		Map<String, List<Trade>> intitalTStore = TStoreUtil.createTStore();
		TValidatorUtil.updateTradeExpireFlag(intitalTStore);
		Collection<List<Trade>> values = intitalTStore.values();
		
		List<Trade> tradeList = new ArrayList<Trade>();
		for (List<Trade> list : values) {
			tradeList.addAll(list);
		}
		
		int updatedExpireFlagCount = 0;
		
		for (Trade trade : tradeList) {
			if(trade.getExpired().equals("Y")) {
				updatedExpireFlagCount++;
			}
		}
		
		assertEquals(4, updatedExpireFlagCount);
	}
}
