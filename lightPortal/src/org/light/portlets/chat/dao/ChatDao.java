package org.light.portlets.chat.dao;

import java.util.List;

import org.light.portal.core.dao.BaseDao;
import org.light.portlets.chat.Chat;
import org.light.portlets.chat.Chatting;
import org.light.portlets.chat.ChattingRecord;
import org.light.portlets.connection.Connection;

public interface ChatDao extends BaseDao {
	public Chat getChatByUser(long userId);
	public int getBuddyCount(long userId);
	public List<Connection> getBuddysByUser(long userId);	
	public List<ChattingRecord> getChattingRecordsById(long chattingId);
	public Chatting getChattingByUser(long userId);
	public Chatting getChattingById(long chattingId);
	public void deleteChattingByUser(long userId);
	public Connection getChatBuddy(long userId, long buddyUserId);
	public void deleteUser(long userId);
	public List<Connection> getOnlineBuddysByUser(long userId);
	public List<Connection> getUpdatedBuddysByUser(long userId);
	public List<Connection> getBuddysByUserAndType(long userId, int type);
	public List<Connection> getBuddysByUser(long userId, String city, String province);
}
