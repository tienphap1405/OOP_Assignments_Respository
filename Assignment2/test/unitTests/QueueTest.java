package unitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.EmptyQueueException;
import utilities.Iterator;
import implementations.MyQueue;

/**
 * @author kitty
 * @version 3.1 Jun 6, 2024  
 * Class Description:
 * DLL based implementation of the QueueADT defined in the CPRG 304
 * Assignment 2.
 */

public class QueueTest
{
	// Attributes
	private MyQueue<Integer> queue;
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
		queue = new MyQueue<Integer>();
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
		queue = null;
		one = null;
		two = null;
		three = null;
		four = null;
		five = null;
	}

	/**
	 * Test method for {@link queueImplementation.MyQueue#Queue()}.
	 */
	@Test
	public void testConstructor()
	{
		boolean expected = true;
		boolean actual = queue != null;
		assertEquals( "Queue object was not created ", expected, actual );
	}

	/**
	 * Test method for {@link queueImplementation.MyQueue#clear()}.
	 */
	@Test
	public void testDequeueAll_Size()
	{
		queue.enqueue( one );
		queue.enqueue( two );
		queue.dequeueAll();
		
		assertEquals( "Queue size is incorrect ", 0, queue.size() );
	}

	/**
	 * Test method for
	 * {@link queueImplementation.MyQueue#equals(utilities.QueueADT)}.
	 */
	@Test
	public void testEquals_True()
	{
		MyQueue<Integer> queue2 = new MyQueue<Integer>();
		boolean expected = true;
		queue.enqueue( one );
		queue.enqueue( two );
		queue.enqueue( three );

		queue2.enqueue( one );
		queue2.enqueue( two );
		queue2.enqueue( three );

		boolean actual = queue.equals( queue2 );
		assertEquals( "Queues being compared are not the same and should be ", expected, actual );
	}

	/**
	 * Test method for
	 * {@link queueImplementation.MyQueue#equals(utilities.QueueADT)}.
	 */
	@Test
	public void testEquals_False()
	{
		MyQueue<Integer> queue2 = new MyQueue<Integer>();
		boolean expected = false;
		queue.enqueue( two );
		queue.enqueue( one );
		queue.enqueue( three );

		queue2.enqueue( one );
		queue2.enqueue( two );
		queue2.enqueue( three );

		boolean actual = queue.equals( queue2 );
		assertEquals( "Queues being compared are the same and should not be ", expected, actual );
		assertEquals( "Queue size is incorrect ", 3, queue.size() );
		assertEquals( "Queue size is incorrect ", 3, queue2.size() );
	}

	/**
	 * Test method for {@link queueImplementation.MyQueue#isEmpty()}.
	 */
	@Test
	public void testIsEmpty_True()
	{
		boolean expected = true;

		boolean actual = queue.isEmpty();
		assertEquals( "Queue is not empty and should have been ", expected, actual );
		assertEquals( "Queue size is incorrect ", 0, queue.size() );
	}

	/**
	 * Test method for {@link queueImplementation.MyQueue#isEmpty()}.
	 */
	@Test
	public void testIsEmpty_False()
	{
		boolean expected = false;
		queue.enqueue( one );
		queue.enqueue( two );
		queue.enqueue( three );
		boolean actual = queue.isEmpty();
		assertEquals( "Queue shows empty but should not have been ", expected, actual );
		assertEquals( "Queue size is incorrect ", 3, queue.size() );
	}

	/**
	 * Test method for {@link queueImplementation.MyQueue#iterator()}.
	 */
	@Test
	public void testIterator()
	{
		int expected1 = 111;
		int expected2 = 222;
		int expected3 = 333;
		int expected4 = 444;
		int expected5 = 555;

		queue.enqueue( one );
		queue.enqueue( two );
		queue.enqueue( three );
		queue.enqueue( four );
		queue.enqueue( five );

		Iterator<Integer> it = queue.iterator();
		int actual1 = it.next();
		int actual2 = it.next();
		int actual3 = it.next();
		int actual4 = it.next();
		int actual5 = it.next();

		assertEquals( "Queue iterator contained wrong element at position 1 ", expected1, actual1 );
		assertEquals( "Queue iterator contained wrong element at position 2 ", expected2, actual2 );
		assertEquals( "Queue iterator contained wrong element at position 3 ", expected3, actual3 );
		assertEquals( "Queue iterator contained wrong element at position 4 ", expected4, actual4 );
		assertEquals( "Queue iterator contained wrong element at position 5 ", expected5, actual5 );
		assertEquals( "Queue size is incorrect ", 5, queue.size() );
	}

	/**
	 * Test method for {@link queueImplementation.MyQueue#peek()}.
	 * 
	 * @throws EmptyQueueException
	 */
	@Test
	public void testPeek_First() throws EmptyQueueException
	{
		int expected1 = 111;

		queue.enqueue( one );
		queue.enqueue( two );
		queue.enqueue( three );
		queue.enqueue( four );
		queue.enqueue( five );

		int actual1 = queue.peek();
		assertEquals( "Queue peek contained wrong element at position 1 ", expected1, actual1 );
		assertEquals( "Queue size is incorrect ", 5, queue.size() );
	}

	/**
	 * Test method for {@link queueImplementation.MyQueue#peek()}.
	 */
	@Test
	public void testPeek_Empty()
	{
		try
		{
			@SuppressWarnings( "unused" )
			Object value = queue.peek();
			fail( "Peek method failed to throw EmptyQueueException correctly." );
		}
		catch( EmptyQueueException e )
		{
			assertTrue( true );
		}
		assertEquals( "Queue size is incorrect ", 0, queue.size() );
	}

	/**
	 * Test method for {@link queueImplementation.MyQueue#dequeue()}.
	 * 
	 * @throws EmptyQueueException
	 */
	@Test
	public void testDequeue_Front() throws EmptyQueueException
	{
		int expected1 = 111;

		queue.enqueue( one );
		queue.enqueue( two );
		queue.enqueue( three );
		queue.enqueue( four );
		queue.enqueue( five );

		int actual1 = queue.dequeue();
		assertEquals( "Queue dequeue contained wrong element at position 1 ", expected1, actual1 );
		assertEquals( "Queue size is incorrect ", 4, queue.size() );
	}

	/**
	 * Test method for {@link queueImplementation.MyQueue#dequeue()}.
	 */
	@Test
	public void testDequeue_Empty()
	{
		try
		{
			@SuppressWarnings( "unused" )
			Object value = queue.dequeue();
			fail( "dequeue method failed to throw EmptyQueueException correctly." );
		}
		catch( EmptyQueueException e )
		{
			assertTrue( true );
		}
		assertEquals( "Queue size is incorrect ", 0, queue.size() );
	}

	/**
	 * Test method for
	 * {@link queueImplementation.MyQueue#enqueue(java.lang.Object)}.
	 * 
	 * @throws EmptyQueueException
	 */
	@Test
	public void testEnqueue_Front() throws EmptyQueueException
	{
		queue.enqueue( one );
		int actual = queue.peek();
		assertEquals( "Queue enqueueed wrong element to head of Queue ", 111, actual );
		assertEquals( "Queue size is incorrect ", 1, queue.size() );

		queue.enqueue( two );
		actual = queue.peek();
		assertEquals( "Queue enqueueed wrong element to head of Queue ", 111, actual );
		assertEquals( "Queue size is incorrect ", 2, queue.size() );

		queue.enqueue( three );
		actual = queue.peek();
		assertEquals( "Queue enqueueed wrong element to head of Queue ", 111, actual );
		assertEquals( "Queue size is incorrect ", 3, queue.size() );

		queue.enqueue( four );
		actual = queue.peek();
		assertEquals( "Queue enqueueed wrong element to head of Queue ", 111, actual );
		assertEquals( "Queue size is incorrect ", 4, queue.size() );

		queue.enqueue( five );
		actual = queue.peek();
		assertEquals( "Queue enqueueed wrong element to head of Queue ", 111, actual );
		assertEquals( "Queue size is incorrect ", 5, queue.size() );
	}

	/**
	 * Test method for
	 * {@link queueImplementation.MyQueue#enqueue(java.lang.Object)}.
	 */
	@Test
	public void testEnqueue_NullPointerException()
	{
		Integer empty = null;
		queue.enqueue( one );
		queue.enqueue( two );
		queue.enqueue( three );
		try
		{
			queue.enqueue( empty );
			fail( "Enqueue method failed to throw NullPointerException." );
		}
		catch( NullPointerException e )
		{
			assertTrue( true );
		}
		assertEquals( "Queue size is incorrect ", 3, queue.size() );
	}

	/**
	 * Test method for {@link utilities.QueueADT#size()}.
	 */
	@Test
	public void testSize_AddOneToEmpty()
	{
		assertEquals( "Queue size is incorrect ", 0, queue.size() );
		queue.enqueue( one );
		assertEquals( "Queue size is incorrect ", 1, queue.size() );
	}
	
	/**
	 * Test method for {@link utilities.QueueADT#size()}.
	 */
	@Test
	public void testSize_AddMany()
	{
		queue.enqueue( one );
		queue.enqueue( two );
		queue.enqueue( three );
		queue.enqueue( four );
		queue.enqueue( five );
		assertEquals( "Queue size is incorrect ", 5, queue.size() );
	}

	/**
	 * Test method for {@link queueImplementation.MyQueue#toArray()}.
	 */
	@Test
	public void testToArray()
	{
		queue.enqueue( one );
		queue.enqueue( two );
		queue.enqueue( three );

		assertEquals( "Queue size is incorrect ", 3, queue.size() );

		Integer[] array = new Integer[3];
		
		array[0] = one;
		array[1] = two;
		array[2] = three;

		Object[] returnArray = new Integer[3];;
		returnArray = queue.toArray();
		assertArrayEquals( "ToArray did not correctly convert list to array.", array, returnArray );
	}

	/**
	 * Test method for {@link queueImplementation.MyQueue#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArray()
	{
		queue.enqueue( one );
		queue.enqueue( two );
		queue.enqueue( three );

		assertEquals( "Stack size is incorrect ", 3, queue.size() );
	
		Object[] array = new Integer[3];
		
		array[0] = one;
		array[1] = two;
		array[2] = three;
		
		Integer[] returnArray = new Integer[3];;
		returnArray = queue.toArray( returnArray );
		assertArrayEquals( "ToArray did not correctly convert list to array.", array, returnArray );
	}
	
	/**
	 * Test method for {@link queueImplementation.MyQueue#toArray(E[])}.
	 */@Test
	public void testToArrayNullArray()
	{
		Integer[] returnArray = null;
		try 
		{
			returnArray = queue.toArray(returnArray);
			fail("toArray did not throw NullPointerException.");
		} 
		catch (NullPointerException e) 
		{
			assertTrue(true);
		}
	}
}
