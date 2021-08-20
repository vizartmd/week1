package com.main;

import java.util.List;
import com.servicedao.domain.User;
import com.servicedao.service.UserServiceImpl;
import com.servicedao.service.UserServiceIntf;

/**
 * @author vrobu1
 *
 */
public class App {
	public static void main(String[] args) {
//    	User newUser = new User(6, "Petea", "0000000");

		UserServiceIntf userService = new UserServiceImpl();
//    	userService.createUser(newUser);
		List<User> users = userService.getAllUsers();
//
		for (User user : users) {
			System.out.println(user);
		}
		
		User findedUser = userService.findUserById(4);
		System.out.println(findedUser);

//		User updatedUser = new User(2, "Gabriela");
//		User updatedUser2 = new User(3, "Mihaela");
//		userService.updateUser(updatedUser);
//		userService.updateUser(updatedUser2);

//		System.out.println("------------------------------- after update ----------------------------------");

//		for (User user : users) {
//			System.out.println(user);
//		}

//		userService.deleteUser(3);
//		List<User> users2 = userService.getAllUsers();
//
//		System.out.println("------------------------------- after delete ----------------------------------");
//
//		for (User user : users2) {
//			System.out.println(user);
//		}
	}
}
