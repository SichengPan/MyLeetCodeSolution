class Solution(object):
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        numSet = set()
        return self.checkIsHappy(n, numSet)

    def checkIsHappy(self, n, numberSet):
        tempNum = sum(int(digit)**2 for digit in str(n))
        if tempNum == 1:
            return True
        elif tempNum in numberSet:
            return False
        else:
            numberSet.add(tempNum)
            return self.checkIsHappy(tempNum, numberSet)