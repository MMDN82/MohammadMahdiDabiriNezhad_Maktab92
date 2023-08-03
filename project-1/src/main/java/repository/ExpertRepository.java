package repository;

import base.repository.BaseRepository;
import entity.Expert;
import entity.SubService;
import exceptions.ExpertException;

import java.util.HashSet;

public interface ExpertRepository extends BaseRepository<Expert,Long> {
    void validateMail(String mail);
}
