package com.mtour.rest.resources;

import java.util.Map;

import javax.ws.rs.GET;  
import javax.ws.rs.Path;  
import javax.ws.rs.Produces;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.core.MediaType;  

import com.sun.jersey.api.core.ResourceConfig;
  
@Path("/hello")  
public class HelloResource extends ResourceConfig{  
	
    @GET  
    @Produces(MediaType.TEXT_PLAIN)  
    public String sayHello() {  
    	System.out.println("hello jersey , first demo");
        return "hello jersey , first demo" ;  
    }  
   
      
    @GET  
    @Path("/{param}")    
    @Produces("text/plain;charset=UTF-8")  
    public String sayHelloToUTF8(@PathParam("param") String username) {  
        return "Hello " + username;  
    }  
    
    @GET  
    @Path("/getuser")  
    @Produces(MediaType.APPLICATION_JSON)  
    public User getUserJson() {  
     User user  = new User();  
     user.setAge(27);  
     user.setUserid("005");  
     user.setUsername("Fmand");  
     return user;  
    }

	@Override
	public boolean getFeature(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Boolean> getFeatures() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getProperty(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
      
}  