package org.light.portlets.demo.jfreechart;

import static org.light.portal.util.Constants._CHARSET_UTF;
import static org.light.portal.util.Constants._PORTLET_JSP_PATH;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.light.portal.portlet.core.impl.LightGenericPortlet;

public class JFreeChartDemoPortlet extends LightGenericPortlet {
	 
	public void processAction (ActionRequest request, ActionResponse response) 
    throws PortletException, java.io.IOException {
		String action = request.getParameter("action");
		
	  }
	 
	 protected void doView (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {
		PieDataset dataset = createDataset();
		JFreeChart chart =  createChart(dataset);
		String path = getServletRequest(request).getSession().getServletContext().getRealPath("/")+"jfreechart/test.png";
		String relativePath ="jfreechart/test.png";
		java.io.File file = new java.io.File(path);
		ChartUtilities.saveChartAsPNG(file,chart,280,250);
		request.setAttribute("path", relativePath);
		this.getPortletContext().getRequestDispatcher(_PORTLET_JSP_PATH+"/demo/jfreechart/jFreeChartPortletView.jsp").include(request,response);  
				
	 }	
	 
	 protected void doEdit (RenderRequest request, RenderResponse response)
	   throws PortletException, java.io.IOException
	 {  
		doView(request,response);		
	 }	
	 
	 private PieDataset createDataset(){
		 DefaultPieDataset dataset = new DefaultPieDataset();
		 dataset.setValue("Software",15.2);
		 dataset.setValue("Services",45.1);
		 dataset.setValue("Hardware",19.7);
		 dataset.setValue("Network",10.8);
		 dataset.setValue("Training",9.2);
		 
		 return dataset;
	 }
	 
	 private JFreeChart createChart(PieDataset dataset){
		 JFreeChart chart = null;
		 String title="IT expenditures 2003";
		 chart = ChartFactory.createPieChart3D(title,dataset,true,false,false);
		 return chart;
	 }
}

