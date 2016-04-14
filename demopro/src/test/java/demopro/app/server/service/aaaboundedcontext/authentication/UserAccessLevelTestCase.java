package demopro.app.server.service.aaaboundedcontext.authentication;
import demopro.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import demopro.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import demopro.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import demopro.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
    }

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("4rEo2jYvSKnfGzaPQsbvB1iKc5hkGgqzDdB2dirRoii1puuXnh");
        useraccesslevel.setLevelDescription("JvI5t6U7zzU3VjWf0QcxWPUFYmaWsJAOWSjG1jbSs7q7Nv8Eeo");
        useraccesslevel.setLevelIcon("y6XZ1v6IMZ4Iu9wzOgw9Pokj2c6DBktXXnrwrSUY8HikdcT1PS");
        useraccesslevel.setLevelName("rQCN7FvUzNACxK8eqw2sOLDMe166mRzLiQqkkuKZo3bxRwoiKH");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setLevelHelp("qB1pUY4AQta3pHXnZxHh0jlMqpyxMHci9YstXpzz1QFPMXjqtX");
            useraccesslevel.setLevelDescription("bhypZrJBmHBJ0PphJ0pSjelCxW8fJOqfXwjDWLsHe4aO6C1f3k");
            useraccesslevel.setLevelIcon("i5EM2rrR8DDj3DFD2SrFLjXvEqrj5czcTA7tu8EDS9Vb8CufWf");
            useraccesslevel.setLevelName("8heJ9s4sQ1kOXnCKbzzZWiiwO3CkGOirT1fjnNLpb6s1zIkySa");
            useraccesslevel.setUserAccessLevel(67702);
            useraccesslevel.setVersionId(1);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 179113));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "pJELlYmeXjRXF6NHwY7BGpyK9XAoOoWGhuf1LzzC7rXbAW965kVVaJwQuIjpnhJ40kpMujAwnMECTBpNug7WvoKOFXArcfGd8m39Hq8ft9w1nptPO1LZy8s2rxcf4a81moJtppjWki9JWcEuD8PWPE6TvAfegZlcjyBj96TNhMdUhMEQUOEwrPQ7NoYFh2HgT5fFEVxiU48BS3qhbv5QK9RkvKaTU8XvpmvxaERtvzLdM2qKL2mYnKOFz8xSC028L"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "nFcFf6HMMkMN3EHWg08Nw5oGpe9oe8FN0EuCymCV3mDX4R8R0SBRJeVfer6eGLuDLrFZHxWQfhf1IEg57Z3Uqo0ZlWCVLZQBzGtqlWQRBmaYZtR4FGInDPcN5IqnL5pnzpBcOkwG28FhBGfMZUg3ynTn8aWpkE0xBg6nSzyVxBdfwQ1fse1drvFvY4PhIG91vVnIiRnlCUBzch1lnU9iNKxJRV2G5nw1eAcbQ33TSDnk3WvNdeSJyQv2fauI1Amha"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "MtZrpDcN5GANtLjdLEaEpcCnyiW8dorteGrXWKRBnxvHf8G1robBchgQXXlVjF6C9x9CZayZoE4pGqoJ5FJcWD5ud1OvSJlA7xl3Wc6JuhFfBE2i9TrCn2EEo75WDZlFHHL4tUVsXtQVSF3col2L0GAcno97YZ80OGabjDG76WOhbze49rad3zYVL3t1J9B4cveROdgoWL9URxDXS00RINWqKdtIn07ZWLFQA2rSCmDoSRHrkWumC2hZ1eYWq2wvu"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                }
            } catch (SpartanIncorrectDataException e) {
                e.printStackTrace();
            } catch (SpartanConstraintViolationException e) {
                e.printStackTrace();
            } catch (SpartanPersistenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
