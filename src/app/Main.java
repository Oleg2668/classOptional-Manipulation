package app;


import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        UserRepository repository = new UserRepository();

/*User user=new User(01,"Ella","ella@gmail.com");
User user1=new User(02,"Oleg","oleg@gmail.com");
User user2=new User(03,"Yevgen","yevgen@gmail.com");
User user3=new User(04,"Julia","julia@gmail.com");*/
// Додаємо користувачей до списку List
       repository.addUserList(new User(01,"Ella","ella@gmail.com"));
        repository.addUserList(new User(02,"Oleg","oleg@gmail.com"));
        repository.addUserList(new User(03,"Yevgen","yevgen@gmail.com"));
        repository.addUserList(new User(04,"Julia","julia@gmail.com"));

        // Пошук користувача за id

        Optional<User> userById = repository.findUserById(03);
        userById.ifPresent(user -> System.out.println("Found user by ID: " + user));
        userById.orElseGet(() -> {
            System.out.println("User not found by ID");
            return null;
        });

        // Пошук користувача за e-mail
        Optional<User> userByEmail = repository.findUserByEmail("yevgen@gmail.com");
        userByEmail.ifPresent(user -> System.out.println("Found user by e-mail: " + user));
        userByEmail.orElseGet(() -> {
            System.out.println("User not found by e-mail");
            return null;
        });

        Optional<List<User>>listAllUsers=repository.findAllUsers();
        listAllUsers.ifPresent(users -> {
            System.out.println("Number of users: " + users.size());
            users.forEach(System.out::println);
        });
        listAllUsers.orElseGet(() -> {
            System.out.println("No users found");
            return null;
        });


    }
    }

