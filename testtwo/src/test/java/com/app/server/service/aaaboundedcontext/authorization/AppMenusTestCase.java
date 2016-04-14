package com.app.server.service.aaaboundedcontext.authorization;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.app.shared.aaaboundedcontext.authorization.AppMenus;
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
public class AppMenusTestCase extends EntityTestCriteria {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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

    private AppMenus createAppMenus(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        AppMenus appmenus = new AppMenus();
        appmenus.setAppId("8tjvLoc3IhTbWUfr79KvTUyYq9gdijv5vbkmqtOoYzQ3xB57pf");
        appmenus.setMenuTreeId("BOIJyHLkojms379XFV1dgTA9lks9hgSl11q5i8ZkIfENGaiD00");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuAction("4JslFJoQNBhgJ33OksGGC7WncLobNT9Rmjfw2I6jebiMZ7v11c");
        appmenus.setMenuAccessRights(9);
        appmenus.setMenuCommands("6ElvIjSb4GBXVnhWOkSuYfzmNnd2Hsr4GQ9pBVOIzsNBPM4ULz");
        appmenus.setRefObjectId("5WwGW1cww7BiyKCDHFYuqFmQZykIrrD8gBg9RJL5b0huY5LaYh");
        appmenus.setMenuIcon("OGf2thimRniWo6FUTDuBbYdGWG9f85vFaBc4Y1y3BO9vXSr6C4");
        appmenus.setMenuLabel("dbXfxAwvPbtH5UN03AGVfbpzMLuamF5u10TL00cY6uMl7EB1pC");
        appmenus.setAppType(2);
        appmenus.setUiType("ey4");
        appmenus.setMenuHead(true);
        appmenus.setAutoSave(true);
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus(true);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setAppId("LWwWcr7Feq5u94g7fYQW8aTQICUqRcM73tsRB4m5Tnn5RL0bXC");
            appmenus.setMenuTreeId("97s0ayDoOjj4kCI3R0l47LmhrKdyMLpfrMFfnaCjtAEJ7gbABv");
            appmenus.setMenuAction("EOb4v5L4TLBNOxAemT4KQnrOUOJaZNry1Z3DRzQbQ3GufRlzCu");
            appmenus.setMenuAccessRights(11);
            appmenus.setMenuCommands("q3HQb1lB5zF65pz0yP674HRrKC06jMcNmVc55XQDEiLRfPjpU3");
            appmenus.setRefObjectId("5UxojHdteODdkRoXn0Hw3JiSyFme2bzETs1cfjvOlj9mVWjn27");
            appmenus.setMenuIcon("akd14MCOCjJwVx5xidg65frLMCMDIjVL6Ztyb8jPN5n9r9QrNl");
            appmenus.setMenuLabel("DzYqmzJHUSgcTuTlIY3PrLHUmbN2qaRsmHdMw8aQQHTSUwWu33");
            appmenus.setVersionId(1);
            appmenus.setAppType(1);
            appmenus.setUiType("nlL");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appmenusRepository.save(appmenus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "menuTreeId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "LL8l8XHy0AiwYh8oqzzU42bSTp6Szu3fw6hVLoYcPg1akwvy3IwvhQ4tLoDmWJF2RpPykBkOXfhsXRyOjfDWGh6tYvx6e2Yj6A8Hu3b92dEhzZk2JfsGTivJrIsf8mGjrNWaSEGDQX8kIcu82m1AQMxrOGEY7wk1Sm1dxTq9P5XyJrWJe5SNlHL5hgkTfc8JjsznsbAWyW0oK1GXvk4HVyZZt6894jBoaYtH7UWATmFrksFGU5z3SWhx8SbavDwEp"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "vC1orUNePJyuDNoYXc2hVqr4qS6vBMVpIkvtTngukb9qReJzc9dxgk50ovJXOyAE1eNXDOX6x3vE2xvJW45WswWdbhdNhFP46WPU3JYgAjz5lgNkJKg4QACbojrVLGXQdXDRCsdaT5wqtw7ZaHziCwFuXBHMqzD2afu6iqcEJoxB4ODL9OFHlbydO56VPcGgrb3eyc5PKXa97BZO6g5dLfgx7DhEty9ag3OEbXPEqdYxZuNMWlAJzUlOEN0uUZuUk"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "tsObDutoLiFIu8kr5I4W9a28wK1o1sYF9YXU1VeG1v5bouj7MWsIjTON58OctxNqJM1uVFOK7w8P3jrTGTrJtc6D4fOE1RVNPoV94dkgxhb9m18bLoa3yq8PxGqWEU2o3fjFQTah47qeuUqhNsG6ortP0c94ZM2XpVzqMZqonN8YIGk4hdJ2ij2f2aJltuYMHGRkbLApM6IvCYLSui6By8tGL8kuzE3K6aM9SnhEYZiOmaB16RbDFskqDlA04AvcK"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "CbfqbYXpwwI5u4diMamy7npH0Y5fMdESCPyAddmbkngt1pVLnXF8pfqzWmW9wxUkJ"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "j8NY2jS9yvrYidHU60Rz7Je8PiThngGwzr2iiVgLLP4RDbfWXBi5lgWSOuSDEI7Cy4WD3lkAZ0OtpWVRKxeBCWvljAZ6mVdycaCRFT6eTDSStyRUr7yWS5p0qA3KOzYmkFjUt1tQdHIQdFG4aHbUF1kHYaRnJREdVsP3M54WzBpmFiAFuOeC2hCb8uprl3qkzrZaKqJ5UQwU4DmiZtBJhBJuwt61WvbGbT9Z3ePwZM4rrioV4zgz2B3Ntq2vCEnqN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "1Cws"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "ZSb2yycE4mMAwdGudV0iva1cMM8AQW9QyUzfrZI1r4uh5c385ti1fmuq5eRtpCy11vI7R4ovd98U7Oo6yiKAgnJCH3oNgeuzST0PlFMGpBCNye94LUMuzwKo0sebZEXp1nv7Sr5aJj3Q1teLkVfY5S0czqiJr7VZLf9u4QjcprePzfNwZUgaTMfUTBPttMFpKy5jczgGYN0AxzgBS3oBqJflUul7AqS8ABtUnGUcwVaXBTro73AMeCyNUvhajOKvk"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 19));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "KIA5kq8dUt3zEj3H1aBdo9qRXcOuxSwaw9lVJawRk91ccGF3x7SSUGBFOZW8gYxVQZNgeT2eGBjwmIHTlMUMdtbb3n4uPtAJsPC0Lw1L3WnL30ZPjiGAAU69qiZMqV4o2PkOVcLtvdb9EdDTdSuvwNoLZH4M4vUKG4pFNmCWhH3ZPz4j7LMz6TL6KpNR02enefslQW5GSFL0y5a2ZIX1QgqYBJlf1I4QPJ8Z33mh4tyv8ZP62rIGVSyi2y0kN1PgA"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 2:
                        appmenus.setMenuTreeId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 3:
                        appmenus.setMenuIcon(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 4:
                        appmenus.setMenuAction(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 5:
                        appmenus.setMenuCommands(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 7:
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 9:
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 11:
                        appmenus.setMenuLabel(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 12:
                        appmenus.setUiType(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 13:
                        appmenus.setRefObjectId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 15:
                        appmenus.setMenuAccessRights(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 16:
                        appmenus.setAppType(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 17:
                        appmenus.setAppId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 18:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 19:
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
