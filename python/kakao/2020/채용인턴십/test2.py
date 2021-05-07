from itertools import permutations


def solution(expression):
    answer = 0
    return answer


expression = "100-200*300-500+20"

opers = ['*', '-', '+']

ex = []
num = ''

for idx, e in enumerate(expression):
    if idx == len(expression)-1:
        num += e
        ex.append(num)
        break

    if e in '*+-':
        ex.append(num)
        ex.append(e)
        num = ''
    else:
        num += e

print(ex)
