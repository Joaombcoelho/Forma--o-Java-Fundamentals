package board;

import java.io.IOException;
import java.sql.SQLException;

import static board.br.com.dio.persistence.config.ConnectionConfig.getConnection;
import board.br.com.dio.persistence.migration.MigrationStrategy;

public class App {
    public static void main(String[] args) throws SQLException, IOException {
        try(var connection = getConnection()){
            new MigrationStrategy(connection).executeMigration();
        }
     }
}

    
