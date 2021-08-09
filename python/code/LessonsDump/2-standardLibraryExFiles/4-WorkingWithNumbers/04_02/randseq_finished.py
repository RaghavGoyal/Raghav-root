#!/usr/bin/env python3

# Functions for generating random data sequences
import random
import string

# Use the choice function to randomly select from a sequence
moves = ["rock", "paper", "scissors"]
print(random.choice(moves))

# Use the choices function to create a list of random elements
# k represents the number of choices made
# optional argument weight defines the chances of being selected
# smaller the weight is, rarer is the selection
roulette_wheel = ["black", "red", "green"]
weights = [18, 18, 2]
print(random.choices(roulette_wheel, weights, k=10))

# The sample function randomly selects elements from a population
# without repetition
chosen = random.sample(string.ascii_uppercase, 6)
print(chosen)

# The shuffle function shuffles a sequence in place
players = ["Bill", "Jane", "Joe", "Sally", "Mike", "Lindsay"]
random.shuffle(players)
print(players)

# to shuffle an immutable sequence, use the sample function first
result = random.sample(string.ascii_uppercase, k=len(string.ascii_uppercase))
random.shuffle(result)
print(''.join(result))
