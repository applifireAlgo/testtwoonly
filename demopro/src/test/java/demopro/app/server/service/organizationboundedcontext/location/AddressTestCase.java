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
import demopro.app.server.repository.organizationboundedcontext.location.AddressRepository;
import demopro.app.shared.organizationboundedcontext.location.Address;
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
import demopro.app.shared.organizationboundedcontext.location.City;
import demopro.app.server.repository.organizationboundedcontext.location.CityRepository;
import demopro.app.shared.organizationboundedcontext.location.State;
import demopro.app.server.repository.organizationboundedcontext.location.StateRepository;
import demopro.app.shared.organizationboundedcontext.location.AddressType;
import demopro.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase extends EntityTestCriteria {

    @Autowired
    private AddressRepository<Address> addressRepository;

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

    private Address createAddress(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Country country = new Country();
        country.setCountryName("s7NMUK11ZmKk4UaLfiGAhxtiuUA9HoRaVLLrf5t90G0Ah5b57q");
        country.setCurrencyCode("T3w");
        country.setCurrencySymbol("AO7MVZlqIirRj2tSOgDlVDfyu7weR6iw");
        country.setCountryCode1("ZLD");
        country.setCountryFlag("fuORQhvpO4QtbVjVcWys0rta7nlvqtLwmpgxho7WyKjLL72U3d");
        country.setCurrencyName("j8HqBIclSJmOJrkYcmHAoNNK9568sAUX4LDEtnAwZRwrf2jq0T");
        country.setCountryCode2("0pD");
        country.setIsoNumeric(745);
        country.setCapitalLatitude(1);
        country.setCapital("RxYixgesbjVDYzTeLS18d8WSqlzWy12V");
        country.setCapitalLongitude(5);
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        City city = new City();
        city.setCityCode(1);
        city.setCityFlag("7cRvaSWFbeG2bZc2b0JQzlSjYJip3XKid8dSH42Q2d3mEdvUZ5");
        city.setCityName("xhOCdhEsajvDDF3j7pUGFv6ITDSEFH7Qg9N8hHhJFw09O26KzC");
        city.setCityLatitude(11);
        city.setCityCodeChar2("1tLd0VTbUWoFvfJG21EJGjOsQYpTXpJt");
        city.setCityDescription("tXuBvmt8iJdnZLN6l6gCho3HG3usFKMD90ywOhOCEPBRbh0EG8");
        city.setCityLongitude(4);
        State state = new State();
        state.setStateCode(1);
        state.setStateCapitalLatitude(4);
        state.setStateCodeChar3("wEuo8pQtzgdmK4xSrnPIDmr45DDT7LXA");
        state.setStateDescription("QQUnhM2m6fTyqEUzbsY65m36VnmvwuehdUdWFDxabbXVtSg6td");
        state.setStateCode(2);
        state.setStateCapitalLatitude(3);
        state.setStateCodeChar3("bEkz3M0BFBltpluOjSiSUzq6PIDOKXJf");
        state.setStateDescription("ZDFGYlsJrAwRVQCoT3dpQUE5WRHOqCss8Lnl0dHhNpcIxUJNOs");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar2("vxMVk0ptwmdueYfFGQA9XCN5UnO2XooK");
        state.setStateCapitalLongitude(9);
        state.setStateFlag("23PBKjovYUFRE7kJQoxu8D44bsxSpBuMbYgtSyLxVm9AeKmYao");
        state.setStateName("aRa6ZbfCWAwcu955waWAwChSzZ4NvYD1Bfq1yvgEeqEPEjaaOx");
        state.setStateCapital("JlvSwU0knQMZwcVIZiv0ZaPSfWYVAgTwOJ2qSpXeEuknTb8P4z");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityCode(2);
        city.setCityFlag("1M8DFh7gnvqOFs3Rrlbd2rl9qTHEXWATvjGcVmVPuHMGpxNGHw");
        city.setCityName("Q4wMZMeSLrQS0leT0k0dgS9Qspr73zlKNUo1KfhtvqKUm8Saw6");
        city.setCityLatitude(6);
        city.setCityCodeChar2("NgJ7ilhrWfmeVm70RufapSmTtgoogh6i");
        city.setCityDescription("FjQJhfBvHkN9eB5R5lbECQC9sfEQciLIRj5iaxOU8EcDoKOw02");
        city.setCityLongitude(10);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("lKUF0NC9syO07XPjvQrDRXTusah0MTFaiO0vV1xoUWn6iZseHI");
        addresstype.setAddressTypeDesc("BfrO6LOLnItQsySm8xmuaTjrq6nqLYKGmPLSLRDlnChsPgDHe0");
        addresstype.setAddressType("g3SAlsFKagTOA81LjXhB31OVmL8kuCOexC1Ae9uiHb7lWMT0id");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Address address = new Address();
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("DmPJyn9W4gQGbUNrd0cUlH7Nhr0Rvuu5xwnQMTPpObhCDjSteW");
        address.setAddressLabel("HHtjaD7VKTj");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("hzXQMb9EYsqFZcmpye5YqMs6v8EPu0ZTputCB0H8s5mKzmTb0V");
        address.setLongitude("wiqM3QqKncuY4c8sL7r8LTudXws7ev7qHICLz5RwZjpMA0bIfs");
        address.setAddress1("rG2tLN3LjZf4Y45yWB0cUtXYo9yFMcV1FgnPcN1VcePAIyQYqh");
        address.setZipcode("9fqu2E");
        address.setAddress2("apbFyFM4vJIw2uzbb4Ez5dQjMJxkaM8PSQIG6bot4R2sjanWZD");
        address.setStateId((java.lang.String) StateTest._getPrimarykey());
        address.setEntityValidator(entityValidator);
        return address;
    }

    @Test
    public void test1Save() {
        try {
            Address address = createAddress(true);
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setLatitude("EY4gngXmeB5ojtCQL2TPDCYd1xV0ni6L2GAstfDmlSftMy2xFc");
            address.setAddressLabel("P5Zpl3f4kZ8");
            address.setVersionId(1);
            address.setAddress3("7y0bNjCWGtlLH2DtEmLsgCOyWIz4WPm6gewXV4WCiVRJWQ3mNd");
            address.setLongitude("iQRNHLN1X5AWeJR09WkIRCrJhY9Sj7LNa5woxQyGjvw7g3bcjC");
            address.setAddress1("e4l61iE36cEW0ItzBlvJrsfpGtrKCyYM3YTsrsAvuWeZ4RsdHK");
            address.setZipcode("gEuj9c");
            address.setAddress2("5zALMEsFcKvwqFtSRnCEvU5LoJvd2LT1QIQVc3sP4UaIktetK0");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddress(EntityTestCriteria contraints, Address address) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            address.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            address.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            address.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            addressRepository.save(address);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "ZgPzrk8UkpjT"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "LXmRMkXuygTnHdx8QFYaCLXWO1drGux1D43yvfXN5VztrBVNX7hOb1HoZ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "pzr1orxy7D3FjqufYgcDc9XOIL4yYHlAZq1EF0WQjbpPQptvmsNkEAsGI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "7qYMUt2Dz2PN4KeDnp3RUwNWbZZD0y34wRIYpNeyx0xQN58EOMuj5Eu0K"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "HVqtZsD"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "sJV4sJI1P6G9rpN05pqm5UDPDmND2BvSEwW6L0AHnfrAbqdmkyAaL0MiNIuQ2jKyB"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "Kbmm6WIvGU7ET7B06JvXwFSNmhhr3aVd0Y707IFSnuqS3AGNIcHXwm6XuEojBhcwh"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Address address = createAddress(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = address.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        address.setAddressLabel(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 2:
                        address.setAddress1(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 3:
                        address.setAddress2(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 4:
                        address.setAddress3(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(address, null);
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 6:
                        address.setZipcode(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 7:
                        address.setLatitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 8:
                        address.setLongitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
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
