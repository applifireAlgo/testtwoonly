package demopro.app.server.service.organizationboundedcontext.location;
import demopro.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import demopro.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import demopro.app.server.repository.organizationboundedcontext.location.StateRepository;
import demopro.app.shared.organizationboundedcontext.location.State;
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
import demopro.app.shared.organizationboundedcontext.location.Country;
import demopro.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase extends EntityTestCriteria {

    @Autowired
    private StateRepository<State> stateRepository;

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

    private State createState(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCountryName("zBNctkVyv7AhAet3XWa761gjEB58H2avjpL21ttfRTAXixV9w4");
        country.setCurrencyCode("6hw");
        country.setCurrencySymbol("e1sZR84SLpCQDcFg7JjmcAICGsIsGQGp");
        country.setCountryCode1("Plb");
        country.setCountryFlag("WTS2pp2N2ewsyv5RMBa13XbCY2xf9cP15YMoejSN4zIsHENkxr");
        country.setCurrencyName("yxs8OBnRT3kfc074JxHjkF5f7xCSy9in4vmMu95IUId47T5eyY");
        country.setCountryCode2("cBU");
        country.setIsoNumeric(718);
        country.setCapitalLatitude(1);
        country.setCapital("zSNy5nFTLCt0GhC803mcy05Mb9ZRJU33");
        country.setCapitalLongitude(9);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCode(2);
        state.setStateCapitalLatitude(4);
        state.setStateCodeChar3("F89U2fvjo2AqHucJK5a9hVjTATSx9BOQ");
        state.setStateDescription("MFpS8UoiT08BbtugS5Z8LPFGbsEBufYbszy1sc5kTNiY58mRa9");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCodeChar2("PcSaE0KWLEj3QIwoIi3wUvWKqGw66xQ8");
        state.setStateCapitalLongitude(8);
        state.setStateFlag("tR5316STWquzViVP74kgxzS86n599xqkQ30cbBvbr5BgF3l5PQ");
        state.setStateName("PxpmDYUy8mRdmyLxypaRCaSufWsllKIDpQKUuUNsIXzrUxVgxo");
        state.setStateCapital("0SUpAmUzuepZ5fVQ40TLrKimvijjyL2FavF9GXfy5gGHAPmu8G");
        state.setEntityValidator(entityValidator);
        return state;
    }

    @Test
    public void test1Save() {
        try {
            State state = createState(true);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateCode(2);
            state.setStateCapitalLatitude(4);
            state.setStateCodeChar3("GVkOtQv0fVQxzMoGCqQxUVgWWOWe7YFQ");
            state.setStateDescription("0PpVaBEvyItmNYId9NuUok13bqAmG7blXmZWLNwK6Y1CcJFrlt");
            state.setStateCodeChar2("bjL38NpVIiLnmXakPDey3hVnCsZJ0WsP");
            state.setStateCapitalLongitude(10);
            state.setStateFlag("a4Gekh6cMhpkCwi03jemVMBKh5yGXUZSi9QpRCW4dreYmixUhX");
            state.setVersionId(1);
            state.setStateName("AsWT83okCgE80lBHSXxBHXs5yE9glQCEfQKKGFIGEKk2JBbvda");
            state.setStateCapital("mWxPfkCmvKsE50fQTE7PKDnwpoimt5aGCVSQPpaIW804NgRCZ4");
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateState(EntityTestCriteria contraints, State state) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            state.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            state.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            state.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            stateRepository.save(state);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "stateName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "jBA0mEKll9iSoOzkqFFmDyDnlXcpjOQ62SB8eKS7IhSz6zyQ2htlTGrTTPY3pAyWn8YVEeiC1RFtXFLtQ0pYsFIn4voTqR7O8RJIYvPZyZEzeJUTPQkKL2snoORiShgGwsA03v0ebecp0BoVjMVR85itKTTUBoF1ZWi7n4XJjehk7J3ljUwFvBkRFTI203uVU75WzwKbI9w0McPtNIWNJlkVHcxR4dIgFaU2fjVYbzMitAVcQ7geHBzOr9N1O423L"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 3));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "yiXQJyQixz35uoUD5yHGQ8wGHWJZBsubA"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "xwmRDjARZxmT3jOl47XCV0CTT0d60r7BI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "C4dCblaJ5j1HYdjX8IGWau0B32Z6xveLpA9cH4SsqTiOP6uGZids0u4gAdPnQJHJYtNvoUPat3jo6tbpo72djwWSIWUOufbJe8djaFgYGqmfHAUeYqRybqNWcPWNw3PXBSS0ZBzJoxtXBbIgsEj5EQchQfTEQHctmgwh1yTD2N2Hq3JOiROa4MmHNYxiAkn0w7jLyguWeFvHAnjtoIUCi69PwX6aHt8xE6BWNNlxJcUXm5mLc1ZjUkYQ3kK2tACOC"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "w6pj3f9yDiWaweyIwrMo2G4tJmEUkmOPiaaa44ab19d9b4tl2NcX8eb5pWcfrtawYMvSK1DXeZarC6XwiHBtezwlCSVUYe29xclZEzztHg5sg9Lo3PXqRsaEu6MTVUWbL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "yv7ZDW1yYuiLOX3UhSjdyPR0rDg35XlllXKnk4oIQyldQP62zRQVFZ8jF2yyWQbtEFxP9W1v6kUIEuwocrlVcDaTku74YZi87gbpwdWAawN1U6Q5a2P0ouIQYZv9nohmh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 21));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 19));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                State state = createState(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = state.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 2:
                        state.setStateName(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 3:
                        state.setStateCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 5:
                        state.setStateCodeChar2(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 6:
                        state.setStateCodeChar3(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 7:
                        state.setStateDescription(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 8:
                        state.setStateFlag(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 9:
                        state.setStateCapital(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 10:
                        state.setStateCapitalLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 11:
                        state.setStateCapitalLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
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
