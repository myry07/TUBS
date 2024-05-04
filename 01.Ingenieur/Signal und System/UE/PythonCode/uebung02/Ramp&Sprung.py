import numpy as np
import matplotlib.pyplot as plt
import sympy as sp


def f01():
    x = np.arange(-2, 2, 0.001)

    y = []
    for t in x:
        if -2 <= t < -1:
            y.append(0)
        elif -1 <= t < 0:
            y.append(-1)
        elif 0 <= t < 1:
            y.append(1)
        else:
            y.append(0)

    plt.plot(x, y, label='x', color='blue')
    plt.xlabel('x')
    plt.ylabel('y')
    plt.legend()
    plt.show()


def f02():
    x = np.arange(0, 4, 0.001)

    y = []
    for t in x:
        if 1 < t <= 3:
            y.append(-t + 2)
        elif 3 < t:
            y.append(t - 4)
        else:
            y.append(t)

    plt.plot(x, y, label='x', color="blue")  # 绘制 x1 对应的部分
    plt.xlabel('tao')
    plt.ylabel('y')
    plt.legend()
    plt.show()


def examStep():
    t = sp.symbols('t')  # 创建符号
    y = sp.Heaviside(t)  # 阶跃函数

    time = np.linspace(-1, 3, 100)  # 时间生成[0, 8] 100个等间隔的数子
    ys = np.zeros(len(time))  # 创建全0数组，长度为len(time) = 100

    # 赋值
    for i in range(len(time)):  # 遍历0-100
        ys[i] += y.subs(t, time[i])

    plt.plot(time, ys, label='Step Function', color='blue')
    plt.xlabel('x')
    plt.ylabel('y')
    plt.title('Step Function')
    plt.legend()
    plt.show()


def examRamp():
    t = sp.symbols('t')  # 创建符号
    y = t * sp.Heaviside(t)  # 阶跃函数

    time = np.linspace(-1, 3, 100)  # 时间生成[0, 8] 100个等间隔的数子
    ys = np.zeros(len(time))  # 创建全0数组，长度为len(time) = 100

    # 赋值
    for i in range(len(time)):  # 遍历0-100
        ys[i] += y.subs(t, time[i])

    plt.plot(time, ys, label='Step Function', color='blue')
    plt.xlabel('x')
    plt.ylabel('y')
    plt.title('Ramp Function')
    plt.legend()
    plt.show()

def examSprung():
    t = sp.Symbol('t')

    y0 = t * sp.Heaviside(t)
    time0 = np.linspace(0, 1, 100)
    ys0 = np.zeros(len(time0))
    for i in range(len(time0)):
        ys0[i] += y0.subs(t, time0[i])

    y1 = sp.Heaviside(t - 1)
    time1 = np.linspace(1.001, 1.999, 100)
    ys1 = np.zeros(len(time1))
    for i in range(len(time1)):
        ys1[i] += y1.subs(t, time1[i])

    y2 = -1 * (t - 2) * sp.Heaviside(t - 2) + 1
    time2 = np.linspace(2, 3, 100)
    ys2 = np.zeros(len(time2))
    for i in range(len(time2)):
        ys2[i] += y2.subs(t, time2[i])

    x_values = np.arange(1, 5)
    plt.xticks(x_values, ['{}T/3'.format(abs(t)) if t != 0 else '0' for t in x_values])
    y_values = np.arange(0, 2)
    plt.yticks(y_values, ['{}a'.format(abs(v0)) if v0 != 0 else '0' for v0 in y_values])

    plt.figure()
    plt.plot(time0, ys0, label='y0', color='black')
    plt.plot(time1, ys1, label='y1', color='blue')
    plt.plot(time2, ys2, label='y2', color='red')
    plt.xlabel('x')
    plt.ylabel('y')
    plt.title('Ramp Function')
    plt.legend()
    plt.show()


def examSprung2():
    t, a, T = sp.symbols('t, a, T')

    y1 = (3 * a / T) * (t * sp.Heaviside(t))
    y2 = -(3 * a / T) * ((t - T / 3) * sp.Heaviside(t - T / 3))
    y3 = -(3 * a / T) * ((t - 2 * T / 3) * sp.Heaviside(t - 2 * T / 3))
    y4 = (3 * a / T) * ((t - 3 * T / 3) * sp.Heaviside(t - 3 * T / 3))

    y = y1 + y2 + y3 + y4
    print(y)

    # 绘制 y(t) 在 a=1, T=3 的情况下的图像
    sp.plot(y.subs({a: 1, T: 3}), (t, 0, 4), xlabel='t', ylabel='y(t)', title='Plot of y(t)')


def pc():
    t = sp.symbols('t')
    y1 = t * sp.Heaviside(t)
    y2 = -1 * (t - 1) * sp.Heaviside(t - 1) + 1

    f = sp.Piecewise((y1, (t >= 0) & (t < 1)), (y2, (t >= 1) & (t < 3)), (0, True))
    sp.plot(f, (t, -0.5, 2.5), line_color='b', title='rect', xlabel='t', ylabel='rect(t)', show=True)


examSprung2()
