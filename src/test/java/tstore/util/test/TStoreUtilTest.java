package tstore.util.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import tstore.entity.Trade;
import tstore.util.TStoreUtil;

public class TStoreUtilTest {
	
	@Test
	public void testCreateTStore() {
		
		Map<String, List<Trade>> createTStore = TStoreUtil.createTStore();
		assertTrue(createTStore.size() == 3 );
		createTStore = null;
	}
	
	@Test
	public void testUpdateTStore() {
		
		Map<String, List<Trade>> createTStore = TStoreUtil.createTStore();
		Trade newTrade = new Trade("T4",1,"CP-4","B1",LocalDate.parse("25/05/2021",DateTimeFormatter.ofPattern("dd/MM/yyyy")),LocalDate.parse("29/06/2020",DateTimeFormatter.ofPattern("dd/MM/yyyy")),"N");
		List<Trade> newTrades = new ArrayList<Trade>();
		newTrades.add(newTrade);
		
		TStoreUtil.updateTStore("T4", newTrades);
		assertTrue(createTStore.size() == 4 );
		createTStore = null;
	}
}
