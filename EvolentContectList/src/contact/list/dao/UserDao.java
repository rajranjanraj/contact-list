package contact.list.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import contact.list.bean.User;

public class UserDao {

	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	} 
	
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	public int save(User u){  
		int i = 0;
		int oldId=0;
		try{
			try{
		       oldId=template.queryForObject("select max(id) from USERSCONTACT", Integer.class);
			}
			catch(Exception e){
				System.out.println("Exception in save operation:" +e);
			}
		 int id = oldId+1; 
		 String sql="insert into USERSCONTACT values('"+id+"','"+u.getFirstName()+"','"+u.getLastName()+"','"+u.getEmailId()+"',"+u.getPhoneNo()+",'"+u.getStatus()+"')"; 
	    i = template.update(sql); 
		}catch(Exception e){
			System.out.println("Exception in save operation:" +e);
		}
		return i;
	}   
	
	public int update(User u){
		int i = 0 ;
		try{
			String sql="update USERSCONTACT set firstName='"+u.getFirstName()+"', lastName='"+u.getLastName()+"', emailId='"+u.getEmailId()+"', phoneNo="+u.getPhoneNo()+",status='"+u.getStatus()+"' where id="+u.getId()+""; 
			i = template.update(sql);  
		   }catch(Exception e)
		{System.out.println("Exception :" +e);}  
		return i;
	}  
	
	public int delete(int id){
		int i = 0;
		try{
			String sql="delete from USERSCONTACT where id="+id+"";    
			i = template.update(sql);  
		}catch(Exception e){
			System.out.println("Exception :" +e);
		}
		return i;
	}    
	public User getUserById(int id){
		User u = new User();
		try{
	    String sql="select * from USERSCONTACT where id=?";    
	    u = template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<User>(User.class)); 
		}catch(Exception e){
			System.out.println("Exception :" +e);
		}
		return u;
	}    
	public List<User> getUser(){ 
		List<User> userList = new ArrayList<User>();
		try{
		userList = template.query("select * from USERSCONTACT order by id",new RowMapper<User>(){    
	        public User mapRow(ResultSet rs, int row) throws SQLException {    
	        	User u=new User();    
	            u.setId(rs.getInt(1));    
	            u.setFirstName(rs.getString(2));   
	            u.setLastName(rs.getString(3));
	            u.setEmailId(rs.getString(4));
	            u.setPhoneNo(rs.getLong(5));    
	            u.setStatus(rs.getString(6)); 
	            list.add(rs.getInt(1));
	            return u;    
	        }    
	    });  
		}catch(Exception e){
			System.out.println("Exception :" +e);
		}
		return userList;
	}
	
}

