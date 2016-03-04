package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

public class TransactionDao {

	HibernateTemplate template; 
	
    public void setTemplate(HibernateTemplate template) {  
        
    	
    	this.template = template;  
    }  
    public void saveTransaction(Transaction i){  
        
	  	template.save(i); 
    
} 
	
}
