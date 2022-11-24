import numpy as np
from matplotlib import pyplot as plt

# Part a (Inverse Transform Method)
U = []
Xa = []
av_Xa = []
vr_Xa = []
plot_list = []  # extra list to store numbers from 1 to 50000 (to plot the avg. and var.)

# Populate the given arrays.
for k in range(50000):
    Ui = np.random.rand()  # sample from uniform distribution
    U.append(Ui)
    Xi = np.sqrt(Ui)  # plug in the value to the inverse CDF
    Xa.append(Xi)
    av_Xa.append(np.mean(Xa))
    vr_Xa.append((np.std(Xa))**2)
    plot_list.append(k)

# Inspect the following plots.
plt.figure()
for i in range(len(Xa)):
    plt.plot([Xa[i], U[i]], [1, 1.2])
plt.figure()
hU = plt.hist(U, 100, alpha=0.5, density=True)
hXa = plt.hist(Xa, 100, alpha=0.5, density=True)
plt.figure()
plt.plot(np.cumsum(hU[0]))
plt.plot(np.cumsum(hXa[0]))

# Plot the average and variance values.
plt.figure()
plt.title("Averages: A (figure 4)")
plt.plot(plot_list, av_Xa, color="orange")
plt.figure()
plt.title("Variances: A (figure 5)")
plt.plot(plot_list, vr_Xa, color="blue")


# Part b (Rejection Method)
Xb = []
av_Xb = []
vr_Xb = []
plot_list_b = []
# Populate the given arrays.


def f(n):  # PDF function (derivative of CDF)
    if 0 <= n <= 1:
        fn = 2*n
    else:
        fn = 0
    return fn


c = 2  # max value of CDF
a = -1  # a number that is less than the lower bound (0)
b = 2  # a number that is greater than the upper bound (1)

for j in range(50000):  # we try to bound the function with a rectangle
    u, v = np.random.rand(), np.random.rand()
    x = (b-a)*u + a
    y = c*v
    if y <= f(x):  # accepted points are found (the ones under the curve of f(x)
        Xb.append(x)
    av_Xb.append(np.mean(Xb))
    vr_Xb.append((np.std(Xb))**2)
    plot_list_b.append(j)

# Inspect the following plots.
plt.figure()
hXb = plt.hist(Xb, 100, density=True)
plt.figure()
plt.plot(np.cumsum(hXb[0]))

# Plot the average and variance values.
plt.figure()
plt.title("Averages: B (figure 8)")
plt.plot(plot_list_b, av_Xb, color="orange")
plt.figure()
plt.title("Variances: B (figure 9)")
plt.plot(plot_list_b, vr_Xb, color="blue")
