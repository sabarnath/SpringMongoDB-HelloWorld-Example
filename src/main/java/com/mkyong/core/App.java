package com.mkyong.core;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mkyong.config.SpringMongoConfig;
import com.mkyong.model.EmployeeVO;
import com.mkyong.model.User;
//import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {

		ApplicationContext ctx = null;
		try {
			// For XML
			//ctx = new GenericXmlApplicationContext("SpringConfig.xml");

			// For Annotation
			 ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		} catch (Throwable e) {
			System.out.println("While initialization getting error : "+e);
			System.exit(0);
		}
		
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		//userCURDOperation(mongoOperation);
		employeeCURDOperation(mongoOperation);

	}

	private static void userCURDOperation(MongoOperations mongoOperation) {
		User user = new User("mkyong", "password123");

		// save
		user.setId(UUID.randomUUID().toString());
		mongoOperation.save(user);

		// now user object got the created id.
		System.out.println("1. user : " + user);

		// query to search user
		Query searchUserQuery = new Query(Criteria.where("username").is("mkyong"));

		// find the saved user again.
		User savedUser = mongoOperation.findOne(searchUserQuery, User.class);
		System.out.println("2. find - savedUser : " + savedUser);

		// update password
		mongoOperation.updateFirst(searchUserQuery, Update.update("password", "new password"),
				User.class);

		// find the updated user object
		User updatedUser = mongoOperation.findOne(
				new Query(Criteria.where("username").is("mkyong")), User.class);

		System.out.println("3. updatedUser : " + updatedUser);

		// delete
		mongoOperation.remove(searchUserQuery, User.class);

		// List, it should be empty now.
		List<User> listUser = mongoOperation.findAll(User.class);
		System.out.println("4. Number of user = " + listUser.size());
	}
	
	private static void employeeCURDOperation(MongoOperations mongoOperation) {
		int size = 10;
		for (int i = 0; i < size; i++) {
			/*EmployeeVO emp = new EmployeeVO(RandomStringUtils.randomAlphanumeric(10),
					RandomStringUtils.randomAlphanumeric(10),
					UUID.randomUUID().toString(),
					"ACTIVE");
			// save
			emp.setId(UUID.randomUUID().toString());
			mongoOperation.save(emp);*/
		}
		

	}

}