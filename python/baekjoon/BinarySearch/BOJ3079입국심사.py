N, M = map(int, input().split())
arr = [0] * N
for i in range(N):
    arr[i] = int(input())

left = 0
right = max(arr) * M
arr.sort()

while left <= right:
    mid = (left + right) // 2
    cnt = 0

    for num in arr:
        add_cnt = mid // num
        cnt += add_cnt
        
    if cnt >= M:
        right = mid - 1
    else:
        left = mid + 1

print(left)