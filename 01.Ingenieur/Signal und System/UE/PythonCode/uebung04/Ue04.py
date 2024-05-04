import sympy as sp

def auf015():
    t, s, tao = sp.symbols('t, s, tao')
    alpha, beta = sp.symbols('alpha, beta')
    a = sp.symbols('a', real=True, positive=True)

    f1 = a * sp.Heaviside(t - tao)
    print('f1时域 ')
    print(f1)

    F1 = sp.laplace_transform(f1, t, s, noconds=True)
    print('F1频域 ')
    print(F1)

    # sp.plot(f1.subs({a: 2, tao: 1}), (t, -1, 4), xlabel='t', ylabel='f1(t)', title='Plot of f1(t)')

    f2 = t * sp.Heaviside(t)
    print('f2时域 ')
    print(f2)

    F2 = sp.laplace_transform(f2, t, s, noconds=True)
    print('F2频域 ')
    print(F2)

    # sp.plot(f2.subs({a: 2, tao: 1}), (t, -1, 4), xlabel='t', ylabel='f2(t)', title='Plot of f2(t)')

    f3 = (sp.exp(alpha * t)) * sp.cos(beta * t) * sp.Heaviside(t)
    print('f3时域 ')
    print(f3)

    F3 = sp.laplace_transform(f3, t, s, noconds=True)
    print('F3频域 ')
    print(F3)

    sp.plot(f3.subs({a: 2, tao: 1, alpha: 1, beta: 1}), (t, -1, 4), xlabel='t', ylabel='f3(t)', title='Plot of f3(t)')


def auf17():
    t, a, tao, s= sp.symbols('t, a, tao, s')

    sp.init_printing()

    y1 = (a / tao) * (t * sp.Heaviside(t))
    y2 = -(a / tao) * ((t - tao) * sp.Heaviside(t - tao))
    y3 = -a * (sp.Heaviside(t - 2 * tao))

    y = y1 + y2 + y3
    print("y时域")
    print(y)

    Y = sp.laplace_transform(y, t, s, noconds=True)
    print('Y频域')
    print(Y)

    sp.plot(y.subs({a: 1, tao: 1}), (t, 0, 4), xlabel='t', ylabel='y(t)', title='Plot of f(t)')

    u1 = -(a / tao) * ((t) * sp.Heaviside(t)) + a
    u2 = (a / tao) * ((t - 2 * tao) * sp.Heaviside(t - 2 * tao))
    u3 = a * (sp.Heaviside(t - 2 * tao))

    u = u1 + u2 + u3
    print("u时域")
    print(u)

    U = sp.laplace_transform(u, t, s, noconds=True)
    print('U频域')
    print(U)

    # sp.plot(u.subs({a: 1, tao: 1}), (t, 0, 4), xlabel='t', ylabel='y(t)', title='Plot of u(t)')

    i = a * ((sp.Heaviside(t)) + sp.Heaviside(t - tao) + sp.Heaviside(t - 2 * tao) + sp.Heaviside(t - 3 * tao))
    print('i时域')
    print(i)

    I = sp.laplace_transform(i, t, s, noconds=True)
    print('I频域')
    print(I)
    # sp.plot(i.subs({a: 1, tao: 1}), (t, 0, 4), xlabel='t', ylabel='y(t)', title='Plot of i(t)')


# auf015()
auf17()
