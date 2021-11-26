package manager;

import db.DBConnectionProvider;
import lombok.RequiredArgsConstructor;
import model.Answer;
import model.Poll;
import repository.imp.AnswerIpm;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class AnswerManager {

    private Connection connection = DBConnectionProvider.getProvider().getConnection();
private QuestionManager questionManager = new QuestionManager();

    public List<Answer> findAll() {
        String sql = "SELECT * FROM answer";
        List<Answer> answers = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Answer answer = Answer.builder()
                        .id(resultSet.getInt(1))
                        .text(resultSet.getString(2))
                        .questionId(questionManager.findById(resultSet.getInt(3)))
                        .build();
                answers.add(answer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answers;
    }

    public Answer findById(int id) {
        String sql = "SELECT * FROM answer WHERE id=" + id;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return Answer.builder()
                        .id(resultSet.getInt(1))
                        .text(resultSet.getString(2))
                        .questionId(questionManager.findById(resultSet.getInt(3)) )
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}


