import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Application {  //Class Application with main method

    public static void main(String[] args){
        Date currentDate = new Date();
        List<User> list = new ArrayList<>();    //List of users

        list.add(new User("Walker", "Tom", 19, "walker.tom@icloud.com", "NEW", "03/10/2020 13:13:13"));
        list.add(new User("Wilson", "Kate", 25, "kate_will@gmail.com", "INACTIVE", "01/05/2018 13:13:13"));
        list.add(new User("Lewis", "Thomas", 23, "tHoMaS12@gmai.com", "ACTIVE", "27/09/2020 13:13:13"));
        list.add(new User("King", "John", 45, "KING_JOHN1975@gmail.com", "INACTIVE", "02/05/2018 13:13:13"));
        list.add(new User("Harris", "Jessica", 18, "Harris_Jess@icloud.com", "NEW", "30/09/2020 13:13:13"));
        list.add(new User("Smith", "Angela", 24, "smith.angela1010@gmail.com", "NEW", "03/10/2020 19:15:19"));
        list.add(new User("Jones", "Andrew", 34, "andrewJones@icloud.com", "INACTIVE", "02/07/2020 14:34:07"));
        list.add(new User("Brown", "Alex" , 22, "Brown1998_04_10@gmail.com", "INACTIVE", "30/09/2020 15:34:57"));
        list.add(new User("Evans", "Mary", 60, "evans.mary1960@gmail.com", "NEW", "04/10/2020 17:02:23"));

        // Switch
        int command;
        do{
            Scanner scanner = new Scanner(System.in);  //Menu
            System.out.println("1 - List of users without change.");
            System.out.println("2 - Change status to ACTIVE for NEW users\n" +
                    "whose timestamp when they were registered in the system is older than yesterday.");
            System.out.println("3 -  Pick up INACTIVE users that where registered more than 1 month ago and set their status to BLOCKED.");
            System.out.println("0 - Stop compilation\n");
            System.out.print("Command = ");
            command = scanner.nextInt();
            System.out.println();
            switch (command){
                case 1:
                    System.out.println(list + "\n");  //List of users
                    break;
                case 2:
                    for (User user : list){
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); //Date format
                        Date date = null;

                        try {
                            date = sdf.parse(user.getTimeStamp()); //From String to Date

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        long difference = currentDate.getTime() - date.getTime(); //How much time has passed from the last registration
                        int hours = (int)(difference / (60 * 60 * 1000));

                        if ((hours > 24) && (user.getStatus().equals("NEW"))){ //Change status to ACTIVE for NEW
                            user.setStatus("ACTIVE");
                        }
                    }
                    System.out.println(list + "\n");
                    break;
                case 3:
                    for (User user : list){
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");  //Date format
                        Date date = null;

                        try {
                            date = sdf.parse(user.getTimeStamp());//From String to Date

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                        long difference = currentDate.getTime() - date.getTime();  //How much time has passed from the last registration
                        int weeks = (int)(difference / (7 * 24 * 60 * 60 * 1000));

                        if ((weeks >= 4) && (user.getStatus().equals("INACTIVE"))){ //Change status to BLOCKED for INACTIVE
                            user.setStatus("BLOCKED");
                        }
                        if (user.getStatus().equals("BLOCKED")){  //Pick up users with status BLOCKED
                            System.out.println(user);
                        }
                    }
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Error.");
            }
        }while(command != 0);

    }

}
