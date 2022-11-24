# Elif Özyürek 280201079

import math
import numpy as np
from matplotlib import pyplot as plt


def prob_density_func(sum_list):  # function to calculate the density of each random variable
    density_list = []
    std = np.std(sum_list)
    mean = np.mean(sum_list)
    for x in sum_list:
        density = (1 / (std*(math.sqrt(2*math.pi)))) * math.exp(-((x-mean)**2) / (2*(std**2)))
        density_list.append(density)
    return density_list  # list that holds the densities


num_of_sums = 200000

"""
  according to the Central Limit Theorem; if we add up large number of values from almost any distribution, the dist. of
the sum converges to Normal. N(mean, variance)
  Variance = (Standard Deviation)**2
"""

# EXPERIMENT 1
sum_list_1 = []
for num in range(num_of_sums):
    sample_sum = 0
    for i in range(2):
        sample_sum += np.random.uniform()
    sum_list_1.append(sample_sum)

print('Theoretical mean for EXPERIMENT 1--> {}'.format(np.mean(sum_list_1)))
print('Theoretical variance for EXPERIMENT 1--> {}'.format(np.std(sum_list_1)**2))
print()

# we sort the list because the values need to be ordered for a decent Normal curve to be plotted
sum_list_1.sort()
plt.title("Experiment 1")
plt.hist(sum_list_1, bins=100, density=True)
plt.plot(sum_list_1, prob_density_func(sum_list_1))
plt.show()


# EXPERIMENT 2
sum_list_2 = []
for num in range(num_of_sums):
    sample_sum = 0
    for i in range(4):
        sample_sum += np.random.uniform()
    sum_list_2.append(sample_sum)

print('Theoretical mean for EXPERIMENT 2--> {}'.format(np.mean(sum_list_2)))
print('Theoretical variance for EXPERIMENT 2--> {}'.format(np.std(sum_list_2)**2))
print()

sum_list_2.sort()
plt.title("Experiment 2")
plt.hist(sum_list_2, bins=100, density=True)
plt.plot(sum_list_2, prob_density_func(sum_list_2))
plt.show()


# EXPERIMENT 3
sum_list_3 = []
for num in range(num_of_sums):
    sample_sum = 0
    for i in range(50):
        sample_sum += np.random.uniform()
    sum_list_3.append(sample_sum)

print('Theoretical mean for EXPERIMENT 3--> {}'.format(np.mean(sum_list_3)))
print('Theoretical variance for EXPERIMENT 3--> {}'.format(np.std(sum_list_3)**2))
print()

sum_list_3.sort()
plt.title("Experiment 3")
plt.hist(sum_list_3, bins=100, density=True)
plt.plot(sum_list_3, prob_density_func(sum_list_3))
plt.show()


# EXPERIMENT 4
sum_list_4 = []
for num in range(num_of_sums):
    sample_sum = 0
    value = np.random.uniform()
    for i in range(50):
        if value < 99:
            value = np.random.uniform(0, 200)
            sample_sum += value
        else:
            value = np.random.uniform(98, 102)
            sample_sum += value
    sum_list_4.append(sample_sum)

print('Theoretical mean for EXPERIMENT 4--> {}'.format(np.mean(sum_list_4)))
print('Theoretical variance for EXPERIMENT 4--> {}'.format(np.std(sum_list_4)**2))
print()

sum_list_4.sort()
plt.title("Experiment 4")
plt.hist(sum_list_4, bins=100, density=True)
plt.plot(sum_list_4, prob_density_func(sum_list_4))
plt.show()


# EXPERIMENT 5
sum_list_5 = []
for num in range(num_of_sums):
    sample_sum = 0
    for i in range(50):
        a, b = np.random.uniform(), np.random.uniform()
        sample_sum += np.random.uniform(a, b)
    sum_list_5.append(sample_sum)


print('Theoretical mean for EXPERIMENT 5--> {}'.format(np.mean(sum_list_5)))
print('Theoretical variance for EXPERIMENT 5--> {}'.format(np.std(sum_list_5)**2))
print()

sum_list_5.sort()
plt.title("Experiment 5")
plt.hist(sum_list_5, bins=100, density=True)
plt.plot(sum_list_5, prob_density_func(sum_list_5))
plt.show()

