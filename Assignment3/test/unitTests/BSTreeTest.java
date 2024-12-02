package unitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import utilities.Iterator;

import implementations.BSTree;
import implementations.BSTreeNode;

/**
 * @author kitty
 * @version 2.1 Jun 7, 2024  
 * Class Description:
 * Linked list based implementation of the BSTreeADT defined in the CPRG 304
 * Assignment 3.
 */

public class BSTreeTest {
	// Attributes
	private BSTree<Integer> tree;
	private Integer one;
	private Integer two;
	private Integer three;
	private Integer four;
	private Integer five;
	private Integer six;
	private Integer seven;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tree = new BSTree<Integer>();
		one = new Integer(11);
		two = new Integer(22);
		three = new Integer(33);
		four = new Integer(44);
		five = new Integer(55);
		six = new Integer(66);
		seven = new Integer(77);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tree = null;
		one = null;
		two = null;
		three = null;
		four = null;
		five = null;
		six = null;
		seven = null;
	}

	/**
	 * Test method for {@link treeImplementation.BSTree#BSTree()}.
	 */
	@Test
	public void testBST_Constructor() {
		boolean expected = true;
		boolean actual = tree != null;
		tree.size();
		assertEquals("Tree was not created ", expected, actual);
		assertEquals("Size of tree should be ", 0, tree.size());
	}

	/**
	 * Test method for
	 * {@link treeImplementation.BSTree#BSTree(java.lang.Comparable)}.
	 */
	@Test
	public void testBSTreeE() {
		int expected = 11;
		int actual = 0;
		BSTreeNode<Integer> i = null;

		BSTree<Integer> newTree = new BSTree<Integer>();
		newTree.add(one);

		i = newTree.getRoot();
		actual = i.getElement();

		assertEquals("Item wasn't correctly added to root. ", expected, actual);
		assertEquals("Size of tree should be ", 1, newTree.size());
	}

	/**
	 * Test method for adding a new element and checking for the correct boolean
	 * return.
	 */
	@Test
	public void testAddNewElementForBoolean() {
		boolean expected = true;
		boolean actual = tree.add(three);
		assertEquals("Correct boolean was not returned - element not added ", expected, actual);
		assertEquals("Size of tree should be ", 1, tree.size());
		assertEquals("Height of tree should be ", 1, tree.getHeight());
	}

	/**
	 * Test method for adding a new element and checking for the correct element
	 * being added to the root.
	 */
	@Test
	public void testAddNewElement_OneToEmpty() {
		int expected = 33;
		BSTreeNode<Integer> value = null;
		tree.add(three);

		value = tree.getRoot();

		int actual = value.getElement();
		assertEquals("Correct value not returned - element not added correctly ", expected, actual);
		assertEquals("Size of tree should be ", 1, tree.size());
		assertEquals("Height of tree should be ", 1, tree.getHeight());
	}

	/**
	 * Test method for adding a new element and checking for the correct element
	 * being added to the left side of the root.
	 */
	@Test
	public void testAddNewElement_LeftChild() {
		int expected1 = 22;
		int expected2 = 33;
		BSTreeNode<Integer> v1 = null;
		BSTreeNode<Integer> v2 = null;
		tree.add(three);
		tree.add(two);

		v1 = tree.search(two);
		v2 = tree.search(three);

		int actual1 = v1.getElement();
		int actual2 = v2.getElement();
		assertEquals("Correct value not returned - element not added correctly ", expected1, actual1);
		assertEquals("Correct value not returned - element not added correctly ", expected2, actual2);
		assertEquals("Size of tree should be ", 2, tree.size());
		assertEquals("Height of tree should be ", 2, tree.getHeight());
	}

	/**
	 * Test method for adding a new element and checking for the correct element
	 * being added to the right side of the root.
	 */
	@Test
	public void testAddNewElement_RightChild() {
		int expected = 44;
		BSTreeNode<Integer> value = null;
		tree.add(three);
		tree.add(four);

		value = tree.search(four);

		int actual = value.getElement();
		assertEquals("Correct value not returned - element not added correctly ", expected, actual);
		assertEquals("Size of tree should be ", 2, tree.size());
		assertEquals("Height of tree should be ", 2, tree.getHeight());
	}

	/**
	 * Test method for adding a new element and checking for the correct element
	 * being added to the correct location.
	 */
	@Test
	public void testAddNewElement_Many() {
		int expected = 77;
		BSTreeNode<Integer> value = null;
		tree.add(four);
		tree.add(two);
		tree.add(six);
		tree.add(one);
		tree.add(five);
		tree.add(seven);

		value = tree.search(seven);

		int actual = value.getElement();
		assertEquals("Correct value not returned - element not added correctly ", expected, actual);
		assertEquals("Size of tree should be ", 6, tree.size());
		assertEquals("Height of tree should be ", 3, tree.getHeight());
	}

	 @Test
	 public void testAddNewElement_ReturnTrue()
	 {
		 boolean expected = true;
		 boolean actual = tree.add(three);
		 
		 assertEquals("boolean not returned correctly ", expected, actual);
	 }

	@Test
	public void testAddNewElementForNullPointerException() {
		Integer value = null;
		try {
			tree.add(value);
			fail("Add method failed to throw NullPointerException.");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link treeImplementation.BSTree#clear()}.
	 */
	@Test
	public void testClear_Size() {
		tree.add(four);
		tree.add(six);
		tree.add(two);
		tree.clear();
		assertEquals("Size of tree should be ", 0, tree.size());
	}

	/**
	 * Test method for
	 * {@link treeImplementation.BSTree#contains(java.larng.Comparable)}.
	 */
	@Test
	public void testContainsForTrue() {
		tree.add(four);
		tree.add(six);
		tree.add(two);
		boolean expected = true;
		boolean actual = false;

			actual = tree.contains(two);

		assertEquals("Element was not found in the tree ", expected, actual);
	}

	@Test
	public void testContainsForFalse() {
		tree.add(four);
		tree.add(six);
		tree.add(two);
		boolean expected = false;
		boolean actual = false;
		try {
			actual = tree.contains(three);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals("Element found in the tree and should not ", expected, actual);
	}

	@Test
	public void testContainsForException() {
		try {
			tree.contains(null);
			fail("Contains method failed to throw NullPointerException.");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for
	 * {@link treeImplementation.BSTree#getEntry(java.lang.Comparable)}.
	 */

	@Test
	public void testSearch_Root() {
		tree.add(one);
		tree.add(two);
		tree.add(three);

		int expected = 11;
		int actual = 0;
		try {
			actual = tree.search(one).getElement();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals("Entry not found, ", expected, actual);
	}

	@Test
	public void testSearch_Level2() {
		tree.add(one);
		tree.add(two);
		tree.add(three);

		int expected = 22;
		int actual = 0;
		try {
			actual = tree.search(two).getElement();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals("Entry not found, ", expected, actual);
	}

	@Test
	public void testSearch_Level3() {
		tree.add(one);
		tree.add(two);
		tree.add(three);

		int expected = 33;
		int actual = 0;
		try {
			actual = tree.search(three).getElement();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals("Entry not found, ", expected, actual);
	}

	@Test
	public void testSearch_NotFound() {
		tree.add(one);
		tree.add(two);
		tree.add(three);
		tree.add(four);

		Integer expected = null;
		BSTreeNode<Integer> actual = null;
		try {
			actual = tree.search(five);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals("Entry not found, ", expected, actual);
	}

	@Test
	public void testSearch_NullPointerException() {
		try {
			tree.search(null);
			fail("Search method failed to throw NullPointerException.");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link treeImplementation.BSTree#getHeight()}.
	 */
	@Test
	public void testGetHeight_Balanced() {
		tree.add(two);
		tree.add(three);
		tree.add(one);
		tree.add(four);
		int expected = 3;
		int actual = tree.getHeight();
		assertEquals("Height of tree is not correct ", expected, actual);
	}

	@Test
	public void testGetHeight_IllBalanced() {
		tree.add(one);
		tree.add(two);
		tree.add(three);
		tree.add(four);
		tree.add(five);
		tree.add(six);
		tree.add(seven);
		int expected = 7;
		int actual = tree.getHeight();
		assertEquals("Height of tree is not correct ", expected, actual);
	}

	/**
	 * Test method for {@link treeImplementation.BSTree#getRootData()}.
	 */
	@Test
	public void testGetRoot() {
		tree.add(three);
		tree.add(two);
		tree.add(four);
		int expected = three;
		int actual = 0;
		try {
			actual = tree.getRoot().getElement();
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		assertEquals("Root of tree is not returned correctly ", expected, actual);
	}

	@Test
	public void testGetRoot_NullPointerException() {
		try {
			tree.getRoot();
			fail("GetRootData method failed to throw NullPointerException.");
		} catch (NullPointerException e) {
			assertTrue(true);
		}
	}

	/**
	 * Test method for {@link treeImplementation.BSTree#isEmpty()}.
	 */
	@Test
	public void testIsEmptyForTrue() {
		boolean expected = true;
		boolean actual = tree.isEmpty();
		assertEquals("Tree is not indicated as empty ", expected, actual);
	}

	@Test
	public void testIsEmptyForFalse() {
		tree.add(one);
		boolean expected = false;
		boolean actual = tree.isEmpty();
		assertEquals("Tree indicated as empty when it's not ", expected, actual);
	}

	/**
	 * Test method for {@link treeImplementation.BSTree#inorderIterator()}.
	 */
	@Test
	public void testInorderIterator() {
		tree.add(four);
		tree.add(two);
		tree.add(six);
		tree.add(one);
		tree.add(five);
		tree.add(three);
		tree.add(seven);

		Integer[] shouldBe = { one, two, three, four, five, six, seven };
		Iterator<Integer> it = tree.inorderIterator();
		int i = 0;
		boolean actual = true;
		while (it.hasNext()) {
			if (it.next() != shouldBe[i++]) {
				actual = false;
			}
		}

		assertEquals("Inorder iterator is out of order ", true, actual);
	}

	/**
	 * Test method for {@link treeImplementation.BSTree#postorderIterator()}.
	 */
	@Test
	public void testPostorderIterator() {
		tree.add(four);
		tree.add(two);
		tree.add(six);
		tree.add(one);
		tree.add(five);
		tree.add(three);
		tree.add(seven);

		Integer[] shouldBe = { one, three, two, five, seven, six, four };
		Iterator<Integer> it = tree.postorderIterator();
		int i = 0;
		boolean actual = true;
		while (it.hasNext()) {
			if (it.next() != shouldBe[i++]) {
				actual = false;
			}
		}

		assertEquals("Inorder iterator is out of order ", true, actual);
	}

	/**
	 * Test method for {@link treeImplementation.BSTree#preorderIterator()}.
	 */
	@Test
	public void testPreorderIterator() {
		tree.add(four);
		tree.add(two);
		tree.add(six);
		tree.add(one);
		tree.add(five);
		tree.add(three);
		tree.add(seven);

		Integer[] shouldBe = { four, two, one, three, six, five, seven };
		Iterator<Integer> it = tree.preorderIterator();
		int i = 0;
		boolean actual = true;
		while (it.hasNext()) {
			if (it.next() != shouldBe[i++]) {
				actual = false;
			}
		}

		assertEquals("Preorder iterator is out of order ", true, actual);
	}

	/**
	 * Test method for {@link treeImplementation.BSTree#size()}.
	 */
	@Test
	public void testSize() {
		tree.add(four);
		tree.add(two);
		tree.add(six);
		tree.add(one);
		tree.add(five);

		int expected = 5;
		int actual = tree.size();
		assertEquals("Size of tree was not returned correctly ", expected, actual);
	}
	
	
	/**
	 * Test method for {@link treeImplementation.BSTree#removeMin()}.
	 */
	@Test
	public void testRemoveMin() {
		tree.add(four);
		tree.add(two);
		tree.add(six);
		tree.add(one);
		tree.add(five);

		int expected = 11;
		int actual = tree.removeMin().getElement();
		assertEquals("Min was not returned correctly ", expected, actual);
	}
	
	/**
	 * Test method for {@link treeImplementation.BSTree#removeMin()}.
	 */
	@Test
	public void testRemoveMinNull() {
		assertNull("Min was not returned correctly ", tree.removeMin());
	}
	
	/**
	 * Test method for {@link treeImplementation.BSTree#removeMax()}.
	 */
	@Test
	public void testRemoveMax() {
		tree.add(four);
		tree.add(two);
		tree.add(six);
		tree.add(one);
		tree.add(five);

		int expected = 66;
		int actual = tree.removeMax().getElement();
		assertEquals("Max was not returned correctly ", expected, actual);
	}
	
	/**
	 * Test method for {@link treeImplementation.BSTree#removeMax()}.
	 */
	@Test
	public void testRemoveMaxNull() {
		assertNull("Max was not returned correctly ", tree.removeMax());
	}
}
