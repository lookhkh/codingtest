def solution(n):
    dy = [0,1,0,-1]
    dx = [1,0,-1,0]
    y,x = 0, -1
    
    arr = [[0] * n for _ in range(n)]
    cnt = 1
    
    dir = 0
    
    while cnt <= n**2:
        ny, nx = y+dy[dir], x+dx[dir]
        if 0<=ny < n and 0<=nx < n and not arr[ny][nx]:
            arr[ny][nx] = cnt
            cnt += 1
            y, x = ny, nx
        else:
            dir = (dir+1) % 4
    
    return arr