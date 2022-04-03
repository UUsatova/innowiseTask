import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDataBase {

    private List<User> dataBase;

    public UserDataBase(){
    dataBase = new ArrayList<>();

    }

    public void addUser(User user){
        dataBase.add(user);
    }

    public void showConsoleDataBase(){
        dataBase.stream().forEach(item -> System.out.println(item.toString()));

    }

    public void showFileDataBase(String fileName) throws IOException{
        FileWorker fw = new FileWorker(fileName);
        fw.clean();
        for(User item : dataBase){
            fw.writer(item.toString());

        }

    }
  
    public int findUserIndex(User usr){
        for(int i = 0; i< dataBase.size();i++){
            if(usr.equals(dataBase.get(i))) return i;
        }
        return -1;
    }

    public User getUser(int i){
      if(i < dataBase.size())  return dataBase.get(i);
      return null;

    }

    public void deliteUser(int i){
        if(i < dataBase.size())   dataBase.remove(i);

    }

    public void deliteUser(User usr){
        int i = 0;
        if ((i = findUserIndex(usr)) != -1) {
             dataBase.remove(i);

        }

     }
    
}