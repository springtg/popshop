package org.light.portlets.email;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;

import org.light.portal.util.DateFormatter;

public class MailBean implements Serializable{
	private String from;
	private String fromAddress;
	private String sender;
	private String subject;
	private String content;
	private Date sentDate;
	private int flag;  //0 seen,1 new
	private int total;
	private int unreadCount;
	private Message msg;
	
	public MailBean(String from,String fromAddress,String sender,String subject,String content, Date sentDate,int flag,int total,int unreadCount,Message msg){
		this.from = from;
		this.fromAddress = fromAddress;
		this.sender = sender;
		this.subject = subject;
		this.content = content;
		this.sentDate = sentDate;
		this.flag = flag;
		this.total = total;
		this.unreadCount = unreadCount;
		this.msg= msg;
	}
	public String getFromName(){
		String name = this.from;
		if(name == null || name.length()<=0)
			name = this.fromAddress;
		return name;
	}
	public String getFromInfo(){
		String info = this.fromAddress;
		if(this.from != null && this.from.length()>0){
			String name = this.from;
			if(this.from.indexOf(",") > 0)
				name ="\""+this.from+"\"";
			if(this.fromAddress != null)
				info = name+"<"+this.fromAddress+">";
			else
				info = name;
		}
		return info;
	}
	public String getDate(){
		String date= null;
		if(this.sentDate != null){
			Calendar today = Calendar.getInstance();
			today.setTimeInMillis(System.currentTimeMillis());
		    today.set(Calendar.HOUR,0);
		    today.set(Calendar.MINUTE,0);
		    today.set(Calendar.SECOND,1);
		    
			Calendar sentTime = Calendar.getInstance();
			sentTime.setTimeInMillis(this.sentDate.getTime());			
			if(sentTime.after(today)){
				date= DateFormatter.format(this.sentDate,"HH:mm aaa");
			}else{
				today.add(Calendar.DATE, -7);
				if(sentTime.after(today)){
					date= DateFormatter.format(this.sentDate,"EEE HH:mm aaa");
				}else{
					date= DateFormatter.format(this.sentDate,"MM/dd/yy");
				}
			}		
		}
		return date;
	}
	public String getFullDate(){
		String date= null;
		if(this.sentDate != null)
			date= DateFormatter.format(this.sentDate,"EEEE, MMMM dd, yyyy HH:mm aaa");
		return date;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Message getMsg() {
		return msg;
	}

	public void setMsg(Message msg) {
		this.msg = msg;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getUnreadCount() {
		return unreadCount;
	}
	public void setUnreadCount(int unreadCount) {
		this.unreadCount = unreadCount;
	}
	
}
