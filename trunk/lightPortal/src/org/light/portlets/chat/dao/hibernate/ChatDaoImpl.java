package org.light.portlets.chat.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.light.portal.core.dao.hibernate.BaseDaoImpl;
import org.light.portlets.chat.Chat;
import org.light.portlets.chat.Chatting;
import org.light.portlets.chat.ChattingRecord;
import org.light.portlets.chat.dao.ChatDao;
import org.light.portlets.connection.Connection;

public class ChatDaoImpl extends BaseDaoImpl implements ChatDao{
	public Chat getChatByUser(long userId){
		Chat chat = null;
		if(userId > 0){			
				chat = (Chat)this.getHibernateTemplate().get(Chat.class,userId);
		}
		return chat;
	}
	public int getBuddyCount(long userId){			
		String hql="select count(*) from Connection buddy where buddy.userId='"+userId+"'";
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		Query query =session.createQuery(hql);
		Integer count = (Integer)query.uniqueResult();
		session.close();
		return count.intValue();
	}
	
	public List<Connection> getBuddysByUser(long userId){			
		List<Connection> list = null;
		if(userId > 0)
			list = this.getHibernateTemplate().find("select buddy from Connection buddy where buddy.userId =? order by buddy.id desc", userId);		
		return list;
	}
	public List<Connection> getBuddysByUser(long userId, String city, String province){			
		List<Connection> list = null;
		if(userId > 0){
			Object[] params= new Object[3];
			params[0]=userId;
			params[1]=city;
			params[2]=province;
			list = this.getHibernateTemplate().find("select buddy from Connection buddy where buddy.userId =? and buddy.city=? and buddy.province=? order by buddy.id desc", params);		
		}
		return list;
	}
	public List<Connection> getOnlineBuddysByUser(long userId){			
		List<Connection> list = null;
		if(userId > 0)
			list = this.getHibernateTemplate().find("select buddy from Connection buddy where buddy.userId =? and buddy.buddyCurrentStatusId = 1", userId);		
		
		return list;
	}
	public List<Connection> getUpdatedBuddysByUser(long userId){			
		List<Connection> list = null;
		if(userId > 0)
			list = this.getHibernateTemplate().find("select buddy from Connection buddy where buddy.userId =? order by buddy.lastLoginDate desc", userId);		
		
		return list;
	}
	
	public List<Connection> getBuddysByUserAndType(long userId, int type){
		Object[] params = new Object[2];
		params[0]= userId;
		params[1]= type;
		List<Connection> list = null;
		if(userId > 0)
			list = this.getHibernateTemplate().find("select buddy from Connection buddy where buddy.userId =? and buddy.type =? order by buddy.id desc", params);		
		
		return list;
	}
	public void deleteUser(long userId){
		Chat chat =this.getChatByUser(userId);
		if(chat != null)
			this.delete(chat);
		List<Connection> list = getBuddysByUser(userId);
		if(list != null){
			for(Connection cb : list){
				this.delete(cb);
			}
		}
	}
	
	public List<ChattingRecord> getChattingRecordsById(long chattingId){
		List<ChattingRecord> list = this.getHibernateTemplate().find("select record from ChattingRecord record where record.chattingId =? order by record.id", chattingId);		
		return list;
	}
	public Chatting getChattingByUser(long userId){
		List<Chatting> list = this.getHibernateTemplate().find("select c from Chatting c where c.to =?  and c.status =0 order by c.id", userId);		
		Chatting chatting = null;
		if(list != null && list.size() > 0) {
			chatting = list.get(0);			
			chatting.setStatus(1);
			Chat chat = getChatByUser(chatting.getFrom());
			if(chat != null)
				chatting.setFromName(chat.getDisplayName());
			this.getHibernateTemplate().update(chatting);
		}
		return chatting;
	}
	
	public Chatting getChattingById(long chattingId){
		Chatting chatting= (Chatting)this.getHibernateTemplate().get(Chatting.class,chattingId);
		return chatting;
	}
	
	public void deleteChattingByUser(long userId){
		List<Chatting> list = this.getHibernateTemplate().find("select c from Chatting c where c.from =? ", userId);
		for(Chatting chatting : list){			
			this.getHibernateTemplate().delete(chatting);
		}
	}
	
	public Connection getChatBuddy(long userId, long buddyUserId){
		Connection buddy = null;
		Object[] params = new Object[2];
		params[0] = userId;
		params[1] = buddyUserId;
		List<Connection> list = this.getHibernateTemplate().find("select c from Connection c where c.userId=? and c.buddyUserId =?", params);		
		if(list != null && list.size() > 0) buddy = list.get(0);
		return buddy;
	}
}
