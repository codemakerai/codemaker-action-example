package ai.codemaker.demo.dao;

public interface CrudDao<T> {

    void save(T entity);

    void update(T entity);
}
