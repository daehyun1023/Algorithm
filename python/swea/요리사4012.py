def comb(depth, mask, start):
    global minimum

    if depth == N//2:
        sum_food = 0
        for i in range(N):
            for j in range(N):
                if i in food and j in food:
                    sum_food += arr[i][j]
                if i not in food and j not in food:
                    sum_food -= arr[i][j]

        minimum = min(minimum, abs(sum_food))

        return

    for i in range(start, N):
        if (1 << i) & mask == 0:
            food[depth] = i
            comb(depth+1, mask | (1 << i), i)


T = int(input())
for t in range(1, T+1):
    N = int(input())
    arr = [list(map(int, input().split())) for i in range(N)]
    food = [0] * (N//2)
    minimum = 1e9
    comb(0, 0, 1)
    print("#{} {}".format(t, minimum))
