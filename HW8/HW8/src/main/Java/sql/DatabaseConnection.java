package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection;
    public Connection getConnection(){
        try{
            this.connection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/library",
                            "postgres",
                            "12345");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }


}
