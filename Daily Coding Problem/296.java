// class Node:
//     def __init__(self, val):
//         self.val = val
//         self.l = None
//         self.r = None

//     def __repr__(self):
//         return "{}=[l={}, r={}]".format(self.val, self.l, self.r)


// def get_hbal_tree(arr):
//     if not arr:
//         return None

//     mid = len(arr) // 2
//     node = Node(arr[mid])
//     node.l = get_hbal_tree(arr[:mid])
//     node.r = get_hbal_tree(arr[mid + 1 :])

//     return node