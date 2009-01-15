package org.light.portal.portlet.contentlibrary.entity;

public final class CLMimeType {
	public static String MIME_TXT = "text/plain";
	public static String MIME_PDF = "application/pdf";
	public static String MIME_MS_DOC = "application/msword";
	public static String MIME_MS_EXCEL = "application/vnd.ms-excel";
	public static String MIME_JPEG = "image/jpeg";
	public static String MIME_JPG = "image/jpeg";
	public static String MIME_BMP = "image/bmp";
	public static String MIME_AVI = "video/x-msvideo";
	public static String MIME_MPEG = "audio/mpeg";
	public static String MIME_MP3 = "audio/mp3";
	public static String MIME_MP4 = "video/mp4";
	public static String MIME_WAV = "audio/x-wav";
	
	public static String EXT_TXT = "txt";
	public static String EXT_PDF = "pdf";
	public static String EXT_MS_DOC = "doc";
	public static String EXT_MS_EXCEL = "xsl";
	public static String EXT_JPEG = "jpeg";
	public static String EXT_JPG = "jpg";
	public static String EXT_BMP = "bmp";
	public static String EXT_AVI = "avi";
	public static String EXT_MPEG = "mpeg";
	public static String EXT_MP3 = "mp3";
	public static String EXT_MP4 = "mp4";
	public static String EXT_WAV = "wav";
	
	public static String getMimeTypeByExt(String ext) {
		String res = MIME_TXT;
		if (ext.equals(EXT_TXT)) {
			return MIME_TXT;
		}
		else if (ext.equals(EXT_PDF)) {
			return MIME_PDF;
		}
		else if (ext.equals(EXT_MS_DOC)) {
			return MIME_MS_DOC;
		}
		else if (ext.equals(EXT_MS_EXCEL)) {
			return MIME_MS_EXCEL;
		}
		else if (ext.equals(EXT_JPEG)) {
			return MIME_JPEG;
		}
		else if (ext.equals(EXT_JPG)) {
			return MIME_JPG;
		}
		else if (ext.equals(EXT_BMP)) {
			return MIME_BMP;
		}
		else if (ext.equals(EXT_AVI)) {
			return MIME_AVI;
		}
		else if (ext.equals(EXT_MPEG)) {
			return MIME_MPEG;
		}
		else if (ext.equals(EXT_MP3)) {
			return MIME_MP3;
		}
		else if (ext.equals(EXT_MP4)) {
			return MIME_MP4;
		}
		else if (ext.equals(EXT_WAV)) {
			return MIME_WAV;
		}
		return res;
	}
}
