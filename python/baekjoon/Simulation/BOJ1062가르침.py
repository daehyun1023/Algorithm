N, K = map(int,input().split())

result = 0
chars = ['a', 'n', 't', 'i', 'c']
plus_chars = []
input_strs = []
temp = chars.copy()

for i in range(N):
    input_str = input()
    input_strs.append(input_str)
    for input_char in input_str:
        if input_char not in chars and input_char not in plus_chars:
            plus_chars.append(input_char)

size = len(plus_chars)
check = [False] * size
K = K - 5

def getCnt(cnt, temp):
    for input_str in input_strs:
        for input_char in input_str:
            if input_char not in temp:
                cnt -= 1
                break
    return cnt

def comb(depth, x):
    global result
    
    if depth == K or (K > len(plus_chars) and depth == len(plus_chars)):
        temp = chars.copy()
        for i in range(size):
            if check[i] == True:
                temp.append(plus_chars[i])
        result = max(result, getCnt(N, temp))

        if depth == K:
            return

    for i in range(x, size):
        if check[i] == False:
            check[i] = True
            comb(depth+1, i)
            check[i] = False

if K < 0 :
    result = 0
else:
    comb(0,0)

print(result)
    
