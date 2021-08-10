"""
    in this challenge given the lists below:
        year = [2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019]
        births = [723165, 723913, 729674, 698512, 695233, 697852, 696271, 679106, 657076, 640370]

    the task is to create a zip that has following structure:
        (year, birth, running_average)
"""

def main():
    def getRunningAvg(list):
        retList = []
        sum = 0

        for index, element in enumerate(list, start=1):
            sum += element
            retList.append(sum/index)

        return retList

    year = [2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019]
    births = [723_165, 723_913, 729_674, 698_512, 695_233, 697_852, 696_271, 679_106, 657_076, 640_370]

    runningAvg = getRunningAvg(births)

    zipped = zip(year, births, runningAvg)
    for elem in zipped:
        print(elem)


if __name__ == '__main__':
    main()