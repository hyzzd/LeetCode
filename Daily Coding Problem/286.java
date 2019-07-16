// import sys


// def get_max_width(buildings):
//     leftmost, rightmost = sys.maxsize, -sys.maxsize
//     for start, end, _ in buildings:
//         if start < leftmost:
//             leftmost = start
//         if end > rightmost:
//             rightmost = end

//     return rightmost - leftmost + 1


// def get_skyline(buildings):
//     skyline_width = get_max_width(buildings)
//     fill_arr = [0 for _ in range(skyline_width)]

//     for start, end, height in buildings:
//         for col in range(start, end):
//             fill_arr[col] = max(fill_arr[col], height)

//     skyline = list()
//     prev_height = None
//     for col, col_height in enumerate(fill_arr):
//         if not skyline or prev_height != col_height:
//             skyline.append((col, col_height))
//         prev_height = col_height

//     return skyline