package service;

import base.service.BaseService;
import entity.Customer;
import entity.Expert;
import entity.SubService;
import exceptions.ExpertException;
import exceptions.PasswordException;

import java.util.HashSet;
import java.util.List;

public interface ExpertService extends BaseService<Expert,Long> {
    void validatePassword(String password) throws PasswordException;
    void changePassword(String password, Expert expert);
    void signUp(String firstname , String lastname , String mail , String password);
    List<SubService> showSubServices(Expert expert) throws ExpertException;
    List<Expert> findAll();
}
