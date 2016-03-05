package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class ExpenseDao {
	  HibernateTemplate template;  
	    public void setTemplate(HibernateTemplate template) {  
	        
	    	
	    	this.template = template;  
	    }  
	 

	    @Transactional(readOnly=false)
	    public void saveExpense(Expense i){  
	        
	    	  	template.save(i); 
	        
	    }  
	    
	    public void updateExpense(Expense i){  
	        template.update(i);  
	    }  
	
	    public void deleteExpense(Expense i){  
	        template.delete(i);  
	    }  
	    
	    public Expense getById(int id){  
	    	Expense i=(Expense)template.get(Expense.class,id);  
	        return i;  
	    }  
		public List<Expense> getExpenses(){  
	        List<Expense> list=new ArrayList<Expense>();  
	        list=template.loadAll(Expense.class);  
	        return list;  
	        
	    }

		public List<Expense> getExpensesbyUid(Integer uid) {
			// TODO Auto-generated method stub
			List<Expense> expenselist = (List<Expense>)template.findByNamedParam("from Expense where uid=:uid order by expid desc", new String[]{"uid"}, new Object[]{uid});
			  return expenselist; 
		} 
}
