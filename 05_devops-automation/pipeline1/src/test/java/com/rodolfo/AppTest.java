package com.rodolfo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testSuma() {
        assertEquals(5, App.sumar(2, 3), "La suma debe ser 5");
    }
}

