package com.higradius;

import java.util.Date;

public class Response {
	private String CustomerNumber; 
	private String CustomerName; 
	private Date DueDate; 
	private float InvoiceAmount; 
	private int InvoiceNumber; 
	private Date Predicted_Payment_Date; 
	private String Predicted_Aging_Bucket; 
	private String Notes;
	
	public Response() {}
	
	public String getCustomerNumber() {
		return CustomerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		CustomerNumber = customerNumber;
	}

	public Date getDueDate() {
		return DueDate;
	}

	public void setDueDate(Date dueDate) {
		DueDate = dueDate;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public float getInvoiceAmount() {
		return InvoiceAmount;
	}

	public void setInvoiceAmount(float invoiceAmount) {
		InvoiceAmount = invoiceAmount;
	}

	public int getInvoiceNumber() {
		return InvoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		InvoiceNumber = invoiceNumber;
	}

	public Date getPredicted_Payment_Date() {
		return Predicted_Payment_Date;
	}

	public void setPredicted_Payment_Date(Date predicted_Payment_Date) {
		Predicted_Payment_Date = predicted_Payment_Date;
	}

	public String getPredicted_Aging_Bucket() {
		return Predicted_Aging_Bucket;
	}

	public void setPredicted_Aging_Bucket(String predicted_Aging_Bucket) {
		Predicted_Aging_Bucket = predicted_Aging_Bucket;
	}

	public String getNotes() {
		return Notes;
	}

	public void setNotes(String notes) {
		Notes = notes;
	}
}
