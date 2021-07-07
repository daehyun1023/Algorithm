N, M = map(int, input().split())
arr = list(map(int, input().split()))
sum = 0
mod = [0] * 1001
mod[0] = 1
cnt = 0

for num in arr:
    sum += num
    mod[sum%M] += 1

for num in mod:
    if num > 1:
        cnt += (num * (num-1)) // 2

print(cnt)