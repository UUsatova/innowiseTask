public class Main {
    public static void main(String[] args) {
        UserCreator userCreator = new UserCreator();
        UserDataBaseCreator userDataBaseCreator = new UserDataBaseCreator();
        UserDataBase a = userDataBaseCreator.createDataBase(userCreator);
        a.showConsoleDataBase();
        userCreator.changeUser( a.getUser(0));
        a.showConsoleDataBase();
        
    }
}
