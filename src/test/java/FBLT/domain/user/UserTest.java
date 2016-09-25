package FBLT.domain.user;


import FBLT.utils.genericvalueobjects.ContactDetails;
import FBLT.utils.genericvalueobjects.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    User user;

    @Before
    public void setUp() throws Exception {
        user = new User.Builder()
                .userId(new Long(1))
                .contactDetails(null)
                .location(null)
                .name("Ferin")
                .rating(5)
                .build();
    }

    @Test
    public void testifTheRankingIsCorrect() throws Exception {
        // beacuse the rating is set to 5
        Assert.assertTrue(user.rank().equalsIgnoreCase("great"));
    }

    @Test
    public void testLocationValueObject() throws Exception {
        Location location = new Location.Builder()
                .city("Cape Town")
                .latitude(new Double(14566.3))
                .longitude(new Double(7899.3))
                .suburb("Northern Suburbs")
                .build();

        user = new User.Builder()
                .copy(user)
                .location(location)
                .build();

        Assert.assertTrue(user.getLocation().getCity().equalsIgnoreCase("Cape Town"));
    }

    @Test
    public void testContactDetailsVslueObject() throws Exception {
        ContactDetails contactDetails = new ContactDetails.Builder()
                .cellPhoneNumber("0810101966")
                .emailAddress("example@gmail.com")
                .build();

        user = new User.Builder()
                .copy(user)
                .contactDetails(contactDetails)
                .build();

        Assert.assertTrue(user.getContactDetails().getCellPhoneNumber().equalsIgnoreCase("0810101966"));
    }
}
