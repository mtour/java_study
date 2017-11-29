package mongodbDemo;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

public class demo {
    
    public static void main(String[] args) {
    	
    	Morphia morphia = new Morphia();

    	// 告诉Morphia在哪里找到你的类
    	// 可以为不同的包或者类进行多次的调用
    	morphia.mapPackage("mongodbDemo");

    	//创建datastore，并连接到指定数据库
    	//datastore有两个参数，第一个用来连接到MongoDB，第二个是数据库的名字。
    	final Datastore datastore = morphia.createDatastore(new MongoClient("localhost"), "morphia_example");
    	datastore.ensureIndexes();
    	
    	final User user = new User(0,"zhansan",false,20,"home");
    	datastore.save(user);
    	
    	
	}
	
}
