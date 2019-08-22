// import sys


// def get_min_steps(mice, holes, largest_step=-sys.maxsize):
//     if not mice:
//         return largest_step

//     mouse = mice[0]
//     min_steps = list()
//     for hole in holes:
//         diff = abs(mouse - hole)
//         min_steps.append(
//             get_min_steps(mice[1:], holes - {hole}, max(largest_step, diff))
//         )

//     return min(min_steps)