// import random


// def knows(known, a, b):
//     return b in known[a]


// def get_celeb(known):
//     celeb_candidates = set(known.keys())

//     while celeb_candidates:
//         sample = next(iter(celeb_candidates))
//         celeb_candidates.remove(sample)
//         count = len(celeb_candidates)
//         for other in celeb_candidates:
//             if not knows(known, sample, other):
//                 count -= 1
//         if count == 0:
//             return sample