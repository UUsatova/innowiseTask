import java.util.ArrayList;
import java.util.List;

public class UserCreator {

    private String getFirstName(){
        return Input.input();

    }

    private String getLastName(){
        return Input.input();

    }

    private String getEmail(){
        return Input.input("^.+@.+\\..+$");

    }

    private Long getPhone(){ 
        System.out.print( "Введите номер:\n>>");
        String phone =  Input.input("^(\\+?)375\\d{9}$");
        return Long.parseLong(phone);
       
       
    }

    private List<Long> getPhoneNumbers(){  
        List<Long> listWithPhones = new ArrayList<>(); 
        int i = 0;
        System.out.println("что бы добавить номер нажмите +,в противном случае любую другую клавишу");
        System.out.print(">> ");
        while(i < 3 && Input.input().equals("+")){
            listWithPhones.add( getPhone());
            System.out.println("что бы добавить номер нажмите +,в противном случае любую другую клавишу");
            System.out.print(">> ");
            i++;
        }
        return listWithPhones;
    }

    private Role getRole(Role role){ 
        if(role == null) role = new Role();
        System.out.println("1 USER");
        System.out.println("2 CUSTOMER");
        System.out.println("3 ADMIN");
        System.out.println("4 PROVIDER");
        System.out.println("5 SUPER_ADMIN");
        System.out.println("нажмите на 0 что-бы завершить");

        int i = 0;
        while (true) {
            System.out.println("Введите числовое значение для установления роли или завершения операции");
            i = Input.inputInt();
            while(i > 5 || i < 0) {
                System.out.println("неверный ввод");
                i = Input.inputInt();
    
            }
            if(i == 0) break;
            choseRole(i, role);
            System.out.println(role.trueStatments());
            
        }
        return role;   

    }

    private void choseRole(int i,Role role){ 
        switch (i) {
            case  (1):
               role.setUSER();
            break;
            case (2):
               role.setCUSTOMER(); 
            break;
            case (3):
               role.setADMIN();
            break;
            case (4):
               role.setPROVIDER();
                break;
            case (5):
               role.setSUPER_ADMIN();
                break;
        }
        System.out.println("Успешно установлено");
    }

    private void changeParametr(int i,User person){
        switch (i) {
                    case  (1):
                        System.out.println("Исходное имя пользователя " + person.getFirstName()); 
                        System.out.print("Измененное имя пользователя\n>> ");person.setFirstName(getFirstName());
                        System.out.println("Успешно изменено");
                        break;
                    case (2):
                        System.out.println("Исходная фамилия пользователя " + person.getLastName());
                        System.out.print("Измененная фамилия пользователя\n>> "); person.setLastName(getFirstName());
                        System.out.println("Успешно изменено");
                        break;
                    case (3):
                        System.out.println("Исходный Email пользователя " + person.getEmail());
                        System.out.print("Измененный Email пользователя\n>> "); person.setEmail(getEmail());
                        System.out.println("Успешно изменено");
                        break;
                    case (4):
                        System.out.println("Исходные номера  пользователя " + person.getPhoneNumbers());
                        System.out.print("Измененние номеров пользователя\n "); person.setPhoneNumbers(getPhoneNumbers());
                        System.out.println("Успешно изменено");
                        break;
                    case (5):
                        System.out.println("Исходные роли пользователя " + person.getRole().toString()); 
                        System.out.print("Измененние ролей пользователя\n>> "); person.setRole(getRole(person.role));
                        System.out.println("Успешно изменено");
                        break;
                    case (6):
                        System.out.println("пользователь сохранен");
                        break;
                   
                }
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////
    public User createUser(){
        System.out.print("Имя пользователя >> "); 
        String firstName = getFirstName();
        System.out.print("Фамилия пользователя>> ");
        String lastName = getLastName();
        System.out.print("Email позьзователя>> ");
        String email = getEmail();
        System.out.println("Пользователь может иметь до трех номеров телефона");
        List<Long> phoneNumbers = getPhoneNumbers();
        System.out.println("Роль пользователя "); 
        Role role = getRole(null);
        User pearson = new User(firstName, lastName, email, phoneNumbers, role);
        System.out.println("создание завершено");
        return pearson;
       
    
    }

    public void changeUser(User person){
        try{
            UserCreator userCreator = new UserCreator();
            System.out.println("Изменить пользователя:  " );
            System.out.println(person.toString());

            System.out.println("1 изменить имя");
            System.out.println("2 изменить фамилию");
            System.out.println("3 изменить Email");
            System.out.println("4 изменить номер");
            System.out.println("5 изменить роль");
            System.out.println("6 сохранить и завершить  ");
            int i = Input.inputInt();
            do{
                while(i > 5 && i < 1) {
                    System.out.println("неверный ввод");
                    System.out.print(">>  ");
                    i = Input.inputInt();

                }
                userCreator.changeParametr(i,person);
                System.out.println("Введите числовое значение для дальнейшего редактирования или соxранения результата и завершения");
                i = Input.inputInt();
            
             } while(i < 6 && i > 0  );
        } catch(Exception e){
            System.out.println("проверьте передаваемые данные");
        }
     
    }

    public static void main(String[] args){ 
        
        UserCreator userCreator = new UserCreator();
        User a  = userCreator.createUser();
        System.out.println(a.toString());
        // userCreator.changeUser(a);
        // System.out.println(a.toString());

    }
}
