from scipy.integrate import odeint
from scipy.integrate import solve_ivp
import numpy as np
import matplotlib.pyplot as plt


def dydt(t, y):
    return 3 * y ** 2 - 5


def sol_ODE():
    y0 = 0
    t = np.linspace(0, 1, 100)
    sol_mod1 = odeint(dydt, y0, t, tfirst=True)
    sol_mod2 = solve_ivp(dydt, t_span=(0, max(t)), y0=[y0], t_eval=t)

    res1 = sol_mod1.T[0]
    print(res1)
    print()
    res2 = sol_mod2.y[0]
    print(res2)

    plt.figure()
    plt.subplot(211)
    plt.plot(t, res1, color='red')
    plt.xlabel("t")
    plt.ylabel("y(t)_ode")

    plt.subplot(212)
    plt.plot(t, res2, color='blue')
    plt.xlabel("t")
    plt.ylabel("y(t)_sol")
    plt.show()

def dSdx(x, S):
    x, y = S
    return [y,
            -y**2 + np.sin(x)]

def sol_2DE():
    x_0 = 0
    y_0 = 5
    S_0 = (x_0, y_0)
    t = np.linspace(0,1,100)
    sol = odeint(dSdx, y0=S_0, t=t, tfirst=True)

    x_sol = sol.T[0]
    print("x= ", x_sol)

    y_sol = sol.T[1]
    print("y= ", y_sol)

    plt.figure()
    plt.plot(t, x_sol, color='orange')
    plt.plot(t, y_sol, color='blue')
    plt.show()



# sol_ODE()
# sol_2DE()

def dZdt(t, Z):
    x1, y1, a1, x2, y2, a2 = Z
    return [y1,
            a1,
            -2*y2**2 + x2,
            y2,
            a2,
            -a1**3 + y2 + y1 + np.sin(t)]
x1_0 = 0
y1_0 = 0
a1_0 = 0
x2_0 = 0
y2_0 = 0
a2_0 = 0
y_0 = 0
Z_0 = (x1_0, y1_0, a1_0, x2_0, y2_0, a2_0)
t = np.linspace(0,1,100)
sol = odeint(dZdt, y0=Z_0, t=t, tfirst=True)
res = sol.T[0]
print(res)
plt.plot(t, sol.T[0], color='orange')
plt.show()


