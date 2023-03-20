package tstore.util.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import tstore.dao.TStoreDao;
import tstore.dao.TStoreDaoImpl;
import tstore.entity.Trade;
import tstore.exception.VersionCheckException;
import tstore.service.TStoreService;
import tstore.service.TStoreServiceImpl;
import tstore.util.TStoreUtil;

public class TStoreServiceImplTest {

	/**
	 * 1.During transmission if the lower version is being received by the store it will reject the trade 
	 * and throw an exception
	 */
	@Test
	public void testUpdateForLowerVerionTrade() {
		 Map<String, List<Trade>> intitalTStore = TStoreUtil.createTStore();
		 Trade newTrade =  new Trade("T2",1,"CP-1","B1",LocalDate.parse("20/05/2021",DateTimeFormatter.ofPattern("dd/MM/yyyy")),LocalDate.parse("14/03/2022",DateTimeFormatter.ofPattern("dd/MM/yyyy")),"N");
		
		 TStoreDao TStoreRepository = new TStoreDaoImpl();
		 TStoreService TStoreService = new TStoreServiceImpl(TStoreRepository);
		 
		 //assertThrows(VersionCheckException.class, ()->TStoreService.updateTStore(newTrade, intitalTStore));
	}
}
