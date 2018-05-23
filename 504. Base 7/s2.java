public String convertTo7(int num) {
    if (num < 0)
        return '-' + convertTo7(-num);
    if (num < 7)
        return num + "";
    return convertTo7(num / 7) + num % 7;
}
// Recursive
