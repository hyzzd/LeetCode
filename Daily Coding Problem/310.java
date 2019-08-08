// def get_set_bits(num):
//     if not num:
//         return 0

//     max_pow, max_pow_of_two = 0, 1
//     while max_pow_of_two - 1 <= num:
//         max_pow_of_two *= 2
//         max_pow += 1
//     max_pow_of_two //= 2
//     max_pow -= 1

//     remainder = num - (max_pow_of_two - 1)
//     set_bits = ((max_pow * max_pow_of_two) // 2)

//     set_bits = set_bits + get_set_bits(remainder)

//     return set_bits