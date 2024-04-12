n = int(input("Wert n: "))

# Array [2, 3, 4, ..., n] initialisieren
num = [1]*(n-1)
for i in range(n-1):
    num[i] = i+2

#Array, um zu schauen, welche Zahlen bereits gestrichen sind
gestrichen = [False]*(n)

for x in num:
    if not gestrichen[x-1]:
        print(x)
        
        factor = n//x #Maximale Anzahl an Vielfachen von x innerhalb von 1 bis n
        for i in range(2,factor+1):
            gestrichen[i*x-1] = True #Streiche Vielfache
