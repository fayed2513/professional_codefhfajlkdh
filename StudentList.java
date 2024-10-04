import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        if(args==null || args.length!=1){
            System.out.println(Constants.Wrong_Argument);
            return;
        }
//		Check arguments
        String readLine = fileReader("students.txt");
        if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try {
                String Students[] = readLine.split(",");
                for (String j : Students) {
                    System.out.println(j);
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try {
                String i[] = readLine.split(",");
                Random x = new Random();
                int y = x.nextInt(i.length);
                System.out.println(i[y].trim());
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter s = new BufferedWriter(
                                   new FileWriter("students.txt", true));
                String t = args[0].substring(1);
                Date d = new Date();
                String df = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(df);
                String fd = dateFormat.format(d);
                s.write(", " + t + "\nList last updated on " + fd);
                s.close();
            } catch (Exception e) {
            }

            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                String i[] = readLine.split(",");
                boolean done = false;
                String t = args[0].substring(1);
                for (int idx = 0; idx < i.length && !done; idx++) {
                    if (i[idx].trim().equals(t)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("c")) {
            System.out.println("Loading data ...");
            try {
                char charArray[] = readLine.toCharArray();
                boolean in_word = false;
                int count = 0;
                for (char element : charArray) {
                    if (element== ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found ");
            } catch (Exception e) {
            }
            System.out.println("Data Loaded.");
        }
        else{
            System.out.println("Wrong Argument");
        }
    }
    public static String fileReader(String fileName){
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("students.txt")));
            return bufferedReader.readLine();
        }
        catch (Exception e){
            return null;
        }
    }
}
