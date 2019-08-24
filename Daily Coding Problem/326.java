// from typing import List


// class Node:
//     def __init__(self, val: int):
//         self.val = val
//         self.l = None
//         self.r = None

//     def __repr__(self):
//         return "{}=[l->{}, r->{}]".format(self.val, self.l, self.r)


// def make_cartree(arr: List[int], last: Node, root: Node):
//     if not arr:
//         return root

//     node = Node(arr[0])
//     if not last:
//         return make_cartree(arr[1:], node, node)

//     if last.val > node.val:
//         node.l = last
//         return make_cartree(arr[1:], node, node)

//     last.r = node
//     return make_cartree(arr[1:], last, last)