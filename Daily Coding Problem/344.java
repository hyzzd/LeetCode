// class Node:
//     def __init__(self, val):
//         self.val = val
//         self.ch = set()
//         self.par = None

//     def size(self):
//         if not self.ch:
//             return 1

//         return 1 + sum([x.size() for x in self.ch])


// def split(node):
//     results = list()
//     for child in node.ch:
//         if child.size() % 2 == 0:
//             new_children = [x for x in node.ch if x != child]
//             node.ch = new_children
//             return [node, child]
//         else:
//             results.extend(split(child))
//     return results


// def segment(nodes):
//     new_nodes = list()
//     count = len(nodes)
//     for node in nodes:
//         new_nodes = split(node)

//     if len(new_nodes) == count:
//         return count

//     return segment(new_nodes)