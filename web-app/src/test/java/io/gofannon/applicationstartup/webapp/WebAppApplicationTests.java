package io.gofannon.applicationstartup.webapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
class WebAppApplicationTests {

    @Test
    void contextLoads() {
    }

}
