import numpy as np
import matplotlib.pyplot as plt
import sympy as sp


def auf07():
    t = sp.symbols('t')

    """
    f = sp.Piecewise((函数, 区间), ... , (0, True))
    sp.plot(f, (t, 左区间, 右区间), line_color='b', title='rect', xlabel='t', ylabel='f', show=True)
    
    """

    spy1 = -1 * (sp.Heaviside(t + 1) - sp.Heaviside(t))
    spy2 = sp.Heaviside(t) - sp.Heaviside(t - 1)
    f = sp.Piecewise((spy1, (-1 < t) & (t < 0)), (spy2, (0 < t) & (t < 1)), (0, True))
    sp.plot(f, (t, -2, 2), line_color='b', title='f', xlabel='t', ylabel='a', show=True)


def auf08():
    t, a, tao = sp.symbols('t, a, tao')

    y1 = (a / tao) * (t * sp.Heaviside(t))
    y2 = -2 * (a / tao) * ((t - tao) * sp.Heaviside(t - tao))
    y3 = 2 * (a / tao) * ((t - 3 * tao) * sp.Heaviside(t - 3 * tao))
    y4 = -(a / tao) * ((t - 4 * tao) * sp.Heaviside(t - 4 * tao))

    y = y1 + y2 + y3 + y4

    sp.plot(y.subs({a: 1, tao: 1}), (t, 0, 5), xlabel='t', ylabel='y(t)', title='Plot of y(t)')


def auf10():
    t = sp.Symbol('t')

    y0 = t * sp.Heaviside(t) - (t - 1) * sp.Heaviside(t - 1)
    time0 = np.linspace(0, 1, 100)
    ys0 = np.zeros(len(time0))
    for i in range(len(time0)):
        ys0[i] += y0.subs(t, time0[i])

    y1 = sp.Heaviside(t - 1)
    time1 = np.linspace(1.001, 2, 100)
    ys1 = np.zeros(len(time1))
    for i in range(len(time1)):
        ys1[i] += y1.subs(t, time1[i])

    y2 = (t - 2) * sp.Heaviside(t - 2)
    time2 = np.linspace(2, 3, 100)
    ys2 = np.zeros(len(time2))
    for i in range(len(time2)):
        ys2[i] += -1 * y2.subs(t, time2[i]) + 1

    x_values = np.arange(1, 5)
    plt.xticks(x_values, ['{}t'.format(abs(t)) if t != 0 else '0' for t in x_values])
    y_values = np.arange(0, 2)
    plt.yticks(y_values, ['{}v0'.format(abs(v0)) if v0 != 0 else '0' for v0 in y_values])

    plt.figure()
    plt.plot(time0, ys0, label='y0', color='black')
    plt.plot(time1, ys1, label='y1', color='blue')
    plt.plot(time2, ys2, label='y2', color='red')
    plt.xlabel('x')
    plt.ylabel('y')
    plt.title('Ramp Function')
    plt.legend()
    plt.show()

    """
    
    
    
    """

    spy1 = t * sp.Heaviside(t)
    spy2 = sp.Heaviside(t - 1)
    spy3 = -1 * (t - 2) * sp.Heaviside(t - 2) + 1
    f = sp.Piecewise((spy1, (t > 0) & (t < 1)), (spy2, (t > 1) & (t < 2)), ((spy3, (t > 2) & (t < 3))), (0, True))
    # sp.plot(f, (t, 0, 3), line_color='b', title='f', xlabel='t', ylabel='a', show=True)


# auf07()
# auf08()
auf10()
