package be.pxl.ja.streamingservice.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilTest {
    @Test
    void passwordShorterThan6CharactersReturns0() {
        assertEquals(0, PasswordUtil.calculateStrength("abc"));
    }

    @Test
    void passwordWith7CharactersReturns3() {
        assertEquals(3, PasswordUtil.calculateStrength("abcdefg"));
    }

    @Test
    void passwordWith7CharactersAndANumberReturns5() {
        assertEquals(5, PasswordUtil.calculateStrength("abcdefg1"));
    }

    @Test
    void passwordWith7CharactersAndANumberAndACapitalReturns7() {
        assertEquals(7, PasswordUtil.calculateStrength("Abcdefg1"));
    }

    @Test
    void passwordWith7CharactersAndANumberAndASpecialCharacterReturns7() {
        assertEquals(7, PasswordUtil.calculateStrength("abcd!efg1"));
    }
}
