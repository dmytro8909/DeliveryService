package dao;

import java.util.List;

public interface AbstractDAO {
	<T> List<T> getAll();
	<T> T get(int id);
	<T> T update(T t);
	<T> T delete(T t);
}
