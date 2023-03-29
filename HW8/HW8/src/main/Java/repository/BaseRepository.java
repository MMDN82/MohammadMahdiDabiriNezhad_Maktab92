package repository;

public interface BaseRepository {
    void save(Object object);
    Object load(int id);
}
