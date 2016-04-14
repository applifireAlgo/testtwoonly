package com.app.server.service.organizationboundedcontext.contacts;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
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
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
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
        Timezone timezone = new Timezone();
        timezone.setCities("7qT00qZWiT0FJKEpZjGJlVYPm2hIie2OLo8qJvpchliUbQed90");
        timezone.setGmtLabel("yLLgkLlOKbfwoReePWYgeeHAHqf5Ng2qXPGRjCZZDwuC8b7ncz");
        timezone.setUtcdifference(11);
        timezone.setTimeZoneLabel("LTvomABHsK38g20yhpSEjL5Opt2sbd1sV5Gu5f2Pc793JMS5Eq");
        timezone.setCountry("exQcIL8dnYh2bCXPN6D8q4plhP79rOrwOFJ1ZuTNOUOKPotU1W");
        Language language = new Language();
        language.setAlpha3("pQC");
        language.setLanguage("i18Ki7XoMu8yilr9pG8KYyXgfv7mU8LSggU4gwZsKzFDiiZooW");
        language.setAlpha2("pv");
        language.setLanguageType("PofAYoVESpfoAF89c6q8TFf8rhRPWTzB");
        language.setLanguageDescription("3V7mcVozwHBL4gjOyZOurfIxpNrPLhjEmihbi0yG3msEjBVGFU");
        language.setLanguageIcon("sL8N4k0fuoHC97BEODCOY1ZHISIsiEaTwQXES8RyN3l4TNA6JN");
        language.setAlpha4("bhly");
        language.setAlpha4parentid(10);
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("FlG4CXVxFt3fZHtcCCILy2ElQsWwrTX4TPHq15wMxlHBfqlIWu");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("je4edgdPbN8k3YKIG0fXRC2DKP44gCmr8T9gQZ3Dfp2Ids1aMp");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setDateofbirth(new java.sql.Timestamp(1460615753860l));
        corecontacts.setAge(16);
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("d4XiPtUXFGTjUbrOlBgQxQHZyh4scmB3kT3OiBY4Zo13U8YIg4");
        corecontacts.setPhoneNumber("xw7fXswm2Lrma0nR1sLH");
        corecontacts.setNativeFirstName("uafFW9mlGI7jIBxb7hbun2foBG4dMqQ8mcrZhvXU43HOuN5d3f");
        corecontacts.setFirstName("xriqQYUFGpW2mWIectVdNg7yIqBH7553G8q86QfseC86A7GdlS");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("0JemoMLBo1gYjk72xcKaewOlVPZ8Ed3763HDqM9qLs8qnjTgSA");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1460615754528l));
        corecontacts.setLastName("3EqAr1lq91Xz5wbL0R4S9hMiDwNuPzG2JWoBVX6vCq51x0dT67");
        corecontacts.setNativeMiddleName("csrfrjo3RAeUnM6XxtCxuIFGhoDbFf7atbnSQ9heyVlPc8QcLm");
        corecontacts.setMiddleName("96ftKzP4EcoFoHaGItd390F7lvctxDpqeaZ8u228Lr6alTfNYP");
        corecontacts.setNativeTitle("3ZCKI7nbXTGfc1W9qgV4EBZET9MX6TVs5ZaUPU7bT39BkViEqu");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("HGtPfHbCLdqt4hVzO5VP8fU5Fv3wARnINDX7agNdxm6N8wNaEM");
        address.setAddressLabel("nrg4JjsdkU5");
        address.setLatitude("wQaRSIUZuQUEFN8v0c4tQFigOJyBm05X33Qav2aN3SbRZXx5Je");
        address.setAddress1("D18Mki7CMUedWIScKc7kGLZhnLzSWJF7u2TRgpBDbxu3RxlKlv");
        address.setLongitude("7JRVSvSM1FATTPBydgikM6LLtNGd2DTPOQ7IEPN9uRYFNOQbNZ");
        City city = new City();
        city.setCityName("l1gpEZLy2FZpqc0ZtneLakni405jl5GH53m52KctXQjoIzjq53");
        Country country = new Country();
        country.setCountryName("SUjS4huCACyTsoR8JVcLtlizgDnrUD5KQ8xZSctoBNpfLiJaek");
        country.setCountryCode1("E7s");
        country.setCountryFlag("sY9a3GYBVd6mSIWiAeS96yQWPKfZCF2qSayNLV8waHVyvRfUZF");
        country.setCapitalLongitude(4);
        country.setCapital("t2aObvcZ0DWy4nxa5NoRsrrsEeGZeE86");
        country.setCurrencyName("UcBmyGNVce5sxCshT49P41WQh39oMxeDBvOXJoQm2YKy20ROPV");
        country.setCurrencyCode("TnU");
        country.setCountryCode2("w7m");
        country.setIsoNumeric(304);
        country.setCapitalLatitude(4);
        country.setCurrencySymbol("HIVnHgmCfPmKZO6h1n1grJjGWDwWptvs");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("QTnC2RSbJHbEc93P6eNCsrqYQLKWhOCE");
        state.setStateCodeChar2("rqPY0OWIeuKsEWfkngTpFvasM3wymrV8");
        state.setStateName("bnWpQmw5F06tTMn4FC70IV2SHFGkO1cKsgzOl6gFKHkQL3ThrX");
        state.setStateCapital("AFXduYCW6TrIb8DtSfj2vNqf16AiF5PlVmnoeZyRIw9fh8zBgN");
        state.setStateCapitalLatitude(4);
        state.setStateFlag("bSlN2sFeirsp1I0IS1K3CA88Z10EPpIKbMiOj2AZIKsMQ0Y0YU");
        state.setStateCode(1);
        state.setStateCapitalLongitude(4);
        state.setStateDescription("EfMD8HhYGVybEVXlP4w0DumOvSQ625p3H7fZgr5sH7IpxFpe0o");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityName("lWPZcwX3YB1tjvnoBdAZvD8lNL4I3apTIblEfo7Hkk6VBgrW1f");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(1);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("F9FPK0JSgX4PtWIckF0bd3RFWIWXWp2MfpLbAqjBDCxdLMlYnl");
        city.setCityFlag("wQVS93kn18yit3vA4O0sArddUTlgo19OyASWoWOB3x2GZvSfCf");
        city.setCityCodeChar2("VdjP9ieWrAPx67INODFWiahXRbL6txTw");
        city.setCityLongitude(1);
        city.setCityLatitude(9);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("JAXcsWlU6CbXaYeKMUQtQC7RwYI8Qt141upHk4gEWkji9vN06v");
        addresstype.setAddressTypeDesc("c5nzoNWiMb8ZxHQz5of9JXG08JOP75vG3UntfN45QhAtjR7OqF");
        addresstype.setAddressType("rHHLlEyDUYFrXeWczEvSL86O4OMIu22AbmI8xL8M0EE050Bh0c");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setAddress3("E6OT2QbYKbozS0Nxru8sChz4fgfiUhEr4qAxLxRtgWz8bWwUsm");
        address.setAddressLabel("e67q1u2iVXr");
        address.setLatitude("K15nrioxmTKxthO8sUBpclHxOT6DuVvlL5biwsBHHJdFr812e2");
        address.setAddress1("tyzagmbULIGHMRyyHieCtus6ftBSqn53d074egZEImp1ALUjY5");
        address.setLongitude("cA5FDZ1AoY3TR0EiRinDPidenUzRHf3u1z0JzKc2T0U5ohKeJc");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("Vt6j4Q");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("rvr0TqSG0VZSh77IzoQZKNP0UBJXMKBhIGhYUrO3eT1dLNkFk7");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("Rd4KRf8XXl");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("D3HO3AWrGFnuVDMXQckzURZPOhSJGC2GBpzSMw77bHtQC4eLOO");
        communicationgroup.setCommGroupName("rZbUaHepHvsTE7Zzf2Dt8lknor1DngEBplBBCb9CEElwRUVDBF");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("Q4hyssfJRHPJc9uODBvR0hsyJqBtbbWZrPwL8mG3tEiIy85tvn");
        communicationtype.setCommTypeDescription("9BGSiRndcIq7QfLDtst4em4qSh3r4wxCtMwMycydCicSlE9PV9");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("AqGfoAnxnejiKnBq0khSKJpLv6eEm5Wskc28rlQFgsLACfHDGy");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("UCVmE8kNVm");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
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
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

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
            corecontacts.setDateofbirth(new java.sql.Timestamp(1460615756841l));
            corecontacts.setAge(7);
            corecontacts.setVersionId(1);
            corecontacts.setNativeLastName("Y2G9EKZWz5Ly8OhOJRmTtTMLXB3xh9SU827Gz7lw1IGkFmHDI1");
            corecontacts.setPhoneNumber("l6cLuuPitUjsDoomnjSO");
            corecontacts.setNativeFirstName("ZxMeYLxuv2af4JpA5rbgxF1A7Y4vjbVerdeRWYhcltSPb7WSJe");
            corecontacts.setFirstName("zyABcsosZT6fMIw044uEnX4otQhZcQ25i5Nqy6tmcbMiwaoISA");
            corecontacts.setEmailId("TMdjGYMEvNRaI8h6MFNKGa4k8jRcFDzzy13e5CRIsGlWjDc48g");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1460615757562l));
            corecontacts.setLastName("bb1iGSTbLf8Zbbr2bZysRpCScRFyBeWkctlVoYSboPryJd9Utn");
            corecontacts.setNativeMiddleName("pvNva9eadVpa29zuYuZ23aUG8Ckmp6gYwSJy3aBRw8A5h0qUOl");
            corecontacts.setMiddleName("kUDlO1SBqunRWmHFwDtbdy6rLuOolV2toljHeFHwsw8rZGy5Rv");
            corecontacts.setNativeTitle("7ctGzoFpxkKzYOmgpT28vAL559ByAUhUsqznlwsOBpN1G1CgWn");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
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
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "S8mZMD4PqhuXp3oOfRoTTKFICxEuTcHGCufwyKaKlpgiwAWBGftST2x6y9R44Xc43KGAxNIOa8sIHCN8YEjNZlmEl7zPuSeJUUnfIrg29SgraO5mpu4fmxTFH8aTYCOkNspuV8BU8lAfkmVMzxAC5KZyIXjetPkJtk2PKCYOd0pm26QQqcJ3L5CAwCAQMGj2zKOiWODT403G1zkjIFLtubD7ec7XXc0mzMMvqZFhUaIvaU8j7O5aTURWuXtdlpiqq"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "gAICylYds3TTzVPEoDqFMyPap0ihtnxRsM71lwp5vWwnDxXf4rjoS9xGFs03XOIUwPkgK5bFXGTHlDW6MIJNH2a038eCCqkjIVHI2kioAFkKVmS9my84AqrAk4k19lQPZUsSoX8IJ7GrtduwlF2DX0rbrCZnqmMHptxRPNKirojuwRskDISeQj95NkdrtEBlUAA951AAmI4KrUHtRPDfekDoT9BmRPNen5trEKmAAoLes6yJBi57s9dJ4ab7O6R81"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "6oQWlNX8zrZIWAy9UVSoXajSY8YlYC50F6LmKZdQnfSwhCYWTqT9HHmhVZytTcoSgBJNEn1pCPGkKl2dtWDK9Qf9O6awkSF1hWiSiHw1QaookokwrAjUztm4IP3JAMAUv8ZiUHsWRDEX5V1DtYi8aPgw5mm0pyH6Nb9rWQp9espENuWTF22dy9Xp7N1AKNE7wARnVe4Cn3Avv2EqIIOufcU0nYbYyi87qKGLTPNMPsTMVLtzKwdmLYW5OVjAfkerJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "Jkl6ucU4NPYxbIwBACGNkTSlu2kkAwlPLypM87sO13ERLnzVGOv64BWxdXTYJjzwU"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "rbhg8Q2RE1KXwHBWaynZ8D9fSWmwr1ZWAmbN9S2z3TZ0LXbeOTCd0pKDmtuO173BU0ivVFOAzshvJDfWnzwxii4rm3Ba9xZdpLCpaNwtzbU9yrusyxa8e6TonfeioHRD6xztEcUgxjrfF2KsP3Qf2XqOwTnZLkVIZ1puDiJmmz3aGWLqeDnZarbWn5Fb2n9m4QUVPtev9hWlJhCy86UjXOLYTsAfrjCCtL0VNrrNGX9RXUtvnhOSh0KvFnTTTh3sw"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "0PeTtWOMyZnNcUTodL5qDs9gS2ci4pVKlzJFHt2tWKeD7SL6q9XMBwyV0XU8Swrj9BztnkPesPf675knOkD7jBSh5CkVQSlO9ThFYS5hZh5jJb4c8tccL6RV5QWtitJmeDwN51MwrXhKTAmLJeIC6gpnwEDoyxZx4ctaY3EgtRZiLzpq1JkjemMyWRKJNh3i5PrwDBTvzdmhwzZUjROQztENXrIcXK1zcbHJ8RJGo7A8JfK6JHfqQHxYx5yv9iVcq"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "Gei4YS5hOsfQpE6j47FXAMewIr2Dj35R77WgaKueY02XypLfyX4fbbcQygZxpJY77HdsrrDPDvopho61gJj2rZx85JT2aFuzADeM7cLjm0HaGouRvhbMC6u6QX0plBHQTuJPyHy3cg7LZ78ePANaNZCtlWos4fKwH6I9hTdXM6etOGnjbxMZdMa6mrnBbwA808gO95lCF5mDLu5LKROvrsWfVOtvdC41rSzW2lpQlaHmvZxmtvcOt8jWKeWyYmXLB"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 163));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "JKxU8vp0iBZ3IQuw4slhyCq77Mr5tZ2kfWBpzcHNm551P5J9lyGf1gqV6CQ6713tTIob41HNXzlyMHuVsWGmEu81FetRn611YH25PLYFshqPISiG1gc0v4Vzpkp08JUXBDBZaVD4zkYV37aufVZXc9O8fFRlq7rFgxVgnKfW2TcSg5jDt7gAQgjQq7f9yEp8lbG63fK2AazgPN5nbWuZ4wW6tKfN1nqlbVxFvILtzsMlEAwaWQWkcwgD1G47Bps0t"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "LqsPgiRQ1HYpcukUHpMhg"));
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
