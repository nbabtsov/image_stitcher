# image_stitcher
A program which uses an image stitching algorithm that takes two input images, computes the best seam to join them, and produces a stitched image as the output.
The actual stitching logic is based on calculating seams and merging pixels along those seams.


The MatrixCuts class is designed to find optimal cuts in a matrix, which can be useful in various applications, including image processing and computer vision tasks where identifying important or least important parts of an image is necessary.

The code uses dynamic programming to find the minimum cost path (cut) from one side of the matrix to another. This is similar to algorithms used for finding the shortest path in graphs, where dynamic programming is often applied.
