## Thought
This question is broke down into 3 pieces:
1. Go through the list and link the tail to the head, so that the list has a loop.
2. Break the loop at the appropriate node.
3. Return the new head of the list.

## Solution
1. Create a pointer pointing to the head, go through the list and link the tail to head (ptr.next = head). At the same time, we count the total size of the list.
2. The list should break the loop at the kth node before the original tail node. But, since there is no way to directly call the node.prev, we need to go down the list from the tail and stop at (size - (k % size)). Now, pointer is pointing to the appropriate node, and ptr.next should be returned. Then, we store the ptr.next into temp and break the loop by calling ptr.next = null.
3. Return the temp.