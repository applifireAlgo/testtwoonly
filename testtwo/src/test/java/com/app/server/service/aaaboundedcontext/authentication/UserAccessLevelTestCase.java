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
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
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
        useraccesslevel.setLevelName("HqTQDDZFIVSXK7242ahARVWDSRyVJMmP0mrzvylSRJOxLIPJst");
        useraccesslevel.setLevelIcon("S36MkRDIpoEYofZvAoZYubZ0QJjawbZqKbcigt23fPkfKmnZjI");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelDescription("JTYBhhNKIkptbarYpiNcSJKcJyghhCrxFTqcZmDxAMwCLqKBxv");
        useraccesslevel.setLevelHelp("bGhDdEzdMQeTAA1Rxb54xJ3MsQ1bubSsWmabV3aINzRGtTI7nO");
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
            useraccesslevel.setLevelName("z0St5dRiWXwHZO70id0WgRHXr2B9UIhtUaJYQSnGEWQWoWqqSw");
            useraccesslevel.setLevelIcon("rXOAvsEw58wsuoq2xT5fTmvgpAlVOqH7PLAnl3Bk1xdjjGWJi7");
            useraccesslevel.setUserAccessLevel(5401);
            useraccesslevel.setLevelDescription("woPJ8sv3Af1uq8koCtnPXJQhc4OwLSpxj4lj5X52FUb0JuFq1w");
            useraccesslevel.setLevelHelp("AaTZSHXrzCGR1TG5gJv0WR5F0uniTsmaXBsVG4yTtK7IYZdUyX");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 119109));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "K2sCaEucXkGjBauLgNf32fu75WminXXbq9vcO9Y4WoRSpEFicAZjegUuuea0qG37CxnR3LRknrPaoSUg4xC39bT9uL4CosylO6mqhI1sAaZQiMhnseg6Uvdv2RAtNY7r3f2bVWdDcHmZviEXiy7TtQCRPgG7aYR9Nl7QvACN4PAhQc7HOD3dz8eDhNGl3eIN9nZmfz311XFOr2hMHbY0MVwMhXKjlzIwe1EnFamREtcLwq6q3VUrq5xa4HuIZNzYY"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "NK7dY3uaReYLWH4lyR0y04CLTsLCWm2i5lp7ZcavakqiIibULEY84CkjfeTt7Jmn93WWT2BqDrbS8rZ02T16gxzLOK7qx6hyrrKeUitiOJeO5z9obwgCUBBdVERoeqZQ4F9fyjcfku9ENuD1lIRmieiSEAZxCh5qYnoHgz2dxX5u0MVqfCrK38Kv7qEhaXCp8EPccvxNH1X21lfkU4asphT5RgmcEs8Hlpad4ktdMDMlNtyMovrDwLDLjBthuzqZX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "yr1dOIP4nw5UxP0ouL8zPupD7qoBwNdcaIsAMJoU9pJ7VPD5eGOddBDjyquWLghN7VDgVtT2BcXtXRB9tMg5FSa8mC2iPSP97xkf5gXZe0mETGwBGpX8301gYOUZCjtibo5ywdunJE98RvYZoKBMIQ7t1YyFBMBfyDxJEmuevoF9frqyOBmp8AYmNbwmBQxvLL3PsvnvVjpS3gHuJ4CK51AYw9GdWw0BB2FgKYHcprJwtzJpLBNnSsv2V461hx1p9"));
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
