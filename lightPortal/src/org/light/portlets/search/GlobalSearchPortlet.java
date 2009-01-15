package org.light.portlets.search;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.LinkedList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.light.portal.model.UserEntity;
import org.light.portal.portlet.core.impl.LightGenericPortlet;
import org.light.portal.search.Searcher;
import org.light.portal.search.model.SearchCriteria;
import org.light.portal.search.model.SearchResult;
import org.light.portal.search.model.SearchResultItem;
import org.light.portal.util.LabelBean;
import org.light.portal.util.PropUtil;

public class GlobalSearchPortlet extends LightGenericPortlet {
	 	     
	public void processAction (ActionRequest request, ActionResponse response) 
		throws PortletException, java.io.IOException 
	{		
		String action = request.getParameter("action");
		if("find".equals(action)){
		   String input = request.getParameter("input");
		   String keyword = request.getParameter("keyword");
		   String type = request.getParameter("type");
		   if("0".equals(input)) keyword=null;
		   if(keyword != null) keyword = URLDecoder.decode(keyword,_CHARSET_UTF);	
		   SearchCriteria criteria = new SearchCriteria();
		   criteria.setKeyword(keyword);
		   try{
			   SearchResult result= null;
			   if(type == null){
				   if(request.getPortletSession().getAttribute("searchTypes",PortletSession.APPLICATION_SCOPE) != null){
					   List<LabelBean> beans = (List<LabelBean>)request.getPortletSession().getAttribute("searchTypes",PortletSession.APPLICATION_SCOPE);				   
					   for(LabelBean bean : beans){
						   if(bean.isDefaulted()){
							   type = bean.getId();
							   break;
						   }
					   }
				   }
				   if(type != null)
					   result = this.getSearcher(request).search(Class.forName(type),criteria);
				   else
					   result = this.getSearcher(request).search(UserEntity.class,criteria);
			   }
			   else{
				   if(!type.equals("all")){			   
					   result = this.getSearcher(request).search(Class.forName(type),criteria);
					   List<LabelBean> beans = (List<LabelBean>)request.getPortletSession().getAttribute("searchTypes",PortletSession.APPLICATION_SCOPE);
					   for(LabelBean bean : beans){
						   if(bean.getId().equals(type))
							   bean.setDefaulted(true);
						   else
							   bean.setDefaulted(false);
					   }					   
				   }else{
					   result = this.getSearcher(request).search(criteria);
					   List<LabelBean> beans = (List<LabelBean>)request.getPortletSession().getAttribute("searchTypes",PortletSession.APPLICATION_SCOPE);
					   for(LabelBean bean : beans){
						   if(bean.getId().equals(type))
							   bean.setDefaulted(true);
						   else
							   bean.setDefaulted(false);
					   }
				   }
			   }
			   request.getPortletSession().setAttribute("criteria",criteria,PortletSession.APPLICATION_SCOPE);	
			   request.getPortletSession().setAttribute("gsResult",result,PortletSession.APPLICATION_SCOPE);	
		   }catch(Exception e){
			   
		   }
		}		
	  }
	
	private void initSearch(RenderRequest request){
		if(request.getPortletSession().getAttribute("searchTypes",PortletSession.APPLICATION_SCOPE) == null){
			List<LabelBean> types = new LinkedList<LabelBean>();
			types.add(new LabelBean("all","All"));
			String value=PropUtil.getString("portlet.search.list");
			String[] lists = value.split(";");
			int i = 0;
			for(String list : lists){
				String[] unit = list.split(",");							
				if(unit.length >= 4){
					if(i == 0)
						types.add(new LabelBean(unit[0],unit[3],true));
					else
						types.add(new LabelBean(unit[0],unit[3]));
				}
				i++;
			}
			request.getPortletSession().setAttribute("searchTypes",types,PortletSession.APPLICATION_SCOPE);
		}
	}
	
