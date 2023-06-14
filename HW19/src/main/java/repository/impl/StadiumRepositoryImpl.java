package repository.impl;

import Base.repository.impl.BaseRepositoryImpl;
import entity.Stadium;
import org.hibernate.Session;
import repository.StadiumRepository;

public class StadiumRepositoryImpl extends BaseRepositoryImpl<Stadium,Long> implements StadiumRepository {
    public StadiumRepositoryImpl(Session session) {
        super(session);
    }

    @Override
    public Class<Stadium> getEntityClass() {
        return Stadium.class;
    }
}
