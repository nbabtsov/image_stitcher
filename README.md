# image_stitcher (ISU CS311 - Design and Analysis of Algorithns, 2019)
A program which uses an image stitching algorithm that takes two input images, computes the best seam to join them, and produces a stitched image as the output.
The actual stitching logic is based on calculating seams and merging pixels along those seams.


The MatrixCuts class is designed to find optimal cuts in a matrix, which can be useful in various applications, including image processing and computer vision tasks where identifying important or least important parts of an image is necessary.

The code uses dynamic programming to find the minimum cost path (cut) from one side of the matrix to another. This is similar to algorithms used for finding the shortest path in graphs, where dynamic programming is often applied.

## Sample Run
select two images to stitch together (Image courtesy of cookie_studio on Freepik: <a href="https://www.freepik.com/free-photo/womans-twins-listening-music-headphones-smiling-blue_9029266.htm#query=same%20size&position=11&from_view=keyword&track=ais">image1</a>, <a href="https://www.freepik.com/free-photo/indoor-shot-young-severe-blonde-lady-keeping-hands-folded-while-standing-pink-background-with-cheerful-blue-eyed-pretty-blonde-woman-with-wavy-hairstyle_12586151.htm#query=same%20size&position=2&from_view=keyword&track=ais#position=2&query=same%20size">image2</a>): 

![blondegirl](https://github.com/nbabtsov/image_stitcher/assets/31867318/630f9079-24f5-4fb1-ad7e-8829ffdbda16)
![brunettegirl](https://github.com/nbabtsov/image_stitcher/assets/31867318/ceb80a21-f539-4e8d-8b8a-5314f2c07d20)

running ImageStitch will result in:


![Capture](https://github.com/nbabtsov/shortest_path_image_stitcher/assets/31867318/7c7e6fe5-da7f-46fe-a699-fc9165776e47)
![Capture2](https://github.com/nbabtsov/shortest_path_image_stitcher/assets/31867318/1b48ad4b-f6ee-4bd7-8e32-252d3aeb1238)


which get stiched together to form:

![blondethenbrunette](https://github.com/nbabtsov/image_stitcher/assets/31867318/c644b2ba-22e2-484d-8ba4-1ee7b7d25f9b)

Result from higher resolution images: 
![image](https://github.com/nbabtsov/shortest_path_image_stitcher/assets/31867318/b432ded1-513d-430c-b419-9ed4dea3dcd2)

