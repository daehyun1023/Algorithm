def make_num(time):
    hour, minute, second = map(int, time.split(':'))
    return hour*3600 + minute*60 + second


def make_time(num):
    hour = str(num//3600)
    num %= 3600
    minute = str(num//60)
    num %= 60
    second = str(num)

    return hour.zfill(2)+':'+minute.zfill(2)+':'+second.zfill(2)


def solution(play_time, adv_time, logs):
    play_time = make_num(play_time)
    adv_time = make_num(adv_time)

    user_cnt = [0 for _ in range(play_time+1)]
    m = 0

    for log in logs:
        start, end = log.split('-')
        start = make_num(start)
        end = make_num(end)
        user_cnt[start] += 1
        user_cnt[end] -= 1

    for i in range(play_time):
        user_cnt[i+1] += user_cnt[i]

    for i in range(play_time):
        user_cnt[i+1] += user_cnt[i]

    for i in range(play_time-adv_time+1):
        if m < user_cnt[i+adv_time] - user_cnt[i]:
            m = user_cnt[i+adv_time] - user_cnt[i]
            result = i+1
            if i == 0:
                result = 0

    result = make_time(result)
    return result
