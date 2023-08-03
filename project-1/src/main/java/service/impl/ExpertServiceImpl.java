package service.impl;

import base.repository.impl.BaseRepositoryImpl;
import base.service.impl.BaseServiceImpl;
import entity.Expert;
import entity.SubService;
import entity.enums.ExpertStatus;
import exceptions.ExpertException;
import exceptions.MailException;
import exceptions.PasswordException;
import org.hibernate.Session;
import repository.ExpertRepository;
import repository.impl.ExpertRepositoryImpl;
import service.ExpertService;
import util.HibernateUtil;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class ExpertServiceImpl extends BaseServiceImpl<Expert,Long,ExpertRepository>
        implements ExpertService {
    private ExpertRepository expertRepository;

    public ExpertServiceImpl(ExpertRepository expertRepository) {
        super(expertRepository);
        this.expertRepository=expertRepository;

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
    public void changePassword(String password, Expert expert) {
        try {
            validatePassword(password);
            expert.setPassword(password);
            expertRepository.update(expert);
        }catch (PasswordException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void signUp(String firstname, String lastname, String mail, String password) {
        try {
            expertRepository.validateMail(mail);
            try{
                Expert expert = new Expert();
                validatePassword(password);
                expert.setDateOfJoin(LocalDate.now());
                expert.setFirstName(firstname);
                expert.setLastName(lastname);
                expert.setMail(mail);
                expert.setExpertStatus(ExpertStatus.WAITING_FOR_ACCEPT);
                expertRepository.save(expert);
            }catch (PasswordException e){
                System.out.println(e.getMessage());
            }
        }catch (MailException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public List<SubService> showSubServices(Expert expert) throws ExpertException {
        Optional<Expert> expert1 = expertRepository.findById(expert.getId());
        List<SubService> ans=new ArrayList<>();
        if (expert1.isPresent()){
            ans.addAll(expert1.get().getSubServices());
        }else {
            throw new ExpertException("expert not found");
        }
        return ans;
    }

    @Override
    public List<Expert> findAll() {
        List<Expert> experts = new ArrayList<>(expertRepository.findAll()) ;
        return experts;
    }
}
