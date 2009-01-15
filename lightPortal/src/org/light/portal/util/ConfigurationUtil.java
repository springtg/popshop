package org.light.portal.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ConfigurationUtil {
	
	public static List<LabelBean> getSupportedThemes() {
		List<LabelBean>  themeCopy = new LinkedList<LabelBean>();
		for(LabelBean bean : themes){
			themeCopy.add(new LabelBean(bean.getId(),bean.getDesc()));
		}
		return themeCopy;
	}
	
	public static List<LabelBean> getSupportedWindowSkins() {
		List<LabelBean>  windowSkinCopy = new LinkedList<LabelBean>();
		for(LabelBean bean : windowSkins){
			windowSkinCopy.add(new LabelBean(bean.getId(),bean.getDesc()));
		}
		return windowSkinCopy;
	}
	
	public static List<LabelBean> getSupportedBgImages() {
		return bgImages;
	}
	
	public static List<LabelBean> getSupportedHeaderImages() {
		return headerImages;
	}
	
	public static List<String> getSupportedFonts() {
		return fonts;
	}
	public static List<LabelBean> getSupportedFontSizes() {
		return fontSizes;
	}
	public static List<LabelBean> getSupportedHeaderHeights() {
		return headerHeights;
	}
	
	public static List<Integer> getMaxShowTabsNumber(){
		List<Integer> list = new LinkedList<Integer>();
		int begin = 1;
		try{
			begin = Integer.parseInt(PropUtil.getString(_MAX_SHOW_TABS_MIN));
		}catch(Exception e){}
		
		int end = 30;
		try{
			end = Integer.parseInt(PropUtil.getString(_MAX_SHOW_TABS_MAX));
		}catch(Exception e){}
		for(int i=begin;i<=end;i++){
			list.add(i);
		}
		return list;
	}
	private static  List<LabelBean>  themes;
	private static  List<LabelBean>  bgImages;
	private static  List<LabelBean>  headerImages;
	private static  List<LabelBean>  windowSkins;
	private static List<String> fonts;
	private static  List<LabelBean>  fontSizes;
	private static  List<LabelBean>  headerHeights;
		
	private final static String _THEME="portal.theme.list";	
	private final static String _BG_IMAGES="portal.bg.image.list";	
	private final static String _HEADER_IMAGES="portal.header.image.list";	
	private final static String _WINDOW_SKIN="portlet.window.skin";	
	private final static String _FONTS="dropdown.fonts";
	private final static String _FONTSIZE_LABEL="dropdown.fontSize.label";
	private final static String _FONTSIZE_VALUE="dropdown.fontSize.value";
	private final static String _HEADER_HEIGHT_LABEL="dropdown.headerHeight.label";
	private final static String _HEADER_HEIGHT_VALUE="dropdown.headerHeight.value";
	private final static String _MAX_SHOW_TABS_MIN = "default.user.maxShowTabs.min";
	private final static String _MAX_SHOW_TABS_MAX = "default.user.maxShowTabs.max";
	static{
		themes = new LinkedList<LabelBean>();
		String[] themeArray = PropUtil.getString(_THEME).split(",");
		for(int i=0;i<themeArray.length;i++){
			themes.add(new LabelBean(themeArray[i],themeArray[i]));
		}
		
		bgImages = new LinkedList<LabelBean>();
		String[] bgImagesArray = PropUtil.getString(_BG_IMAGES).split(",");
		for(int i=0;i<bgImagesArray.length;i++){
			bgImages.add(new LabelBean(bgImagesArray[i],bgImagesArray[i]));
		}
		
		headerImages = new LinkedList<LabelBean>();
		String[] headerImagesArray = PropUtil.getString(_HEADER_IMAGES).split(",");
		for(int i=0;i<headerImagesArray.length;i++){
			headerImages.add(new LabelBean(headerImagesArray[i],headerImagesArray[i]));
		}
		
		windowSkins = new LinkedList<LabelBean>();
		String[] windowSkinArray = PropUtil.getString(_WINDOW_SKIN).split(",");
		for(int i=0;i<windowSkinArray.length;i++){
			windowSkins.add(new LabelBean(windowSkinArray[i],windowSkinArray[i]));
		}
		
		String supportedFonts = PropUtil.getString(_FONTS);
		String[] listFonts = supportedFonts.split(",");
		fonts = Arrays.asList(listFonts);
		
		String fontSizeLabel = PropUtil.getString(_FONTSIZE_LABEL);
		String fontSizeValue = PropUtil.getString(_FONTSIZE_VALUE);
		String[] fontSizeLabels = fontSizeLabel.split(",");
		String[] fontSizeValues = fontSizeValue.split(",");
		fontSizes = new LinkedList<LabelBean>();
		for(int i=0;i<fontSizeLabels.length;i++){
			fontSizes.add(new LabelBean(fontSizeValues[i],fontSizeLabels[i]));
		}
		
		String headerHeightLabel = PropUtil.getString(_HEADER_HEIGHT_LABEL);
		String headerHeightValue = PropUtil.getString(_HEADER_HEIGHT_VALUE);
		String[] headerHeightLabels = headerHeightLabel.split(",");
		String[] headerHeightValues = headerHeightValue.split(",");
		headerHeights = new LinkedList<LabelBean>();
		for(int i=0;i<headerHeightLabels.length;i++){
			headerHeights.add(new LabelBean(headerHeightValues[i],headerHeightLabels[i]));
		}
		
	}
	
	
}
