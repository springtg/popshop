package org.light.portlets.chat.service.spring;

import java.util.List;

import org.light.portal.core.service.spring.BaseServiceImpl;
import org.light.portlets.chat.Chat;
import org.light.portlets.chat.Chatting;
import org.light.portlets.chat.ChattingRecord;
import org.light.portlets.chat.dao.ChatDao;
import org.light.portlets.chat.service.ChatService;
import org.light.portlets.connection.Connection;

public class ChatServiceImpl extends BaseServiceImpl implements ChatService{
	private ChatDao chatDao;
	
	public Chat getChatByUser(long userId){
		return chatDao.getChatByUser(userId);
	}
	
	public List<Connection> getBuddysByUser(long userId){
		return chatDao.getBuddysByUser(userId);
	}
	
	public int getBuddyCount(long userId){
		return chatDao.getBuddyCount(userId);
	}
	public List<ChattingRecord> getChattingRecordsById(long chattingId){
		return chatDao.getChattingRecordsById(chattingId);
	}
	public List<Connection> getBuddysByUser(long userId, String city, String province){
		return chatDao.getBuddysByUser(userId,city,province);
	}
	public Chatting getChattingByUser(long userId){
		return chatDao.getChattingByUser(userId);
	}
	public List<Connection> getOnlineBuddysByUser(long userId){
		return chatDao.getOnlineBuddysByUser(userId);
	}
	public List<Connection> getBuddysByUserAndType(long userId, int type){
		return chatDao.getBuddysByUserAndType(userId,type);
	}
	public List<Connection> getUpdatedBuddysByUser(long userId){
		return chatDao.getUpdatedBuddysByUser(userId);
	}
	public Chatting getChattingById(long chattingId){
		return chatDao.getChattingById(chattingId);
	}
	
	public void deleteChattingByUser(long userId){
		chatDao.deleteChattingByUser(userId);
	}
	
	public Connection getChatBuddy(long userId, long buddyUserId){
		return chatDao.getChatBuddy(userId,buddyUserId);
	}
	
	public ChatDao getChatDao() {
		return chatDao;
	}
	

	public void setChatDao(ChatDao chatDao) {
		this.chatDao = chatDao;
	}
	
}
