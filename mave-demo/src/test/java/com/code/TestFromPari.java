package com.code;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestFromPari {

	@Test
	public void test() {
		MainFromDao test = new MainFromDao();
		String output=test.pari();
		assertEquals("446",output);
		
	}

	}
