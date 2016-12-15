package FBLT.controller.user;

import FBLT.controllers.advert.AdvertController;
import FBLT.domain.user.User;
import FBLT.utils.genericvalueobjects.ContactDetails;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.ExpectedCount.manyTimes;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by tayfer01 on 12/15/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new AdvertController()).build();
    }

    @Test
    public void userProfile() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        MockRestServiceServer server = MockRestServiceServer.bindTo(restTemplate).build();

        server.expect(manyTimes(), requestTo("/user-profile")).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{ \"email\" : \"ferintaylor@gmail.com\"}", MediaType.APPLICATION_JSON));
        User user = restTemplate.getForObject("/user-profile", User.class);
        server.verify();

        Assert.assertNotNull(user);
    }

    @Test
    public void updateProfile() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        MockRestServiceServer server = MockRestServiceServer.bindTo(restTemplate).build();

        server.expect(manyTimes(), requestTo("/user-profile-update")).andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess("{ \"email\" : \"ferintaylor@gmail.com\"}", MediaType.APPLICATION_JSON));
        User user = restTemplate.getForObject("/user-profile-update", User.class);
        server.verify();

        Assert.assertNotNull(user);
    }
}
