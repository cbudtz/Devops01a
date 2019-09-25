package rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GiraffeServiceTest {
    GiraffeService g = new GiraffeService();

    @Test
    void getGiraffes() {
        List<String> strings = Arrays.asList("Melman", "Eslmer");
        Assertions.assertEquals(strings, g.getGiraffes());
    }
}