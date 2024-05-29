package web.service;

import org.junit.Assert;
import org.junit.Test;

import web.service.MathQuestionService;

public class TestMathQuestionService {

	@Test
	public void testTrueAdd() {
		Assert.assertEquals(MathQuestionService.q1Addition("1", "2"), 3, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddNumber1Empty() {
		Assert.assertNull(MathQuestionService.q1Addition("", "2"));
	}	
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddNumbe2Empty() {
		Assert.assertNull(MathQuestionService.q1Addition("1",""));
	}	
	@Test(expected = IllegalArgumentException.class)
	public void testBothNumberEmptyAdd() {
		Assert.assertNull(MathQuestionService.q1Addition("",""));
	}
	@Test(expected = IllegalArgumentException.class)
    public void testBothNumberNonNumericAdd() {
        Assert.assertNull(MathQuestionService.q1Addition("abc", "xyz"));
    }
	
	//subtract
	public void testTrueSub() {
		Assert.assertEquals(MathQuestionService.q2Subtraction("3", "2"), 1, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSubNumber1Empty() {
		Assert.assertNull(MathQuestionService.q2Subtraction("", "2"));
	}	
	
	@Test(expected = IllegalArgumentException.class)
	public void testSubNumbe2Empty() {
		Assert.assertNull(MathQuestionService.q2Subtraction("1",""));
	}	
	@Test(expected = IllegalArgumentException.class)
	public void testBothNumberEmptySub() {
		Assert.assertNull(MathQuestionService.q2Subtraction("",""));
	}
	@Test(expected = IllegalArgumentException.class)
    public void testBothNumberNonNumericSub() {
        Assert.assertNull(MathQuestionService.q2Subtraction("abc", "xyz"));
    }
	
	
	//Multiply
	@Test
	public void testTrueMult() {
		Assert.assertEquals(MathQuestionService.q3Multiplication("1", "2"), 2, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testMultNumber1Empty() {
		Assert.assertNull(MathQuestionService.q3Multiplication("", "2"));
	}	
	
	@Test(expected = IllegalArgumentException.class)
	public void testMultNumbe2Empty() {
		Assert.assertNull(MathQuestionService.q3Multiplication("1",""));
	}	
	@Test(expected = IllegalArgumentException.class)
	public void testBothNumberEmptyMult() {
		Assert.assertNull(MathQuestionService.q3Multiplication("",""));
	}
	@Test(expected = IllegalArgumentException.class)
    public void testBothNumberNonNumericMult() {
        Assert.assertNull(MathQuestionService.q3Multiplication("abc", "xyz"));
    }
	
}
