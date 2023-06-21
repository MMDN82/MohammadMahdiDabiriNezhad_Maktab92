package repository;

import base.repository.BaseRepository;
import entity.Member;

import java.util.Optional;

public interface MemberRepository extends BaseRepository<Member,Long> {
    String SignUp(Member member);
}
