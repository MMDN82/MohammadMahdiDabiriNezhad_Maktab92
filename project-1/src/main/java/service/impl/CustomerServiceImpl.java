package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Customer;
import entity.Service;
import entity.SubService;
import exceptions.MailException;
import exceptions.PasswordException;
import org.hibernate.Session;
import repository.CustomerRepository;
import repository.ExpertRepository;
import repository.ServiceRepository;
import repository.SubServiceRepository;
import repository.impl.CustomerRepositoryImpl;
import repository.impl.ExpertRepositoryImpl;
import repository.impl.ServiceRepositoryImpl;
import repository.impl.SubServiceRepositoryImpl;
import service.CustomerService;
import service.ExpertService;
import service.ServiceService;
import service.SubServiceService;
import util.HibernateUtil;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

public class CustomerServiceImpl extends BaseServiceImpl<Customer,Long,CustomerRepository>
        implements CustomerService {
    private CustomerRepository customerRepository ;
    private Session session = HibernateUtil.getSessionfactory().openSession();
    private ServiceRepository serviceRepository = new ServiceRepositoryImpl(session);
    private ServiceService serviceService = new ServiceServiceImpl(serviceRepository);
    private SubServiceRepository subServiceRepository = new SubServiceRepositoryImpl(session);
    private SubServiceService subServiceService = new SubServiceServiceImpl(subServiceRepository);
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        super(customerRepository);
        this.customerRepository=customerRepository;
    }

    @Override
    public void signUp(String firstname, String lastname, String mail, String password) {
        try {
           customerRepository.validateMail(mail);
            try{
                Customer customer = new Customer();
                validatePassword(password);
                customer.setDateOfJoin(LocalDate.now());
                customer.setFirstName(firstname);
                customer.setLastName(lastname);
                customer.setMail(mail);
                customerRepository.save(customer);
            }catch (PasswordException e){
                System.out.println(e.getMessage());
            }
        }catch (MailException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void validatePassword(String password) throws PasswordException {
        if (password.length() < 8) {
            throw new PasswordException("Password length is less than 8");
        }
        boolean upperCheck = false;
        boolean lowerCheck = false;
        boolean digitCheck = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCheck = true;
            }
            if (Character.isLowerCase(c)) {
                lowerCheck = true;
            }
            if (Character.isDigit(c)) {
                digitCheck = true;
            }
        }

        if (!upperCheck) {
            throw new PasswordException("There must be an uppercase character");
        }

        if (!lowerCheck) {
            throw new PasswordException("There must be a lowercase character");
        }

        if (!digitCheck) {
            throw new PasswordException("There must a be a digit");
        }
        System.out.println("Valid password.");
    }

    @Override
    public void changePassword(String password,Customer customer) {
        try {
            validatePassword(password);
            customer.setPassword(password);
            customerRepository.update(customer);
        }catch (PasswordException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Service> showService() {
        return serviceService.showServices() ;
    }

    @Override
    public List<SubService> searchByService(Service service) {
        return subServiceService.searchByService(service);
    }
}
