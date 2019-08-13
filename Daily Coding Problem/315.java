// def check_diagonal(start, matrix, val, rows, cols):
//     if start[0] == rows or start[1] == cols:
//         return True

//     if matrix[start[0]][start[1]] == val:
//         return check_diagonal((start[0] + 1, start[1] + 1), matrix, val, rows, cols)

//     return False


// def is_toeplitz(matrix):
//     rows, cols = len(matrix), len(matrix[0])
//     for ind in range(rows):
//         val = matrix[ind][0]
//         if not check_diagonal((ind + 1, 1), matrix, val, rows, cols):
//             return False

//     for ind in range(1, cols):
//         val = matrix[0][ind]
//         if not check_diagonal((1, ind + 1), matrix, val, rows, cols):
//             return False

//     return True