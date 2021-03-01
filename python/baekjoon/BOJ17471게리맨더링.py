from sys import stdin
N = int(stdin.readline())
population = list(map(int, stdin.readline().split()))
arr = []
total = 0
result = 1e10
check = [0] * N

for i in range(N):
    info = list(map(int, stdin.readline().split()))
    info = list(map(lambda x: x-1, info))
    arr.append(info[1:])

total = sum(population)


def dfs(x, mask, area):
    global check
    for i in arr[x]:
        if area == 1 and check[i] == 0 and mask & 1 << i != 0:
            check[i] = area
            dfs(i, mask, area)
        elif area == 2 and check[i] == 0 and (mask & 1 << i) == 0:
            check[i] = area
            dfs(i, mask, area)


def comb(depth, mask, start, area_1):
    global check
    global result

    if depth >= 1 and depth <= N//2:
        check = [0] * N

        for i in range(N):
            if mask & 1 << i:
                check[i] = 1
                dfs(i, mask, 1)
                break

        for i in range(N):
            if mask & 1 << i == 0:
                check[i] = 2
                dfs(i, mask, 2)
                break

        if 0 not in check:
            result = min(result, abs(total-area_1*2))

    for i in range(start, N):
        if (mask & 1 << i) != 0:
            continue
        comb(depth+1, mask | 1 << i, i, area_1+population[i])


comb(0, 0, 0, 0)
print(-1 if result == 1e10 else result)
