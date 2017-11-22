import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Home_BudgetDao {

    private static final String URL = "jdbc:mysql://localhost:3306/home_budget?characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASS = "leksters";
    private Connection connection;

    public Home_BudgetDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Home_Budget home_budget) {
        final String sql = "insert into home_budget(type, description, amount, date_transaction) values(?, ?, ?, ?)";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, home_budget.getType());
            prepStmt.setString(2, home_budget.getDescription());
            prepStmt.setDouble(3, home_budget.getAmount());
            prepStmt.setDate(4, home_budget.getDate_transaction());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not save record");
            e.printStackTrace();
        }
    }

    public List<Home_Budget> allExpenses (Home_Budget home_budget) throws SQLException {
        List<Home_Budget> resultList = new ArrayList<>();
        final String sql2 = "select* from home_budget where type = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql2);
        preparedStatement.setString(1, home_budget.getType());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultList.add(new Home_Budget(resultSet.getLong("id"),resultSet.getString("type"), resultSet.getString("description"),
                    resultSet.getDouble("amount"), resultSet.getDate("date_transaction").toLocalDate()));
        }
        return resultList;
    }

    public List<Home_Budget> allExpensesByDate (Home_Budget home_budget, Home_Budget home_budget2) throws  SQLException {
        List<Home_Budget> resultList = new ArrayList<>();
        final String sgl3 = "select * from home_budget where date_transaction between ? and ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sgl3);
        preparedStatement.setDate(1, home_budget.getDate_transaction());
        preparedStatement.setDate(2, home_budget2.getDate_transaction());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultList.add(new Home_Budget(resultSet.getLong("id"),resultSet.getString("type"), resultSet.getString("description"),
                    resultSet.getDouble("amount"), resultSet.getDate("date_transaction").toLocalDate()));
        }
        return resultList;
    }

    public List<Home_Budget> allExpensesByAmount (Home_Budget home_budget) throws SQLException {
        List<Home_Budget> resultList = new ArrayList<>();
        final String sql4 = "select* from home_budget where type = ? and amount > ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql4);
        preparedStatement.setString(1, home_budget.getType());
        preparedStatement.setDouble(2, home_budget.getAmount());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            resultList.add(new Home_Budget(resultSet.getLong("id"),resultSet.getString("type"), resultSet.getString("description"),
                    resultSet.getDouble("amount"), resultSet.getDate("date_transaction").toLocalDate()));
        }
        return resultList;
    }
    public Home_Budget read(long id) {
        final String sql = "select id, type, description, amount, date_transaction from home_budget where id = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setLong(1, id);
            ResultSet result = prepStmt.executeQuery();
            if (result.next()) {
                Home_Budget home_budget = new Home_Budget();
                home_budget.setId(result.getLong("id"));
                home_budget.setType(result.getString("type"));
                home_budget.setDescription(result.getString("description"));
                home_budget.setAmount(result.getDouble("amount"));
                home_budget.setDate_transaction(result.getDate("date_transaction"));
                return home_budget;
            }
        } catch (SQLException e) {
            System.out.println("Could not get home budget");
        }
        return null;
    }



}
