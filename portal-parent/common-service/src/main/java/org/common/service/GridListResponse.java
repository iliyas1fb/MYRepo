package org.common.service;

import java.io.Serializable;
import java.util.List;

public class GridListResponse implements Serializable {

	/** The Constant serialVersionUID. */
private static final long serialVersionUID = -4023902307598242582L;

/** The page. */
private String page;

private String errormsg;

/** The total. */
private String total;

/** The records. */
private String records;

/** The rows. */
private List<?> rows;
private String cancelCheck;
private String settleCheck;


/**
 * @return the serialversionuid
 */
public static long getSerialversionuid() {
	return serialVersionUID;
}
/**
 * @return the settleCheck
 */
public String getSettleCheck() {
	return settleCheck;
}

/**
 * @param settleCheck the settleCheck to set
 */
public void setSettleCheck(String settleCheck) {
	this.settleCheck = settleCheck;
}

public String getCancelCheck() {
	return cancelCheck;
}

public void setCancelCheck(String cancelCheck) {
	this.cancelCheck = cancelCheck;
}

/**
 * @return the errormsg
 */
public String getErrormsg() {
	return errormsg;
}

/**
 * @param errormsg
 *            the errormsg to set
 */
public void setErrormsg(String errormsg) {
	this.errormsg = errormsg;
}

/**
 * @return the page
 */
public String getPage() {
	return page;
}

/**
 * @param page
 *            the page to set
 */
public void setPage(String page) {
	this.page = "1";
}

/**
 * @return the total
 */
public String getTotal() {
	return total;
}

/**
 * @param total
 *            the total to set
 */
public void setTotal(String total) {
	this.total = "10";
}

/**
 * @return the records
 */
public String getRecords() {
	return records;
}

/**
 * @param records
 *            the records to set
 */
public void setRecords(String records) {
	this.records = records;
}

/**
 * @return the rows
 */
public List<?> getRows() {
	return rows;
}

/**
 * @param rows
 *            the rows to set
 */
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
