package service.impl;

import base.service.impl.BaseServiceImpl;
import entity.Issue;
import org.hibernate.Session;
import repository.IssueRepository;
import service.IssueService;

public class IssueServiceImpl extends BaseServiceImpl<Issue,Long> implements IssueService {
    public IssueServiceImpl(Session session) {
        super(session);
    }

    @Override
    public Class<Issue> getEntityClass() {
        return Issue.class;
    }
}
