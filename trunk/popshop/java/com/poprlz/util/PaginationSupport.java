package com.poprlz.util;

import java.util.List;

public class PaginationSupport<T> {
	 public final static int PAGESIZE = 15;  
	 
	 	private int currentPage=1;
	 	
	   
	     private int pageSize = PAGESIZE;  
	   
	     private List<T> items;  
	   
	     private int totalCount; 
	     
	     private int totalPage;
	     
	     private int[] pageIndexes = new int[0];
	   
	     public int[] getPageIndexes() {
			return pageIndexes;
		}

		public void setPageIndexes(int[] pageIndexes) {
			this.pageIndexes = pageIndexes;
		}

		private int[] indexes = new int[0];  
	   
	     private int startIndex = 0;  
	   
	     public PaginationSupport(List<T> items, int totalCount) {  
	         setPageSize(PAGESIZE);  
	                 setTotalCount(totalCount);  
	         setItems(items);          
	         setStartIndex(0);  
	     }  
	   
	     public PaginationSupport(List<T> items, int totalCount, int currentPage) {  
	         setPageSize(PAGESIZE);  
	         setTotalCount(totalCount);  
	         setItems(items);      
	         setCurrentPage(currentPage);
	         //setStartIndex(startIndex);  
	     }  
	   
	     public PaginationSupport(List<T> items, int totalCount, int pageSize, int currentPage) {  
	                 setPageSize(pageSize);  
	         setTotalCount(totalCount);  
	         setItems(items);  
	         setCurrentPage(currentPage);
	         //setStartIndex(startIndex);  
	     }  
	   
	     public List<T> getItems() {  
	         return items;  
	     }  
	   
	     public void setItems(List<T> items) {  
	         this.items = items;  
	     }  
	   
	     public int getPageSize() {  
	         return pageSize;  
	     }  
	   
	     public void setPageSize(int pageSize) {  
	         this.pageSize = pageSize;  
	     }  
	   
	     public int getTotalCount() {  
	         return totalCount;  
	     }  
	   
	     public void setTotalCount(int totalCount) {  
	         if (totalCount > 0) {  
	             this.totalCount = totalCount;  
	             int count = totalCount / pageSize;  
	             if (totalCount % pageSize > 0)  
	                 count++;  
	             indexes = new int[count];  
	             for (int i = 0; i < count; i++) {  
	                 indexes[i] = pageSize * i;  
	             }  
	             
	             this.totalPage=indexes.length;
	         } else {  
	             this.totalCount = 0; 
	             this.totalPage=1;
	         } 
	         initPageIndex();
	     }
	     
	     private void initPageIndex(){
	    	 if (totalPage > 0) {
	    		 this.pageIndexes=new int[totalPage];
	    		 for(int i=0;i<totalPage;i++)
	    			 pageIndexes[i]=i+1; 
	    	 }
	     }
	   
	     public int[] getIndexes() {  
	         return indexes;  
	     }  
	   
	     public void setIndexes(int[] indexes) {  
	         this.indexes = indexes;  
	     }  
	   
	     public int getStartIndex() {  
	         return startIndex;  
	     }  
	   
	     public void setStartIndex(int startIndex) {  
	         if (totalCount <= 0)  
	             this.startIndex = 0;  
	         else if (startIndex >= totalCount)  
	             this.startIndex = indexes[indexes.length - 1];  
	         else if (startIndex < 0)  
	             this.startIndex = 0;  
	         else {  
	             this.startIndex = indexes[startIndex / pageSize];  
	         }  
	     }  
	   
	     public int getNextIndex() {  
	         int nextIndex = getStartIndex() + pageSize;  
	         if (nextIndex >= totalCount)  
	             return getStartIndex();  
	         else  
	             return nextIndex;  
	     }  
	   
	     public int getPreviousIndex() {  
	         int previousIndex = getStartIndex() - pageSize;  
	         if (previousIndex < 0)  
	             return 0;  
	         else  
	             return previousIndex;  
	     }

		public int getTotalPage() {
			return totalPage;
		}

		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}

		public int getCurrentPage() {
			return currentPage;
		}

		public void setCurrentPage(int currentPage) {
			
			 if (totalCount <= 1)  
	             this.currentPage = 1;  
	         else if (currentPage*this.pageSize >= totalCount)  
	             this.currentPage = indexes.length;  
	         else 
	        	 this.currentPage=currentPage;
			 this.setStartIndex(this.currentPage*this.pageSize-this.pageSize);
			 
		}  
		
		 public int getNextPage() {  
	         int nextPage = getCurrentPage() + 1;  
	         if (nextPage >= totalPage)  
	             return getCurrentPage();  
	         else  
	             return nextPage;  
	     }  
	   
	     public int getPreviousPage() {  
	         int previousPage = getCurrentPage() - 1;  
	         if (previousPage < 1)  
	             return 1;  
	         else  
	             return previousPage;  
	     }
}
