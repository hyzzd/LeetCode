// class Node:
//     def __init__(self, val):
//         self.val = val
//         self.l = None
//         self.r = None

//     def __repr__(self):
//         return "{}".format(self.val)


// def merge(t1, t2, final_prev, left):
//     if not t1 and not t2:
//         return

//     if t1 and t2:
//         final_node = Node(t1.val + t2.val)
//         if left:
//             final_prev.l = final_node
//         else:
//             final_prev.r = final_node
//         merge(t1.l, t2.l, final_node, True)
//         merge(t1.r, t2.r, final_node, False)
//         return

//     only_node = t1 if t1 else t2
//     if left:
//         final_prev.l = only_node
//     else:
//         final_prev.r = only_node