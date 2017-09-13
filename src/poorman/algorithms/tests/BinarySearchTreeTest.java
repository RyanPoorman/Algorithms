package poorman.algorithms.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import poorman.algorithms.searching.BinarySearchTree;

public class BinarySearchTreeTest {

	static BinarySearchTree bst = null;
	static List<Integer> bstKeys = null;

	@BeforeClass
	public static void populateGlobalVars() {
		bst = new BinarySearchTree();
		bstKeys = new ArrayList<Integer>();
		populateBSTKeys(bstKeys);
		Collections.sort(bstKeys);
	}

	private static void populateBSTKeys(List<Integer> bstKeys2) {
		bstKeys.add(7);
		bstKeys.add(8);
		bstKeys.add(9);
		bstKeys.add(1);
		bstKeys.add(2);
		bstKeys.add(3);
		bstKeys.add(4);
		bstKeys.add(5);
		bstKeys.add(6);
		bstKeys.add(10);
	}

	@Test
	public void addToTreeTest() {
		bst.add(7);
		bst.add(8);
		bst.add(9);
		bst.add(1);
		bst.add(2);
		bst.add(3);
		bst.add(4);
		bst.add(5);
		bst.add(6);
		bst.add(10);
	}

	@Test
	public void getNodeKeysAsListTest() {
		Assert.assertEquals(bstKeys, bst.getNodeKeysAsList());
	}

	@Test
	public void getSizeTest() {
		Assert.assertEquals(10, bst.size());
	}

	@Test
	public void hasChildrenTest() {
		Assert.assertFalse(bst.hasChildren(44));
		Assert.assertTrue(bst.hasChildren(3));
	}

	@Test
	public void nodeExistsTest() {
		Assert.assertFalse(bst.nodeExists(42));
		Assert.assertTrue(bst.nodeExists(5));
	}

	@Test
	public void removeNodeTest() {
		int originalCount = bst.size();
		bst.remove(8);
		Assert.assertEquals(originalCount, bst.size() + 1);
		Assert.assertNotSame(originalCount, bst.size());
	}

	@Test
	public void getLeafCountTest() {
		Assert.assertEquals(2, bst.getLeafCount());
	}

}
