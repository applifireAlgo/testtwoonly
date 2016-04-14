package com.app.server.service.aaaboundedcontext.authentication;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
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
        useraccessdomain.setDomainName("P7YvZziSoF6DiwtWJEjdBQG16PWfENdIJHmMnQypl8XwsUkV70");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("pfJfknZgdvghz0Ax4N5HZcaHMu6PBnnbDkDErUe5vVuMXVLpSd");
        useraccessdomain.setDomainIcon("0QXrWhx6Js1wrOCWn4DCB4aCto53meZxTjG74rIBnXKIz0AuoB");
        useraccessdomain.setDomainDescription("JQO1rY55xomv4nK1DO5qmKX4KyGTgwyRBV6gVeI81fS76lUrwx");
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
            useraccessdomain.setDomainName("RkoCbVMicS3njMZ3EmyNG7EcUMTcHd7SX7RLArCdWpYyZbHBqG");
            useraccessdomain.setUserAccessDomain(68493);
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainHelp("LC3uYmtmew7TtRAmyqEx0xDW6wAfLqnn1YEAfvdGadggEuRPPH");
            useraccessdomain.setDomainIcon("WnbHocl2oyyKQlnsXp0qapd1SqWO3pz7yUHBDoPLl4TYugF5bE");
            useraccessdomain.setDomainDescription("L7RTkdMG3vWnhGrCmLv9ZGye6K4w3cDSwkTYEnGUEinjV1CZBn");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 146324));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "LxELjToyT8sEIM8BeqWZEq5gpqpNs0ilOAjaMpuR3L25tnbAera2h1oLfusPniLnFmpQMMJvDetcSuv5n5YVa6kJA4oYGDkLfrilIAF156trI1r6SDSv19vGWk7H7tcVLbDhsIOLTvBNVu5dwenxPMZ8Und9q7Ebhf5jPf6hJPSojgJmtfvMo4qj1gmBn7BQy1KD31QfB2hnd1G8by4ZWxdBw1gQPPdhbqVMMiCrR5Qo8xgU47bbRCX84BD3MKREm"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "nNnnRoT6R29K4NmtwdpE16mxqrRXrykgaUHYR5YNJKlEEM958tPZuwZYA05PaqDRrd5KDlQUfHYCjp38i9DqQFdPiU6vtBCpJpuGCEGLl5S5yOg4fY0BdN7Ojl0sU3zE14nzJxMrZ4WBX1JOVtS22XzRShcau4jkE53wKeYWvUJrmVsU2YkiIZycp7ZWeTCcIf7JyjnprlEsx8mTwI7lF50A22yq6J00zMKrFNJVaQsghUXmV6fKrSKvXsFqqunB2"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "mAdeDSUE2UnDth18e8rt0OTlk5I74LFwGaNL5Bm9xLbbGlSHLQc9smO0JrqjxbVVufpIyN1QhCppSRKQQWAZAKmAEprrhXvS0PlsovTiPvgmxGDRRyvpGjrJYgZx8T5Y7z8iLYrZlg52lj9LBtPDkPwd0sKtWaMJdBZNXBFw8bUr2brBng7DMLkx7lM3JhR6RfQ9glrYeYlQ7LssLgZiecRZgo8Ej1AyRf5YqQdZGDzjaNueDODZmfDfYzYMHbbm4"));
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
