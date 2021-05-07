from bisect import bisect
from bisect import bisect_right
from bisect import bisect_left


nums = [i for i in range(0, 12, 2)]
n = 5

a = bisect_left(nums, n)
print(a)
