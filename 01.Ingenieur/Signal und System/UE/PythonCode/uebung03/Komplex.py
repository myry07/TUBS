import numpy as np
import matplotlib.pyplot as plt
import sympy as sp


def exmKomp():
    # 定义复数
    z = 5 + 2j  # 5 + 2i
    k = -7 + 3j

    # 提取实部和虚部
    z_real_part = np.real(z)
    z_imag_part = np.imag(z)

    k_real_part = np.real(k)
    k_imag_part = np.imag(k)

    # 绘制复平面
    plt.figure()

    """

        绘制向量点和箭头

        def arrow(x: float, y: float, dx: float, dy: float, **kwargs) -> FancyArrow:
        return gca().arrow(x, y, dx, dy, **kwargs)


    """

    # plt.plot(real_part, imag_part, 'ro')  # 绘制复数点
    plt.arrow(0, 0, z_real_part, z_imag_part, head_width=0.2, head_length=0.3, fc='black', ec='red')
    plt.arrow(0, 0, k_real_part, k_imag_part, head_width=0.2, head_length=0.3, fc='black', ec='blue')

    """
    
    绘制数轴
    
    def axhline(y: float = 0, xmin: float = 0, xmax: float = 1, **kwargs) -> Line2D:
    return gca().axhline(y=y, xmin=xmin, xmax=xmax, **kwargs)
    
    """
    plt.axhline(y=0, color='k', xmin=-2, xmax=2)  # 绘制虚数轴
    plt.axvline(x=0, color='k', ymin=-3, ymax=3)  # 绘制实数轴
    plt.xlabel('Real')
    plt.ylabel('Imag')

    plt.title('Complex Plane')
    # plt.grid(True)#网络线
    plt.axis('equal')  # 使坐标轴比例相等
    plt.show()


exmKomp()
