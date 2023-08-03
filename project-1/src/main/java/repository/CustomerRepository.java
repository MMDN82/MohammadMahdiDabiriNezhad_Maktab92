package repository;

import base.repository.BaseRepository;
import entity.Customer;

public interface CustomerRepository  extends BaseRepository<Customer,Long> {
    void validateMail(String mail);

}
