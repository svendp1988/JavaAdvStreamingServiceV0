package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {
    Movie movie;

    @BeforeEach
    void init() {
        movie = new Movie("Titanic", Rating.OLDER_KIDS);
    }

    @Test
    void negativeDurationBecomesPositive() {
        // Arrange
        // Act
        movie.setDuration(-125);
        // Assert
        assertEquals(125, movie.getDuration());
    }

    @Test
    void positiveDurationStaysUnchanged() {
        // Arrange
        // Act
        movie.setDuration(125);
        // Assert
        assertEquals(125, movie.getDuration());
    }

    @Test
    void movieWithDurationTimeShorterThanLongPlayingTimeReturnsFalse() {
        // Arrange
        // Act
        movie.setDuration(Movie.LONG_PLAYING_TIME - 1);
        // Assert
        assertFalse(movie.isLongPlayingTime());
    }

    @Test
    void movieWithDurationTimeLongerThanLongPlayingTimeReturnsTrue() {
        // Arrange
        // Act
        movie.setDuration(Movie.LONG_PLAYING_TIME + 1);
        // Assert
        assertTrue(movie.isLongPlayingTime());
    }

    @Test
    void movieWithDurationTimeExactlyLongPlayingTimeReturnsTrue() {
        // Arrange
        // Act
        movie.setDuration(Movie.LONG_PLAYING_TIME);
        // Assert
        assertTrue(movie.isLongPlayingTime());
    }

    @Test
    void toStringReturnsOnlyTitleWhenNoReleaseDateGiven() {
        // Arrange
        // Act
        String actualToString = movie.toString();
        String expectedToString = movie.getTitle();
        // Assert
        assertEquals(expectedToString, actualToString);
    }

    @Test
    void toStringReturnsTitleAndReleaseDateInBracketsWhenReleaseDateGiven() {
        // Arrange
        // Act
        movie.setReleaseDate(LocalDate.of(1998, 1, 7));
        String actualToString = movie.toString();
        String expectedToString = String.format("%s (%d)", movie.getTitle(), movie.getReleaseDate().getYear());
        // Assert
        assertEquals(expectedToString, actualToString);
    }

    @Test
    public void returnsQuestionmarkWhenDurationZero() {
        movie.setDuration(0);
        assertEquals("?", movie.getPlayingTime());
    }

    @Test
    public void returnsMinutesWhenDurationLessThan60() {
        movie.setDuration(59);
        assertEquals("59 min", movie.getPlayingTime());
    }

    @Test
    public void returnsHoursWhenDurationMultipleOf60() {
        movie.setDuration(120);
        assertEquals("2 h", movie.getPlayingTime());
    }

    @Test
    public void
    returnsHoursAndMinutesWhenDurationNotMultipleOf60() {
        movie.setDuration(135);
        assertEquals("2 h 15 min", movie.getPlayingTime());
    }
}
