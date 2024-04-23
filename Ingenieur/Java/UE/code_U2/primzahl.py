def is_prime():
    n = int(input("Wert n: "))
    
    """
    Optional, um Fehler durch Nutzer zu minimieren
    Zahlen =< 0 können nicht getestet werden.
    """
    if n <= 0:
        print("n darf nur positiv sein!")
        return False
    
    # 1 ist keine Primzahl    
    if n == 1:
        return False
    else:
        for a in range(2,n):
            #Wenn es ein a gibt, welches n teilt, dann ist n keine Primzahl
            if n % a == 0:
                return False

    return True
    

#Ab hier startet das Python Programm
res = is_prime()
if res == True:
    print ("n ist eine Primzahl")
else:
    print ("n ist keine Primzahl")


