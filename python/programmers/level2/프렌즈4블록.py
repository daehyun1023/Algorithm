dx = [0, 1, 0, 1]
dy = [0, 0, 1, 1]

def get_kill_blocks(m, n, board, block_list):
    for i in range(m-1):
        for j in range(n-1):
            for d in range(1,4):
                nx = i + dx[d]
                ny = j + dy[d]
                if board[nx][ny] != board[i][j] or board[i][j] == '':
                    break
            else:
                for d in range(4):
                    nx = i + dx[d]
                    ny = j + dy[d]
                    if [nx,ny] not in block_list:
                        block_list.append([nx,ny])

    return block_list

def fall_blocks(m, n, board):
    for j in range(n):
        ## 열마다 살아있는 block 저장
        alive_col_blocks = []
        for i in range(m):
            if board[i][j] != '':
                alive_col_blocks.append(board[i][j])
        ## 살아있는 block들 내리기
        for i in range(m-1, -1, -1):
            if alive_col_blocks:
                board[i][j] = alive_col_blocks.pop()
            else:
                board[i][j] = ''
    return board


def solution(m, n, board):
    ## board 리스트화
    board = [list(b) for b in board]
    ## 터지는 개수 (결과값)
    cnt = 0
    while True:
        ## 죽여야하는 block 얻기
        kill_blocks = get_kill_blocks(m ,n, board, [])
        ## 죽여야하는 block 개수 더하기
        cnt += len(kill_blocks)
        ## 죽여야할 block이 없다면 멈추기
        if kill_blocks:
            pass
            ## 죽이기
            for kill_block in kill_blocks:
                board[kill_block[0]][kill_block[1]] = ''
            ## 죽인 후 내리기
            board = fall_blocks(m, n, board)

        else:
            break

    return cnt

print(solution(m, n, board))

