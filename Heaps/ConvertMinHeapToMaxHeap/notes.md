# Convert Min Heap to Max Heap

## Problem Statement
Convert a given **Min Heap** into a **Max Heap** **in-place**, without using any extra data structure.

---

## Key Observations
- The heap is already a **complete binary tree**.
- Only the **heap order property** needs to be changed.
- The **structure of the tree must remain unchanged**.
- Conversion must be done **in-place**.

---

## Heap Properties
- **Min Heap:** Parent ≤ Children  
- **Max Heap:** Parent ≥ Children  

---

## Array Representation Facts
- Left child index: `2i + 1`
- Right child index: `2i + 2`
- All indices `≥ N/2` represent **leaf nodes**
- Leaf nodes already satisfy heap property

---

## Core Idea
Convert the Min Heap into a Max Heap by applying **max-heapify (downheap)** on all **non-leaf nodes**, starting from the bottom and moving upward.

---

## Why Start from `(N/2) - 1`
- Nodes from index `N/2` to `N-1` are leaf nodes
- Leaf nodes do not need heapification
- `(N/2) - 1` is the **last non-leaf node**
- Bottom-up heapification ensures children are fixed before parents

---

## Step-by-Step Approach
1. Identify the last non-leaf node: `(N/2) - 1`
2. Traverse from `(N/2) - 1` down to index `0`
3. For each node:
   - Compare it with its left and right children
   - Swap with the larger child if required
   - Continue downheap until max-heap property is restored
4. After processing index `0`, the array becomes a Max Heap

---

## Why Bottom-Up Works
- Child subtrees are converted to Max Heaps first
- Parent nodes are fixed only after children are valid
- Prevents repeated and unnecessary corrections
- Ensures optimal performance

---

## Time Complexity
- **O(N)**

### Explanation
- Most nodes are leaf or near-leaf nodes → constant work
- Few nodes near the root take logarithmic time
- Total work across all nodes sums to **O(N)**

---

## Space Complexity
- **O(1)** (in-place conversion)

---

## Common Mistakes
- Heapifying only the root ❌
- Using insertion-based `upheap` instead of heapify ❌
- Starting heapification from index `0` ❌
- Assuming time complexity is `O(N log N)` ❌

---

## Final Takeaway
> Converting a Min Heap to a Max Heap is done by applying **bottom-up max-heapify on all non-leaf nodes**, achieving **O(N)** time and **O(1)** space complexity.
