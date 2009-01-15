package org.light.portal.portlet.contentlibrary;

import java.io.InputStream;
import java.util.List;

import javax.naming.directory.SearchResult;

import org.light.portal.portlet.contentlibrary.entity.CLFile;
import org.light.portal.portlet.contentlibrary.entity.CLFolder;
import org.light.portal.portlet.contentlibrary.exception.DuplicateFileException;
import org.light.portal.portlet.contentlibrary.exception.DuplicateFolderException;
import org.light.portal.portlet.contentlibrary.exception.NoSuchFileException;
import org.light.portal.portlet.contentlibrary.exception.NoSuchFolderException;

public interface ContentLibrary {
	
	public boolean addFolder(long orgId, long userId, CLFolder folder) throws DuplicateFolderException;
	
	public boolean updateFolder(long orgId, long userId, CLFolder folder);
	
	public boolean copyFolder(long orgId, long userId, CLFolder sourceFolder, CLFolder destFolder);
	
	public boolean moveFolder(long orgId, long userId, CLFolder sourceFolder, CLFolder destFolder);
	
	public boolean deleteFolder(long orgId, long userId, CLFolder folder, boolean isSoftDelete) throws NoSuchFolderException;
	
	public List<CLFolder> getSubFoldersByParentId(long orgId, long userId, long parentFolderId, int start, int end);
	
	public boolean indexFolder(long orgId, long userId, CLFolder folder);
	
	public List<CLFile> getFilesByFolderId(long orgId, long userId, long folderId, int start, int end);
	
	public boolean addFile(long orgId, long userId, CLFile file)  throws DuplicateFileException;
	
	public boolean updateFile(long orgId, long userId, CLFile file);
	
	public boolean copyFile(long orgId, long userId, CLFile sourceFile, CLFile destFile);
	
	public boolean moveFile(long orgId, long userId, CLFile sourceFile, CLFile destFile);
	
	public boolean deleteFile(long orgId, long userId, CLFile file, boolean isSoftDelete) throws NoSuchFileException;
	
	public CLFile getFile(long orgId, long userId, CLFile file) throws NoSuchFileException;
	
	public boolean exists(String name, int contentType);
	
	public boolean indexFile(long orgId, long userId, CLFile file);
	
	public List<SearchResult> search(long orgId, long userId, String query, int start, int end);
	
	public String parseText(InputStream file, String fileExt);
	
	public int getCounts(long folderId);
	
}
