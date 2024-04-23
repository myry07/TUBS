import sympy as sp

def integral():
    t = sp.symbols('t')
    f = sp.Heaviside(t)
    # 计算定积分，例如从0到1的积分
    f_res = sp.integrate(f, (t, 0, 2))
    print(f_res)

    sp.plot(f, xlim=(-1, 4), ylim=(0, 3))

integral()  # 调用函数




