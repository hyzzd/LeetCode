// OPERATORS = {'+', '-', '*', '/'}
// TARGET = 24


// def possible(arr):
//     if len(arr) == 1:
//         return arr[0] == TARGET

//     new_possibilities = list()
//     for si in range(len(arr) - 1):
//         for operator in OPERATORS:
//             num_1 = arr[si]
//             num_2 = arr[si + 1]
//             try:
//                 possibility = \
//                     arr[:si] + \
//                     [eval("{}{}{}".format(num_1, operator, num_2))] + \
//                     arr[si + 2:]
//                 new_possibilities.append(possibility)
//             except Exception:
//                 pass

//     return any([possible(x) for x in new_possibilities])