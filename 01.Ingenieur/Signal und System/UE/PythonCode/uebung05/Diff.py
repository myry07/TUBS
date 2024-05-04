import sympy as sp
import scipy as sc


def diffExam():
    """

    用python求解微分方程

    1. 定义变量和函数

    2. 写出微分方程
       x^2对t求二阶导 + omega^2x = 0

       y(x).diff(x, 2) 对x求二介导


    """


x, omega = sp.symbols('x, omega')
y = sp.Function('y')

f = y(x).diff(x, 2) + omega ** 2 * y(x)

res = sp.dsolve(f,y(x))
print(res) #C1*exp(-I*omega*x) + C2*exp(I*omega*x) 这是解析解