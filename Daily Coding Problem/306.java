// def sort_k(arr, k):
//     arr = sorted(arr[:k]) + arr[k:]
//     for i in range(k, len(arr)):
//         start, end = i-k+1, i+1
//         p, n = arr[:start], arr[end:]
//         sub = sorted(arr[start:end])
//         arr = p + sub + n
//     return arr