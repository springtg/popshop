package org.light.portal.portlet.contentlibrary.dao.hibernate;

import java.util.List;

import org.light.portal.core.dao.hibernate.BaseDaoImpl;
import org.light.portal.portlet.contentlibrary.ContentLibrary;
import org.light.portal.portlet.contentlibrary.dao.ContentLibraryDao;
import org.light.portal.portlet.contentlibrary.entity.CLFile;
import org.light.portal.portlet.contentlibrary.entity.CLFolder;
import org.light.portal.portlet.contentlibrary.exception.DuplicateFileException;
import org.light.portal.portlet.contentlibrary.exception.DuplicateFolderException;
import org.light.portal.portlet.contentlibrary.exception.NoSuchFileException;
import org.light.portal.portlet.contentlibrary.exception.NoSuchFolderException;

public class ContentLibraryDaoImpl extends BaseDaoImpl implements ContentLibraryDao {
	
	private ContentLibrary contentLibrary = null;

	
	public boolean addFile(long orgId, long userId, CLFile file)
			throws DuplicateFileException {
		
		// check file already exists or not
		
		try {
			this.save(file);
			contentLibrary.addFile(orgId, userId, file);
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	
	public boolean addFolder(long orgId, long userId, CLFolder folder)
			throws DuplicateFolderException {
		
		try {
			// save to DB
			this.save(folder);
			
			// save to specific repository
			contentLibrary.addFolder(orgId, userId, folder);
		}
		catch(Exception e) {
			return false;
		}
		
		return true;
	}

	
	public boolean copyFile(long orgId, long userId, CLFile sourceFile,
			CLFile destFile) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean copyFolder(long orgId, long userId, CLFolder sourceFolder,
			CLFolder destFolder) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean deleteFile(long orgId, long userId, CLFile file,
			boolean isSoftDelete) throws NoSuchFileException {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean deleteFolder(long orgId, long userId, CLFolder folder,
			boolean isSoftDelete) throws NoSuchFolderException {
		// TODO Auto-generated method stub
		return false;
	}

	
	public int getCounts(long folderId) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public CLFile getFile(long orgId, long userId, CLFile file)
			throws NoSuchFileException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<CLFile> getFilesByFolderId(long orgId, long userId,
			long folderId, int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<CLFolder> getSubFoldersByParentId(long orgId, long userId,
			long parentFolderId, int start, int end) {
		String[] params = new String[3];
		params[0] = Long.toString(orgId);
		params[1] = Long.toString(userId);
		params[2] = Long.toString(parentFolderId);
		List<CLFolder> folders = this.getHibernateTemplate().find("select clFolder from CLFolder clFolder where clFolder.orgId = ? and clFolder.userId =? order by clFolder.parentId, clFolder.name", params);
		return folders;
	}

	
	public boolean moveFile(long orgId, long userId, CLFile sourceFile,
			CLFile destFile) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean moveFolder(long orgId, long userId, CLFolder sourceFolder,
			CLFolder destFolder) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean updateFile(long orgId, long userId, CLFile file) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean updateFolder(long orgId, long userId, CLFolder folder) {
		// TODO Auto-generated method stub
		return false;
	}

	public ContentLibrary getContentLibrary() {
		return this.contentLibrary;
	}
	
	public void setContentLibrary(ContentLibrary contentLibrary) {
		this.contentLibrary = contentLibrary;
	}

}
