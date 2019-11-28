package ch.mike.testing.prime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.assertj.core.api.Assertions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class PrimeControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private PrimeService primeService;

    @BeforeEach
    public void setUp() {
        given(primeService.isPrime(7)).willReturn(true);
        given(primeService.isPrime(0)).willReturn(false);
        given(primeService.isPrime(-1)).willReturn(false);
        given(primeService.isPrime(1)).willReturn(false);

        given(primeService.getPrimesUntil(11)).willReturn(Arrays.asList(2, 3, 5, 7));
        given(primeService.getPrimesUntil(1)).willReturn(Arrays.asList());
        given(primeService.getPrimesUntil(0)).willReturn(Arrays.asList());
        given(primeService.getPrimesUntil(-1)).willReturn(Arrays.asList());
    }

    @Test
    public void primesUntil() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.get("/primes/{maxNumber}", 11)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[3]").value(7));

        verify(primeService, times(1)).getPrimesUntil(11);
    }

    @Test
    void isPrime() {
    }

    @Test
    void getFibonacciSequence() {
    }

    @Test
    void getFibonacciSequenceCount() {
    }
}