package example.mocking.persistence;

import java.util.List;


public class PersistenceService {

    private final EntityManager entityManager;

    public PersistenceService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void persist(List<MyEntity> entities) {
        entities.forEach(entityManager::persist);
    }

}
