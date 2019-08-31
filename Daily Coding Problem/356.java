// # Not sure how a set of arrays provides advantages over a single array
// # Regardless, their indices can be combined to act as a single large array


// class Queue:
//     def __init__(self, arr_size):
//         self.flarr = [None for _ in range(arr_size)]
//         self.start, self.end = 0, 0
//         self.size = 0
//         self.max_size = arr_size

//     def enqueue(self, val):
//         if self.size == self.max_size:
//             # No more space
//             return

//         new_end = (self.end + 1) % self.max_size
//         self.flarr[self.end] = val
//         self.end = new_end
//         self.size += 1

//     def dequeue(self):
//         if self.size == 0:
//             # Nothing to dequeue
//             return None

//         new_start = (self.start + 1) % self.max_size
//         val = self.flarr[self.start]
//         self.flarr[self.start] = None
//         self.start = new_start
//         self.size -= 1

//         return val

//     def get_size(self):
//         return self.size