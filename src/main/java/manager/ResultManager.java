package manager;

import db.DBConnectionProvider;
import model.Poll;
import model.Result;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ResultManager {
    private Connection connection = DBConnectionProvider.getProvider().getConnection();
    private  PollManager pollManager = new PollManager();


    public List<Result> findAll() {
        String sql = "SELECT * FROM result";
        List<Result> results = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Result result = Result.builder()
                        .id(resultSet.getInt(1))
                        .explanation(resultSet.getString(2))
                        .MaxScore(resultSet.getInt(3))
                        .MinScore(resultSet.getInt(4))
                        .pollId(pollManager.findById(resultSet.getInt(5)))
                        .build();
                results.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
    public Result findById(int id) {
        String sql = "SELECT * FROM result WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Result.builder()
                        .id(resultSet.getInt(1))
                        .explanation(resultSet.getString(2))
                        .MaxScore(resultSet.getInt(3))
                        .MinScore(resultSet.getInt(4))
                        .pollId(pollManager.findById(resultSet.getInt(5)))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
