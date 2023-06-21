package repository;

import base.repository.BaseRepository;
import entity.Issue;

import java.util.List;

public interface IssueRepository extends BaseRepository<Issue,Long> {
    String IssueByBookId(Long id);
    List<String> showIssue();
}
