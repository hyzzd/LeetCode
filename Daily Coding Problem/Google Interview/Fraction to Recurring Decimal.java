import java.util.HashMap;

class Main {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        sb.append((numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-");
        long num = Math.abs(Long.valueOf(numberator));
        long den = Math.abs(Long.valueOf(denominator));
        sb.append(String.valueOf(num / den));
        num %= den;
        if (num == 0) {
            return sb.toString();
        }

        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        while (num != 0) {
            if (map.containsKey(num)) {
                sb.insert(map.get(num), "(");
                sb.append(")");
                break;
            }
            map.put(num, sb.length());
            num *= 10;
            sb.append(String.valueOf(num / den));
            num %= den;
        }
        return sb.toString();
    }
}