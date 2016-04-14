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
import demopro.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import demopro.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
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
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainHelp("UJhEJ6fOCWnHkwUZr41Qrkdncq2EwZOkdldqP3VJXJzN8XhLXs");
        useraccessdomain.setDomainName("q1mEW3LtgjrsippidcTUIbs49WCpzkpk1OVTEPGhZMys3Qydt5");
        useraccessdomain.setDomainDescription("Q7ONCFyoHcsHhiU3yBsoVktDSR3lqXPAbWWRlYvkKurRBT07ND");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainIcon("wNxlSlUzLoLqDhHkFVmaEKSEWK5aYlfjdDeD688hYut7nn69Ka");
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain(true);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setDomainHelp("pOHGas9Y3pCzIDZkbeKtrJEpDlhP6fac5p96xUdVL8CYY3iaeY");
            useraccessdomain.setDomainName("c9195uGZCcuflNWedcaOl2uanFWwFpCWV3fZCzceG4MThm2KLG");
            useraccessdomain.setDomainDescription("WWpX4Z03lAXARGgQNdP4e5a79xd9K2IaQzXckQIA9Gi4X1F0UQ");
            useraccessdomain.setUserAccessDomain(42753);
            useraccessdomain.setDomainIcon("kacbhHO33CkuZoh5KiDSJEixkouWxiEUvHUGXHfPHq3XSbkIDV");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 148721));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "3TDnnAmweZJcYdAf7dnJHpedryjb4MOb5aJGuQSCD55hONeGzvg56vm9EqHUSX1eQj8XvVy81nRixFaaj8q45Y3xuk3b2zddC6wMBAH1OMUVW73GFzJH5MJVcCHBB9MqplfMsHQJOBXRuA2VzGaavDwl2hoIRV69duC076Lw5fcbkrbaPtEKmrqZ1q3zbvYd408vWqIZd1rcHq6WpwzYpA0j9OsbBp1WWLoFYRc0gn5m8RQoNtrbTny0gw7xQv9mL"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "o4J5c3XxcLQTNZTNxZCSYqh2QzrtCOqnCwam2TIcvSfx010gokxhr9EMZ9UBCQp82Hg2vBgKkYTSkRlmBwPE6HJsop1N9KALfKcQhWnqYt3V1PES12QODuq7UKEeNllStzNZ3CnCHOkAPBaSLX3hrpp4IhChst76vUU05lThzSuuKXNmiN5O8hp79yCDh0Q5uHB2lqdKFaQxt5HfgYc7aUD2EFR7sFXkjS4ebngxkKLUSvBTOBV7teLhJVDq59eRL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "3FExXyI6XPb1PiwGmbLbsuU4pqieZB4lv4YS6lpxRRfdHOob4gFFv4wzYvn2HmZjKkDGEYlOelikIzTeEcFcBhwVQVsT2ZxFs5dkD1PTyoEN0NaYPaTFPeRo0alAks6lUosSQuSGKJfhrwDh0fPXYHG5pnB2IzHhhBuBDFkKdtDefKh77CNLhQY6taSZWuOHjj9sl41iC9q4bdtdDKxckpQyTIbL69MN4oYPysFWLgwvejSMPmmOxzDU8F2fPODuK"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
