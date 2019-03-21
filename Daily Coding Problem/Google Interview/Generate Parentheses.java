class Main {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        dfs(res, n, n, "");
        return res;
    }

    private dfs(List<String> res, int left, int right, String build){
        if (left == 0 && right == 0) {
            res.add(build);
            return;
        }
        if(left > 0){
            dfs(res, left - 1, right, build + "(");
        }
        if(right > 0){
            dfs(res, left, right-1, build + ")");
        }
    }
}