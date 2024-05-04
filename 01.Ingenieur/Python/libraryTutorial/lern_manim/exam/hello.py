from manim import *

class hello(Scene):
    def construct(self):
        str = Tex("hello world")
        self.play(Write(str))
        self.wait(3)