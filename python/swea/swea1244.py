def btr(depth):
    global max_num
    num = int(''.join(nums))

    if num in num_set:
        return
    else:
        num_set.add(num)

    if depth == n:
        num = int()
        if max_num < max(num_set):
            max_num = max(num_set)
        return

    for i in range(size):
        for j in range(i+1, size):
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
            btr(depth+1)
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp


T = int(input())
for i in range(1, T+1):
    nums, n = input().split()
    n = int(n)
    nums = list(nums)
    max_num = 0
    size = len(nums)
    num_set = set()
    btr(0)
    print(f'#{i} {max_num}')
