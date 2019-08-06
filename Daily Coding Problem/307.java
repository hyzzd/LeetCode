// import bisect


// class Node:
//     def __init__(self, val):
//         self.val = val
//         self.l = None
//         self.r = None


// def get_arr(root):
//     if not root:
//         return list()

//     return get_arr(root.l) + [root.val] + get_arr(root.r)


// def get_fc(root, val):
//     arr = get_arr(root)
//     ind = bisect.bisect(arr, val)
//     if ind == 0:
//         return None, arr[0]
//     elif ind == len(arr):
//         return arr[-1], None
//     elif val == arr[ind-1]:
//         return val, val
//     else:
//         return arr[ind-1], arr[ind]