import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        WorkWithDB workWithDB = new WorkWithDB();
        workWithDB.connectDB.startDriver();
        workWithDB.addIntoDB(readFromScreen("Enter surname"),
                             readFromScreen("Enter name"),
                             readFromScreen("Enter phone number"));
        workWithDB.viewTable();
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