	protected void doView (RenderRequest request, RenderResponse response)
   		throws PortletException, java.io.IOException
	{	
		 initSearch(request);
		 String flowOff = request.getParameter("flowOff");
		 if(flowOff != null){
			 if("0".equals(flowOff))
				 request.getPortletSession().setAttribute("flowOff",true,PortletSession.APPLICATION_SCOPE);
			 else
				 request.getPortletSession().removeAttribute("flowOff",PortletSession.APPLICATION_SCOPE);
		 }
		 String viewType = request.getParameter("viewType");	
		 if(viewType != null && "2".equals(viewType))
			 doViewFlow(request,response);
		 else if(viewType != null && "1".equals(viewType))
			 doViewFlowPage(request,response);
		 else
			 doViewNormal(request,response);		
	}	
	private void doViewFlow (RenderRequest request, RenderResponse response)
		throws PortletException, java.io.IOException
	{	
	 SearchResult result = (SearchResult)request.getPortletSession().getAttribute("gsResult",PortletSession.APPLICATION_SCOPE);		 
	 if(result != null){		 
		 int number = 0;
		 int total = result.getTotal();

		 if(request.getParameter("page") != null){
			 try{
				 number = Integer.parseInt(request.getParameter("page"));	
			 }catch(Exception e){}
		 }else if(request.getParameter("number") != null){
			 try{
				 number = Integer.parseInt(request.getParameter("number"));	
			 }catch(Exception e){}
		 }
		 
		 if(number >= total) number = total - 1;
		 if(number < 0) number = 0;
		 List<SearchResultItem> leftPage = new LinkedList<SearchResultItem>();
		 for(int i=number - 5;i<number;i++){
			 if(i < 0) continue;
			 if(i >= total) break;
			 leftPage.add(result.getItems().get(i));
		 }
		 List<SearchResultItem> rightPage = new LinkedList<SearchResultItem>();
		 for(int i=number + 1;i<=number + 5;i++){
			 if(i >= total) break;
			 rightPage.add(0,result.getItems().get(i));
		 }
		 request.setAttribute("leftPage", leftPage);
		 request.setAttribute("rightPage", rightPage);
		 request.setAttribute("pages", total);
		 if(number < total)
			 request.setAttribute("current", result.getItems().get(number));
		 
		 request.setAttribute("page", number);
	 }
		
	 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/global/flowView.jsp").include(request,response);	 
	}
	private void doViewFlowPage (RenderRequest request, RenderResponse response)
		throws PortletException, java.io.IOException
	{		 
		 SearchResult result = (SearchResult)request.getPortletSession().getAttribute("gsResult",PortletSession.APPLICATION_SCOPE);		 
		 if(result != null){		 
		 int pageNumber = 5;
		 int pages = (result.getTotal() % pageNumber == 0) ? result.getTotal() / pageNumber : result.getTotal() / pageNumber + 1;
		 int page =0;
		 int number = 0;
		 int total = result.getTotal();
		 
		 if(request.getParameter("page") != null){
			 try{
				 page = Integer.parseInt(request.getParameter("page"));	
				 number = page * pageNumber;
			 }catch(Exception e){}
		 }else if(request.getParameter("number") != null){
			 try{
				 number = Integer.parseInt(request.getParameter("number"));	
				 page = number / pageNumber;
			 }catch(Exception e){}
		 }
		 
		 List<SearchResultItem> currentPage = new LinkedList<SearchResultItem>();
		 for(int i=page * pageNumber;i<result.getTotal();i++){
			 if(i>=(page + 1)* pageNumber) break;
			 currentPage.add(result.getItems().get(i));
		 }
		 request.setAttribute("members", currentPage);
		 request.setAttribute("pages", pages);
		 request.setAttribute("page", page);
	 }			
	 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/global/slideView.jsp").include(request,response);
	}	
	private void doViewNormal (RenderRequest request, RenderResponse response)
		throws PortletException, java.io.IOException
	{		 
		 SearchCriteria criteria = (SearchCriteria)request.getPortletSession().getAttribute("criteria",PortletSession.APPLICATION_SCOPE);
		 SearchResult result = (SearchResult)request.getPortletSession().getAttribute("gsResult",PortletSession.APPLICATION_SCOPE);		 
		 if(result != null){		 
			 int pageNumber = 5;
			 int pages = (result.getTotal() % pageNumber == 0) ? result.getTotal() / pageNumber : result.getTotal() / pageNumber + 1;
			 int page =0;
			 int number = 0;
			 int total = result.getTotal();
			 
			 if(request.getParameter("page") != null){
				 try{
					 page = Integer.parseInt(request.getParameter("page"));	
					 number = page * pageNumber;
				 }catch(Exception e){}
			 }else if(request.getParameter("number") != null){
				 try{
					 number = Integer.parseInt(request.getParameter("number"));	
					 page = number / pageNumber;
				 }catch(Exception e){}
			 }
			 List<SearchResultItem> currentPage = new LinkedList<SearchResultItem>();
			 for(int i=page * pageNumber;i<result.getTotal();i++){
				 if(i>=(page + 1)* pageNumber) break;
				 currentPage.add(result.getItems().get(i));
			 }
			 request.setAttribute("items", currentPage);
			 request.setAttribute("pages", pages);
			 request.setAttribute("page", page);
			 request.setAttribute("start",criteria.getRowPerPage() * page + 1);
			 request.setAttribute("end",(criteria.getRowPerPage() * (page + 1) < result.getTotal()) ? criteria.getRowPerPage() * (page + 1) : result.getTotal());
			 
			 //flow view	 		 
			 if(number >= total) number = total - 1;
			 if(number < 0) number = 0;
			 List<SearchResultItem> leftPage = new LinkedList<SearchResultItem>();
			 for(int i=number - 5;i<number;i++){
				 if(i < 0) continue;
				 if(i >= total) break;
				 leftPage.add(result.getItems().get(i));
			 }
			 List<SearchResultItem> rightPage = new LinkedList<SearchResultItem>();
			 for(int i=number + 1;i<=number + 5;i++){
				 if(i >= total) break;
				 rightPage.add(0,result.getItems().get(i));
			 }
			 request.setAttribute("leftPage", leftPage);
			 request.setAttribute("rightPage", rightPage);
			 if(number < total)
				 request.setAttribute("current", result.getItems().get(number));
	
		 }			
		 this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/global/view.jsp").include(request,response);
	}	
	
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {	
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/global/edit.jsp").include(request,response);
	 }
	
	 protected Searcher getSearcher(PortletRequest request) {			
		return (Searcher)getService(this.getServletRequest(request), "searcher");
	}
}
