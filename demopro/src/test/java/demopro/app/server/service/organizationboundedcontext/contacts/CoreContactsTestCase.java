package demopro.app.server.service.organizationboundedcontext.contacts;
import demopro.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import demopro.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import demopro.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import demopro.app.shared.organizationboundedcontext.contacts.CoreContacts;
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
import demopro.app.shared.organizationboundedcontext.location.Language;
import demopro.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import demopro.app.shared.organizationboundedcontext.contacts.Gender;
import demopro.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import demopro.app.shared.organizationboundedcontext.contacts.Title;
import demopro.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import demopro.app.shared.organizationboundedcontext.location.Timezone;
import demopro.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import demopro.app.shared.organizationboundedcontext.location.Address;
import demopro.app.server.repository.organizationboundedcontext.location.AddressRepository;
import demopro.app.shared.organizationboundedcontext.location.Country;
import demopro.app.server.repository.organizationboundedcontext.location.CountryRepository;
import demopro.app.shared.organizationboundedcontext.location.City;
import demopro.app.server.repository.organizationboundedcontext.location.CityRepository;
import demopro.app.shared.organizationboundedcontext.location.State;
import demopro.app.server.repository.organizationboundedcontext.location.StateRepository;
import demopro.app.shared.organizationboundedcontext.location.AddressType;
import demopro.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import demopro.app.shared.organizationboundedcontext.contacts.CommunicationData;
import demopro.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import demopro.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import demopro.app.shared.organizationboundedcontext.contacts.CommunicationType;
import demopro.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase extends EntityTestCriteria {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    private CoreContacts createCoreContacts(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Language language = new Language();
        language.setAlpha4parentid(7);
        language.setAlpha3("su6");
        language.setLanguage("aFHYsGLnWGfmUBhdOrPaIm4oY1cUAIThF2bExDwV2hWS7aQQUd");
        language.setLanguageIcon("nGcxDZQMzT7SoMfQIhGwe3akWarm8585cKkcDZO9UTIqJ0MBAi");
        language.setLanguageDescription("grnvVInw17kFiephUyDqh0G7r2j8UwSLZvKxUXzuyAQmWE6Zhu");
        language.setAlpha4("jzyq");
        language.setAlpha2("ju");
        language.setLanguageType("zK5FzLtt7Gu4XhMqT0VasnnLLZmzTs0S");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("ThF3BteqvYl3Y8xAuHCkXEe19Kr9eK3027OVfnsqoJ61OdsXgK");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("lTRF2cRgemd9an7mcXLNr78FzFTZAQuOhj0aPlc17IkaY56RR1");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("9KRkwRjWHiufjmiZyo2d7ZAzjmo5Bpk7A7tEnzHIG4Jk3CNlEP");
        timezone.setCountry("pWyqXCtH7i5WAOXHrdqXv4OVUmXfy6WBIBOUdGzcnPYbi0Ssrs");
        timezone.setUtcdifference(11);
        timezone.setGmtLabel("opqcAA4cQNqXQejGz1W7Ym23N8CuqpGo291s5uTqhEYhIxzgUM");
        timezone.setCities("LmLVzgm43U096tb1lmq5eunrfixyeRT2tM32HWmtGkXRcwyzef");
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setMiddleName("g7zzb34uxD6Nw982pDoeY1NKwXOCygmcQLF4YH9RWeLr8o6HmK");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1460618824472l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1460618824472l));
        corecontacts.setNativeFirstName("xPRY2AdckDU0g2EfnhHFb3Kj4Jm99z62bqTrKku4usXx0PI46Z");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("3JsRhdayp1okC09gOeyXUg7rIaVRyuV7b0KbTXE5O1gCd5du13");
        corecontacts.setNativeMiddleName("ihdqlwnsXk1TKXGIKVkepbGlCuy2gdfzobKdv8ELRqn3TIaJH8");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setAge(120);
        corecontacts.setNativeLastName("JOnQS6RSH0O66ZYl18mO3pNtxfo51fPRa7yf3ozr8ofTjOrlLq");
        corecontacts.setNativeTitle("clThnNxloUAyFPohoM5SehBD3oSO8PzlM7tPkliyEmgi9iEeDl");
        corecontacts.setLastName("m4wgvuKwazuoQoSul7Pi0uzrzKOMxXqZL3JZf6wWfQXV8i4rtx");
        corecontacts.setFirstName("Sy22dOP6K9oiukBsgxi0Ga4vJyVymuDY5QJHn9dJA03wnmLLxw");
        corecontacts.setPhoneNumber("gYUYj77vtF0OelVA2vFG");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        Country country = new Country();
        country.setCountryName("spD6FlRqXK5QUdwbQ4FdzjI5ccIddW72TwwbncJj7hDYAnDDOn");
        country.setCurrencyCode("or6");
        country.setCurrencySymbol("Ux7BNqeu7aQSYU6hubDeoDHpHmHLEg73");
        country.setCountryCode1("z31");
        country.setCountryFlag("YZshFfyoSGHe0u9cC9eYoeHPtjdbuiQkFR34HbxwV7ibdBfThi");
        country.setCurrencyName("lRdlTfME54Ce6YeDVEuabl8REtaKbcjGzuL8ca1Z3R84zr9fUw");
        country.setCountryCode2("aXA");
        country.setIsoNumeric(864);
        country.setCapitalLatitude(2);
        country.setCapital("XbqK7f4RPKUlUnuehagprCAYCvr7euju");
        country.setCapitalLongitude(10);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        City city = new City();
        city.setCityCode(2);
        city.setCityFlag("qKZrMnQOxQAQYq6w2Tzuyp315puCtlAd1IDZMKZo3ztfgANYXn");
        city.setCityName("ZJaKVifOkpaO06NnOlmddhpEzAQMIKBUaJA3vVsuYXVHcVc3x0");
        city.setCityLatitude(11);
        city.setCityCodeChar2("kA9JzIIYHzqK0ONs1hOgk5Uymr4WMQLH");
        city.setCityDescription("GpTSzmTWwte0Ci0Bfvh1YPPvGBbRsFC1E705i5gdvFN6U8JXxz");
        city.setCityLongitude(5);
        State state = new State();
        state.setStateCode(1);
        state.setStateCapitalLatitude(6);
        state.setStateCodeChar3("V7LO30gPL1hbZceEhabSk9C5Bq4r1T14");
        state.setStateDescription("B6t8zj5hR0Y11XNkv8GqkCnylj6zLykwYlSKPmX2PnGZjBLrKe");
        state.setStateCode(1);
        state.setStateCapitalLatitude(2);
        state.setStateCodeChar3("Hq8BYzOYnBiBQ0KBpoxV2JOy9xZb0way");
        state.setStateDescription("RAqjFB2rqkdliLQASEnrgmeoWMlhDV3VRUh2KfKEjYOZaahgej");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar2("4553SCecQZAhWkM9FdVsUCiCnC99tqg2");
        state.setStateCapitalLongitude(10);
        state.setStateFlag("Q9bBV1YytlKtBi59cQk6qmiY3Khd2XdDC3f9bQDpASfTZxMUZf");
        state.setStateName("Q4KDmmveJhtga5c7G9idS24skQlsQ0TTZl6UdvF5bytmGFY7It");
        state.setStateCapital("njE1nXDEDIdNiusQOnpzJ10ZBV2XbIkRTkifxWAcxROhiiFiV5");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityCode(1);
        city.setCityFlag("XzEtzMC9fwiF5Z2P8mDbmsTIk258PJ4qlKNMSYgmd6Ulse83y7");
        city.setCityName("cOX3ZSyntjoOiHWiUDKyMJNpsLq6iM94Nyj5X2apqbzpjDmr5q");
        city.setCityLatitude(9);
        city.setCityCodeChar2("5mv36PgSVien4Zld2pWlduzkRX6OZbsN");
        city.setCityDescription("Ffy8ZwkDQPYoJoRh28iWaOgK4Wa1aXdASSSwBaSIDF30iYPMdB");
        city.setCityLongitude(5);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("AhxjTzPz1iCeWOhBuryOfYKB9obetSrTguv4jUaEBphStsK55i");
        addresstype.setAddressTypeDesc("tmkcmb1gWwJ9SnABQzAldpsIjMEv1pKNzHdxxBTAe2jPkKxayp");
        addresstype.setAddressType("BgNk2cGPVodZya5vVgt8ve4Nq5pAbdnYoEM9w7rjZhgLuR7RWW");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("pFvzRa5ThUODIodtje13zSiE3FZxJ3uasW8oMGtn0tXmRF3BwB");
        address.setAddressLabel("LZxc9mLlEuc");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("FNJWGUAB9H3D56rkYn4C3NMEgNw96lU1a0GxZwTPRhM55HGevR");
        address.setLongitude("52Y1Qs8fS7tCMV41KsGYXnLaT1Iz19rFCflyHUZ3XgKub1q4Ql");
        address.setAddress1("lXIlbgvjNZZT8onBIU02G5lug6nXjQ4tF19R09DPIhouoDbLOr");
        address.setZipcode("50Hxt9");
        address.setAddress2("C3lZgzw1Yi2DoRvfGPCX06iMqS7npHUgiwhONSMjTlMC5XAdaY");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("tm7KI2Ollh9IgCnIWluhhFNqs1LOFCbW1QAlUCwSuEXMczowes");
        communicationgroup.setCommGroupName("N9Bs5GHP5uUMdKPnahTQC2jh9OpWORkBPKBlAZjDvWFsWs755W");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("3ziww5pGiMvO373cOUY4PCJqnnet517mM6y6OUfHoTVkb3G53w");
        communicationtype.setCommTypeName("MbZ8sq6bUXXk2auZhqHgYV43eQswmL6oOdq4cpvvO7je8e5QlP");
        communicationtype.setCommTypeDescription("3CWJujrjjxcgumJR1KJFjz4QGzd7hKsfyYIuN0q5PX9Q3u4QG6");
        communicationtype.setCommTypeName("EDTrJrq6xa3mbc186S7S7RsaRvRrhlObhjbzQdYLNd9sDpo1Iv");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
        communicationdata.setCommData("MztRTaUTCa");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts(true);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setMiddleName("FBkx2bKppPbjpbOH0wmYnFgeBmXmaQkLRrcRaV2lN2Ycx0KU1y");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1460618827425l));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1460618827467l));
            corecontacts.setNativeFirstName("C1Z0u2qQiFbMsgCaOXp7d1x12UkipNrkhksamdMGx0KeqMuBsX");
            corecontacts.setEmailId("jlbpcnz6sVh4JxUWK5OC4NHqnYlUaxIe5AfpDpOtvwQ0PTxNFK");
            corecontacts.setNativeMiddleName("EuVqMirJWYxR7lHSzQIWJTSN6MIbJiMi8Rz9eIAPSXHPvwnUNU");
            corecontacts.setAge(93);
            corecontacts.setNativeLastName("iwqSPv6mPrMsqP1ALAXOAtL2pmwDMMq8ZOyLy9PHUGKo127n4W");
            corecontacts.setVersionId(1);
            corecontacts.setNativeTitle("lLwv8ReAcHdGxdSkV0ef1am7uP12JcDuLUCO7Hg8oYnR0hgfyp");
            corecontacts.setLastName("Fimda2GwKHEtEWLZKhYE26E3NdaU5XQblTNMJhJsEORi3S3uGU");
            corecontacts.setFirstName("Fgt1MgCR6LGNYN3Mwy9jyGEPPXLNZvaz7pLaQ5ZQg1WODVpDO6");
            corecontacts.setPhoneNumber("aGi76AahIsHJXkm7BQ8V");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "Jk6qiRX5FEqm1k0VEvBj0UsP6HPe8XcVO04NGFZQMtW8PWybVi5nd1YF3CIbP3U9GLOVvfHwyodtDQHUF5TnXmB14vrfinjxndimeGF37H1gA3r79MibWz92nDJcFgbGhK1iLPVVzte8GT4IjNhvS74341igYauGzscQXPHoEtifkRgpFqUV2gzEyRnJEzxeYL3H7DsqPbtDNn96szsklJaNAgAbBSSwzGgn1KMtZQwfPc2hP4Ua8vv0pE6ADO46Q"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "aUjevHbayZw9VJrLvMGyv2I9IsPvECJdHJ7fTWW80nD6f2q5K2h7ODEK6mlsIGZAg0tIewUPG9WY51v2udB3d4S0TZwDT2heas9sN7Tt5kRyOaUfJ5h8FCMObI2TXpMUDLvIS2kb5FLrzStE25Eetzxfm68yzX07ac5MLrr4QGe9ptxbnw4GcPpEKCN81S19BkH77YISKAlHPdotFYpjZYy1tWcUa8F0ugzACT26DwdkIMv5M8gdbmewH7TqjtxAx"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "f5suDdtjZOOBsdHGq6P4gJ7CfG2BNkDVY4eY63Ukef6Kj1KTWxlTyFQMw0OxoeMAgu0xuMNIBQ9CawlmI5sYcUmLcKPGLDivZgs0T0S3z8G9Hf9es7L0KSYBriwdwz7IuZPiDnfF3E1kAgup72ldGnAEyVEDTPpio3Gktu5vKUvNU1S5Jg5CpxOBBv77RsU5CBQh8vCHvOFR8arVREfttuw8fUaIee2yCnNXscW2S19nwJYOOTxAAnwq3yW9j7GR5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "XeRAMGYooe2nIvg1xyEqST9ij5kQymevF4hXDei6HvZDTwcBPTFPB1OT36w1YoTkz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "Jafv4ox9QtgNMLoTpvo3EzmJ2xQJdQoBqWnPrPEcQZOo9Xh1XehdHNgU5kuLZs2uYgMC9qnKGKm0XzJjZI8Rej4Fq9J0jPS5UoQQ6nxx01a6EBb3CkDLgxkm2VObFW9ASZBVBmeipTYAF3Yp1UK593hrnBfNNg7xnrRo87Yg0Pk0rUw2yKLc35JX8igI1HKMgfCqjQzwIDQ8G4k9fNAdEptaucO43P7JrKt1EPXD9ahMNabc7aMm25j5op9K86iM2"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "t6XewZfJQbADmAJI2T76ZrvC21rRsaYKthbsZNF3CiDRqSgKZxJ4QIaaUMtaLfMZNahLYQt3gqLgI3tXCp1PRid8bkWr924vYoDn43grJjmhQC0psL5zquW1JV8EKGuo7FCVsKDjjrqX2wqM20nAaYELtFEzefgWhkTQQIeNATke963GUYzNbn9Eq3t3LuGBugm49Tg5ffBYZBgnCjS6I4hTzzni7em6BALHTenNVRlvVK4N5jld3jOHmhybVS7ma"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "bUPo5HRFH97VqP887g2v5RVkrpKzlT5SpasKwmxuDLppDKSI330S7w6HRKvCGLGddClYukf9iXWKWCycgvjeaV6Qm7nY9I3apUpALzNH2uwy4hSUeiz1nabtsrRkpCJdrgqFNKh4DMBepv6a9wvns6QTtXcyXWTer1zhvoBuju7rwb1XqU1EiouHB5L2Qira6crQEy7SeFELsCu0LLK87D0aetX2Vpu88xDSMcAXgdjmssxEejCL1jxVZQ5s4Grp5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 156));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "2hsXg2sGEMaxRjN9mTdoix5UCsW4kPE3R1c5UHjCo9TGCrOUZTKQvNTpS76mSRk4vHPbJIXea1JmU0B1tASwTMQYFiYb4tOXni3G06V8kMiZb7oC85jkBWhRVvG2K3KV9OCcKj4swWqY6sgUyey7rA3bEoGseKAYVhSf6wGjY47EO5vHE89efl5MeMQVfnFJYSw6zuN1qwqcztrBapHwQtVWkI0QDXQPPzyzU6saqm4j2LDQCNhs4BMvcBM0XJ4wU"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "oXmy16sJhHH58wiTjzi00"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 2:
                        corecontacts.setFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 3:
                        corecontacts.setMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 5:
                        corecontacts.setLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 6:
                        corecontacts.setNativeTitle(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 7:
                        corecontacts.setNativeFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 8:
                        corecontacts.setNativeMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 9:
                        corecontacts.setNativeLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 10:
                        corecontacts.setAge(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 12:
                        corecontacts.setEmailId(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 14:
                        corecontacts.setPhoneNumber(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
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
