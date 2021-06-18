n = int(input())
arr = list(map(int,input().split(' ')))
m = int(input())

total = sum(arr)
if total <= m:
    print(max(arr))
else:
    start = 0
    end = max(arr)
    while start <= end:
        mid = (start + end) // 2
        
        large_num = 0
        for num in arr:
            if num > mid:
                large_num += (num - mid)

        if total - large_num > m:
            end = mid - 1
        else:
            start = mid + 1

    print(end)

