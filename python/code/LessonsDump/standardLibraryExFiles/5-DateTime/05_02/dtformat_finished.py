#!/usr/bin/env python3

# Formatting date and time information
import datetime

# create a datetime for today
now = datetime.datetime.now()

# print various day and month formatting
# Formatting days:
# a -> Abbreviated day of the week
# A -> Full day of the week
# w -> number representing the day of week; starting Monday as 1
# e -> represents the day from the date
print(now.strftime("%a, %A, %w, %e"))

# Month Formatting:
# b -> abbreviated month name
# B -> Full month name
# m -> number representing month, starting January as 1
print(now.strftime("%b, %B, %m"))

# Time formatting:
# H -> represents hour in 24-hour format
# I -> represents hour in 12-hour format
# M -> Represents the minutes
# p -> indicates AM or PM
print(now.strftime("%H, %I, %M, %S, %p"))

# Locale-specific
print(now.strftime("%c"))
print(now.strftime("%X"))

# short date format (m/d/y)
output = now.strftime("%m/%d/%y")
print("today is: ", output)

# long date format (Day, number, Month, Year)
output = now.strftime("%A %d, %B %Y")
print("today is: ", output)

# short date and time (m/d/y, H:M am/pm)
output = now.strftime("%m/%d/%y %I:%M %p")
print("today is: ", output)
