package org.example;

import org.example.model.User;
import org.example.service.UserService;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        UserService userService = new UserService();

        userService.createTable();
//        userService.saveUser(new User("Meder", "Tynychbekov"));
//        userService.saveUser(new User("Aidai", "Ysmaiylova"));

        User user = userService.findUserById(8);

        System.out.println(user);
    }
}
