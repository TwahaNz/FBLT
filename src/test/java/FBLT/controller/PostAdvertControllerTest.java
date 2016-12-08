package FBLT.controller;


import FBLT.controllers.advert.PostAdvertController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * edited by luke
 * <p>
 * -----------------------------------------THIS TEST WILL ONLY RUN IF THE SERVER IS UP!!!------------------------------
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class PostAdvertControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new PostAdvertController()).build();
    }

    @Test
    public void testController() throws Exception {

        this.mockMvc.perform(post("/post-advert"))
                .andExpect(view().name("post_ad"))
                .andExpect(status().isOk()).andDo(print());


    }

}
