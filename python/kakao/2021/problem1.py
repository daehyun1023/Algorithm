def solution(new_id):
    new_id1 = new_id.lower()

    new_id2 = ''
    for char in new_id1:
        if char not in '~!@#$%^&*()=+[{]}:?,<>/':
            new_id2 += char

    new_id3 = ''
    for char in new_id2:
        if len(new_id3) > 0 and new_id3[-1] == '.' and char == '.':
            continue
        new_id3 += char

    new_id4 = new_id3.strip('.')

    if new_id4 == '':
        new_id4 = 'a'

    if len(new_id4) >= 16:
        new_id4 = new_id4[:15]

    new_id4.strip('.')

    if len(new_id4) <= 2:
        add_char = new_id4[-1]
        while len(new_id4) < 3:
            new_id4 += add_char
    return new_id4
