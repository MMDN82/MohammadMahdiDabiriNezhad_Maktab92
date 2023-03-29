package repository;

import entity.Author;
import service.AuthorService;
import sql.DatabaseConnection;

import java.sql.Connection;

public class AuthorRepository implements BaseRepository{

    private Connection connection;

    public AuthorRepository() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        this.connection = databaseConnection.getConnection();
    }

    @Override
    public void save(Object object) {

        Author author = (Author) object;
        StringBuilder query = new StringBuilder( "INSERT INTO author(id,first_name,last_name)" +
                "VALUES(" );
        query
                .append(author.getId())
                .append(" ,")
                .append(author.getFirstName())
                .append(" ,")
                .append(author.getLastName())
                .append(")");
        try {
            this.sta
        }
    }

    @Override
    public Object load(int id) {
        return null;
    }
}
