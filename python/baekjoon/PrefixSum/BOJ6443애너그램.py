import sys
N = int(sys.stdin.readline())

def solve(input_chars, check, depth, output_str):
    global l
    global str_set
    
    if depth == l:
        output_str = ''.join(output_str)
        if output_str in str_set:
            return
        str_set.add(output_str)
        sys.stdout.write("".join(output_str)+"\n")

        return

    for i in range(l):
        if check[i] == False:
            check[i] = True
            output_str[depth] = input_chars[i]
            solve(input_chars, check, depth+1, output_str)
            check[i] = False

for _ in range(N):
    input_chars = sorted(list(sys.stdin.readline().strip()))
    input_chars = ''.join(input_chars)
    l = len(input_chars)
    print(input_chars)
    output_str = [''] * l
    str_set = set()
    check = [False] * l
    solve(input_chars, check, 0, output_str)