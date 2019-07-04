package com.revature.util;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;



public class LotsTest {

	public static Lots l;
	@Rule
	public ExpectedException thrown = ExpectedException.none(); // if any exception is thrown, test will fail
	
	@BeforeClass
	public static void initializeLots() {
		l = new Lots();
	}
	
	
}
