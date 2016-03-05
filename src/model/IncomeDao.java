package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class IncomeDao {
	  HibernateTemplate template;  
	    public void setTemplate(HibernateTemplate template) {  
	        
	    	
	    	this.template = template;  
	    }  
	

	    @Transactional(readOnly=false)
	    public void saveIncome(Income i){  
	        
	    	  	template.save(i); 
	        
	    }  
	 
	    public void updateIncome(Income i){  
	        template.update(i);  
	    }  
	
	    public void deleteIncome(Income i){  
	        template.delete(i);  
	    }  
	    
	    public Income getById(int id){  
	    	Income i=(Income)template.get(Income.class,id);  
	        return i;  
	    }  
		public List<Income> getIncomes(){  
	        List<Income> list=new ArrayList<Income>();  
	        list=template.loadAll(Income.class);  
	        return list;  
	        
	    } 
		public List<Income> getIncomesbyUid(int uid){  
	       //Income list;  
	        List<Income> incomelist = (List<Income>)template.findByNamedParam("from Income where uid=:uid order by incmid desc", new String[]{"uid"}, new Object[]{uid}); 
//	        if(!incomelist.isEmpty())
//	        {   }
//	   else
//	        { incomelist=null;}
	      
	 
	        return incomelist;  
	        
	    } 
}