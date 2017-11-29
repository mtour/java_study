package com.mtour.mybatis.demo;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.ws.rs.GET;  
import javax.ws.rs.Path;  
import javax.ws.rs.Produces;  
import javax.ws.rs.PathParam;  
import javax.ws.rs.core.MediaType;  


  
@Path("/student")  
public class demo {  
	
	static String resource = "conf.xml";
	static InputStream is = demo.class.getClassLoader().getResourceAsStream(resource);
	static SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
	
    @GET  
    @Produces(MediaType.TEXT_PLAIN)  
    public String sayHello() {  
        return "hello jersey , first demo" ;  
    }  
      
    @GET  
    @Path("/{param}")    
    @Produces("text/plain;charset=UTF-8")  
    public String sayHelloToUTF8(@PathParam("param") String username) {  
        return "Hello " + username;  
    }  
    
    @GET  
    @Path("/getstudent/{id}")  
    @Produces(MediaType.APPLICATION_JSON)  
    public Student getUserJson(@PathParam("id") String id) {  
    	
     Integer studentId = Integer.valueOf(id);
     
     
     SqlSession session = sessionFactory.openSession();
    
     String statement = "com.mtour.mybatis.demo.studentMapper.getStudent";
     
     Student s = session.selectOne(statement, studentId);
     
     session.close();
    	
     return s;  
    }
      
    
    
    
}  
