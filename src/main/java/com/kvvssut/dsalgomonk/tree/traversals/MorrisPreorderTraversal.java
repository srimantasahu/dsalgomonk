package com.kvvssut.dsalgomonk.tree.traversals;

import com.kvvssut.dsalgomonk.utils.BinaryTree;

public class MorrisPreorderTraversal {

	public static void main(String[] args) {
		final BinaryTree root = new BinaryTree(1);
		final BinaryTree l1 = new BinaryTree(2);
		final BinaryTree r1 = new BinaryTree(3);
		final BinaryTree ll2 = new BinaryTree(4);
		final BinaryTree lr2 = new BinaryTree(5);
		final BinaryTree rl2 = new BinaryTree(6);
		final BinaryTree rr2 = new BinaryTree(7);

		root.setLeft(l1);
		root.setRight(r1);
		l1.setLeft(ll2);
		l1.setRight(lr2);
		r1.setLeft(rl2);
		r1.setRight(rr2);

		preorderTraversal(root);
	}

	// https://www.geeksforgeeks.org/morris-traversal-for-preorder/
	private static void preorderTraversal(BinaryTree root) {
		BinaryTree currentNode = root;

		while (currentNode != null) {

			if (currentNode.getLeft() == null) {
				System.out.println(currentNode.getData());

				currentNode = currentNode.getRight();
			} else {
				final BinaryTree leftNode = currentNode.getLeft();
				final BinaryTree rightMostChildInLeftSubTree = getRightMostChild(leftNode);

				currentNode.setLeft(null);
				rightMostChildInLeftSubTree.setRight(currentNode.getRight());
				currentNode.setRight(leftNode);
			}
		}
	}

	private static BinaryTree getRightMostChild(BinaryTree root) {
		if (root.getRight() == null) {
			return root;
		}
		return getRightMostChild(root.getRight());
	}

}
