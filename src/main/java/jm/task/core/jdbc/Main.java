package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl service = new UserServiceImpl();
        System.out.println("создаем таблицу");
        service.createUsersTable();
        System.out.println("создали таблицу");

        //создаем  4 usera

        User user1 = new User("Kirill1", "Semin1", (byte) 41);
        User user2 = new User("Kirill2", "Semin2", (byte) 42);
        User user3 = new User("Kirill3", "Semin3", (byte) 43);
        User user4 = new User("Kirill4", "Semin4", (byte) 44);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        System.out.println("Создали лист");
        //сохраняем в бд и выводим в консоль
        for (User element : userList) {
            service.saveUser(element.getName(), element.getLastName(), element.getAge());
            System.out.println("User с именем - " + element.getName() + " добавлен в базу данных");
        }
        System.out.println("Сохранили пользователей в БД");
        //получение всех user
        List<User> select = service.getAllUsers();
        select.stream().forEach(System.out::println);
        System.out.println("Получили пользователей");
        //очистка таблицы
        service.cleanUsersTable();
        System.out.println("Очистили таблицу");
        //удаление таблицы
        service.dropUsersTable();
        System.out.println("Удалили таблицу");
        try {
            Util.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
