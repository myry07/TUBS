import numpy as np
import matplotlib.pyplot as plt
import sympy as sp
from sympy import fourier_series, pi
from sympy import cos, sin, exp, I

def auf01():
    k = 100  # 保留多少项
    T = sp.pi  # 周期

    t = sp.symbols('t')
    y1 = sp.Heaviside(t)
    x = sp.Piecewise((0, t < 0), (y1, t > 0))
    s = sp.fourier_series(x, (t, -T, T))

    print(s.truncate(k))
    sp.plot(s.truncate(k), (t, -2*T, 2*T))  # 注意这里的区间应该是 (-T, T)

    s_exp = s.rewrite(sp.exp)
    print(s_exp.truncate(k))


auf01()
