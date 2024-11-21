package unitTests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import implementations.MyArrayList;
import utilities.Iterator;

/**
 * @author kitty
 * @version 3.1 Jun 6, 2024  
 * Class Description:
 * Array based implementation of the ListADT defined in the CPRG 304
 * Assignment 2.
 */

public class ArrayListTest
{
	// Attributes
	private MyArrayList<Integer> myList;
	private ArrayList<Integer> jList;
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
		myList = new MyArrayList<>();
		one = Integer.valueOf( 1 );
		two = Integer.valueOf( 2 );
		three = Integer.valueOf( 3 );
		four = Integer.valueOf( 4 );
		five = Integer.valueOf( 5 );
		jList = new ArrayList<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		myList = null;
		one = null;
		two = null;
		three = null;
		four = null;
		five = null;
		jList = null;
	}

	@Test
	public void testConstructor()
	{
		boolean expected = true;
		boolean actual = myList != null;
		assertEquals( "List was not created ", expected, actual );
		assertEquals( "Size of the array was not returned correctly ", 0, myList.size() );
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntE_returnTrue()
	{
		boolean expectedBoolean = true;
		boolean actualBoolean = myList.add( 0, one );

		assertEquals( "Element not added to the correct position in the list ", expectedBoolean, actualBoolean );
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntE_NullPointerException()
	{
		one = null;
		try
		{
			myList.add( 0, null );
			fail( "Add method failed to throw NullPointerException correctly." );
		}
		catch( NullPointerException e )
		{
			assertTrue( true );
		}
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntE_IndexOutOfBoundsException()
	{
		myList.add( 0, one );
		myList.add( 1, two );
		myList.add( 2, three );

		try
		{
			myList.add( 4, four );
			fail( "Add method failed to throw IndexOutOfBoundsException." );
		}
		catch( IndexOutOfBoundsException e )
		{
			assertTrue( true );
		}
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddIntE_ItemAddedCorrectly_Empty()
	{
		int expected = 1;

		myList.add( 0, one );
		int actual = ( myList.get( 0 ) ).intValue();
		assertEquals( "Element added was not in the correct position.", expected, actual );
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddIntE_ItemAddedCorrectly_Tail()
	{
		int expected = 3;

		myList.add( 0, one );
		myList.add( 1, two );
		myList.add( 2, three );

		int actual = ( myList.get( 2 ) ).intValue();
		assertEquals( "Element added was not in the correct position.", expected, actual );
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddIntE_ItemAddedCorrectly_Head()
	{
		int expected = 1;

		myList.add( 0, three );
		myList.add( 0, two );
		myList.add( 0, one );

		int actual = ( myList.get( 0 ) ).intValue();
		assertEquals( "Element added was not in the correct position.", expected, actual );
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddIntE_ItemAddedCorrectly_Order()
	{
		int expected = 3;

		myList.add( 0, three );
		myList.add( 0, two );
		myList.add( 0, one );

		int actual = ( myList.get( 2 ) ).intValue();
		assertEquals( "Element added was not in the correct position.", expected, actual );
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddE_ResizeArray()
	{
		myList.add( 0, one );
		myList.add( 1, two );
		myList.add( 2, three );
		myList.add( 3, four );
		myList.add( 4, five );
		myList.add( 0, one );
		myList.add( 1, two );
		myList.add( 2, three );
		myList.add( 3, four );
		myList.add( 4, five );
		// default original is 10
		myList.add( 0, one );

		int expectedValue = 1;
		int expectedSize = 11;

		int actualValue = ( myList.get( 0 ) ).intValue();
		assertEquals( "Element added was not in the correct position.", expectedValue, actualValue );
		int actualSize = myList.size();
		assertEquals( "Size of list was not increased correctly after resize.", expectedSize, actualSize );
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddE_returnTrue()
	{
		boolean expectedBoolean = true;
		boolean actualBoolean = myList.add( one );

		assertEquals( "Element not added to the correct position in the list.", expectedBoolean, actualBoolean );
		assertEquals( "Element not added to the correct position in the list.", jList.add( one ), actualBoolean );
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddE_NullPointerException()
	{
		one = null;
		try
		{
			myList.add( null );
			fail( "Add method failed to throw NullPointerException correctly." );
		}
		catch( NullPointerException e )
		{
			assertTrue( true );
		}
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddE_ItemAddedCorrectly_OneElement()
	{
		int expected = 1;

		myList.add( one );
		int actual = ( myList.get( 0 ) ).intValue();
		assertEquals( "Element added was not in the correct position.", expected, actual );
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddE_ItemAddedCorrectly_MultipleElements()
	{
		int expected = 3;

		myList.add( 0, one );
		myList.add( 1, two );
		myList.add( 2, three );

		int actual = ( myList.get( 2 ) ).intValue();
		assertEquals( "Element added was not in the correct position.", expected, actual );
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#addAll(utilities.List)}.
	 */
	@Test
	public void testAddAll_returnTrue()
	{
		boolean expected = true;
		MyArrayList<Integer> intArray = new MyArrayList<>();
		intArray.add( three );
		intArray.add( four );
		intArray.add( five );

		myList.add( one );
		myList.add( two );
		boolean actual = myList.addAll( intArray );
		assertEquals( "Element was not added to the end of the list correctly.", expected, actual );
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#addAll(utilities.List)}.
	 */
	@Test
	public void testAddAll_NullPointerException()
	{
		MyArrayList<Integer> intArray = null;

		myList.add( one );
		myList.add( two );
		try
		{
			myList.addAll( intArray );
			fail( "AddAll method failed to throw NullPointerException correctly." );
		}
		catch( NullPointerException e )
		{
			assertTrue( true );
		}
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#addAll(utilities.List)}.
	 */
	@Test
	public void testAddAll_ItemsAddedCorrectly_Head()
	{
		int expected = 5;
		MyArrayList<Integer> intArray = new MyArrayList<>();
		intArray.add( three );
		intArray.add( four );
		intArray.add( five );

		myList.add( one );
		myList.add( two );

		myList.addAll( intArray );
		Integer value = myList.get( 4 );
		int actual = value.intValue();
		assertEquals( "Elements were not added to the end of list correctly.", expected, actual );
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#addAll(utilities.List)}.
	 */
	@Test
	public void testAddAll_ItemsAddedCorrectly_Tail()
	{
		int expected = 5;
		MyArrayList<Integer> intArray = new MyArrayList<>();
		intArray.add( one );
		intArray.add( two );
		intArray.add( three );

		myList.add( four );
		myList.add( five );

		intArray.addAll( myList );
		Integer value = intArray.get( 4 );
		int actual = value.intValue();
		assertEquals( "Elements were not added to the end of list correctly.", expected, actual );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#clear()}.
	 */
	@Test
	public void testClear_Size()
	{
		int expected = 0;

		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );
		myList.clear();

		int actual = myList.size();
		assertEquals( "List was not cleared correctly.", expected, actual );
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains_returnTrue()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );

		boolean expected = true;
		boolean actual = myList.contains( three );
		assertEquals( "Element was not correctly found in the current list.", expected, actual );
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains_returnFalse()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );

		boolean expected = false;
		boolean actual = myList.contains( five );
		assertEquals( "Element found in current list and should not be found.", expected, actual );
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContains_NullPointerException()
	{
		try
		{
			myList.contains( null );
			fail( "Contains method failed to throw NullPointerException." );
		}
		catch( NullPointerException e )
		{
			assertTrue( true );
		}
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#get(int)}.
	 */
	@Test
	public void testGetInt_One()
	{
		myList.add( one );

		int expected = 1;
		Integer value = myList.get( 0 );
		int actual = value.intValue();
		assertEquals( "Get did not retrieved correct item from list.", expected, actual );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#get(int)}.
	 */
	@Test
	public void testGetInt_Head()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );

		int expected = 1;
		Integer value = myList.get( 0 );
		int actual = value.intValue();
		assertEquals( "Get did not retrieved correct item from list.", expected, actual );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#get(int)}.
	 */
	@Test
	public void testGetInt_Tail()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );

		int expected = 4;
		Integer value = myList.get( 3 );
		int actual = value.intValue();
		assertEquals( "Get did not retrieved correct item from list.", expected, actual );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#get(int)}.
	 */
	@Test
	public void testGetInt_IndexOutOfBoundsException_Empty()
	{
		try
		{
			myList.get( 0 );
			fail( "Get method failed to throw IndexOutOfBoundsException." );
		}
		catch( IndexOutOfBoundsException e )
		{
			assertTrue( true );
		}
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#get(int)}.
	 */
	@Test
	public void testGetInt_IndexOutOfBoundsException_InvalidIndex() // need test for empty
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );

		try
		{
			myList.get( 4 );
			fail( "Get method failed to throw IndexOutOfBoundsException." );
		}
		catch( IndexOutOfBoundsException e )
		{
			assertTrue( true );
		}
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty_True()
	{
		boolean expected = true;
		boolean actual = myList.isEmpty();
		assertEquals( "List is not indicated as empty when it is empty.", expected, actual );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty_False()
	{
		myList.add( one );
		boolean expected = false;
		boolean actual = myList.isEmpty();
		assertEquals( "List indicated as empty when it's not empty.", expected, actual );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#iterator()}.
	 */
	@Test
	public void testIterator_Head()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );
		myList.add( five );

		int expected = 1;
		Iterator<Integer> it = myList.iterator();
		int actual = it.next().intValue();
		assertEquals( "Iterator returnArrayed incorrect value at 1st position.", expected, actual );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#iterator()}.
	 */
	@Test
	public void testIterator_Tail()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );
		myList.add( five );

		Iterator<Integer> it = myList.iterator();
		Integer value = null;
		int expected = 5;
		while( it.hasNext() )
		{
			value = it.next();
		}
		int actual = value.intValue();
		assertEquals( "Iterator returnArrayed incorrect value at the last position.", expected, actual );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt_OneElement()
	{
		myList.add( one );

		int expected = 1;
		Integer value = myList.remove( 0 );
		int actual = value.intValue();
		assertEquals( "Element was not removed correctly.", expected, actual );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt_Head()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );

		int expected1 = 1;
		Integer value = myList.remove( 0 );
		int actual1 = value.intValue();

		int expected2 = 2;
		Integer value2 = myList.get( 0 );
		int actual2 = value2.intValue();

		assertEquals( "Element was not removed correctly.", expected1, actual1 );
		assertEquals( "Element was not removed correctly.", expected2, actual2 );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt_Tail()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );

		int expected1 = 4;
		Integer value = myList.remove( 3 );
		int actual1 = value.intValue();

		int expected2 = 3;
		Integer value2 = myList.get( 2 );
		int actual2 = value2.intValue();

		assertEquals( "Element was not removed correctly.", expected1, actual1 );
		assertEquals( "Element was not removed correctly.", expected2, actual2 );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt_NotHeadOrTail()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );
		myList.add( five );

		int expected1 = 3;
		Integer value = myList.remove( 2 );
		int actual1 = value.intValue();

		int expected2 = 2;
		Integer value2 = myList.get( 1 );
		int actual2 = value2.intValue();

		int expected3 = 4;
		Integer value3 = myList.get( 2 );
		int actual3 = value3.intValue();

		assertEquals( "Element was not removed correctly.", expected1, actual1 );
		assertEquals( "Element was not removed correctly.", expected2, actual2 );
		assertEquals( "Element was not removed correctly.", expected3, actual3 );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt_IndexOutOfBoundsException_Empty()
	{
		try
		{
			myList.remove( 0 );
			fail( "Remove method failed to throw IndexOutOfBoundsException." );
		}
		catch( IndexOutOfBoundsException e )
		{
			assertTrue( true );
		}
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt_IndexOutOfBoundsException_InvalidIndex()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );

		try
		{
			myList.remove( 4 );
			fail( "Remove method failed to throw IndexOutOfBoundsException." );
		}
		catch( IndexOutOfBoundsException e )
		{
			assertTrue( true );
		}
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#remove(E)}.
	 */
	@Test
	public void testRemoveE_OneElement()
	{
		Integer expected = 1;
		myList.add( one );
		Integer actual = myList.remove( one );

		assertEquals( "Element was not removed correctly.", expected, actual );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemove_Found()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );

		int expected1 = 1;
		Integer value = myList.remove( one );
		int actual1 = value.intValue();

		int expected2 = 2;
		Integer value2 = myList.get( 0 );
		int actual2 = value2.intValue();

		assertEquals( "Element was not removed correctly.", expected1, actual1 );
		assertEquals( "Element was not removed correctly.", expected2, actual2 );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemove_NotFound()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );

		Integer expected1 = myList.remove( five );

		int expected2 = 1;
		Integer value2 = myList.get( 0 );
		int actual2 = value2.intValue();

		assertEquals( "Element was not removed correctly.", expected1, null );
		assertEquals( "Element was not removed correctly.", expected2, actual2 );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#remove(E)}.
	 */
	@Test
	public void testRemoveE_NullPointerException()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );

		three = null;

		try
		{
			myList.remove( three );
			fail( "Remove method failed to throwNullPointerException." );
		}
		catch( NullPointerException e )
		{
			assertTrue( true );
		}
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#set(int, E)}.
	 */
	@Test
	public void testSet_SpecificIndex()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );
		myList.add( five );

		Integer toChange = Integer.valueOf( 33 );

		int expected1 = 3;
		Integer value = myList.set( 2, toChange );
		int actual1 = value.intValue();

		int expected2 = 33;
		Integer value1 = myList.get( 2 );
		int actual2 = value1.intValue();

		assertEquals( "Original element not returnArrayed correctly after Set.", expected1, actual1 );
		assertEquals( "Element was not changed correctly after Set.", expected2, actual2 );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#set(int, E)}.
	 */
	@Test
	public void testSet_Head()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );

		Integer toChange = Integer.valueOf( 11 );

		Integer expected1 = 1;
		int expected2 = 11;
		Integer actual1 = myList.set( 0, toChange );
		int actual2 = myList.get( 0 ).intValue();

		assertEquals( "Original element was not returnArrayed correctly.", expected1, actual1 );
		assertEquals( "Element was not changed correctly.", expected2, actual2 );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#set(int, E)}.
	 */
	@Test
	public void testSet_Tail()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );
		myList.add( five );

		Integer toChange = Integer.valueOf( 55 );

		int expected1 = 5;
		Integer value = myList.set( 4, toChange );
		int actual1 = value.intValue();

		int expected2 = 55;
		Integer value1 = myList.get( 4 );
		int actual2 = value1.intValue();

		assertEquals( "Original element was not returnArrayed correctly.", expected1, actual1 );
		assertEquals( "Element was not changed correctly.", expected2, actual2 );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#set(int, E)}.
	 */
	@Test
	public void testSet_NullPointerException()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );
		myList.add( five );

		Integer toChange = null;

		try
		{
			myList.set( 2, toChange );
			fail( "Set method failed to throw the NullPointerException." );
		}
		catch( NullPointerException e )
		{
			assertTrue( true );
		}
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#set(int, E)}.
	 */
	@Test
	public void testSet_IndexOutOfBoundsException_Empty()
	{
		Integer toChange = Integer.valueOf( 33 );

		try
		{
			myList.set( 0, toChange );
			fail( "Set method failed to throw the IndexOutOfBoundsException." );
		}
		catch( IndexOutOfBoundsException e )
		{
			assertTrue( true );
		}
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#set(int, E)}.
	 */
	@Test
	public void testSet_IndexOutOfBoundsException_InvalidIndex()
	{
		myList.add( one );
		myList.add( two );
		myList.add( three );

		Integer toChange = Integer.valueOf( 33 );

		try
		{
			myList.set( 4, toChange );
			fail( "Set method failed to throw IndexOutOfBoundsException." );
		}
		catch( IndexOutOfBoundsException e )
		{
			assertTrue( true );
		}
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#size()}.
	 */
	@Test
	public void testSize_AddOneToEmpty() // test for 0 and 1 and max
	{
		int expected = 1;
		myList.add( one );

		int actual = myList.size();
		assertEquals( "Size of the array was not returned correctly.", expected, actual );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#size()}.
	 */
	@Test
	public void testSize_AddMany() // test for 0 and 1 and max
	{
		int expected = 5;
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );
		myList.add( five );

		int actual = myList.size();
		assertEquals( "Size of the array was not returned correctly ", expected, actual );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#size()}.
	 */
	@Test
	public void testSize_RemoveOneToEmpty() // test for 0 and 1 and max
	{
		int expected = 0;
		myList.add( one );
		myList.remove( 0 );
		int actual = myList.size();
		assertEquals( "Size of the array was not returned correctly ", expected, actual );
	}

	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#size()}.
	 */
	@Test
	public void testSize_RemoveMany() // test for 0 and 1 and max
	{
		int expected = 2;
		myList.add( one );
		myList.add( two );
		myList.add( three );
		myList.add( four );
		myList.add( five );
		myList.remove( 0 );
		myList.remove( 0 );
		myList.remove( 0 );
		int actual = myList.size();
		assertEquals( "Size of the array was not returned correctly ", expected, actual );
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#toArray(T[])}.
	 */
	@Test
	public void testToArrayEArray()
	{
		Object[] original = new Integer[500];
		for( int i = 0; i < 500; i++ )
		{
			original[i] = i;
			myList.add( Integer.valueOf( i ) );
		}

		Integer[] returnArray = new Integer[500];;
		returnArray = myList.toArray( returnArray );

		assertArrayEquals( "ToArray did not correctly convert list to array.", original, returnArray );
	}

	/**
	 * Test method for
	 * {@link arrayBasedListImplementation.MyArrayList#toArray(T[])}.
	 */
	@Test
	public void testToArrayNullArray()
	{
		Integer[] returnArray = null;
		try 
		{
			returnArray = myList.toArray(returnArray);
			fail("toArray did not throw NullPointerException.");
		} 
		catch (NullPointerException e) 
		{
			assertTrue(true);
		}
	}
	
	/**
	 * Test method for {@link arrayBasedListImplementation.MyArrayList#toArray()}.
	 */
	@Test
	public void testToArray()
	{
		Integer[] original = new Integer[500];
		for( int i = 0; i < 500; i++ )
		{
			original[i] = i;
			myList.add( Integer.valueOf( i ) );
		}

		Object[] returnArray = myList.toArray();

		assertArrayEquals( "ToArray did not correctly convert list to array.", original, returnArray );
	}
}
