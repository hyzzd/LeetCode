// from heapq import heappush, heappop


// def interleave_playlist(ranked_listings):
//     scores = dict()
//     for listing in ranked_listings:
//         num_songs = len(listing)
//         total_points = ((num_songs + 1) * num_songs) // 2
//         for rank, song in enumerate(listing):
//             if song not in scores:
//                 scores[song] = 0
//             scores[song] += total_points / (rank + 1)

//     sorted_scored_tuples = list()
//     for song, score in scores.items():
//         heappush(sorted_scored_tuples, (score, song))

//     interleaved = list()
//     while sorted_scored_tuples:
//         _, song = heappop(sorted_scored_tuples)
//         interleaved.append(song)

//     return interleaved[::-1]
