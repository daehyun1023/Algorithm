N, M = list(map(int,input().split(' ')))
nums = [0] * N

def comb(depth, total):
    global nums

    if depth == N:
        if total == 0:
            print(*nums)
        return True

    for i in range(1,7):
        nums[depth] = i
        if total - i < 0 or (N-depth) * 6 < total:
            break
        comb(depth+1, total-i)    

comb(0, M)
