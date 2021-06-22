N, M, L = map(int, input().split())
arr = list(map(int, input().split()))
arr.append(0)
arr.append(L)
arr.sort()

start = 0
end = L

while start <= end:
    mid = (start + end) // 2
    cnt = 0
    for i in range(len(arr)-1):
        first = arr[i]
        second = arr[i+1]
        diff = second - first - mid
        if diff <= 0:
            continue
        else:
            cnt += 1
            cnt += diff//mid
            if diff % mid == 0:
                cnt -= 1

    if cnt > M:
        start = mid + 1
    elif cnt <= M:
        end = mid - 1

print(start)

