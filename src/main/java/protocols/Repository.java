package protocols;

import java.util.List;

public interface Repository<T> {
	
	T save(T data);
	T getById(String id);
	void delete(String id);
	T updateById(String id, T data);
	List<T> fidAll();

}
