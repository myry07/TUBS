import sympy as sp
from pandas import DataFrame
import jinja2


def examLap():
    t, s = sp.symbols('t, s')
    a = sp.symbols('a', real=True, positive=True)

    # 先从函数 e^-at开始
    f = sp.exp(-a * t) * sp.Heaviside(t)

    """
    
    正变换
    
    可以直接积分
    sp.integrate(f*sp.exp(-s*t), (t, 0, sp.oo))
    
    也可以用库函数
    F2 = sp.laplace_transform(f, t, s, noconds=True)
    
    """

    F1 = sp.integrate(f * sp.exp(-s * t), (t, 0, sp.oo))
    print(F1)

    F2 = sp.laplace_transform(f, t, s, noconds=True)
    print(F2)

    """
    
    逆变换
    
    fi = sp.inverse_laplace_transform(F2, s, t)
    
    """

    fi = sp.inverse_laplace_transform(F2, s, t)
    print(fi)

    # a = 1
    sp.plot(f.subs({a: 2}), xlim=(-1, 4), ylim=(0, 3))

    # sp.plot(F2.subs({a: 2}), xlim=(-1, 4), ylim=(0,3))


def examLapTab():
    a, t, s = sp.symbols('a , t, s')
    omega = sp.Symbol('omega', real=True)
    exp = sp.exp
    sin = sp.sin
    cos = sp.cos

    """
    定义多个函数
    """

    functions = [1,
                 t,
                 exp(-a * t),
                 t * exp(-a * t),
                 t ** 2 * exp(-a * t),
                 sin(omega * t),
                 cos(omega * t),
                 1 - exp(-a * t),
                 exp(-a * t) * sin(omega * t),
                 exp(-a * t) * cos(omega * t),
                 ]

    print(functions)

    """
    进行变换
    """

    Fs = [sp.laplace_transform(f, t, s, noconds=True) for f in functions]
    print(Fs)

    """
    在 pandas 的帮助下，我们可以对表格做出很好的近似
    """

    #  创建 DataFrame
    df = DataFrame(list(zip(makelatex(functions), makelatex(Fs))))

    # 保存 DataFrame 为 LaTeX 文件
    df.to_latex('laplace_table.tex', index=False, header=False, column_format='ll')


def makelatex(args):
    return ["$${}$$".format(sp.latex(a)) for a in args]


# examLap()
examLapTab()
