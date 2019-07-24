// def get_pastri_row(k, row=None):
//     assert k and k > 0

//     if not row:
//         row = [0 for _ in range(k)]
//         row[0] = 1

//     if k == 1:
//         return row

//     row = get_pastri_row(k - 1, row)
//     for i in range(len(row) - 1, 0, -1):
//         row[i] += row[i - 1]

//     return row