package com.saucedemo.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasspathResource("features")
public class TestRunner {

    @BeforeAll
    public static void setup() {

    }
}