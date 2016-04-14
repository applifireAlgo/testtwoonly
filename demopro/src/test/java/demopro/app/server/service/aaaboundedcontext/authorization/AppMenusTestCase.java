package demopro.app.server.service.aaaboundedcontext.authorization;
import demopro.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import demopro.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import demopro.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import demopro.app.shared.aaaboundedcontext.authorization.AppMenus;
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
        appmenus.setUiType("RUo");
        appmenus.setAppType(2);
        appmenus.setMenuAction("puOHJa79DK0gJARzPAJQlqaGQJuQGsNtxKotsHu76nAuTA2YL1");
        appmenus.setAutoSave(true);
        appmenus.setMenuAccessRights(5);
        appmenus.setMenuIcon("se2Hs5yMXzYlbRShV1OtZN4qwB0HrcbBYGJGdbvT68oUxzqum0");
        appmenus.setMenuDisplay(true);
        appmenus.setRefObjectId("IqwHIGEdYFii0XjaarHxFHLhccFiN46XJpISofVEBUxqaC72do");
        appmenus.setMenuLabel("ZUnUxKwNXb5bR8Qm5KRtJzmbO3px3Kbxr8avzPF7lM6KEx43tD");
        appmenus.setAppId("tEfJy2BKGj6yaqdgBTSZiWDcsOfDMbeG9r24jAglAEXh28pvjb");
        appmenus.setMenuCommands("s0FMfuWqDtdUxdjrRtrV5zwVsO0l9q8f0Icijx78VTcK3taf9I");
        appmenus.setMenuTreeId("9JoyGp0L9ObeAsWNWZYm5bwiO4OgXvHwDLFy0Qjij9lf7xxteN");
        appmenus.setMenuHead(true);
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
            appmenus.setUiType("HDY");
            appmenus.setAppType(1);
            appmenus.setMenuAction("e32doEPakCh3uZD7av5OwFMySNRaP2zwbesmos7YnquKRLBuEf");
            appmenus.setMenuAccessRights(1);
            appmenus.setMenuIcon("ph192k6XTuamBFhE2VXPepETIRlLpbaT2l4JkUGgB2hCmlqlZ4");
            appmenus.setVersionId(1);
            appmenus.setRefObjectId("3nvHcwTMDcjCoJFQYxjYoljBKE1NtaywIzNL4xfrs2ocgaWUWr");
            appmenus.setMenuLabel("IMxZTK9zxODGhSsMZErq7ujNz6QB9fqw4QarxxsV42j08aYgwL");
            appmenus.setAppId("Vk0YbQbniHLYmchwZcS0e6x76ysaCoxkOhaY3rdxaH2G0GymDZ");
            appmenus.setMenuCommands("UcmCphI1LLkE03YgGcYJj0UQd1ueSlNNlvR3UsZKtzRB47XEgk");
            appmenus.setMenuTreeId("1a2JZlAVVJJT6DJtVn2Sgg6Ixpq9uAZllmnjhWJ8R3uN9MktzS");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "YsZJUv0xjysmB2ELty20qFlQQaAcvY4CCuEhhZnLSC1EvdYhpyDpaxf2IYXCoQeb7XnfyeoHLveTUM285XvkHy1BrkzIPRFFIyTgtedJJIX20N4LeDUpsB07GIl1KonClT7HelzHPQzlpjAstoVtRKOiOOqBvVUqbJklZiqXEHlEaNVUllXmi7tiNiSDVdRZ8qw00YsXntw6D9OXH1vpIbFPQgWF4Nmy4YsQkbghLjf2kHMjF6jiN2SrAgtBl7Sjm"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "3RQVJWBW66vTkHZWggsFvhiODxg3B39ZD1TzZ0SXkvFcDwn93DO6e7LHuPcz5nD7S9CMuxejkJxZ2eSDFcDu7cVhOI9ZCVJld0ZoiRU3REZOPJNnGIsN5eojF51YyTewZkTnf0EwRWY6oieDb2azVZBahEAILVNr5eVRKu7G4zEJoA9i6OyPfDQrId34BrypN9aLdXhUhIYDo6cC45yX7BbTXXCRUSl1JbGqiAtvL6qJGMzZckM9SAcsHUnpiWczq"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "vtXWWuGSuCTySE9ULdM6rid7oPd69daI8263leIn6ZYgHRSpzRJeI1PsVd6us8Puf9ouZBfZVIKnpSJelKqQSyjaY42UBdx9USpoAfwYWOMYeZKDWzYQKtcnEw3bO37R5tbToMqihsb124MysshlSY4VYCiZprNRGKw7A4UUVkRjpjmcEYI3cauDARYOzlejq0sivd9f3iJOPxdRzuNhH5pcD8HipuHS3DhXYljDdFOYs4BAbXP25A2ZgRWDhx7uz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "tWhHCvPQUcybLvizoVAwTScbmdHpUdCXn1w273qz69s7qhbsALrUezfhiVING2vYS"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "YIfTP0otKRxSHSE4R3p7cUFkEVlxY5XtsyHInZgA9n8F1ni1OZoHd349D1vngdLk0SnLxKC3FmiP6BViPAkKIsgyLpgKTPYKIKSqSkEbMNhMwXnaS28lBOlBeUpQr1ySPngnYDxY61zKhxf4UTOvmpjWmJgN8eUX5Yr9S1axjW2NWZu5b5OUKWlwIwN1PxH0aXbiXtAxaeMfco4uOJq9VeXYaKCA8BSiL6jfl8BtvWXC9tEnR8j7AHnFfZy0YyofE"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "cn2X"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "bOUXkMspoVXtKQmi6ShNXVhYOB5qOTtHEGpFFP3GEo8BywCk3f9slv72EkAO0G4hJjBgniHb2TJrGpdRwNVO3LmvnGcsW6xoFYTiCsazsJgTmBPj7YPsG1ajCt4cFbwF9yoGRA54INWY3M8rYJKTt7GUR0hDrlQ2y3dcFJ08j5k0TraGZjeXp1IXmw2lUXj6SAlEiDuqKGL1RgAsnAFel2VVmJDS1nw6ZCI6E1fOTOYnB1Z6TROA2gNIeKtkSHDpe"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 16));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "BFSUYKgDk0mVVNoMlWRxXx5YsyTDmqyJC278sp4HvkOCcZBuDQCRe9Jyf1pqMS0xusFxGgz50RjbmPV19z3VD91ziCDZwLNjWfd7RTZRU2QmQf2r0ZKi5xkuAAvycEabIIKgkHnyNyXbycXVCs7iav1NhLj0qIue301LFnaTEqehoUykGXYT6fQDkHGfd5gCxEgYOhhukKxGl6qNFySqblAdgDRDGGNmrvnOSVILhiib3UxjH7rrf381hqKBx6PKs"));
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
