package model;

public class Transaction {
int tid,incOrExpId, amount;
String type, srcOrresn,desc, date;
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}

public int getIncOrExpId() {
	return incOrExpId;
}
public void setIncOrExpId(int incOrExpId) {
	this.incOrExpId = incOrExpId;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public String getSrcOrresn() {
	return srcOrresn;
}
public void setSrcOrresn(String srcOrresn) {
	this.srcOrresn = srcOrresn;
}
public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
}

}
