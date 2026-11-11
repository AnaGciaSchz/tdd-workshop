package org.kata.tennis.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MatchRepository {

    private static final String CREATE_TABLE =
            "CREATE TABLE IF NOT EXISTS match (" +
            "id SERIAL PRIMARY KEY, " +
            "player1 VARCHAR(50) NOT NULL, " +
            "player2 VARCHAR(50) NOT NULL, " +
            "result VARCHAR(50) NOT NULL)";
    private static final String INSERT = "INSERT INTO match (player1, player2, result) VALUES (?, ?, ?)";
    private static final String COUNT = "SELECT COUNT(*) FROM match";
    private static final int PLAYER_ONE_PARAMETER = 1;
    private static final int PLAYER_TWO_PARAMETER = 2;
    private static final int RESULT_PARAMETER = 3;
    private static final int COUNT_COLUMN = 1;

    private final String url;
    private final String user;
    private final String password;

    public MatchRepository(String url, String user, String password) throws SQLException {
        this.url = url;
        this.user = user;
        this.password = password;
        createTable();
    }

    public void save(String player1, String player2, String result) throws SQLException {
        try (Connection connection = connect(); PreparedStatement statement = connection.prepareStatement(INSERT)) {
            statement.setString(PLAYER_ONE_PARAMETER, player1);
            statement.setString(PLAYER_TWO_PARAMETER, player2);
            statement.setString(RESULT_PARAMETER, result);
            statement.executeUpdate();
        }
    }

    public long count() throws SQLException {
        try (Connection connection = connect();
             Statement statement = connection.createStatement();
             ResultSet rows = statement.executeQuery(COUNT)) {
            rows.next();
            return rows.getLong(COUNT_COLUMN);
        }
    }

    private void createTable() throws SQLException {
        try (Connection connection = connect(); Statement statement = connection.createStatement()) {
            statement.execute(CREATE_TABLE);
        }
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
