package infra;

import java.util.ArrayList;
import java.util.List;

import domain.Service;
import protocols.Repository;

public class InMemoryRepositoryService implements Repository<Service> {
	
	private List<Service> serviceList = new ArrayList<Service>();

	@Override
	public Service save(Service data) {
		serviceList.add(data);
		return data;
	}

	@Override
	public Service getById(String id) {
		for(Service service: serviceList) {
			if(service.getId().equals(id)) {
				return service;
			}
		}
		return null;
	}

	@Override
	public void delete(String id) {
		for(Service service: serviceList) {
			if(service.getId().equals(id)) {
				serviceList.remove(service);
			}
		}
		
	}

	@Override
	public Service updateById(String id, Service data) {
		for(Service service: serviceList) {
			if(service.getId().equals(id)) {
				serviceList.remove(service);
				serviceList.add(data);
			}
		}
		
		return data;
	}

	@Override
	public List<Service> fidAllById() {
		return serviceList;
	}

}
