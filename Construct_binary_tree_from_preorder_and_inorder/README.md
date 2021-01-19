<!-- https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/ -->

Used recursion method to solve the problem.

Both preorder traversal and inorder traversal 

For the result of preorder traversal, root of the current tree is always at the leftmost index, and the root of the left subtree is always the 1st right node of the root. 

For the inorer traversal, root locates at the middle point of the resultant array. The left part of the root is the left subtree, and its right is the right subtree.

We can use this info to recursively pick out the root of the subtree until we hit the leaf, then we return null and the recursive process ends.

So, the primary task is to identify the proper ranges of the left subtree and the right subtree of both preorder and inorder result and pass them to the next recursion.

Once we realize the job left is to define the ranges, which can be calculated by using the fact that the number of elements in these ranges of preorder and inorder array should be the same.