def func(p, x):
    return p**2 - x
def grad(p, x):
    return (p**2 + x) / 2 / p

# Used Newton's optimization method
# Take the gradient on func at x_i and draw a line that passes that point,
# we can get a line: y = 2x_i*x - (x_i^2 + c), where c is the square of the target.
# Then, the next point that is closer to the optimal point, x_{i+1}, should be the intersection point betw line y and the x-axis.
class Solution(object):
    def mySqrt(self, x):
        p = 0.1
        while (abs(func(p, x)) > 0.001):
            p = grad(p,x)
        return int(p)
    
        