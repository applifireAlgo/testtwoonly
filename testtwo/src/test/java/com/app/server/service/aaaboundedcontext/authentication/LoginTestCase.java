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
import com.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import com.app.shared.aaaboundedcontext.authentication.Login;
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
import com.app.shared.aaaboundedcontext.authentication.User;
import com.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.app.shared.aaaboundedcontext.authentication.Question;
import com.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.app.shared.aaaboundedcontext.authentication.UserData;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
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
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

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

    private Login createLogin(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        User user = new User();
        user.setPasswordAlgo("Q80BDqyVNJ8Ayz9ozOBmx6h2T4Rr7oyIYQWP7TCpp5lgAo5zDv");
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainName("jyX1ilPNzSHWH6XPWV0uNjwZKEPhLnS90VQ9iAT8CoXTIHVjjH");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("mtE4uBVXjcJ6EdmKRr9Y1o8nLw3RggarQerF9uFkT7tpIFoyLA");
        useraccessdomain.setDomainIcon("XbBZc0Y20HEWSV9bQF8UJzxTF2FJr1FHafAp7hAp1Cpvzx3NU6");
        useraccessdomain.setDomainDescription("1iDVaUsoLZM1gpJfWIFS9WNalFSR7OX6a2E710RvbnyZhcMB3d");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("48sLDHZk0nEh5EjZJVcKIXDNVQqHzmYW3w0NnRnlu4a1uC91Fe");
        useraccesslevel.setLevelIcon("DvG5xbw58mWV7y8m8T6npvtX8Tcqxrh1YGbHwoS8BkDei4DFw0");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelDescription("PI2avFVm89OTHKLpeBEw23mZflo6wMlR0wWhZgaD2WcdseWLhH");
        useraccesslevel.setLevelHelp("pMp78IqmP5Wx6F61DScC9pIpIzrB3PzvlurJNLEaZeLOJFes9D");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setPasswordAlgo("4Wkoydx6RWJJANiS4vAS2ePiZbXgd5s69eKbBae1FosvKvFAqb");
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordExpiryDate(new java.sql.Timestamp(1460615773629l));
        user.setAllowMultipleLogin(1);
        user.setUserAccessCode(35129);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1460615773629l));
        user.setGenTempOneTimePassword(1);
        user.setSessionTimeout(2252);
        user.setIsLocked(1);
        user.setMultiFactorAuthEnabled(1);
        user.setChangePasswordNextLogin(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setIsDeleted(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setLevelid(6);
        question.setQuestionIcon("FcmhCWVeKdhkXNJH7bSDrUbHQEHHekXtTIo6clL3WuZUteFRID");
        question.setQuestion("wkhEJ0SUFX29kGCbfzENqiFWdjXkRaTJcJLwlHu0cKGXE7fuNJ");
        question.setQuestionDetails("MvfPCXi4aV");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        passrecovery.setUser(user);
        passrecovery.setAnswer("Q81L8vXdvcoG6wSGBW5hCYjh1Abwupl8E4gFdvnZ47LLSHBzNB");
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1460615774873l));
        userdata.setOneTimePassword("5XYFpfXhme4eePJZz2KovAus7C36tLYa");
        userdata.setLast5Passwords("G29cuKylanvLiAYfPPxVdnjIWGX1k42PKO7JxpFXHDLiIjbcLW");
        userdata.setOneTimePasswordExpiry(3);
        userdata.setPassword("Nl1Bm8dDehWMyeWUozEaJd2Wxu4q81YznH9kxi3ND3UUZzn3KI");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1460615774989l));
        userdata.setOneTimePassword("gL0YtUCbv1KNU5PSQGylUpq2eCP8uUVk");
        userdata.setLast5Passwords("rq4kLbXb9gjE4pUILeWD7KHnlqCySDvWto8kPM9d1snwSgxqlI");
        userdata.setOneTimePasswordExpiry(11);
        userdata.setPassword("lrpHELmR2tv0ad0SYIPiw6kYuB0sMcSzD3D0ndFYvEWB2wfWfV");
        userdata.setUser(user);
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        Timezone timezone = new Timezone();
        timezone.setCities("em3h1sX3TVErglEplblwvrQWSYnk9Nn9MN3xSB9CM1j0ggY91w");
        timezone.setGmtLabel("keoVUHYqPhnnE8DIqZSgSF2q8ApaNU5XEWqgbr2V5HYSix0OqW");
        timezone.setUtcdifference(5);
        timezone.setTimeZoneLabel("eZEa8F4Q8PITbEU9c6EKaCrE9c7FyTwYEI0tY7fyzjTQAMsJap");
        timezone.setCountry("41XZrovFLjn9mfQFIeMpfdYEls0lLSsUM8EnXwoLIBfSEKlgaz");
        Language language = new Language();
        language.setAlpha3("dew");
        language.setLanguage("C7ulvMGs79sv3aU12qkhBF6OVVrJPE9kQ1QYYHlQ9B0TYAFl52");
        language.setAlpha2("dY");
        language.setLanguageType("ANQmqWKivSMCgUCNMwHQmWfRvsnSMraY");
        language.setLanguageDescription("3T5B40pP61dQfCJ0TxFkMrXwIQlGbNMsR5STIOuhYKj0KaV06d");
        language.setLanguageIcon("GvTKseIfkzWbFnSvX8SbM9PMzCssnahPDz61UiIQPs1i8Mu9mw");
        language.setAlpha4("C6Rc");
        language.setAlpha4parentid(6);
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("0BAMUCBfCT7yUhQCr8fOXPtDAra53Vc3YQMzYt6EsEx59C61r2");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("dGIYANEjKKiT7lllr7j5IGMsiHJGJLciM3S4jwluWmXHLKa7L2");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setDateofbirth(new java.sql.Timestamp(1460615775876l));
        corecontacts.setAge(97);
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("hFOE1TN9Ffn0XhNoKNj9ryu5QEBClHgQUqwzBTaTsXp3BSva8O");
        corecontacts.setPhoneNumber("x4mF34jeB0rsDBvhpuro");
        corecontacts.setNativeFirstName("pzuTfBEV7yy8cdXQdq7W6MTtsMTSFQTDMpDfP7nlkNbt9WuGkY");
        corecontacts.setFirstName("dww2T0ODNcw5Fez87xWiRxAqnYoP11yoWULDFagAQBbTNS7olh");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("3zRVk0r1FTMABAFhnMHovjEH45bQa4qon2vpaUZNUAtGz7r2vK");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1460615776568l));
        corecontacts.setLastName("0jdCGDXAPLMkkaR1CmB9cqFdc3R12pGU51cbwtnDi0RHJ6no3s");
        corecontacts.setNativeMiddleName("xrk2SXviQ4vmg6TMYzVtqfDinPYKJ4PjRlnZWT8mUOgj56aGA8");
        corecontacts.setMiddleName("wlbruThFTNZAxpKhhGZEG0dGZvTPCf4cxm2D4st3a5hfh6PpG1");
        corecontacts.setNativeTitle("UPOhGynJ7RW2R5KAow3icHvcizV4rjEELmLH1W2H4lTCQH3b7l");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("BpfTAt03HrJGuXl6BMBV9CuiyBf3No1AwyxbPskYRfEMHTOc4h");
        address.setAddressLabel("4U7VcYb43fN");
        address.setLatitude("VCqIyr80zKT7JDEgyojk5dZ0L4cGh0bFq1VrbRit1lH67RdUGD");
        address.setAddress1("oP7GPuAEVBJ6rdcsrSqfNIIBHun1i6QNwLYoa9Y7gYPYl6JAFw");
        address.setLongitude("6gTnaBcwigcYCmlrmkUS1jEJDhDxxNuJZk2QtMUrLKd7gmOtof");
        City city = new City();
        city.setCityName("eCh69KrCffIAUjuNeijRvbX0jIvtMHngS1C6KlYaj9Tf654CA9");
        Country country = new Country();
        country.setCountryName("FzxnVrXBfIhF8o4HVf88JV33aNEsq40OnxrXKKuqHROc4j8CyW");
        country.setCountryCode1("vNQ");
        country.setCountryFlag("9YF0IcuT4gBc7Wj9tKxlWET5km4uqvztGqGynQ2gSgptzGukhQ");
        country.setCapitalLongitude(6);
        country.setCapital("YUlIabPsaWTQXIV16WwwLJQWXMVrOHFi");
        country.setCurrencyName("9OmXNlxobphtN77LydR7wMaHlvnbVMpJSHALeE1KnAJHni39Fz");
        country.setCurrencyCode("yNi");
        country.setCountryCode2("RaQ");
        country.setIsoNumeric(711);
        country.setCapitalLatitude(3);
        country.setCurrencySymbol("kR4hQVS2p8MkTYHKqJRfp94WtTyyjCLj");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("fIePGIP1csy59nB80kHoyAapQlLRpvIt");
        state.setStateCodeChar2("gHVVPBH0GALPVN4R3RtZYhK2hoRpe8XA");
        state.setStateName("DSp2NrX6NRfS34Q08W9ivPdjyMoeHt42f6mu0Hd0L6K2hQ11Gy");
        state.setStateCapital("LhQBw7tCisqWWU4fhliV0oFuYR7JnwGmA5BPcRaUxez5TT6uS6");
        state.setStateCapitalLatitude(2);
        state.setStateFlag("XirVAfaobkDCGFEhQ2xdq7UrJq24DqtUPLPcVrAs44XUBs5V0m");
        state.setStateCode(1);
        state.setStateCapitalLongitude(7);
        state.setStateDescription("gLWmlfatqv3IoURWzpAnGXsDYhYGhB5yYApEGe3cXw9irhtQ5q");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityName("eBRML9JRIAmOJ7F27UxlQmHxVe325XM9hVXKI8kf8dxowMWbft");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCode(2);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("YfKdIM5RqXOQNOSDpGFAMLmlXyujkpe2G0otUmHYx0T6JxZotl");
        city.setCityFlag("c2enS6tKWEknJ8q49rOvEhbBwphHAoMiYjKgSBcEnopYpEBqvz");
        city.setCityCodeChar2("2spHs3BeX4HoF2vlvFtvVbJtJMBSskdm");
        city.setCityLongitude(6);
        city.setCityLatitude(7);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("i6Cc9q4YzObti04cMgMhEzKrU1YCzzUThDqpRVZX6usad9aGOt");
        addresstype.setAddressTypeDesc("BL2whI1I8OWExlqB3LM1qkcuvbjh48wkbmWAhcjHDZHvfvofoY");
        addresstype.setAddressType("Rq9plHyzAsX9EeAgpVFY2NI4lE5E1zZSIYD9sNXGeLPTg2qREd");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setAddress3("8SPJWzICaEbnOBUP0eAi8rsYcF7vIEciyzbtRS5yo1jJTQmOsH");
        address.setAddressLabel("v7dtugXsdXO");
        address.setLatitude("zVURdUzPZZ8FiHzx8Wh6pmf3RiLEL8CzuGoGKsfz1NbrsdUZzk");
        address.setAddress1("DqNkQp1NNQu1Yx4FB0DjrCEXS24AWwcpkjYZWrTCp7A60l40mA");
        address.setLongitude("JLnQghWhqg1Ggmg222vtDPv0kRwswJK0c0rG2O00KbE7ldi7Jp");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("SrcOJm");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("vxvMlLOFLr9qyHulJ6RNXq5wDPA2FxOBJog9i2tOAZt0RB6lZt");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("aLFdoFYSkG");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("909LQLDePvKkHJSp0I0JZTDUsJcivmEZn4Vw2Aev00cKAutHub");
        communicationgroup.setCommGroupName("S0zJmyaqd3zIgycLFqiWo8PuSAoCH670h6zk2Sc734D7n1KBxY");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("q3Ictnnrz2hWYQ53mxOdlZcbQeGoQ6bCOnEehOw81cG4cKHGfd");
        communicationtype.setCommTypeDescription("rcKjNBKtIpHrUXvJkUCMSGGQMb3deq8oihXLbYk492MRy8l7f5");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationtype.setCommTypeName("fctsmVzfypIkG651Hzw9a35ucMDphBBk14pDsCxBUgoZBWYbPE");
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("FUXozc5hcZ");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey());
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        Login login = new Login();
        user.setUserId(null);
        login.setUser(user);
        login.setLoginId("2XmPpLbcUXKfb0puKFa4q3gL1sTKqkTZ9P84WCYbWCYlIIDsJF");
        login.setServerAuthText("DT0eW7U1VqSf2ABl");
        login.setServerAuthImage("5K4EBWtIAznqPjoYcZpQT43RP5HJH6tq");
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setFailedLoginAttempts(2);
        login.setIsAuthenticated(true);
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setVersionId(1);
            login.setLoginId("v0d64v9ytlOmMZFMjwG7w1eBtrsel9s7ngGR9AyClW2RBsbRI6");
            login.setServerAuthText("aKPjx4I1UH5NxcvW");
            login.setServerAuthImage("5HMUmzMYZMkTnoNywKa6zk3tFkE9W63v");
            login.setFailedLoginAttempts(9);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLogin(EntityTestCriteria contraints, Login login) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "EYLPMTV6SbjqnPLuar1k3QdgKQ2zQoL9k8lnZrsHr541SrSvbKToQqpdIq0RiWNqkjwO5aSWOEGm4aDX3dGerXD9RRAvL221OMgvvoySBKD5airHeCrInzEalOmQIpuRlUKBAvGoicJydv4LGK2KjwTReE1LTgrcgTcZ96fzrDj0UdRuj7HI7PyXMytg1VGaD4AiXIKeZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "f3iiiPohQkekZkzESw65n4eDFfac3Ru4y"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "7yW22laYX9RtkdmF1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 21));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = login.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
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
