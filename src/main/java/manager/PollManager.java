package manager;

import db.DBConnectionProvider;
import model.Poll;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PollManager {

    private Connection connection = DBConnectionProvider.getProvider().getConnection();


    public List<Poll> findAll() {
        String sql = "SELECT * FROM poll";
        List<Poll> polls = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Poll poll = Poll.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .build();
                polls.add(poll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return polls;
    }

    public Poll findById(int id) {
        String sql = "SELECT * FROM poll WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Poll.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
