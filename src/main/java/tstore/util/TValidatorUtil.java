package tstore.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import tstore.entity.Trade;
import tstore.exception.VersionCheckException;

public class TValidatorUtil {

	/**
	 * Incase of lower version trade will get rejected and exception is thrown. If the version is same it will override the existing record.
	 * @param newTrade has to validate
	 * @param tList updated List
	 * @return 
	 * @throws LowerVersionTradeException throws Exception if Lower Version trade received by store
	 */
	public static List<Trade> rejectForLowerVerUpdateForSameVer(Trade newTrade,
			List<Trade> tList) throws VersionCheckException {
		Collections.sort(tList);

		if(tList.get(0).getVersion().equals(newTrade.getVersion())) {
			//tList = new ArrayList<>();
			tList.set(0, newTrade);
		}
		if(tList.get(0).getVersion().compareTo(newTrade.getVersion())>0) {
			System.out.println("As The lower version is being received by the store it will reject the trade and throw an exception.\n"
					+ "			If the version is same it will override/update the existing record.");

			throw new VersionCheckException("Trade_Id:"+tList.get(0).getTradeId()+" Received trade version:"+newTrade.getVersion()+" Which is lower than store trade verion:"+tList.get(0).getVersion());
		}else {
			System.out.println("This trade is successfully added in store.");
			tList.add(newTrade);
		}
		return tList;
	}

	/**
	 * Store should automatically update the expire flag if in a store the trade crosses the maturity date.
	 * @param intitalTStore trade store data
	 */
	public static void updateTradeExpireFlag(Map<String, List<Trade>> intitalTStore) {
		System.out.println("\n");
		Set<Entry<String, List<Trade>>> entrySet = intitalTStore.entrySet();
		for (Entry<String, List<Trade>> tEntry : entrySet) {
			List<Trade> ts = tEntry.getValue();
			
			ListIterator<Trade> listIterator = ts.listIterator();
			while (listIterator.hasNext()) {
				Trade t = listIterator.next();
				if(t.getMaturityDate().isBefore(LocalDate.now())) {
					System.out.println("Expire flag is updated for below in store:: ");
					t.setExpired("Y");
					System.out.println(t);
				}
			}
		}
	}
}
