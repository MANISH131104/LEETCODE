import java.util.*;

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

        // start, end, weight, original index
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {

            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by ending point
        Arrays.sort(arr, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        // Find previous non-overlapping interval
        int[] prev = new int[n];

        for (int i = 0; i < n; i++) {
            prev[i] = findPrevious(arr, i);
        }

        /*
         * dp[k][i]
         *
         * k = maximum number of intervals we can select
         * i = first i intervals
         */
        State[][] dp = new State[5][n + 1];

        /*
         * IMPORTANT:
         *
         * If we are allowed to choose 0 intervals,
         * answer is always score 0 and empty list.
         *
         * Therefore initialize ALL dp[0][i].
         */
        for (int i = 0; i <= n; i++) {

            dp[0][i] = new State(
                    0,
                    new ArrayList<>()
            );
        }

        /*
         * If we have 0 intervals available,
         * answer is also 0.
         */
        for (int k = 0; k <= 4; k++) {

            dp[k][0] = new State(
                    0,
                    new ArrayList<>()
            );
        }

        /*
         * Build DP
         */
        for (int k = 1; k <= 4; k++) {

            for (int i = 1; i <= n; i++) {

                int current = i - 1;

                /*
                 * -------------------------
                 * OPTION 1: DON'T TAKE
                 * -------------------------
                 */

                State skip = dp[k][i - 1];

                /*
                 * -------------------------
                 * OPTION 2: TAKE
                 * -------------------------
                 */

                int weight = arr[current][2];

                int originalIndex = arr[current][3];

                /*
                 * prev[current] is the index of
                 * the previous non-overlapping interval.
                 *
                 * If prev = -1:
                 *
                 * there are 0 previous intervals.
                 *
                 * Therefore:
                 *
                 * previousCount = prev + 1
                 */
                int previousCount = prev[current] + 1;

                State previous = dp[k - 1][previousCount];

                /*
                 * Make a COPY.
                 *
                 * Don't modify previous.indices directly.
                 */
                List<Integer> takeIndices =
                        new ArrayList<>(previous.indices);

                takeIndices.add(originalIndex);

                /*
                 * Result must be in increasing
                 * order of original indices.
                 */
                Collections.sort(takeIndices);

                State take = new State(
                        previous.score + weight,
                        takeIndices
                );

                /*
                 * Choose better result.
                 */
                dp[k][i] = better(take, skip);
            }
        }

        /*
         * We can choose AT MOST 4 intervals.
         */
        State answer = dp[4][n];

        int[] result = new int[answer.indices.size()];

        for (int i = 0; i < answer.indices.size(); i++) {

            result[i] = answer.indices.get(i);
        }

        return result;
    }


    /*
     * Find the last interval before current
     * whose ending point is STRICTLY LESS
     * than current starting point.
     *
     * Example:
     *
     * [1,5]
     * [5,9]
     *
     * These overlap.
     *
     * Therefore:
     *
     * previousEnd < currentStart
     */
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


    /*
     * Compare two states.
     *
     * First:
     *     maximum score
     *
     * If scores are equal:
     *     lexicographically smaller indices
     */
    private State better(State a, State b) {

        if (a.score > b.score) {
            return a;
        }

        if (a.score < b.score) {
            return b;
        }

        /*
         * Same score
         */
        if (isLexicographicallySmaller(
                a.indices,
                b.indices)) {

            return a;
        }

        return b;
    }


    /*
     * Check whether a is lexicographically
     * smaller than b.
     */
    private boolean isLexicographicallySmaller(
            List<Integer> a,
            List<Integer> b) {

        int size = Math.min(a.size(), b.size());

        for (int i = 0; i < size; i++) {

            if (!a.get(i).equals(b.get(i))) {

                return a.get(i) < b.get(i);
            }
        }

        /*
         * If one is prefix of the other,
         * shorter list is smaller.
         */
        return a.size() < b.size();
    }
}