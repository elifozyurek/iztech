# Elif Özyürek 280201079

import numpy as np
from matplotlib import pyplot as plt
import random

# P(A)=(number of favorable outcomes)/(number of all possible outcomes) (COMBINATORICS)
# P(A)+P(A^c)=1 (here A^c means A's complement) (COMPLEMENTARY RULE)
""" (P1: The probability that at least one dice is 3.)
 "at least one dice is 3" is the complement of "no 3's". If we calculate the probability of no 3's occurring,
we can subtract that value from 1 and find theoretical P1.
 Each die has 6 sides and the probability of not getting a 3 is 5/6. Since we are rolling 5 dice, the probability of 
not getting any 3's becomes (5/6)**5. 
 P1(A^c)=(5/6)**5 ---> theoretical_p1=P1(A)=1-((5/6)**5)
"""
theoretical_p1 = 1 - ((5 / 6) ** 5)

""" (P2: The probability that at least one dice is 3 given one of the dice is even.)
 Since there is no possibility of getting a 3 from an even die, we can do the calculations using the remaining 4 dice.
(even die will not affect the calculations because the probability of not getting 3 will be 1 and 1 is ineffective in 
multiplication)
 We will use the complementary rule here as well.
 Each die has 6 sides and the probability of not getting a 3 is 5/6. Since we are rolling 4 dice, the probability of 
not getting any 3's becomes (5/6)**4. 
 P2(A^c)=(5/6)**4 ---> theoretical_p2=P2(A)=1-((5/6)**4)
"""
theoretical_p2 = 1 - ((5 / 6) ** 4)

""" (P3: The probability that at least one dice is 3 given only one of the dice is even.)
 If only one die is even, then the rest has to be odd. Since it is not possible to get 3 as an outcome from an even die,
we will use the remaining 4 dice to calculate the probability.
 We will calculate the probability of never getting three as an outcome and use the complementary rule.
 Given that all 4 dice are odd there are three possibilities: 1, 3, 5. The probability of not getting 3 as an outcome
becomes (2/3)**4. 
 P3(A^c)=(2/3)**4 ---> theoretical_p3=P3(A)=1-((2/3)**4)
"""
theoretical_p3 = 1 - ((2 / 3) ** 4)

print('Theoretical P1: {} \nTheoretical P2: {} \nTheoretical P3: {} \n'
      .format(theoretical_p1, theoretical_p2, theoretical_p3))

# empirical probability=(number of times an event occurred)/(total number of times the experiment is performed)

N = np.array([10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000, 500000, 1000000])  # total num. of exp. performed
p1_plot, p2_plot, p3_plot = [], [], []  # we need to keep the probabilities in a list in order to plot the graph.

for n in N:
    p1 = 0  # number of times 3 occurred will be stored in this variable
    for exp in range(n):  # simulation of an experiment being performed n times
        p1_list = []  # outcomes of an experiment will be stored in this list
        for dice in range(5):  # simulation of 5 dice rolls
            x = random.randint(1, 6)
            p1_list.append(x)  # outcomes are appended to the list
        if 3 in p1_list:  # if 3 is in the list, it means that 3 has occurred at least once
            p1 += 1  # so we increment p1
    empirical_p1 = p1 / n  # formula to calculate empirical possibility is used
    p1_plot.append(empirical_p1)  # we append the data to the related list
    print('Empirical P1 for {} experiments: {}'.format(n, empirical_p1))
print()

for n in N:
    p2 = 0  # number of times 3 occurred will be stored in this variable
    for exp in range(n):  # simulation of an experiment being performed n times
        p2_list = []  # outcomes of an experiment will be stored in this list
        for dice in range(4):  # simulation of 4 dice rolls (the reason for this is explained in line 18)
            y = random.randint(1, 6)
            p2_list.append(y)  # outcomes are appended to the list
        if 3 in p2_list:  # if 3 is in the list, it means that 3 has occurred at least once
            p2 += 1  # so we increment p2
    empirical_p2 = p2 / n  # formula to calculate empirical possibility is used
    p2_plot.append(empirical_p2)  # we append the data to the related list
    print('Empirical P2 for {} experiments: {}'.format(n, empirical_p2))
print()

for n in N:
    p3 = 0  # number of times 3 occurred will be stored in this variable
    odd_sides = [1, 3, 5]  # since all dice are odd there are three possibilities
    for exp in range(n):  # simulation of an experiment being performed n times
        p3_list = []  # outcomes of an experiment will be stored in this list
        for dice in range(4):  # simulation of 4 dice rolls (the reason for this is explained in line 30)
            z = random.choice(odd_sides)
            p3_list.append(z)  # outcomes are appended to the list
        if 3 in p3_list:  # if 3 is in the list, it means that 3 has occurred at least once
            p3 += 1  # so we increment p3
    empirical_p3 = p3 / n  # formula to calculate empirical possibility is used
    p3_plot.append(empirical_p3) # we append the data to the related list
    print('Empirical P3 for {} experiments: {}'.format(n, empirical_p3))
print()

print("Plotting graph...")

plt.axhline(y=theoretical_p1, color="red", linestyle="dashed")
plt.axhline(y=theoretical_p2, color="green", linestyle="dashed")
plt.axhline(y=theoretical_p3, color="blue", linestyle="dashed")

plt.plot(N, p1_plot, color="red", label=str(n))
plt.plot(N, p2_plot, color="green", label=str(n))
plt.plot(N, p3_plot, color="blue", label=str(n))

plt.text(N[-1], theoretical_p1+0.01, "P1, P'1", size="11")
plt.text(N[-1], theoretical_p2+0.01, "P2, P'2", size="11")
plt.text(N[-1], theoretical_p3+0.01, "P3, P'3", size="11")

plt.title("Graph of Empirical Probabilities", size="15")
plt.xlabel("Number of Experiments (N)", size="15")
plt.ylabel("Probabilities (P')", size="15")
plt.ylim(0, 1)
plt.xscale("log")
plt.show()
