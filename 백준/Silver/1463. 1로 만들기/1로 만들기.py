from sys import stdin
n = int(stdin.readline())

if n == 1 :
    print(0);
else:
    memory = [0] * (n + 1)
    memory[1] = 0
    memory[2] = 1

    for nn in range(3, n + 1):
        temp = [nn - 1]
        if nn % 2 == 0 : temp.append(nn // 2);
        if nn % 3 == 0 : temp.append(nn // 3);
        memory[nn] = min([memory[x] for x in temp])+1

    print(memory[n])