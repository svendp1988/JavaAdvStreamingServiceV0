package be.pxl.ja.streamingservice.model;

import be.pxl.ja.streamingservice.exception.InvalidDateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {
    Profile profile;
    @BeforeEach
    void init() {
        profile = new Profile("Test", LocalDate.of(2016, 6, 20));
    }

    @Test
    void allowedToWatchReturnsFalseWhenTooYoungForContent() {
        // Arrange
        // Act
        // Assert
        assertFalse(profile.allowedToWatch(new Movie("Test", Rating.MATURE)));
    }

    @Test
    void allowedToWatchReturnsTrueWhenOldEnoughForContent() {
        // Arrange
        // Act
        // Assert
        assertTrue(profile.allowedToWatch(new Movie("Test", Rating.LITTLE_KIDS)));
    }

    @Test
    void dateOfBirthInFutureThrowsInvalidDateException() {
        assertThrows(InvalidDateException.class, () -> {
            new Profile("Test", LocalDate.now().plusYears(1));
        });
    }
}
