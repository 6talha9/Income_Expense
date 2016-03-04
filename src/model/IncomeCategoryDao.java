package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class IncomeCategoryDao {
    
	 HibernateTemplate template;  
	    public void setTemplate(HibernateTemplate template) {  
	        
	    	
	    	this.template = template;  
	    }  
	public List<IncomeCategory> getIncomesCat(){  
        List<IncomeCategory> list=new ArrayList<IncomeCategory>();  
        list=template.loadAll(IncomeCategory.class);  
        return list;  
        
    }
	
    @Transactional(readOnly=false)
    public void saveIncomeCat(IncomeCategory ic){  
        
    	  	template.save(ic); 
        
    }
	public IncomeCategory getIncCatbyId(int id) {
		// TODO Auto-generated method stub
	 
		IncomeCategory e=(IncomeCategory)template.get(IncomeCategory.class,id);  
		        return e;  

	}  
	public List<IncomeCategory> getIncmCatsbyUid(int uid){  
	       //Income list;  
	        List<IncomeCategory> incomecatlist = (List<IncomeCategory>)template.findByNamedParam("from IncomeCategory where uid=:uid", new String[]{"uid"}, new Object[]{uid}); 
//	        if(!incomelist.isEmpty())
//	        {   }
//	   else
//	        { incomelist=null;}
	      
	 
	        return incomecatlist;  
	        
	    } 
}
