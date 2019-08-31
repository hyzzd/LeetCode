// class Node:
//     def __init__(self, val):
//         self.val = val
//         self.l = None
//         self.r = None


// def sum_range(node, lo, hi):
//     if not node:
//         return 0
//     elif node.val < lo:
//         return sum_range(node.r, lo, hi)
//     elif node.val > hi:
//         return sum_range(node.l, lo, hi)

//     return node.val + sum_range(node.l, lo, hi) + sum_range(node.r, lo, hi)