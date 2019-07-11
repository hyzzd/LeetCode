// def contains_pytrip(arr):
//     squared = [x * x for x in arr]
//     set_of_squares = set(squared)
//     for i in range(len(squared) - 1):
//         for k in range(i + 1, len(squared) - 1):
//             summed = squared[i] + squared[k]
//             if summed in set_of_squares:
//                 return True

//     return False