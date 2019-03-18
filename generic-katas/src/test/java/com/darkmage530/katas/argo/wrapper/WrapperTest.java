package com.darkmage530.katas.argo.wrapper;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static com.darkmage530.katas.argo.wrapper.Wrapper.wrap;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * User: Jon
 * Date: 7/25/13
 * Time: 7:36 PM
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({WrapperTest.DegenerateTests.class, WrapperTest.WrapWordsTest.class,
        WrapperTest.SplitWordTests.class, WrapperTest.WrapTwoWords.class})
public class WrapperTest {

    @Ignore //No longer needed, bad tests
    public static class DegenerateTests {

        @Test
        public void emptyString() throws Exception {
            assertThat(wrap("", 1), equalTo(""));
        }

        @Test
        public void stringShorterThanCol() throws Exception {
            assertThat(wrap("this", 10), equalTo("this"));
        }
    }

    @Ignore //No longer being needed, bad tests
    public static class WrapWordsTest {

        @Test
        public void testwrapTwoWordsAfterSpace() throws Exception {
            assertThat(wrap("word word", 6), equalTo("word\nword"));
        }

        @Test
        public void testwrapThreeWordsAfterFirstSpace() throws Exception {
            assertThat(wrap("word word word", 6), equalTo("word\nword\nword"));
        }

        @Test
        public void testwrapThreeWordsAfterSecondSpace() throws Exception {
            assertThat(wrap("word word word", 11), equalTo("word word\nword"));
        }
    }

    public static class SplitWordTests {
        @Test
        public void testsplitOneWord() throws Exception {
            assertThat(wrap("word", 2), equalTo("wo\nrd"));
        }

        @Test
        public void testsplitOneWordManyTimes() throws Exception {
            assertThat(wrap("abcdefghij", 3), equalTo("abc\ndef\nghi\nj"));
        }
    }

    public static class WrapTwoWords {
        @Test
        public void testwrapOnWordBoundary() throws Exception {
            assertThat(wrap("word word", 5), equalTo("word\nword"));
        }

        @Test
        public void testwrapAfterWordBoundary() throws Exception {
            assertThat(wrap("word word", 6), equalTo("word\nword"));
        }

        @Test
        public void testwrapWellBeforeWordBoundary() throws Exception {
            assertThat(wrap("word word", 3), equalTo("wor\nd\nwor\nd"));
        }

        @Test
        public void testwrapJustBeforeWordBoundary() throws Exception {
            assertThat(wrap("word word", 4), equalTo("word\nword"));
        }

    }

}