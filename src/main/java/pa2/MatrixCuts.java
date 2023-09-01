package pa2;

import java.util.*;

/**
 * @author Nika Babtsov, Jack Seiter
 */
public class MatrixCuts {

    static class HistoricTuple extends Tuple {
        int cost;
        HistoricTuple previous;

        public HistoricTuple(int x, int y, int cost, HistoricTuple previous) {
            super(x, y);
            this.cost = cost;
            this.previous = previous;
        }
    }

    public static ArrayList<Tuple> widthCut(int[][] M) {// 1.1
//        for (int i = 0; i < M.length; i++) {
//            System.out.println(Arrays.toString(M[i]));
//        }
//        System.out.println();
        HistoricTuple[][] cache = new HistoricTuple[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                cache[i][j] = new HistoricTuple(i, j, Integer.MAX_VALUE, null);
            }
        }
        for (int i = 0; i < M[0].length; i++) {
            cache[0][i].cost = M[0][i];
        }
        for (int i = 0; i < M.length - 1; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (cache[i + 1][j].cost > cache[i][j].cost + M[i + 1][j]) {
                    cache[i + 1][j].cost = cache[i][j].cost + M[i + 1][j];
                    cache[i + 1][j].previous = cache[i][j];
                }
                if (j != M[0].length - 1) {
                    if (cache[i + 1][j + 1].cost > cache[i][j].cost + M[i + 1][j + 1]) {
                        cache[i + 1][j + 1].cost = cache[i][j].cost + M[i + 1][j + 1];
                        cache[i + 1][j + 1].previous = cache[i][j];
                    }
                }
                if (j != 0) {
                    if (cache[i + 1][j - 1].cost > cache[i][j].cost + M[i + 1][j - 1]) {
                        cache[i + 1][j - 1].cost = cache[i][j].cost + M[i + 1][j - 1];
                        cache[i + 1][j - 1].previous = cache[i][j];
                    }
                }
            }
        }
        HistoricTuple best = cache[M.length - 1][0];
        for (int i = 1; i < M[0].length; i++) {
            if (cache[M.length - 1][i].cost <= best.cost) {
                best = cache[M.length - 1][i];
            }
        }
        ArrayList<Tuple> revHistory = new ArrayList<>(1000);
        HistoricTuple trail = best;
        while (trail != null) {
            revHistory.add(trail);
            trail = trail.previous;
        }
        revHistory.add(new Tuple(best.cost, -1));
        Collections.reverse(revHistory);
//        revHistory.forEach(System.out::println);
        return revHistory;
    }

    public static ArrayList<Tuple> stitchCut(int[][] M) {// 1.1
        HistoricTuple[][] cache = new HistoricTuple[M.length][M[0].length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                cache[i][j] = new HistoricTuple(i, j, Integer.MAX_VALUE, null);
            }
        }
        cache[0][0].cost = M[0][0];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (j != M[0].length - 1) {// todo double check tese bounds checks
                    if(cache[i][j + 1].cost > cache[i][j].cost + M[i][j + 1]) {
                        cache[i][j + 1].cost = cache[i][j].cost + M[i][j + 1];
                        cache[i][j + 1].previous = cache[i][j];
                    }
                }
                if (i != M.length - 1) {
                    if (cache[i + 1][j].cost > cache[i][j].cost + M[i + 1][j]) {
                        cache[i + 1][j].cost = cache[i][j].cost + M[i + 1][j];
                        cache[i + 1][j].previous = cache[i][j];
                    }
                    if (j != M[0].length - 1) {// todo double check these bounds checks
                        if (cache[i + 1][j + 1].cost > cache[i][j].cost + M[i + 1][j + 1]) {
                            cache[i + 1][j + 1].cost = cache[i][j].cost + M[i + 1][j + 1];
                            cache[i + 1][j + 1].previous = cache[i][j];
                        }
                    }
                }
            }
        }
        HistoricTuple best = cache[M.length - 1][0];
        for (int i = 1; i < M[0].length; i++) {
            if (cache[M.length - 1][i].cost <= best.cost) {
                best = cache[M.length - 1][i];
            }
        }
        ArrayList<Tuple> revHistory = new ArrayList<>(1000);
        HistoricTuple trail = best;
        while (trail != null) {
            revHistory.add(trail);
            trail = trail.previous;
        }
        revHistory.add(new Tuple(best.cost, -1));
        Collections.reverse(revHistory);
        return revHistory;
    }
}