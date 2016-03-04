package model;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;  
import org.springframework.transaction.annotation.Transactional;

import java.util.*;  


public class UserDao {
  
    
   
    HibernateTemplate template;  
    public void setTemplate(HibernateTemplate template) {  
        
    	
    	this.template = template;  
    }  
    //method to save employee 

    @Transactional(readOnly=false)
    public void saveUser(User u){  
        
    	  	template.save(u); 
        
    }  
    //method to update employee  
    public void updateUser(User u){  
        template.update(u);  
    }  
    //method to delete employee  
    public void deleteUser(User u){  
        template.delete(u);  
    }  
    //method to return one employee of given id  
    public User getById(int id){  
    	User e=(User)template.get(User.class,id);  
        return e;  
    }  
    public User getByNamePassword(String name, String password){  
    	//User e=(User)template.get(User.class,name, password);
    	User u;
    	 List<?> userlist = template.findByNamedParam("from User where name=:name and password=:password", new String[]{"name","password"}, new Object[]{name, password});//("select * from user where name=? and password=?", name,password)
   if(!userlist.isEmpty())
        {  u=(User) userlist.get(0);  }
   else
        { u=null;}
      return u;
    }  
    //method to return all employees  
    public List<User> getUsers(){  
        List<User> list=new ArrayList<User>();  
        list=template.loadAll(User.class);  
        return list;  
    }

	public User getByName(String name) {
		// TODO Auto-generated method stub
		User u;
   	 List<?> userlist = template.findByNamedParam("from User where name=:name", new String[]{"name"}, new Object[]{name});//("select * from user where name=? and password=?", name,password)
  if(!userlist.isEmpty())
       {  u=(User) userlist.get(0);  }
  else
       { u=null;}
     return u;
		
		
	}

	public User getByEmail(String email) {
		// TODO Auto-generated method stub
		User u;
	   	 List<?> userlist = template.findByNamedParam("from User where email=:email", new String[]{"email"}, new Object[]{email});//("select * from user where name=? and password=?", name,password)
	  if(!userlist.isEmpty())
	       {  u=(User) userlist.get(0);  }
	  else
	       { u=null;}
	     return u;
	}  
    }  

