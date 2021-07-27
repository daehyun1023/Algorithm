nums = [1, 2, 3, 4]
from itertools import combinations

def is_prime(number):
    sqrt_number = int(number ** (0.5))
    for i in range(2, sqrt_number+1):
        if number % i == 0:
            return False
    return True

def solution(nums):
    answer = 0
    numbers = list(map(sum,list(combinations(nums, 3))))
    for number in numbers:
        if is_prime(number):
            answer += 1
    return answer

print(solution(nums))