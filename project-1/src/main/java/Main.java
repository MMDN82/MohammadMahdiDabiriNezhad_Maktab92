import entity.Customer;
import entity.Expert;
import entity.Service;
import entity.Wallet;
import entity.enums.ExpertStatus;
import org.hibernate.Session;
import repository.*;
import repository.impl.*;
import service.CustomerService;
import service.ExpertService;
import service.ManagerService;
import service.ServiceService;
import service.impl.CustomerServiceImpl;
import service.impl.ExpertServiceImpl;
import service.impl.ManagerServiceImpl;
import service.impl.ServiceServiceImpl;
import util.HibernateUtil;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        Session session = HibernateUtil.getSessionfactory().openSession();
        ManagerRepository managerRepository = new ManagerRepositoryImpl(session);
        ManagerService managerService = new ManagerServiceImpl(managerRepository);
        SubServiceRepository subServiceRepository = new SubServiceRepositoryImpl(session);
        ExpertRepository expertRepository = new ExpertRepositoryImpl(session);
        ServiceRepository serviceRepository = new ServiceRepositoryImpl(session);
        ServiceService serviceService = new ServiceServiceImpl(serviceRepository);
        ExpertRepository expertRepository1 = new ExpertRepositoryImpl(session);
        ExpertService expertService = new ExpertServiceImpl(expertRepository1);
        CustomerRepository customerRepository = new CustomerRepositoryImpl(session);
        CustomerService customerService = new CustomerServiceImpl(customerRepository);


    }
}
