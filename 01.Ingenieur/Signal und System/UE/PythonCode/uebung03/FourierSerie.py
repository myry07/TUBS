import numpy as np
import matplotlib.pyplot as plt
import sympy as sp
from sympy import fourier_series, pi
from sympy import cos, sin, exp, I

"""

https://docs.sympy.org/latest/modules/series/fourier.html

"""


def examSerie01():
    k = 4 #保留多少项
    T = sp.pi #周期

    t = sp.Symbol('t')
    x = sp.Piecewise((-1, t < 0), (1, t > 0))
    s = sp.fourier_series(x, (t, -T, T))

    print(s.truncate(k))#4*sin(t)/pi
    sp.plot(s.truncate(k), (t, -2*T, 2*T))

    s_exp = s.rewrite(sp.exp)
    print(s_exp.truncate(k))


examSerie01()