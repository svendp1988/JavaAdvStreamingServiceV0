package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DocumentaryTest {
    private static final String TITLE = "Planet Earth";

    @Test
    void documentaryConstructor() {
        Documentary testDocumentary = new Documentary(TITLE, Rating.TEENS);
        assertEquals(TITLE, testDocumentary.getTitle());
        assertEquals(Rating.TEENS, testDocumentary.getMaturityRating());
        assertEquals(Genre.DOCUMENTARY, testDocumentary.getGenre());
    }
}
