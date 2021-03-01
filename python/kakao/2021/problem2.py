from itertools import combinations


def solution(orders, course):
    comb_dict = {}
    result = []
    max_comb = []

    for i in course:
        m = 0
        for order in orders:
            if len(order) < i:
                continue
            comb_orders = combinations(order, i)
            for comb_order in comb_orders:
                comb_order = sorted(list(comb_order))
                comb_string = ''.join(comb_order)
                comb_dict[comb_string] = comb_dict.get(comb_string, 0) + 1
                m = max(m, comb_dict[comb_string])
        max_comb.append(m)

    for key, value in comb_dict.items():
        for i in range(len(course)):
            if len(key) == course[i] and value == max_comb[i]:
                result.append(key)

    result.sort()
    return result
