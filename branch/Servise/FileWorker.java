package branch.Servise;

import java.io.*;
import java.util.*;
import java.util.Scanner;
public class FileWorker {
        private String fileName;

        public FileWorker(String fileName){

            this.fileName = fileName;

        }

        public StringBuilder read() throws IOException{

            StringBuilder text = new StringBuilder();

            try (Scanner scanner = new Scanner(new File(fileName))) {
            
                while (scanner.hasNextLine()){
                text.append( scanner.nextLine());
                text.append("\n");
                }
            
            } 
            return text;

        }

        public List<String> readToList() throws IOException{

            List<String> text = new ArrayList<String>();

            StringTokenizer st = new StringTokenizer(read().toString(), "\n");
            String resultstring = new String();
            
            while(st.hasMoreTokens()) {

                resultstring = st.nextToken();
                text.add(resultstring);
                
            }

            return text;
            
        }

        public void writer(String str) throws IOException{
                try(FileWriter writer = new FileWriter(fileName, true))
            {
                writer.write(str);
            }
            

        }

        public void clean(){
            
        try {
            FileWriter fstream1 = new FileWriter(fileName);// конструктор с одним параметром - для перезаписи
            BufferedWriter out1 = new BufferedWriter(fstream1); //  создаём буферезированный поток
            out1.write(""); // очищаем, перезаписав поверх пустую строку
            out1.close(); // закрываем
         } catch (Exception e) 
            {System.err.println("Error in file cleaning: " + e.getMessage());}

        }
        public static void main(String args[]) {}
     
}