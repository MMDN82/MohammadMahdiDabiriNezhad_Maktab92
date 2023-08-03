package service;

import base.service.BaseService;
import entity.Customer;
import entity.Service;
import entity.SubService;
import exceptions.PasswordException;

import java.util.HashSet;
import java.util.List;

public interface CustomerService extends BaseService<Customer,Long> {
    void signUp(String firstname , String lastname , String mail , String password);
    void validatePassword(String password) throws PasswordException;
    void changePassword(String password, Customer customer);
    List<Service> showService();
    List<SubService> searchByService(Service service);
}
