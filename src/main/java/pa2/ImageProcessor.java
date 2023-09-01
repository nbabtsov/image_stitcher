package pa2;

import java.util.List;

public class ImageProcessor {
    public static int[][] importance(Picture a) {
        int[][] M = new int[a.height()][a.width()];
        for (int i = 0; i < M.length; i++) {
            M[i][0] = ImageStitch.pixelDistance(a.get(0, i), a.get(1, i));
            for (int j = 1; j < M[0].length - 1; j++) {
                M[i][j] = ImageStitch.pixelDistance(a.get(j - 1, i), a.get(j + 1, i));
            }
            M[i][M[0].length - 1] = ImageStitch.pixelDistance(a.get(M[0].length - 2, i), a.get(M[0].length - 1, i));
        }
        return M;
    }

    public static Picture reduceWidth(int x, String inputImage) {
        try {
            Picture img = new Picture(inputImage);
            Picture newImg;
            int[][] M;
            while (x-- > 0) {
                M = importance(img);
                List<Tuple> cuts = MatrixCuts.widthCut(M);
                cuts.remove(0);
                int[] k = new int[cuts.size()];
                for (Tuple tuple : cuts) {
                    k[tuple.getX()] = tuple.getY();
                }
                newImg = new Picture(img.width() - 1, img.height());
                for (int i = 0; i < M.length; i++) {
                    for (int j = 0; j < M[0].length - 1; j++) {
                        if (j < k[i]) {
                            newImg.set(j, i, img.get(j, i));
                        } else {
                            newImg.set(j, i, img.get(j + 1, i));
                        }
                    }
                }
                img = newImg;
            }
            return img;
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }
}