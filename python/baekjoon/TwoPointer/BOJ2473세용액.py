import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int,input().split()))
arr.sort()

tmp = sys.maxsize
idx = [0] * 3

for i in range(n-2):
    left = i + 1
    right = n - 1

    while left < right:
        s = arr[i] + arr[left] + arr[right]

        if abs(s) < abs(tmp):
            idx[0] = arr[i]
            idx[1] = arr[left]
            idx[2] = arr[right]
            tmp = s

        if s < 0:
            left += 1
        elif s > 0:
            right -= 1
        else:
            print(arr[i], arr[left], arr[right])
            sys.exit(0)
print(*idx)



