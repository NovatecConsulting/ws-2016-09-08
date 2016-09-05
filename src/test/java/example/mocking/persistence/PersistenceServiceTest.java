package example.mocking.persistence;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;


public class PersistenceServiceTest { // ~Stub

    long idCounter = 0;

    EntityManager entityManager;
    PersistenceService cut;

    @Before
    public void setUp() {
        entityManager = mock(EntityManager.class);
        cut = new PersistenceService(entityManager);
        doAnswer(this::simulateEntityPersist).when(entityManager).persist(any(MyEntity.class));
    }

    Void simulateEntityPersist(InvocationOnMock invocation) {
        invocation.getArgumentAt(0, MyEntity.class).setId(idCounter++);
        return null;
    }

    @Test
    public void multipleEntitiesArePersisted() {

        MyEntity entity1 = new MyEntity("foo");
        MyEntity entity2 = new MyEntity("bar");
        MyEntity entity3 = new MyEntity("xur");

        cut.persist(asList(entity1, entity2, entity3));

        assertThat(entity1.getId()).isEqualTo(0);
        assertThat(entity2.getId()).isEqualTo(1);
        assertThat(entity3.getId()).isEqualTo(2);

    }

}
