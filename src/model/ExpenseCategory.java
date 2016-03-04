package model;

public class ExpenseCategory {
int expcatid, uid;
String reason, descrip;

public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public int getExpcatid() {
	return expcatid;
}
public void setExpcatid(int expcatid) {
	this.expcatid = expcatid;
}
public String getReason() {
	return reason;
}
public void setReason(String reason) {
	this.reason = reason;
}
public String getDescrip() {
	return descrip;
}
public void setDescrip(String descrip) {
	this.descrip = descrip;
}

}
