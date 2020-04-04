# Polynomial Transform
Adjustable transformation of a 2D coordinate grid. The program takes a grid of points in a space with coordinates (_x_, _y_) and transforms the points to a new set of points (_x'_, _y'_) where both _x'_ and _y'_ are general polynomials of degree 3 in both _x_ and _y_. The coefficients of these polynomials are presented as adjustable knobs, which can be adjusted and the corresponding effect on the transformed grid observed.

![Example](/images/example.png)

## Interaction
The 2 grids of knobs (which can be clicked and dragged to change their values) each represent the 16 coefficients of _x'_ and _y'_ respectively. The knobs are weighted so that higher powers, which tend to change faster, will have less of an effect on the shape of the grid. Pressing the '0' number key will reset all coefficients to zero. Pressing the 's' key will save an image of the grid to the local folder.

## Running the code
The program uses the Processing API and requires the ControlP5 library to be installed (https://github.com/sojamo/controlp5).