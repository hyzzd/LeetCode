// import sys


// def get_shortest_path(
//         target, elevations, path_map, path_so_far,
//         elevations_so_far, distance, switches):

//     if 0 == target and path_so_far:
//         return path_so_far, distance if switches < 2 else sys.maxsize

//     min_dist, min_path = sys.maxsize, None
//     for src, dist in path_map[target]:
//         if src == target:
//             continue

//         new_switches = switches + 1 \
//             if elevations_so_far and elevations[src] > elevations_so_far[0] \
//             else switches

//         new_path_so_far, new_dist = get_shortest_path(
//             src, elevations, path_map, [src] + path_so_far,
//             [elevations[target]] + elevations_so_far, distance + dist, new_switches)

//         if new_dist < min_dist:
//             min_dist = new_dist
//             min_path = new_path_so_far

//     return min_path, min_dist


// def get_shortest_path_helper(elevations, paths):
//     path_map = dict()
//     for (src, tgt), dist in paths.items():
//         if tgt not in path_map:
//             path_map[tgt] = list()
//         path_map[tgt].append((src, dist))

//     shortest_path, _ = get_shortest_path(
//         0, elevations, path_map, list(), list(), 0, 0)

//     return shortest_path