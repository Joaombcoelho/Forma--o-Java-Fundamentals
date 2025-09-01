package board.br.com.dio.persistence.migration;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.SQLException;

import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;



public class MigrationStrategy {

    private final Connection connection;

    public MigrationStrategy(Connection connection) {
        this.connection = connection;
    }

    private Connection getConnection() {
        return this.connection;
    }

    public void executeMigration() throws IOException, SQLException{
        var originalOut = System.out;
        var originalErr = System.err;
        try (var fos = new FileOutputStream("liquibase.log")) {
            System.setOut(new PrintStream(fos));
            System.setErr(new PrintStream(fos));
            try(
                var conn = getConnection();
                var jdbcConnection = new JdbcConnection(conn);
            ){
                var liquibase = new Liquibase(
                    "db/changelog/db.changelog-master.xml",
                    new ClassLoaderResourceAccessor(),
                    jdbcConnection);
                liquibase.update(); 
            } catch (LiquibaseException e) {
                System.setErr(originalErr);
            }
        } catch (IOException ex) {
        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
    }

    public void executeMigrations() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}