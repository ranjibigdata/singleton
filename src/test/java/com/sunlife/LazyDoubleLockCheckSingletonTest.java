package com.sunlife;

import static org.junit.Assert.*;
import org.junit.Test;

public class LazyDoubleLockCheckSingletonTest {

        @Test
        public void testSingleton() {

            LazyDoubleLockCheckSingleton instance1 = LazyDoubleLockCheckSingleton.getInstance();
            LazyDoubleLockCheckSingleton instance2 = LazyDoubleLockCheckSingleton.getInstance();
            System.out.println("checking singleton objects equality");
            assertEquals(true, instance1==instance2);

        }
}
