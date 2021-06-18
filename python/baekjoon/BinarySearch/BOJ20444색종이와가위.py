n, k = map(int,input().split())

start = 0
end = n
result = 0
answer = 'NO'

while start <= end:
    mid = (start+end) // 2
    result = (mid+1) * (n-mid+1)
    if result == k:
        answer = 'YES'
        break
    else:
        if start == end:
            break

        if result > k:
            end = mid - 1
        else:
            start = mid + 1

print(answer)

