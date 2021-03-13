a = input().split()
N = int(a[0])
M = int(a[1])
trees = list(map(int, input().split()))
low = 0
high = max(trees)
while True:
    mid = (low+high)//2
    if low > high:
        print(mid)
        break

    length = 0
    for tree in trees:
        if tree > mid:
            length += tree-mid

    if length < M:
        high = mid-1
    else:
        low = mid+1
