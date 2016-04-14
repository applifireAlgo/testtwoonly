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
import demopro.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import demopro.app.shared.aaaboundedcontext.authorization.Roles;
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
import demopro.app.shared.aaaboundedcontext.authorization.RoleMenuBridge;
import demopro.app.shared.aaaboundedcontext.authorization.AppMenus;
import demopro.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase extends EntityTestCriteria {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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

    private Roles createRoles(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Roles roles = new Roles();
        roles.setRoleIcon("1psDujwgAAXPUCewEBaaoNVm0CVlPrFuPzU4ewZMdVwotOrNw0");
        roles.setRoleName("ZjiuJE1lKnmYomQm6iFR0trAHm3i908wYdcM0cdUmzEJgj8TkI");
        roles.setRoleDescription("gCN5OlQr5qFiu0WZhj0bUbZDCAwN5BKrDvEg0vqMlw4Pevn1n8");
        roles.setRoleHelp("3ZwPOm6x4uBKScRsfLmUBLLBo9uOnbSIk0pHQl97aikZAt6wFF");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        rolemenubridge.setIsRead(true);
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setIsExecute(true);
        AppMenus appmenus = new AppMenus();
        appmenus.setUiType("gcp");
        appmenus.setAppType(2);
        appmenus.setMenuAction("KoYTpvSrwXhUm8pfK4rcAH5uUNp5I9HQbqrNJl78HMYMtNeFKi");
        appmenus.setAutoSave(true);
        appmenus.setMenuAccessRights(4);
        appmenus.setMenuIcon("3MghIhKlXvjtBUcLNjnTAkTBebU17Cjak2c83CLZAqJfTDL8iX");
        appmenus.setMenuDisplay(true);
        appmenus.setRefObjectId("4z08RDJyyrXEMRJLxzIeDsuWvPrusbt3wPoRzQMdhtjLUgC53t");
        appmenus.setMenuLabel("qbmF8jxAIshlE3FYsBIDktfWhyqm8A8k5rFdwcpbF20W2fFoz0");
        appmenus.setAppId("guxcSLwBFeJxibjw3PsLR8VuJr2Vt67doDDMoyRPrtk48s5vNO");
        appmenus.setMenuCommands("mrkdVEoc8qhPErT7yGydrHv2YNN1pbTqvqEyDxV4K2H3J0t2Ci");
        appmenus.setMenuTreeId("ek3v8hqMgw6HekZOZvi132HlMjRB6QkPFDiEmdq7Db8Yp2Tkym");
        appmenus.setMenuHead(true);
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setIsRead(true);
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setRoles(roles);
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        listOfRoleMenuBridge.add(rolemenubridge);
        roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
        roles.setEntityValidator(entityValidator);
        return roles;
    }

    @Test
    public void test1Save() {
        try {
            Roles roles = createRoles(true);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setVersionId(1);
            roles.setRoleIcon("zRvrwYgWEtOWikxolo1wH8IMD8Ato15lf2bsnbL8LkVZcJqLK0");
            roles.setRoleName("Atjyll1RszIrQr3iQqP4vh9Uy8uWPXs1N083Dkh9P5VE2LjCkk");
            roles.setRoleDescription("4GFLbuK6xh47mn0iIfBTnXUPYp7zwM6XLGcWE5IZh5Pd6mLNlf");
            roles.setRoleHelp("uWM0nOrsnq5DBWS2uBWpwMZR8ud961aDUthHa4EWheLxaJGQFN");
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRoles(EntityTestCriteria contraints, Roles roles) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            roles.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            roles.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            roles.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            rolesRepository.save(roles);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "RoleName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "C9dh0ZvmL7brLrV09QVwBdnuBKeZcRFOnyMPT9pS00CC6MjdwJndS1za5ihWASsLU4U1vnhwLzZjdHiHlETuv91LKIPv8hJ3svpekQB17WYJmYJmJ1xILV4bWa74xQoIG4buJhfXw2NFkbxprogI26gyjUU01wvxpIEEmqjA1egolpyYgs5HylXe3odzkvfo3HBTdRjMTWBUZPc4J1ifkkGxiVVF4H4FV3wuapgxjCSLGHP5xOWxVnH5xISVT5ceQ"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "5VQwHUxORzG8nhJamY5Bgk04qWJtS0TqyBCZvRgLAFyYOpMF7RgtMIGUXc3lgwBqpLQDDkM4vUOEydrnafWhW9HonKQVJGmZO1kSPbJYLUUH3DXExReRQnN6lwxDStR8dKWyUXt018LY8OPPeEI3UDG5oqs5BDPsFHsSxohVpR48Q6aylM9oEZPDFAtfmWyiZvlvSCDELTmmnlivqi3CZPoKqsl2YYDfK9Ubl9iiQFBeLUnd5jlPubWkn84sMAMTy"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "vOAt3mlT0h125X3XfazJIjr7zGFIHtjhc7afnoIa9jDrA7hLvJiU0aSlO8Raoag5M"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "uOCiSmIpicFughkk9TsnRP5iqaZr6dVOLYpejbEwLb03AV0wV0i81519xyh2LD1FXX7RMRYwR0AFYwX0C32Br5i6pddhmE3vKLIVXrGs7Iq1uhJJPYarjwTC3KXpL3j17Sds0TvUQ0npcKvWxHruVhoGDmLZ5zswluILhAoYSUnlLNuHQarGboOGeUE6azWrt790Yj3gxG2cPOZ3YXEvB0uYjY9kCKOolwEwpqODC9A8f05DW1rVtyQevHU31ccYt"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Roles roles = createRoles(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = roles.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 2:
                        roles.setRoleName(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 4:
                        roles.setRoleDescription(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 5:
                        roles.setRoleIcon(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 6:
                        roles.setRoleHelp(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
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
