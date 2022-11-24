# Elif Özyürek 280201079
# my code runs for a very long time

import numpy as np
from matplotlib import pyplot as plt

X = [0.3, 0.6, 0.8, 0.9]

# PART A


def method_of_moments(sample_set):
    return np.mean(sample_set) / 2


def max_likelihood_est(sample_set):
    return np.min(sample_set)


print('MoM estimation of theta is: {}'.format(method_of_moments(X)))
print('MLE estimation of theta is: {}'.format(max_likelihood_est(X)))


# PART B


def inv_cdf(u):
    return 2.4 / np.sqrt(1-u)


P = []  # population array
U = []

for k in range(10000000):
    Ui = np.random.rand()  # sample from uniform distribution
    U.append(Ui)
    Xi = inv_cdf(Ui)  # plug in the value to the inverse CDF
    P.append(Xi)


# PART C

N = [1, 2, 3, 4, 5, 10, 50, 100, 500, 1000]


def simulation(population, sample_size_list):
    mom_list = []
    mle_list = []
    for j in range(100000):
        sample = []
        for sz in sample_size_list:
            random_ind = np.random.randint(len(population), size=sz)
            for i in random_ind:
                sample.append(P[i])
        mom_list.append(method_of_moments(sample))
        mle_list.append(max_likelihood_est(sample))
    plt.hist(mom_list, 100, alpha=0.5, density=True, color="blue")
    plt.hist(mle_list, 100, alpha=0.5, density=True, color="orange")
    plt.show()
    means = [np.mean(mom_list), np.mean(mle_list)]
    std = [np.std(mom_list), np.std(mle_list)]
    return means, std


x = simulation(P, N)
print()
print("First array contains the means of MoM and MLE estimations, respectively")
print("Second array contains the standard deviations of MoM and MLE estimations, respectively")
print(x)
