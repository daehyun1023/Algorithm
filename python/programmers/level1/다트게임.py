def solution(dartResult):
    ## 각 라운드의 저장하는 리스트
    num_list = [0]
    ## 현재 몇라운드인지 알려주는 index
    now_idx = 0
    for i in range(len(dartResult)):
        ## 점수인 경우
        if dartResult[i] in '0123456789':
            ## 처음 숫자가 나오게 되면 다음 round가 되는 것이므로 1씩 추가, 10이 나온 경우에도 round 1추가
            now_idx += 1
            ## 현재 값이 1인 경우 10인지 1인지 판단
            if dartResult[i] == '1':
                if dartResult[i+1] == '0':
                    num_list.append(10)
                else:
                    num_list.append(1)

            ## 현재 값이 0인 경우 10인지 0인지 판단
            elif dartResult[i] == '0':
                if dartResult[i-1] == '1':
                    ## 10인경우 중복으로 계산이 되기 때문에 round -1 해줌
                    now_idx -= 1
                    continue
                else:
                    num_list.append(0)
            ## 1~9 점수 처리
            else:
                num_list.append(int(dartResult[i]))

        ## 보너스인 경우
        elif dartResult[i] in 'SDT':
            if dartResult[i] == 'D':
                num_list[now_idx] = num_list[now_idx] ** 2
            elif dartResult[i] == 'T':
                num_list[now_idx] = num_list[now_idx] ** 3

        ## 옵션인 경우
        elif dartResult[i] in '*#':
            ## *의 경우
            if dartResult[i]=='*':
                num_list[now_idx] = num_list[now_idx] * 2
                num_list[now_idx-1] = num_list[now_idx-1] * 2
            elif dartResult[i] == '#':
                num_list[now_idx] = num_list[now_idx] * -1
                            
    return sum(num_list)