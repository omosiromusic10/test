package com.internousdev.glanq.dto;

public class MCategoryDTO {

		  private int id;
		  private int categoryId;
		  private String categoryName;
		  private String categoryDescription;
		  private String insertDate;
		  private String updateDate;

		public int getId(){
		 return id;
		   }
		public void setId(int id){
		 this.id=id;
		}

		public int getCategoryId(){
		 return categoryId;
		   }
		public void setCategoryId(int categoryId){
		 this.categoryId=categoryId;
		}

		public String getCategoryName(){
		 return categoryName;
		   }
		public void setCategoryName(String categoryName){
		 this.categoryName=categoryName;
		}

		public String getCategoryDescription(){
		 return categoryDescription;
		   }
		public void setCategoryDescription(String categoryDescription){
		 this.categoryDescription=categoryDescription;
		}

		public String getInsertDate(){
		 return insertDate;
		   }
		public void setInsertDate(String insertDate){
		 this.insertDate=insertDate;
		}

		public String getUpdateDate(){
		 return updateDate;
		   }
		public void setUpdateDate(String updateDate){
		 this.updateDate=updateDate;
		}


}
