package com.bbb.mySamples;

import org.easymock.*;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(EasyMockRunner.class)
public class StrictlyMock extends EasyMockSupport {

//        @Rule
//        public EasyMockRule mocks = new EasyMockRule(this);

    @Mock(type = MockType.STRICT)
    ServiceOne serviceOne;

    @Mock(type = MockType.DEFAULT)
    ServiceTwo serviceTwo;

    @TestSubject()
    private final ClassTested classUnderTest = new ClassTested();

    @Test
    public void testExpectedException() {
        serviceOne.service_1();
        serviceOne.service_2();

        serviceTwo.service_2();
        serviceTwo.service_1();

        replayAll();

        classUnderTest.serviceOne_1();
        classUnderTest.serviceOne_2();

        classUnderTest.serviceTwo_1();
        classUnderTest.serviceTwo_2();

        verifyAll();
    }

}