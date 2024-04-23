import math as mt
import sympy as sp
from manim import *

"""

FirstExample 继承了 Scene, Scene 是 manim的一个类
含有含参构造器 参数self

出现在屏幕上的
blue_circle = Circle(color=BLUE, fill_opacity=0.5)
blue_square = Square(color=GREEN, fill_opacity=0.8)
fill_opacity 不透明度

Circle Square是Manim对象

绿方块放在篮球旁边 
green_square.next_to(blue_circle, RIGHT)
中间是蓝球 右边是绿色方块


添加对象到屏幕
self.add

"""


class FirstExample(Scene):
    def construct(self):
        blue_circle = Circle(color=BLUE, fill_opacity=0.5)
        green_square = Square(color=GREEN, fill_opacity=0.8)
        green_square.next_to(blue_circle, RIGHT)
        self.add(blue_circle, green_square)


"""

绘制函数

1.
数轴 Manim对象 Axes
x轴x_range y轴y_range


2.
函数 使用Axes的plot方法
lamda 映射 lambda x: (x+2)*(x*-2)/2

Axes的get_area 可以获取函数的区域

"""


class SecondExample(Scene):
    def construct(self):
        ax = Axes(x_range=(-3, 3), y_range=(-3, 3))
        func = lambda x: x ** 2
        curve = ax.plot(func, color=RED)
        area = ax.get_area(curve, x_range=(-2, 0))
        self.add(ax, curve, area)


"""

绘制动画
self.add -> self.play

Creat 创建动画 
FadeIn 淡入动画
Transform 一个对象转为另一个对象
ReplacementTransform 转换完并取代之
Indicate 将对象放大一下并变成黄色
Circumscribe 
Uncreate 
FadeOut 缄默破坏
添加生物对象的动画

"""


class ThirdExample(Scene):
    def construct(self):
        ax = Axes(x_range=(-3, 3), y_range=(-3, 3))
        func = lambda x: x ** 2
        curve = ax.plot(func, color=RED)
        area = ax.get_area(curve, x_range=(-2, 0))
        self.play(Create(ax, run_time=1.5))  # run_time运行速度满一点
        self.wait(1)
        self.play(Create(curve, run_time=3), FadeIn(area, run_time=3))
        self.wait(2)


class SquareToCircle(Scene):
    def construct(self):
        green_square = Square(color=GREEN, fill_opacity=0.5)
        self.play(DrawBorderThenFill(green_square))  # DrawBorderThenFill先画边界再填充

        blue_circle = Circle(color=BLUE, fill_opacity=0.5)
        self.play(Transform(green_square, blue_circle))  # 绿方 -> 篮球
        self.play(Indicate(green_square))
        self.play(FadeOut(green_square))  # FadeOut缄默破坏
        self.wait(2)


class cos_(Scene):
    def construct(self):
        ax = Axes(x_range=(-3, 3), y_range=(-3, 3))
        func = lambda x: mt.cos(x)
        curve = ax.plot(func, color=RED)
        area = ax.get_area(curve, x_range=(-2, 0))
        self.play(Create(ax, run_time=1.5))  # run_time运行速度满一点
        self.wait(1)
        self.play(Create(curve, run_time=3), FadeIn(area, run_time=3))
        self.wait(2)


class Sprung(Scene):
    def construct(self):
        # 数轴
        ax = Axes(x_range=(-1, 6), y_range=(-2, 2))
        self.play(Create(ax, run_time=1.5))  # run_time运行速度满一点
        self.wait(1)

        # 函数
        func0 = lambda t: t * sp.Heaviside(t)
        func1 = lambda t: -(t - 1) * sp.Heaviside(t - 1)
        func2 = lambda t: -(t - 2) * sp.Heaviside(t - 2)
        func3 = lambda t: (t - 4) * sp.Heaviside(t - 4)
        func4 = lambda t: (t - 5) * sp.Heaviside(t - 5)
        func5 = lambda t: func0(t) + func1(t) + func2(t) + func3(t) + func4(t)

        curve0 = ax.plot(lambda t: func0(t), color=RED)
        self.play(Create(curve0, run_time=2))
        self.wait(1)

        curve1 = ax.plot(lambda t: func1(t), color=PINK)
        self.play(Create(curve1, run_time=2))
        self.wait(1)

        curve2 = ax.plot(lambda t: func2(t), color=YELLOW)
        self.play(Create(curve2, run_time=2))
        self.wait(1)

        curve3 = ax.plot(lambda t: func3(t), color=GREEN)
        self.play(Create(curve3, run_time=2))
        self.wait(1)

        curve4 = ax.plot(lambda t: func4(t), color=DARK_BROWN)
        self.play(Create(curve4, run_time=2))
        self.wait(1)

        curve5 = ax.plot(lambda t: func5(t), color=BLUE)
        self.play(Create(curve5, run_time=2))
        self.remove(curve0, curve1, curve2, curve3, curve4)
        self.wait(1)


class Step(Scene):
    def construct(self):
        # 数轴
        ax = Axes(x_range=(-1, 6), y_range=(-2, 2))
        self.play(Create(ax, run_time=1.5))  # run_time运行速度满一点
        self.wait(1)

        func = lambda t: sp.Heaviside(t - 2) - sp.Heaviside(t - 4)
        curve = ax.plot(lambda t: func(t), color=BLUE)
        self.play(Create(curve, run_time=2))
        self.wait(1)