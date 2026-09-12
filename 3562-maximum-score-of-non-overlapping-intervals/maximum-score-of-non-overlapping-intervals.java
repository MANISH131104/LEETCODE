class Solution {
    class State {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

public int[] maximumWeight(List<List<Integer>> intervals) {
    int n = intervals.size();
    int[][] arr = new int[n][4];

    for (int i = 0; i < n; i++) {
        arr[i][0] = intervals.get(i).get(0);
        arr[i][1] = intervals.get(i).get(1);
        arr[i][2] = intervals.get(i).get(2);
        arr[i][3] = i;
        }

        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = findPrevious(arr, i);
        }
        State[][] dp = new State[5][n + 1];

        
        for (int i = 0; i <= n; i++) {

            dp[0][i] = new State(
                    0,
                    new ArrayList<>()
            );
        }

        for (int k = 0; k <= 4; k++) {
            dp[k][0] = new State(
                    0,
                    new ArrayList<>()
            );
        }

        for (int k = 1; k <= 4; k++) {
            for (int i = 1; i <= n; i++) {
                int current = i - 1;
                State skip = dp[k][i - 1];

                int weight = arr[current][2];
                int originalIndex = arr[current][3];
                int previousCount = prev[current] + 1;
                State previous = dp[k - 1][previousCount];

                List<Integer> takeIndices =
                    new ArrayList<>(previous.indices);

                takeIndices.add(originalIndex);
                Collections.sort(takeIndices);

                State take = new State(
                    previous.score + weight,
                    takeIndices
                );
                dp[k][i] = better(take, skip);
            }
        }
        State answer = dp[4][n];

        int[] result = new int[answer.indices.size()];
        for (int i = 0; i < answer.indices.size(); i++) {
            result[i] = answer.indices.get(i);
        }
        return result;
    }
    private int findPrevious(int[][] arr, int current) {
        int low = 0;
        int high = current - 1;
        int start = arr[current][0];
        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid][1] < start) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }
    private State better(State a, State b) {

        if (a.score > b.score) {
            return a;
        }
        if (a.score < b.score) {
            return b;
        }
        if (isLexicographicallySmaller(
            a.indices,
            b.indices)) {
            return a;
        }
        return b;
    }
    private boolean isLexicographicallySmaller(
        List<Integer> a,
        List<Integer> b) {

        int size = Math.min(a.size(), b.size());
        for (int i = 0; i < size; i++) {
            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }
        return a.size() < b.size();
    }
}