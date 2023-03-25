package tstore.entity;

import java.time.LocalDate;
import java.lang.*;


public class Trade implements Comparable<Trade> {
	
	private String tId;
	private Integer version;
	private LocalDate maturityDate;
	private LocalDate createdDate;
	private String CounterPartyId;
	private String expired;	
	private String bookId;

	
	public Trade(String tId, Integer version, String counterPartyId, String bookId, LocalDate maturityDate,
			LocalDate createdDate, String expired) {
		super();
		this.tId = tId;
		this.version = version;
		CounterPartyId = counterPartyId;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expired = expired;
	}
	public String getTradeId() {
		return tId;
	}
	public void setTradeId(String tId) {
		this.tId = tId;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public LocalDate getMaturityDate() {
		return maturityDate;
	}
	public void setMaturityDate(LocalDate maturityDate) {
		this.maturityDate = maturityDate;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public String getExpired() {
		return expired;
	}
	public void setExpired(String expired) {
		this.expired = expired;
	}
	public String getCounterPartyId() {
		return CounterPartyId;
	}
	public void setCounterPartyId(String counterPartyId) {
		CounterPartyId = counterPartyId;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CounterPartyId == null) ? 0 : CounterPartyId.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((expired == null) ? 0 : expired.hashCode());
		result = prime * result + ((maturityDate == null) ? 0 : maturityDate.hashCode());
		result = prime * result + ((tId == null) ? 0 : tId.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		if (CounterPartyId == null) {
			if (other.CounterPartyId != null)
				return false;
		} else if (!CounterPartyId.equals(other.CounterPartyId))
			return false;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (expired == null) {
			if (other.expired != null)
				return false;
		} else if (!expired.equals(other.expired))
			return false;
		if (maturityDate == null) {
			if (other.maturityDate != null)
				return false;
		} else if (!maturityDate.equals(other.maturityDate))
			return false;
		if (tId == null) {
			if (other.tId != null)
				return false;
		} else if (!tId.equals(other.tId))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Trade [tId=" + tId + ", version=" + version + ", CounterPartyId=" + CounterPartyId + ", bookId="
				+ bookId + ", maturityDate=" + maturityDate + ", createdDate=" + createdDate + ", expired=" + expired
				+ "]";
	}
	@Override
	public int compareTo(Trade o) {
		return o.getVersion().compareTo(this.getVersion());
	}
}
