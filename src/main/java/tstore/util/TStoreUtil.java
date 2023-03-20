package tstore.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tstore.entity.Trade;

public class TStoreUtil {

	private static Map<String,List<Trade>> TStoreMap = new HashMap<>();
	
	 static {
		 List<Trade> ts = new ArrayList<>();
		 
		 ts.add(new Trade("T1",1,"CP-1","B1",LocalDate.parse("20/05/2020",DateTimeFormatter.ofPattern("dd/MM/yyyy")),LocalDate.parse("29/06/2020",DateTimeFormatter.ofPattern("dd/MM/yyyy")),"N"));
		 TStoreMap.put("T1", ts);
		 
		 ts = new ArrayList<>();
		 ts.add(new Trade("T2",2,"CP-2","B1",LocalDate.parse("20/05/2021",DateTimeFormatter.ofPattern("dd/MM/yyyy")),LocalDate.parse("29/06/2020",DateTimeFormatter.ofPattern("dd/MM/yyyy")),"N"));
		 ts.add(new Trade("T2",1,"CP-1","B1",LocalDate.parse("20/05/2021",DateTimeFormatter.ofPattern("dd/MM/yyyy")),LocalDate.parse("14/03/2015",DateTimeFormatter.ofPattern("dd/MM/yyyy")),"N"));
		 
		 TStoreMap.put("T2", ts);
		 
		 ts = new ArrayList<>();
		 ts.add(new Trade("T3",3,"CP-3","B2",LocalDate.parse("20/05/2014",DateTimeFormatter.ofPattern("dd/MM/yyyy")),LocalDate.parse("29/06/2020",DateTimeFormatter.ofPattern("dd/MM/yyyy")),"Y"));
		 
		 TStoreMap.put("T3", ts); 
	 }
	 
	 /**
	  * @return trade store 
	  */
	 public static Map<String,List<Trade>> createTStore(){
		 
		return TStoreMap;
	 }
	 
	 public static Map<String,List<Trade>> updateTStore(String tId,List<Trade> newTrades){
		TStoreMap.put(tId, newTrades);
		return TStoreMap;
		 
	 }
}
