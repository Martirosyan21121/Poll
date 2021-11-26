package manager;

import db.DBConnectionProvider;
import model.Poll;
import model.Question;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

public class QuestionManager {

    private Connection connection = DBConnectionProvider.getProvider().getConnection();
private  PollManager pollManager = new PollManager();

    public List<Question> findAll() {
        String sql = "SELECT * FROM question";
        List<Question> questions = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Question question = Question.builder()
                        .id(resultSet.getInt(1))
                        .text(resultSet.getString(2))
                        .pollId(pollManager.findById(resultSet.getInt(3)))
                        .build();
                questions.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    public Question findById(int id) {
        String sql = "SELECT * FROM question WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Question.builder()
                        .id(resultSet.getInt(1))
                        .text(resultSet.getString(2))
                        .pollId(pollManager.findById(resultSet.getInt(3)))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
