import sympy as sp

def auf18():
    t, s = sp.symbols('t, s')

    X = (s**2) / ((s+1)**3)

    x = sp.inverse_laplace_transform(X, s, t)
    print(x)


auf18()