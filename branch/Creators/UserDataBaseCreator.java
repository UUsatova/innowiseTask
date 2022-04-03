package branch.Creators;
import branch.Servise.Input;
import branch.init.UserDataBase;

public class UserDataBaseCreator {

    public UserDataBase createDataBase(UserCreator userCreator){
        UserDataBase dataBase = new UserDataBase();
        System.out.println("Для создания нового пользователя нажмите +,что-бы завершить процесс заполнения базы данных нажмите на любую клавишу");
        System.out.print(">>");
        while (Input.input().equals("+")) {
            dataBase.addUser(userCreator.createUser());
            System.out.println("Для создания нового пользователя нажмите +,что-бы завершить процесс заполнения базы данных нажмите на любую клавишу");
            System.out.print(">>");
            
        }

        return dataBase ;

    }

}
