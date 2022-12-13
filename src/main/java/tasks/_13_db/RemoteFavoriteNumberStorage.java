package tasks._13_db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Optional;

public class RemoteFavoriteNumberStorage {
    private final Connection connection;

    public RemoteFavoriteNumberStorage(String username, String password) throws IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost/numbers", username, password);

            execute("CREATE TABLE IF NOT EXISTS `numbers` (`number` INT UNIQUE);");
        } catch(Exception exception) {
            throw new IOException(exception);
        }
    }

    private Optional<ResultSet> execute(String sql) {
        Objects.requireNonNull(sql, "SQL statement is required for RemoteFavoriteNumberStorage.execute(sql != null) -> ResultSet?");

        try {
            var statement = connection.createStatement();

            if(statement.execute(sql)) {
                return Optional.of(statement.getResultSet());
            } else {
                return Optional.empty();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(int number) {
        execute("INSERT IGNORE INTO `numbers` VALUES (%d);".formatted(number));
    }

    public boolean has(int number) {
        var resultOptional = execute("SELECT COUNT(*) as `number_count` FROM `numbers` WHERE `number` = %d;".formatted(number));

        if(resultOptional.isPresent()) {
            try {
                var result = resultOptional.get();
                result.next();
                return result.getInt("number_count") != 0;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("No value returned.");
        }
    }
}
