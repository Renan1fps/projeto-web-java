package infra;

import java.util.ArrayList;
import java.util.List;

import domain.Service;
import protocols.Repository;

public class InMemoryRepositoryService implements Repository<Service> {
	
    private static InMemoryRepositoryService instance;

    private List<Service> serviceList = new ArrayList<>();

    private InMemoryRepositoryService() {
    	  this.initializeServiceList();
    }

    public static InMemoryRepositoryService getInstance() {
        if (instance == null) {
            instance = new InMemoryRepositoryService();
        }
        return instance;
    }

    @Override
    public Service save(Service data) {
        serviceList.add(data);
        return data;
    }

    @Override
    public Service getById(String id) {
        for (Service service : serviceList) {
            if (service.getId().equals(id)) {
                return service;
            }
        }
        return null;
    }

    @Override
    public void delete(String id) {
        for (Service service : serviceList) {
            if (service.getId().equals(id)) {
                serviceList.remove(service);
                break;
            }
        }
    }

    @Override
    public Service updateById(String id, Service data) {
        for (Service service : serviceList) {
            if (service.getId().equals(id)) {
                serviceList.remove(service);
                serviceList.add(data);
                return data;
            }
        }
        return null;
    }

    @Override
    public List<Service> fidAll() {
        return serviceList;
    }
    
    private void initializeServiceList() {
        serviceList.add(new Service("1", "Serviço 1", "Corte de cabelo", 50.00));
        serviceList.add(new Service("2", "Serviço 2", "Corte de cabelo com barba",80.00));
        serviceList.add(new Service("2", "Serviço 2", "Manicure e pedicure", 65.00));
    }
}
