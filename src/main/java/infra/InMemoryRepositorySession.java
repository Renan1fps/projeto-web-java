package infra;

import java.util.ArrayList;
import java.util.List;

import domain.Session;
import protocols.Repository;

public class InMemoryRepositorySession implements Repository<Session> {

	private static InMemoryRepositorySession instance;

	private List<Session> sessionList = new ArrayList<>();

	private InMemoryRepositorySession() {

	}

	public static InMemoryRepositorySession getInstance() {
		if (instance == null) {
			instance = new InMemoryRepositorySession();
		}
		return instance;
	}

	@Override
	public Session save(Session data) {
		sessionList.add(data);
		return data;
	}

	@Override
	public Session getById(String id) {
		for (Session session : sessionList) {
			if (session.getId().equals(id)) {
				return session;
			}
		}
		return null;
	}

	@Override
	public void delete(String id) {
		for (Session session : sessionList) {
			if (session.getId().equals(id)) {
				sessionList.remove(session);
				break;
			}
		}
	}

	@Override
	public Session updateById(String id, Session data) {
		for (Session session : sessionList) {
			if (session.getId().equals(id)) {
				sessionList.remove(session);
				sessionList.add(data);
				return data;
			}
		}
		return null;
	}

	@Override
	public List<Session> fidAll() {
		return sessionList;
	}

}