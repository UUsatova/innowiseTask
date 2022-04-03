import java.util.ArrayList;
import java.util.List;

public class User{

    public String firstName;
    public String lastName;
    public String email;
    public List<Long> phoneNumbers;
    public Role role;

    public User(){
        phoneNumbers = new ArrayList<>();
        role = new Role();

    }

    public User(String firstName,String lastName,String email,List<Long> phoneNumbers,Role role){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumbers = phoneNumbers;
        this.role = role;

    }
/////////////////////////////////////////////////////
    public void setLastName(String lastName){
        this.lastName = lastName;

    }

    public void setEmail(String email){
        this.email = email;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPhoneNumbers(List<Long> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public void setRole(Role role) {
        this.role = role;

    }
    //////////////////////////////////////////////////////
    public String getFirstName(){
        return firstName;

    }

    public String getLastName(){
        return lastName ;

    }

    public String getEmail(){
        return email ;

    }

    public List<Long> getPhoneNumbers(){ 
        return phoneNumbers;
        
    }

    public String getRole(){       
        return role.trueStatments();

    }
////////////////////////////////////////////////////
    public  String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nИмя пользователя: " + getFirstName() ); 
        sb.append("\nФамилия пользователя: " + getLastName());
        sb.append("\nEmail позьзователя: " + getEmail());
        sb.append( "\nНомера пользователя"); 
        if(getPhoneNumbers().isEmpty()) sb.append( " отсутствуют");
        else {
            for(Long item : getPhoneNumbers()){
                sb.append("\n+" + item ); 

            }
        }
        sb.append("\nРоль/роли пользователя: " + getRole() ); 
        sb.append( "\n"); 
        return sb.toString();

    }
  
} 






















