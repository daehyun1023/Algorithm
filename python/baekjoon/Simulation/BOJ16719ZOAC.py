chars = list(input())
S = []

def solve(start, end, offset):
    global S

    if start > end:
        return

    idx = start
    for i in range(start, end+1):
        if chars[idx] > chars[i]:
            idx = i
    S.insert(offset,chars[idx])
    print(''.join(S), offset)
    solve(idx+1, end, offset+1)
    solve(start, idx-1, offset)

solve(0, len(chars)-1, 0)

