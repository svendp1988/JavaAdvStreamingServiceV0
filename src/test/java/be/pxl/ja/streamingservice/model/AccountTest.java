package be.pxl.ja.streamingservice.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    ObjectMapper mapper = new ObjectMapper();

    @Test
    void whenCreatingAccountFirstProfileIsProfile1() throws JsonProcessingException {
        Account account = new Account("test", "test");
        Profile expectedProfile = new Profile("profile1");
        Profile actualProfile = (account.getFirstProfile());
        assertEquals(mapper.writeValueAsString(expectedProfile), mapper.writeValueAsString(actualProfile));
    }
}
