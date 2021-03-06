// # if there are 2 consecutive numbers, the least significant
// # bit will be 0 once, which means the result of an AND on
// # the last bit will be zero
// from math import log2, ceil


// def bitwise_and_slow(start, end):
//     result = end
//     for num in range(start, end):
//         result &= num

//     return result


// def bitwise_and(start, end):
//     diff = end - start + 1
//     power_diff = ceil(log2(diff))
//     power_end = ceil(log2(end))

//     result = start & (2**power_end - 2**power_diff)
//     return result