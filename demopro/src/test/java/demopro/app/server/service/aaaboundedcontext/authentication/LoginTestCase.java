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
import demopro.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import demopro.app.shared.aaaboundedcontext.authentication.Login;
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
import demopro.app.shared.organizationboundedcontext.contacts.CoreContacts;
import demopro.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
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
import demopro.app.shared.aaaboundedcontext.authentication.User;
import demopro.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import demopro.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import demopro.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import demopro.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import demopro.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import demopro.app.shared.aaaboundedcontext.authentication.PassRecovery;
import demopro.app.shared.aaaboundedcontext.authentication.Question;
import demopro.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import demopro.app.shared.aaaboundedcontext.authentication.UserData;
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
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setMiddleName("q7nvGDgDgnfljflrJlPVs5PhIitJhXT9y9QsNV868hQBP5VSoN");
        Language language = new Language();
        language.setAlpha4parentid(3);
        language.setAlpha3("4LT");
        language.setLanguage("n7C858Qex2fz4fWoBwShYP97EzKmC1etCxr7taOCND3sYuQknL");
        language.setLanguageIcon("rjAB90MCdHM1sWGDSHCe423EYLgzSLU0kuv5020y4PGUfR9APA");
        language.setLanguageDescription("XS48Sxhu7PrSKOyI2ZSvTEKIShkBZyh06AWFausVCJFBaWrBJP");
        language.setAlpha4("rega");
        language.setAlpha2("oa");
        language.setLanguageType("8X1xyIkPd3YNmEAqdgddDDZ1eQkZ9qz4");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("hRVJXtsn1DBQV4Iy0njrcBpGQ8JqnjeIxNbEbtkgUCF1bTGPxF");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("HCPa86tWx116hIqbGULXAbhUd0j6JG5BHCKr5MgVxlw27U3PYT");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("hUdtkaLZ3FL9qgLIOicHwwHULSPFT2pk8PTPtimYHzHUqiKRsg");
        timezone.setCountry("ME1uKvl4cxL7e8BGfRvL2mChNT2faw1GAGzquISoyxMrfK42tV");
        timezone.setUtcdifference(8);
        timezone.setGmtLabel("Ce5dBSHwh3lBHtxAnVTzNAVwjketLVcCbF53cDHOYP21MzlGGB");
        timezone.setCities("NmWxKYM2xrMYzbVcQJsz8eS1SuFt1fAEv5o8akv4JulU8U1zgf");
        corecontacts.setMiddleName("EyIXoHL0PiaVlmi8NTQ0FFYXhUjk346668TEXc4QBbkYFmq4FR");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1460618869787l));
        corecontacts.setDateofbirth(new java.sql.Timestamp(1460618869787l));
        corecontacts.setNativeFirstName("h3faubqNpcbhMeatzvnv69HqtMYitn5cROC3U86fG4SGqMWxTD");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setEmailId("Akn2qGHMqUFm5pCOc09SG7ANrMjcGp0oIJ3GXerBABnRRs6lk1");
        corecontacts.setNativeMiddleName("PHhHVD9KozpEpU6Bv1GrMkNphaxHE9VBn1R5LGZoAbz1h8iQdP");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setAge(85);
        corecontacts.setNativeLastName("vjboSPtgbqOEwyp33wlFxyoa5PL0KOiFKhJFyrXxQHQlITaNqU");
        corecontacts.setNativeTitle("8r3AGJI4vWzziZHgHM1fxOjDrZl0WnDZd1kJ0SHG9WDT0cxzyN");
        corecontacts.setLastName("vGz9n0cvn7VT9YzYd9r4YcErX0CEU9vZ8RvYgvARp0RB491E7Y");
        corecontacts.setFirstName("nladiGCypLoxXvnuRmRC1IJPg3CjVYNaQFbSXmjXYSt0ApKKDt");
        corecontacts.setPhoneNumber("Q9RnF6XMfdrh7tP4wiCt");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        Country country = new Country();
        country.setCountryName("jplnlBxQRoxt5ZDCinNqhGkRGtiooBYCYrVo0Cd9nS7hczgQIR");
        country.setCurrencyCode("htU");
        country.setCurrencySymbol("lD5eKZadWp2zNGa62kTbbBpPXhm7KPgC");
        country.setCountryCode1("0sg");
        country.setCountryFlag("etXEvgHdI5q57iYMc8fd4kINqCWdPckCmu7UYV5y43qlNk6Z7R");
        country.setCurrencyName("d2LTf4UIoB0eqkz3bpc4cXBRivJDJjNQXMu9FVvfzkPJavNQHf");
        country.setCountryCode2("j3L");
        country.setIsoNumeric(951);
        country.setCapitalLatitude(9);
        country.setCapital("TsNB9R6AMrMK5b79CLxi8B28MLTusxuu");
        country.setCapitalLongitude(11);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        City city = new City();
        city.setCityCode(3);
        city.setCityFlag("n024xWWjX5OS6cAMMTlMz41H85Bml7Hf2w8u1iEahQ8prXGUsd");
        city.setCityName("VTfBnCReOuMYorfAXS02rqy69KemSXBZdjLwL75N4aFcUnKS0L");
        city.setCityLatitude(3);
        city.setCityCodeChar2("tkcVVUzyBFrl48U7M4IbbnvOhSJrcBUj");
        city.setCityDescription("Z7ZoVXYTILypTmcFqEfjitxV2LQckwDea4XWMHnddu8w7oOwbi");
        city.setCityLongitude(10);
        State state = new State();
        state.setStateCode(1);
        state.setStateCapitalLatitude(11);
        state.setStateCodeChar3("IYN29pV9DcAPEoBre3VhW3aXSZr7ZTDK");
        state.setStateDescription("2QTUxVSjhIIxsomcWXR67NEvGOUgt8aaJ3Q0Yv7jdG7QF6LaOh");
        state.setStateCode(1);
        state.setStateCapitalLatitude(2);
        state.setStateCodeChar3("ZHmA902A57nP4Uod9RayQfZmguMJ0kaH");
        state.setStateDescription("3O9QnO3Qn4hzCa4iBVRWg8bJqLSeIqUR0IXgRflGhiENUsaAua");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar2("lSx4Hkmyb2BqpFPgfJRfqXacfPZecILC");
        state.setStateCapitalLongitude(1);
        state.setStateFlag("QwRppx6mic4xLP8ihsfSlNZUCcc9YVW4sNmnUL1WYx5bqnnySU");
        state.setStateName("1coX26qQFe2tZjF2Q07GIklGEybNRjpIaLsRKzliUIhFi6Nc42");
        state.setStateCapital("IQhQ4U2zGcIsRzgRPceYWIYGQNXNshsITvjPWSqP9MR0QOBaLs");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityCode(2);
        city.setCityFlag("frb65IudiRmxYaZ5DHBps6Y3rJPcT4RxzdbDBNA9oZUiVxtEW6");
        city.setCityName("f9V3MN2lpaJROqDCaKouwnVhLi5dKJZhOTs1SIQIndgEb3odsd");
        city.setCityLatitude(6);
        city.setCityCodeChar2("TIaNVYZwOCo6C75Ylqhx8A0F3LCG5skP");
        city.setCityDescription("dHF1tXY1DVuj87nH3gntbo6KC5gxgjWM2ChvW1MhhsfKQnsLn4");
        city.setCityLongitude(5);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("GmbAOvrOVtWvyoUORJ2gOm8OyINdD8z1wv6CGDnURI895SHqUm");
        addresstype.setAddressTypeDesc("5T06OXuj3kCLDDrXagFzwrXEuqbHmjfunzAMS1qSkT0wNgLFdj");
        addresstype.setAddressType("FabmmwaBsI0l00QGO8tIfQWpoaDVI0T0KgLbYTe4ZS8qTMoXV6");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("BrD5dzQSHuCqs8OVkrlpcQfMJ5a2D6vLkfSrBRnyWMWeCezK13");
        address.setAddressLabel("SIdYa7CRV62");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("7bMsbtMESf18izka96cFcznNfrtZJOSJ1Wtk11YTEe8VVLBjkN");
        address.setLongitude("A6YYGsmb77DHhrVJmVUaCRuXCWOHBRJuYCmpkmEyFSM8e6ynWG");
        address.setAddress1("z1KTe6vKk2DCGCxX29iLUJV6TQuhn2nRPb0SakJj5JDx2ZAmei");
        address.setZipcode("xqxae1");
        address.setAddress2("MZq1jEmea7Ny9i3iWxiEXTRF6vP8tPUS0WeBBlw7dcAykbgINJ");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("P3KESAtFRzNRbwkeXmWB2UzyeN03emz9WUFkIkVrkUdKLLo6Bw");
        communicationgroup.setCommGroupName("FgZq0O1Aahh4bEHXz9tnfw0Wqz8hV8eHB6WQhn7PdXioFzRKIF");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("q6AcBz4faoWHMGVkaQWKYii3Be2RnMxpHFEeM2S7hMV4S6wkYT");
        communicationtype.setCommTypeName("7SVeRDjbL3hi4xoQ0jUW7gzIYuZKRm7E5PLlGDn38VmmarWTdM");
        communicationtype.setCommTypeDescription("RqkMMMTSexUn3ce4LJeeAUlqX780EyroCUFuk7mpAFXClJXMIc");
        communicationtype.setCommTypeName("ouBPBFyxfmeYv36f409rywlrBR6dguuIwrb0BLLfo9oEcGNu88");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("4I6Bqoebbu");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        User user = new User();
        user.setMultiFactorAuthEnabled(1);
        user.setAllowMultipleLogin(1);
        user.setUserAccessCode(13245);
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("CVMlCfOFXGCi69YdwKtGMEAjA74BJG4AOTz3IiPAPNT0LH6t3v");
        useraccesslevel.setLevelDescription("jt4YIlH4TYlHROsCa2KTvosqSErKBnkTBu9YItU0xZCrc5NJiG");
        useraccesslevel.setLevelIcon("uFsP8lwC0FwjzubpLM2fhzIqKZcDRWVPzxzZv84At8x2645KRM");
        useraccesslevel.setLevelName("nI1DLrSrpMEeA2DzcENHP7Ym6gT7xsIJHxrBsGdFCTJ4dlgpc7");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainHelp("UsOg9eOKIrdp63sbn4SE1l7wnUryzHxKirJdhtZTqZOdZ8UNyX");
        useraccessdomain.setDomainName("rZIJvsgVuxRpRKsVM38DChzm5K0FHOxzGpCZUM64ncOKyAVQww");
        useraccessdomain.setDomainDescription("ZkIbUKHERynP4qpsyP9544Xg6k638qNrDjFm2mz0iFiYTXf1PM");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainIcon("c43qLHEb3AHupeH2VhjmwkY9UGdRPGJJnawMQ4UItrOxT6ShYX");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        user.setMultiFactorAuthEnabled(1);
        user.setAllowMultipleLogin(1);
        user.setUserAccessCode(21970);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setIsLocked(1);
        user.setChangePasswordNextLogin(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setPasswordExpiryDate(new java.sql.Timestamp(1460618873018l));
        user.setPasswordAlgo("grWYWQL4DYoyesw91snsNpYBDzv8hLgpHK246GzOp4f4SpvwM5");
        user.setIsDeleted(1);
        user.setGenTempOneTimePassword(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1460618873018l));
        user.setSessionTimeout(249);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionDetails("buFrbPZF8i");
        question.setQuestion("IFnGwIvWa0wp1gfKub82yWlBeuyM1kC6TqH8nG8l3gfosorIbr");
        question.setLevelid(9);
        question.setQuestionIcon("5DSaqjhycbKxl70RuwQMNtN0w0JqlJpVsef8E9qHz6pgkVTNWp");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        passrecovery.setAnswer("XCjUqyK6YcM9sQJpXAjfqLNGAglWor4qDr2yPdrLgSQsjvpk6K");
        passrecovery.setUser(user);
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordExpiry(5);
        userdata.setOneTimePasswordExpiry(5);
        userdata.setUser(user);
        userdata.setOneTimePassword("UjqT7DTyiU7cFKb2RH5ygO6eu6PVAImj");
        userdata.setLast5Passwords("vss8r9kOwdraf3yMFWCa3t0asTuolYQEYcM0KWE3mrOTNYA2LO");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1460618874330l));
        userdata.setPassword("mlEbDIzrmcyiC2X4s7XwiMkgu3xsVWC7W0dxXCzT732cm6rfTF");
        user.setUserData(userdata);
        Login login = new Login();
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setLoginId("x9D77ffFx3vss9NAW2rd4qjz0FrybIwB0BrVhuoVKxjccOJEl8");
        login.setServerAuthImage("dLqW0YYRX5fH3C3VLmSrrmrOTGX2RsgJ");
        login.setFailedLoginAttempts(9);
        login.setIsAuthenticated(true);
        user.setUserId(null);
        login.setUser(user);
        login.setServerAuthText("AiPJkVimGq3ZcJSA");
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
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setLoginId("9GaCXpSud2ces8YcXcbpJagfSlPQdehDXNQ63T67QlZFw2nts3");
            login.setServerAuthImage("M9XRMYeXaFWxzFr2HVyntQEyFYWXUMtE");
            login.setFailedLoginAttempts(4);
            login.setServerAuthText("lNGK6527vatQSHBi");
            login.setVersionId(1);
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
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
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
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "PlpTt2vh57f8kWuzv83hulYSZQaADGKylYBqPdFk3xUJVfBd134rAOwvGtC1rArJuXtKoP2O5YWKxFlLrfwmA9W5epxTAl0msZINkFoVv7elFrVeFGZsfuGstuIpUptr589d5zHvyVDF81rJYfs96pMJuU60I0qJFv3cV9RjWcYCCxWVFPb6ceYZUP8eoymxKFhfVEmrr"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "ucF3htJCajBA7ePcxco7RhakDvG8oiwpu"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "L5kZkPtJDpLykAUCq"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 18));
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
