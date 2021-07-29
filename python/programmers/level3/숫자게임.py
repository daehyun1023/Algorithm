A = [5, 1, 3, 7]
B = [2, 2, 6, 8]

def solution(A,B):
    answer = 0
    A.sort()
    B.sort()

    for i in range(len(A)-1, -1, -1):
        if A[i] >= B[i]: # 젤 큰애들끼리 점수를 비교하고, 점수를 얻지 않는 경우가 생길경우 버리는 카드를 낸다.
            B.insert(i+1, B[0]) # 버리는 카드 내기
            B.pop(0)       

    for i in range(len(A)):
        if A[i] < B[i]:
            answer += 1
    return answer