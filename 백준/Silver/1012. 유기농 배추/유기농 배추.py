from collections import deque

xway = [-1, 1, 0, 0]
yway = [0, 0, -1, 1]


def solution(board=[[]]):
    history = [[False for _ in range(w)] for _ in range(h)]
    ans = 0
    for x in range(len(board)):
        for y in range(len(board[x])):
            if history[x][y] is True: continue
            if board[x][y] != 1: continue
            bfs(x, y, board, history)
            ans += 1
    print(ans)


def bfs(x, y, board, history):
    que = deque()
    que.append([x, y])
    while len(que) > 0:
        next = que.pop();
        curX = next[0]
        curY = next[1]
        if history[curX][curY] is True: continue
        history[curX][curY] = True

        for idx in range(0,4):
            nextX = curX + xway[idx]
            nextY = curY + yway[idx]
            if 0 <= nextX < len(board) and 0 <= nextY < len(board[0]):
                if board[nextX][nextY] == 1:
                    que.append([nextX, nextY])

case = int(input())

for t in range(case):
    w, h, case = map(int, input().split(" "))
    board = [[0 for _ in range(w)] for _ in range(h)]
    for i in range(0, case):
        wp, hp = map(int, input().split(" "))
        board[hp][wp] = 1

    solution(board)
