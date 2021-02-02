def dfs(count):
    global answer
    # 횟수를 다 사용했다면
    if not count:
        # 숫자로 바꿔보고
        temp = int(''.join(values))
        # 가지고 있는 최대수보다 크다면 갱신
        if answer < temp:
            answer = temp
        return
    # 바꿔야 하니까 이중 포문
    for i in range(length):
        # 경우의 수를 찾는거니까 i보다 큰위치부터
        for j in range(i+1, length):
            # 두개의 위치를 바꾸고 나서
            values[i], values[j] = values[j], values[i]
            # 가지치기 해야하니까 일단 합쳐보고
            temp_key = ''.join(values)
            # 어떤수가 몇회차에 나왔는지 체크 1이면 안나온거니까 경우의수에 넣어주기
            if visited.get((temp_key, count-1), 1):
                # 이숫자는 몇회차에 사용했으니까 체크해주고
                visited[(temp_key, count-1)] = 0
                # dfs도 돌려주고
                dfs(count-1)
            # 다 썻으면 원상복귀
            values[i], values[j] = values[j], values[i]


for t in range(int(input())):
    answer = -1
    value, change = input().split()
    # 바꾸기 편하려고 리스트화시킴
    values = list(value)
    change = int(change)
    # 계속 쓸꺼니까 캐스팅
    length = len(values)
    # 가지치기용 딕셔너리
    visited = {}
    dfs(change)
    # print('#{} {}'.format(t+1, answer))
    for key in visited:
        print(key)
