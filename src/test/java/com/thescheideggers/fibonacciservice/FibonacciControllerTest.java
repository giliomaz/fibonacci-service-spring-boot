/*
 * _=_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_=
 * Fibonacci Service
 * _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
 * Copyright (C) 2014 - 2017 Coffeehouse Consultants
 * _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_=_
 */
package com.thescheideggers.fibonacciservice;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.logging.Logger;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.CONTENT_ENCODING;
import static org.springframework.http.MediaType.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * This is the Known Answer Test (KAT) for the Fibonacci Service.
 *
 * @author <a href="mailto:William.Scheidegger@GMail.com?subject=FibonacciControllerTest%20JavaDoc">William Scheidegger</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FibonacciControllerTest {
    /**
     * Class name.
     */
    private static final String CLASS_NAME = FibonacciControllerTest.class.getName();
    /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);

    private static final String HTML_HEADER_STRING = "<html><body>";
    private static final String HTML_FOOTER_STRING = "</body></html>";
    private static final String KAT_05_STRING = "0 1 1 2 3";
    private static final String KAT_93_STRING = KAT_05_STRING + " 5 8 13 21 34 55 89 144 233 377 "
            + "610 987 1597 2584 4181 6765 10946 17711 28657 46368 "
            + "75025 121393 196418 317811 514229 832040 1346269 2178309 "
            + "3524578 5702887 9227465 14930352 24157817 39088169 63245986 "
            + "102334155 165580141 267914296 433494437 701408733 1134903170 "
            + "1836311903 2971215073 4807526976 7778742049 12586269025 "
            + "20365011074 32951280099 53316291173 86267571272 139583862445 "
            + "225851433717 365435296162 591286729879 956722026041 1548008755920 "
            + "2504730781961 4052739537881 6557470319842 10610209857723 "
            + "17167680177565 27777890035288 44945570212853 72723460248141 "
            + "117669030460994 190392490709135 308061521170129 498454011879264 "
            + "806515533049393 1304969544928657 2111485077978050 3416454622906707 "
            + "5527939700884757 8944394323791464 14472334024676221 23416728348467685 "
            + "37889062373143906 61305790721611591 99194853094755497 160500643816367088 "
            + "259695496911122585 420196140727489673 679891637638612258 1100087778366101931 "
            + "1779979416004714189 2880067194370816120 4660046610375530309 7540113804746346429";
    private static final String ERR_MSG_NEG = "Length was less than 1. [-1]";
    private static final String ERR_MSG_POS = "Length was greater than 93. [94]";
    private static final String ERR_MSG_NON = "Length was unparseable. [%s]";
    private static final long[] KAT_05_ARRAY = new long[]{0L, 1L, 1L, 2L, 3L};
    private static final long[] KAT_93_ARRAY = new long[]{
            0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L, 55L, 89L, 144L, 233L, 377L,
            610L, 987L, 1597L, 2584L, 4181L, 6765L, 10946L, 17711L, 28657L, 46368L,
            75025L, 121393L, 196418L, 317811L, 514229L, 832040L, 1346269L, 2178309L,
            3524578L, 5702887L, 9227465L, 14930352L, 24157817L, 39088169L, 63245986L,
            102334155L, 165580141L, 267914296L, 433494437L, 701408733L, 1134903170L,
            1836311903L, 2971215073L, 4807526976L, 7778742049L, 12586269025L,
            20365011074L, 32951280099L, 53316291173L, 86267571272L, 139583862445L,
            225851433717L, 365435296162L, 591286729879L, 956722026041L, 1548008755920L,
            2504730781961L, 4052739537881L, 6557470319842L, 10610209857723L,
            17167680177565L, 27777890035288L, 44945570212853L, 72723460248141L,
            117669030460994L, 190392490709135L, 308061521170129L, 498454011879264L,
            806515533049393L, 1304969544928657L, 2111485077978050L, 3416454622906707L,
            5527939700884757L, 8944394323791464L, 14472334024676221L, 23416728348467685L,
            37889062373143906L, 61305790721611591L, 99194853094755497L, 160500643816367088L,
            259695496911122585L, 420196140727489673L, 679891637638612258L, 1100087778366101931L,
            1779979416004714189L, 2880067194370816120L, 4660046610375530309L, 7540113804746346429L
    };


    /**
     * The Spring provided Mock of a Boot Container.
     */
    @Autowired
    private MockMvc mockMvc;


    public FibonacciControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getFibonacciString method of class FibonacciController with Zero args and expecting HTML.
     */
    @Test
    @Ignore
    public void testGetFibonacciString_HTML_Zero() throws Exception {
        LOGGER.finest("Starting...");
        final String expResult = HTML_HEADER_STRING + KAT_93_STRING + HTML_FOOTER_STRING;
        this.mockMvc.perform(
                get("/fibonacci").header(ACCEPT, TEXT_HTML_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expResult));
        LOGGER.finest("Finished.");
    }

    /**
     * Test of getFibonacciString method of class FibonacciController with Zero args and expecting XML.
     */
    @Test
    public void testGetFibonacciString_XML_Zero() throws Exception {
        LOGGER.finest("Starting...");
        this.mockMvc.perform(
                get("/fibonacci").header(ACCEPT, APPLICATION_XML_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
                // TODO: FIX_THIS
                //.andExpect(xpath("//value").string(KAT_93_STRING));
                //.andExpect(xpath("/*/value").string(KAT_93_STRING));
                //.andExpect(xpath("/FibonacciResponseString/value").string(KAT_93_STRING));
                //.andExpect(xpath("FibonacciResponseString/value").string(KAT_93_STRING));
                //.andExpect(xpath("/FibonacciResponse/value").string(KAT_93_STRING));
                //.andExpect(xpath("FibonacciResponse/value").string(KAT_93_STRING));
        LOGGER.finest("Finished.");
    }

    /**
     * Test of getFibonacciString method of class FibonacciController with Zero args and expecting JSON.
     */
    @Test
    public void testGetFibonacciString_JSON_Zero() throws Exception {
        LOGGER.finest("Starting...");
        this.mockMvc.perform(
                get("/fibonacci").header(ACCEPT, APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(KAT_93_STRING));
        LOGGER.finest("Finished.");
    }

    /**
     * Test of getFibonacciString method of class FibonacciController with a Positive arg and expecting HTML.
     */
    @Test
    @Ignore
    public void testGetFibonacciString_HTML_Positive() throws Exception {
        LOGGER.finest("Starting...");
        final String expResult = HTML_HEADER_STRING + KAT_05_STRING + HTML_FOOTER_STRING;
        this.mockMvc.perform(
                get("/fibonacci/5").header(ACCEPT, TEXT_HTML_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expResult));
        LOGGER.finest("Finished.");
    }

    /**
     * Test of getFibonacciString method of class FibonacciController with a Positive arg and expecting XML.
     */
    @Test
    public void testGetFibonacciString_XML_Positive() throws Exception {
        LOGGER.finest("Starting...");
        this.mockMvc.perform(
                get("/fibonacci/5").header(ACCEPT, APPLICATION_XML_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
                // TODO: FIX_THIS
                //.andExpect(xpath("/*/value").string(KAT_05_STRING));
        LOGGER.finest("Finished.");
    }

    /**
     * Test of getFibonacciString method of class FibonacciController with a Positive arg and expecting JSON.
     */
    @Test
    public void testGetFibonacciString_JSON_Positive() throws Exception {
        LOGGER.finest("Starting...");
        this.mockMvc.perform(
                get("/fibonacci/5").header(ACCEPT, APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(KAT_05_STRING));
        LOGGER.finest("Finished.");
    }

    /**
     * Test of getFibonacciString method of class FibonacciController with a Negative arg and expecting HTML.
     */
    @Test
    @Ignore
    public void testGetFibonacciString_HTML_Negative() throws Exception {
        LOGGER.finest("Starting...");
        final String expResult = HTML_HEADER_STRING + ERR_MSG_NEG + HTML_FOOTER_STRING;
        this.mockMvc.perform(
                get("/fibonacci/-1").header(ACCEPT, TEXT_HTML_VALUE))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(content().string(expResult));
        LOGGER.finest("Finished.");
    }

    /**
     * Test of getFibonacciString method of class FibonacciController with a Negative arg and expecting XML.
     */
    @Test
    public void testGetFibonacciString_XML_Negative() throws Exception {
        LOGGER.finest("Starting...");
        this.mockMvc.perform(
                get("/fibonacci/-1").header(ACCEPT, APPLICATION_XML_VALUE))
                .andDo(print())
                .andExpect(status().isForbidden());
                // TODO: FIX_THIS
                //.andExpect(xpath("/*/value").string(ERR_MSG_NEG));
        LOGGER.finest("Finished.");
    }

    /**
     * Test of getFibonacciString method of class FibonacciController with a Negative arg and expecting JSON.
     */
    @Test
    public void testGetFibonacciString_JSON_Negative() throws Exception {
        LOGGER.finest("Starting...");
        this.mockMvc.perform(
                get("/fibonacci/-1").header(ACCEPT, APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.value").value(ERR_MSG_NEG));
        LOGGER.finest("Finished.");
    }

    /**
     * Test of getFibonacciString method of class FibonacciController with a non-numeric arg and expecting JSON.
     */
    @Test
    @Ignore
    public void testGetFibonacciString_JSON_NonNumeric() throws Exception {
        LOGGER.finest("Starting...");
        this.mockMvc.perform(
                get("/fibonacci/five").header(ACCEPT, APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.value").value(String.format(ERR_MSG_NON, "five")));
        LOGGER.finest("Finished.");
    }

    /**
     * Test of getFibonacciArray method of class FibonacciController with Zero args and expecting XML.
     */
    @Test
    @Ignore
    public void testGetFibonacciArray_XML_Zero() throws Exception {
        LOGGER.finest("Starting...");
        this.mockMvc.perform(
                get("/fibonacciArray").header(ACCEPT, APPLICATION_XML_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(xpath("/*/value").string(KAT_93_STRING));
        LOGGER.finest("Finished.");
    }

    /**
     * Test of getFibonacciArray method of class FibonacciController with Zero args and expecting JSON.
     */
    @Test
    public void testGetFibonacciArray_JSON_Zero() throws Exception {
        LOGGER.finest("Starting...");
        final ResultActions actions = this.mockMvc.perform(
                get("/fibonacciArray").header(ACCEPT, APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
        for (int i = 0; i < KAT_93_ARRAY.length; ++i) {
            actions.andExpect(jsonPath("$.value[" + i + "]").value(KAT_93_ARRAY[i]));
        }
        LOGGER.finest("Finished.");
    }

    /**
     * Test of putFibonacciString method of class FibonacciController with a Positive arg and expecting XML.
     */
    @Test
    @Ignore
    public void testPutFibonacciString_XML_Positive() throws Exception {
        LOGGER.finest("Starting...");
        final FibonacciRequest request = new FibonacciRequest(5);
        this.mockMvc.perform(
                put("/fibonacci", request)
                        .header(CONTENT_ENCODING, APPLICATION_OCTET_STREAM_VALUE)
                        .header(ACCEPT, APPLICATION_XML_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
                // TODO: FIX_THIS
                //.andExpect(xpath("/*/value").string(KAT_05_STRING));
        LOGGER.finest("Finished.");
    }

    /**
     * Test of putFibonacciString method of class FibonacciController with a Positive arg and expecting JSON.
     */
    @Test
    @Ignore
    public void testPutFibonacciString_JSON_Positive() throws Exception {
        LOGGER.finest("Starting...");
        final FibonacciRequest request = new FibonacciRequest(5);
        this.mockMvc.perform(
                put("/fibonacci", request)
                        .header(CONTENT_ENCODING, APPLICATION_OCTET_STREAM_VALUE)
                        .header(ACCEPT, APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.value").value(KAT_05_STRING));
        LOGGER.finest("Finished.");
    }

    /**
     * Test of putFibonacciString method of class FibonacciController with a Negative arg and expecting XML.
     */
    @Test
    @Ignore
    public void testPutFibonacciString_XML_Negative() throws Exception {
        LOGGER.finest("Starting...");
        final FibonacciRequest request = new FibonacciRequest(-1);
        this.mockMvc.perform(
                put("/fibonacci", request)
                        .header(CONTENT_ENCODING, APPLICATION_OCTET_STREAM_VALUE)
                        .header(ACCEPT, APPLICATION_XML_VALUE))
                .andDo(print())
                .andExpect(status().isForbidden());
                // TODO: FIX_THIS
                //.andExpect(xpath("/*/value").string(ERR_MSG_NEG));
        LOGGER.finest("Finished.");
    }

    /**
     * Test of putFibonacciString method of class FibonacciController with a Negative arg and expecting JSON.
     */
    @Test
    @Ignore
    public void testPutFibonacciString_JSON_Negative() throws Exception {
        LOGGER.finest("Starting...");
        final FibonacciRequest request = new FibonacciRequest(-1);
        this.mockMvc.perform(
                put("/fibonacci", request)
                        .header(CONTENT_ENCODING, APPLICATION_OCTET_STREAM_VALUE)
                        .header(ACCEPT, APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.error").value(ERR_MSG_NEG));
        LOGGER.finest("Finished.");
    }

    /**
     * Test of putFibonacciArray method of class FibonacciController with a Positive arg and expecting XML.
     */
    @Test
    @Ignore
    public void testPutFibonacciArray_XML_Positive() throws Exception {
        LOGGER.finest("Starting...");
        final FibonacciRequest request = new FibonacciRequest(5);
        this.mockMvc.perform(
                put("/fibonacciArray", request)
                        .header(CONTENT_ENCODING, APPLICATION_OCTET_STREAM_VALUE)
                        .header(ACCEPT, APPLICATION_XML_VALUE))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(xpath("/*/value").string(KAT_05_STRING));
        LOGGER.finest("Finished.");
    }

    /**
     * Test of putFibonacciArray method of class FibonacciController with a Positive arg and expecting JSON.
     */
    @Test
    @Ignore
    public void testPutFibonacciArray_JSON_Positive() throws Exception {
        LOGGER.finest("Starting...");
        final FibonacciRequest request = new FibonacciRequest(5);
        final ResultActions actions = this.mockMvc.perform(
                put("/fibonacciArray", request)
                        .header(CONTENT_ENCODING, APPLICATION_OCTET_STREAM_VALUE)
                        .header(ACCEPT, APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
        for (int i = 0; i < KAT_05_ARRAY.length; ++i) {
            actions.andExpect(jsonPath("$.value[" + i + "]").value(KAT_05_ARRAY[i]));
        }
        LOGGER.finest("Finished.");
    }

    /**
     * Test of putFibonacciArray method of class FibonacciController with a Negative arg and expecting XML.
     */
    @Test
    @Ignore
    public void testPutFibonacciArray_XML_Negative() throws Exception {
        LOGGER.finest("Starting...");
        final FibonacciRequest request = new FibonacciRequest(-1);
        this.mockMvc.perform(
                put("/fibonacciArray", request)
                        .header(CONTENT_ENCODING, APPLICATION_OCTET_STREAM_VALUE)
                        .header(ACCEPT, APPLICATION_XML_VALUE))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(xpath("/*/value").string(ERR_MSG_NEG));
        LOGGER.finest("Finished.");
    }

    /**
     * Test of putFibonacciArray method of class FibonacciController with a Negative arg and expecting JSON.
     */
    @Test
    @Ignore
    public void testPutFibonacciArray_JSON_Negative() throws Exception {
        LOGGER.finest("Starting...");
        final String expResult = "Length was less than 1. [-1]";
        final FibonacciRequest request = new FibonacciRequest(-1);
        this.mockMvc.perform(
                put("/fibonacciArray", request)
                        .header(CONTENT_ENCODING, APPLICATION_OCTET_STREAM_VALUE)
                        .header(ACCEPT, APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$.error").value(expResult));
        LOGGER.finest("Finished.");
    }
}
