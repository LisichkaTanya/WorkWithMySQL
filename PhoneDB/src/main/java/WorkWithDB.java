import java.sql.*;

public class WorkWithDB {
    ConnectDB connectDB = new ConnectDB();

    public void addIntoDB(String surname, String name, String phone){
        String INSERT_NEW = "insert into phonenumbers (surname, name, phonenumber) values (?,?,?)";
        try {
            PreparedStatement preparedStatement = connectDB.getConnection().prepareStatement(INSERT_NEW);
            preparedStatement.setString(1,surname);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,phone);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


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
