package com.rest.webapp.vo;

public class Variables {
	 CustId CustIdObject;
	 Msisdn MsisdnObject;
	 Protype ProtypeObject;


	 // Getter Methods 

	 public CustId getCustId() {
	  return CustIdObject;
	 }

	 public Msisdn getMsisdn() {
	  return MsisdnObject;
	 }

	 public Protype getProtype() {
	  return ProtypeObject;
	 }

	 // Setter Methods 

	 public void setCustId(CustId custIdObject) {
	  this.CustIdObject = custIdObject;
	 }

	 public void setMsisdn(Msisdn msisdnObject) {
	  this.MsisdnObject = msisdnObject;
	 }

	 public void setProtype(Protype protypeObject) {
	  this.ProtypeObject = protypeObject;
	 }
}
