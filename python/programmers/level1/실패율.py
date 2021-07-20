N = 5
stages = [2, 1, 2, 6, 2, 4, 3, 3]
# result = [3,4,2,1,5]
# N = 4
# stages = [4,4,4,4,4]


def solution(N, stages):
    answer = []
    l = []
    for i in range(1, N+1):
        total_cnt = 0
        clear_cnt = 0
        prob = 0
        for stage in stages:
            if stage >= i:
                total_cnt += 1
                if stage > i:
                    clear_cnt += 1
        
        if total_cnt == 0:
            prob = 0
        else:
            prob = (total_cnt - clear_cnt) / total_cnt
        l.append([prob, i])

    l.sort(key=lambda x: (-x[0], x[1]))

    for value in l:
        answer.append(value[1])

    return answer

print(solution(N, stages))