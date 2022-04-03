

class Role{
      private boolean USER ;
      private boolean CUSTOMER;
      private boolean ADMIN ;
      private boolean PROVIDER;
      private boolean SUPER_ADMIN;
      
      
      public Role(){
           USER = false ;
           CUSTOMER = false ;
           ADMIN = false  ;
           PROVIDER= false ;
           SUPER_ADMIN= false ;
  
      }
  
      public boolean chekLevl1(){
          return (!(USER ^ CUSTOMER) && !SUPER_ADMIN ); 
      }
  
      public boolean chekLevl2(){
          return (!(ADMIN ^ PROVIDER)&& !SUPER_ADMIN);
      }
  
      public boolean chekLevl3(){
          return (!ADMIN && !PROVIDER && !USER && !CUSTOMER );
      }
  
      public String trueStatments(){
          String str = "";
          if(USER)  str = str + " USER ";
          if(CUSTOMER) str = str + " CUSTOMER ";
          if(ADMIN) str = str + " ADMIN ";
          if(PROVIDER) str = str + " PROVIDER ";
          if(SUPER_ADMIN) str = str + " SUPER_ADMIN ";
          if(str.equals("")) str = "роли не установлены";
          return str;
      }
  
      public void setUSER(){
          
          if(!chekLevl1()) {
              System.out.println("Установленные роли: " + trueStatments());
              System.out.println("Вы действительно хотите изменить роль? 1- да; любое другое число - нет");
              if(Input.inputInt() == 1){
                  USER = true;
                  CUSTOMER = false;
                  SUPER_ADMIN = false;
              }
              
   
          }
          else USER = true; 
  
      }
      public void setCUSTOMER(){
  
          if(!chekLevl1()) {
              System.out.println("Установленные роли: " + trueStatments());
              System.out.println("Вы действительно хотите изменить роль? 1- да; любое другое число - нет");
              if(Input.inputInt() == 1){
                  USER = false;
                  CUSTOMER = true;
                  SUPER_ADMIN = false;
              }
              
          }
          else CUSTOMER = true;
  
  
      }
      public void setPROVIDER(){  
  
          if(!chekLevl2()) {
          System.out.println("Установленные роли: " + trueStatments());
          System.out.println("Вы действительно хотите изменить роль? 1- да; любое другое число - нет");
          if(Input.inputInt() == 1){
              PROVIDER = true;
              ADMIN = false;
              SUPER_ADMIN = false;
          }
          
      }
      else PROVIDER = true;
  }
      public void setADMIN(){  
  
          if(!chekLevl2()) {
          System.out.println("Установленные роли: " + trueStatments());
          System.out.println("Вы действительно хотите изменить роль? 1- да; любое другое число - нет");
          if(Input.inputInt() == 1){
              PROVIDER = false;
              ADMIN = true;
              SUPER_ADMIN = false;
          }
          
        }
        else ADMIN = true;
  
  }
      public void setSUPER_ADMIN(){
  
          if(!chekLevl3()) {
              System.out.println("Установленные роли: " + trueStatments());
              System.out.println("Вы действительно хотите изменить роль? 1- да; любое другое число - нет");
              if(Input.inputInt() == 1){
                  PROVIDER = false;
                  ADMIN = false;
                  USER = false;
                  CUSTOMER = false;
                  SUPER_ADMIN = true;
                  
              }
              
          }
          else SUPER_ADMIN = true;
  
      }
  }
  