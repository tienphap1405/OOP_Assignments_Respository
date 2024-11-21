package unitTests;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utilities.Iterator;
import implementations.MyStack;

/**
 * @author kitty
 * @version 3.1 Jun 6, 2024  
 * Class Description:
 * Arraylist based implementation of the StackADT defined in the CPRG 304
 * Assignment 2.
 */

public class StackTest
{
	// Attributes
	private MyStack<Integer> stack;
	private Integer one;
	private Integer two;
	private Integer three;
	private Integer four;
	private Integer five;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		stack = new MyStack<Integer>();
		one = new Integer( 111 );
		two = new Integer( 222 );
		three = new Integer( 333 );
		four = new Integer( 444 );
		five = new Integer( 555 );
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		stack = null;
		one = null;
		two = null;
		three = null;
		four = null;
		five = null;
	}

	/**
	 * Test method for {@link stackImplementation.MyStack#Stack()}.
	 */
	@Test
	public void testConstructor()
	{
		boolean expected = true;
		boolean actual = stack != null;
		assertEquals( "Stack object was not created ", expected, actual );
		assertEquals( "Size of the array was not returned correctly ", 0, stack.size() );
	}

	/**
	 * Test method for {@link stackImplementation.MyStack#clear()}.
	 */
	@Test
	public void testClear_Size()
	{
		stack.push( one );
		stack.push( two );
		stack.clear();
		
		assertEquals( "Stack size is incorrect ", 0, stack.size() );
	}

	/**
	 * Test method for
	 * {@link stackImplementation.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains_True()
	{
		boolean expected = true;
		stack.push( one );
		stack.push( two );
		stack.push( three );
		boolean actual = stack.contains( two );
		assertEquals( "Stack didn't contain the item and should have ", expected, actual );
		assertEquals( "Stack size is incorrect ", 3, stack.size() );
	}

	/**
	 * Test method for
	 * {@link stackImplementation.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains_False()
	{
		boolean expected = false;
		stack.push( one );
		stack.push( two );
		stack.push( three );
		boolean actual = stack.contains( four );
		assertEquals( "Stack contained the item and should not have ", expected, actual );
		assertEquals( "Stack size is incorrect ", 3, stack.size() );
	}

	/**
	 * Test method for
	 * {@link stackImplementation.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains_NullPointerException()
	{
		Integer empty = null;
		stack.push( one );
		stack.push( two );
		stack.push( three );
		try
		{
			stack.contains( empty );
			fail( "Contains method failed to throw NullPointerException." );
		}
		catch( NullPointerException e )
		{
			assertTrue( true );
		}
		assertEquals( "Stack size is incorrect ", 3, stack.size() );
	}

	/**
	 * Test method for
	 * {@link stackImplementation.MyStack#equals(utilities.MyStack)}.
	 */
	@Test
	public void testEquals_True()
	{
		MyStack<Integer> stack2 = new MyStack<Integer>();
		boolean expected = true;
		stack.push( one );
		stack.push( two );
		stack.push( three );

		stack2.push( one );
		stack2.push( two );
		stack2.push( three );

		boolean actual = stack.equals( stack2 );
		assertEquals( "Stacks being compared are not the same and should be ", expected, actual );
		assertEquals( "Stack size is incorrect ", 3, stack.size() );
		assertEquals( "Stack size is incorrect ", 3, stack2.size() );
	}

	/**
	 * Test method for
	 * {@link stackImplementation.MyStack#equals(utilities.MyStack)}.
	 */
	@Test
	public void testEquals_False()
	{
		MyStack<Integer> stack2 = new MyStack<Integer>();
		boolean expected = false;
		stack.push( two );
		stack.push( one );
		stack.push( three );

		stack2.push( one );
		stack2.push( two );
		stack2.push( three );

		boolean actual = stack.equals( stack2 );
		assertEquals( "Stacks being compared are the same and should not be ", expected, actual );
		assertEquals( "Stack size is incorrect ", 3, stack.size() );
		assertEquals( "Stack size is incorrect ", 3, stack2.size() );
	}

	/**
	 * Test method for {@link stackImplementation.MyStack#isEmpty()}.
	 */
	@Test
	public void testIsEmpty_True()
	{
		boolean expected = true;

		boolean actual = stack.isEmpty();
		assertEquals( "Stack is not empty and should have been ", expected, actual );
		assertEquals( "Stack size is incorrect ", 0, stack.size() );
	}

	/**
	 * Test method for {@link stackImplementation.MyStack#isEmpty()}.
	 */
	@Test
	public void testIsEmpty_False()
	{
		boolean expected = false;
		stack.push( one );
		stack.push( two );
		stack.push( three );
		boolean actual = stack.isEmpty();
		assertEquals( "Stack shows empty but should not have been ", expected, actual );
		assertEquals( "Stack size is incorrect ", 3, stack.size() );
	}


	/**
	 * Test method for {@link stackImplementation.MyStack#iterator()}.
	 */
	@Test
	public void testIterator()
	{
		int expected1 = 111;
		int expected2 = 222;
		int expected3 = 333;
		int expected4 = 444;
		int expected5 = 555;

		stack.push( one );
		stack.push( two );
		stack.push( three );
		stack.push( four );
		stack.push( five );

		Iterator<Integer> it = stack.iterator();
		int actual5 = it.next(); // kitty: flipped 1-5 to 5-1
		int actual4 = it.next();
		int actual3 = it.next();
		int actual2 = it.next();
		int actual1 = it.next();

		assertEquals( "Stack iterator contained wrong element at position 1 ", expected5, actual5 );
		assertEquals( "Stack iterator contained wrong element at position 2 ", expected4, actual4 );
		assertEquals( "Stack iterator contained wrong element at position 3 ", expected3, actual3 );
		assertEquals( "Stack iterator contained wrong element at position 4 ", expected2, actual2 );
		assertEquals( "Stack iterator contained wrong element at position 5 ", expected1, actual1 );
		assertEquals( "Stack size is incorrect ", 5, stack.size() );
	}

	/**
	 * Test method for {@link stackImplementation.MyStack#peek()}.
	 * 
	 * @throws EmptyStackException
	 */
	@Test
	public void testPeek_Top() throws EmptyStackException
	{
		int expected5 = 555;

		stack.push( one );
		stack.push( two );
		stack.push( three );
		stack.push( four );
		stack.push( five );

		int actual5 = stack.peek();
		assertEquals( "Peek did not returned correct element.", expected5, actual5 );
		assertEquals( "Stack size is incorrect ", 5, stack.size() );
	}

	/**
	 * Test method for {@link stackImplementation.MyStack#peek()}.
	 */
	@Test
	public void testPeek_Empty()
	{
		try
		{
			@SuppressWarnings( "unused" )
			// kitty: what about null ptr?
			Object value = stack.peek();
			fail( "Peek method failed to throw EmptyStackException correctly." );
		}
		catch( EmptyStackException e )
		{
			assertTrue( true );
		}
		assertEquals( "Stack size is incorrect ", 0, stack.size() );
	}

	/**
	 * Test method for {@link stackImplementation.MyStack#pop()}.
	 * 
	 * @throws EmptyStackException
	 */
	@Test
	public void testPop_Top() throws EmptyStackException
	{
		int expected5 = 555;

		stack.push( one );
		stack.push( two );
		stack.push( three );
		stack.push( four );
		stack.push( five );

		int actual5 = stack.pop();
		assertEquals( "Stack pop contained wrong element at position 1 ", expected5, actual5 );
		assertEquals( "Stack size is incorrect ", 4, stack.size() );
	}

	/**
	 * Test method for {@link stackImplementation.MyStack#pop()}.
	 */
	@Test
	public void testPop_Empty()
	{
		try
		{
			@SuppressWarnings( "unused" )
			Object value = stack.pop();
			fail( "Pop method failed to throw EmptyStackException correctly." );
		}
		catch( EmptyStackException e )
		{
			assertTrue( true );
		}
		assertEquals( "Stack size is incorrect ", 0, stack.size() );
	}

	/**
	 * Test method for {@link stackImplementation.MyStack#push(java.lang.Object)}.
	 * 
	 * @throws EmptyStackException
	 */
	@Test
	public void testPush_Top() throws EmptyStackException
	{
		stack.push( one );
		int actual = stack.peek();
		assertEquals( "Stack pushed wrong element to top of stack ", 111, actual );
		assertEquals( "Stack size is incorrect ", 1, stack.size() );

		stack.push( two );
		actual = stack.peek();
		assertEquals( "Stack pushed wrong element to top of stack ", 222, actual );
		assertEquals( "Stack size is incorrect ", 2, stack.size() );

		stack.push( three );
		actual = stack.peek();
		assertEquals( "Stack pushed wrong element to top of stack ", 333, actual );
		assertEquals( "Stack size is incorrect ", 3, stack.size() );

		stack.push( four );
		actual = stack.peek();
		assertEquals( "Stack pushed wrong element to top of stack ", 444, actual );
		assertEquals( "Stack size is incorrect ", 4, stack.size() );

		stack.push( five );
		actual = stack.peek();
		assertEquals( "Stack pushed wrong element to top of stack ", 555, actual );
		assertEquals( "Stack size is incorrect ", 5, stack.size() );
	}

	/**
	 * Test method for {@link stackImplementation.MyStack#push(java.lang.Object)}.
	 */
	@Test
	public void testPush_NullPointerException()
	{
		Integer empty = null;
		stack.push( one );
		stack.push( two );
		stack.push( three );
		try
		{
			stack.push( empty );
			fail( "Push method failed to throw NullPointerException." );
		}
		catch( NullPointerException e )
		{
			assertTrue( true );
		}
		assertEquals( "Stack size is incorrect ", 3, stack.size() );
	}

	/**
	 * Test method for {@link stackImplementation.MyStack#search(java.lang.Object)}.
	 */
	@Test
	public void testSearch_Botton()
	{
		int expected = 5;
		stack.push( one );
		stack.push( two );
		stack.push( three );
		stack.push( four );
		stack.push( five );
		assertEquals( "Stack size is incorrect ", 5, stack.size() );

		int actual = stack.search( one );
		assertEquals( "Value on the bottom of stack is incorrect ", expected, actual );
	}

	/**
	 * Test method for {@link stackImplementation.MyStack#search(java.lang.Object)}.
	 */
	@Test
	public void testSearch_Top()
	{
		int expected = 1;
		stack.push( one );
		stack.push( two );
		stack.push( three );
		stack.push( four );
		stack.push( five );
		assertEquals( "Stack size is incorrect ", 5, stack.size() );

		int actual = stack.search( five );
		assertEquals( "Value on the top of stack is incorrect ", expected, actual );
	}

	/**
	 * Test method for {@link stackImplementation.MyStack#search(java.lang.Object)}.
	 */
	@Test
	public void testSearch_Middle()
	{
		int expected = 3;
		stack.push( one );
		stack.push( two );
		stack.push( three );
		stack.push( four );
		stack.push( five );
		assertEquals( "Stack size is incorrect ", 5, stack.size() );

		int actual = stack.search( three );
		assertEquals( "Value in the middle of stack is incorrect ", expected, actual );
	}
	
	/**
	 * Test method for {@link stackImplementation.MyStack#search(java.lang.Object)}.
	 */
	@Test
	public void testSearch_NotFound()
	{
		int expected = -1;
		stack.push( one );
		stack.push( two );
		stack.push( three );

		assertEquals( "Stack size is incorrect ", 3, stack.size() );

		int actual = stack.search( five );
		assertEquals( "Search should return -1 if not found. ", expected, actual );
	}

	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	public void testSize_AddOneToEmpty()
	{
		assertEquals( "Stack size is incorrect ", 0, stack.size() );
		stack.push( one );
		assertEquals( "Stack size is incorrect ", 1, stack.size() );
	}
	
	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	public void testSize_AddMany()
	{
		stack.push( one );
		stack.push( two );
		stack.push( three );
		stack.push( four );
		stack.push( five );
		assertEquals( "Stack size is incorrect ", 5, stack.size() );
	}

	/**
	 * Test method for {@link stackImplementation.MyStack#toArray()}.
	 */
	@Test
	public void testToArray()
	{
		stack.push( one );
		stack.push( two );
		stack.push( three );

		assertEquals( "Stack size is incorrect ", 3, stack.size() );
	
		Integer[] array = new Integer[3];
		
		array[0] = three;
		array[1] = two;
		array[2] = one;

		Object[] returnArray = new Integer[3];;
		returnArray = stack.toArray();
		assertArrayEquals( "ToArray did not correctly convert list to array.", array, returnArray );
	}

	/**
	 * Test method for {@link stackImplementation.MyStack#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArray()
	{
		stack.push( one );
		stack.push( two );
		stack.push( three );

		assertEquals( "Stack size is incorrect ", 3, stack.size() );
	
		Object[] array = new Integer[3];
		
		array[0] = three;
		array[1] = two;
		array[2] = one;

		Integer[] returnArray = new Integer[3];;
		returnArray = stack.toArray( returnArray );
		assertArrayEquals( "ToArray did not correctly convert list to array.", array, returnArray );
	}
	

	/**
	 * Test method for {@link stackImplementation.MyStack#toArray(E[])}.
	 */@Test
	public void testToArrayNullArray()
	{
		Integer[] returnArray = null;
		try 
		{
			returnArray = stack.toArray(returnArray);
			fail("toArray did not throw NullPointerException.");
		} 
		catch (NullPointerException e) 
		{
			assertTrue(true);
		}
	}
}
