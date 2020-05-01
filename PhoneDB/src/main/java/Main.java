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
                    "2 - find a user by full surname \n" +
                    "3 - find a user by name \n" +
                    "4 - find a user by phone number \n" +
                    "5 - delete from database by id \n" +
                    "6 - delete from database by phone number \n" +
                    "7 - rename a user \n" +
                    "8 - view all users\n" +
                    "9 - exit the program");

            int operation = Integer.parseInt(reader.readLine());

            switch (operation) {
                case 1: workWithDB.addIntoDB(readFromScreen("Enter surname"),
                             readFromScreen("Enter name"),
                             readFromScreen("Enter phone number"));
                    break;

                case 5: workWithDB.deleteFromDBbyID(readFromScreen("Enter id which you want to delete"));
                    break;
                case 6 : workWithDB.deleteFromDBbyPhoneNumber(readFromScreen("Enter phone number which you want to delete"));
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
