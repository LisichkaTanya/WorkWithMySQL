import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        WorkWithDB workWithDB = new WorkWithDB();
        workWithDB.connectDB.startDriver();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String exit = "no";
        while (exit.equals("no")) {
            System.out.println("Choose the operation. Enter the appropriate number: \n" +
                    "1 - add new user \n" +
                    "2 - find a user by surname \n" +
                    "3 - find a user by name \n" +
                    "4 - find a user by phone number \n" +
                    "5 - delete from database \n" +
                    "6 -  \n" +
                    "7 -  \n" +
                    "8 - view all users\n" +
                    "9 - exit the program");

            int operation = Integer.parseInt(reader.readLine());

            switch (operation) {
                case 1: workWithDB.addIntoDB(readFromScreen("Enter surname"),
                             readFromScreen("Enter name"),
                             readFromScreen("Enter phone number"));
                    break;
                case 2: workWithDB.findBySurname(readFromScreen("Enter surname which you want to find"));
                    break;
                case 3: workWithDB.findBySurname(readFromScreen("Enter name which you want to find"));
                    break;
                case 4: workWithDB.findBySurname(readFromScreen("Enter phone number which you want to find"));
                    break;
                case 5: String param = readFromScreen("Enter the parameter that we will look for to delete ('id', 'name', 'surname' or 'phone number')");
                    if (param.equals("id")){
                        workWithDB.findByID(readFromScreen("Enter id which you want to find"));
                    } else if (param.equals("name")){
                        workWithDB.findByName(readFromScreen("Enter name which you want to find"));
                    }else if (param.equals("surname")){
                        workWithDB.findBySurname(readFromScreen("Enter surname which you want to find"));
                    }else if (param.equals("phone number")){
                        workWithDB.deleteFromDBbyPhoneNumber(readFromScreen("Enter phone number which you want to find"));
                    }
                    workWithDB.deleteFromDB(readFromScreen("Enter <id> to delete the line from database"));
                    break;

                case 8: workWithDB.viewTable();
                    break;
                case 9: exit = "yes";
                    break;
            }
        }
    }

    /**
     * This method to communicate via the screen
     * @param input - String which tell to user what he need to do
     * @return - will return string what was reading from screen
     */
    public static String readFromScreen (String input) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(input);
        String read = scanner.nextLine();
        return read;
    }
}
