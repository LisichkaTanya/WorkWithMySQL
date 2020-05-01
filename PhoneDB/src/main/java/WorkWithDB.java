import java.sql.*;

public class WorkWithDB {
    ConnectDB connectDB = new ConnectDB();

    /**     case 1:
     * This method add new user into database
     * @param surname - this parameter corresponds to cell 2 "surname" in the database
     * @param name - this parameter corresponds to cell 3 "name" in the database
     * @param phone - this parameter corresponds to cell 4 "phone number" in the database
     */
    public void addIntoDB(String surname, String name, String phone){
        String INSERT_NEW = "insert into phonenumbers (surname, name, phonenumber) values (?,?,?)";
        try {
            PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(INSERT_NEW);
            preparedStatement.setString(1,surname);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,phone);
            preparedStatement.execute();
            System.out.println("User: " + surname + " " + name + "was add");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**     case 2:
     * This method will find all users in database by surname
     * @param findSurname
     */
    public void findBySurname(String findSurname){
        String FIND = "select * from phonenumbers where surname=?";
        try {
            PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(FIND);
            preparedStatement.setString(1,findSurname);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setSurname(resultSet.getString("surname"));
                user.setName(resultSet.getString("name"));
                user.setPhoneNumber(resultSet.getString("phonenumber"));
                System.out.println(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**     case 3:
     * This method will find all users in database by surname
     * @param findName
     */
    public void findByName(String findName){
        String FIND = "select * from phonenumbers where name=?";
        try {
            PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(FIND);
            preparedStatement.setString(1,findName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setSurname(resultSet.getString("surname"));
                user.setName(resultSet.getString("name"));
                user.setPhoneNumber(resultSet.getString("phonenumber"));
                System.out.println(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**     case 4:
     * This method will find all users in database by phone number
     * @param findPhone - phone number which we will find
     */
    public void findByPhone(String findPhone){
        String FIND = "select * from phonenumbers where phonenumber=?";
        try {
            PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(FIND);
            preparedStatement.setString(1,findPhone);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setSurname(resultSet.getString("surname"));
                user.setName(resultSet.getString("name"));
                user.setPhoneNumber(resultSet.getString("phonenumber"));
                System.out.println(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void findByID(String findID){
        String FIND = "select * from phonenumbers where id=?";
        try {
            PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(FIND);
            preparedStatement.setString(1,findID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setSurname(resultSet.getString("surname"));
                user.setName(resultSet.getString("name"));
                user.setPhoneNumber(resultSet.getString("phonenumber"));
                System.out.println(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**     case 5:
     * At first enter the parameter that we will look for to delete
     *
     * This method will delete that line in table which ID will be specified in the parameter
     * @param param - - this parameter specifies which line to delete
     */
    public void deleteFromDB(String param){
        String DELETE = "delete from phonenumbers where id=?";
        try {
            PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(DELETE);
            preparedStatement.setString(1,param);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    /**     case 8:
     * This method show all table
     */
    public void viewTable (){
        try {
            Statement statement = connectDB.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select * from phonenumbers");
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setSurname(resultSet.getString("surname"));
                user.setName(resultSet.getString("name"));
                user.setPhoneNumber(resultSet.getString("phonenumber"));

                System.out.println(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
