package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class ExpenseCategoryDao {
	 HibernateTemplate template;  
	    public void setTemplate(HibernateTemplate template) {  
	        
	    	
	    	this.template = template;  
	    }  
	public List<ExpenseCategory> getExpenseCat(){  
     List<ExpenseCategory> list=new ArrayList<ExpenseCategory>();  
     list=template.loadAll(ExpenseCategory.class);  
     return list;  
     
 }
	
 @Transactional(readOnly=false)
 public void saveExpenseCat(ExpenseCategory ec){  
     
 	  	template.save(ec); 
     
 }
public ExpenseCategory getExpCatbyId(int id) {
	// TODO Auto-generated method stub
	ExpenseCategory e=(ExpenseCategory)template.get(ExpenseCategory.class,id);  
    return e;  

}  

public List<ExpenseCategory> getExpCatsbyUid(int uid){  
    //Income list;  
     List<ExpenseCategory> expensecatlist = (List<ExpenseCategory>)template.findByNamedParam("from ExpenseCategory where uid=:uid", new String[]{"uid"}, new Object[]{uid}); 
//     if(!incomelist.isEmpty())
//     {   }
//else
//     { incomelist=null;}
   

     return expensecatlist;  
     
 } 
}
